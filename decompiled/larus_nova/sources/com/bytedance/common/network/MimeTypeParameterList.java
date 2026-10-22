package com.bytedance.common.network;

import com.alipay.sdk.m.n.a;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes15.dex */
public class MimeTypeParameterList {
    private Hashtable parameters;

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.ensureCapacity(this.parameters.size() * 16);
        Enumeration r101 = this.parameters.keys();
    L4:
        if (r101.hasMoreElements() == false) goto L7;
        String r102 = (String) r101.nextElement();
        r100.append("; ");
        r100.append(r102);
        r100.append(a.f25612h);
        r100.append(quote((String) this.parameters.get(r102)));
        goto L4
    L7:
        return r100.toString();
    }

    public MimeTypeParameterList() {
        this.parameters = new Hashtable();
    }

    public MimeTypeParameterList(String r100) throws MimeTypeParseException {
        this.parameters = new Hashtable();
        parse(r100);
    }

    private static boolean isTokenChar(char r100) {
        if (r100 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r100 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r100) >= 0) goto L9;
        return true;
    }

    private static String quote(String r100) {
        int r101 = r100.length();
        int r102 = 0;
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r101) goto L6;
        if (r104 == true) goto L6;
        r104 = !isTokenChar(r100.charAt(r103));
        r103 = r103 + 1;
    L6:
        if (r104 == false) goto L21;
        StringBuffer r105 = new StringBuffer();
        r105.ensureCapacity((int) (((double) r101) * 1.5d));
        r105.append(Typography.quote);
    L8:
        if (r102 >= r101) goto L14;
        char r106 = r100.charAt(r102);
        if (r106 == '\\') goto L12;
        if (r106 == '\"') goto L12;
    L13:
        r105.append(r106);
        r102 = r102 + 1;
    L12:
        r105.append('\\');
        goto L13
    L14:
        r105.append(Typography.quote);
        return r105.toString();
    L21:
        return r100;
    }

    private static String unquote(String r100) {
        int r101 = r100.length();
        StringBuffer r102 = new StringBuffer();
        r102.ensureCapacity(r101);
        int r103 = 0;
        boolean r104 = false;
    L3:
        if (r103 >= r101) goto L14;
        char r105 = r100.charAt(r103);
        if (r104 == false) goto L7;
    L9:
        if (r104 == false) goto L11;
        r102.append(r105);
        r104 = false;
    L12:
        r103 = r103 + 1;
        goto L3
    L11:
        r104 = true;
        goto L12
    L7:
        if (r105 == '\\') goto L9;
        r102.append(r105);
        goto L12
    L14:
        return r102.toString();
    }

    public String get(String r100) {
        return (String) this.parameters.get(r100.trim().toLowerCase(Locale.ENGLISH));
    }

    public void parse(String r100) throws MimeTypeParseException {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length();
        if (r101 > 0) goto L7;
        return;
    L7:
        int r102 = skipWhiteSpace(r100, 0);
    L8:
        if (r102 >= r101) goto L59;
        if (r100.charAt(r102) != ';') goto L59;
        int r103 = skipWhiteSpace(r100, r102 + 1);
        if (r103 >= r101) goto L13;
        int r104 = r103;
    L15:
        if (r104 >= r101) goto L19;
        if (isTokenChar(r100.charAt(r104)) == false) goto L19;
        r104 = r104 + 1;
    L19:
        String r105 = r100.substring(r103, r104).toLowerCase(Locale.ENGLISH);
        int r106 = skipWhiteSpace(r100, r104);
        if (r106 >= r101) goto L58;
        if (r100.charAt(r106) != '=') goto L58;
        int r107 = skipWhiteSpace(r100, r106 + 1);
        if (r107 >= r101) goto L56;
        char r108 = r100.charAt(r107);
        if (r108 != '\"') goto L45;
        int r109 = r107 + 1;
        if (r109 >= r101) goto L43;
        int r110 = r109;
    L30:
        if (r110 >= r101) goto L38;
        r108 = r100.charAt(r110);
        if (r108 == '\"') goto L38;
        if (r108 != '\\') goto L37;
        r110 = r110 + 1;
    L37:
        r110 = r110 + 1;
    L38:
        if (r108 != '\"') goto L41;
        String r111 = unquote(r100.substring(r109, r110));
        int r112 = r110 + 1;
    L52:
        this.parameters.put(r105, r111);
        r102 = skipWhiteSpace(r100, r112);
        goto L8
    L41:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L43:
        throw new MimeTypeParseException("Encountered unterminated quoted parameter value.");
    L45:
        if (isTokenChar(r108) == false) goto L54;
        r112 = r107;
    L47:
        if (r112 >= r101) goto L51;
        if (isTokenChar(r100.charAt(r112)) == false) goto L51;
        r112 = r112 + 1;
    L51:
        r111 = r100.substring(r107, r112);
        goto L52
    L54:
        throw new MimeTypeParseException("Unexpected character encountered at index " + r107);
    L56:
        throw new MimeTypeParseException("Couldn't find a value for parameter named " + r105);
    L58:
        throw new MimeTypeParseException("Couldn't find the '=' that separates a parameter name from its value.");
    L13:
        return;
    L59:
        if (r102 < r101) goto L62;
        return;
    L62:
        throw new MimeTypeParseException("More characters encountered in input than expected.");
    }

    public void remove(String r100) {
        this.parameters.remove(r100.trim().toLowerCase(Locale.ENGLISH));
    }

    private static int skipWhiteSpace(String r100, int r101) {
        int r102 = r100.length();
    L3:
        if (r101 >= r102) goto L7;
        if (Character.isWhitespace(r100.charAt(r101)) == false) goto L7;
        r101 = r101 + 1;
    L7:
        return r101;
    }

    public void set(String r100, String r101) {
        this.parameters.put(r100.trim().toLowerCase(Locale.ENGLISH), r101);
    }
}

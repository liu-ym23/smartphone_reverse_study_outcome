package com.bytedance.frameworks.baselib.network.http.parser;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;
import px5.b;

/* JADX INFO: loaded from: classes3.dex */
public class MimeType implements Externalizable {
    private b parameters;
    private String primaryType;
    private String subType;

    public String getBaseType() {
        return this.primaryType + HTTP.URL_DEFAULT + this.subType;
    }

    public String toString() {
        return getBaseType() + this.parameters.toString();
    }

    public MimeType() {
        this.primaryType = "application";
        this.subType = "*";
        this.parameters = new b();
    }

    public b getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public MimeType(String r100) throws MimeTypeParseException {
        b(r100);
    }

    public static boolean a(String r100) {
        int r101 = r100.length();
        if (r101 <= 0) goto L19;
        int r102 = 0;
    L5:
        boolean r103 = true;
        if (r102 >= r101) goto L18;
        char r104 = r100.charAt(r102);
        if (r104 > ' ') goto L10;
    L14:
        r103 = false;
    L15:
        if (r103 == false) goto L16;
        r102 = r102 + 1;
        goto L5
    L16:
        return false;
    L10:
        if (r104 >= 127) goto L14;
        if ("()<>@,;:/[]?=\\\"".indexOf(r104) >= 0) goto L14;
    L18:
        return true;
    L19:
        return false;
    }

    public final void b(String r100) throws MimeTypeParseException {
        int r101 = r100.indexOf(47);
        int r102 = r100.indexOf(59);
        if (r101 >= 0) goto L8;
        if (r102 >= 0) goto L8;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L8:
        if (r101 >= 0) goto L14;
        if (r102 < 0) goto L14;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L14:
        if (r101 < 0) goto L17;
        if (r102 >= 0) goto L17;
        String r103 = r100.substring(0, r101).trim();
        Locale r104 = Locale.ENGLISH;
        this.primaryType = r103.toLowerCase(r104);
        this.subType = r100.substring(r101 + 1).trim().toLowerCase(r104);
        this.parameters = new b();
    L20:
        if (a(this.primaryType) == false) goto L27;
        if (a(this.subType) == false) goto L25;
        return;
    L25:
        throw new MimeTypeParseException("Sub type is invalid.");
    L27:
        throw new MimeTypeParseException("Primary type is invalid.");
    L17:
        if (r101 >= r102) goto L29;
        String r105 = r100.substring(0, r101).trim();
        Locale r106 = Locale.ENGLISH;
        this.primaryType = r105.toLowerCase(r106);
        this.subType = r100.substring(r101 + 1, r102).trim().toLowerCase(r106);
        this.parameters = new b(r100.substring(r102));
        goto L20
    L29:
        throw new MimeTypeParseException("Unable to find a sub type.");
    }

    public String getParameter(String r100) {
        return (String) this.parameters.f530933a.get(r100.trim().toLowerCase(Locale.ENGLISH));
    }

    public boolean match(MimeType r100) {
        if (this.primaryType.equals(r100.getPrimaryType()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.subType.equals("*") == false) goto L7;
    L10:
        return true;
    L7:
        if (r100.getSubType().equals("*") == true) goto L10;
        if (this.subType.equals(r100.getSubType()) == false) goto L11;
        goto L10
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException, ClassNotFoundException {
        b(r100.readUTF());     // Catch: MimeTypeParseException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public void removeParameter(String r100) {
        this.parameters.f530933a.remove(r100.trim().toLowerCase(Locale.ENGLISH));
    }

    public void setPrimaryType(String r100) throws MimeTypeParseException {
        if (a(this.primaryType) == false) goto L7;
        this.primaryType = r100.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    public void setSubType(String r100) throws MimeTypeParseException {
        if (a(this.subType) == false) goto L7;
        this.subType = r100.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Sub type is invalid.");
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        r100.writeUTF(toString());
        r100.flush();
    }

    public boolean match(String r100) throws MimeTypeParseException {
        return match(new MimeType(r100));
    }

    public MimeType(String r100, String r101) throws MimeTypeParseException {
        if (a(r100) == false) goto L11;
        Locale r102 = Locale.ENGLISH;
        this.primaryType = r100.toLowerCase(r102);
        if (a(r101) == false) goto L9;
        this.subType = r101.toLowerCase(r102);
        this.parameters = new b();
        return;
    L9:
        throw new MimeTypeParseException("Sub type is invalid.");
    L11:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    public void setParameter(String r100, String r101) {
        this.parameters.f530933a.put(r100.trim().toLowerCase(Locale.ENGLISH), r101);
    }
}

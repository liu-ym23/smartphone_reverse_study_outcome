package org.apache.commons.lang3.text;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public class ExtendedMessageFormat extends MessageFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -2362048321261811743L;
    private final Map<String, ? extends FormatFactory> registry;
    private String toPattern;

    @Override // java.text.MessageFormat
    public int hashCode() {
        return (((super.hashCode() * 31) + Objects.hashCode(this.registry)) * 31) + Objects.hashCode(this.toPattern);
    }

    static {
    }

    @Override // java.text.MessageFormat
    public String toPattern() {
        return this.toPattern;
    }

    public ExtendedMessageFormat(String r100) {
        this(r100, Locale.getDefault());
    }

    private boolean containsElements(Collection<?> r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L14;
        Iterator<?> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        if (r101.next() == null) goto L9;
        return true;
    }

    private Format getFormat(String r100) {
        if (this.registry == null) goto L12;
        int r101 = r100.indexOf(44);
        if (r101 <= 0) goto L7;
        String r102 = r100.substring(0, r101).trim();
        String r103 = r100.substring(r101 + 1).trim();
        r100 = r102;
    L8:
        FormatFactory r104 = this.registry.get(r100);
        if (r104 == null) goto L12;
        return r104.getFormat(r100, r103, getLocale());
    L7:
        r103 = null;
    L12:
        return null;
    }

    private ParsePosition next(ParsePosition r100) {
        r100.setIndex(r100.getIndex() + 1);
        return r100;
    }

    @Override // java.text.MessageFormat
    public final void applyPattern(String r110) {
        if (this.registry != null) goto L6;
        super.applyPattern(r110);
        this.toPattern = super.toPattern();
        return;
    L6:
        ArrayList r100 = new ArrayList();
        ArrayList<String> r101 = new ArrayList();
        StringBuilder r102 = new StringBuilder(r110.length());
        int r103 = 0;
        ParsePosition r104 = new ParsePosition(0);
        char[] r105 = r110.toCharArray();
        int r106 = 0;
    L8:
        if (r104.getIndex() >= r110.length()) goto L38;
        char r107 = r105[r104.getIndex()];
        if (r107 != '\'') goto L12;
        appendQuotedString(r110, r104, r102);
        goto L8
    L12:
        if (r107 != '{') goto L34;
        r106 = r106 + 1;
        seekNonWs(r110, r104);
        int r108 = r104.getIndex();
        int r109 = readArgumentIndex(r110, next(r104));
        r102.append('{');
        r102.append(r109);
        seekNonWs(r110, r104);
        String r111 = null;
        if (r105[r104.getIndex()] != ',') goto L19;
        String r112 = parseFormatDescription(r110, next(r104));
        Format r113 = getFormat(r112);
        if (r113 != null) goto L20;
        r102.append(',');
        r102.append(r112);
    L20:
        r100.add(r113);
        if (r113 == null) goto L24;
        r111 = r112;
    L24:
        r101.add(r111);
        boolean r114 = true;
        if (r100.size() != r106) goto L27;
        boolean r115 = true;
    L28:
        Validate.isTrue(r115);
        if (r101.size() == r106) goto L32;
        r114 = false;
    L32:
        Validate.isTrue(r114);
        if (r105[r104.getIndex()] == '}') goto L34;
        throw new IllegalArgumentException("Unreadable format element at position " + r108);
    L27:
        r115 = false;
        goto L28
    L19:
        r112 = null;
        r113 = null;
    L34:
        r102.append(r105[r104.getIndex()]);
        next(r104);
        goto L8
    L38:
        super.applyPattern(r102.toString());
        this.toPattern = insertFormats(super.toPattern(), r101);
        if (containsElements(r100) == false) goto L59;
        Format[] r116 = getFormats();
        Iterator r117 = r100.iterator();
    L42:
        if (r117.hasNext() == false) goto L47;
        Format r118 = (Format) r117.next();
        if (r118 == null) goto L46;
        r116[r103] = r118;
    L46:
        r103 = r103 + 1;
        goto L42
    L47:
        super.setFormats(r116);
        return;
    }

    @Override // java.text.MessageFormat
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L12;
        return false;
    L12:
        if (ObjectUtils.notEqual(getClass(), r100.getClass()) == false) goto L14;
        return false;
    L14:
        ExtendedMessageFormat r101 = (ExtendedMessageFormat) r100;
        if (ObjectUtils.notEqual(this.toPattern, r101.toPattern) == false) goto L18;
        return false;
    L18:
        return !ObjectUtils.notEqual(this.registry, r101.registry);
    }

    @Override // java.text.MessageFormat
    public void setFormats(Format[] r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatsByArgumentIndex(Format[] r100) {
        throw new UnsupportedOperationException();
    }

    public ExtendedMessageFormat(String r100, Map<String, ? extends FormatFactory> r101) {
        this(r100, Locale.getDefault(), r101);
    }

    private void getQuotedString(String r100, ParsePosition r101) {
        appendQuotedString(r100, r101, null);
    }

    private String insertFormats(String r100, ArrayList<String> r101) {
        if (containsElements(r101) == true) goto L5;
        return r100;
    L5:
        StringBuilder r102 = new StringBuilder(r100.length() * 2);
        int r103 = 0;
        ParsePosition r104 = new ParsePosition(0);
        int r105 = -1;
    L7:
        if (r104.getIndex() >= r100.length()) goto L24;
        char r106 = r100.charAt(r104.getIndex());
        if (r106 != '\'') goto L11;
        appendQuotedString(r100, r104, r102);
        goto L7
    L11:
        if (r106 != '{') goto L13;
        r103 = r103 + 1;
        r102.append('{');
        r102.append(readArgumentIndex(r100, next(r104)));
        if (r103 != 1) goto L7;
        r105 = r105 + 1;
        String r107 = (String) ListProtector.get(r101, r105);
        if (r107 == null) goto L7;
        r102.append(',');
        r102.append(r107);
        goto L7
    L13:
        if (r106 != '}') goto L16;
        r103 = r103 - 1;
    L16:
        r102.append(r106);
        next(r104);
        goto L7
    L24:
        return r102.toString();
    }

    private String parseFormatDescription(String r100, ParsePosition r101) {
        int r102 = r101.getIndex();
        seekNonWs(r100, r101);
        int r103 = r101.getIndex();
        int r104 = 1;
    L4:
        if (r101.getIndex() >= r100.length()) goto L20;
        char r105 = r100.charAt(r101.getIndex());
        if (r105 != '\'') goto L8;
        getQuotedString(r100, r101);
    L18:
        next(r101);
        goto L4
    L8:
        if (r105 != '{') goto L10;
        r104 = r104 + 1;
        goto L18
    L10:
        if (r105 != '}') goto L18;
        r104 = r104 - 1;
        if (r104 != 0) goto L18;
        return r100.substring(r103, r101.getIndex());
    L20:
        throw new IllegalArgumentException("Unterminated format element at position " + r102);
    }

    private int readArgumentIndex(String r100, ParsePosition r101) {
        int r102 = r101.getIndex();
        seekNonWs(r100, r101);
        StringBuilder r103 = new StringBuilder();
        boolean r104 = false;
    L3:
        if (r104 == true) goto L20;
        if (r101.getIndex() >= r100.length()) goto L20;
        char r105 = r100.charAt(r101.getIndex());
        if (Character.isWhitespace(r105) == false) goto L12;
        seekNonWs(r100, r101);
        r105 = r100.charAt(r101.getIndex());
        if (r105 == ',') goto L12;
        if (r105 == '}') goto L12;
        r104 = true;
    L19:
        next(r101);
    L12:
        if (r105 == ',') goto L15;
        if (r105 == '}') goto L15;
    L18:
        boolean r106 = !Character.isDigit(r105);
        r103.append(r105);
        r104 = r106;
    L15:
        if (r103.length() <= 0) goto L18;
        return CastIntegerProtector.parseInt(r103.toString());
    L20:
        if (r104 == false) goto L24;
        throw new IllegalArgumentException("Invalid format argument index at position " + r102 + ": " + r100.substring(r102, r101.getIndex()));
    L24:
        throw new IllegalArgumentException("Unterminated format element at position " + r102);
    }

    private void seekNonWs(String r100, ParsePosition r101) {
        char[] r102 = r100.toCharArray();
    L3:
        int r103 = StrMatcher.splitMatcher().isMatch(r102, r101.getIndex());
        r101.setIndex(r101.getIndex() + r103);
        if (r103 <= 0) goto L7;
        if (r101.getIndex() < r100.length()) goto L3;
        return;
    }

    @Override // java.text.MessageFormat
    public void setFormat(int r100, Format r101) {
        throw new UnsupportedOperationException();
    }

    @Override // java.text.MessageFormat
    public void setFormatByArgumentIndex(int r100, Format r101) {
        throw new UnsupportedOperationException();
    }

    public ExtendedMessageFormat(String r100, Locale r101) {
        this(r100, r101, null);
    }

    public ExtendedMessageFormat(String r100, Locale r101, Map<String, ? extends FormatFactory> r102) {
        super("");
        setLocale(r101);
        this.registry = r102;
        applyPattern(r100);
    }

    private StringBuilder appendQuotedString(String r100, ParsePosition r101, StringBuilder r102) {
        if (r102 == null) goto L5;
        r102.append('\'');
    L5:
        next(r101);
        int r103 = r101.getIndex();
        char[] r104 = r100.toCharArray();
        int r105 = r101.getIndex();
    L7:
        if (r105 >= r100.length()) goto L17;
        if (r104[r101.getIndex()] == '\'') goto L11;
        next(r101);
        r105 = r105 + 1;
        goto L7
    L11:
        next(r101);
        if (r102 != null) goto L14;
        return null;
    L14:
        r102.append(r104, r103, r101.getIndex() - r103);
        return r102;
    L17:
        throw new IllegalArgumentException("Unterminated quoted string at position " + r103);
    }
}

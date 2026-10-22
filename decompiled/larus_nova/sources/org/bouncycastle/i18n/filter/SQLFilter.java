package org.bouncycastle.i18n.filter;

/* JADX INFO: loaded from: classes42.dex */
public class SQLFilter implements Filter {
    public SQLFilter() {
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilter(String r100) {
        StringBuffer r101 = new StringBuffer(r100);
        int r102 = 0;
    L4:
        if (r102 >= r101.length()) goto L36;
        char r103 = r101.charAt(r102);
        if (r103 != '\n') goto L8;
        int r104 = r102 + 1;
        String r105 = "\\n";
    L33:
        r101.replace(r102, r104, r105);
        r102 = r104;
    L34:
        r102 = r102 + 1;
        goto L4
    L8:
        if (r103 != '\r') goto L10;
        r104 = r102 + 1;
        r105 = "\\r";
        goto L33
    L10:
        if (r103 != '\"') goto L12;
        r104 = r102 + 1;
        r105 = "\\\"";
        goto L33
    L12:
        if (r103 != '\'') goto L14;
        r104 = r102 + 1;
        r105 = "\\'";
        goto L33
    L14:
        if (r103 != '-') goto L16;
        r104 = r102 + 1;
        r105 = "\\-";
        goto L33
    L16:
        if (r103 != '/') goto L18;
        r104 = r102 + 1;
        r105 = "\\/";
        goto L33
    L18:
        if (r103 != ';') goto L20;
        r104 = r102 + 1;
        r105 = "\\;";
        goto L33
    L20:
        if (r103 != '=') goto L22;
        r104 = r102 + 1;
        r105 = "\\=";
        goto L33
    L22:
        if (r103 != '\\') goto L34;
        r104 = r102 + 1;
        r105 = "\\\\";
        goto L33
    L36:
        return r101.toString();
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilterUrl(String r100) {
        return doFilter(r100);
    }
}

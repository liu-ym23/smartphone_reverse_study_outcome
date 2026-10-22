package org.bouncycastle.i18n.filter;

/* JADX INFO: loaded from: classes42.dex */
public class HTMLFilter implements Filter {
    public HTMLFilter() {
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilter(String r100) {
        StringBuffer r101 = new StringBuffer(r100);
        int r102 = 0;
    L4:
        if (r102 >= r101.length()) goto L36;
        char r103 = r101.charAt(r102);
        if (r103 != '\"') goto L8;
        int r104 = r102 + 1;
        String r105 = "&#34";
    L33:
        r101.replace(r102, r104, r105);
    L34:
        r102 = r102 + 4;
        goto L4
    L8:
        if (r103 != '#') goto L10;
        r104 = r102 + 1;
        r105 = "&#35";
        goto L33
    L10:
        if (r103 != '+') goto L12;
        r104 = r102 + 1;
        r105 = "&#43";
        goto L33
    L12:
        if (r103 != '-') goto L14;
        r104 = r102 + 1;
        r105 = "&#45";
        goto L33
    L14:
        if (r103 != '>') goto L16;
        r104 = r102 + 1;
        r105 = "&#62";
        goto L33
    L16:
        if (r103 != ';') goto L18;
        r104 = r102 + 1;
        r105 = "&#59";
        goto L33
    L18:
        if (r103 == '<') goto L26;
        switch(r103) {
            case 37: goto L25;
            case 38: goto L24;
            case 39: goto L23;
            case 40: goto L22;
            case 41: goto L21;
            default: goto L20;
        };
    L20:
        r102 = r102 - 3;
        goto L34
    L21:
        r104 = r102 + 1;
        r105 = "&#41";
        goto L33
    L22:
        r104 = r102 + 1;
        r105 = "&#40";
        goto L33
    L23:
        r104 = r102 + 1;
        r105 = "&#39";
        goto L33
    L24:
        r104 = r102 + 1;
        r105 = "&#38";
        goto L33
    L25:
        r104 = r102 + 1;
        r105 = "&#37";
        goto L33
    L26:
        r104 = r102 + 1;
        r105 = "&#60";
        goto L33
    L36:
        return r101.toString();
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilterUrl(String r100) {
        return doFilter(r100);
    }
}

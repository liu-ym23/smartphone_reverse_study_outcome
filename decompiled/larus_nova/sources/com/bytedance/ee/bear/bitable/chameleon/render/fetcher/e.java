package com.bytedance.ee.bear.bitable.chameleon.render.fetcher;

/* JADX INFO: loaded from: classes15.dex */
public final class e {
    public static final String b(String r100) {
        int r101 = 0;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "";
    L9:
        StringBuilder r103 = new StringBuilder(r100.length());
    L11:
        if (r101 >= r100.length()) goto L28;
        char r104 = r100.charAt(r101);
        if (r104 != '\r') goto L15;
        r103.append("\\r");
    L26:
        r101 = r101 + 1;
        goto L11
    L15:
        if (r104 != '\"') goto L17;
        r103.append("\\\"");
        goto L26
    L17:
        if (r104 == '\\') goto L23;
        switch(r104) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            default: goto L19;
        };
    L19:
        r103.append(r104);
        goto L26
    L20:
        r103.append("\\n");
        goto L26
    L21:
        r103.append("\\t");
        goto L26
    L22:
        r103.append("\\b");
        goto L26
    L23:
        r103.append("\\\\");
        goto L26
    L28:
        return r103.toString();
    L5:
        r102 = false;
        goto L6
    }

    public static final String a(BaseAppClientVarsFetcher.b r100, String r110, boolean r111) {
        long r101 = 0;
        if (r100 == null) goto L5;
        long r102 = r100.f209740a;
    L6:
        boolean r103 = false;
        if (r100 == null) goto L9;
        int r112 = r100.f209741b;
    L13:
        if (r110 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        String r105 = "";
        String r106 = null;
        if (r104 == false) goto L35;
        if (r100 == null) goto L24;
        String r113 = r100.f209742c;
    L25:
        if (r113 != null) goto L27;
    L28:
        r103 = true;
    L29:
        if (r103 == true) goto L34;
        if (r100 == null) goto L32;
        r110 = r100.f209742c;
    L33:
        if (r110 != null) goto L35;
    L32:
        r110 = null;
    L34:
        r110 = "";
        goto L35
    L27:
        if (r113.length() != 0) goto L29;
    L24:
        r113 = null;
    L35:
        if (r100 == null) goto L37;
        String r107 = r100.f209743d;
    L38:
        if (r107 != null) goto L40;
        r107 = "";
    L40:
        if (r100 == null) goto L42;
        String r108 = r100.f209744e;
    L43:
        if (r108 != null) goto L45;
        r108 = "";
    L45:
        if (r100 == null) goto L47;
        r101 = r100.f209745f;
    L47:
        if (r100 == null) goto L49;
        r106 = r100.f209746g;
    L49:
        if (r106 == null) goto L53;
        r105 = r106;
    L53:
        return "{\"requestStart\":" + r102 + ",\"apiCode\":" + r112 + ",\"errorMsg\":\"" + b(r110) + "\",\"xttLogId\":\"" + b(r107) + "\",\"source\":\"" + b(r108) + "\",\"cacheElapsedTime\":" + r101 + ",\"preloadQueryResult\":\"" + b(r105) + "\"}";
    L42:
        r108 = null;
        goto L43
    L37:
        r107 = null;
        goto L38
    L15:
        if (r110.length() == 0) goto L18;
        r104 = false;
        goto L19
    L9:
        if (r111 == false) goto L11;
        r112 = 0;
        goto L13
    L11:
        r112 = -1;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }
}

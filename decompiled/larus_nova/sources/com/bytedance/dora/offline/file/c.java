package com.bytedance.dora.offline.file;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public c() {
    }

    public static String a(String r100, b.d r101) {
        int r102 = r101.f204581a;
        String r103 = r101.f204582b;
        return c(r100, "business_delivered_", r102 + "_" + b.g(r103) + "_" + r101.f204585e + "_" + r101.f204583c + "_" + b.g(r101.f204584d));
    }

    public static void b(String r100, boolean r101) {
        pk4.i.a.f529628a.f529627a.storeInt(r100, r101 ? 1 : 0);
    }

    public static String c(String r100, String r101, String r102) {
        char[] r103 = ek4.a.f472939a;
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        r104.append(ek4.a.b(r100));
        r104.append("_");
        if (r102 != null) goto L5;
    L8:
        String r105 = "";
    L9:
        r104.append(r105);
        return r104.toString();
    L5:
        if (r102.isEmpty() == true) goto L8;
        r105 = r102.replaceAll("[^a-zA-Z0-9._-]", "_");
        goto L9
    }
}

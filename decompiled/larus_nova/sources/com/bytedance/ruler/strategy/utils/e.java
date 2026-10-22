package com.bytedance.ruler.strategy.utils;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267751a = 0;

    static {
    }

    public static void a(Object r100, int r101, String r102, Throwable r103) {
        String r104 = "[" + r100.getClass().getSimpleName() + "]code:" + r101 + "  msg:" + r102;
        if (com.bytedance.ruler.d.c() == null) goto L7;
        com.bytedance.ruler.utils.e r105 = com.bytedance.ruler.d.c();
        if (r105 == null) goto L10;
        r105.e("StrategyCenter", r104, r103);
        return;
    L10:
        return;
    L7:
        if (r103 == null) goto L12;
        r103.printStackTrace();
        return;
    }
}

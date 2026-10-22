package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i {
    public static final int a = 0;

    static {
        a = com.bytedance.android.ec.core.abtest.d.q();
    }

    public static boolean b() {
        if (a <= 0) goto L5;
    L8:
        return true;
    L5:
        if (c() == true) goto L8;
        return false;
    }

    public static boolean c() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L5;
    L10:
        return true;
    L5:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.b == true) goto L10;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.d == true) goto L10;
        return false;
    }

    public static boolean a() {
        if (com.bytedance.android.ec.core.abtest.d.w() == true) goto L5;
    L7:
        return false;
    L5:
        if (com.bytedance.android.ec.core.abtest.d.o() == false) goto L7;
        return true;
    }
}

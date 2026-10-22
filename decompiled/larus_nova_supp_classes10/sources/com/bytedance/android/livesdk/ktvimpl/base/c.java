package com.bytedance.android.livesdk.ktvimpl.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static int a() {
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L6;
        return ((Number) com.bytedance.android.livesdk.sharedpref.c.F.getValue()).intValue();
    L6:
        return ((Number) com.bytedance.android.livesdk.sharedpref.c.G.getValue()).intValue();
    }

    static {
    }
}

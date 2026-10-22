package com.bytedance.android.livesdk.ktvimpl.mv;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final String b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "url:" + this.a + ";savePath:" + this.c;
    }

    public t(String r3, String r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = null;
    L8:
        Intrinsics.checkNotNullParameter(r3, "url");
        this.a = r3;
        this.b = r4;
        this.c = r5;
    }
}

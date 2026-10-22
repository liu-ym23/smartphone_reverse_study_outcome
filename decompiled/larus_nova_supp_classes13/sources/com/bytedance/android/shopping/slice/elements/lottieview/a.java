package com.bytedance.android.shopping.slice.elements.lottieview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final boolean a;
    public final int b;
    public final String c;

    public final int getType() {
        return this.b;
    }

    public a(boolean r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

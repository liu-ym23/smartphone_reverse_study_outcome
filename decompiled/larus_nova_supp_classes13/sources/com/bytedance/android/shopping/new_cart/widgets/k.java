package com.bytedance.android.shopping.new_cart.widgets;

import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements q {
    public final Function0<Boolean> a;
    public final Function0<Unit> b;
    public final Function0<Boolean> c;
    public final Function0<Boolean> d;
    public final Function0<Integer> e;

    public k() {
        this(null, null, null, null, null, 31);
    }

    public k(Function0 r2, Function0 r3, Function0 r4, Function0 r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r2 = LoadingViewAction$1.INSTANCE;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = LoadingViewAction$2.INSTANCE;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = LoadingViewAction$3.INSTANCE;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = LoadingViewAction$4.INSTANCE;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = LoadingViewAction$5.INSTANCE;
    L17:
        Intrinsics.checkNotNullParameter(r2, "showTitleBar");
        Intrinsics.checkNotNullParameter(r3, "onRLBarClick");
        Intrinsics.checkNotNullParameter(r4, "darkMode");
        Intrinsics.checkNotNullParameter(r5, "isHalfPanel");
        Intrinsics.checkNotNullParameter(r6, "getScreenOrSplitWidth");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}

package com.bytedance.ee.bear.lark.biz.bitable;

import android.view.View;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ BitableTabFragmentV2 a;
    public final /* synthetic */ View b;

    public g(BitableTabFragmentV2 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        LinearLayout r0 = this.a.o;
        LottieAnimationView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("showLoadingLayout");
        r0 = null;
    L5:
        r0.setVisibility(8);
        LinearLayout r2 = this.a.q;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("showViewPagerLayout");
        r2 = null;
    L8:
        r2.setVisibility(0);
        LottieAnimationView r3 = this.a.p;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("lkuiLoadingView");
    L12:
        r1.cancelAnimation();
        this.a.U90(this.b);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.android.shopping.deepfeed.ui.view;

import android.animation.Animator;
import com.bytedance.android.ec.core.utils.u0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a.d = 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        if (this.a.d != 1) goto L10;
        Map<String, List<Long>> r5 = g.h;
        String r6 = this.b;
        List r0 = (List) ((LinkedHashMap) g.h).get(r6);
        if (r0 != null) goto L7;
        r0 = new ArrayList();
    L7:
        r0.add(Long.valueOf(System.currentTimeMillis()));
        ed3.c r1 = g.i;
        String r2 = u0.d(new g.a.C0062a(r0));
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r2, "value");
        com.bytedance.android.shopping.deepfeed.action.h r7 = this.a.g;
        if (r7 == null) goto L10;
        r7.w();
    L10:
        this.a.d = 2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a.d = 1;
    }

    public h(g r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}

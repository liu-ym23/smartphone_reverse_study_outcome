package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f0 implements Runnable {
    public final /* synthetic */ ConstraintLayout a;
    public final /* synthetic */ g0 b;

    public /* synthetic */ f0(ConstraintLayout r1, g0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConstraintLayout r0 = this.a;
        g0 r1 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$constraintLayout");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (x54.b.c(r0) == true) goto L5;
        return;
    L5:
        if (r0.getChildCount() > 0) goto L7;
        return;
    L7:
        if (r1.f.getParent() == null) goto L16;
        f04.a r2 = r1.g(UserProfileHeaderInfoPresenter.class);
        Intrinsics.checkNotNull(r2);
        UserProfileHeaderInfoPresenter r3 = (UserProfileHeaderInfoPresenter) r2;
        Object r4 = r1.f.getParent();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
        int r5 = ((View) r4).getHeight() - r3.f.getBottom();
        View r6 = r0.getChildAt(0);
        r6.measure(View.MeasureSpec.makeMeasureSpec(com.bytedance.awemeopen.apps.framework.utils.d0.d(r1.getContext()), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r7 = RangesKt.coerceAtLeast(r6.getMeasuredHeight(), r5);
        if (r0.getHeight() == r7) goto L17;
        r0.getLayoutParams().height = r7;
        int r8 = r3.f.getBottom() + r7;
        Object r9 = r1.f.getParent();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.View");
        int r10 = RangesKt.coerceAtLeast(0, r8 - ((View) r9).getHeight());
        r1.h = r10;
        r1.f.setMaxScrollHeight(r10);
        r0.requestLayout();
        return;
    L17:
        return;
    }
}

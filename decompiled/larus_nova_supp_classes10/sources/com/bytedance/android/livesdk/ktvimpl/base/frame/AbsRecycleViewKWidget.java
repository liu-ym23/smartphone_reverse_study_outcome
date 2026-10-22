package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.widget.KtvStageWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsRecycleViewKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "T", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsViewKWidget;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsRecycleViewKWidget<T extends AbsKWidgetViewModel> extends AbsViewKWidget<T> {
    public Integer g;

    public static final class a {
    }

    static {
    }

    public boolean i() {
        return false;
    }

    public void j(c r2) {
        Intrinsics.checkNotNullParameter(r2, "outFuncProvider");
    }

    public AbsRecycleViewKWidget(KtvStageWidget r2, ViewGroup r3, c r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3, r4);
        this.g = 0;
    }

    public void k(LifecycleOwner r3, ViewGroup r4, c r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "newContainer");
        if (Intrinsics.areEqual(this.e, r4) == false) goto L5;
        return;
    L5:
        ViewGroup r0 = this.c;
        if (r0 == null) goto L30;
        ViewParent r1 = r0.getParent();
        if ((r1 instanceof ViewGroup) == true) goto L10;
        r1 = null;
    L10:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L17;
        ViewGroup r7 = this.c;
        if (r7 == null) goto L16;
        r2.removeView(r7);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L17:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
        View r8 = this.c;
        if (r8 != null) goto L21;
        r8 = e();
    L21:
        Unit r9 = (Unit) r6.invoke(Boolean.FALSE);
        r4.addView(r8, d());
        Unit r10 = (Unit) r6.invoke(Boolean.TRUE);
        if (r3 == null) goto L24;
        Intrinsics.checkNotNullParameter(r3, "newOner");
        this.a.getLifecycle().removeObserver(this);
        r3.getLifecycle().addObserver(this);
    L24:
        this.f = r5;
        if (r5 == null) goto L27;
        j(r5);
    L27:
        c();
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}

package com.bytedance.creativex.mediaimport.preview.internal.main;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.aweme.transition.EmptyTransition;
import com.ss.android.ugc.aweme.transition.InitiativeTransition;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends TransitionListener.DefaultTransitionListener implements InitiativeTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f203507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f203508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InitiativeTransition f203509c;

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void a(TransitionListener.DefaultTransitionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f203509c.a(r100);
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void d(EmptyTransition r100) {
        ViewParent r101 = this.f203508b.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L8;
        r102.removeView(this.f203508b);
    L8:
        this.f203507a.addView(this.f203508b);
        this.f203509c.d(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.transition.InitiativeTransition
    public final void g(EmptyTransition r100) {
        this.f203509c.g(r100);
    }

    public j(ViewGroup r100, View r101, InitiativeTransition r102) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "delegate");
        this.f203507a = r100;
        this.f203508b = r101;
        this.f203509c = r102;
    }
}

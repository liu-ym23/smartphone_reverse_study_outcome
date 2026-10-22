package com.ss.android.ugc.tools.view.base;

import android.view.View;
import com.ss.android.ugc.aweme.transition.TransitionListener;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends TransitionListener.DefaultTransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransitionView f454873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f454874b;

    @Override // com.ss.android.ugc.aweme.transition.TransitionListener.DefaultTransitionListener, com.ss.android.ugc.aweme.transition.ITransition
    public final void b() {
        BaseTransitionView r100 = this.f454873a;
        r100.f454864b = BaseTransitionView.State.HIDE;
        View r101 = this.f454874b;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        this.f454873a.f454867e.setVisibility(8);
        this.f454873a.f454866d.onNext(TransitionViewState.HIDDEN);
        BaseTransitionView r102 = this.f454873a;
        BaseTransitionView.Action r103 = r102.f454865c;
        if (r103 != BaseTransitionView.Action.SHOW) goto L9;
        r102.show();
    L11:
        r102.f454865c = BaseTransitionView.Action.NONE;
        return;
    L9:
        if (r103 != BaseTransitionView.Action.HIDE) goto L11;
        r102.hide();
        goto L11
    }

    @Override // com.ss.android.ugc.aweme.transition.TransitionListener.DefaultTransitionListener, com.ss.android.ugc.aweme.transition.ITransition
    public final void e() {
        this.f454873a.f454867e.setVisibility(0);
        View r100 = this.f454874b;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        this.f454873a.f454866d.onNext(TransitionViewState.PRE_SHOW);
    }

    @Override // com.ss.android.ugc.aweme.transition.TransitionListener.DefaultTransitionListener, com.ss.android.ugc.aweme.transition.ITransition
    public final void f() {
        View r100 = this.f454874b;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        this.f454873a.f454866d.onNext(TransitionViewState.PRE_HIDE);
    }

    @Override // com.ss.android.ugc.aweme.transition.TransitionListener.DefaultTransitionListener, com.ss.android.ugc.aweme.transition.ITransition
    public final void onShowEnd() {
        BaseTransitionView r100 = this.f454873a;
        r100.f454864b = BaseTransitionView.State.SHOWN;
        View r101 = this.f454874b;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        this.f454873a.f454866d.onNext(TransitionViewState.SHOWN);
        BaseTransitionView r102 = this.f454873a;
        BaseTransitionView.Action r103 = r102.f454865c;
        if (r103 != BaseTransitionView.Action.SHOW) goto L9;
        r102.show();
    L11:
        r102.f454865c = BaseTransitionView.Action.NONE;
        return;
    L9:
        if (r103 != BaseTransitionView.Action.HIDE) goto L11;
        r102.hide();
        goto L11
    }

    public a(BaseTransitionView r100, View r101) {
        this.f454873a = r100;
        this.f454874b = r101;
    }
}

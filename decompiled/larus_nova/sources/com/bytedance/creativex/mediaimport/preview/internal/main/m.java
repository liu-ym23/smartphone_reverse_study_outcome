package com.bytedance.creativex.mediaimport.preview.internal.main;

import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.transition.TransitionListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes15.dex */
public final class m extends TransitionListener.DefaultTransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f203520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f203521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f203522c;

    @Override // com.ss.android.ugc.aweme.transition.TransitionListener.DefaultTransitionListener, com.ss.android.ugc.aweme.transition.ITransition
    public final void b() {
        this.f203520a.removeView(this.f203521b);
        this.f203522c.invoke();
    }

    public m(ViewGroup r100, View r101, Function0<Unit> r102) {
        this.f203520a = r100;
        this.f203521b = r101;
        this.f203522c = r102;
    }
}

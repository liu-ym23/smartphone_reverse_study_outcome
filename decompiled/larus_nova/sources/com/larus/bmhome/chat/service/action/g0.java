package com.larus.bmhome.chat.service.action;

import android.view.View;
import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class g0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Balloon> f308756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<View> f308757b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Balloon r101 = this.f308756a.element;
        if (r101 == null) goto L5;
        r101.h();
    L5:
        View r102 = this.f308757b.element;
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        r100.removeOnAttachStateChangeListener(this);
    }

    public g0(Ref.ObjectRef<Balloon> r100, Ref.ObjectRef<View> r101) {
        this.f308756a = r100;
        this.f308757b = r101;
    }
}

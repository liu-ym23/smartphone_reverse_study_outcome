package com.ss.android.lark.api.util;

import android.view.View;
import android.view.ViewTreeObserver;
import com.ss.android.lark.forseti.node.ForsetiFragmentDisplayControllerImpl;
import com.ss.android.lark.forseti.widget.ForsetiNodeViewGroup;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f408698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f408699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f408700c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f408698a.invoke();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ViewTreeObserver r101 = this.f408699b.getViewTreeObserver();
        if (r101.isAlive() == false) goto L6;
        r101.removeOnGlobalLayoutListener(this.f408700c);
        return;
    }

    public a(Function0 r100, ForsetiNodeViewGroup r101, ForsetiFragmentDisplayControllerImpl.b r102) {
        this.f408698a = r100;
        this.f408699b = r101;
        this.f408700c = r102;
    }
}

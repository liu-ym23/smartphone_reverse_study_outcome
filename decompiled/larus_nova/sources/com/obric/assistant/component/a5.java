package com.obric.assistant.component;

import android.view.View;
import android.view.ViewTreeObserver;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
public final class a5 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> f388420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OrionChatSpeakerComponent f388421b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.removeOnAttachStateChangeListener(this);
        ViewTreeObserver.OnGlobalLayoutListener r101 = this.f388420a.element;
        if (r101 == null) goto L7;
        ViewTreeObserver r102 = r100.getViewTreeObserver();
        if (r102 == null) goto L7;
        r102.removeOnGlobalLayoutListener(r101);
    L7:
        this.f388421b.f388297w = false;
    }

    public a5(Ref.ObjectRef<ViewTreeObserver.OnGlobalLayoutListener> r100, OrionChatSpeakerComponent r101) {
        this.f388420a = r100;
        this.f388421b = r101;
    }
}

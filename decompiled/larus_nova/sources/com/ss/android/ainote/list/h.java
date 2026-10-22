package com.ss.android.ainote.list;

import android.view.View;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDLoadingDrawable f407078a;

    public h(UDLoadingDrawable r100) {
        this.f407078a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f407078a.stop();
        this.f407078a.start();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f407078a.stop();
        r100.removeOnAttachStateChangeListener(this);
    }
}

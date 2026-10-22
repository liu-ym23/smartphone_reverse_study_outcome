package com.obric.assistant.view;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f394293a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public i(View r100) {
        this.f394293a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        PopupWindow r101 = j.f394295a;
        if (r101 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    L5:
        this.f394293a.removeOnAttachStateChangeListener(this);
    }
}

package com.obric.assistant.view;

import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h0 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricUpdateBannerPopupWindow f394292a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public h0(ObricUpdateBannerPopupWindow r100) {
        this.f394292a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("anchor detached, hostId=");
        r102.append(this.f394292a.f393996a);
        r102.append(", anchor=");
        this.f394292a.getClass();
        r102.append(ObricUpdateBannerPopupWindow.j(r100));
        r101.i("ObricUpdateBannerPopupWindow", r102.toString());
        this.f394292a.c();
    }
}

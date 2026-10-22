package com.ss.android.lark.forwardv2.impl;

import com.larksuite.framework.callback.IGetDataCallback;
import iib.e;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardPresenter f424924a;

    public c(ForwardPresenter r100) {
        this.f424924a = r100;
    }

    public final void a(final IGetDataCallback<rib.b> r100) {
        final ForwardPresenter r101 = this.f424924a;
        r101.getClass();
        IGetDataCallback<rib.b> r102 = new ForwardPresenter.AnonymousClass7(r101, r100);
        r101.I8(r102, true);
        r101.I8(r102, false);
    }
}

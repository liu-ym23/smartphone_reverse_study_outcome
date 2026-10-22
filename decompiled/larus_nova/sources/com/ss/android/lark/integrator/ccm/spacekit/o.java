package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes36.dex */
public final class o implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f427908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean[] f427909b;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        IGetDataCallback r100 = this.f427908a;
        if (r100 == null) goto L6;
        r100.onSuccess(Boolean.valueOf(this.f427909b[0]));
        return;
    }

    public o(IGetDataCallback r100, boolean[] r101) {
        this.f427908a = r100;
        this.f427909b = r101;
    }
}

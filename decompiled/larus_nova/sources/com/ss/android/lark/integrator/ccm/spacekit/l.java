package com.ss.android.lark.integrator.ccm.spacekit;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f427904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long[] f427905b;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        this.f427904a.onSuccess(Long.valueOf(this.f427905b[0]));
    }

    public l(IGetDataCallback r100, long[] r101) {
        this.f427904a = r100;
        this.f427905b = r101;
    }
}

package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.larksuite.framework.callback.UICallbackExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements mpc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mpc.b f461311a;

    @Override // mpc.b
    public final void onSuccess() {
        int r100 = opc.d.f524827a;
        UICallbackExecutor.post(opc.b.f524825a);
        this.f461311a.onSuccess();
    }

    public f(u48.c r100) {
        this.f461311a = r100;
    }

    @Override // mpc.b
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        int r102 = opc.d.f524827a;
        UICallbackExecutor.post(opc.b.f524825a);
        this.f461311a.onFailure(r100, r101);
    }
}

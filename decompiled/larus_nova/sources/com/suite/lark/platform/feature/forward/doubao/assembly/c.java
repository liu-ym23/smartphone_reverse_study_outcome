package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements mpc.e {
    public c() {
    }

    @Override // mpc.e
    public final void D0() {
    }

    @Override // mpc.e
    public final mpc.a K0() {
        return new mpc.a();
    }

    @Override // mpc.e
    public final void c0(mpc.c r100, ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.onFailure(-1, "Doubao forward protocol is not implemented");
    }
}

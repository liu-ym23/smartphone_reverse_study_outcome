package com.larus.larkfeed.impl.service;

import com.larus.bmhome.chat.larkforward.o;
import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mpc.b f355531a;

    @Override // com.larus.bmhome.chat.larkforward.o
    public final void onSuccess() {
        this.f355531a.onSuccess();
    }

    public i(ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1.a r100) {
        this.f355531a = r100;
    }

    @Override // com.larus.bmhome.chat.larkforward.o
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f355531a.onFailure(r100, r101);
    }
}

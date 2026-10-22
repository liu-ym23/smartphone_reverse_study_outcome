package com.bytedance.lark.sdk.refactor.state;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.lark.sdk.refactor.i0;
import com.bytedance.lark.sdk.refactor.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e extends j {
    @Override // com.bytedance.lark.sdk.refactor.state.j
    public final SdkState a() {
        return SdkState.NONE;
    }

    public e(m r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100);
    }

    @Override // com.bytedance.lark.sdk.refactor.state.j, com.bytedance.lark.sdk.refactor.l
    public final void j(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        i0.a(r100, "NoneState before sdk init invokeAsync command = " + r100.f541569c.getName());
    }

    @Override // com.bytedance.lark.sdk.refactor.state.j, com.bytedance.lark.sdk.refactor.l
    public final InvokeResponse r(se6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        i0.a(r100, "NoneState before sdk init invoke command = " + r100.f541569c.getName());
        return new InvokeResponse(-1, new byte[]{0, 0, 0, 0}, new byte[]{0, 0, 0, 0});
    }
}

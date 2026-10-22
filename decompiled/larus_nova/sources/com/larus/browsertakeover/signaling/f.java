package com.larus.browsertakeover.signaling;

import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.service.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocalPcSignaling.b f319598a;

    public f(LocalPcSignaling.b r100) {
        this.f319598a = r100;
    }

    @Override // com.larus.im.service.a0
    public final void onReceiveDispatchCommand(final OmniDispatchCommandResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        final LocalPcSignaling.b r101 = this.f319598a;
        r101.c(new e(r101, r100));
    }

    @Override // com.larus.im.service.a0
    public final void a(String r100, String r101, IIMError r102) {
        a0.a.a(r100, r101, r102);
    }
}

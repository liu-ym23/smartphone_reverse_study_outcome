package com.bytedance.lark.molten_livequery;

import com.bytedance.lark.molten_livequery_wrapper.adapter.LiveQuerySubscriber;
import kotlin.jvm.internal.Intrinsics;
import molten_livequery.proto_kmp.MoltenContextExtra;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f253332a;

    public e(LiveQuerySubscriber.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callbackObj");
        this.f253332a = r100;
    }

    @Override // com.bytedance.lark.molten_livequery.i
    public final void a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        throw new RuntimeException("onInvokeAsync not implemented");
    }

    @Override // com.bytedance.lark.molten_livequery.i
    public final byte[] b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MoltenContextExtra r101 = MoltenContextExtra.ADAPTER.e(r100);
        this.f253332a.a();
        return new byte[0];
    }
}

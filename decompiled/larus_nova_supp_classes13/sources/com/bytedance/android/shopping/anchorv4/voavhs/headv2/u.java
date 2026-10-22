package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u implements p {
    public final AnchorV4VM a;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.p
    public final Boolean d() {
        return Boolean.valueOf(this.a.isInSplit());
    }

    public u(AnchorV4VM r2) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.a = r2;
    }
}

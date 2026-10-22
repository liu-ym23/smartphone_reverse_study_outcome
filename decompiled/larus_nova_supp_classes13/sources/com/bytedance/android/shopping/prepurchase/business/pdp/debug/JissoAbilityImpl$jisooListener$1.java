package com.bytedance.android.shopping.prepurchase.business.pdp.debug;

import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.helper.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class JissoAbilityImpl$jisooListener$1 implements f {
    public final /* synthetic */ a a;

    public JissoAbilityImpl$jisooListener$1(a r1) {
        this.a = r1;
    }

    public final void a(PackResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r4, "dto");
        com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.f.b(this.a.c, new JissoAbilityImpl$jisooListener$1$onGetNewPackData$1(this, r4, null));
    }
}

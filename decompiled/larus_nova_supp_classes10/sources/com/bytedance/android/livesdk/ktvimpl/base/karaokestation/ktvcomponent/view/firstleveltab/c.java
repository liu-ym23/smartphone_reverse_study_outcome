package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvTextSwitcher;
import com.bytedance.android.live.ktv.common.search.view.CommonSearchContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements KtvTextSwitcher.e {
    public final /* synthetic */ WantListenFirstLevelTabFragment a;

    public c(WantListenFirstLevelTabFragment r1) {
        this.a = r1;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "specialText");
        com.bytedance.android.live.ktv.common.search.viewmodel.a r0 = this.a.B;
        if (r0 == null) goto L5;
        r0.updateSearchInitText(r2);
    L5:
        CommonSearchContainer r3 = this.a.y;
        if (r3 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r3);
    L8:
        WantListenFirstLevelTabFragment.ga0(this.a);
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultText");
        CommonSearchContainer r3 = this.a.y;
        if (r3 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r3);
    L5:
        WantListenFirstLevelTabFragment.ga0(this.a);
    }
}

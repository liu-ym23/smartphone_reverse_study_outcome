package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.widget.ECRoundedLinearLayout;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends m0 {
    public final /* synthetic */ ECTabKitMixEnginePresenter a;
    public final /* synthetic */ Map b;

    public final ECLynxCardHolder a(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        ECRoundedLinearLayout r2 = new ECRoundedLinearLayout(r15, null, 6, 0);
        r2.setOrientation(1);
        r2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        ECLynxCardHolder r0 = new ECLynxCardHolder(r2, this.a.h0().getSceneId(), null, null, null, null, null, null, false, false, 2044);
        r0.q = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("metaInfo", this.b)});
        return r0;
    }

    public c(ECTabKitMixEnginePresenter r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }
}

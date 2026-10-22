package com.bytedance.android.shopping.store.moments.module.presenter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.store.widget.ECRoundedLinearLayout;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreMomentPresenter$initEngine$3 extends m0 {
    public final /* synthetic */ ECStoreMomentPresenter a;
    public final /* synthetic */ Map b;

    public final ECLynxCardHolder a(Context r15) {
        Intrinsics.checkNotNullParameter(r15, "context");
        ECRoundedLinearLayout r2 = new ECRoundedLinearLayout(r15, null, 6, 0);
        r2.setOrientation(1);
        r2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        final ECLynxCardHolder r0 = new ECLynxCardHolder(r2, this.a.i.getSceneId(), null, null, null, null, null, null, false, false, 2044);
        if (ECStoreFoldPhoneHelper.d() == false) goto L5;
        Function1<Boolean, Unit> r1 = new ECStoreMomentPresenter$initEngine$3$createLynxHolder$1(this, r0);
        Intrinsics.checkNotNullParameter(r1, "callback");
        ((ArrayList) r0.x).add(r1);
    L5:
        r0.q = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("metaInfo", this.b)});
        return r0;
    }

    public ECStoreMomentPresenter$initEngine$3(ECStoreMomentPresenter r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }
}

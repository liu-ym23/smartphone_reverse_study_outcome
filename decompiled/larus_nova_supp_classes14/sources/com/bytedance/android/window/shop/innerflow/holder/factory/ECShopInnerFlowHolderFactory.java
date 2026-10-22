package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.app.Activity;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import vp3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopInnerFlowHolderFactory {
    public static final Map<Integer, Function1<Activity, ECShopInnerFlowItemHolder<? extends b>>> a = null;

    static {
        a r5 = a.a;
        a = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, new ECShopInnerFlowHolderFactory$holderGenerators$1(r5)), TuplesKt.to(3, new ECShopInnerFlowHolderFactory$holderGenerators$2(r5)), TuplesKt.to(4, new ECShopInnerFlowHolderFactory$holderGenerators$3(r5))});
    }
}

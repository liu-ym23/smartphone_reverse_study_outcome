package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.app.Activity;
import com.bytedance.android.window.shop.innerflow.holder.ECWindowInnerFlowVideoNotHangingHolder;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import vp.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoNotHangingHolder;", "p1", "Landroid/app/Activity;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECShopInnerFlowHolderFactory$holderGenerators$2 extends FunctionReferenceImpl implements Function1<Activity, ECWindowInnerFlowVideoNotHangingHolder> {
    public ECShopInnerFlowHolderFactory$holderGenerators$2(a r8) {
        super(1, r8, a.class, "createInnerFlowVideoNotHangingHolder", "createInnerFlowVideoNotHangingHolder(Landroid/app/Activity;)Lcom/bytedance/android/window/shop/innerflow/holder/ECWindowInnerFlowVideoNotHangingHolder;", 0);
    }

    public final ECWindowInnerFlowVideoNotHangingHolder invoke(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ((a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        QUIManager r0 = new QUIManager();
        c r1 = new c();
        r0.l(new bq3.c(a.a(r5, 2131560892), r1), r5, false);
        return new ECWindowInnerFlowVideoNotHangingHolder(r0, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Activity) r1);
    }
}

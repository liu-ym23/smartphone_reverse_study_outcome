package com.bytedance.android.shopping.store.home.presenter.preview;

import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.ec.model.response.s;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements cf.i {
    public final /* synthetic */ ECShopExplainCardPresenter a;

    public d(ECShopExplainCardPresenter r1) {
        this.a = r1;
    }

    public final void a(String r1, boolean r2, Pair<Long, Long> r3, s r4, String r5, Map<String, String> r6, Function1<? super ECCurrentPromotion, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        o r8 = (o) this.a.n.getValue();
        if (r8 == null) goto L6;
        r8.g(r1, r7);
        return;
    }
}

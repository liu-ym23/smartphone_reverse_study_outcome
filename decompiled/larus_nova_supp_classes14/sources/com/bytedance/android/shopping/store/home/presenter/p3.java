package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.store.db.StoreDatabase;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p3<T> implements Consumer {
    public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;
    public final /* synthetic */ String b;

    public p3(ECShopTopMarqueeUDSlidePresenter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        int r0 = 0;
        nm.a r12 = (nm.a) CollectionsKt.getOrNull((List) r11, 0);
        if (r12 != null) goto L9;
        om.a r13 = om.a.a;
        nm.a r14 = new nm.a(0, com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId(), this.a.T().getStoreParam().getSecShopId(), this.b, 1);
        Intrinsics.checkNotNullParameter(r14, "item");
        StoreDatabase r1 = lm.a.b.a();
        if (r1 == null) goto L7;
        Observable r15 = Observable.create(new om.b(r1, r14));
    L8:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r15).subscribe(l3.a, m3.a), this.a.T());
        return;
    L7:
        r15 = Observable.just(-1L);
        goto L8
    L9:
        Integer r3 = r12.e;
        if (r3 == null) goto L12;
        r0 = r3.intValue();
    L12:
        r12.e = Integer.valueOf(r0 + 1);
        om.a r2 = om.a.a;
        Intrinsics.checkNotNullParameter(r12, "item");
        StoreDatabase r4 = lm.a.b.a();
        if (r4 == null) goto L15;
        Observable r16 = Observable.create(new om.c(r4, r12));
    L16:
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r16).subscribe(n3.a, o3.a), this.a.T());
        return;
    L15:
        r16 = Observable.just(-1);
        goto L16
    }
}

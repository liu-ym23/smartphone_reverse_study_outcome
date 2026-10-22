package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.lifecycle.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class TrackShowProductActionHandler$showProduct$1 extends FunctionReferenceImpl implements Function2<Map<String, ? extends String>, Integer, Unit> {
    public TrackShowProductActionHandler$showProduct$1(TrackShowProductActionHandler r8) {
        super(2, r8, TrackShowProductActionHandler.class, "notifyShowProduct", "notifyShowProduct(Ljava/util/Map;I)V", 0);
    }

    public final void invoke(Map<String, String> r3, int r4) {
        TrackShowProductActionHandler r0 = (TrackShowProductActionHandler) ((CallableReference) this).receiver;
        r0.getClass();
        Map<Long, m> r1 = com.bytedance.android.shopping.store.lifecycle.a.a;
        ECShopHybridProductViewModel r2 = r0.b;
        if (r2 == null) goto L7;
        ECStoreParam r5 = r2.getStoreParam();
        if (r5 == null) goto L7;
        Long r6 = Long.valueOf(r5.getLifecycleMonitorId());
    L8:
        m r7 = com.bytedance.android.shopping.store.lifecycle.a.a(r6);
        if (r7 == null) goto L12;
        com.bytedance.android.shopping.store.lifecycle.f r8 = new com.bytedance.android.shopping.store.lifecycle.f();
        r8.a = r3;
        r8.b = r4;
        Unit r9 = Unit.INSTANCE;
        r7.L(r8);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Map) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}

package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product.gul;

import com.bytedance.android.shopping.api.mall.feed.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GULSDKComponent$tryPrefetchData$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public GULSDKComponent$tryPrefetchData$1$1(GULSDKComponent r8) {
        super(0, r8, GULSDKComponent.class, "doGulPrefetch", "doGulPrefetch()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2619invoke() {
        GULSDKComponent r0 = (GULSDKComponent) ((CallableReference) this).receiver;
        if (r0.p == true) goto L9;
        com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r0, "doGulPrefetch " + r0.n);
        d r1 = r0.n;
        if (r1 == null) goto L7;
        r1.d();
    L7:
        r0.p = true;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2619invoke();
        return Unit.INSTANCE;
    }
}

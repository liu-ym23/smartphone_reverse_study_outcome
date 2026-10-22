package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECReplayScrollProductCardDataSourceFactory$create$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public ECReplayScrollProductCardDataSourceFactory$create$1$1(a r8) {
        super(0, r8, a.class, "onInvalidated", "onInvalidated()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m850invoke() {
        ((a) ((CallableReference) this).receiver).onInvalidated();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m850invoke();
        return Unit.INSTANCE;
    }
}

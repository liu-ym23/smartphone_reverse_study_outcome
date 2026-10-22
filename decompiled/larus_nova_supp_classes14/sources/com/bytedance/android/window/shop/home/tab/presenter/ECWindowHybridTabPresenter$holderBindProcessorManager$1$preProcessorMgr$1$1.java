package com.bytedance.android.window.shop.home.tab.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zq3.v1;
import zq3.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lzq3/w1;", "p1", "", "p2", "", "invoke", "(Lzq3/w1;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1 extends FunctionReferenceImpl implements Function2<w1, String, Unit> {
    public static final ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1 INSTANCE = null;

    static {
        INSTANCE = new ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1();
    }

    public ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1() {
        super(2, w1.class, "onRenderBegin", "onRenderBegin(Ljava/lang/String;)V", 0);
    }

    public final void invoke(w1 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        r2.getClass();
        if (r3 == null) goto L7;
        r2.c(new v1.f(r3));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((w1) r1, (String) r2);
        return Unit.INSTANCE;
    }
}

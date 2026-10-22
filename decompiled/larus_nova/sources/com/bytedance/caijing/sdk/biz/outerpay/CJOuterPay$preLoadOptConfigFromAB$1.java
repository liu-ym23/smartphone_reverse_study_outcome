package com.bytedance.caijing.sdk.biz.outerpay;

import com.bytedance.caijing.sdk.biz.outerpay.api.CJOuterPayApiService;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CJOuterPay$preLoadOptConfigFromAB$1 extends Lambda implements Function0<Unit> {
    public static final CJOuterPay$preLoadOptConfigFromAB$1 INSTANCE = null;

    static {
        INSTANCE = new CJOuterPay$preLoadOptConfigFromAB$1();
    }

    public CJOuterPay$preLoadOptConfigFromAB$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Lazy r100 = CJOuterPay.f202199a;
        CJOuterPayApiService r101 = (CJOuterPayApiService) CJOuterPay.f202200b.getValue();
        if (r101 == null) goto L6;
        r101.preLoadOptConfigFromAB();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

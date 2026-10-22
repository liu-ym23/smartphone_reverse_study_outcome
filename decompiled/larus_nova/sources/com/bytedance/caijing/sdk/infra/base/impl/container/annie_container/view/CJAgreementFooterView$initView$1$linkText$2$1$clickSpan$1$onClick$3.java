package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view;

import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CJAgreementFooterView$initView$1$linkText$2$1$clickSpan$1$onClick$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CJAgreementFooterView this$0;

    public CJAgreementFooterView$initView$1$linkText$2$1$clickSpan$1$onClick$3(CJAgreementFooterView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ICJTag.DefaultImpls.e$default(this.this$0, "open agreement failed", null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

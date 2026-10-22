package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CJAgreementFooterView$initView$1$guideText$1 extends Lambda implements Function0<String> {
    public static final CJAgreementFooterView$initView$1$guideText$1 INSTANCE = null;

    static {
        INSTANCE = new CJAgreementFooterView$initView$1$guideText$1();
    }

    public CJAgreementFooterView$initView$1$guideText$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "点击按钮代表阅读并同意";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}

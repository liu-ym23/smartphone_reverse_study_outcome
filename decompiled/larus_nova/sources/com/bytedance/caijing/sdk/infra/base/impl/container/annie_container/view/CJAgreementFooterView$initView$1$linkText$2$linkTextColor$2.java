package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CJAgreementFooterView$initView$1$linkText$2$linkTextColor$2 extends Lambda implements Function0<Integer> {
    public static final CJAgreementFooterView$initView$1$linkText$2$linkTextColor$2 INSTANCE = null;

    static {
        INSTANCE = new CJAgreementFooterView$initView$1$linkText$2$linkTextColor$2();
    }

    public CJAgreementFooterView$initView$1$linkText$2$linkTextColor$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        return Integer.valueOf(ColorProtector.parseColor("#04498D"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}

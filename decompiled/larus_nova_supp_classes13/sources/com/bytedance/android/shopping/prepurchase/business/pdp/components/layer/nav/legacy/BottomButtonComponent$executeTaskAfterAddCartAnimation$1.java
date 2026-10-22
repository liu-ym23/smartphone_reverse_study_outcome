package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.content.Context;
import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.dto.elements.ToastElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BottomButtonComponent$executeTaskAfterAddCartAnimation$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BottomButtonComponent this$0;

    public BottomButtonComponent$executeTaskAfterAddCartAnimation$1(BottomButtonComponent r1, Context r2) {
        this.this$0 = r1;
        this.$context = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2566invoke() {
        BottomButtonVO r0 = this.this$0.a;
        if (r0 == null) goto L19;
        BottomButtonMeta r1 = r0.getBottomButtonMetaValue();
        if (r1 == null) goto L19;
        AddCartMeta r2 = r1.getAddCartMeta();
        if (r2 == null) goto L19;
        if (r2.getAddCartAnimationStyle() != 1) goto L19;
        BottomButtonVO r3 = this.this$0.a;
        if (r3 == null) goto L29;
        BottomButtonMeta r4 = r3.getBottomButtonMetaValue();
        if (r4 == null) goto L30;
        AddCartMeta r5 = r4.getAddCartMeta();
        if (r5 == null) goto L31;
        ToastElement r6 = r5.getAddCartToast();
        if (r6 == null) goto L32;
        int r7 = com.bytedance.android.shopping.utils.c.a;
        com.bytedance.android.shopping.utils.c.c(this.$context, r6, new i(this.this$0.f), new BottomButtonComponent$executeTaskAfterAddCartAnimation$1$$special$$inlined$let$lambda$1(this));
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L19:
        int r8 = com.bytedance.android.shopping.utils.c.a;
        Context r9 = this.this$0.h.getContext();
        i r10 = new i(this.this$0.f);
        BottomButtonVO r11 = this.this$0.a;
        if (r11 == null) goto L26;
        BottomButtonMeta r12 = r11.getBottomButtonMetaValue();
        if (r12 == null) goto L26;
        AddCartMeta r13 = r12.getAddCartMeta();
        if (r13 == null) goto L26;
        String r14 = r13.getAddCartPopupSchema();
    L27:
        com.bytedance.android.shopping.utils.c.g(r9, r10, r14, 0);
        return;
    L26:
        r14 = null;
        goto L27
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2566invoke();
        return Unit.INSTANCE;
    }
}

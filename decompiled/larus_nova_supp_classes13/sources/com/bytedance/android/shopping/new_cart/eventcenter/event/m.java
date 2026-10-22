package com.bytedance.android.shopping.new_cart.eventcenter.event;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.new_cart.container.CartDialogFragment;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CartObjectContainer a;

    public m(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Map r6 = r5.q();
        if (r6 == null) goto L5;
        Object r7 = r6.get("click_type");
    L7:
        if ((r7 instanceof String) == true) goto L9;
        r7 = null;
    L9:
        String r8 = (String) r7;
        if (Intrinsics.areEqual(r8, "back") == false) goto L26;
        Fragment r9 = this.a.f;
        if ((r9 instanceof CartDialogFragment) == true) goto L14;
        r9 = null;
    L14:
        CartDialogFragment r10 = (CartDialogFragment) r9;
        if (r10 != null) goto L55;
    L22:
        NewCartActivity r11 = this.a.getActivity();
        if (r11 == null) goto L53;
        r11.finish();
    L53:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L55:
        r10.dismissAllowingStateLoss();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r13 = DialogFragmentLancet.sLastShowStack;
        if (r13 == null) goto L22;
        com.bytedance.crash.d.d(r13, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L22
    L26:
        if (Intrinsics.areEqual(r8, "close_all") == false) goto L39;
        int r14 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r15 = this.a.e.c;
        if (r15 == null) goto L30;
        String r16 = r15.getSplitActivityScene();
    L32:
        if (com.bytedance.android.shopping.new_cart.utils.c.a(r16) == false) goto L53;
        nj.d r17 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r17 == null) goto L53;
        Fragment r1 = this.a.f;
        if (r1 == null) goto L38;
        r1.requireActivity();
    L38:
        r17.n();
        goto L53
    L30:
        r16 = null;
        goto L32
    L39:
        Fragment r18 = this.a.f;
        if ((r18 instanceof CartDialogFragment) == true) goto L42;
        r18 = null;
    L42:
        CartDialogFragment r19 = (CartDialogFragment) r18;
        if (r19 != null) goto L57;
    L50:
        NewCartActivity r20 = this.a.getActivity();
        if (r20 == null) goto L53;
        r20.finish();
        goto L53
    L57:
        r19.dismissAllowingStateLoss();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r21 = DialogFragmentLancet.sLastShowStack;
        if (r21 == null) goto L50;
        com.bytedance.crash.d.d(r21, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L50
    L5:
        r7 = null;
        goto L7
    }
}

package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.ui.ec.widget.dialog.ECAlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "show_dialog", description = "展示弹窗", service = {"LiveBase"})
public final class e0 extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.k> {
    public e0() {
    }

    public static final void c(e0 r10, Context r11, sl.h r12, Object r13) {
        r10.getClass();
        if (r12 == null) goto L17;
        Intrinsics.checkNotNullParameter(r12, "$this$convert2Standard");
        int r14 = r12.a();
        com.bytedance.android.livesdk.livecommerce.ability.f r0 = null;
        if (r14 != 1) goto L7;
        sl.a r15 = r12.b();
        if (r15 != null) goto L13;
    L12:
        com.bytedance.android.livesdk.livecommerce.ability.f r5 = r0;
        if (r5 == null) goto L18;
        Lazy r16 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), r11, r5, r13, null, null, 16);
        return;
    L18:
        return;
    L13:
        String r17 = com.bytedance.android.livesdk.livecommerce.eventcenter.a.c(r12.a(), r15.a());
        r0 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r17, com.bytedance.android.livesdk.livecommerce.eventcenter.a.b(r17, r12));
        goto L12
    L7:
        if (r14 != 4) goto L12;
        String r18 = com.bytedance.android.livesdk.livecommerce.eventcenter.a.c(r12.a(), null);
        r0 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveList", r18, com.bytedance.android.livesdk.livecommerce.eventcenter.a.b(r18, r12));
        goto L12
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r11, sl.k r12, Object r13, il2.a r14, com.bytedance.android.livesdk.livecommerce.ability.e r15) {
        sl.k r16 = r12;
        SpannableStringBuilder r0 = null;
        if (r11 == null) goto L62;
        if (r16 == null) goto L62;
        ECAlertDialog r6 = new ECAlertDialog(r11);
        String r1 = r16.f();
        if (r1 != null) goto L9;
    L17:
        sl.j r2 = r16.c();
        if (r2 == null) goto L20;
        List r3 = r2.a();
    L21:
        if (r3 == null) goto L38;
        SpannableStringBuilder r4 = new SpannableStringBuilder();
        Iterator r5 = r3.iterator();
        int r7 = 0;
        int r8 = 0;
    L25:
        if (r5.hasNext() == false) goto L37;
        sl.l r9 = (sl.l) r5.next();
        String r10 = r9.b();
        if (r10 == null) goto L25;
        if (r10.length() <= 0) goto L31;
        boolean r17 = true;
    L32:
        if (r17 == true) goto L35;
        r10 = null;
    L35:
        if (r10 == null) goto L25;
        r4.append(r10);
        r7 = r7 + r10.length();
        int r18 = com.bytedance.android.ec.core.utils.s.a;
        r4.setSpan(new ForegroundColorSpan(com.bytedance.android.ec.core.utils.s.a(r9.a(), 0)), r8, r7, 17);
        r8 = r7;
        goto L25
    L31:
        r17 = false;
        goto L32
    L37:
        r0 = r4;
    L38:
        if (r0 == null) goto L40;
        r6.setMessage(r0);
    L40:
        sl.i r19 = r16.b();
        String r110 = "";
        if (r19 == null) goto L47;
        String r20 = r19.b();
        if (r20 != null) goto L45;
        String r21 = "";
    L46:
        r6.setPositiveButton(r21, new z(r19, this, r16, r11, r13));
        goto L47
    L45:
        r21 = r20;
    L47:
        sl.i r22 = r16.a();
        if (r22 == null) goto L55;
        String r23 = r22.b();
        if (r23 == null) goto L53;
        r110 = r23;
    L53:
        r6.setNegativeButton(r110, new a0(r22, this, r16, r11, r13));
    L55:
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L66;
        DialogLancet.handleBlockedDialogShow(r6);
    L59:
        oh.a.c("ECAlertDialogShowEvent", new d0(r16.d(), r16.e()));
        if (r15 == null) goto L75;
        r15.onSuccess();
        return;
    L75:
        return;
    L66:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L65
    L58:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        goto L59
    L20:
        r3 = null;
        goto L21
    L9:
        if (r1.length() <= 0) goto L11;
        boolean r24 = true;
    L12:
        if (r24 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L17;
        r6.setTitle(r1);
        goto L17
    L11:
        r24 = false;
    L62:
        if (r15 == null) goto L77;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r15, 0, null, 3);
        return;
    }
}

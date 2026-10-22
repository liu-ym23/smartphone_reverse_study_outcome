package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfToastFunction extends com.bytedance.kmp.ec.yata.event.common.a {
    public final String a;
    public final Lazy b;
    public final CardListObjectContainer c;

    public SelfToastFunction(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.c = r2;
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = LazyKt.lazy(new SelfToastFunction$monitorManager$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Object r0 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r7.e).a.get("toast_message");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L17;
        Object r9 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "toast_message");
        if ((r9 instanceof String) == true) goto L16;
        r9 = null;
    L16:
        r1 = (String) r9;
    L17:
        if (r1 != null) goto L19;
    L22:
        if (r2 == false) goto L28;
        CardListYataMonitorManager r10 = (CardListYataMonitorManager) this.b.getValue();
        if (r10 == null) goto L28;
        com.bytedance.android.shopping.card_list.monitor.error.a r11 = r10.e;
        if (r11 == null) goto L28;
        CardListErrorMonitorType r3 = CardListErrorMonitorType.SELF_FUN_ERROR;
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r4 = com.bytedance.android.shopping.card_list.monitor.error.a.b;
        r11.b(r3, "selfToast  toastMsg is null", null);
    L28:
        ECToastUtils r12 = ECToastUtils.INSTANCE;
        Context r6 = this.c.getContext();
        if (r6 != null) goto L31;
        r6 = ECAppInfoService.e.getCurrentActivity();
    L31:
        if (r1 != null) goto L33;
        r1 = "";
    L33:
        r12.showToast(r6, r1, Boolean.TRUE);
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L19:
        if (StringsKt.isBlank(r1) == true) goto L22;
        r2 = false;
        goto L22
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r5 = false;
        goto L12
    }
}

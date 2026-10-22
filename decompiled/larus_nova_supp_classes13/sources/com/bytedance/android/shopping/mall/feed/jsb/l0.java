package com.bytedance.android.shopping.mall.feed.jsb;

import android.content.Context;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.DeliveryInterceptDialog;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l0 extends qf3.e {
    public final String getName() {
        return "mall.showDeliveryDialog";
    }

    public l0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r3, Map<String, ? extends Object> r4, IDLXBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Object r6 = r4.get("mainTip");
        Object r1 = null;
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        Object r8 = r4.get("subTip");
        if ((r8 instanceof String) == true) goto L8;
        r8 = null;
    L8:
        String r9 = (String) r8;
        Object r10 = r4.get("dismissBtnText");
        if ((r10 instanceof String) == true) goto L11;
        r10 = null;
    L11:
        String r11 = (String) r10;
        Object r12 = r4.get("confirmBtnText");
        if ((r12 instanceof String) == true) goto L14;
        r12 = null;
    L14:
        String r13 = (String) r12;
        Object r14 = r4.get("chatGroupUrl");
        if ((r14 instanceof String) == false) goto L18;
        r1 = r14;
    L18:
        String r2 = (String) r1;
        int r15 = com.bytedance.android.shopping.api.mall.common.tools.w.a;
        Context r16 = this.c.a;
        com.bytedance.android.shopping.api.mall.common.tools.l.a.getClass();
        if (HybridAppInfoService.p.isLocalTest() == false) goto L26;
        if (r16 == null) goto L26;
        AppCompatDialog r17 = new DeliveryInterceptDialog(r16);
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r17);
        goto L26
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L25:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
    L26:
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("code", 1);
        r18.put("msg", "success");
        r5.invoke(r18);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}

package com.bytedance.applet.aibridge.ecommerce.impl;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.ecommerce.api.AbsUpdateECommercePageInfoMethodIDL;
import com.larus.platform.api.l2;
import com.larus.platform.service.l0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/UpdateECommercePageInfoMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateECommercePageInfoMethod extends AbsUpdateECommercePageInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public UpdateECommercePageInfoMethod() {
    }

    public final void handle(d r4, ParamModel r5, h r6) {
        AbsUpdateECommercePageInfoMethodIDL.a r7 = (AbsUpdateECommercePageInfoMethodIDL.a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        FragmentActivity r8 = r4.getOwnerActivity();
        if ((r8 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r9 = r8;
    L6:
        if (r9 == null) goto L10;
        l2 r0 = l0.a();
        if (r0 == null) goto L10;
        r0.d(r9, r7.getPageAction(), r7.getCurrentPage(), r7.getSource());
    L10:
        Intrinsics.checkNotNullParameter(AbsUpdateECommercePageInfoMethodIDL.b.class, "<this>");
        r6.b(c.a(AbsUpdateECommercePageInfoMethodIDL.b.class), "");
        return;
    L5:
        r9 = null;
        goto L6
    }
}

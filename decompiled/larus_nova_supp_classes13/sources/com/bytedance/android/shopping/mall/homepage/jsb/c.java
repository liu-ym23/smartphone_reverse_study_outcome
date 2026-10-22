package com.bytedance.android.shopping.mall.homepage.jsb;

import android.view.View;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendant;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public c(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.anchor_pendant_visibility_change";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r4, IBDXBridgeContext r5, Map<String, ? extends Object> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "result");
        Object r8 = r6.get("container_id");
        Object r1 = null;
        if ((r8 instanceof String) == true) goto L5;
        r8 = null;
    L5:
        String r9 = (String) r8;
        int r0 = 0;
        if (r9 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        Object r10 = r6.get("visible");
        if ((r10 instanceof Boolean) == false) goto L19;
        r1 = r10;
    L19:
        boolean r11 = Intrinsics.areEqual((Boolean) r1, Boolean.TRUE);
        AnchorPendantManager r12 = r4.b.A1.Pt();
        if (r12 == null) goto L40;
        if (Intrinsics.areEqual(r9, "self") == false) goto L32;
        View r13 = r5.getEngineView();
        if (r13 == null) goto L40;
        Intrinsics.checkNotNullParameter(r13, "lynxView");
        AnchorPendant r14 = r12.g(r13);
        if (r14 == null) goto L40;
        View r15 = r14.p;
        if (r11 == true) goto L31;
        r0 = 8;
    L31:
        r15.setVisibility(r0);
        goto L40
    L32:
        Intrinsics.checkNotNullParameter(r9, "containerID");
        AnchorPendant r16 = r12.f(r9);
        if (r16 == null) goto L40;
        View r17 = r16.p;
        if (r11 == true) goto L38;
        r0 = 8;
    L38:
        r17.setVisibility(r0);
    L40:
        return qf3.e.f(this);
    L14:
        return qf3.e.c("container_id is null or empty");
    L8:
        if (r9.length() == 0) goto L11;
        r2 = false;
        goto L12
    }
}

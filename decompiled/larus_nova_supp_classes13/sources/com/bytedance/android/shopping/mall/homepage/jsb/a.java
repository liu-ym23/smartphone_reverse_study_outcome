package com.bytedance.android.shopping.mall.homepage.jsb;

import android.view.View;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendant;
import com.bytedance.android.shopping.mall.homepage.pendant.anchor.AnchorPendantManager;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends qf3.e {
    public final String d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.jsb.a$a, reason: collision with other inner class name */
    public static final class C0103a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public a(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.anchor_pendant_dismiss";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("container_id");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 != null) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        AnchorPendantManager r8 = r2.b.A1.Pt();
        if (r8 == null) goto L27;
        if (Intrinsics.areEqual(r7, "self") == false) goto L25;
        View r9 = r3.getEngineView();
        if (r9 == null) goto L27;
        Intrinsics.checkNotNullParameter(r9, "lynxView");
        r8.g(r9);
        Intrinsics.checkNotNullParameter(r9, "lynxView");
        AnchorPendant r10 = r8.g(r9);
        if (r10 == null) goto L24;
        r8.e(r10);
        r8.d.remove(r10);
    L24:
        r8.i();
        Lazy r11 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.c.b, "dismiss pendent :" + r10);
        goto L27
    L25:
        int r12 = AnchorPendantManager.l;
        r8.b(r7, true);
    L27:
        return qf3.e.f(this);
    L14:
        return qf3.e.c("container_id is null or empty");
    L8:
        if (r7.length() == 0) goto L11;
        r0 = false;
        goto L12
    }
}

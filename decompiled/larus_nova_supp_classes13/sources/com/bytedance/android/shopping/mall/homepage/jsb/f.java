package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public f(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.hideTaskBanner";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        Object r6 = r4.get("containerID");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 != null) goto L8;
    L11:
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
        IHybridHostService r9 = com.bytedance.android.ec.hybrid.a.h();
        if (r9 == null) goto L22;
        yj.f r10 = r9.getHybridECSdkService();
        if (r10 == null) goto L22;
        r10.hideTaskBanner(r7);
        Unit r11 = Unit.INSTANCE;
        Pair<Boolean, String> r12 = qf3.e.f(this);
        if (r12 == null) goto L22;
        return r12;
    L22:
        return qf3.e.c("ECHostService or ECSdkService is null");
    L14:
        return qf3.e.c("containerID is null or empty");
    L8:
        if (r7.length() == 0) goto L11;
        r8 = false;
        goto L12
    }
}

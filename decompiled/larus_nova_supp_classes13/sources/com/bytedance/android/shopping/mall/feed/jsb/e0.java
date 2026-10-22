package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.opt.session.ECPerfSessionManager;
import com.bytedance.android.ec.opt.session.model.StageType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 extends qf3.e {
    public final String getName() {
        return "ec.writePerfSession";
    }

    public e0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r4, IBDXBridgeContext r5, Map<String, ? extends Object> r6, Map<String, Object> r7) {
        Intrinsics.checkNotNullParameter(r4, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "result");
        Object r8 = r6.get("session_id");
        if ((r8 instanceof String) == true) goto L5;
        r8 = null;
    L5:
        String r9 = (String) r8;
        Object r10 = r6.get("stage");
        if ((r10 instanceof String) == true) goto L8;
        r10 = null;
    L8:
        String r11 = (String) r10;
        boolean r0 = true;
        if (r9 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L44;
        if (r11 != null) goto L18;
    L21:
        if (r0 == true) goto L44;
        Object r1 = r6.get("timestamp");
        if ((r1 instanceof String) == true) goto L26;
        r1 = null;
    L26:
        String r3 = (String) r1;
        if (r3 != null) goto L29;
        r3 = "0";
    L29:
        Object r12 = r6.get("stage_type");
        if ((r12 instanceof String) == true) goto L32;
        r12 = null;
    L32:
        String r13 = (String) r12;
        Object r14 = r6.get("stage_data");
        if ((r14 instanceof Map) == true) goto L35;
        r14 = null;
    L35:
        Map r15 = (Map) r14;
        if (r15 != null) goto L38;
        r15 = MapsKt.emptyMap();
    L38:
        bm.b r16 = new bm.b(r11, r3);
        StageType.Companion.getClass();
        StageType r17 = StageType.a.a(r13);
        if (r17 != null) goto L41;
        r17 = StageType.NORMAL;
    L41:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.a = r17;
        r16.update(r15);
        ECPerfSessionManager.d.d(r9, r11, r16);
        return TuplesKt.to(Boolean.TRUE, null);
    L18:
        if (StringsKt.isBlank(r11) == true) goto L21;
        r0 = false;
    L44:
        return TuplesKt.to(Boolean.FALSE, "invalid id or stage");
    L11:
        if (StringsKt.isBlank(r9) == true) goto L14;
        r2 = false;
        goto L15
    }
}

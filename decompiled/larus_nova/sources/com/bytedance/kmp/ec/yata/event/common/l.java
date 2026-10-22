package com.bytedance.kmp.ec.yata.event.common;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.facebook.keyframes.model.KFImage;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class l {
    public static final Map a(com.bytedance.kmp.ec.yata.store.node.c r100) {
        Pair[] r101 = new Pair[3];
        r101[0] = TuplesKt.to("node_key", r100.getKey());
        r101[1] = TuplesKt.to(SlcCommonAction.KEY_PARAMS, r100.s());
        com.bytedance.kmp.ec.yata.common.protocol.data.k r102 = r100.r();
        if (r102 == null) goto L5;
        Map<String, Object> r103 = r102.f();
    L6:
        r101[2] = TuplesKt.to(KFImage.FEATURES_JSON_FIELD, r103);
        return MapsKt.mapOf(r101);
    L5:
        r103 = null;
        goto L6
    }
}

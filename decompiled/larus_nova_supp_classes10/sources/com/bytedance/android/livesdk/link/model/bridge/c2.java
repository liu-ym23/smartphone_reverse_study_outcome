package com.bytedance.android.livesdk.link.model.bridge;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c2 {
    public static final String a(b2 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$simpleString");
        StringBuilder r0 = new StringBuilder("PreRtcInfo{");
        Map<Long, z1> r1 = r5.getPreRtcUserInfo();
        if (r1 == null) goto L8;
        Iterator<Map.Entry<Long, z1>> r2 = r1.entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<Long, z1> r3 = r2.next();
        r0.append("[");
        r0.append(r3.getKey().longValue());
        r0.append(":");
        r0.append(r3.getValue().getLinkmicIdStr());
        r0.append(",push=");
        r0.append(r3.getValue().getRtcPushStream());
        r0.append(",status=");
        r0.append(r3.getValue().getLinkStatus());
        r0.append("]");
    L8:
        r0.append(" pre_join=");
        r0.append(r5.getRtcJoinChannel());
        r0.append(" version=");
        r0.append(r5.getVersion());
        r0.append("}");
        return r0.toString();
    }
}

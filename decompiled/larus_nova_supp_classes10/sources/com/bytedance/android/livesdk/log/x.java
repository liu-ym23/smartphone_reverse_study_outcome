package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.b8;
import com.bytedance.android.livesdk.config.LiveTeaDynamicConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x {
    public static LiveTeaDynamicConfig a;

    static {
    }

    public static Map a(String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        if (r5 != null) goto L5;
        return r5;
    L5:
        if (StringsKt.startsWith$default(r4, "livesdk_", false, 2, null) == true) goto L8;
        return r5;
    L8:
        if (a != null) goto L10;
        a = (LiveTeaDynamicConfig) b8.a.getValue();
    L10:
        LiveTeaDynamicConfig r0 = a;
        if (r0 != null) goto L15;
        ALogger.i("LiveLoggerHelper", "mConfig is null");
        return r5;
    L15:
        if (r0.getEnable() == true) goto L18;
        return r5;
    L18:
        if (r0.getParamBlockList() != null) goto L22;
        ALogger.i("LiveLoggerHelper", "paramAllowList is null");
        return r5;
    L22:
        if (r0.isTrackAll() == true) goto L28;
        List r2 = r0.getEventAllowList();
        if (r2 != null) goto L26;
        return r5;
    L26:
        if (r2.contains(r4) != true) goto L33;
        ALogger.i("LiveLoggerHelper", "isTrackAll=false, eventName=" + r4);
        Map r1 = c(r0.getParamBlockList(), r5);
        b(r4, r5, r1);
    L30:
        return r1;
    L33:
        return r5;
    L28:
        ALogger.i("LiveLoggerHelper", "isTrackAll=true, eventName=" + r4);
        r1 = c(r0.getParamBlockList(), r5);
        b(r4, r5, r1);
        goto L30
    }

    public static Map c(List r4, Map r5) {
        if (r4 == null) goto L9;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r6 = r5.entrySet().iterator();
    L5:
        if (r6.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r6.next();
        if ((!CollectionsKt.contains(r4, (String) r1.getKey())) == false) goto L5;
        r0.put(r1.getKey(), r1.getValue());
        goto L5
    L16:
        return r0;
    L9:
        return null;
    }

    public static void b(String r4, Map r5, Map r6) {
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L22;
        StringBuilder r0 = new StringBuilder("触发埋点参数裁剪->【eventName=");
        r0.append(r4);
        r0.append(", list =");
        String r7 = null;
        Set r8 = null;
        if (r6 == null) goto L15;
        if (r5 == null) goto L14;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator r10 = r5.entrySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r10.next();
        if ((!r6.keySet().contains((String) r1.getKey())) == false) goto L9;
        r9.put(r1.getKey(), r1.getValue());
        goto L9
    L13:
        r8 = r9.keySet();
    L14:
        r7 = String.valueOf(r8);
    L15:
        r0.append(r7);
        r0.append(12305);
        ALogger.i("LiveLoggerHelper", r0.toString());
        return;
    }
}

package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static final boolean a(String r100) {
        if (r100 == null) goto L4;
        String r101 = r100.toLowerCase(Locale.ROOT);
    L6:
        if (Intrinsics.areEqual(r101, MonitorConstants.CONNECT_TYPE_GET) == false) goto L8;
    L11:
        return true;
    L8:
        if (Intrinsics.areEqual(r101, UGCMonitor.TYPE_POST) == true) goto L11;
        return false;
    L4:
        r101 = null;
        goto L6
    }

    public static final Map<String, String> b(JSONObject r100) {
        if (r100 == null) goto L4;
        Iterator<String> r101 = r100.keys();
        HashMap r102 = new HashMap();
    L7:
        if (r101.hasNext() == false) goto L15;
        String r103 = r101.next();
        if (r100.optJSONObject(r103) == null) goto L14;
        Map<String, String> r104 = b(r100.optJSONObject(r103));     // Catch: NullPointerException -> L12
        Intrinsics.checkNotNull(r104);     // Catch: NullPointerException -> L12
        r102.putAll(r104);     // Catch: NullPointerException -> L12
    L12:
        e = move-exception;
        e.getMessage();
        goto L7
    L14:
        r102.put(r103, r100.optString(r103));
        goto L7
    L15:
        return r102;
    L4:
        return new LinkedHashMap();
    }
}

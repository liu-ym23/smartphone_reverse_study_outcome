package com.bytedance.live.livelink.kmp.impl.base.rtc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f255316a = 0;

    static {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004e -> B:18:0x0063). Please report as a decompilation issue!!! */
    public static int b(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "abTestConfig");
        Intrinsics.checkNotNullParameter("rtc_ab_enable_csm_thread", "abTestName");
        Intrinsics.checkNotNullParameter(r101, "abTestOption");
        Object r103 = null;
        if ((!StringsKt.isBlank(r100)) == false) goto L5;
        String r104 = r100;
    L6:
        if (r104 != null) goto L27;
    L18:
        Object r105 = null;
    L19:
        if ((r105 instanceof Integer) == false) goto L23;
        r103 = r105;
    L23:
        Integer r106 = (Integer) r103;
        if (r106 != null) goto L26;
        return r102;
    L26:
        return r106.intValue();
    L16:
        e = move-exception;
        int r107 = ej6.a.f472874a;
        ej6.a.d("RTCABTestHelper", "parseABTest exception " + e);
        goto L18
    L27:
        JSONObject r108 = new JSONObject(r100);     // Catch: Exception -> L16
        JSONObject r109 = r108.optJSONObject("rtc_ab_enable_csm_thread");     // Catch: Exception -> L16
        if (r109 == null) goto L11;
        r105 = r109.opt(r101);     // Catch: Exception -> L16
        goto L19
    L11:
        if ((r108.get("rtc_ab_enable_csm_thread") instanceof String) == false) goto L18;
        String r110 = r108.optString("rtc_ab_enable_csm_thread");     // Catch: Exception -> L16
        if ((!StringsKt.isBlank(r110)) == false) goto L18;
        r105 = new JSONObject(r110).opt(r101);     // Catch: Exception -> L16
        goto L19
    L5:
        r104 = null;
        goto L6
    }

    public static boolean a(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "abTestConfig");
        Intrinsics.checkNotNullParameter(r101, "abTestName");
        Intrinsics.checkNotNullParameter(r102, "abTestOption");
        if ((!StringsKt.isBlank(r100)) == false) goto L5;
        String r104 = r100;
    L6:
        if (r104 != null) goto L20;
    L19:
        return r103;
    L20:
        JSONObject r105 = new JSONObject(r100);     // Catch: Exception -> L17
        JSONObject r106 = r105.optJSONObject(r101);     // Catch: Exception -> L17
        if (r106 == null) goto L12;
        return r106.optBoolean(r102);
    L12:
        if ((r105.get(r101) instanceof String) == false) goto L19;
        String r107 = r105.optString(r101);     // Catch: Exception -> L17
        if ((!StringsKt.isBlank(r107)) == false) goto L19;
        return new JSONObject(r107).optBoolean(r102);
    L17:
        e = move-exception;
        int r108 = ej6.a.f472874a;
        ej6.a.d("RTCABTestHelper", "parseABTest exception " + e);
        goto L19
    L5:
        r104 = null;
        goto L6
    }
}

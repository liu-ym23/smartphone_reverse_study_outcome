package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class i1 {
    public static final void a(String r110, String r111, Integer r112, JSONObject r113, JSONObject r114, JSONObject r115, String r116) {
        String r100 = r116;
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "bid");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "bid");
        if (r112 == null) goto L5;
        int r101 = r112.intValue();
    L7:
        if (r113 == null) goto L9;
        Intrinsics.checkNotNullParameter(r113, "jsonObj");
        JSONObject r102 = or3.a.a(r113);
        Intrinsics.checkNotNullParameter(r102, "category");
        JSONObject r117 = r102;
    L10:
        if (r114 == null) goto L12;
        Intrinsics.checkNotNullParameter(r114, "jsonObj");
        JSONObject r103 = or3.a.a(r114);
        Intrinsics.checkNotNullParameter(r103, "metrics");
        JSONObject r118 = r103;
    L13:
        if (r115 == null) goto L15;
        Intrinsics.checkNotNullParameter(r115, "jsonObj");
        JSONObject r104 = or3.a.a(r115);
        Intrinsics.checkNotNullParameter(r104, "extra");
        JSONObject r119 = r104;
    L16:
        if (r100 == null) goto L18;
        Intrinsics.checkNotNullParameter(r100, "url");
    L19:
        AnnieXSLCustomReportImplKt.a(new q5(r110, Integer.valueOf(r101), null, r100, r111, r117, r118, r119));
        return;
    L18:
        r100 = null;
        goto L19
    L15:
        r119 = null;
        goto L16
    L12:
        r118 = null;
        goto L13
    L9:
        r117 = null;
        goto L10
    L5:
        r101 = 2;
        goto L7
    }

    public static final void b(String r110, String r111, Integer r112, JSONObject r113, JSONObject r114, JSONObject r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "containerId");
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Intrinsics.checkNotNullParameter(r111, "containerId");
        if (r112 == null) goto L5;
        int r100 = r112.intValue();
    L7:
        if (r113 == null) goto L9;
        Intrinsics.checkNotNullParameter(r113, "jsonObj");
        JSONObject r101 = or3.a.a(r113);
        Intrinsics.checkNotNullParameter(r101, "category");
        JSONObject r118 = r101;
    L10:
        if (r114 == null) goto L12;
        Intrinsics.checkNotNullParameter(r114, "jsonObj");
        JSONObject r102 = or3.a.a(r114);
        Intrinsics.checkNotNullParameter(r102, "metrics");
        JSONObject r119 = r102;
    L13:
        if (r115 == null) goto L15;
        Intrinsics.checkNotNullParameter(r115, "jsonObj");
        JSONObject r103 = or3.a.a(r115);
        Intrinsics.checkNotNullParameter(r103, "extra");
        JSONObject r104 = r103;
    L16:
        if (r116 == null) goto L18;
        Intrinsics.checkNotNullParameter(r116, "url");
        String r105 = r116;
    L19:
        if (r117 == null) goto L21;
        Intrinsics.checkNotNullParameter(r117, "bid");
        String r106 = r117;
    L22:
        AnnieXSLCustomReportImplKt.a(new q5(r110, Integer.valueOf(r100), r111, r105, r106, r118, r119, r104));
        return;
    L21:
        r106 = null;
        goto L22
    L18:
        r105 = null;
        goto L19
    L15:
        r104 = null;
        goto L16
    L12:
        r119 = null;
        goto L13
    L9:
        r118 = null;
        goto L10
    L5:
        r100 = 2;
        goto L7
    }
}

package com.larus.voicecall.impl.degrade;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larus.platform.service.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class d {
    public static final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        r103.put("scene", r100);     // Catch: Throwable -> L9
        if (r101 == false) goto L6;
        String r104 = "total";
    L7:
        r103.put("type", r104);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L14;
        r105 = null;
    L14:
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("downgrade_time_limit", (JSONObject) r105, null, null);
        return;
    L6:
        r104 = "once";
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r102, "limitType");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L15
        r104.put("limited_biz", r100);     // Catch: Throwable -> L15
        r104.put("limited_entrance", r101);     // Catch: Throwable -> L15
        if (Intrinsics.areEqual(r101, "video_button") == false) goto L6;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        String r106 = "switch";
    L13:
        r104.put("limited_trigger", r106);     // Catch: Throwable -> L15
        r104.put("limited_type", r102);     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        r107 = null;
    L20:
        o r108 = o.f365780a;
        r108.reportEvent("to_limited_toast_show", (JSONObject) r107);
        return;
    L12:
        r106 = "entry";
        goto L13
    L6:
        if (Intrinsics.areEqual(r101, "voice_button") == true) goto L9;
        r105 = false;
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}

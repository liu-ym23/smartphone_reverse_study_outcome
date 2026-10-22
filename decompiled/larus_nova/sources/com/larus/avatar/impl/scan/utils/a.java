package com.larus.avatar.impl.scan.utils;

import com.ixigua.lib.track.TrackParams;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static final void a(boolean r110, VideoRecordStage r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r111, "stage");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        com.larus.platform.service.g r101 = com.larus.platform.service.g.f365738a;     // Catch: Throwable -> L20
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L20
        int r103 = 1;
        if (r110 == false) goto L6;
        int r104 = 1;
    L7:
        r102.put("is_success", r104);     // Catch: Throwable -> L20
        r102.put("stage", r111.getValue());     // Catch: Throwable -> L20
        if (r112 == null) goto L11;
        r102.put("error_code", r112.intValue());     // Catch: Throwable -> L20
    L11:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r101.monitorEventForSlardar("avatar_video_record_result", r102, new JSONObject(), new JSONObject());     // Catch: Throwable -> L20
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L20
        if (r110 == true) goto L15;
        r103 = 0;
    L15:
        r106.put("is_success", r103);     // Catch: Throwable -> L20
        r106.put("stage", r111.getValue());     // Catch: Throwable -> L20
        if (r112 == null) goto L18;
        r106.put("error_code", r112.intValue());     // Catch: Throwable -> L20
    L18:
        TrackParams r113 = new TrackParams().merge(r106);     // Catch: Throwable -> L20
        by7.a r114 = new by7.a("avatar_video_record_result");     // Catch: Throwable -> L20
        r114.f21463a.merge(r113);     // Catch: Throwable -> L20
        r114.b();     // Catch: Throwable -> L20
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        return;
    L6:
        r104 = 0;
    L20:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void b(boolean r110, int r111, Integer r112, Integer r113, int r114) {
        if ((r114 & 4) == 0) goto L6;
        r112 = null;
    L6:
        if ((r114 & 8) == 0) goto L25;
        r113 = null;
    L25:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L22
        com.larus.platform.service.g r101 = com.larus.platform.service.g.f365738a;     // Catch: Throwable -> L22
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L22
        if (r110 == false) goto L12;
        int r103 = 1;
    L13:
        r102.put("is_success", r103);     // Catch: Throwable -> L22
        if (r113 == null) goto L17;
        r102.put("error_code", r113.intValue());     // Catch: Throwable -> L22
    L17:
        r102.put("scene", "video_avatar_create");     // Catch: Throwable -> L22
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L22
        r105.put("file_size", r112);     // Catch: Throwable -> L22
        r105.put("duration", r111);     // Catch: Throwable -> L22
        r101.monitorEventForSlardar("avatar_video_upload_result", r102, r105, new JSONObject());     // Catch: Throwable -> L22
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L22
        r106.put("is_success", r110 ? 1 : 0);     // Catch: Throwable -> L22
        if (r113 == null) goto L20;
        r106.put("error_code", r113.intValue());     // Catch: Throwable -> L22
    L20:
        r106.put("scene", "video_avatar_create");     // Catch: Throwable -> L22
        r106.put("file_size", r112);     // Catch: Throwable -> L22
        r106.put("duration", r111);     // Catch: Throwable -> L22
        TrackParams r115 = new TrackParams().merge(r106);     // Catch: Throwable -> L22
        by7.a r116 = new by7.a("avatar_video_upload_result");     // Catch: Throwable -> L22
        r116.f21463a.merge(r115);     // Catch: Throwable -> L22
        r116.b();     // Catch: Throwable -> L22
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return;
    L12:
        r103 = 0;
    L22:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}

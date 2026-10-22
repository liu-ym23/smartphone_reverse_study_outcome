package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvapi.model.KtvSeiModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        ALogger.i("ttlive_ktv_karaoke_video_chorus", "videoChorusLog, " + r2 + ", " + r3);
    }

    public static final void a(String r9, String r10, String r11, Function1<? super KtvSeiModel, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "sei");
        Intrinsics.checkNotNullParameter(r10, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r11, "source");
    L12:
        e = move-exception;
        b(r10, "onSei, Error parsing JSON in sei: " + r9 + ", Error: " + e.getMessage());
        return;
    L4:
        if (StringsKt.indexOf$default(r9, "ktv_sei", 0, false, 6, null) == (-1)) goto L17;
        JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r9), "ktv_sei");     // Catch: Exception -> L12
        if (r12 != null) goto L8;
    L10:
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L12
        r14.put("ktv_sei", r13);     // Catch: Exception -> L12
        String r15 = r14.toString();     // Catch: Exception -> L12
        int r16 = ee2.a.a;     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter("realtime_chorus", "businessId");     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(r15, "sei");     // Catch: Exception -> L12
        JsonObject r0 = new JsonObject();     // Catch: Exception -> L12
        r0.addProperty("sei", r15);     // Catch: Exception -> L12
        r0.addProperty("current_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L12
        ee2.a.c("realtime_chorus", "onSeiReceiver", r0);     // Catch: Exception -> L12
        return;
    L8:
        if (((Boolean) KtvSettingHelper.Y0.getValue()).booleanValue() == false) goto L10;
        r12.invoke((KtvSeiModel) GsonHelper.getDefault().fromJson(StringsKt.trim(r13.toString(), new char[]{'\"'}), KtvSeiModel.class));     // Catch: Exception -> L12
        goto L10
    }
}

package com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ui6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/JsonObject;", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class ChorusJsbService$actionGetHandlers$5 extends FunctionReferenceImpl implements Function1<JsonObject, JsonObject> {
    public ChorusJsbService$actionGetHandlers$5(ChorusJsbService r8) {
        super(1, r8, ChorusJsbService.class, "getNtpTime", "getNtpTime(Lcom/google/gson/JsonObject;)Lcom/google/gson/JsonObject;", 0);
    }

    public final JsonObject invoke(JsonObject r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        ChorusJsbService r8 = (ChorusJsbService) ((CallableReference) this).receiver;
        int r0 = ChorusJsbService.l;
        r8.getClass();
        JsonObject r1 = new JsonObject();
        ei6.a r9 = r8.d();
        if (r9 == null) goto L10;
        d r10 = r9.l();
        if (r10 == null) goto L10;
        mi6.a r11 = r10.b();
        if (r11 == null) goto L10;
        r11.v();
    L10:
        if (KtvSettingHelper.p().getEnableLocalNtpTime() == false) goto L12;
        long r2 = e.a();
        ALogger.i("ChorusJsbService", "getNtpTime, use local ntp time: " + r2);
    L13:
        r1.addProperty("ntp_time", Long.valueOf(r2));
        r1.addProperty("current_time", Long.valueOf(System.currentTimeMillis()));
        ALogger.i("ChorusJsbService", "getNtpTime, ntp: " + r2);
        return r1;
    L12:
        r2 = 0;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((JsonObject) r1);
    }
}

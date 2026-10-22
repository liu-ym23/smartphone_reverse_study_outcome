package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.app.Activity;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(Activity r1, JSONObject r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
            int r1 = ECSdk.a;     // Catch: Throwable -> L8
            o r2 = (o) ECSdk.a(o.class);     // Catch: Throwable -> L8
            if (r2 == null) goto L5;
            Activity r3 = this.a;     // Catch: Throwable -> L8
            String r5 = this.b.toString();     // Catch: Throwable -> L8
            JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
            r4.put("roomId", this.c);     // Catch: Throwable -> L8
            r4.put("methodName", this.d);     // Catch: Throwable -> L8
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L8
            r2.c(r3, "live_room_controller", "live_room_controller", r5, r4.toString(), VmSdkSetting.a().h());     // Catch: Throwable -> L8
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L8
        L6:
            Result.constructor-impl(r7);     // Catch: Throwable -> L8
            return;
        L5:
            r7 = null;
        L8:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static void a(String r3, String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        Intrinsics.checkNotNullParameter(r5, "params");
        if (ECLiveABUtils.INSTANCE.getENABLE_EC_LIVE_CONTROLLER_MONITOR() == true) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Activity r1 = ECAppInfoService.e.a();     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        oh.a.c("liveController", new a(r1, r5, r3, r4));     // Catch: Throwable -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r6);     // Catch: Throwable -> L11
        return;
    L8:
        r6 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}

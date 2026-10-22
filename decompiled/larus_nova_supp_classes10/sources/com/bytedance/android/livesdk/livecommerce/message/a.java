package com.bytedance.android.livesdk.livecommerce.message;

import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int i = 0;
    public boolean a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public String g;
    public String h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.message.a$a, reason: collision with other inner class name */
    public static final class C0078a {
        @JvmStatic
        public static a a(sg2.b r6) {
            if (r6 == null) goto L15;
            TraceTimeMetricV2 r0 = r6.d;
            if (r0 == null) goto L15;
            if (r0.getOpTimestamp() <= 0) goto L15;
            if (r0.getMsgSendTimestamp() <= 0) goto L15;
            a r1 = new a();
            r1.b = r0.getOpTimestamp();
            r1.c = r0.getProducerDuration();
            r1.d = r0.getConsumerDuration();
            r1.e = r0.getMsgSendTimestamp();
            String r7 = r6.b;
            if (r7 != null) goto L14;
            r7 = "";
        L14:
            r1.g = r7;
            return r1;
        L15:
            return null;
        }
    }

    static {
    }

    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        long r0 = System.currentTimeMillis();
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L10
        r2.put(LocationMonitorConst.TYPE, this.g);     // Catch: Exception -> L10
        r2.put("scene", this.h);     // Catch: Exception -> L10
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L10
        r3.put("duration", r0 - this.b);     // Catch: Exception -> L10
        r3.put("duration_added", ((this.c + this.d) + r0) - this.e);     // Catch: Exception -> L10
        r3.put("business_duration", this.c);     // Catch: Exception -> L10
        r3.put("message_duration", this.d);     // Catch: Exception -> L10
        r3.put("live_message_center_duration", this.f - this.e);     // Catch: Exception -> L10
        r3.put("render_duration", r0 - this.f);     // Catch: Exception -> L10
        int r1 = ECSdk.a;     // Catch: Exception -> L10
        pi.b r4 = (pi.b) ECSdk.a(pi.b.class);     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        r4.monitorEvent("live_ec_update_message_duration", r2, r3, null);     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    public a() {
        this.g = "";
        this.h = "";
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.f = System.currentTimeMillis();
        this.h = r3;
    }
}

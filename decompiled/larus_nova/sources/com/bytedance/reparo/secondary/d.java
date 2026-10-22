package com.bytedance.reparo.secondary;

import android.text.TextUtils;
import com.bytedance.crash.Npth;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.exception.JavaLoadException;
import com.bytedance.reparo.core.exception.PatchDownloadException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.exception.PatchInstallException;
import com.bytedance.reparo.core.exception.PatchLoadException;
import com.bytedance.reparo.core.exception.SoLoadException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.im.internal.network.proto2.AvCmd;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements PatchEventReporter.c {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Event f267476a;

        public final void a() {
            com.bytedance.reparo.g.a().getClass();
            Event r100 = this.f267476a;
            SDKMonitor r101 = MonitorService.f267465a;
            String r102 = r100.f267344c;
            if (TextUtils.isEmpty(r102) == true) goto L16;
            HashMap r103 = (HashMap) MonitorService.f267466b;
            if (TextUtils.isEmpty((CharSequence) r103.get(r102)) == true) goto L16;
            String r104 = (String) r103.get(r102);
            JSONObject r105 = r100.d();     // Catch: Throwable -> L14
            JSONObject r106 = r100.b();     // Catch: Throwable -> L14
            MonitorService.b(r106);     // Catch: Throwable -> L14
            JSONObject r110 = r100.c();     // Catch: Throwable -> L14
            SDKMonitor r107 = MonitorService.c();     // Catch: Throwable -> L14
            if (r100.f267348g == false) goto L11;
            int r108 = 1;
        L12:
            r107.monitorStatusAndEvent(r104, r108, r106, r105, r110);     // Catch: Throwable -> L14
            goto L22
        L11:
            r108 = r100.f267349h;     // Catch: Throwable -> L14
        L22:
            Event r109 = this.f267476a;
            String r111 = r109.f267344c;
            r111.getClass();
            int r112 = r111.hashCode();
            if (r112 == (-638342497)) goto L38;
            if (r112 == 1275480701) goto L34;
            if (r112 == 1890919588) goto L30;
        L39:
            byte r113 = -1;
        L42:
            if (r113 == 0) goto L97;
            if (r113 == 1) goto L70;
            if (r113 == 2) goto L47;
            return;
        L47:
            if (r109.f267348g == true) goto L137;
            long r114 = System.currentTimeMillis();
            JSONObject r115 = new JSONObject();
            HashMap<String, Object> r116 = r109.f();     // Catch: JSONException -> L67
            if (r109.f267352k != null) goto L54;
            r109.f267352k = new HashMap();     // Catch: JSONException -> L67
        L54:
            if (r109.f267354m != null) goto L56;
            r109.f267354m = new HashMap();     // Catch: JSONException -> L67
        L56:
            r115.putOpt("timestamp", Long.valueOf(r114));     // Catch: JSONException -> L67
            r115.putOpt("better_name", r116.get("patch_id"));     // Catch: JSONException -> L67
            r115.putOpt("version_code", r116.get("patch_version"));     // Catch: JSONException -> L67
            PatchException r117 = r109.f267350i;     // Catch: JSONException -> L67
            if (r117 != null) goto L60;
        L64:
            int r118 = 12000;
        L65:
            r115.putOpt("status", Integer.valueOf(r118));     // Catch: JSONException -> L67
            r115.putOpt("error_msg", r109.h());     // Catch: JSONException -> L67
        L69:
            MonitorService.c().monitorCommonLog("bd_better_monitor", r115);
            return;
        L60:
            if ((r117 instanceof PatchInstallException) == false) goto L64;
            if (r117.getErrorCode() != 1) goto L64;
            r118 = AvCmd.CommandEventType.TTS_PLAYBACK_RESUME_VALUE;
        L67:
            e = move-exception;
            e.printStackTrace();
            goto L69
        L137:
            return;
        L70:
            JSONObject r119 = new JSONObject();
            HashMap<String, Object> r120 = r109.f();     // Catch: JSONException -> L93
            r119.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: JSONException -> L93
            r119.putOpt("better_name", r120.get("patch_id"));     // Catch: JSONException -> L93
            r119.putOpt("version_code", r120.get("patch_version"));     // Catch: JSONException -> L93
            if (r109.f267348g == false) goto L76;
            r119.putOpt("status", 21000);     // Catch: JSONException -> L93
            long r121 = r109.g();     // Catch: JSONException -> L93
            if (r121 == (-1)) goto L95;
            r119.putOpt("duration", Long.valueOf(r121));     // Catch: JSONException -> L93
        L95:
            MonitorService.c().monitorCommonLog("bd_better_monitor", r119);
            return;
        L76:
            PatchException r122 = r109.f267350i;     // Catch: JSONException -> L93
            if (r122 != null) goto L80;
        L90:
            int r123 = 22000;
        L91:
            r119.putOpt("status", Integer.valueOf(r123));     // Catch: JSONException -> L93
            r119.putOpt("error_msg", r109.h());     // Catch: JSONException -> L93
            goto L95
        L80:
            if ((r122 instanceof PatchLoadException) == false) goto L90;
            if ((r122 instanceof JavaLoadException) == false) goto L85;
            r123 = 22008;
            goto L91
        L85:
            if ((r122 instanceof SoLoadException) == false) goto L90;
            if (r122.getErrorCode() != 300) goto L89;
            r123 = 22009;
            goto L91
        L89:
            r123 = 22010;
        L93:
            e = move-exception;
            e.printStackTrace();
            goto L95
        L97:
            if (r109.f267348g == true) goto L130;
        L102:
            long r124 = System.currentTimeMillis();
            JSONObject r125 = new JSONObject();
            HashMap<String, Object> r126 = r109.f();     // Catch: JSONException -> L122
            r125.putOpt("timestamp", Long.valueOf(r124));     // Catch: JSONException -> L122
            r125.putOpt("better_name", r126.get("patch_id"));     // Catch: JSONException -> L122
            r125.putOpt("version_code", r126.get("patch_version"));     // Catch: JSONException -> L122
            if (r109.f267348g == false) goto L108;
            r125.putOpt("status", 11000);     // Catch: JSONException -> L122
            long r127 = r109.g();     // Catch: JSONException -> L122
            if (r127 == (-1)) goto L124;
            r125.putOpt("duration", Long.valueOf(r127));     // Catch: JSONException -> L122
        L124:
            MonitorService.c().monitorCommonLog("bd_better_monitor", r125);
            return;
        L108:
            PatchException r128 = r109.f267350i;     // Catch: JSONException -> L122
            if (r128 != null) goto L112;
        L119:
            int r129 = 12000;
        L120:
            r125.putOpt("status", Integer.valueOf(r129));     // Catch: JSONException -> L122
            r125.putOpt("error_msg", r109.h());     // Catch: JSONException -> L122
            goto L124
        L112:
            if ((r128 instanceof PatchDownloadException) == false) goto L119;
            if (((PatchDownloadException) r128).getErrorCode() != 1) goto L117;
            r129 = 12001;
            goto L120
        L117:
            if ((r128.getCause() instanceof SocketTimeoutException) == false) goto L119;
            r129 = 12006;
        L122:
            e = move-exception;
            e.printStackTrace();
            goto L124
        L130:
            com.bytedance.reparo.secondary.a.a(true, 11000);     // Catch: Throwable -> L100
        L100:
            th = move-exception;
            Logger.b("AppMonitorService", "report local patch list failed. ", th);
            goto L102
        L30:
            if (r111.equals("patch_install") == false) goto L39;
            r113 = 2;
            goto L42
        L34:
            if (r111.equals("patch_load") == false) goto L39;
            r113 = 1;
            goto L42
        L38:
            if (r111.equals("patch_download") == false) goto L39;
            r113 = 0;
        L16:
            if (r100.f267348g == false) goto L18;
            r100.toString();
            Logger.c();
            goto L22
        L18:
            PatchException r130 = r100.f267350i;
            if (r130 == null) goto L21;
            Logger.b("MonitorService", r100.f267344c, r130);
            goto L22
        L21:
            String r131 = r100.toString();
            Logger.f267463a.e(r131);
            goto L22
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

        public a(Event r100) {
            this.f267476a = r100;
        }
    }

    public d() {
    }

    @Override // com.bytedance.reparo.core.PatchEventReporter.c
    public final void a(Event r100) {
        e97.c.a().execute(new a(r100));
        if ("patch_load".equals(r100.f267344c) == false) goto L13;
        String r101 = String.valueOf(r100.f().get("patch_id"));
        if (i.f267487a == true) goto L14;
        ConcurrentLinkedQueue<Runnable> r102 = com.bytedance.reparo.j.f267458a;
        Npth.addTag("reparo_patch_id", r101);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L14:
        return;
    }
}

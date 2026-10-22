package k78;

import android.app.Application;
import android.os.SystemClock;
import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.report.h;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import m58.s;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f502041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f502044d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<String, JSONObject, Unit> f502045e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f502046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f502047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f502048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f502049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f502050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f502051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f502052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f502053m;

    @Override // com.larus.audio.report.h
    public final void q() {
        this.f502050j = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.audio.report.h
    public final void s() {
        this.f502049i = SystemClock.elapsedRealtime();
    }

    public final void a(JSONObject r100) {
        r100.put("is_business_resend", this.f502051k);
        r100.put("bot_id", this.f502044d);
        r100.put("conversation_id", this.f502043c);
        r100.put("task_id", this.f502042b);
        m58.b r101 = m58.h.f512140k;
        if (r101 == null) goto L5;
        long r102 = r101.b();
    L7:
        if (r102 <= (-1)) goto L12;
        long r103 = this.f502053m;
        if (r103 <= 0) goto L13;
        r100.put("time_interval_from_cold_start", r103 - r102);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = -1;
        goto L7
    }

    public final void b(boolean r100) {
        this.f502051k = r100;
        IAudioEventCommonParams r101 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r101 == null) goto L9;
        x58.a r102 = m58.h.f512130a;
        m58.b r103 = m58.h.f512140k;
        if (r103 == null) goto L7;
        Application r104 = r103.getApplication();
    L8:
        r101.b(r104);
        goto L9
    L7:
        r104 = null;
    L9:
        x58.a r105 = m58.h.f512130a;
        s r106 = m58.h.f512131b;
        if (r106 == null) goto L12;
        JSONObject r107 = new JSONObject();
        this.f502053m = SystemClock.elapsedRealtime();
        a(r107);
        this.f502045e.invoke("flow_im_asr_start", r107);
        r107.put("user_press_to_start_task_duration", this.f502053m - this.f502041a);
        Unit r108 = Unit.INSTANCE;
        r106.report("flow_im_asr_start", r107);
    L12:
        IAudioDeviceMonitorReporter r109 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);
        if (r109 == null) goto L16;
        r109.a(AudioDeviceMonitorScenes.ASR);
        return;
    }

    @Override // com.larus.audio.report.h
    public final void n(boolean r100) {
        if (this.f502048h == true) goto L5;
        this.f502047g = SystemClock.elapsedRealtime();
        this.f502048h = r100;
    L5:
        this.f502046f = SystemClock.elapsedRealtime();
    }

    @Override // com.larus.audio.report.h
    public final void o(boolean r100) {
        x58.a r101 = m58.h.f512130a;
        s r102 = m58.h.f512131b;
        if (r102 == null) goto L5;
        JSONObject r103 = new JSONObject();
        a(r103);
        this.f502045e.invoke("flow_im_asr_end", r103);
        r103.put("result", 2);
        r103.put("is_from_server", r100);
        r103.put("is_stream_asr", this.f502048h);
        Unit r104 = Unit.INSTANCE;
        r102.report("flow_im_asr_end", r103);
    L5:
        IAudioEventCommonParams r105 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r105 == null) goto L9;
        r105.disable();
        return;
    }

    @Override // com.larus.audio.report.h
    public final void p(int r100) {
        if (this.f502052l != 0) goto L8;
        this.f502052l = SystemClock.elapsedRealtime();
        x58.a r101 = m58.h.f512130a;
        s r102 = m58.h.f512131b;
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        a(r103);
        this.f502045e.invoke("asr_client_start_up", r103);
        r103.put("press_to_recorde_first_pkg_duration", this.f502050j - this.f502041a);
        r103.put("recorde_first_pkg_to_send_first_pkg_duration", this.f502052l - this.f502050j);
        r103.put("duration", this.f502052l - this.f502041a);
        r103.put("retry_times", r100);
        Unit r104 = Unit.INSTANCE;
        r102.report("asr_client_start_up", r103);
        return;
    L9:
        return;
    }

    @Override // com.larus.audio.report.h
    public final void t(y58.b r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "result");
        s r100 = m58.h.f512131b;
        if (r100 == null) goto L45;
        JSONObject r101 = new JSONObject();
        a(r101);
        this.f502045e.invoke("flow_im_asr_end", r101);
        boolean r102 = true;
        if (r111 != null) goto L7;
    L10:
        boolean r112 = true;
    L11:
        r101.put("is_content_recognized", !r112);
        r101.put("result", 0);
        r101.put("tail_pkg_duration", this.f502046f - this.f502049i);
        if (this.f502048h == false) goto L14;
        long r103 = this.f502047g - this.f502049i;
    L15:
        r101.put("tail_pkg_duration_stream", r103);
        r101.put("is_stream_asr", this.f502048h);
        y58.c r113 = r110.f566276i;
        if (r113 == null) goto L44;
        String r114 = r113.f566278b;
        if (r114 == null) goto L44;
        if (r114.length() > 0) goto L23;
        r102 = false;
    L23:
        String r104 = null;
        if (r102 == true) goto L27;
        r114 = null;
    L27:
        if (r114 == null) goto L44;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L35
        JSONObject r115 = new JSONArray(r114).optJSONObject(0);     // Catch: Throwable -> L35
        if (r115 == null) goto L32;
        String r116 = r115.optString("aed_res");     // Catch: Throwable -> L35
    L33:
        Object r117 = Result.m9449constructorimpl(r101.put("aed_res", r116));     // Catch: Throwable -> L35
    L37:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r117);
        if (r106 == null) goto L43;
        int r107 = c68.b.f22600a;
        StringBuilder r108 = new StringBuilder("onAsrSuccess, Parse aed_res error: ");
        y58.c r118 = r110.f566276i;
        if (r118 == null) goto L42;
        r104 = r118.f566278b;
    L42:
        r108.append(r104);
        c68.b.c("AsrTracer", r108.toString(), r106);
    L43:
        Result.m9448boximpl(r117);
        goto L44
    L32:
        r116 = null;
    L35:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        Unit r119 = Unit.INSTANCE;
        r100.report("flow_im_asr_end", r101);
        goto L45
    L14:
        r103 = 0;
        goto L15
    L7:
        if (r111.length() == 0) goto L10;
        r112 = false;
    L45:
        IAudioEventCommonParams r120 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r120 == null) goto L51;
        r120.disable();
        return;
    }

    @Override // com.larus.audio.report.h
    public final void r(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        x58.a r103 = m58.h.f512130a;
        s r104 = m58.h.f512131b;
        if (r104 == null) goto L5;
        JSONObject r105 = new JSONObject();
        a(r105);
        this.f502045e.invoke("flow_im_asr_end", r105);
        r105.put("result", 1);
        r105.put("error_code", r100);
        r105.put("error_msg", r101);
        r105.put("server_error_code", r102);
        r105.put("is_stream_asr", this.f502048h);
        Unit r106 = Unit.INSTANCE;
        r104.report("flow_im_asr_end", r105);
    L5:
        IAudioEventCommonParams r107 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        if (r107 == null) goto L9;
        r107.disable();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(long r100, String r101, String r102, String r103, Function2<? super String, ? super JSONObject, Unit> r104) {
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "convId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r104, "appendBizParamsCallback");
        this.f502041a = r100;
        this.f502042b = r101;
        this.f502043c = r102;
        this.f502044d = r103;
        this.f502045e = r104;
    }
}

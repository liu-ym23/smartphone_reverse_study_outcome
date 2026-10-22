package com.ss.android.vesdk.audio;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ttve.model.VEAudioDeviceType;
import com.ss.android.ttve.nativePort.TESystemUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.vesdk.VEAudioCaptureSettings;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VELogUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements com.ss.android.vesdk.audio.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f455735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f455736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f455737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f455738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f455739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TEAudioRecord f455740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f455741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f455742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PthreadHandlerThreadV2 f455743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConditionVariable f455744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f455745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f455746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f455747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f455748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f455749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f455750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VEAudioDevice f455751q;

    public static class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<f> f455752a;

        public a(f r100) {
            this.f455752a = new WeakReference(r100);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r110) {
            int r100 = r110.what;
            Object r101 = r110.obj;
            f r102 = this.f455752a.get();
            if (r102 != null) goto L6;
            VELogUtil.e("TEAudioCaptureProxy", "audio capture is null");
            return false;
        L6:
            long r103 = System.currentTimeMillis();
            if (r100 != 0) goto L9;
            VEAudioCaptureSettings r104 = (VEAudioCaptureSettings) r101;
            if (r102.f455735a == 0) goto L55;
            VELogUtil.d("TEAudioCaptureProxy", "init in a error state: " + r102.f455735a);
            int r111 = -105;
        L79:
            VELogUtil.i("TEAudioCaptureProxy", "init mic:" + r111);
        L80:
            return false;
        L55:
            if (r102.f455740f != null) goto L64;
            VEConfigCenter.getInstance().getValue("ve_enable_common_earback", true).booleanValue();
            VEAudioDevice r105 = r102.f455751q;
            if (r105 == null) goto L59;
            int r106 = r105.getType().ordinal();
        L61:
            if (r106 != VEAudioDeviceType.BLUETOOTH.ordinal()) goto L63;
            com.ss.android.ttve.monitor.i.f(0, "te_record_audio_earback_type", 4);
        L63:
            r104.isLowLatency();
            TEAudioRecord r107 = new TEAudioRecord(new g());
            r102.f455740f = r107;
            r107.setAudioCallback(new e(r102));
            r102.f455740f.setHandler(r102.f455742h);
            goto L64
        L59:
            r106 = TESystemUtils.getOutputAudioDeviceType();
        L64:
            r102.f455740f.setNativeAudioDataCallback(r102.f455739e);
            r111 = r102.f455740f.init(r104);
            r102.f455735a = 1;
            if (r111 == 0) goto L71;
            r102.c(r102.f455748n);
            if (r102.f455745k.get() == true) goto L71;
            int r108 = r102.f455746l;
            if (r108 <= 0) goto L71;
            r102.f455746l = r108 - 1;
            r102.f(0, r104, 30);
        L71:
            if (r111 == 0) goto L75;
            if (r102.f455746l == 0) goto L75;
        L78:
            VELogUtil.i("TEAudioCaptureProxy", "retry int mic times : " + r102.f455746l + " ret: " + r111);
        L75:
            if (r102.f455746l != 0) goto L77;
            r102.f455741g.onError(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT, VEInfo.TE_ERROR_RECORD_AUDIO_CAPTURE_INIT, "use up retry init times");
        L77:
            com.ss.android.ttve.monitor.i.f(0, "te_record_audio_mic_init_ret", r111);
            goto L78
        L9:
            if (r100 == 1) goto L21;
            if (r100 != 2) goto L12;
            JSONObject r109 = new JSONObject();
            r109.put("time", r103);     // Catch: JSONException -> L18
            r109.put("state", 0);     // Catch: JSONException -> L18
        L20:
            com.ss.android.ttve.monitor.c.a("vesdk_event_will_stop_mic", r109, "behavior");
            int r112 = r102.d(r101);
            a("vesdk_event_did_stop_mic", r103, Integer.valueOf(r112));
            VELogUtil.i("TEAudioCaptureProxy", "stop mic:" + r112);
        L18:
            e = move-exception;
            e.printStackTrace();
            goto L20
        L12:
            if (r100 == 3) goto L14;
            VELogUtil.e("TEAudioCaptureProxy", "mic msg error");
            goto L80
        L14:
            r102.f455746l = 0;
            r102.f455747m = 0;
            r102.c(r101);
            VELogUtil.i("TEAudioCaptureProxy", "release mic");
            goto L80
        L21:
            JSONObject r113 = new JSONObject();
            r113.put("time", r103);     // Catch: JSONException -> L24
            r113.put("state", 0);     // Catch: JSONException -> L24
        L26:
            com.ss.android.ttve.monitor.c.a("vesdk_event_will_start_mic", r113, "behavior");
            long r114 = System.currentTimeMillis();
            if (r102.f455735a == 1) goto L30;
            VELogUtil.d("TEAudioCaptureProxy", "start in a error state: " + r102.f455735a);
        L37:
            int r115 = -105;
        L50:
            a("vesdk_event_did_start_mic", r103, Integer.valueOf(r115));
            VELogUtil.i("TEAudioCaptureProxy", "start mic:" + r115);
            goto L80
        L30:
            if (r102.f455737c == true) goto L32;
        L34:
            TEAudioRecord r116 = r102.f455740f;
            if (r116 != null) goto L38;
            VELogUtil.e("TEAudioCaptureProxy", "mic start error, audio record is null");
            goto L37
        L38:
            int r117 = r116.start(r101);
            r102.f455735a = 2;
            if (r117 == (-2)) goto L48;
            if (r117 == 0) goto L48;
            r102.d(r102.f455748n);
            if (r102.f455745k.get() == false) goto L45;
        L47:
            r102.f455741g.onError(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_INIT, VEInfo.TE_ERROR_RECORD_AUDIO_CAPTURE_START, "use up retry start times");
            com.ss.android.ttve.monitor.i.f(0, "te_record_audio_mic_start_ret", r117);
        L49:
            int r118 = r102.f455747m;
            long r119 = System.currentTimeMillis() - r114;
            r102.f455749o.put("micStartRet" + r118, Integer.valueOf(r117));
            r102.f455749o.put("micStartCost" + r118, Long.valueOf(r119));
            r115 = r117;
            goto L50
        L45:
            if (r102.f455747m <= 0) goto L47;
            VELogUtil.e("TEAudioCaptureProxy", "retry start mic times : " + r102.f455747m + " ret: " + r117);
            r102.f455747m = r102.f455747m - 1;
            r102.f(1, r102.f455748n, 30);
        L48:
            r102.f455741g.a(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_START, r117, null);
            com.ss.android.ttve.monitor.i.f(0, "te_record_audio_mic_start_ret", 0);
            goto L49
        L32:
            if (r102.f455736b == false) goto L34;
            VELogUtil.e("TEAudioCaptureProxy", "in background block start");
            r115 = -1;
            r102.f455741g.a(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_START, -1, null);
        L24:
            e = move-exception;
            e.printStackTrace();
            goto L26
        }

        public static void a(String r100, long r101, Integer r102) {
            JSONObject r103 = new JSONObject();
            long r104 = System.currentTimeMillis();
            r103.put("time", r101);     // Catch: JSONException -> L5
            r103.put("state", r102);     // Catch: JSONException -> L5
            r103.put("duration", r104 - r101);     // Catch: JSONException -> L5
        L8:
            if (VEConfigCenter.getInstance().getValue("ve_enable_report_business", false).booleanValue() == false) goto L10;
            com.ss.android.ttve.monitor.c.b(r100, r103, "behavior", false, true);
            return;
        L10:
            com.ss.android.ttve.monitor.c.a(r100, r103, "behavior");
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }
    }

    public final synchronized void b() {
        monitor-enter(this);
        PthreadHandlerThreadV2 r100 = this.f455743i;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.quitSafely();     // Catch: Throwable -> L8
        this.f455743i = null;     // Catch: Throwable -> L8
        this.f455742h = null;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized Handler a() {
        monitor-enter(this);
        PthreadHandlerThreadV2 r100 = this.f455743i;     // Catch: Throwable -> L10 Exception -> L12
        if (r100 == null) goto L7;
        r100.quit();     // Catch: Throwable -> L10 Exception -> L12
    L7:
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("TEAudioCaptureProxy");     // Catch: Throwable -> L10 Exception -> L12
        this.f455743i = r101;     // Catch: Throwable -> L10 Exception -> L12
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L10 Exception -> L12
        Handler r102 = new Handler(this.f455743i.getLooper(), new a(this));     // Catch: Throwable -> L10 Exception -> L12
        monitor-exit(this);
        return r102;
    L12:
        e = move-exception;
        VELogUtil.e("TEAudioCaptureProxy", "CreateHandler failed!: " + e.toString());     // Catch: Throwable -> L10
        if (Looper.myLooper() == null) goto L16;
        Looper r103 = Looper.myLooper();     // Catch: Throwable -> L10
    L17:
        return new Handler(r103, new a(this));
    L16:
        r103 = Looper.getMainLooper();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public f() {
        this.f455735a = 0;
        this.f455736b = false;
        this.f455737c = false;
        this.f455738d = 0;
        this.f455739e = null;
        this.f455744j = new ConditionVariable();
        this.f455745k = new AtomicBoolean(false);
        this.f455746l = 3;
        this.f455747m = 3;
        this.f455748n = null;
        this.f455749o = new ConcurrentHashMap();
        this.f455750p = new Object();
        this.f455738d = VEConfigCenter.getInstance().getValue("ve_release_mic_timeout", 0);
        boolean r100 = VEConfigCenter.getInstance().getValue("ve_enable_background_strategy", false).booleanValue();
        this.f455737c = r100;
        VELogUtil.d("TEAudioCaptureProxy", "KEY_ENABLE_BACKGROUND_STRATEGY : " + r100);
    }

    public final void c(Object r100) {
        Object r101 = this.f455750p;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f455735a != 2) goto L7;
        d(r100);     // Catch: Throwable -> L13
    L7:
        TEAudioRecord r102 = this.f455740f;     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        r102.release(r100);     // Catch: Throwable -> L13
        this.f455740f = null;     // Catch: Throwable -> L13
    L10:
        this.f455745k.set(false);     // Catch: Throwable -> L13
        this.f455744j.open();     // Catch: Throwable -> L13
        this.f455735a = 0;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public final int d(Object r100) {
        Object r101 = this.f455750p;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f455735a == 2) goto L9;
        VELogUtil.e("TEAudioCaptureProxy", "mic stop in error state: " + this.f455735a);     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return -105;
    L9:
        TEAudioRecord r102 = this.f455740f;     // Catch: Throwable -> L17
        if (r102 != null) goto L14;
        VELogUtil.e("TEAudioCaptureProxy", "mic stop error, audio record is null");     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return -105;
    L14:
        int r103 = r102.stop(r100);     // Catch: Throwable -> L17
        this.f455741g.a(VEInfo.TE_INFO_RECORD_AUDIO_CAPTURE_STOP, r103, null);     // Catch: Throwable -> L17
        this.f455735a = 1;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return r103;
    }

    @Override // com.ss.android.vesdk.audio.a
    public final synchronized int init(VEAudioCaptureSettings r100) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f455742h != null) goto L6;
        this.f455742h = a();     // Catch: Throwable -> L13
        this.f455746l = 3;     // Catch: Throwable -> L13
        this.f455747m = 3;     // Catch: Throwable -> L13
        e(0, r100);     // Catch: Throwable -> L13
        monitor-exit(this);
        return 0;
    L6:
        if (this.f455738d <= 0) goto L8;
        this.f455746l = 3;     // Catch: Throwable -> L13
        this.f455747m = 3;     // Catch: Throwable -> L13
        e(0, r100);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return 0;
    }

    @Override // com.ss.android.vesdk.audio.a
    public final synchronized void release(Object r110) {
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.f455742h != null) goto L9;
        VELogUtil.w("TEAudioCaptureProxy", "release, mHandler is null!");     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L9:
        this.f455745k.set(true);     // Catch: Throwable -> L31
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L31
        this.f455744j.close();     // Catch: Throwable -> L31
        this.f455742h.removeCallbacksAndMessages(null);     // Catch: Throwable -> L31
        e(3, r110);     // Catch: Throwable -> L31
        int r101 = this.f455738d;     // Catch: Throwable -> L31
        if (r101 <= 0) goto L12;
        long r102 = r101;
        VELogUtil.i("TEAudioCaptureProxy", "configured timeout is " + this.f455738d);     // Catch: Throwable -> L31
    L13:
        this.f455744j.block(r102);     // Catch: Throwable -> L31
        long r103 = System.currentTimeMillis() - r100;     // Catch: Throwable -> L31
        VELogUtil.i("TEAudioCaptureProxy", "mic release cost: " + r103 + "ms");     // Catch: Throwable -> L31
        if (r103 < r102) goto L17;
        VELogUtil.e("TEAudioCaptureProxy", "mic release timeout");     // Catch: Throwable -> L31
    L17:
        if (this.f455738d != 0) goto L25;
        if (this.f455745k.get() == true) goto L21;
    L23:
        b();     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return;
    L21:
        if (this.f455740f == null) goto L23;
        c(r110);     // Catch: Throwable -> L31
        goto L23
    L25:
        if (this.f455745k.get() == false) goto L29;
        if (this.f455740f == null) goto L29;
        e(3, r110);     // Catch: Throwable -> L31
        this.f455744j.block();     // Catch: Throwable -> L31
        goto L29
    L12:
        r102 = 2000;
        goto L13
    }

    @Override // com.ss.android.vesdk.audio.a
    public final int start(Object r100) {
        if (this.f455742h != null) goto L6;
        VELogUtil.e("TEAudioCaptureProxy", "start, mHandler is null!");
        return -108;
    L6:
        this.f455748n = r100;
        e(1, r100);
        return 0;
    }

    @Override // com.ss.android.vesdk.audio.a
    public final int stop(Object r100) {
        if (this.f455742h != null) goto L6;
        VELogUtil.e("TEAudioCaptureProxy", "stop, mHandler is null!");
        return -108;
    L6:
        com.ss.android.ttve.monitor.i.g(0, "te_record_audio_mic_start_info", this.f455749o.toString());
        e(2, r100);
        return 0;
    }

    public final void e(int r100, Object r101) {
        f(r100, r101, 0);
    }

    public final synchronized void f(int r100, Object r101, long r102) {
        monitor-enter(this);
        Handler r103 = this.f455742h;     // Catch: Throwable -> L17
        if (r103 != null) goto L9;
        VELogUtil.i("TEAudioCaptureProxy", "send MSG error mHandler is null");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L9:
        if (r103.hasMessages(r100) == false) goto L11;
        this.f455742h.removeMessages(r100);     // Catch: Throwable -> L17
    L11:
        Message r104 = Message.obtain();     // Catch: Throwable -> L17
        r104.obj = r101;     // Catch: Throwable -> L17
        r104.what = r100;     // Catch: Throwable -> L17
        if (r102 > 0) goto L14;
        this.f455742h.sendMessage(r104);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        this.f455742h.sendMessageDelayed(r104, r102);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}

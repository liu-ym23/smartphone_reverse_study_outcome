package com.ss.android.bytedcert.face;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.byted.cast.common.bean.State;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class FaceDetectionRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ksa.e f407327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f407328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f407329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f407330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f407331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile RecordState f407332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f407333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f407334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f407335i;

    public static final enum RecordState extends Enum<RecordState> {
        public static final RecordState RECORDING = null;
        public static final RecordState STARTING = null;
        public static final RecordState STOPPING = null;
        public static final RecordState WAIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecordState[] f407336a = null;

        static {
            RecordState r100 = new RecordState("WAIT", 0);
            WAIT = r100;
            RecordState r101 = new RecordState("STARTING", 1);
            STARTING = r101;
            RecordState r102 = new RecordState(State.RECORDING, 2);
            RECORDING = r102;
            RecordState r103 = new RecordState("STOPPING", 3);
            STOPPING = r103;
            f407336a = new RecordState[]{r100, r101, r102, r103};
        }

        public static RecordState[] values() {
            return (RecordState[]) f407336a.clone();
        }

        public static RecordState valueOf(String r100) {
            return (RecordState) r27.a.a(RecordState.class, r100);
        }

        public RecordState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f407337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BDResponse f407338b;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f407337a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            w.f r101 = (w.f) r100;     // Catch: Throwable -> L6
            r101.a(this.f407338b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(c r100, BDResponse r101) {
            this.f407337a = r100;
            this.f407338b = r101;
        }
    }

    public interface b {
        void a(String r100);

        void b(SDKCallBack.CommonRequestCallback r100);

        Context getContext();

        Handler getHandler();

        void hideLoading();

        void onEvent(String r100, JSONObject r101);

        void showLoading();
    }

    public interface c {
    }

    public FaceDetectionRecorder() {
        this.f407332f = RecordState.WAIT;
        this.f407333g = new Object();
        this.f407334h = new AtomicBoolean(false);
        this.f407335i = false;
    }

    public final void d(RecordState r100) {
        Object r101 = this.f407333g;
        monitor-enter(r101);
        this.f407332f = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(c r100, BDResponse r101) {
        if (r100 == null) goto L8;
        b r102 = this.f407330d;
        if (r102 != null) goto L6;
        ((w.f) r100).a(r101);
        return;
    L6:
        r102.getHandler().post(new a(r100, r101));
        return;
    }

    public final void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        int r103 = this.f407328b;     // Catch: Exception -> L15
        if (r103 <= 0) goto L8;
        r102.put("record_policy", r103);     // Catch: Exception -> L15
    L10:
        r102.put("record_path", r100);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r101) == true) goto L13;
        r102.put("init_result", r101);     // Catch: Exception -> L15
        goto L13
    L8:
        if (this.f407329c == false) goto L10;
        r102.put("record_policy", 4);     // Catch: Exception -> L15
    L13:
        this.f407330d.onEvent("face_detection_record_init", r102);
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("record", "init_e", null)));
    }

    public static void a(FaceDetectionRecorder r100, int r110, int r111) {
        ksa.e r101 = r100.f407327a;
        if (r101 != null) goto L5;
    L14:
        JSONObject r102 = new JSONObject();
        r102.put("record_id", System.currentTimeMillis());     // Catch: JSONException -> L17
        r102.put("record_policy", r100.f407328b);     // Catch: JSONException -> L17
    L18:
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("record", "init_s", r102)));
        r100.f407334h.set(false);
        r100.d(RecordState.STARTING);
        String r103 = rsa.b.a();
        r100.f407331e = rsa.d.j(r100.f407330d.getContext(), r103 + "_src.mp4");
        StringBuilder r104 = new StringBuilder("start record:");
        r104.append(r100.f407331e);
        CertLog.d("FaceDetectionRecorder", r104.toString());
        ksa.e r105 = new ksa.e();
        r100.f407327a = r105;
        r105.f505977d = new r(r100);
        r100.f407330d.getContext();
        String r112 = r105.a(r110, r111, r100.f407331e, 30, false);
        if (r112 == null) goto L21;
        r100.c(r100.f407331e, r112);
        return;
    L21:
        String r113 = r100.f407327a.c();
        if (r113 == null) goto L24;
        r100.c(r100.f407331e, r113);
        return;
    L24:
        r100.c(r100.f407331e, null);
        return;
    L5:
        if (r101.f505978e.get() == true) goto L14;
        r100.f407330d.getHandler().postDelayed(new q(r100, r110, r111), 500);
        r100.f407327a.d();
        r100.f407327a = null;
        RecordState r114 = RecordState.WAIT;
        Object r106 = r100.f407333g;
        monitor-enter(r106);
        r100.f407332f = r114;     // Catch: Throwable -> L11
        monitor-exit(r106);     // Catch: Throwable -> L11
        r100.f407335i = false;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(boolean r110, String r111, w.f r112) {
        if (this.f407327a != null) goto L6;
        b(r112, new BDResponse(new CertResponse(true)));
        return;
    L6:
        CertLog.d("FaceDetectionRecorder", " stop record");
        RecordState r100 = RecordState.STOPPING;
        Object r101 = this.f407333g;
        monitor-enter(r101);
        this.f407332f = r100;     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        String r102 = this.f407331e;
        ksa.e r103 = this.f407327a;
        s r104 = new s(this, r103, r102, r111, r110, r112);
        r103.f505977d = r104;
        r103.d();
        this.f407330d.getHandler().postDelayed(new t(r104), 500);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void f(String r110, long r111, u r112) {
        JSONObject r100 = new JSONObject();
        int r101 = this.f407328b;     // Catch: Exception -> L12
        if (r101 <= 0) goto L8;
        r100.put("record_policy", r101);     // Catch: Exception -> L12
    L10:
        r100.put("file_size", new PolarisFileWrapper(r110).length());     // Catch: Exception -> L12
        goto L13
    L8:
        if (this.f407329c == false) goto L10;
        r100.put("record_policy", 4);     // Catch: Exception -> L12
    L13:
        this.f407330d.onEvent("face_detection_record_upload_start", r100);
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("record", "upload_s", null)));
        v r102 = new v(this, r112, r110, System.currentTimeMillis());
        if (r111 <= 0) goto L16;
        m r113 = new m(new AtomicBoolean(false), r102);
        this.f407330d.getHandler().postDelayed(new n(r113), r111);
        this.f407330d.b(r113);
        return;
    L16:
        this.f407330d.b(r102);
    }
}

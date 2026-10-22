package com.ss.android.bytedcert.face;

import android.util.Pair;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class s implements ksa.a.InterfaceC6605a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ksa.a f407420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f407421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f407422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f407423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder.c f407424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ FaceDetectionRecorder f407425f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f407426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f407427b;

        /* JADX INFO: renamed from: com.ss.android.bytedcert.face.s$a$a, reason: collision with other inner class name */
        public class RunnableC4714a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f407428a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f407429b;

            public final void a() {
                String r100 = "success";
                s r101 = this.f407429b.f407427b;
                FaceDetectionRecorder r102 = r101.f407425f;
                String r103 = r101.f407421b;
                String r104 = r101.f407422c;
                Pair r105 = this.f407428a;
                r102.getClass();
                JSONObject r106 = new JSONObject();
                int r107 = r102.f407328b;     // Catch: Exception -> L45
                if (r107 <= 0) goto L8;
                r106.put("record_policy", r107);     // Catch: Exception -> L45
            L11:
                if (((Boolean) r105.first).booleanValue() == false) goto L13;
                Object r108 = "success";
            L14:
                r106.put("record_result", r108);     // Catch: Exception -> L45
                r106.put("record_path", r103);     // Catch: Exception -> L45
                r106.put("from", r104);     // Catch: Exception -> L45
                if (((Boolean) r105.first).booleanValue() == false) goto L17;
                r106.put("duration", r105.second);     // Catch: Exception -> L45
            L18:
                r106.put("file_size", new PolarisFileWrapper(r103).length());     // Catch: Exception -> L45
                goto L19
            L17:
                r106.put("fail_reason", r105.second);     // Catch: Exception -> L45
                goto L18
            L13:
                r108 = "fail";
                goto L14
            L8:
                if (r102.f407329c == false) goto L11;
                r106.put("record_policy", 4);     // Catch: Exception -> L45
            L19:
                r102.f407330d.onEvent("face_detection_record_finish", r106);
                JSONObject r109 = new JSONObject();
                if (((Boolean) this.f407428a.first).booleanValue() == true) goto L24;
                r100 = "fail";
            L24:
                r109.put("result", r100);     // Catch: JSONException -> L26
                r109.put("from", this.f407429b.f407427b.f407422c);     // Catch: JSONException -> L26
            L27:
                rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("record", "end", r109)));
                s r110 = this.f407429b.f407427b;
                FaceDetectionRecorder r111 = r110.f407425f;
                String r112 = r110.f407421b;
                boolean r113 = r110.f407423d;
                boolean r114 = ((Boolean) this.f407428a.first).booleanValue();
                FaceDetectionRecorder.c r115 = this.f407429b.f407427b.f407424e;
                if (r111.f407329c == false) goto L31;
                if (r113 == true) goto L31;
                r111.f(r112, 0, null);
                return;
            L31:
                if (r113 == true) goto L33;
                rsa.d.g(r112);
                return;
            L33:
                int r116 = r111.f407328b;
                if (r116 != 2) goto L36;
                if (r114 == false) goto L43;
                r111.f407330d.showLoading();
                r111.f(r112, 10000, new u(r111, r115));
                return;
            L43:
                r111.b(r115, new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UN_EXISTS));
                return;
            L36:
                if (r116 == 3) goto L38;
                r111.b(r115, new BDResponse(new CertResponse(true)));
                return;
            L38:
                if (r114 == false) goto L40;
                r111.f(r112, 0, null);
            L40:
                r111.b(r115, new BDResponse(new CertResponse(true)));
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

            public RunnableC4714a(a r100, Pair r101) {
                this.f407429b = r100;
                this.f407428a = r101;
            }
        }

        public final void a() {
            Pair<Boolean, String> r100 = rsa.d.l(this.f407427b.f407421b);
            if (((Boolean) r100.first).booleanValue() == false) goto L5;
        L19:
            this.f407427b.f407425f.f407330d.getHandler().post(new RunnableC4714a(this, r100));
            return;
        L5:
            if (this.f407426a != 2) goto L22;
            ksa.a r101 = this.f407427b.f407420a;
            if (r101 == null) goto L22;
            ksa.e r102 = (ksa.e) r101;
            ksa.f r103 = r102.f505975b;
            if (r103 == null) goto L12;
            r103.g();
            r102.f505975b = null;
        L12:
            if (r102.f505979f == false) goto L22;
            ksa.b r104 = r102.f505976c;
            if (r104 == null) goto L22;
            r104.g();
            r102.f505976c = null;
        L22:
            Thread.sleep(500);     // Catch: InterruptedException -> L21
        L18:
            r100 = rsa.d.l(this.f407427b.f407421b);
            goto L19
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

        public a(s r100, int r101) {
            this.f407427b = r100;
            this.f407426a = r101;
        }
    }

    @Override // ksa.a.InterfaceC6605a
    public final void onPrepared() {
    }

    @Override // ksa.a.InterfaceC6605a
    public final void onStopped() {
        if (this.f407425f.f407334h.getAndSet(true) == false) goto L5;
        return;
    L5:
        FaceDetectionRecorder r100 = this.f407425f;
        r100.f407327a = null;
        FaceDetectionRecorder.RecordState r101 = FaceDetectionRecorder.RecordState.WAIT;
        Object r102 = r100.f407333g;
        monitor-enter(r102);
        r100.f407332f = r101;     // Catch: Throwable -> L25
        monitor-exit(r102);     // Catch: Throwable -> L25
        int r103 = 0;
        r100.f407335i = false;
        Object r104 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.VIDEO_RECORD_OPT_ON_STOP);
        if ((r104 instanceof Number) == false) goto L12;
        r103 = ((Number) r104).intValue();
    L12:
        if (r103 != 1) goto L23;
        ksa.a r105 = this.f407420a;
        if (r105 == null) goto L23;
        ksa.e r106 = (ksa.e) r105;
        ksa.f r107 = r106.f505975b;
        if (r107 == null) goto L19;
        r107.g();
        r106.f505975b = null;
    L19:
        if (r106.f505979f == false) goto L23;
        ksa.b r108 = r106.f505976c;
        if (r108 == null) goto L23;
        r108.g();
        r106.f505976c = null;
    L23:
        this.f407425f.f407330d.a(this.f407421b);
        ThreadPlus.submitRunnable(new a(this, r103));
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public s(FaceDetectionRecorder r100, ksa.e r101, String r102, String r103, boolean r104, w.f r105) {
        this.f407425f = r100;
        this.f407420a = r101;
        this.f407421b = r102;
        this.f407422c = r103;
        this.f407423d = r104;
        this.f407424e = r105;
    }
}

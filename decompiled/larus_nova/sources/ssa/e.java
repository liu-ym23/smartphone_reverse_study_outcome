package ssa;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.bytedcert.cvlibrary.FaceLiveness;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.dialog.controller.video.VideoRecordController;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.CertLog;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends lsa.a implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final List<Integer> f543470n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FaceLiveness f543471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f543472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f543473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f543474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f543475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHandler f543476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f543477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f543478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ksa.e f543479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f543480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f543481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VideoRecordController f543482l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f543483m;

    public class a implements ksa.a.InterfaceC6605a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f543484a;

        @Override // ksa.a.InterfaceC6605a
        public final void onPrepared() {
            CertLog.e("RecordState", "onPrepared recordState = RECORD_STATE.RECORDING;");
            this.f543484a.f543474d = 2;
        }

        @Override // ksa.a.InterfaceC6605a
        public final void onStopped() {
            CertLog.e("RecordState", "onStop listener");
            e r100 = this.f543484a;
            if (r100.f543475e == false) goto L5;
            r100.f543476f.sendEmptyMessage(11112);
            return;
        L5:
            r100.f543476f.sendEmptyMessage(11113);
        }

        public a(e r100) {
            this.f543484a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f543485a;

        @Override // java.lang.Runnable
        public final void run() {
            e r100 = this.f543485a;     // Catch: Throwable -> L4
            r100.f543477g++;     // Catch: Throwable -> L4
            r100.l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(e r100) {
            this.f543485a = r100;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f543486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f543487b;

        @Override // java.lang.Runnable
        public final void run() {
            ksa.e r100 = this.f543487b.f543479i;     // Catch: Throwable -> L4
            byte[] r101 = this.f543486a;     // Catch: Throwable -> L4
            r100.b(r101, r101.length, System.nanoTime() / 1000);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(e r100, byte[] r101) {
            this.f543487b = r100;
            this.f543486a = r101;
        }
    }

    public class d implements CommonDialog.OnDialogClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f543488a;

        public d(e r100) {
            this.f543488a = r100;
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onCancel(DialogInterface r100) {
            ((ssa.a) this.f543488a.f543473c).O(new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_NO_FACE));
        }

        @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
        public final void onConfirm(DialogInterface r100) {
            this.f543488a.f543482l.setLiveSDKRunning(true);
            ((ssa.a) this.f543488a.f543473c).startRecord();
        }
    }

    /* JADX INFO: renamed from: ssa.e$e, reason: collision with other inner class name */
    public class RunnableC7648e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f543489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f543490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f543491c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f543491c.m(this.f543489a, this.f543490b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7648e(e r100, int r101, int r102) {
            this.f543491c = r100;
            this.f543489a = r101;
            this.f543490b = r102;
        }
    }

    static {
        f543470n = Arrays.asList(new Integer[]{103, 104, 106, 110, 111});
    }

    @Override // lsa.a
    public final String c(int r100) {
        return null;
    }

    @Override // lsa.a
    public final String d() {
        return null;
    }

    @Override // lsa.a
    public final int g() {
        this.f543477g = 0;
        this.f543475e = false;
        this.f543483m = 0;
        this.f543476f.removeMessages(11112);
        if (this.f543472b != 0) goto L7;
        return -1;
    L7:
        return this.f543471a.native_FL_ResetHandle(this.f543472b, false, "");
    }

    @Override // lsa.a
    public final int i(int[] r100, float[] r101) {
        return 0;
    }

    @Override // lsa.a
    public final int k(LiveInfo r100) {
        return 0;
    }

    @Override // lsa.a
    public final int f() {
        CertLog.e("VideoRecordTask", "release ");
        n(false);
        if (this.f543472b != 0) goto L6;
        return -1;
    L6:
        int r100 = this.f543471a.native_FL_ReleaseHandle(this.f543472b, false, "");
        this.f543472b = 0;
        return r100;
    }

    public final void l() {
        CertLog.e("VideoRecordTask", "face compare change to PlayFragment ");
        if (((Boolean) rsa.d.l(this.f543480j).first).booleanValue() == false) goto L6;
        this.f543477g = 0;
        this.f543482l.saveVideo(this.f543480j);
        ((ssa.a) this.f543473c).hideLoading();
        ((ssa.a) this.f543473c).n0("preview");
        return;
    L6:
        if (this.f543477g < 3) goto L9;
        this.f543477g = 0;
        o(-1);
        return;
    L9:
        this.f543476f.postDelayed(new b(this), 1000);
    }

    public e(VideoRecordController r100) {
        this.f543471a = null;
        this.f543472b = 0;
        this.f543474d = 0;
        this.f543476f = new WeakHandler(Looper.getMainLooper(), this);
        this.f543477g = 0;
        this.f543481k = "";
        this.f543483m = 0;
        this.f543482l = r100;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        int r101 = r100.what;
        if (r101 != 11112) goto L6;
        this.f543476f.removeMessages(11112);
        l();
        return;
    L6:
        if (r101 != 11113) goto L13;
        this.f543476f.removeMessages(11113);
        CertLog.e("VideoRecordTask", "stop record ui");
        if (TextUtils.isEmpty(this.f543480j) == true) goto L10;
        rsa.d.g(this.f543480j);
    L10:
        ((ssa.a) this.f543473c).hideLoading();
        ((ssa.a) this.f543473c).k0();
        return;
    }

    public final void n(boolean r100) {
        CertLog.e("VideoRecordTask", "stopRecord ");
        CertLog.e("RecordState", "stopRecord  recordState = RECORD_STATE.STOPING;");
        if (r100 == true) goto L5;
        g();
    L5:
        this.f543474d = 3;
        this.f543475e = r100;
        this.f543479i.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o(int r100) {
        n(false);
        if (this.f543473c == null) goto L6;
        rsa.d.g(this.f543480j);
        this.f543482l.setLiveSDKRunning(false);
        ((ssa.a) this.f543473c).hideLoading();
        Context r101 = this.f543473c;
        ((ssa.a) r101).r1(r101.getString(R.string.byted_video_record_check_no_face_title), this.f543473c.getString(R.string.byted_video_record_check_no_face_tip), this.f543473c.getString(R.string.byted_exit_veri), this.f543473c.getString(R.string.byted_video_record_check_retry), new d(this), r100);
        return;
    }

    @Override // lsa.a
    public final int e(Context r100, Bundle r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        this.f543473c = r100;
        this.f543478h = r100.getResources().getStringArray(R.array.byted_liveness_prompt_info);
        FaceLiveness r102 = new FaceLiveness();
        this.f543471a = r102;
        this.f543472b = r102.native_FL_CreateHandler();
        if (this.f543472b != 0) goto L9;
        CertLog.d("VideoRecordTask", "Create handle err: " + this.f543472b);
        return 1;
    L9:
        String r103 = "res/action_liveness/" + FaceLiveness.native_FL_GetModelName();
        rsa.d.c(r100, r103);
        String r104 = rsa.d.j(r100, r103);
        int r105 = this.f543471a.native_FL_SetModule(this.f543472b, r104);
        if (r105 == 0) goto L17;
        CertLog.e("VideoRecordTask", " err SetModle in FaceLiveness, code: " + r105);
        if (r105 != (-5)) goto L16;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104);
        if (r106.exists() == false) goto L16;
        r106.delete();
    L16:
        return r105;
    L17:
        ksa.e r107 = new ksa.e();
        this.f543479i = r107;
        this.f543475e = false;
        r107.f505977d = new a(this);
        return 0;
    }

    public final void m(int r100, int r110) {
        ksa.e r101 = this.f543479i;
        if (r101 != null) goto L5;
    L8:
        this.f543474d = 1;
        CertLog.e("RecordState", "startRecord recordState = RECORD_STATE.STARTING;");
        String r102 = rsa.b.a();
        this.f543480j = rsa.d.j(this.f543473c, r102 + "_src.mp4");
        StringBuilder r103 = new StringBuilder("start record ");
        r103.append(this.f543480j);
        CertLog.d("VideoRecordTask", r103.toString());
        this.f543479i.a(r100, r110, this.f543480j, 30, true);
        this.f543479i.c();
        return;
    L5:
        if (r101.f505978e.get() == true) goto L8;
        this.f543476f.postDelayed(new RunnableC7648e(this, r100, r110), 500);
    }

    @Override // lsa.a
    public final int a(byte[] r110, int r111, byte[] r112, int r113, int r210) {
        if (this.f543482l.isLiveSdkPaused() == false) goto L5;
        return 0;
    L5:
        int[] r114 = new int[2];
        this.f543471a.native_FL_doFaceQuality(this.f543472b, r110, 0, r113, r210, r113 * 4, r111, r114);
        int r100 = r114[1];
        if (this.f543474d != 2) goto L15;
        if (r100 >= 101) goto L9;
    L14:
        byte[] r101 = new byte[r110.length];
        System.arraycopy(r110, 0, r101, 0, r110.length);
        ThreadPlus.submitRunnable(new c(this, r101));
    L23:
        return 0;
    L9:
        if (TextUtils.isEmpty(this.f543478h[r100 - 101]) == false) goto L11;
        this.f543483m = 0;
        goto L14
    L11:
        int r102 = this.f543483m + 1;
        this.f543483m = r102;
        if (r102 < 100) goto L14;
        o(r100);
        goto L14
    L15:
        if (r100 < 101) goto L23;
        if (f543470n.contains(Integer.valueOf(r100)) == false) goto L19;
        String r103 = this.f543473c.getString(R.string.byted_video_record_face_prompt);
    L21:
        if (this.f543481k.equals(r103) == true) goto L23;
        ((ssa.a) this.f543473c).w(r103, r100);
        this.f543481k = r103;
        goto L23
    L19:
        r103 = this.f543478h[r100 - 101];
        goto L21
    }
}

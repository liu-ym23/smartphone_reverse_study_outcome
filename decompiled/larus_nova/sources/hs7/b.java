package hs7;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.WorkState;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.DeviceSetting;
import com.dtf.face.config.OSSConfig;
import com.dtf.face.config.Upload;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.dtf.face.network.model.FaceInfo;
import com.dtf.face.photinus.VideoFormatConfig;
import com.dtf.face.utils.ClientConfigUtil;
import com.dtf.face.verify.IVerifyResultCallBack;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.algorithm.TGDepthFrame;
import com.dtf.toyger.base.algorithm.TGFrame;
import com.dtf.toyger.base.algorithm.ToygerCameraConfig;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.dtf.toyger.base.face.ToygerFaceAttr;
import com.dtf.toyger.base.face.ToygerFaceCallback;
import com.dtf.toyger.base.face.ToygerFaceInfo;
import com.dtf.toyger.base.face.ToygerFaceService;
import com.dtf.toyger.base.face.ToygerFaceState;
import com.dtf.toyger.base.face.ToygerPairFaceInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttm.player.MediaPlayer;
import faceverify.h;
import faceverify.i;
import faceverify.j;
import faceverify.k;
import faceverify.l;
import faceverify.s;
import is7.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import ws7.f;
import ws7.o;
import ws7.q;
import ws7.t;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements ToygerFaceCallback, is7.d {
    public static final b D = null;
    public l A;
    public boolean B;
    public int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f487018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ToygerFaceService f487019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f487020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f487021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public faceverify.d f487022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f487023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IVerifyResultCallBack f487024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WorkState f487025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f487026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicBoolean f487027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f487028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f487029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f487030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f487031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public is7.b f487032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CopyOnWriteArrayList<is7.b> f487033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CopyOnWriteArrayList<is7.b> f487034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f487035r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f487036s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f487037t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f487038u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f487039v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<String> f487040w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f487041x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ps7.d f487042y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f487043z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f487044a;

        /* JADX INFO: renamed from: hs7.b$a$a, reason: collision with other inner class name */
        public class RunnableC6191a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f487045a;

            public final void a() {
                b r100 = this.f487045a.f487044a;
                if (r100.f487023f != null) goto L5;
                return;
            L5:
                if (b.D.f487031n == true) goto L7;
            L13:
                r100.g(902);
                return;
            L7:
                if (r100.f487020c != null) goto L13;
                CopyOnWriteArrayList<is7.b> r101 = r100.f487034q;     // Catch: Throwable -> L12
                new k(r101, "toyger_verify_video", new faceverify.b(r100)).b();     // Catch: Throwable -> L12
                return;
            L12:
                r100.g(902);
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

            public RunnableC6191a(a r100) {
                this.f487045a = r100;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ts7.c.c(new RunnableC6191a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f487044a = r100;
        }
    }

    /* JADX INFO: renamed from: hs7.b$b, reason: collision with other inner class name */
    public class RunnableC6192b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f487046a;

        /* JADX INFO: renamed from: hs7.b$b$a */
        public class a implements APICallback<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RunnableC6192b f487047a;

            public a(RunnableC6192b r100) {
                this.f487047a = r100;
            }

            @Override // com.dtf.face.network.APICallback
            public final void onSuccess(String r100) {
                String r101 = r100;
                ToygerFaceService r102 = this.f487047a.f487046a.f487019b;
                if (r102 != null) goto L8;
                return;
            L8:
                r102.updateNativeState(111, r101);     // Catch: Exception -> L7
                return;
            }

            @Override // com.dtf.face.network.APICallback
            public final void onError(String r100, String r101, String r102) {
                if ("stopPreviewError".equals(r102) == true) goto L5;
                ToygerFaceService r103 = this.f487047a.f487046a.f487019b;
                if (r103 == null) goto L18;
                r103.updateNativeState(111, "");     // Catch: Exception -> L11
                return;
            L11:
                e = move-exception;
                RecordService.getInstance().recordException(e);
                return;
            L18:
                return;
            L5:
                if (TextUtils.isEmpty(r101) == true) goto L16;
                RecordService.getInstance().recordEvent(4, "photinusException", new String[]{"errMsg", r101});
                return;
            }
        }

        public final void a() {
            b r100 = this.f487046a;
            ps7.d r101 = r100.f487042y;
            Camera r102 = r100.f487018a.getCamera();
            a r103 = new a(this);
            r101.getClass();
            r101.f530456l = r103;     // Catch: Throwable -> L23
            AndroidClientConfig r104 = hs7.a.h().c();     // Catch: Throwable -> L23
            if (r104 == null) goto L6;
            Upload r105 = r104.getUpload();     // Catch: Throwable -> L23
        L7:
            if (r105 != null) goto L9;
        L15:
            boolean r106 = "0".equals(ClientConfigUtil.c("CLIENT_NATIVE_PHOTINUS"));     // Catch: Throwable -> L23
            Handler r107 = r101.f530455k;     // Catch: Throwable -> L23
            ps7.b r108 = new ps7.b(r101, r102);     // Catch: Throwable -> L23
            if (r106 == false) goto L18;
            long r109 = 0;
        L19:
            r107.postDelayed(r108, r109);     // Catch: Throwable -> L23
            if (r106 == true) goto L31;
            ps7.d.b(r102, new ps7.c(r101));     // Catch: Throwable -> L23
            return;
        L31:
            return;
        L18:
            r109 = 800;
            goto L19
        L9:
            if (r105.photinusPicture == true) goto L15;
            if (r101.f530456l == null) goto L29;
            JSONObject r110 = new JSONObject();     // Catch: Throwable -> L23
            r110.put2(com.heytap.mcssdk.constant.b.C, "2.3.43");     // Catch: Throwable -> L23
            r110.put2("device-name", Build.MODEL);     // Catch: Throwable -> L23
            r110.put2("data-source", "antfincloud-production-android-2");     // Catch: Throwable -> L23
            String r111 = r110.toJSONString();     // Catch: Throwable -> L23
            r101.f530454j = r111;     // Catch: Throwable -> L23
            r101.f530456l.onSuccess(r111);     // Catch: Throwable -> L23
            return;
        L29:
            return;
        L6:
            r105 = null;
        L23:
            th = move-exception;
            r101.f530455k.removeCallbacks(null);
            APICallback<String> r112 = r101.f530456l;
            if (r112 == null) goto L32;
            r112.onError(null, RecordService.getStackTraceString(th), null);
            return;
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

        public RunnableC6192b(b r100) {
            this.f487046a = r100;
        }
    }

    public class c implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APICallback f487048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f487049b;

        public c(b r100, APICallback r101) {
            this.f487049b = r100;
            this.f487048a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f487050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f487051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f487052c;

        public class a implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f487053a;

            @Override // faceverify.j
            public final void a() {
                this.f487053a.a(null, 0);
            }

            public a(d r100) {
                this.f487053a = r100;
            }

            @Override // faceverify.j
            public final void a(String r100, String r101) {
                d r102 = this.f487053a;
                r102.a(r100, ((ToygerFaceInfo) ListProtector.get(((ToygerPairFaceInfo) ListProtector.get(r102.f487050a, 0)).faceInfos, 0)).frame.rotation);
            }
        }

        public final void b() {
            if (((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos != null) goto L5;
        L11:
            a(null, 0);
            return;
        L5:
            if (((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos.size() <= 0) goto L11;
            if (((ToygerFaceInfo) ListProtector.get(((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos, 0)).frame.data == null) goto L11;
            if (((ToygerFaceInfo) ListProtector.get(((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos, 0)).frame.data.length <= 0) goto L11;
            k r100 = new k(h.a(((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos), "" + System.currentTimeMillis(), new a(this));
            int r101 = ((ToygerFaceInfo) ListProtector.get(((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos, 0)).frame.width;
            int r102 = ((ToygerFaceInfo) ListProtector.get(((ToygerPairFaceInfo) ListProtector.get(this.f487050a, 0)).faceInfos, 0)).frame.height;
            r100.f476143d = 0;
            r100.f476144e = r101;
            r100.f476145f = r102;
            r100.f476149j = VideoFormatConfig.S;
            r100.b();
        }

        @Override // java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(String r110, int r111) {
            OSSConfig r100 = hs7.a.h().i();
            Object r101 = null;
            String r102 = "NULL";
            if (r100 == null) goto L11;
            if (r110 == null) goto L6;
            String r103 = ws7.i.d(r100.FileNamePrefix, "faceCollect_" + r111, "mp4");
            q.a r104 = q.c(r100.OssEndPoint, r100.AccessKeyId, r100.AccessKeySecret, r100.SecurityToken, r100.BucketName, r103, f.g(new PolarisFileWrapper(r110)));
        L7:
            String r105 = ws7.i.d(r100.FileNamePrefix, "faceCollect", "json");
            if (this.f487051b.get("metaInfo") == null) goto L10;
            r101 = q.c(r100.OssEndPoint, r100.AccessKeyId, r100.AccessKeySecret, r100.SecurityToken, r100.BucketName, r105, ((String) this.f487051b.get("metaInfo")).getBytes());
        L10:
            Object r112 = r103;
            q.a r106 = r101;
            r101 = r112;
        L12:
            RecordService r107 = RecordService.getInstance();
            String[] r108 = new String[10];
            r108[0] = "bucketName";
            if (r100 == null) goto L16;
            r102 = r100.BucketName;
        L16:
            r108[1] = r102;
            r108[2] = "videoFileName";
            String r109 = "Null";
            if (r101 != null) goto L19;
            r101 = "Null";
        L19:
            r108[3] = r101;
            r108[4] = "isVideoSuccess";
            if (r104 != null) goto L22;
            String r113 = "Null";
        L23:
            r108[5] = r113;
            r108[6] = "metaInfoFileName";
            if (r106 != 0) goto L26;
            r105 = "Null";
        L26:
            r108[7] = r105;
            r108[8] = "isMetaInfoSuccess";
            if (r106 == 0) goto L30;
            r109 = String.valueOf(r106.f561101a);
        L30:
            r108[9] = r109;
            r107.recordEvent(2, "faceCaseCollect", r108);
            this.f487052c.f487039v.decrementAndGet();
            b r114 = this.f487052c;
            r114.getClass();
            ts7.c.d(new faceverify.a(r114));
            RecordService.getInstance().flush(false);
            return;
        L22:
            r113 = String.valueOf(r104.f561101a);
            goto L23
        L6:
            r104 = null;
            r103 = null;
            goto L7
        L11:
            r104 = null;
            r106 = 0;
            r105 = "NULL";
            goto L12
        }

        public d(b r100, List r101, Map r102) {
            this.f487052c = r100;
            this.f487050a = r101;
            this.f487051b = r102;
        }
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final void onAsyncUpload(int r100, byte[] r101, byte[] r102, boolean r103) {
    }

    @Override // is7.d
    public final void onSurfaceDestroyed() {
    }

    static {
        D = new b();
    }

    @Override // is7.d
    public final void a() {
        Camera r100 = this.f487018a.getCamera();
        if (r100 == null) goto L8;
        l r101 = this.A;
        if (r101 == null) goto L9;
        r101.f476150a = r100;
        return;
    L9:
        return;
    }

    public final void i() {
        if (this.f487023f == null) goto L14;
        c(902);
        a r100 = new a(this);
        monitor-enter(this);
        Handler r101 = this.f487023f;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.post(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    L11:
        th = move-exception;
        throw th;
    L14:
        this.f487025h = WorkState.FACE_COMPLETED;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final void onEncodeLoading() {
        g(913);
    }

    public b() {
        this.f487021d = 0;
        this.f487022e = new faceverify.d();
        this.f487025h = WorkState.INIT;
        this.f487026i = 0;
        this.f487027j = new AtomicBoolean(false);
        this.f487028k = false;
        this.f487029l = false;
        this.f487030m = new HashMap();
        this.f487031n = false;
        this.f487035r = 30;
        this.f487036s = 5;
        this.f487037t = false;
        this.f487038u = false;
        this.f487039v = new AtomicInteger(0);
        this.f487040w = new ArrayList();
        this.f487041x = false;
        this.f487043z = "";
        this.B = false;
        this.C = 0;
    }

    public static boolean h() {
        AndroidClientConfig r100 = hs7.a.h().c();
        if (r100 != null) goto L5;
        return false;
    L5:
        DeviceSetting[] r101 = r100.getDeviceSettings();
        if (r101.length <= 0) goto L15;
        DeviceSetting r102 = r101[0];
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.isCameraAuto() == false) goto L12;
        return false;
    L12:
        if (r102.getCameraID() != 0) goto L18;
        return true;
    L18:
        return false;
    L15:
        return false;
    }

    public static void f(List r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L8;
        r100.clear();
        return;
    }

    public final void c(int r100) {
        if (this.f487023f != null) goto L5;
        return;
    L5:
        if (this.f487031n == false) goto L38;
        CopyOnWriteArrayList<is7.b> r101 = this.f487034q;
        if (r101 != null) goto L11;
        return;
    L11:
        if (r100 != 11) goto L13;
    L31:
        this.f487036s = 5;
        this.f487037t = true;
        return;
    L13:
        if (r100 == 14) goto L31;
        if (r100 == 15) goto L31;
        if (r100 != 902) goto L29;
        faceverify.c r102 = new faceverify.c(this);
        monitor-enter(this);
        Handler r103 = this.f487023f;     // Catch: Throwable -> L26
        if (r103 == null) goto L24;
        r103.post(r102);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        if (r100 != 1) goto L36;
        this.f487036s = 0;
        this.f487037t = false;
        f(r101);
        FaceDataFrameInfo.info_cache_bak = "";
        return;
    L36:
        return;
    }

    public final void d(String r100) {
        Message r101 = Message.obtain();
        r101.what = 903;
        r101.obj = r100;
        monitor-enter(this);
        Handler r102 = this.f487023f;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.sendMessage(r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(int r100) {
        monitor-enter(this);
        Handler r101 = this.f487023f;     // Catch: Throwable -> L8
        if (r101 == null) goto L6;
        r101.sendEmptyMessage(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback, faceverify.r
    public final PointF onAlignDepthPoint(PointF r100) {
        PointF r101 = new PointF(r100.x, r100.y);
        e r102 = this.f487018a;
        if (r102 == null) goto L5;
        int r103 = r102.getColorWidth();
        int r104 = this.f487018a.getColorHeight();
        int r105 = this.f487018a.getDepthWidth();
        int r106 = this.f487018a.getDepthHeight();
        PointF r107 = new PointF();
        r107.x = r100.x * r103;
        r107.y = r100.y * r104;
        PointF r108 = this.f487018a.colorToDepth(r107);
        r101.x = r108.x / r105;
        r101.y = r108.y / r106;
    L5:
        return r101;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final void onEncryptUploadInfo(Map<String, Object> r100) {
        if (r100 == null) goto L25;
        Object r101 = r100.get(faceverify.q.KEY_ELEMENT_CONTENT);
        if (r101 == null) goto L6;
        byte[] r102 = (byte[]) r101;
        this.f487022e.f476099h = r102;
    L6:
        Object r103 = r100.get(faceverify.q.KEY_CONTENT_MD5);
        if (r103 == null) goto L9;
        String r104 = (String) r103;
        this.f487022e.f476095d = r104;
    L9:
        Object r105 = r100.get(faceverify.q.KEY_CONTENT_BITMAP);
        if (r105 == null) goto L12;
        byte[] r106 = (byte[]) r105;
        this.f487022e.f476094c = r106;
    L12:
        Object r107 = r100.get(faceverify.q.KEY_CONTENT_ATTR);
        if (r107 == null) goto L15;
        ToygerFaceAttr r108 = (ToygerFaceAttr) r107;
        this.f487022e.f476096e = r108;
    L15:
        Object r109 = r100.get(faceverify.q.KEY_CONTENT_FACE_ATTR);
        if (r109 == null) goto L18;
        FaceInfo r110 = (FaceInfo) r109;
        this.f487022e.f476097f = r110;
    L18:
        Object r111 = r100.get(faceverify.q.KEY_COLLECT_SIG);
        if (r111 == null) goto L21;
        String r112 = (String) r111;
        this.f487022e.f476103l = r112;
    L21:
        Object r113 = r100.get(faceverify.q.KEY_PREVIEW_TRACE);
        if (r113 == null) goto L26;
        hs7.a r114 = hs7.a.h();
        r114.M = r113.toString();
        return;
    L26:
        return;
    }

    @Override // is7.d
    public final void onError(Throwable r100) {
        RecordService.getInstance().recordException(r100);
        d("Z1020");
    }

    @Override // is7.d
    public final void onPreviewFrame(is7.b r110) {
        if (this.f487032o != null) goto L14;
        Message r100 = Message.obtain();
        r100.what = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
        monitor-enter(this);
        Handler r101 = this.f487023f;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.sendMessage(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    L11:
        th = move-exception;
        throw th;
    L14:
        this.f487032o = r110;
        if (this.f487028k == false) goto L17;
        return;
    L17:
        boolean r102 = false;
        if (this.f487029l == true) goto L55;
        ToygerCameraConfig r103 = new ToygerCameraConfig();
        AndroidClientConfig r104 = hs7.a.h().c();
        if (r104 == null) goto L27;
        Upload r105 = r104.getUpload();
        if (r105 == null) goto L26;
        Boolean r106 = r105.isMirror;
        if (r106 == null) goto L26;
    L28:
        e r107 = this.f487018a;
        if (r107 == null) goto L35;
        if (r106 != null) goto L34;
        r106 = Boolean.valueOf(r107.isMirror());
        if (r105 == null) goto L34;
        r105.isMirror = r106;
    L34:
        ((HashMap) this.f487030m).put(faceverify.q.KEY_IS_MIRROR, Boolean.toString(r106.booleanValue()));
        this.f487018a.getCameraParams();
        r103.roiRect = this.f487018a.getROI();
    L35:
        ((HashMap) this.f487030m).put(faceverify.q.KEY_CAMERA_CONFIG, r103);
        ToygerFaceService r108 = this.f487019b;
        if (r108 != null) goto L38;
    L54:
        this.f487029l = true;
        goto L55
    L38:
        if (r108.config(this.f487030m) == true) goto L218;
        RecordService.getInstance().recordEvent(4, "faceServiceConfig", new String[]{"status", "false"});
        d("Z1001");
        goto L54
    L218:
        if (hs7.a.h().f486997i == null) goto L51;
        ToygerFaceService r109 = this.f487019b;
        if (r109 != null) goto L212;
    L47:
        ToygerFaceService r111 = this.f487019b;
        if (r111 == null) goto L54;
        r111.updateNativeState(104, String.valueOf(false));     // Catch: Exception -> L205
    L217:
        goto L54
    L212:
        r109.updateNativeState(103, String.valueOf(false));     // Catch: Exception -> L46
        goto L47
    L51:
        ToygerFaceService r112 = this.f487019b;
        if (r112 == null) goto L54;
        r112.updateNativeState(105, String.valueOf(false));     // Catch: Exception -> L205
    L26:
        r106 = null;
        goto L28
    L27:
        r105 = null;
        r106 = null;
    L55:
        WorkState r113 = this.f487025h;
        if (r113 == WorkState.FACE_CAPTURING) goto L63;
        if (r113 == WorkState.FACE_CAPTURING_DARK) goto L63;
        if (r113 == WorkState.PHOTINUS) goto L63;
        return;
    L63:
        if (this.f487027j.getAndSet(true) == false) goto L65;
        return;
    L65:
        e r114 = this.f487018a;
        if (r114 == null) goto L70;
        int r115 = r114.getCameraViewRotation();
        if (h() == true) goto L71;
        r115 = (360 - r115) % 360;
    L71:
        AndroidClientConfig r116 = hs7.a.h().c();
        if (r116 != null) goto L74;
    L85:
        r110.f495634j = r115;
        if (D.f487031n == true) goto L88;
    L208:
        byte[] r117 = r110.f495625a.array();     // Catch: Exception -> L120
        hs7.d r118 = hs7.d.f487062i;     // Catch: Exception -> L120
        int r119 = r110.f495626b;     // Catch: Exception -> L120
        int r120 = r110.f495627c;     // Catch: Exception -> L120
        if (r117 == null) goto L121;
        r118.f487063a = r117;     // Catch: Exception -> L120
        r118.f487064b = r119;     // Catch: Exception -> L120
        r118.f487065c = r120;     // Catch: Exception -> L120
        r118.f487066d = r115;     // Catch: Exception -> L120
    L121:
        ByteBuffer r121 = r110.f495625a;
        if (r121 == null) goto L135;
        ArrayList r122 = new ArrayList();
        TGFrame r123 = new TGFrame(r121, r110.f495626b, r110.f495627c, r115, r110.f495628d, this.f487026i);
        if (this.f487042y != null) goto L126;
    L134:
        r122.add(r123);
    L136:
        ByteBuffer r124 = r110.f495629e;
        if (r124 == null) goto L139;
        TGDepthFrame r125 = new TGDepthFrame(r124, r110.f495630f, r110.f495631g, r115);
    L140:
        ToygerFaceService r126 = this.f487019b;
        if (r126 == null) goto L143;
        r126.processImage(r122, r125);
    L143:
        this.f487027j.set(false);
        l r127 = this.A;
        if (r127 != null) goto L146;
        return;
    L146:
        if (r127.f476157h == false) goto L202;
        HashMap<String, String> r128 = new HashMap();
        if (r127.f476150a == null) goto L150;
        r128.put("whiteBalance", r127.f476161l);
        r128.put(GestureAction.zoom, r127.f476163n);
    L150:
        OSSConfig r129 = hs7.a.h().f();
        if (r129 != null) goto L153;
        RecordService.getInstance().recordEvent(4, ChameleonResConstants.WEBCONAINER_ROOT_DIR, new String[]{"errMsg", "ossConfig is null"});
        goto L202
    L153:
        String r130 = ws7.i.d(r129.chameleonFileNamePrefix, "chameleon", LoadParams.ImageFormat.JPEG);
        r127.f476166q.add(HTTP.URL_DEFAULT + r129.BucketName + HTTP.URL_DEFAULT + r130);
        r127.f476167r.add(r130);
        r127.a(r128, "");
        Bitmap r131 = ws7.a.a(r110);     // Catch: Throwable -> L185
        if (r131 == null) goto L183;
        AndroidClientConfig r132 = hs7.a.h().c();     // Catch: Throwable -> L185
        if (r132 == null) goto L161;
        Upload r133 = r132.getUpload();     // Catch: Throwable -> L185
        if (r133 == null) goto L161;
        int r134 = r133.desiredWidth;     // Catch: Throwable -> L185
    L163:
        if (r131.getWidth() <= r134) goto L166;
        if (r134 <= 0) goto L166;
        r131 = faceverify.f.a(r131, r134);     // Catch: Throwable -> L185
    L166:
        float r135 = r127.f476159j;     // Catch: Throwable -> L185
        ByteArrayOutputStream r136 = new ByteArrayOutputStream();     // Catch: Throwable -> L185
        if (r135 > 1.0f) goto L172;
        if (r135 <= 0.0f) goto L172;
        r135 = r135 * 100.0f;     // Catch: Throwable -> L185
    L174:
        int r137 = (int) r135;     // Catch: Throwable -> L185
    L175:
        r131.compress(Bitmap.CompressFormat.JPEG, r137, r136);     // Catch: Throwable -> L185
        r136.flush();     // Catch: IOException -> L178 Throwable -> L185
        r136.close();     // Catch: IOException -> L178 Throwable -> L185
    L180:
        byte[] r138 = r136.toByteArray();     // Catch: Throwable -> L185
        r131.recycle();     // Catch: Throwable -> L185
        r127.f476165p.add(r138);     // Catch: Throwable -> L185
    L187:
        r127.f476157h = false;
        Camera r139 = r127.f476150a;
        if (r139 == null) goto L201;
        Camera.Parameters r140 = r127.a(r139);
        if (r140 == null) goto L201;
        if ("whiteBalanceFormer".equals(r127.f476155f) == true) goto L194;
        r140.setWhiteBalance(r127.f476155f);
    L194:
        int r141 = r127.f476154e;
        if (r141 == (-1)) goto L215;
        r140.setZoom(r141);
    L215:
        r127.f476150a.setParameters(r140);     // Catch: Throwable -> L199
    L199:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "cameraError", new String[]{"errMsg", RecordService.getStackTraceString(th)});
    L201:
        r102 = true;
        goto L202
    L178:
        e = move-exception;
        RecordService.getInstance().recordException(e);     // Catch: Throwable -> L185
    L172:
        if (r135 > 0.0f) goto L174;
        r137 = 70;
    L161:
        r134 = 480;
        goto L163
    L183:
        RecordService.getInstance().recordEvent(4, ChameleonResConstants.WEBCONAINER_ROOT_DIR, new String[]{"errMsg", "bitmap is null"});     // Catch: Throwable -> L185
        r127.f476165p.add(null);     // Catch: Throwable -> L185
    L185:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    L202:
        if (r102 == false) goto L223;
        i();
        return;
    L223:
        return;
    L139:
        r125 = null;
        goto L140
    L126:
        if (this.C != 6) goto L134;
        JSONObject r142 = new JSONObject();
        if (t.a(this.f487043z) == true) goto L130;
        r142.put2("color", this.f487043z);
        r142.put2("status", "normal");
    L130:
        ps7.d r143 = this.f487042y;
        if (r143.f530449e == false) goto L133;
        r142.put2("light-sensor", Float.valueOf(r143.f530446b));
        r142.put2(LocationMonitorConst.ACCURACY, Integer.valueOf(this.f487042y.f530447c));
    L133:
        r123.meta = r142.toJSONString();
        goto L134
    L135:
        r122 = null;
        goto L136
    L88:
        if (ClientConfigUtil.a() == true) goto L208;
        CopyOnWriteArrayList<is7.b> r144 = this.f487034q;
        if (r144 == null) goto L95;
        if (r144.size() > 0) goto L208;
    L95:
        if (this.f487037t == false) goto L109;
        int r145 = this.f487036s - 1;
        this.f487036s = r145;
        if (r145 >= 0) goto L109;
        faceverify.c r146 = new faceverify.c(this);
        monitor-enter(this);
        Handler r147 = this.f487023f;     // Catch: Throwable -> L105
        if (r147 == null) goto L103;
        r147.post(r146);     // Catch: Throwable -> L105
    L103:
        monitor-exit(this);
    L105:
        th = move-exception;
        throw th;
    L109:
        if (this.f487033p != null) goto L112;
        this.f487033p = new CopyOnWriteArrayList();
    L112:
        if (this.f487033p.size() <= this.f487035r) goto L114;
        this.f487033p.remove(0);
    L114:
        this.f487033p.add(r110);
        goto L208
    L74:
        if (r116.getDeviceSettings() == null) goto L85;
        if (r116.getDeviceSettings().length <= 0) goto L85;
        DeviceSetting r148 = r116.getDeviceSettings()[0];
        if (r148.isAlgorithmAuto() == false) goto L84;
        e r149 = this.f487018a;
        if (r149 == null) goto L85;
        r115 = r149.getCameraViewRotation();
        if (h() == true) goto L85;
        r115 = (360 - r115) % 360;
        goto L85
    L84:
        r115 = r148.getAlgorithmAngle();
        goto L85
    L70:
        r115 = 0;
        goto L71
    }

    public static void e(String r100, String r101) {
        RecordService.getInstance().recordEvent(2, "sendErrorCode", new String[]{"errCode", r100});
        if (RecordService.NEED_FILE_LOG == true) goto L5;
        RecordService.getInstance().flush(true);
    L5:
        WorkState r102 = WorkState.RET;
        b r103 = D;
        if (r102 != r103.f487025h) goto L8;
        return;
    L8:
        r103.f487025h = r102;
        IVerifyResultCallBack r104 = r103.f487024g;
        if (r104 == null) goto L12;
        r104.sendResAndExit(r100, r101);
        return;
    }

    @Override // is7.d
    public final void b(double r100, double r101) {
        Message r102 = Message.obtain();
        r102.what = 901;
        r102.arg1 = (int) r100;
        r102.arg2 = (int) r101;
        monitor-enter(this);
        Handler r103 = this.f487023f;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.sendMessage(r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final void onEncodeFaceInfo(List<ToygerFaceInfo> r100, APICallback<String> r101) {
        if (ClientConfigUtil.a() == true) goto L6;
        r101.onSuccess(null);
        return;
    L6:
        if (r100 != null) goto L8;
    L32:
        r101.onSuccess(null);
        return;
    L8:
        if (r100.size() <= 0) goto L32;
        if (this.f487020c != null) goto L12;
        this.f487020c = new h();
    L12:
        h r102 = this.f487020c;
        ToygerFaceInfo r103 = (ToygerFaceInfo) ListProtector.get(r100, 0);
        is7.b r104 = this.f487032o;
        int r105 = this.f487021d;
        c r106 = new c(this, r101);
        if (r102.f476124c != (-1)) goto L15;
    L18:
        if (r104 == null) goto L20;
        r102.f476124c = r104.f495634j;
        r102.f476125d = r104.f495632h;
        r102.f476126e = r104.f495633i;
    L20:
        r102.f476123b = r105;
        r102.f476122a = r103;
        r102.f476133l = r106;
        h r107 = this.f487020c;
        monitor-enter(r107);
    L29:
        th = move-exception;
        throw th;
    L23:
        if (r107.f476127f <= 0) goto L26;
        monitor-exit(r107);     // Catch: Throwable -> L29
    L34:
        return;
    L26:
        r107.f476127f = System.currentTimeMillis();     // Catch: Throwable -> L29
        r107.f476134m = false;     // Catch: Throwable -> L29
        monitor-exit(r107);     // Catch: Throwable -> L29
        r107.a();
        goto L34
    L15:
        if (r102.f476125d == (-1)) goto L18;
        if (r102.f476126e != (-1)) goto L20;
        goto L18
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback, faceverify.r
    public final boolean onEvent(int r100, Map<String, Object> r101) {
        String r102 = "";
        if (this.f487025h != WorkState.FACE_CAPTURING) goto L5;
        int r103 = 0;
    L6:
        this.f487026i = r103;
        if (r100 != 1001) goto L9;
        Object r104 = r101.get(faceverify.q.KEY_COLLECT_SIG);
        if (r104 == null) goto L76;
        this.f487022e.f476103l = r104.toString();
    L76:
        i();
    L78:
        if (TextUtils.isEmpty(r102) == true) goto L80;
        d(r102);
    L80:
        return true;
    L9:
        switch(r100) {
            case -48: goto L36;
            case -47: goto L33;
            case -46: goto L30;
            case -45: goto L23;
            case -44: goto L13;
            case -43: goto L12;
            case -42: goto L11;
            default: goto L53;
        };
    L11:
        c(11);
        goto L78
    L12:
        c(1);
        goto L78
    L13:
        String r105 = (String) r101.get("message");
        this.f487043z = r105;
        ((ArrayList) this.f487040w).add(r105);
        int r106 = ColorProtector.parseColor(this.f487043z);
        Message r107 = Message.obtain();
        r107.what = MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_TRC;
        r107.arg1 = r106;
        monitor-enter(this);
        Handler r108 = this.f487023f;     // Catch: Throwable -> L20
        if (r108 == null) goto L18;
        r108.sendMessage(r107);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
    L20:
        th = move-exception;
        throw th;
    L23:
        List<String> r109 = this.f487040w;
        if (r109 == null) goto L27;
        ((ArrayList) r109).clear();
    L27:
        if (ToygerFaceAlgorithmConfig.ZFACE_PHOTINUS_LIVENESS.equals((String) r101.get("message")) == false) goto L78;
        g(MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES);
        goto L78
    L30:
        if (ToygerFaceAlgorithmConfig.ZFACE_PHOTINUS_LIVENESS.equals((String) r101.get("message")) == false) goto L78;
        g(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST);
        goto L78
    L33:
        if (ToygerFaceAlgorithmConfig.ZFACE_PHOTINUS_LIVENESS.equals((String) r101.get("message")) == false) goto L78;
        g(917);
        goto L78
    L36:
        if (ToygerFaceAlgorithmConfig.ZFACE_PHOTINUS_LIVENESS.equals((String) r101.get("message")) == false) goto L38;
        g(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST);
    L38:
        Handler r110 = this.f487023f;
        if (this.f487042y != null) goto L41;
    L47:
        ToygerFaceService r111 = this.f487019b;
        if (r111 == null) goto L78;
        r111.updateNativeState(111, "");     // Catch: Exception -> L51
        goto L78
    L41:
        if (this.f487018a == null) goto L47;
        if (r110 == null) goto L47;
        String r112 = Arrays.toString(((ArrayList) this.f487040w).toArray());
        if (TextUtils.isEmpty(r112) == true) goto L46;
        r112 = r112.replace("[", "").replace("]", "");
    L46:
        RecordService.getInstance().recordEvent(2, "nativePhotinus", new String[]{"usedPhotinus", r112});
        r110.post(new RunnableC6192b(this));
        goto L78
    L53:
        if (r100 != (-4)) goto L55;
        if (r101 == null) goto L71;
        if (r101.get("errSubCode") == null) goto L71;
        if ((r101.get("errSubCode") instanceof String) == false) goto L71;
        r102 = (String) r101.get("errSubCode");
    L71:
        if (TextUtils.isEmpty(r102) == false) goto L78;
        r102 = "Z1001";
        goto L78
    L55:
        if (r100 != (-3)) goto L57;
        r102 = "Z1013";
        goto L78
    L57:
        if (r100 != (-2)) goto L59;
        r102 = "Z1023";
        goto L78
    L59:
        if (r100 != (-1)) goto L78;
        this.f487026i = 1;
        goto L78
    L5:
        r103 = 1;
        goto L6
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final boolean onHighQualityFrame(Bitmap r100, ToygerAttr r101) {
        this.f487022e.f476093b = r100;
        return true;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final void onNativeDataUpdate(int r100, List<ToygerPairFaceInfo> r101, Map<String, String> r102) {
        if (r100 != 100) goto L9;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.size() <= 0) goto L11;
        this.f487039v.addAndGet(1);
        ts7.c.c(new d(this, r101, r102));
        return;
    L11:
        return;
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final boolean onStateUpdated(s r100, ToygerAttr r101, Map r102) {
        ToygerFaceState r103 = (ToygerFaceState) r100;
        ToygerFaceAttr r104 = (ToygerFaceAttr) r101;
        int r105 = r103.messageCode;
        int r106 = r103.staticMessage;
        this.C = r106;
        if (this.B == false) goto L5;
    L7:
        r104.setCurrentAction(faceverify.f.a(r106));
        hs7.d r107 = hs7.d.f487062i;
        if (r107.f487068f != null) goto L10;
    L19:
        hs7.d r108 = hs7.d.f487062i;
        if (r108.f487069g != null) goto L22;
        r108.f487069g = r108.f487063a;
        r108.f487070h = r104;
    L32:
        if (this.f487023f == null) goto L48;
        Message r109 = Message.obtain();
        r109.what = 904;
        r109.arg1 = r105;
        r109.arg2 = this.C;
        faceverify.d r110 = this.f487022e;
        r110.getClass();
        if (r110.f476092a != null) goto L36;
        r110.f476092a = new Bundle();
    L36:
        r110.f476092a.putBoolean("lipMovement", r104.lipMovement);
        r110.f476092a.putBoolean("hasFace", r104.hasFace);
        r110.f476092a.putInt("faceID", r104.faceId);
        r110.f476092a.putInt("actionCode", r103.staticMessage);
        r110.f476092a.putInt("messageCode", r103.messageCode);
        r110.f476092a.putFloat("targetFaceRatio", r103.targetFaceRegion);
        Bundle r111 = this.f487022e.f476092a;
        if (r111 == null) goto L39;
        r109.setData(r111);
    L39:
        monitor-enter(this);
        Handler r112 = this.f487023f;     // Catch: Throwable -> L45
        if (r112 == null) goto L43;
        r112.sendMessage(r109);     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
    L45:
        th = move-exception;
        throw th;
    L48:
        return true;
    L22:
        ToygerFaceAttr r113 = r108.f487070h;
        if (r113 != null) goto L25;
    L29:
        if (r113 != null) goto L32;
        r108.f487070h = r104;
        r108.f487069g = r108.f487063a;
        goto L32
    L25:
        if (r104.hasFace == false) goto L29;
        if (r104.quality <= r113.quality) goto L29;
        r108.f487070h = r104;
        r108.f487069g = r108.f487063a;
        goto L32
    L10:
        if (ClientConfigUtil.b() <= 0) goto L19;
    L17:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        goto L19
    L13:
        if (r107.f487068f.size() <= ClientConfigUtil.b()) goto L15;
        r107.f487068f.remove(0);     // Catch: Throwable -> L17
    L15:
        r107.f487068f.add(r104);     // Catch: Throwable -> L17
        goto L19
    L5:
        if (r105 != 24) goto L7;
        this.B = true;
        o.e(hs7.a.h().getContext());
        RecordService.getInstance().recordEvent(4, "faceServiceConfig", new String[]{"msg", "QUALITY_ERROR"});
        d("Z1048");
        goto L48
    }

    @Override // com.dtf.toyger.base.face.ToygerFaceCallback
    public final boolean onComplete(int r100, byte[] r101, byte[] r102, boolean r103) {
        faceverify.d r104 = this.f487022e;
        r104.f476101j = r101;
        r104.f476102k = r102;
        SgomInfoManager.updateSgomInfo(-129750822, null);
        g(913);
        l r105 = this.A;
        if (r105 != null) goto L5;
    L6:
        i();
        return true;
    L5:
        if (r105.a(4) == false) goto L6;
        return true;
    }
}

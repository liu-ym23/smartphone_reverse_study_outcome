package hs7;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.alipay.zoloz.toyger.blob.FaceDataFrameInfo;
import com.dtf.face.api.IDTFragment;
import com.dtf.face.api.IDTLoadingFragment;
import com.dtf.face.api.IDTUIListener;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.AndroidDocConfig;
import com.dtf.face.config.IConstValues;
import com.dtf.face.config.OSSConfig;
import com.dtf.face.config.Protocol;
import com.dtf.face.config.ProtocolContent;
import com.dtf.face.config.SDKAction;
import com.dtf.face.config.WishConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.model.NetworkEnv;
import com.dtf.face.verify.IFlowCheck;
import com.dtf.face.verify.IOcrResultCallback;
import com.dtf.face.verify.IVerifyResultCallBack;
import com.dtf.toyger.base.face.ToygerFaceAlgorithmConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import us7.h;
import ws7.j;
import ws7.o;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static a T;
    public final AtomicBoolean A;
    public String B;
    public String C;
    public boolean D;
    public boolean E;
    public final Map<String, String> F;
    public boolean G;
    public WeakReference<Context> H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f486988J;
    public long K;
    public String L;
    public String M;
    public boolean N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f486989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f486990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f486991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f486992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f486993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Protocol f486994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OSSConfig f486995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f486996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WishConfig f486997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Class<? extends IDTFragment> f486998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Class f486999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f487000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IDTUIListener f487001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final us7.a f487002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Class<? extends IDTFragment> f487003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Class<? extends IDTLoadingFragment> f487004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public IOcrResultCallback f487005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IVerifyResultCallBack f487006r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IFlowCheck f487007s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public NetworkEnv f487008t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f487009u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f487010v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f487011w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public JSONObject f487012x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f487013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f487014z;

    /* JADX INFO: renamed from: hs7.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes22.dex */
    public class RunnableC6190a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f487015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f487016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f487017c;

        @Override // java.lang.Runnable
        public final void run() {
            IVerifyResultCallBack r100 = this.f487017c.f487006r;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.sendResAndExit(this.f487015a, this.f487016b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC6190a(a r100, String r101, String r102) {
            this.f487017c = r100;
            this.f487015a = r101;
            this.f487016b = r102;
        }
    }

    public static a h() {
        if (T != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (T != null) goto L9;
        T = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return T;
    }

    public final AndroidClientConfig c() {
        Protocol r100 = this.f486994f;
        if (r100 == null) goto L8;
        ProtocolContent r101 = r100.protocolContent;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.androidClientConfig;
    L8:
        return null;
    }

    public final ProtocolContent d() {
        Protocol r100 = this.f486994f;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.protocolContent;
    }

    public final String e() {
        if (this.f487014z != null) goto L6;
        this.f487014z = j.b();
    L6:
        return this.f487014z;
    }

    public final OSSConfig f() {
        Protocol r100 = this.f486994f;
        if (r100 == null) goto L8;
        ProtocolContent r101 = r100.protocolContent;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.dtOSSConfig;
    L8:
        return null;
    }

    public final String g() {
        String r100 = this.f486989a;
        SgomInfoManager.IReport r101 = SgomInfoManager.sReportCrash;
        Class<?> r102 = ss7.a.f543414b;
        String r103 = "";
        if (r102 == null) goto L34;
        if (ss7.a.f543416d == null) goto L34;
        Method r104 = r102.getMethod("getDeviceToken", new Class[]{String.class});     // Catch: Throwable -> L30
        Object r105 = ss7.a.f543416d;     // Catch: Throwable -> L30
        Object[] r110 = new Object[1];     // Catch: Throwable -> L30
        if (r100 != null) goto L11;
        r100 = "";
    L11:
        r110[0] = r100;     // Catch: Throwable -> L30
        Object r106 = r104.invoke(r105, r110);     // Catch: Throwable -> L30
        if (r106 == null) goto L27;
        Class<?> r107 = r106.getClass();     // Catch: Throwable -> L30
        int r111 = ((Integer) r107.getField("code").get(r106)).intValue();     // Catch: Throwable -> L30
        String r108 = String.valueOf(r107.getField("token").get(r106));     // Catch: Throwable -> L30
        if (10000 != r111) goto L16;
    L19:
        String r109 = r108;
    L20:
        if (r101 != null) goto L38;
    L26:
        r103 = r109;
        goto L34
    L38:
        r101.onReport("securityDevcie", "", null, new String[]{"code", String.valueOf(r111), "deviceToken", r108});     // Catch: Throwable -> L24
    L24:
        th = th;
        r103 = r109;
    L31:
        if (r101 == null) goto L34;
        r101.onReport("securityDevcie", "getDeviceTokenError", th, new String[0]);
        goto L34
    L16:
        if (r108.isEmpty() == false) goto L19;
        r109 = "";
        goto L20
    L27:
        if (r101 == null) goto L34;
        r101.onReport("securityDevcie", "", null, new String[]{"getDeviceTokenError", "Security token is null."});     // Catch: Throwable -> L30
    L30:
        th = th;
    L34:
        if (r103.isEmpty() == true) goto L36;
        this.f486992d = r103;
    L36:
        String r112 = this.f486992d;
        this.f486992d = r112;
        return r112;
    }

    public Context getContext() {
        if (this.f486991c != null) goto L8;
        q(h.f551544b.b());
        if (this.A.getAndSet(true) == true) goto L8;
        a("Z1045", null);
    L8:
        return this.f486991c;
    }

    public final OSSConfig i() {
        OSSConfig r100 = this.f486995g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        OSSConfig r101 = f();
        if (r101 == null) goto L8;
        this.L = r101.BucketName;
    L8:
        return r101;
    }

    public final Context j() {
        WeakReference<Context> r100 = this.H;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public final boolean m() {
        Protocol r100 = this.f486994f;
        if (r100 == null) goto L14;
        ProtocolContent r101 = r100.protocolContent;
        if (r101 == null) goto L16;
        AndroidDocConfig r102 = r101.docConfig;
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r102.getColl() != null) goto L11;
        return false;
    L11:
        if ("NFC".equals(this.f486994f.protocolContent.docConfig.getColl().opType) == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        return false;
    L14:
        return false;
    }

    public final boolean n() {
        if (this.I != (-1)) goto L15;
        AndroidClientConfig r100 = h().c();
        if (r100 == null) goto L15;
        JSONObject r101 = r100.getAlgorithm();
        if (r101 == null) goto L15;
        JSONArray r102 = r101.getJSONArray("liveness_combination");
        if (r102 != null) goto L11;
    L13:
        this.I = 0;
        goto L15
    L11:
        if (r102.contains(ToygerFaceAlgorithmConfig.ZFACE_NEARFAR_LIVENESS) == false) goto L13;
        this.I = 1;
    L15:
        if (this.I != 1) goto L18;
        return true;
    L18:
        return false;
    }

    public a() {
        this.f487002n = new us7.a();
        this.f487009u = 20;
        this.f487010v = 20;
        this.f487011w = true;
        this.A = new AtomicBoolean(false);
        this.D = false;
        this.E = false;
        this.F = new HashMap();
        this.G = false;
        this.I = -1;
        this.f486988J = "";
        this.K = -1;
        this.N = false;
        this.O = "";
        this.P = "0";
        this.Q = "0";
        this.R = "0";
        this.S = "ant";
    }

    public final String k() {
        AndroidClientConfig r100 = c();
        if (r100 == null) goto L10;
        HashMap<String, String> r101 = r100.suitable;
        if (r101 != null) goto L7;
        return "0";
    L7:
        if (r101.containsKey(IConstValues.SUITABLE_TYPE_KEY) == true) goto L9;
        return "0";
    L9:
        return r100.suitable.get(IConstValues.SUITABLE_TYPE_KEY);
    L10:
        return "0";
    }

    public final boolean l() {
        AndroidClientConfig r100 = c();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getUi() != 993) goto L7;
        return true;
    }

    public final boolean o() {
        AndroidClientConfig r100 = c();
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList<SDKAction> r101 = r100.getSdkActionList();
        if (r101 != null) goto L8;
    L17:
        return false;
    L8:
        if (r101.size() <= 0) goto L17;
        Iterator<SDKAction> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L17;
        if ("ocr".equalsIgnoreCase(r102.next().actionName) == false) goto L12;
        return true;
    }

    public final void p(Protocol r100) {
        this.K = -1;
        this.f486994f = r100;
        if (r100 == null) goto L12;
        ProtocolContent r101 = r100.protocolContent;
        if (r101 == null) goto L12;
        AndroidClientConfig r102 = r101.androidClientConfig;
        if (r102 != null) goto L9;
    L11:
        FaceDataFrameInfo.info_cache = this.f486994f.protocolContent.token;
        goto L12
    L9:
        if (TextUtils.isEmpty(r102.token) == true) goto L11;
        FaceDataFrameInfo.info_cache = this.f486994f.protocolContent.androidClientConfig.token;
    L12:
        AndroidClientConfig r103 = c();
        if (r103 != null) goto L15;
        SgomInfoManager.setSimpleFlagsDetect(true);
        return;
    L15:
        JSONObject r104 = r103.getSimpleFlags();
        if (r104 != null) goto L18;
    L22:
        SgomInfoManager.setSimpleFlagsDetect(true);
        return;
    L18:
        if (r104.containsKey("enable") == false) goto L22;
        if (r104.getBooleanValue("enable") == true) goto L22;
        SgomInfoManager.setSimpleFlagsDetect(false);
    }

    public final void q(Context r100) {
        if (this.f486991c != null) goto L8;
        if (r100 == null) goto L9;
        this.f486991c = r100.getApplicationContext();
        return;
    L9:
        return;
    }

    public final void r(String r100) {
        AndroidClientConfig r101 = c();
        if (r101 == null) goto L6;
        r101.suitable.put(IConstValues.SUITABLE_TYPE_KEY, r100);
        return;
    }

    public final void a(String r100, String r101) {
        if ("Z1040".equals(r100) == false) goto L5;
        o.e(h().getContext());
    L5:
        RecordService.getInstance().recordEvent(2, "sendErrorCode", new String[]{"errCode", r100});
        if (RecordService.NEED_FILE_LOG == true) goto L9;
        RecordService.getInstance().flush(true);
    L9:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L11;
        new Handler(Looper.getMainLooper()).post(new RunnableC6190a(this, r100, r101));
        return;
    L11:
        IVerifyResultCallBack r102 = this.f487006r;
        if (r102 == null) goto L16;
        r102.sendResAndExit(r100, r101);
        return;
    }

    public final boolean b(String r100, String r101, long r102) {
        boolean r103 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        return r103;
    L5:
        if (r100.equalsIgnoreCase(this.f486989a) == true) goto L10;
        RecordService r104 = RecordService.getInstance();
        String[] r105 = new String[8];
        r105[0] = "certifyId";
        r103 = true;
        r105[1] = r100;
        r105[2] = "actionName";
        r105[3] = r101;
        r105[4] = ChameleonOpenTracker.ParamKey.COST;
        r105[5] = String.valueOf(r102);
        r105[6] = "errMsg";
        String r106 = null;
        if (TextUtils.isEmpty(null) == false) goto L9;
        r106 = "NULL";
    L9:
        r105[7] = r106;
        r104.recordEvent(4, "expiredCertification", r105);
        goto L10
    }
}

package of4;

import android.app.Activity;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import cd4.k;
import cd4.m;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import com.bytedance.caijing.sdk.infra.base.api.container.interfaceWrapper.JSBResult;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerName;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerType;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.PlugInContainerService;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.h5jsb.geninfo.CJJsbError;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.ContainerUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements qd4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f523075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qd4.a f523076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f523077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ee4.c f523078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f523079e;

    /* JADX INFO: renamed from: of4.a$a, reason: collision with other inner class name */
    public class C7044a implements ld4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f523080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f523081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f523082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f523083d;

        @Override // ld4.a
        public final String getCallbackId() {
            return "";
        }

        @Override // ld4.a
        public Activity getActivity() {
            IBridgeContext r100 = this.f523080a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getActivity();
        }

        @Override // ld4.a
        public final WebView getWebView() {
            IBridgeContext r100 = this.f523080a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getWebView();
        }

        @Override // ld4.a
        public final void callback(JSBResult r110) {
            String r100 = "";
            of4.b r101 = new of4.b(0, "");
            BridgeResult r102 = BridgeResult.Companion.createErrorResult();
            r102.setCode(r110.f202212a);
            r102.setMessage(r110.f202213b);
            r102.setData(r110.f202214c);
            of4.c.a(r102, r110.f202215d);
            if (r110.f202212a == 0) goto L5;
            a r103 = this.f523083d;
            IBridgeContext r104 = this.f523080a;
            long r105 = this.f523081b;
            ContainerUtils r106 = ContainerUtils.f202693a;
            a.a(r103, r104, r102, r101, r105, "ttcjpay.chooseMedia", ContainerUtils.c(this.f523082c));
            return;
        L5:
            CJJsbError r107 = CJJsbError.f202601a;
            if (r107.a("ttcjpay.chooseMedia") == null) goto L12;
            r101 = r107.a("ttcjpay.chooseMedia");
            String r111 = r110.f202213b;
            r101.getClass();
            if (r111 == null) goto L11;
            r100 = r111;
        L11:
            r101.f523100b = r100;
        L12:
            a r108 = this.f523083d;
            IBridgeContext r109 = this.f523080a;
            long r112 = this.f523081b;
            ContainerUtils r113 = ContainerUtils.f202693a;
            a.a(r108, r109, r102, r101, r112, "ttcjpay.chooseMedia", ContainerUtils.c(this.f523082c));
        }

        public C7044a(a r100, IBridgeContext r101, long r102, JSONObject r103) {
            this.f523083d = r100;
            this.f523080a = r101;
            this.f523081b = r102;
            this.f523082c = r103;
        }
    }

    public class b implements ld4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f523084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f523085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f523086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f523087d;

        @Override // ld4.a
        public final String getCallbackId() {
            return "";
        }

        @Override // ld4.a
        public Activity getActivity() {
            IBridgeContext r100 = this.f523084a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getActivity();
        }

        @Override // ld4.a
        public final WebView getWebView() {
            IBridgeContext r100 = this.f523084a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getWebView();
        }

        @Override // ld4.a
        public final void callback(JSBResult r110) {
            String r100 = "";
            of4.b r101 = new of4.b(0, "");
            BridgeResult r102 = BridgeResult.Companion.createErrorResult();
            r102.setCode(r110.f202212a);
            r102.setMessage(r110.f202213b);
            r102.setData(r110.f202214c);
            of4.c.a(r102, r110.f202215d);
            if (r110.f202212a == 0) goto L5;
            a r103 = this.f523087d;
            IBridgeContext r104 = this.f523084a;
            long r105 = this.f523085b;
            ContainerUtils r106 = ContainerUtils.f202693a;
            a.a(r103, r104, r102, r101, r105, "ttcjpay.uploadMedia", ContainerUtils.c(this.f523086c));
            return;
        L5:
            CJJsbError r107 = CJJsbError.f202601a;
            if (r107.a("ttcjpay.uploadMedia") == null) goto L12;
            r101 = r107.a("ttcjpay.uploadMedia");
            String r111 = r110.f202213b;
            r101.getClass();
            if (r111 == null) goto L11;
            r100 = r111;
        L11:
            r101.f523100b = r100;
        L12:
            a r108 = this.f523087d;
            IBridgeContext r109 = this.f523084a;
            long r112 = this.f523085b;
            ContainerUtils r113 = ContainerUtils.f202693a;
            a.a(r108, r109, r102, r101, r112, "ttcjpay.uploadMedia", ContainerUtils.c(this.f523086c));
        }

        public b(a r100, IBridgeContext r101, long r102, JSONObject r103) {
            this.f523087d = r100;
            this.f523084a = r101;
            this.f523085b = r102;
            this.f523086c = r103;
        }
    }

    public class c implements ld4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeContext f523088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f523089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f523090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f523091d;

        @Override // ld4.a
        public final String getCallbackId() {
            return "";
        }

        @Override // ld4.a
        public Activity getActivity() {
            return this.f523088a.getActivity();
        }

        @Override // ld4.a
        public final WebView getWebView() {
            return this.f523088a.getWebView();
        }

        @Override // ld4.a
        public final void callback(JSBResult r110) {
            BridgeResult r100 = BridgeResult.Companion.createErrorResult(r110.f202213b, r110.f202214c);
            r100.setCode(r110.f202212a);
            r100.setMessage(r110.f202213b);
            r100.setData(r110.f202214c);
            of4.c.a(r100, r110.f202215d);
            this.f523088a.callback(r100);
            if (r110.f202212a == BridgeResult.CODE.SUCCESS.getValue()) goto L8;
            of4.b r101 = CJJsbError.f202601a.a("ttcjpay.saveImgToAlbum");
            String r111 = "fail:" + r110.f202212a;
            r101.getClass();
            if (r111 != null) goto L7;
            r111 = "";
        L7:
            r101.f523100b = r111;
            of4.b r102 = r101;
        L9:
            a r103 = this.f523091d;
            IBridgeContext r104 = this.f523088a;
            long r105 = this.f523089b;
            ContainerUtils r112 = ContainerUtils.f202693a;
            a.a(r103, r104, r100, r102, r105, "ttcjpay.saveImgToAlbum", ContainerUtils.c(this.f523090c));
            return;
        L8:
            r102 = null;
            goto L9
        }

        public c(a r100, IBridgeContext r101, long r102, JSONObject r103) {
            this.f523091d = r100;
            this.f523088a = r101;
            this.f523089b = r102;
            this.f523090c = r103;
        }
    }

    public class d implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f523092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f523093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IBridgeContext f523094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f523095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a f523096e;

        /* JADX INFO: renamed from: of4.a$d$a, reason: collision with other inner class name */
        public class C7045a implements md4.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f523097a;

            @Override // md4.b
            public final Map<String, String> getReportParams() {
                return null;
            }

            @Override // md4.b
            public final String getContainerId() {
                Activity r100 = this.f523097a.f523096e.f523075a;
                if (r100 != null) goto L5;
                return "";
            L5:
                return String.valueOf(r100.hashCode());
            }

            @Override // md4.b
            public final String getSchema() {
                qd4.a r100 = this.f523097a.f523096e.f523076b;
                if (r100 != null) goto L5;
                return "";
            L5:
                if (TextUtils.isEmpty(r100.getSchema()) == false) goto L7;
                return "";
            L7:
                return this.f523097a.f523096e.f523076b.getSchema();
            }

            @Override // md4.b
            public final Map<String, String> getSecurityHeader() {
                qd4.a r100 = this.f523097a.f523096e.f523076b;
                if (r100 != null) goto L5;
                return null;
            L5:
                return r100.getSecurityHeader();
            }

            @Override // md4.b
            public final ContainerName a() {
                return ContainerName.CJ_H5;
            }

            @Override // md4.b
            public final ContainerType getContainerType() {
                return ContainerType.H5;
            }

            public C7045a(d r100) {
                this.f523097a = r100;
            }
        }

        @Override // cd4.k
        public final void onStart(m r100) {
            this.f523092a = SystemClock.elapsedRealtime();
            if (r100 == null) goto L6;
            this.f523096e.f523079e = r100;
            r100.putDependency(md4.b.class, new C7045a(this));
            return;
        }

        @Override // cd4.k
        public final void onSuccess(JSONObject r100) {
            if (r100 != null) goto L9;
            BridgeResult r101 = BridgeResult.Companion.createSuccessResult();
        L6:
            BridgeResult r102 = r101;
            a r103 = this.f523096e;
            IBridgeContext r104 = this.f523094c;
            long r105 = this.f523092a;
            String r106 = this.f523093b;
            ContainerUtils r107 = ContainerUtils.f202693a;
            a.a(r103, r104, r102, null, r105, r106, ContainerUtils.c(this.f523095d));
            return;
        L9:
            r100.put("cj_jsb_native_callback_timestamp", System.currentTimeMillis());     // Catch: Exception -> L8
        L4:
            r101 = BridgeResult.Companion.createSuccessResult(r100);
            goto L6
        }

        @Override // cd4.k
        public final void onFailed(String r110, JSONObject r111) {
            r111.put("cj_jsb_native_callback_timestamp", System.currentTimeMillis());     // Catch: Exception -> L4
        L5:
            BridgeResult r100 = BridgeResult.Companion.createErrorResult(r110, r111);
            of4.b r101 = CJJsbError.f202601a.a(this.f523093b);
            if (r101 == null) goto L10;
            if (r110 != null) goto L9;
            r110 = "";
        L9:
            r101.f523100b = r110;
        L10:
            a r102 = this.f523096e;
            IBridgeContext r103 = this.f523094c;
            long r104 = this.f523092a;
            String r105 = this.f523093b;
            ContainerUtils r112 = ContainerUtils.f202693a;
            a.a(r102, r103, r100, r101, r104, r105, ContainerUtils.c(this.f523095d));
        }

        public d(a r100, IBridgeContext r101, String r102, JSONObject r103) {
            this.f523096e = r100;
            this.f523092a = -1;
            this.f523093b = "";
            this.f523094c = r101;
            this.f523095d = r103;
            this.f523093b = r102;
        }
    }

    public class e implements ld4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IBridgeContext f523098a;

        @Override // ld4.a
        public final String getCallbackId() {
            return "";
        }

        @Override // ld4.a
        public Activity getActivity() {
            IBridgeContext r100 = this.f523098a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getActivity();
        }

        @Override // ld4.a
        public final WebView getWebView() {
            IBridgeContext r100 = this.f523098a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getWebView();
        }

        public e(IBridgeContext r100) {
            this.f523098a = null;
            this.f523098a = r100;
        }

        @Override // ld4.a
        public final void callback(JSBResult r110) {
            IBridgeContext r100 = this.f523098a;
            if (r100 == null) goto L46;
            Method r101 = of4.c.f523101a;
            JSONObject r102 = r110.f202214c;
            String r103 = r110.f202213b;
            boolean r111 = r110.f202215d;
            Method r104 = of4.c.f523101a;
            if (r104 == null) goto L47;
        L11:
            Class<?> r105 = null;
            if (r104 != null) goto L49;
        L18:
            Integer r106 = null;
        L19:
            if (r106 != null) goto L22;
        L24:
            if (r106 == null) goto L37;
            if (r106.intValue() != 2) goto L37;
            Object r112 = r104.invoke(null, new Object[]{r102, r103});     // Catch: InvocationTargetException -> L16
        L29:
            if ((r112 instanceof BridgeResult) == false) goto L31;
            r100.callback((BridgeResult) r112);
            return;
        L31:
            StringBuilder r107 = new StringBuilder("Unexpected result type: ");
            if (r112 == null) goto L34;
            r105 = r112.getClass();
        L34:
            r107.append(r105);
            throw new IllegalStateException(r107.toString());
        L37:
            throw new IllegalStateException("Unsupported method signature");     // Catch: InvocationTargetException -> L16
        L22:
            if (r106.intValue() != 3) goto L24;
            r112 = r104.invoke(null, new Object[]{r102, r103, Boolean.valueOf(r111)});     // Catch: InvocationTargetException -> L16
            goto L29
        L49:
            Class<?>[] r108 = r104.getParameterTypes();     // Catch: InvocationTargetException -> L16
            if (r108 == null) goto L18;
            r106 = Integer.valueOf(r108.length);     // Catch: InvocationTargetException -> L16
        L16:
            e = move-exception;
            Throwable r109 = e.getTargetException();
            if (r109 != null) goto L42;
            throw e;
        L42:
            throw r109;
        L47:
            Method r113 = BridgeResult.class.getMethod("createSuccessResult", new Class[]{JSONObject.class, String.class, Boolean.TYPE});     // Catch: NoSuchMethodException -> L10
            of4.c.f523101a = r113;     // Catch: NoSuchMethodException -> L10
            r104 = r113;
        L10:
            r104 = BridgeResult.class.getMethod("createSuccessResult", new Class[]{JSONObject.class, String.class});     // Catch: NoSuchMethodException -> L43
            of4.c.f523101a = r104;     // Catch: NoSuchMethodException -> L43
        L43:
            e = move-exception;
            throw new IllegalStateException("BridgeResult.createSuccessResult method not found", e);
        }
    }

    @Override // qd4.c
    public final void release() {
        this.f523075a = null;
        this.f523076b = null;
        m r100 = this.f523079e;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // qd4.c
    public final JSONObject w1() {
        JSONObject r100 = new JSONObject();
        r100.put("platform", "share_native");     // Catch: Exception -> L7
        qd4.a r101 = this.f523076b;     // Catch: Exception -> L7
        if (r101 == null) goto L6;
        r100.put("url", r101.getUrl());     // Catch: Exception -> L7
    L6:
        return r100;
    }

    @BridgeMethod("ttcjpay.blockNativeBack")
    public void blockNativeBack(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.blockNativeBack");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.blockNativeBack", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.ccmGetEntryInfo")
    public void ccmGetEntryInfo(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.ccmGetEntryInfo");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.ccmGetEntryInfo", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.getAppInfo")
    public void getAppInfo(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.getAppInfo");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.getAppInfo", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.getH5InitTime")
    public void getH5InitTime(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.getH5InitTime");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.getH5InitTime", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.vipInfo")
    public void getVipInfo(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.vipInfo");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.vipInfo", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.goSettings")
    public void goSettings(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.goSettings");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.goSettings", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.hideLoading")
    public void hideLoading(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.hideLoading");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.hideLoading", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.login")
    public void loginFailure(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.login");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.login", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.setVisible")
    public void notifyWebViewVisibility(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.setVisible");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.setVisible", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.payInfo")
    public void payInfo(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.payInfo");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.payInfo", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.disableHistory")
    public void setDisableHistory(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.disableHistory");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.disableHistory", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.showLoading")
    public void showLoading(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.showLoading");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.showLoading", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.supportFile")
    public void supportFile(@BridgeContext IBridgeContext r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        ee4.c r102 = this.f523078d;     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        m r103 = r102.getH5JSB("ttcjpay.supportFile");     // Catch: Exception -> L9
        if (r103 == null) goto L13;
        r103.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r103.handle(r100.getActivity(), r101, new d(this, r100, "ttcjpay.supportFile", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    public a(AppCompatActivity r100, qd4.a r101) {
        this.f523077c = "";
        this.f523075a = r100;
        this.f523076b = r101;
        ve4.a.f554342a.getClass();
        PlugInContainerService r102 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        if (r102 == null) goto L6;
        this.f523078d = r102.getJSBHelper();
        return;
    }

    @BridgeMethod("ttcjpay.openAppByScheme")
    private void openAppByScheme(@BridgeContext IBridgeContext r100, @BridgeParam("app_scheme") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("app_scheme", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.openAppByScheme");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.openAppByScheme", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.authAlipay")
    public void authAlipay(@BridgeContext IBridgeContext r100, @BridgeParam("infoStr") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("infoStr", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.authAlipay");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.authAlipay", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.checkAppInstalled")
    public void checkAppInstalled(@BridgeContext IBridgeContext r100, @BridgeParam("open_url") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("open_url", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.checkAppInstalled");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.checkAppInstalled", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.close")
    public void closeCurrentActivity(@BridgeContext IBridgeContext r100, @BridgeParam("disable_animation") int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("disable_animation", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.close");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.close", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.closeWebview")
    public void closeWebView(@BridgeContext IBridgeContext r100, @BridgeParam("id") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("id", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.closeWebview");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.closeWebview", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.copyToClipboard")
    public void copyToClipboard(@BridgeContext IBridgeContext r100, @BridgeParam("text") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("text", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.copyToClipboard");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.copyToClipboard", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.deviceInfo")
    public void deviceInfo(@BridgeContext IBridgeContext r100, @BridgeParam("type") int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("type", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.deviceInfo");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.deviceInfo", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.disallowCapture")
    public void disallowCapture(@BridgeContext IBridgeContext r100, @BridgeParam("disallow") int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("disallow", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.disallowCapture");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.disallowCapture", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.dnsPrefetch")
    public void dnsPrefetch(@BridgeContext IBridgeContext r100, @BridgeParam("host") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("host", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.dnsPrefetch");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.dnsPrefetch", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.dypay")
    public void dypay(@BridgeContext IBridgeContext r100, @BridgeParam("sdk_info") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("sdk_info", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.dypay");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.dypay", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.decrypt")
    public void executeDecrypt(@BridgeContext IBridgeContext r100, @BridgeParam("data") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("data", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.decrypt");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.decrypt", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.pay")
    public void executePay(@BridgeContext IBridgeContext r100, @BridgeParam("data") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("data", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.pay");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.pay", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.isAppInstalled")
    public void getAppIsInstalled(@BridgeContext IBridgeContext r100, @BridgeParam("open_url") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("open_url", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.isAppInstalled");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.isAppInstalled", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.getMegaObject")
    public void getMegaObject(@BridgeContext IBridgeContext r100, @BridgeParam("id") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("id", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.getMegaObject");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.getMegaObject", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.getPhoneInfo")
    public void getPhoneInfo(@BridgeContext IBridgeContext r100, @BridgeParam(ReportConstant.COMMON_ACTION_TYPE) String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L12
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r102.put(ReportConstant.COMMON_ACTION_TYPE, r101);     // Catch: Exception -> L12
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L12
        if (r103 == null) goto L15;
        m r104 = r103.getH5JSB("ttcjpay.getPhoneInfo");     // Catch: Exception -> L12
        if (r104 == null) goto L16;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L12
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.getPhoneInfo", r102));     // Catch: Exception -> L12
        return;
    L16:
        return;
    L15:
        return;
    }

    @BridgeMethod("ttcjpay.goMyBankCard")
    public void goMyBankCard(@BridgeContext IBridgeContext r100, @BridgeParam("params") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("params", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.goMyBankCard");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.goMyBankCard", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.goRecharge")
    public void goRecharge(@BridgeContext IBridgeContext r100, @BridgeParam("params") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("params", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.goRecharge");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.goRecharge", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.performanceTracker")
    public void performanceTracker(@BridgeContext IBridgeContext r100, @BridgeParam("event_list") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("event_list", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.performanceTracker");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.performanceTracker", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.preconnect")
    public void preConnect(@BridgeContext IBridgeContext r100, @BridgeParam("urls") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("urls", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.preconnect");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.preconnect", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.prefetchData")
    public void prefetchData(@BridgeContext IBridgeContext r100, @BridgeParam("path") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("path", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.prefetchData");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.prefetchData", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("registerBtmPage")
    public void registerBtmPage(@BridgeContext IBridgeContext r100, @BridgeParam("btm") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L12
        r102.put("btm", r101);     // Catch: Exception -> L12
        ve4.a.f554342a.getClass();     // Catch: Exception -> L12
        IJsbService r103 = (IJsbService) ve4.a.a(IJsbService.class);     // Catch: Exception -> L12
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.getXBridgeHelper() == null) goto L16;
        com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.b r104 = r103.getXBridgeHelper().c("registerBtmPage", r100.getWebView(), r100.getActivity());     // Catch: Exception -> L12
        if (r104 == null) goto L17;
        Intrinsics.checkNotNullParameter(qd4.a.class, "clazz");     // Catch: Exception -> L12
        r104.handle(r100.getActivity(), r102, new d(this, r100, "registerBtmPage", r102));     // Catch: Exception -> L12
        return;
    L17:
        return;
    L16:
        return;
    }

    @BridgeMethod("ttcjpay.sendDeviceInfo")
    public void sendDeviceInfo(@BridgeContext IBridgeContext r100, @BridgeParam("scene") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("scene", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.sendDeviceInfo");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.sendDeviceInfo", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.setWebviewInfo")
    public void setWebViewInfo(@BridgeContext IBridgeContext r100, @BridgeParam("id") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("id", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.setWebviewInfo");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.setWebviewInfo", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.showToast")
    public void showToast(@BridgeContext IBridgeContext r100, @BridgeParam("message") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("message", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.showToast");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.showToast", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.signAlipay")
    public void signAliPay(@BridgeContext IBridgeContext r100, @BridgeParam("sign_params") String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("sign_params", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.signAlipay");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.signAlipay", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.disableDragBack")
    public void switchDragBack(@BridgeContext IBridgeContext r100, @BridgeParam("disable") int r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("disable", r101);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.disableDragBack");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.disableDragBack", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.callHostApp")
    public void callHostApp(@BridgeContext IBridgeContext r100, @BridgeParam(com.alipay.sdk.m.p.e.f25671s) String r101, @BridgeParam("data") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put(com.alipay.sdk.m.p.e.f25671s, r101);     // Catch: Exception -> L9
        r103.put("data", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.callHostApp");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.callHostApp", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.checkLivePlugin")
    public void checkLivePlugin(@BridgeContext IBridgeContext r100, @BridgeParam("is_install_background") boolean r101, @BridgeParam("is_only_check") boolean r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("is_install_background", r101);     // Catch: Exception -> L9
        r103.put("is_only_check", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.checkLivePlugin");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.checkLivePlugin", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.ai")
    public void cjAi(@BridgeContext IBridgeContext r100, @BridgeParam("biz") String r101, @BridgeParam("params") JSONObject r102) {
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L9
        r103.put("biz", r101);     // Catch: Throwable -> L9
        r103.put("params", r102);     // Catch: Throwable -> L9
        ee4.c r104 = this.f523078d;     // Catch: Throwable -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.ai");     // Catch: Throwable -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Throwable -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.ai", r103));     // Catch: Throwable -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("createBtmChain")
    public void createBtmChain(@BridgeContext IBridgeContext r100, @BridgeParam("btm") String r101, @BridgeParam("enter_new_page") boolean r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L12
        r103.put("btm", r101);     // Catch: Exception -> L12
        r103.put("enter_new_page", r102);     // Catch: Exception -> L12
        ve4.a.f554342a.getClass();     // Catch: Exception -> L12
        IJsbService r104 = (IJsbService) ve4.a.a(IJsbService.class);     // Catch: Exception -> L12
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.getXBridgeHelper() == null) goto L16;
        com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.utils.b r105 = r104.getXBridgeHelper().c("createBtmChain", r100.getWebView(), r100.getActivity());     // Catch: Exception -> L12
        if (r105 == null) goto L17;
        Intrinsics.checkNotNullParameter(qd4.a.class, "clazz");     // Catch: Exception -> L12
        r105.handle(r100.getActivity(), r103, new d(this, r100, "createBtmChain", r103));     // Catch: Exception -> L12
        return;
    L17:
        return;
    L16:
        return;
    }

    @BridgeMethod("ttcjpay.facepp")
    public void doFaceWithKS(@BridgeContext IBridgeContext r100, @BridgeParam("url") String r101, @BridgeParam(CJDyPayResult.EXT_K_RETURN_URL) String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("url", r101);     // Catch: Exception -> L9
        r103.put(CJDyPayResult.EXT_K_RETURN_URL, r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.facepp");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.facepp", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.downloadFile")
    public void downloadPdfFile(@BridgeContext IBridgeContext r100, @BridgeParam("download_url") String r101, @BridgeParam("file_name") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("download_url", r101);     // Catch: Exception -> L9
        r103.put("file_name", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.downloadFile");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.downloadFile", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.dyVerify")
    public void dyVerify(@BridgeContext IBridgeContext r100, @BridgeParam("verify_id") String r101, @BridgeParam("verify_token") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("verify_id", r101);     // Catch: Exception -> L9
        r103.put("verify_token", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.dyVerify");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.dyVerify", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.sendNotification")
    public void executeSendNotification(@BridgeContext IBridgeContext r100, @BridgeParam("data") String r101, @BridgeParam("type") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("data", r101);     // Catch: Exception -> L9
        r103.put("type", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.sendNotification");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.sendNotification", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.abTest")
    public void getABTest(@BridgeContext IBridgeContext r100, @BridgeParam("ab_setting_key") String r101, @BridgeParam("isExposure") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("ab_setting_key", r101);     // Catch: Exception -> L9
        r103.put("isExposure", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.abTest");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.abTest", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.openPage")
    public void openPage(@BridgeContext IBridgeContext r100, @BridgeParam("goto_type") String r101, @BridgeParam("url") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("goto_type", r101);     // Catch: Exception -> L9
        r103.put("url", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.openPage");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.openPage", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.operateCert")
    public void operateCert(@BridgeContext IBridgeContext r100, @BridgeParam("action_type") String r101, @BridgeParam("action_params") JSONObject r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("action_type", r101);     // Catch: Exception -> L9
        r103.put("action_params", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.operateCert");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.operateCert", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("pia.rendering.execute")
    public void piaMethod(@BridgeContext IBridgeContext r100, @BridgeParam("url") String r101, @BridgeParam(PerfLog.PARAM_KEY_CONTEXT_ID) JSONObject r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("url", r101);     // Catch: Exception -> L9
        r103.put(PerfLog.PARAM_KEY_CONTEXT_ID, r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("pia.rendering.execute");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "pia.rendering.execute", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.requestWXH5Payment")
    public void requestWXH5Payment(@BridgeContext IBridgeContext r100, @BridgeParam("url") String r101, @BridgeParam(AppConstants.BUNDLE_REFERER) String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("url", r101);     // Catch: Exception -> L9
        r103.put(AppConstants.BUNDLE_REFERER, r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.requestWXH5Payment");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.requestWXH5Payment", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.saveImgToAlbum")
    public void saveImgToAlbum(@BridgeContext IBridgeContext r110, @BridgeParam("dataURL") String r111, @BridgeParam("extension") String r112) {
        long r100 = System.currentTimeMillis();     // Catch: Exception -> L9
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        r101.put("data_url", r111);     // Catch: Exception -> L9
        r101.put("extension", r112);     // Catch: Exception -> L9
        ee4.c r113 = this.f523078d;     // Catch: Exception -> L9
        if (r113 == null) goto L12;
        m r114 = r113.getH5JSB("ttcjpay.saveImgToAlbum");     // Catch: Exception -> L9
        if (r114 == null) goto L13;
        r114.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r114.putDependency(ld4.a.class, new c(this, r110, r100, r101));     // Catch: Exception -> L9
        r114.handle(r110.getActivity(), r101, new d(this, r110, "ttcjpay.saveImgToAlbum", r101));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.sendLog")
    public void sendLog(@BridgeContext IBridgeContext r100, @BridgeParam("event") String r101, @BridgeParam("params") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("event", r101);     // Catch: Exception -> L9
        r103.put("params", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.sendLog");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.sendLog", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.setDeviceInfo")
    public void setDeviceInfo(@BridgeContext IBridgeContext r100, @BridgeParam("page") int r101, @BridgeParam("action") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("page", r101);     // Catch: Exception -> L9
        r103.put("action", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.setDeviceInfo");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.setDeviceInfo", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.setTitle")
    public void setWebViewText(@BridgeContext IBridgeContext r100, @BridgeParam("title") String r101, @BridgeParam("subTitle") String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
        r103.put("title", r101);     // Catch: Exception -> L9
        r103.put("subTitle", r102);     // Catch: Exception -> L9
        ee4.c r104 = this.f523078d;     // Catch: Exception -> L9
        if (r104 == null) goto L12;
        m r105 = r104.getH5JSB("ttcjpay.setTitle");     // Catch: Exception -> L9
        if (r105 == null) goto L13;
        r105.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r105.handle(r100.getActivity(), r103, new d(this, r100, "ttcjpay.setTitle", r103));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.alog")
    public void alog(@BridgeContext IBridgeContext r100, @BridgeParam("level") String r101, @BridgeParam("tag") String r102, @BridgeParam("log") String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L9
        r104.put("tag", r102);     // Catch: Exception -> L9
        r104.put("log", r103);     // Catch: Exception -> L9
        r104.put("level", r101);     // Catch: Exception -> L9
        ee4.c r105 = this.f523078d;     // Catch: Exception -> L9
        if (r105 == null) goto L12;
        m r106 = r105.getH5JSB("ttcjpay.alog");     // Catch: Exception -> L9
        if (r106 == null) goto L13;
        r106.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r106.handle(r100.getActivity(), r104, new d(this, r100, "ttcjpay.alog", r104));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.certPluginPreload")
    public void certPluginPreload(@BridgeContext IBridgeContext r100, @BridgeParam("risk_source") String r101, @BridgeParam("silent_install") Boolean r102, @BridgeParam("merchant_id") String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L16
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r104.put("risk_source", r101);     // Catch: Exception -> L16
        r104.put("silent_install", r102);     // Catch: Exception -> L16
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r104.put("merchant_id", r103);     // Catch: Exception -> L16
        ee4.c r105 = this.f523078d;     // Catch: Exception -> L16
        if (r105 == null) goto L19;
        m r106 = r105.getH5JSB("ttcjpay.certPluginPreload");     // Catch: Exception -> L16
        if (r106 == null) goto L20;
        r106.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L16
        r106.handle(r100.getActivity(), r104, new d(this, r100, "ttcjpay.certPluginPreload", r104));     // Catch: Exception -> L16
        return;
    L20:
        return;
    L19:
        return;
    }

    @BridgeMethod("ttcjpay.encrypt")
    public void executeEncrypt(@BridgeContext IBridgeContext r100, @BridgeParam("data") String r101, @BridgeParam("public_key") String r102, @BridgeParam("isec_key") String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L9
        r104.put("data", r101);     // Catch: Exception -> L9
        r104.put("public_key", r102);     // Catch: Exception -> L9
        r104.put("isec_key", r103);     // Catch: Exception -> L9
        ee4.c r105 = this.f523078d;     // Catch: Exception -> L9
        if (r105 == null) goto L12;
        m r106 = r105.getH5JSB("ttcjpay.encrypt");     // Catch: Exception -> L9
        if (r106 == null) goto L13;
        r106.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r106.handle(r100.getActivity(), r104, new d(this, r100, "ttcjpay.encrypt", r104));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.publishEvent")
    public void publishEvent(@BridgeContext IBridgeContext r100, @BridgeParam(ReportCardMonitorPlugin.EVENT_NAME) String r101, @BridgeParam("params") String r102, @BridgeParam("timestamp") String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L9
        r104.put(ReportCardMonitorPlugin.EVENT_NAME, r101);     // Catch: Exception -> L9
        r104.put("params", r102);     // Catch: Exception -> L9
        r104.put("timestamp", r103);     // Catch: Exception -> L9
        ee4.c r105 = this.f523078d;     // Catch: Exception -> L9
        if (r105 == null) goto L12;
        m r106 = r105.getH5JSB("ttcjpay.publishEvent");     // Catch: Exception -> L9
        if (r106 == null) goto L13;
        r106.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r106.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r106.handle(r100.getActivity(), r104, new d(this, r100, "ttcjpay.publishEvent", r104));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.sendPageStatus")
    public void sendPageStatus(@BridgeContext IBridgeContext r100, @BridgeParam("code") int r101, @BridgeParam("url") String r102, @BridgeParam(LocationMonitorConst.ERR_MSG) String r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L9
        r104.put("code", String.valueOf(r101));     // Catch: Exception -> L9
        r104.put("url", r102);     // Catch: Exception -> L9
        r104.put(LocationMonitorConst.ERR_MSG, r103);     // Catch: Exception -> L9
        ee4.c r105 = this.f523078d;     // Catch: Exception -> L9
        if (r105 == null) goto L12;
        m r106 = r105.getH5JSB("ttcjpay.sendPageStatus");     // Catch: Exception -> L9
        if (r106 == null) goto L13;
        r106.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r106.handle(r100.getActivity(), r104, new d(this, r100, "ttcjpay.sendPageStatus", r104));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.iDaaSAuth")
    public void iDaaSAuth(@BridgeContext IBridgeContext r100, @BridgeParam("cmccAppId") String r101, @BridgeParam("cmccParams") String r102, @BridgeParam("needLoading") Boolean r103, @BridgeParam("overTime") Long r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L16
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r105.put("cmccAppId", r101);     // Catch: Exception -> L16
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r105.put("cmccParams", r102);     // Catch: Exception -> L16
        r105.put("needLoading", r103);     // Catch: Exception -> L16
        r105.put("overTime", r104);     // Catch: Exception -> L16
        ee4.c r106 = this.f523078d;     // Catch: Exception -> L16
        if (r106 == null) goto L19;
        m r107 = r106.getH5JSB("ttcjpay.iDaaSAuth");     // Catch: Exception -> L16
        if (r107 == null) goto L20;
        r107.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L16
        r107.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.iDaaSAuth", r105));     // Catch: Exception -> L16
        return;
    L20:
        return;
    L19:
        return;
    }

    @BridgeMethod("ttcjpay.sendMonitor")
    public void sendMonitor(@BridgeContext IBridgeContext r100, @BridgeParam("event") String r101, @BridgeParam("params") String r102, @BridgeParam("category") String r103, @BridgeParam("metric") String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        r105.put("event", r101);     // Catch: Exception -> L9
        r105.put("params", r102);     // Catch: Exception -> L9
        r105.put("category", r103);     // Catch: Exception -> L9
        r105.put("metric", r104);     // Catch: Exception -> L9
        ee4.c r106 = this.f523078d;     // Catch: Exception -> L9
        if (r106 == null) goto L12;
        m r107 = r106.getH5JSB("ttcjpay.sendMonitor");     // Catch: Exception -> L9
        if (r107 == null) goto L13;
        r107.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r107.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.sendMonitor", r105));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.updatePayTypeInfo")
    public void updatePayTypeInfo(@BridgeContext IBridgeContext r100, @BridgeParam("default_pay_channel") String r101, @BridgeParam("pay_channels") String r102, @BridgeParam("app_id") String r103, @BridgeParam("merchant_id") String r104) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        r105.put("default_pay_channel", r101);     // Catch: Exception -> L9
        r105.put("pay_channels", r102);     // Catch: Exception -> L9
        r105.put("app_id", r103);     // Catch: Exception -> L9
        r105.put("merchant_id", r104);     // Catch: Exception -> L9
        ee4.c r106 = this.f523078d;     // Catch: Exception -> L9
        if (r106 == null) goto L12;
        m r107 = r106.getH5JSB("ttcjpay.updatePayTypeInfo");     // Catch: Exception -> L9
        if (r107 == null) goto L13;
        r107.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r107.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.updatePayTypeInfo", r105));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.chooseMedia")
    public void chooseMedia(@BridgeContext IBridgeContext r100, @BridgeParam("camera_type") String r110, @BridgeParam("source_type") String r111, @BridgeParam("compress_size") int r112, @BridgeParam("save_to_dcim") String r113, @BridgeParam("maxCount") int r114) {
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L9
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("camera_type", r110);     // Catch: Exception -> L9
        r102.put("source_type", r111);     // Catch: Exception -> L9
        r102.put("compress_size", r112);     // Catch: Exception -> L9
        r102.put("save_to_dcim", r113);     // Catch: Exception -> L9
        r102.put("maxCount", r114);     // Catch: Exception -> L9
        ee4.c r115 = this.f523078d;     // Catch: Exception -> L9
        if (r115 == null) goto L12;
        m r116 = r115.getH5JSB("ttcjpay.chooseMedia");     // Catch: Exception -> L9
        if (r116 == null) goto L13;
        r116.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r116.putDependency(ld4.a.class, new C7044a(this, r100, r101, r102));     // Catch: Exception -> L9
        r116.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.chooseMedia", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.faceVerification")
    public void faceVerification(@BridgeContext IBridgeContext r100, @BridgeParam("scene") String r101, @BridgeParam("ticket") String r102, @BridgeParam("mode") String r103, @BridgeParam("cert_app_id") String r104, @BridgeParam("eventParams") String r105) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("scene", r101);     // Catch: Exception -> L9
        r106.put("ticket", r102);     // Catch: Exception -> L9
        r106.put("mode", r103);     // Catch: Exception -> L9
        r106.put("cert_app_id", r104);     // Catch: Exception -> L9
        r106.put("use_new_api", "true");     // Catch: Exception -> L9
        r106.put("eventParams", r105);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.faceVerification");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.faceVerification", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.notifyOrderResult")
    public void notifyOrderResult(@BridgeContext IBridgeContext r100, @BridgeParam("service") String r101, @BridgeParam("data") String r102, @BridgeParam("response") String r103, @BridgeParam("sign") String r104, @BridgeParam("sign_type") String r105) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("service", r101);     // Catch: Exception -> L9
        r106.put("data", r102);     // Catch: Exception -> L9
        r106.put("response", r103);     // Catch: Exception -> L9
        r106.put("sign", r104);     // Catch: Exception -> L9
        r106.put("sign_type", r105);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.notifyOrderResult");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.notifyOrderResult", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.CJModalView")
    public void openModalView(@BridgeContext IBridgeContext r100, @BridgeParam("url") String r101, @BridgeParam("enable_animation") int r102, @BridgeParam("fullpage") int r103, @BridgeParam("background_color") String r104, @BridgeParam("show_loading") int r105) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("url", r101);     // Catch: Exception -> L9
        r106.put("enable_animation", r102);     // Catch: Exception -> L9
        r106.put("fullpage", r103);     // Catch: Exception -> L9
        r106.put("background_color", r104);     // Catch: Exception -> L9
        r106.put("show_loading", r105);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.CJModalView");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.CJModalView", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.ttpay")
    public void pay(@BridgeContext IBridgeContext r100, @BridgeParam("sdk_info") String r101, @BridgeParam("ext") String r102, @BridgeParam("service") int r103, @BridgeParam("sub_way") String r104, @BridgeParam(AppConstants.BUNDLE_REFERER) String r105) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("sdk_info", r101);     // Catch: Exception -> L9
        r106.put("ext", r102);     // Catch: Exception -> L9
        r106.put("service", r103);     // Catch: Exception -> L9
        r106.put("sub_way", r104);     // Catch: Exception -> L9
        r106.put(AppConstants.BUNDLE_REFERER, r105);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.ttpay");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.ttpay", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.setShareInfo")
    public void setShareInfo(@BridgeContext IBridgeContext r100, @BridgeParam(defaultString = "share_native", value = "platform") String r101, @BridgeParam("title") String r102, @BridgeParam(SocialConstants.PARAM_APP_DESC) String r103, @BridgeParam("image") String r104, @BridgeParam("url") String r105) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("platform", r101);     // Catch: Exception -> L9
        r106.put("title", r102);     // Catch: Exception -> L9
        r106.put(SocialConstants.PARAM_APP_DESC, r103);     // Catch: Exception -> L9
        r106.put("image", r104);     // Catch: Exception -> L9
        r106.put("url", r105);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.setShareInfo");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.putDependency(ld4.a.class, new e(r100));     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.setShareInfo", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    public static void a(a r110, IBridgeContext r111, BridgeResult r112, of4.b r113, long r210, String r211, Map r212) {
        if (r111 == null) goto L9;
        r110.getClass();
        if (r112 == null) goto L7;
        r111.callback(r112);
        goto L9
    L7:
        r111.callback(BridgeResult.Companion.createSuccessResult());
    L9:
        if (r110.f523076b == null) goto L26;
        long r114 = SystemClock.elapsedRealtime() - r210;
        if (r113 == null) goto L15;
        int r100 = r113.f523099a;
        int r115 = r100;
        String r116 = r113.f523100b;
    L19:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L21;
        r110.f523077c = r110.f523076b.getUrl();
    L21:
        ve4.a.f554342a.getClass();
        PlugInContainerService r101 = (PlugInContainerService) ve4.a.a(PlugInContainerService.class);
        if (r101 == null) goto L25;
        r101.reportJSBResult(r211, r110.f523077c, true, r212, r115, r116, r114, r110.f523076b.getMerchantId(), r110.f523076b.getAppId());
        return;
    L25:
        return;
    L15:
        if (r112 == null) goto L17;
        r116 = "";
        r115 = r112.getCode();
        goto L19
    L17:
        r116 = "";
        r115 = 1;
        goto L19
    }

    @BridgeMethod("ttcjpay.CJAuth")
    public void authRealName(@BridgeContext IBridgeContext r100, @BridgeParam("app_id") String r101, @BridgeParam("merchant_id") String r102, @BridgeParam("log_data") String r103, @BridgeParam("theme") String r104, @BridgeParam("scene") String r105, @BridgeParam("style") String r110) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("app_id", r101);     // Catch: Exception -> L9
        r106.put("merchant_id", r102);     // Catch: Exception -> L9
        r106.put("log_data", r103);     // Catch: Exception -> L9
        r106.put("theme", r104);     // Catch: Exception -> L9
        r106.put("scene", r105);     // Catch: Exception -> L9
        r106.put("style", r110);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.CJAuth");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.CJAuth", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.backBlock")
    public void executeBackBlock(@BridgeContext IBridgeContext r100, @BridgeParam("title") String r101, @BridgeParam(PerfLog.PARAM_KEY_CONTEXT_ID) String r102, @BridgeParam("policy") int r103, @BridgeParam("confirm") String r104, @BridgeParam("cancel") String r105, @BridgeParam("enable_animation") String r110) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("title", r101);     // Catch: Exception -> L9
        r106.put(PerfLog.PARAM_KEY_CONTEXT_ID, r102);     // Catch: Exception -> L9
        r106.put("policy", r103);     // Catch: Exception -> L9
        r106.put("confirm", r104);     // Catch: Exception -> L9
        r106.put("cancel", r105);     // Catch: Exception -> L9
        r106.put("enable_animation", r110);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.backBlock");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.backBlock", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.loginAPI")
    public void loginAPI(@BridgeContext IBridgeContext r100, @BridgeParam("merchant_id") String r101, @BridgeParam("app_id") String r102, @BridgeParam("tagAid") String r103, @BridgeParam("loginMode") String r104, @BridgeParam("loginExt") String r105, @BridgeParam("track_base_params") String r110) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("merchant_id", r101);     // Catch: Exception -> L9
        r106.put("app_id", r102);     // Catch: Exception -> L9
        r106.put("tagAid", r103);     // Catch: Exception -> L9
        r106.put("loginMode", r104);     // Catch: Exception -> L9
        r106.put("loginExt", r105);     // Catch: Exception -> L9
        r106.put("track_base_params", r110);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.loginAPI");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.loginAPI", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.request")
    public void request(@BridgeContext IBridgeContext r100, @BridgeParam("url") String r101, @BridgeParam(com.alipay.sdk.m.p.e.f25671s) String r102, @BridgeParam("dataType") String r103, @BridgeParam("params") String r104, @BridgeParam("header") String r110, @BridgeParam("need_cj_jsb_timestamp") String r111, @BridgeParam("cj_jsb_fe_invoke_timestamp") String r112) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L14
        r105.put("url", r101);     // Catch: Exception -> L14
        r105.put(com.alipay.sdk.m.p.e.f25671s, r102);     // Catch: Exception -> L14
        r105.put("dataType", r103);     // Catch: Exception -> L14
        r105.put("params", r104);     // Catch: Exception -> L14
        r105.put("header", r110);     // Catch: Exception -> L14
        r105.put("cj_jsb_native_invoke_timestamp", System.currentTimeMillis());     // Catch: Exception -> L14
        r105.put("cj_jsb_fe_invoke_timestamp", r112);     // Catch: Exception -> L14
        r105.put("need_cj_jsb_timestamp", r111);     // Catch: Exception -> L14
        String r106 = UriProtector.getQueryParameter(UriProtector.parse(r101), "old_struct_use_cj_data");     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r106) == true) goto L7;
        r105.put("old_struct_use_cj_data", r106);     // Catch: Exception -> L13
    L7:
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L14
        if (r107 == null) goto L19;
        m r108 = r107.getH5JSB("ttcjpay.request");     // Catch: Exception -> L14
        if (r108 == null) goto L20;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L14
        r108.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.request", r105));     // Catch: Exception -> L14
        return;
    L20:
        return;
    L19:
        return;
    }

    @BridgeMethod("ttcjpay.uploadMedia")
    public void uploadMedia(@BridgeContext IBridgeContext r100, @BridgeParam("file_path") String r101, @BridgeParam("header") String r102, @BridgeParam("params") String r103, @BridgeParam("public_key") String r110, @BridgeParam("isec_key") String r111, @BridgeParam("compress_limit") int r112, @BridgeParam("url") String r113, @BridgeParam("is_caijing_saas") String r114) {
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L9
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        r105.put("file_path", r101);     // Catch: Exception -> L9
        r105.put("header", r102);     // Catch: Exception -> L9
        r105.put("params", r103);     // Catch: Exception -> L9
        r105.put("public_key", r110);     // Catch: Exception -> L9
        r105.put("isec_key", r111);     // Catch: Exception -> L9
        r105.put("compress_limit", r112);     // Catch: Exception -> L9
        r105.put("url", r113);     // Catch: Exception -> L9
        r105.put("is_caijing_saas", r114);     // Catch: Exception -> L9
        ee4.c r106 = this.f523078d;     // Catch: Exception -> L9
        if (r106 == null) goto L12;
        m r115 = r106.getH5JSB("ttcjpay.uploadMedia");     // Catch: Exception -> L9
        if (r115 == null) goto L13;
        r115.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r115.putDependency(ld4.a.class, new b(this, r100, r104, r105));     // Catch: Exception -> L9
        r115.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.uploadMedia", r105));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.voiceVerify")
    public void voiceVerify(@BridgeContext IBridgeContext r100, @BridgeParam("merchantId") String r101, @BridgeParam("appId") String r102, @BridgeParam("verifyType") String r103, @BridgeParam("memberBizOrderNo") String r104, @BridgeParam("voiceText") String r110, @BridgeParam("verifyGroupNum") int r111, @BridgeParam("useDenoise") Boolean r112, @BridgeParam("extParams") JSONObject r113) {
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L25
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r105.put("merchantId", r101);     // Catch: Exception -> L25
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r105.put("appId", r102);     // Catch: Exception -> L25
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r105.put("verifyType", r103);     // Catch: Exception -> L25
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        r105.put("memberBizOrderNo", r104);     // Catch: Exception -> L25
        if (r110 != null) goto L19;
        r110 = "";
    L19:
        r105.put("voiceText", r110);     // Catch: Exception -> L25
        r105.put("verifyGroupNum", r111);     // Catch: Exception -> L25
        r105.put("useDenoise", r112);     // Catch: Exception -> L25
        r105.put("extParams", r113);     // Catch: Exception -> L25
        r105.put("old_struct_use_cj_data", "0");     // Catch: Exception -> L25
        ee4.c r106 = this.f523078d;     // Catch: Exception -> L25
        if (r106 == null) goto L28;
        m r107 = r106.getH5JSB("ttcjpay.voiceVerify");     // Catch: Exception -> L25
        if (r107 == null) goto L29;
        r107.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L25
        r107.handle(r100.getActivity(), r105, new d(this, r100, "ttcjpay.voiceVerify", r105));     // Catch: Exception -> L25
        return;
    L29:
        return;
    L28:
        return;
    }

    @BridgeMethod("ttcjpay.bioPaymentShowState")
    public void bioPaymentShowState(@BridgeContext IBridgeContext r100, @BridgeParam("appId") String r101, @BridgeParam("signType") String r102, @BridgeParam("sign") String r103, @BridgeParam("uid") String r104, @BridgeParam("merchantId") String r105, @BridgeParam(com.bytedance.android.ec.core.event.a.KEY_DID) String r110, @BridgeParam("timestamp") String r111, @BridgeParam("is_caijing_saas") String r112, @BridgeParam("onlyReturnDeviceType") boolean r113) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L12
        r106.put("appId", r101);     // Catch: Exception -> L12
        r106.put("signType", r102);     // Catch: Exception -> L12
        r106.put("sign", r103);     // Catch: Exception -> L12
        r106.put("uid", r104);     // Catch: Exception -> L12
        r106.put("merchantId", r105);     // Catch: Exception -> L12
        r106.put(com.bytedance.android.ec.core.event.a.KEY_DID, r110);     // Catch: Exception -> L12
        r106.put("timestamp", r111);     // Catch: Exception -> L12
        r106.put("onlyReturnDeviceType", r113);     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r112) == true) goto L6;
        r106.put("is_caijing_saas", r112);     // Catch: Exception -> L12
    L6:
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L12
        if (r107 == null) goto L15;
        m r108 = r107.getH5JSB("ttcjpay.bioPaymentShowState");     // Catch: Exception -> L12
        if (r108 == null) goto L16;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L12
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.bioPaymentShowState", r106));     // Catch: Exception -> L12
        return;
    L16:
        return;
    L15:
        return;
    }

    @BridgeMethod("ttcjpay.faceVerifyFullPage")
    public void copyToClipboard(@BridgeContext IBridgeContext r100, @BridgeParam("app_id") String r101, @BridgeParam("merchant_id") String r102, @BridgeParam("order_id") String r103, @BridgeParam("server_source") String r104, @BridgeParam("risk_source") String r105, @BridgeParam("live_route") String r110, @BridgeParam("is_signed") String r111, @BridgeParam("configuration_params") String r112, @BridgeParam("ext_params") String r113) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("app_id", r101);     // Catch: Exception -> L9
        r106.put("merchant_id", r102);     // Catch: Exception -> L9
        r106.put("order_id", r103);     // Catch: Exception -> L9
        r106.put("server_source", r104);     // Catch: Exception -> L9
        r106.put("risk_source", r105);     // Catch: Exception -> L9
        r106.put("live_route", r110);     // Catch: Exception -> L9
        r106.put("is_signed", r111);     // Catch: Exception -> L9
        r106.put("configuration_params", r112);     // Catch: Exception -> L9
        r106.put("ext_params", r113);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.faceVerifyFullPage");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.faceVerifyFullPage", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.closeCallback")
    public void executeCloseAndCallback(@BridgeContext IBridgeContext r100, @BridgeParam("service") String r101, @BridgeParam("code") String r102, @BridgeParam("data") String r103, @BridgeParam("amount") String r104, @BridgeParam("success_desc") String r105, @BridgeParam("fail_desc") String r110, @BridgeParam(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID) String r111, @BridgeParam("ext") String r112, @BridgeParam("style") String r113, @BridgeParam("pay_token") String r114) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("service", r101);     // Catch: Exception -> L9
        r106.put("code", r102);     // Catch: Exception -> L9
        r106.put("data", r103);     // Catch: Exception -> L9
        r106.put("amount", r104);     // Catch: Exception -> L9
        r106.put("success_desc", r105);     // Catch: Exception -> L9
        r106.put("fail_desc", r110);     // Catch: Exception -> L9
        r106.put(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, r111);     // Catch: Exception -> L9
        r106.put("ext", r112);     // Catch: Exception -> L9
        r106.put("style", r113);     // Catch: Exception -> L9
        r106.put("pay_token", r114);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.closeCallback");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.closeCallback", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.ocr")
    public void doOCR(@BridgeContext IBridgeContext r100, @BridgeParam("type") String r101, @BridgeParam("merchant_id") String r102, @BridgeParam("app_id") String r103, @BridgeParam(com.heytap.mcssdk.constant.b.f276366p) String r104, @BridgeParam("compress_size") int r105, @BridgeParam("track_base_param") String r110, @BridgeParam("frontUploadInteface") String r111, @BridgeParam("backUploadInteface") String r112, @BridgeParam("publicKey") String r113, @BridgeParam("is_caijing_saas") String r114, @BridgeParam("params") String r115) {
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L9
        r106.put("type", r101);     // Catch: Exception -> L9
        r106.put("merchant_id", r102);     // Catch: Exception -> L9
        r106.put("app_id", r103);     // Catch: Exception -> L9
        r106.put(com.heytap.mcssdk.constant.b.f276366p, r104);     // Catch: Exception -> L9
        r106.put("compress_size", r105);     // Catch: Exception -> L9
        r106.put("track_base_param", r110);     // Catch: Exception -> L9
        r106.put("frontUploadInteface", r111);     // Catch: Exception -> L9
        r106.put("backUploadInteface", r112);     // Catch: Exception -> L9
        r106.put("publicKey", r113);     // Catch: Exception -> L9
        r106.put("is_caijing_saas", r114);     // Catch: Exception -> L9
        r106.put("params", r115);     // Catch: Exception -> L9
        ee4.c r107 = this.f523078d;     // Catch: Exception -> L9
        if (r107 == null) goto L12;
        m r108 = r107.getH5JSB("ttcjpay.ocr");     // Catch: Exception -> L9
        if (r108 == null) goto L13;
        r108.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r108.handle(r100.getActivity(), r106, new d(this, r100, "ttcjpay.ocr", r106));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    @BridgeMethod("ttcjpay.switchBioPaymentState")
    public void switchBioPaymentState(@BridgeContext IBridgeContext r100, @BridgeParam("appId") String r101, @BridgeParam("signType") String r110, @BridgeParam("sign") String r111, @BridgeParam("uid") String r112, @BridgeParam("merchantId") String r113, @BridgeParam(com.bytedance.android.ec.core.event.a.KEY_DID) String r114, @BridgeParam("timestamp") String r115, @BridgeParam("open") String r116, @BridgeParam("member_biz_order_no") String r117, @BridgeParam("verify_type") String r118, @BridgeParam("verify_info") String r119, @BridgeParam("is_caijing_saas") String r210, @BridgeParam("source") String r211) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L15
        r102.put("appId", r101);     // Catch: Exception -> L15
        r102.put("signType", r110);     // Catch: Exception -> L15
        r102.put("sign", r111);     // Catch: Exception -> L15
        r102.put("uid", r112);     // Catch: Exception -> L15
        r102.put("merchantId", r113);     // Catch: Exception -> L15
        r102.put(com.bytedance.android.ec.core.event.a.KEY_DID, r114);     // Catch: Exception -> L15
        r102.put("timestamp", r115);     // Catch: Exception -> L15
        r102.put("open", r116);     // Catch: Exception -> L15
        r102.put("member_biz_order_no", r117);     // Catch: Exception -> L15
        r102.put("verify_type", r118);     // Catch: Exception -> L15
        r102.put("verify_info", r119);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r211) == true) goto L7;
        r102.put("source", r211);     // Catch: Exception -> L15
    L7:
        if (TextUtils.isEmpty(r210) == true) goto L9;
        r102.put("is_caijing_saas", r210);     // Catch: Exception -> L15
    L9:
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L15
        if (r103 == null) goto L18;
        m r104 = r103.getH5JSB("ttcjpay.switchBioPaymentState");     // Catch: Exception -> L15
        if (r104 == null) goto L19;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L15
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.switchBioPaymentState", r102));     // Catch: Exception -> L15
        return;
    L19:
        return;
    L18:
        return;
    }

    @BridgeMethod("ttcjpay.goH5")
    public void openH5(@BridgeContext IBridgeContext r100, @BridgeParam("title") String r101, @BridgeParam("url") String r110, @BridgeParam("hide_status_bar") String r111, @BridgeParam("background_color") String r112, @BridgeParam("status_bar_text_style") String r113, @BridgeParam("back_button_color") String r114, @BridgeParam("back_button_icon") String r115, @BridgeParam("title_text_color") String r116, @BridgeParam("title_bar_bg_color") String r117, @BridgeParam("hide_title_bar") String r118, @BridgeParam("canvas_mode") String r119, @BridgeParam("show_loading") int r210, @BridgeParam("enable_font_scale") String r211, @BridgeParam("is_caijing_saas") String r212) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("title", r101);     // Catch: Exception -> L9
        r102.put("url", r110);     // Catch: Exception -> L9
        r102.put("hide_status_bar", r111);     // Catch: Exception -> L9
        r102.put("background_color", r112);     // Catch: Exception -> L9
        r102.put("status_bar_text_style", r113);     // Catch: Exception -> L9
        r102.put("back_button_color", r114);     // Catch: Exception -> L9
        r102.put("back_button_icon", r115);     // Catch: Exception -> L9
        r102.put("title_text_color", r116);     // Catch: Exception -> L9
        r102.put("title_bar_bg_color", r117);     // Catch: Exception -> L9
        r102.put("hide_title_bar", r118);     // Catch: Exception -> L9
        r102.put("canvas_mode", r119);     // Catch: Exception -> L9
        r102.put("show_loading", r210);     // Catch: Exception -> L9
        r102.put("enable_font_scale", r211);     // Catch: Exception -> L9
        r102.put("is_caijing_saas", r212);     // Catch: Exception -> L9
        ee4.c r103 = this.f523078d;     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        m r104 = r103.getH5JSB("ttcjpay.goH5");     // Catch: Exception -> L9
        if (r104 == null) goto L13;
        r104.putDependency(qd4.a.class, this.f523076b);     // Catch: Exception -> L9
        r104.handle(r100.getActivity(), r102, new d(this, r100, "ttcjpay.goH5", r102));     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }
}

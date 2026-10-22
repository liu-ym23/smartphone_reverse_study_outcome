package com.bytedance.caijing.sdk.infra.base.core;

import android.util.Log;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.caijing.sdk.infra.base.api.plugin.settings.IPluginSettingsHelper;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CJContext {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Set<String> f202254w = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f202255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f202256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f202257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f202258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f202259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f202260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<String> f202261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TTCJPayResult f202262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PaymentStatus f202263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PageStatus f202264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ContextType f202265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public IH5PayCallback f202266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Map<String, Object>> f202267m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f202268n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f202269o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView<b, Boolean> f202270p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f202271q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f202272r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public JSONObject f202273s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f202274t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f202275u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f202276v;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/core/CJContext$ContextType;", "", "PAY", "DEFAULT", "cj-base_release"}, k = 1, mv = {1, 6, 0})
    public static final enum ContextType extends Enum<ContextType> {
        public static final ContextType DEFAULT = null;
        public static final ContextType PAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContextType[] f202277a = null;

        public static ContextType valueOf(String r100) {
            return (ContextType) r27.a.a(ContextType.class, r100);
        }

        public static ContextType[] values() {
            return (ContextType[]) f202277a.clone();
        }

        static {
            ContextType r100 = new ContextType("PAY", 0);
            PAY = r100;
            ContextType r101 = new ContextType("DEFAULT", 1);
            DEFAULT = r101;
            f202277a = new ContextType[]{r100, r101};
        }

        public ContextType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/core/CJContext$PageStatus;", "", "ACTIVE", "BACKGROUND", "DESTROYED", "cj-base_release"}, k = 1, mv = {1, 6, 0})
    public static final enum PageStatus extends Enum<PageStatus> {
        public static final PageStatus ACTIVE = null;
        public static final PageStatus BACKGROUND = null;
        public static final PageStatus DESTROYED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PageStatus[] f202278a = null;

        public static PageStatus valueOf(String r100) {
            return (PageStatus) r27.a.a(PageStatus.class, r100);
        }

        public static PageStatus[] values() {
            return (PageStatus[]) f202278a.clone();
        }

        static {
            PageStatus r100 = new PageStatus("ACTIVE", 0);
            ACTIVE = r100;
            PageStatus r101 = new PageStatus("BACKGROUND", 1);
            BACKGROUND = r101;
            PageStatus r102 = new PageStatus("DESTROYED", 2);
            DESTROYED = r102;
            f202278a = new PageStatus[]{r100, r101, r102};
        }

        public PageStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/core/CJContext$PaymentStatus;", "", "ACTIVE", "PROCESSING", "COMPLETED", "cj-base_release"}, k = 1, mv = {1, 6, 0})
    public static final enum PaymentStatus extends Enum<PaymentStatus> {
        public static final PaymentStatus ACTIVE = null;
        public static final PaymentStatus COMPLETED = null;
        public static final PaymentStatus PROCESSING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PaymentStatus[] f202279a = null;

        public static PaymentStatus valueOf(String r100) {
            return (PaymentStatus) r27.a.a(PaymentStatus.class, r100);
        }

        public static PaymentStatus[] values() {
            return (PaymentStatus[]) f202279a.clone();
        }

        static {
            PaymentStatus r100 = new PaymentStatus("ACTIVE", 0);
            ACTIVE = r100;
            PaymentStatus r101 = new PaymentStatus("PROCESSING", 1);
            PROCESSING = r101;
            PaymentStatus r102 = new PaymentStatus("COMPLETED", 2);
            COMPLETED = r102;
            f202279a = new PaymentStatus[]{r100, r101, r102};
        }

        public PaymentStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        TTCJPayResult getCJPayResult();

        boolean onIObserverPayResult(String r100, TTCJPayResult r101);

        boolean onITTCJPayResultInterceptor(String r100, TTCJPayResult r101);

        void onNotifyPayResult(CJContext r100);

        void onUploadWalletCashierSdk(int r100, String r101);
    }

    /* JADX INFO: loaded from: classes15.dex */
    public interface b {
        void onTerminateBySystem();
    }

    public static final class c {
        public static String c() {
            StringBuilder r100 = new StringBuilder();
            r100.append(System.currentTimeMillis());
            r100.append((int) (Math.random() * ((double) 10000)));
            return r100.toString();
        }

        public c() {
        }

        public static /* synthetic */ CJContext b(String r100, String r101, String r102) {
            return a(r100, r101, r102, new HashMap());
        }

        public static CJContext a(String r110, String r111, String r112, Map r113) {
            Intrinsics.checkNotNullParameter(r110, "cjSource");
            Intrinsics.checkNotNullParameter(r111, "cjAppId");
            Intrinsics.checkNotNullParameter(r112, "merchantId");
            Intrinsics.checkNotNullParameter(r113, "eventParams");
            String r100 = c();
            CJContext r101 = new CJContext(r100, r112, r111, r110, System.currentTimeMillis(), r113);
            CJContext r114 = com.bytedance.caijing.sdk.infra.base.core.a.f202280a;
            Intrinsics.checkNotNullParameter(r101, "newContext");
            com.bytedance.caijing.sdk.infra.base.core.a.f202281b.put(r100, r101);
            return r101;
        }
    }

    public CJContext() {
        throw null;
    }

    static {
        new c();
        f202254w = SetsKt.setOf(new String[]{"verifyScanResultSync", "pay_10_from_h5", "pay_20_from_h5"});
    }

    public final void a() {
        CJLogger.d("CJContext", "activatePayment : " + this);
        this.f202263i = PaymentStatus.ACTIVE;
    }

    public final void d() {
        CJLogger.d("CJContext", "completePayment : " + this);
        this.f202263i = PaymentStatus.COMPLETED;
        CJContext r100 = com.bytedance.caijing.sdk.infra.base.core.a.f202280a;
        Intrinsics.checkNotNullParameter(this, PerfLog.PARAM_KEY_CONTEXT_ID);
        CJLogger.d("CJContextManager", "onPaymentCompleted: " + this + " ， activePayContext=" + com.bytedance.caijing.sdk.infra.base.core.a.f202280a);
        Object r101 = com.bytedance.caijing.sdk.infra.base.core.a.f202284e;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(com.bytedance.caijing.sdk.infra.base.core.a.f202280a, this) == false) goto L7;
        com.bytedance.caijing.sdk.infra.base.core.a.f202280a = null;     // Catch: Throwable -> L19
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        ve4.a.f554342a.getClass();
        IPluginSettingsHelper r103 = (IPluginSettingsHelper) ve4.a.a(IPluginSettingsHelper.class);
        if (r103 == null) goto L12;
        boolean r104 = r103.isDegradeIntegratedCounterRebuildSuccessRecovery();
    L13:
        if (r104 == false) goto L26;
        com.bytedance.caijing.sdk.infra.base.core.a.f202281b.remove(this.f202255a);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        CJLogger.c("CJContextManager", "onPaymentCompleted", e);
        return;
    L26:
        return;
    L12:
        r104 = true;
        goto L13
    }

    public final boolean e() {
        CJLogger.d("CJContext", "enableNotifyPayResult : " + this);
        return CollectionsKt.contains(CollectionsKt.listOf(new String[]{Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "20", BDLocationException.ERROR_SDK_NO_PERMISSION, BDLocationException.ERROR_BEACON_INFO_NULL}), this.f202272r);
    }

    public final void f() {
        PageStatus r100 = this.f202264j;
        PageStatus r101 = PageStatus.DESTROYED;
        if (r100 == r101) goto L6;
        CJLogger.d("CJContext", "exitPaymentPage : " + this);
        this.f202264j = r101;
        com.bytedance.caijing.sdk.infra.base.core.a.b(this);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h() {
        CJLogger.d("CJContext", "notifyPayResult : " + this + ", h5PayCallback: " + this.f202266l + ", observer: null");
        TTCJPayResult r100 = g("notifyPayResult");
    L9:
        e = move-exception;
        CJLogger.c("CJContext", " callbackInfo error", e);
    L11:
        JSONObject r101 = null;
    L13:
        if (r100.getCode() == 110) goto L15;
        f();
    L15:
        boolean r102 = false;
        int r103 = 0;
        char r104 = 0;
        char r105 = 0;
        if (this.f202266l != null) goto L18;
        a r106 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r106 == null) goto L134;
        Boolean r107 = Boolean.valueOf(r106.onITTCJPayResultInterceptor(this.f202255a, r100));
    L135:
        if (r107 == null) goto L137;
        boolean r108 = r107.booleanValue();
    L138:
        if (r108 == false) goto L141;
        CJLogger.d("CJContext", "notifyPayResult : " + this + ", onITTCJPayResultInterceptor");
        i(r100.getCode(), r101, "resultInterceptor");
        return;
    L141:
        CJLogger.d("CJContext", "center:" + r100.getCode() + ',' + Log.getStackTraceString(new Throwable()));
        a r109 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r109 == null) goto L144;
        Boolean r110 = Boolean.valueOf(r109.onIObserverPayResult(this.f202255a, r100));
    L145:
        if (r110 == null) goto L147;
        r102 = r110.booleanValue();
    L147:
        if (r102 == false) goto L149;
    L154:
        if (r100.getCode() == 110) goto L169;
        a r111 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r111 == null) goto L158;
        r111.onNotifyPayResult(this);
    L158:
        this.f202266l = null;
        this.f202270p.clear();
        this.f202274t = true;
        return;
    L169:
        return;
    L149:
        if (this.f202274t == true) goto L154;
        if (f202254w.contains(this.f202258d) == true) goto L154;
        CJReporter r112 = CJReporter.f202294a;
        CJReporter.k(this, "CJContextNotifyNoHandler", 1, "notifyPayResult, code: " + r100.getCode());
        goto L154
    L144:
        r110 = null;
        goto L145
    L137:
        r108 = false;
        goto L138
    L134:
        r107 = null;
        goto L135
    L18:
        if (r100.getCode() == 110) goto L154;
        i(r100.getCode(), r101, "callback");
        if (this.f202266l == null) goto L154;
        if (r100.getCode() != 0) goto L25;
        String r113 = "支付成功";
    L107:
        if (r100.getCallBackInfo() == null) goto L117;
        if (r100.getCallBackInfo().containsKey("front_standard_data") == false) goto L117;
        JSONObject r114 = new JSONObject(r100.getCallBackInfo().get("front_standard_data"));     // Catch: Throwable -> L112 Exception -> L160
        r114.put("result_msg", r113);     // Catch: Throwable -> L112 Exception -> L160
        r114.put(BytedCertConstant.CertKey.SDK_CODE, r103);     // Catch: Throwable -> L112 Exception -> L160
        r114.put("sdk_msg", r113);     // Catch: Throwable -> L112 Exception -> L160
        r113 = r114.toString();     // Catch: Throwable -> L112 Exception -> L160
    L112:
        th = move-exception;
        r100.getCallBackInfo().remove("front_standard_data");
        throw th;
    L115:
        r100.getCallBackInfo().remove("front_standard_data");
    L122:
        a r115 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r115 == null) goto L125;
        r115.onUploadWalletCashierSdk(r100.getCode(), r113);
    L125:
        if (r103 != 0) goto L165;
    L127:
        IH5PayCallback r116 = this.f202266l;     // Catch: Exception -> L129
        Intrinsics.checkNotNull(r116);     // Catch: Exception -> L129
        r116.onResult(r103, r113);     // Catch: Exception -> L129
    L129:
        e = move-exception;
        CJReporter r117 = CJReporter.f202294a;
        CJReporter.m(this, "handleH5result", 1, e);
        goto L154
    L165:
        CJLogger.d("payjsb", r103 + ',' + r113);     // Catch: Exception -> L129
    L117:
        if (this.f202273s == null) goto L122;
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L120
        r118.put("create_order_response", this.f202273s);     // Catch: JSONException -> L120
        r118.put("result_msg", r113);     // Catch: JSONException -> L120
        r118.put(BytedCertConstant.CertKey.SDK_CODE, r103);     // Catch: JSONException -> L120
        r118.put("sdk_msg", r113);     // Catch: JSONException -> L120
        r113 = r118.toString();     // Catch: JSONException -> L120
    L120:
        e = move-exception;
        CJLogger.b("handleH5Result", e.toString());
        goto L122
    L25:
        if (r100.getCode() != 103) goto L38;
        if (r100.getCallBackInfo() == null) goto L35;
        r113 = r100.getCallBackInfo().get("fail_desc");
        if (r113 == null) goto L35;
        if (r113.length() != 0) goto L33;
        r104 = 1;
    L33:
        if (r104 != 0) goto L35;
    L36:
        r103 = 1;
    L35:
        r113 = "支付超时";
        goto L36
    L38:
        if (r100.getCode() == 102) goto L40;
        r103 = 104;
        if (r100.getCode() != 104) goto L54;
        r103 = 4;
        r113 = "支付取消";
        goto L107
    L54:
        if (r100.getCode() != 101) goto L57;
        r103 = 9;
        r113 = "支付处理中";
        goto L107
    L57:
        if (r100.getCode() != 109) goto L60;
        r113 = "网络错误";
        r103 = 109;
        goto L107
    L60:
        if (r100.getCode() != 112) goto L63;
        r113 = "参数非法";
        r103 = 112;
        goto L107
    L63:
        if (r100.getCode() != 113) goto L66;
        r113 = "支付取消";
        r103 = 113;
        goto L107
    L66:
        if (r100.getCode() != 116) goto L69;
        r113 = "刷单风控弹窗取消支付";
        r103 = 116;
        goto L107
    L69:
        if (r100.getCode() != 117) goto L72;
        r113 = "用户手动切回前台";
        r103 = 117;
        goto L107
    L72:
        if (r100.getCode() != 118) goto L75;
        r113 = "亲友银行卡邀请成功";
        r103 = 118;
        goto L107
    L75:
        if (r100.getCode() != 119) goto L78;
        r113 = "";
        r103 = 119;
        goto L107
    L78:
        if (r100.getCode() != 4100) goto L81;
        r113 = "绑卡成功";
        r103 = 4100;
        goto L107
    L81:
        if (r100.getCode() != 4101) goto L84;
        r113 = "绑卡失败";
        r103 = 4101;
        goto L107
    L84:
        if (r100.getCode() != 4102) goto L87;
        r113 = "绑卡取消";
        r103 = 4102;
        goto L107
    L87:
        if (r100.getCode() != 4103) goto L90;
        r113 = "调起绑卡失败";
        r103 = 4103;
        goto L107
    L90:
        if (r100.getCode() != 4110) goto L93;
        r113 = "登录失败";
        r103 = 4110;
        goto L107
    L93:
        if (r100.getCode() != 4111) goto L96;
        r113 = "参数非法";
    L98:
        r103 = 4111;
        goto L107
    L96:
        if (r100.getCode() != 4199) goto L100;
        r113 = "网络错误";
        goto L98
    L100:
        if (r100.getCode() != 5000) goto L103;
        r113 = "创建订单错误";
        r103 = 5000;
        goto L107
    L103:
        if (r100.getCode() != 5001) goto L105;
        r113 = "创建订单成功，跳过支付";
        r103 = 5001;
        goto L107
    L105:
        r113 = "";
        goto L107
    L40:
        if (r100.getCallBackInfo() == null) goto L48;
        r113 = r100.getCallBackInfo().get("fail_desc");
        if (r113 == null) goto L48;
        if (r113.length() != 0) goto L46;
        r105 = 1;
    L46:
        if (r105 != 0) goto L48;
    L49:
        r103 = 2;
    L48:
        r113 = "支付失败";
        goto L49
    L4:
        if (r100.getCallBackInfo() == null) goto L11;
        Map<String, String> r119 = r100.getCallBackInfo();     // Catch: Exception -> L9
        if (r119 == null) goto L11;
        r101 = new JSONObject(r119);     // Catch: Exception -> L9
        goto L13
    }

    public final void k() {
        a r100 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        Integer r101 = null;
        if (r100 == null) goto L5;
        TTCJPayResult r102 = r100.getCJPayResult();
    L6:
        StringBuilder r103 = new StringBuilder("saveFinalPayResult : ");
        r103.append(this);
        r103.append(" code: ");
        if (r102 == null) goto L9;
        r101 = Integer.valueOf(r102.getCode());
    L9:
        r103.append(r101);
        CJLogger.d("CJContext", r103.toString());
        TTCJPayResult r104 = g("saveFinalPayResult");
        this.f202262h.setCode(r104.getCode());
        this.f202262h.setCallBackInfo(r104.getCallBackInfo());
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final String toString() {
        return "CJContext(clientSessionId='" + this.f202255a + "', merchantId='" + this.f202256b + "', cjAppId='" + this.f202257c + "', cjSource='" + this.f202258d + "', startTime=" + this.f202259e + ", paymentStatus=" + this.f202263i + ", contextType=" + this.f202265k + ", h5PayCallback=" + this.f202266l + ", observer=null, traceId='" + this.f202271q + "', service=" + this.f202272r + ')';
    }

    public static String j(String r110) {
        if (r110 == null) goto L9;
        String r100 = StringsKt.replace$default(r110, HiAnalyticsConstant.REPORT_VAL_SEPARATOR, "_", false, 4, null);
        if (r100 == null) goto L9;
        String r111 = StringsKt.replace$default(r100, "\n", " ", false, 4, null);
        if (r111 == null) goto L9;
        String r112 = StringsKt.take(r111, 100);
        if (r112 == null) goto L9;
        return r112;
    L9:
        return "null";
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        this.f202261g.add(r100);
    }

    public final void c(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extraEventParams");
        this.f202260f.putAll(r100);
    }

    public final TTCJPayResult g(String r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        boolean r100 = false;
        if (this.f202263i != PaymentStatus.COMPLETED) goto L5;
        TTCJPayResult r101 = this.f202262h;
    L20:
        StringBuilder r102 = new StringBuilder("getPayResult from:");
        r102.append(r110);
        r102.append(" :curPayResult.code:");
        r102.append(r101.getCode());
        r102.append(", ICJContextReg.impl?.getCJPayResult()?.code:");
        a r103 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        Map<String, String> r104 = null;
        if (r103 == null) goto L25;
        TTCJPayResult r105 = r103.getCJPayResult();
        if (r105 == null) goto L25;
        Integer r106 = Integer.valueOf(r105.getCode());
    L26:
        r102.append(r106);
        r102.append(", ");
        CJLogger.d("CJContext", r102.toString());
        a r107 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r107 == null) goto L29;
        TTCJPayResult r108 = r107.getCJPayResult();
    L31:
        if (this.f202275u == true) goto L44;
        if (r108 != null) goto L34;
    L36:
        boolean r109 = false;
    L37:
        if (r109 == true) goto L44;
        this.f202275u = true;
        CJReporter r111 = CJReporter.f202294a;
        StringBuilder r112 = new StringBuilder();
        r112.append(r110);
        r112.append('|');
        r112.append(this.f202263i);
        r112.append('|');
        r112.append(r101.getCode());
        r112.append('|');
        if (r108 == null) goto L41;
        Integer r113 = Integer.valueOf(r108.getCode());
    L42:
        r112.append(r113);
        CJReporter.k(this, "CJContextCodeDiff", 1, r112.toString());
        goto L44
    L41:
        r113 = null;
        goto L42
    L34:
        if (r101.getCode() != r108.getCode()) goto L36;
        r109 = true;
    L44:
        if (this.f202276v == true) goto L100;
        Map<String, String> r114 = r101.getCallBackInfo();
        if (r108 == null) goto L48;
        Map<String, String> r115 = r108.getCallBackInfo();
    L50:
        if (Intrinsics.areEqual(r114, r115) == true) goto L100;
        this.f202276v = true;
        Map<String, String> r116 = r101.getCallBackInfo();
        if (r108 == null) goto L54;
        Map<String, String> r117 = r108.getCallBackInfo();
    L55:
        if (r116 == null) goto L71;
        if (r117 == null) goto L71;
        Set r118 = SetsKt.plus(r116.keySet(), r117.keySet());     // Catch: Exception -> L69
        LinkedHashMap r119 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r118, 10)), 16));     // Catch: Exception -> L69
        Iterator r120 = r118.iterator();     // Catch: Exception -> L69
    L60:
        if (r120.hasNext() == false) goto L62;
        Object r121 = r120.next();     // Catch: Exception -> L69
        String r122 = (String) r121;     // Catch: Exception -> L69
        r119.put(r121, new Pair(r116.get(r122), r117.get(r122)));     // Catch: Exception -> L69
        goto L60
    L62:
        Map r123 = new LinkedHashMap();     // Catch: Exception -> L69
        Iterator r124 = r119.entrySet().iterator();     // Catch: Exception -> L69
    L63:
        if (r124.hasNext() == false) goto L72;
        Map.Entry r125 = (Map.Entry) r124.next();     // Catch: Exception -> L69
        Pair r126 = (Pair) r125.getValue();     // Catch: Exception -> L69
        if ((!Intrinsics.areEqual(r126.getFirst(), r126.getSecond())) == false) goto L63;
        r123.put(r125.getKey(), r125.getValue());     // Catch: Exception -> L69
    L72:
        Iterator r127 = r123.entrySet().iterator();
    L74:
        if (r127.hasNext() == false) goto L76;
        Map.Entry r128 = (Map.Entry) r127.next();
        String r129 = (String) r128.getKey();
        Pair r130 = (Pair) r128.getValue();
        CJLogger.d("CJContext", "Key '" + r129 + "': '" + ((String) r130.getFirst()) + "' vs '" + ((String) r130.getSecond()) + '\'');
        goto L74
    L76:
        CJReporter r131 = CJReporter.f202294a;
        Map<String, String> r132 = r101.getCallBackInfo();
        if (r108 == null) goto L79;
        r104 = r108.getCallBackInfo();
    L79:
        StringBuilder r133 = new StringBuilder();
        r133.append(r110);
        r133.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r133.append(this.f202263i.toString());
        r133.append("|diffCount=");
        r133.append(r123.size());
        if (r132 == null) goto L91;
        if (r104 == null) goto L91;
        if (r123.isEmpty() == false) goto L86;
        r133.append("|no_diff_keys");
        String r134 = r133.toString();
    L99:
        CJReporter.k(this, "CJContextCallbackInfoDiff", 1, r134);
        goto L100
    L86:
        Iterator r135 = CollectionsKt.take(r123.entrySet(), 5).iterator();
    L88:
        if (r135.hasNext() == false) goto L90;
        Map.Entry r136 = (Map.Entry) r135.next();
        r133.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r133.append(j((String) r136.getKey()));
        r133.append(":");
        r133.append(j((String) ((Pair) r136.getValue()).getFirst()));
        r133.append("->");
        r133.append(j((String) ((Pair) r136.getValue()).getSecond()));
        goto L88
    L90:
        r134 = r133.toString();
    L91:
        r133.append("|curNull=");
        if (r132 != null) goto L94;
        boolean r137 = true;
    L95:
        r133.append(r137);
        r133.append("|globalNull=");
        if (r104 != null) goto L98;
        r100 = true;
    L98:
        r133.append(r100);
        r134 = r133.toString();
        goto L99
    L94:
        r137 = false;
    L69:
        e = move-exception;
        CJLogger.c("CJContext", "findStringMapDifferences error", e);
        r123 = MapsKt.emptyMap();
    L71:
        r123 = MapsKt.emptyMap();
        goto L72
    L54:
        r117 = null;
        goto L55
    L48:
        r115 = null;
    L100:
        return r101;
    L29:
        r108 = null;
    L25:
        r106 = null;
        goto L26
    L5:
        a r138 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r138 == null) goto L12;
        TTCJPayResult r139 = r138.getCJPayResult();
        if (r139 == null) goto L12;
        if (r139.getCode() != 0) goto L12;
        boolean r140 = true;
    L13:
        if (r140 == false) goto L15;
        r101 = this.f202262h;
        goto L20
    L15:
        a r141 = com.bytedance.caijing.sdk.infra.base.core.b.f202286a;
        if (r141 == null) goto L19;
        r101 = r141.getCJPayResult();
        if (r101 != null) goto L20;
    L19:
        r101 = this.f202262h;
    L12:
        r140 = false;
        goto L13
    }

    public final void l(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CJLogger.d("CJContext", "setCJContextInstanceListener : " + this + " listener: " + r100);
        this.f202270p.add(r100);
    }

    public final void m(int r100) {
        CJLogger.d("CJContext", "setResultCode : " + this + " code: " + r100);
        this.f202262h.setCode(r100);
    }

    public final void n(int r100) {
        this.f202272r = String.valueOf(r100);
    }

    public final void i(int r100, JSONObject r101, String r110) {
        HashMap r102 = new HashMap();
        r102.put("result", Integer.valueOf(r100));
        r102.put("from", r110);
        if (r101 == null) goto L6;
        String r103 = r101.toString();
        if (r103 == null) goto L6;
    L7:
        r102.put("callbackInfo", r103);
        r102.put("fromCJContext", BdpAppEventConstant.YES);
        CJReporter r104 = CJReporter.f202294a;
        CJReporter.g(this, "wallet_rd_pay_result_callback", r102, null, -1, true);
        return;
    L6:
        r103 = "null";
        goto L7
    }

    public CJContext(String r100, String r101, String r102, String r103, long r104, Map r105) {
        this.f202255a = r100;
        this.f202256b = r101;
        this.f202257c = r102;
        this.f202258d = r103;
        this.f202259e = r104;
        this.f202260f = r105;
        this.f202261g = new CopyOnWriteArraySet();
        this.f202262h = new TTCJPayResult(104);
        this.f202263i = PaymentStatus.ACTIVE;
        this.f202264j = PageStatus.ACTIVE;
        this.f202265k = ContextType.DEFAULT;
        this.f202267m = new LinkedHashMap();
        this.f202270p = ConcurrentHashMap.newKeySet();
        this.f202271q = "";
    }
}

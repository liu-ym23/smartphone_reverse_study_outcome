package u1b;

import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IDependency;
import com.ss.android.lark.chameleon.IMonitorDependency;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleon.PreloadPolicy;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonReport;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import otb.n;
import swb.q;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, C7822a> f548359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f548360b;

    /* JADX INFO: renamed from: u1b.a$a, reason: collision with other inner class name */
    public static final class C7822a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChameleonConfig f548361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f548362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ChameleonPluginHost f548363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<String, Pair<Long, Long>> f548364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, Object> f548365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f548366f;

        public C7822a(String r100, ChameleonConfig r101) {
            long r102 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Intrinsics.checkNotNullParameter(r101, "chameleonConfig");
            this.f548361a = r101;
            this.f548362b = r102;
            this.f548364d = new LinkedHashMap();
            this.f548365e = new LinkedHashMap();
        }

        public static /* synthetic */ void e(C7822a r100, String r101) {
            r100.d(r101, System.currentTimeMillis());
        }

        public final void c(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            Pair r102 = (Pair) ((LinkedHashMap) this.f548364d).get(r100);
            if (r102 == null) goto L6;
            this.f548364d.put(r100, new Pair(r102.getFirst(), Long.valueOf(r101)));
            return;
        }

        public final void d(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            this.f548364d.put(r100, new Pair(Long.valueOf(r101), 0L));
        }

        public static /* synthetic */ void b(C7822a r100, String r101, int r102) {
            r100.a(r101, r102, System.currentTimeMillis());
        }

        public final void a(String r100, int r110, long r111) {
            Intrinsics.checkNotNullParameter(r100, "result");
            if (this.f548366f == false) goto L5;
            return;
        L5:
            this.f548366f = true;
            JSONObject r101 = new JSONObject();
            r101.put("result", r100);
            r101.put("code", r110);
            r101.put("app_name", this.f548361a.getBizName());
            PreloadConfig r102 = this.f548361a.getPreloadConfig();
            if (r102 == null) goto L10;
            PreloadPolicy r103 = r102.getPolicy();
            if (r103 == null) goto L10;
        L11:
            r101.put(ChameleonOpenTracker.ParamKey.PRELOAD_TYPE, r103.ordinal());
            Lazy<n> r104 = TTWebViewUtil.f437209a;
            TTWebViewUtil.a.d(null);
            r101.put(ChameleonOpenTracker.ParamKey.IS_TT_WEBVIEW, 0);
            TTWebViewUtil.a.b().p();
            r101.put(ChameleonOpenTracker.ParamKey.TT_WEBVIEW_VERSION, "");
            r101.put(ChameleonOpenTracker.ParamKey.COST, r111 - this.f548362b);
            r101.put("recovery", Intrinsics.areEqual(a.f548360b, Boolean.TRUE));
            Iterator r112 = ((LinkedHashMap) this.f548364d).entrySet().iterator();
        L13:
            if (r112.hasNext() == false) goto L22;
            Map.Entry r113 = (Map.Entry) r112.next();
            if (((Number) ((Pair) r113.getValue()).getFirst()).longValue() <= 0) goto L13;
            if (((Number) ((Pair) r113.getValue()).getSecond()).longValue() <= ((Number) ((Pair) r113.getValue()).getFirst()).longValue()) goto L13;
            long r105 = ((Number) ((Pair) r113.getValue()).getFirst()).longValue() - this.f548362b;
            if (r105 <= 0) goto L21;
            r101.put(((String) r113.getKey()) + "_stage_start", r105);
        L21:
            r101.put(((String) r113.getKey()) + "_stage_cost", ((Number) ((Pair) r113.getValue()).getSecond()).longValue() - ((Number) ((Pair) r113.getValue()).getFirst()).longValue());
            goto L13
        L22:
            Iterator r114 = ((LinkedHashMap) this.f548365e).entrySet().iterator();
        L24:
            if (r114.hasNext() == false) goto L26;
            Map.Entry r115 = (Map.Entry) r114.next();
            r101.put((String) r115.getKey(), r115.getValue());
            goto L24
        L26:
            ChameleonPluginHost r116 = this.f548363c;
            if (r116 == null) goto L42;
            IDependency r117 = this.f548361a.getDependency();
            if (r117 == null) goto L42;
            IMonitorDependency r118 = r117.getMonitorDependency();
            if (r118 == null) goto L42;
            Map<String, Object> r119 = r118.getBizParams(r116);
            if (r119 == null) goto L42;
            Iterator<Map.Entry<String, Object>> r120 = r119.entrySet().iterator();
        L36:
            if (r120.hasNext() == false) goto L42;
            Map.Entry<String, Object> r121 = r120.next();
            String r106 = r121.getKey();
            Object r122 = r121.getValue();
            if (r101.has(r106) == true) goto L36;
            r101.put(r106, r122);     // Catch: Exception -> L41
        L41:
            j.f(ChameleonReport.TAG, "skip invalid biz param: " + r106);
        L42:
            j.e(ChameleonReport.TAG, "openFinish, eventName = webapp_open_finish_dev param is " + r101);
            b.b(ChameleonOpenTracker.Event.Chameleon_OPEN_FINISH_DEV, r101);
            a.f548360b = null;
            return;
        L10:
            r103 = PreloadPolicy.NO_PRELOAD;
            goto L11
        }
    }

    static {
        f548359a = new LinkedHashMap();
    }

    public static C7822a a(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (C7822a) ((LinkedHashMap) f548359a).get(r100);
    }

    @JvmStatic
    public static final String b(ChameleonConfig r110) {
        Intrinsics.checkNotNullParameter(r110, "chameleonConfig");
        ThreadLocal<SecureRandom> r100 = q.f543780a;
        SecureRandom r101 = r100.get();
        if (r101 != null) goto L5;
        r101 = new SecureRandom();
        r100.set(r101);
    L5:
        byte[] r102 = new byte[16];
        r101.nextBytes(r102);
        byte r103 = (byte) (r102[6] & 15);
        r102[6] = r103;
        r102[6] = (byte) (r103 | 64);
        byte r104 = (byte) (r102[8] & 63);
        r102[8] = r104;
        r102[8] = (byte) (r104 | ByteCompanionObject.MIN_VALUE);
        long r105 = 0;
        int r106 = 0;
        long r107 = 0;
    L6:
        if (r106 >= 8) goto L8;
        r107 = (r107 << 8) | ((long) (r102[r106] & UByte.MAX_VALUE));
        r106 = r106 + 1;
        goto L6
    L8:
        int r108 = 8;
    L9:
        if (r108 >= 16) goto L11;
        r105 = (r105 << 8) | ((long) (r102[r108] & UByte.MAX_VALUE));
        r108 = r108 + 1;
        goto L9
    L11:
        String r109 = new UUID(r107, r105).toString();
        f548359a.put(r109, new C7822a(r109, r110));
        return r109;
    }
}

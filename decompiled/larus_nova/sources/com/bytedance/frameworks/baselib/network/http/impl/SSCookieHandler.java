package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cookie.CookieMetricManager;
import com.bytedance.frameworks.baselib.network.http.cookie.WebviewCookieRawSyncUtil;
import com.bytedance.frameworks.baselib.network.http.cookie.f;
import com.bytedance.frameworks.baselib.network.http.cookie.h;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SSCookieHandler extends CookieManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile android.webkit.CookieManager f244734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f244735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f244736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f244737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f244738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WebViewCookieMgrUsage f244739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f244740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f244741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap<URI, List<String>> f244742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f244743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f244744k;

    public static final enum CookieInitType extends Enum<CookieInitType> {
        public static final CookieInitType INIT_V1 = null;
        public static final CookieInitType INIT_V2_DISABLE_COOKIE_MGR = null;
        public static final CookieInitType INIT_V2_PREFER_DELAY_COOKIE_MGR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CookieInitType[] f244745a = null;

        static {
            CookieInitType r100 = new CookieInitType("INIT_V1", 0);
            INIT_V1 = r100;
            CookieInitType r101 = new CookieInitType("INIT_V2_PREFER_DELAY_COOKIE_MGR", 1);
            INIT_V2_PREFER_DELAY_COOKIE_MGR = r101;
            CookieInitType r102 = new CookieInitType("INIT_V2_DISABLE_COOKIE_MGR", 2);
            INIT_V2_DISABLE_COOKIE_MGR = r102;
            f244745a = new CookieInitType[]{r100, r101, r102};
        }

        public static CookieInitType[] values() {
            return (CookieInitType[]) f244745a.clone();
        }

        public static CookieInitType valueOf(String r100) {
            return (CookieInitType) r27.a.a(CookieInitType.class, r100);
        }

        public CookieInitType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ReqCookieSource extends Enum<ReqCookieSource> {
        public static final ReqCookieSource APP_COOKIE_STORE = null;
        public static final ReqCookieSource MAIN = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_BACKUP = null;
        public static final ReqCookieSource SHARE_INTERCEPTOR_MAIN = null;
        public static final ReqCookieSource TT_WRAP = null;
        public static final ReqCookieSource UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReqCookieSource[] f244746a = null;

        static {
            ReqCookieSource r100 = new ReqCookieSource("UNKNOWN", 0);
            UNKNOWN = r100;
            ReqCookieSource r101 = new ReqCookieSource("APP_COOKIE_STORE", 1);
            APP_COOKIE_STORE = r101;
            ReqCookieSource r102 = new ReqCookieSource("SHARE_INTERCEPTOR_MAIN", 2);
            SHARE_INTERCEPTOR_MAIN = r102;
            ReqCookieSource r103 = new ReqCookieSource("SHARE_INTERCEPTOR_BACKUP", 3);
            SHARE_INTERCEPTOR_BACKUP = r103;
            ReqCookieSource r104 = new ReqCookieSource(AccountType.MAIN, 4);
            MAIN = r104;
            ReqCookieSource r105 = new ReqCookieSource("TT_WRAP", 5);
            TT_WRAP = r105;
            f244746a = new ReqCookieSource[]{r100, r101, r102, r103, r104, r105};
        }

        public static ReqCookieSource[] values() {
            return (ReqCookieSource[]) f244746a.clone();
        }

        public static ReqCookieSource valueOf(String r100) {
            return (ReqCookieSource) r27.a.a(ReqCookieSource.class, r100);
        }

        public ReqCookieSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final enum TtCookieRelTestState extends Enum<TtCookieRelTestState> {
        public static final TtCookieRelTestState BOTH_EMPTY = null;
        public static final TtCookieRelTestState EQUAL = null;
        public static final TtCookieRelTestState INVALID = null;
        public static final TtCookieRelTestState NOT_EQUAL = null;
        public static final TtCookieRelTestState ONLY_SYS_EMPTY = null;
        public static final TtCookieRelTestState ONLY_TT_EMPTY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TtCookieRelTestState[] f244747a = null;

        static {
            TtCookieRelTestState r100 = new TtCookieRelTestState("INVALID", 0);
            INVALID = r100;
            TtCookieRelTestState r101 = new TtCookieRelTestState("BOTH_EMPTY", 1);
            BOTH_EMPTY = r101;
            TtCookieRelTestState r102 = new TtCookieRelTestState("ONLY_SYS_EMPTY", 2);
            ONLY_SYS_EMPTY = r102;
            TtCookieRelTestState r103 = new TtCookieRelTestState("ONLY_TT_EMPTY", 3);
            ONLY_TT_EMPTY = r103;
            TtCookieRelTestState r104 = new TtCookieRelTestState("NOT_EQUAL", 4);
            NOT_EQUAL = r104;
            TtCookieRelTestState r105 = new TtCookieRelTestState("EQUAL", 5);
            EQUAL = r105;
            f244747a = new TtCookieRelTestState[]{r100, r101, r102, r103, r104, r105};
        }

        public static TtCookieRelTestState[] values() {
            return (TtCookieRelTestState[]) f244747a.clone();
        }

        public static TtCookieRelTestState valueOf(String r100) {
            return (TtCookieRelTestState) r27.a.a(TtCookieRelTestState.class, r100);
        }

        public TtCookieRelTestState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum WebViewCookieMgrUsage extends Enum<WebViewCookieMgrUsage> {
        public static final WebViewCookieMgrUsage COLD_START_DELAY_INIT = null;
        public static final WebViewCookieMgrUsage DISABLED = null;
        public static final WebViewCookieMgrUsage INIT_AT_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WebViewCookieMgrUsage[] f244748a = null;

        static {
            WebViewCookieMgrUsage r100 = new WebViewCookieMgrUsage("INIT_AT_START", 0);
            INIT_AT_START = r100;
            WebViewCookieMgrUsage r101 = new WebViewCookieMgrUsage("COLD_START_DELAY_INIT", 1);
            COLD_START_DELAY_INIT = r101;
            WebViewCookieMgrUsage r102 = new WebViewCookieMgrUsage("DISABLED", 2);
            DISABLED = r102;
            f244748a = new WebViewCookieMgrUsage[]{r100, r101, r102};
        }

        public static WebViewCookieMgrUsage[] values() {
            return (WebViewCookieMgrUsage[]) f244748a.clone();
        }

        public static WebViewCookieMgrUsage valueOf(String r100) {
            return (WebViewCookieMgrUsage) r27.a.a(WebViewCookieMgrUsage.class, r100);
        }

        public WebViewCookieMgrUsage(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        ArrayList<String> getCookieFlushPathList();

        void onEvent(String r100, JSONObject r101);
    }

    public final void a() {
        if (this.f244737d == true) goto L5;
        return;
    L5:
        if (this.f244734a == null) goto L7;
        return;
    L7:
        if (this.f244739f == WebViewCookieMgrUsage.DISABLED) goto L24;
        this.f244734a = android.webkit.CookieManager.getInstance();     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Logger.e("SSCookieHandler", "CookieInitV2 CookieManager get failed", th);
        if (this.f244738e == true) goto L15;
        return;
    L15:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L23;
        new Handler(Looper.getMainLooper()).post(new e(this));
        return;
    L23:
        return;
    }

    public static Map c(List r100, Map r101) {
        Map r102 = Collections.emptyMap();
        if (r101 == null) goto L5;
        List r103 = e(r101, "Cookie");
    L7:
        if (CollectionUtils.isEmpty(r103) == true) goto L9;
        return r102;
    L9:
        return Collections.singletonMap("Cookie", r100);
    L5:
        r103 = null;
        goto L7
    }

    public static List e(Map r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        List r102 = (List) r100.get(r101);
        if (r102 == null) goto L13;
        if (r102.isEmpty() == true) goto L13;
        return r102;
    L13:
        return (List) r100.get(r101.toLowerCase());
    L18:
        return null;
    }

    public final void b(String r100, boolean r101) {
        if (this.f244734a != null) goto L5;
        return;
    L5:
        if (this.f244739f != WebViewCookieMgrUsage.DISABLED) goto L7;
        return;
    L7:
        if (r101 == false) goto L12;
        this.f244734a.flush();
        if (Logger.debug() == false) goto L29;
        Logger.d("SSCookieHandler", "Force flush cookie: " + r100);
        return;
    L29:
        return;
    L12:
        ArrayList<String> r102 = this.f244736c.getCookieFlushPathList();
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return;
    L15:
        if (CollectionUtils.isEmpty(r102) == true) goto L34;
        Iterator<String> r103 = r102.iterator();
    L19:
        if (r103.hasNext() == false) goto L35;
        if (r100.equals(r103.next()) == false) goto L19;
        this.f244734a.flush();
        if (Logger.debug() == false) goto L33;
        Logger.d("SSCookieHandler", "Path match flush cookie: ".concat(r100));
        return;
    L33:
        return;
    L35:
        return;
    }

    public final boolean f(URI r100, String r101) {
        if (r100 != null) goto L5;
    L25:
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L25;
        String r102 = r100.getHost().toLowerCase();     // Catch: Throwable -> L23
        String r103 = "";
        Matcher r104 = this.f244735b.matcher(r101);     // Catch: Throwable -> L23
        if (r104.find() == false) goto L11;
        r103 = r104.group().toLowerCase();     // Catch: Throwable -> L23
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L14;
        return false;
    L14:
        if (r103.equals(r102) == false) goto L18;
        return true;
    L18:
        if (r103.startsWith(".") == false) goto L22;
        return r102.endsWith(r103);
    L22:
        return r102.endsWith(".".concat(r103));
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public final Map<String, List<String>> get(URI r210, Map<String, List<String>> r211) throws IOException {
        if (r210 == null) goto L5;
        String r100 = r210.toString();     // Catch: Throwable -> L43
        if (r211 != null) goto L282;
    L38:
        boolean r101 = false;
        boolean r102 = false;
        boolean r110 = false;
    L39:
        NetworkParams.getAppCookieStore();     // Catch: Throwable -> L41
    L315:
        NetworkParams.h r103 = NetworkParams.getCookieShareInterceptor();     // Catch: Throwable -> L58
        if (r103 == null) goto L60;
        List<String> r104 = r103.getShareCookie(this.f244734a, b.a.f244757a, r210);     // Catch: Throwable -> L58
        if (Lists.isEmpty(r104) == true) goto L60;
        ReqCookieSource r111 = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;     // Catch: Throwable -> L58
        if (r104.remove("x-tt-cookie-backup-source=1") == false) goto L56;
        r111 = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;     // Catch: Throwable -> L58
    L56:
        return d(r101, c(r104, r211), r111);
    L60:
        WebViewCookieMgrUsage r105 = this.f244739f;
        if (r105 != WebViewCookieMgrUsage.DISABLED) goto L63;
        boolean r112 = true;
    L65:
        if (this.f244737d == false) goto L78;
        if (r110 == false) goto L68;
    L72:
        boolean r106 = false;
    L73:
        r112 = r112 | r106;
        if (r112 == true) goto L78;
        if (this.f244734a != null) goto L78;
        a();
        goto L78
    L68:
        if (r105 != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L72;
        if (this.f244741h.get() == true) goto L72;
        r106 = true;
    L78:
        long r113 = -1;
        if (this.f244734a == null) goto L112;
        if (r112 == true) goto L112;
        long r114 = System.nanoTime();     // Catch: Exception -> L109
        String r115 = this.f244734a.getCookie(r100);     // Catch: Exception -> L109
        if (r102 == true) goto L311;
        long r212 = -1;
        boolean r107 = false;
        String r108 = null;
    L284:
    L107:
        e = e;
        r115 = r108;
    L111:
        e.printStackTrace();
        boolean r109 = r107;
        long r116 = r212;
        Map<String, List<String>> r117 = null;
    L113:
        if (r117 == null) goto L309;
        long r213 = -1;
        Pair<String, Map<String, Set<f>>> r118 = null;
    L147:
        long r119 = System.nanoTime();
        JSONObject r120 = new JSONObject();
        if (r102 == true) goto L289;
    L215:
        r117 = r117;
        boolean r121 = false;
    L217:
        int r122 = 1;
        if ((!ix5.b.f496366e) == true) goto L234;
        long r123 = System.nanoTime();     // Catch: Throwable -> L224
        JSONObject r124 = CookieMetricManager.a.f244685a.a();     // Catch: Throwable -> L224
        r113 = (System.nanoTime() - r123) / 1000;     // Catch: Throwable -> L222
    L227:
        long r125 = r113;
        if (r124 == null) goto L231;
        r120.put("detail", r124);     // Catch: Throwable -> L266
    L231:
        if (r125 <= 0) goto L234;
        r120.put("detail_t", r125);     // Catch: Throwable -> L266
    L222:
        th = th;
    L226:
        th.printStackTrace();     // Catch: Throwable -> L266
    L224:
        th = th;
        r124 = null;
    L234:
        if (this.f244739f == WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L238;
        r122 = 0;
    L238:
        if (this.f244734a != null) goto L240;
        int r126 = 0;
    L242:
        if (this.f244741h.get() == false) goto L244;
        int r127 = 4;
    L245:
        if (r110 == false) goto L247;
        int r128 = 8;
    L248:
        if (r121 == false) goto L250;
        int r129 = 16;
    L251:
        if (r109 == false) goto L253;
        int r130 = 32;
    L255:
        if (this.f244739f != WebViewCookieMgrUsage.DISABLED) goto L257;
        int r131 = 64;
    L258:
        r120.put("init_state", (((((r126 | r122) | r127) | r128) | r129) | r130) | r131);     // Catch: Throwable -> L266
        long r132 = b.f244755b;     // Catch: Throwable -> L266
        if (r132 <= 0) goto L261;
        r120.put("tt_init", r132);     // Catch: Throwable -> L266
    L261:
        long r133 = this.f244744k;     // Catch: Throwable -> L266
        if (r133 <= 0) goto L264;
        r120.put("cs_t", r133);     // Catch: Throwable -> L266
    L264:
        r120.put("rel_t", (System.nanoTime() - r119) / 1000);     // Catch: Throwable -> L266
        String r134 = r120.toString();     // Catch: Throwable -> L266
    L269:
        if (TextUtils.isEmpty(r134) == false) goto L271;
        Map<String, List<String>> r135 = r117;
        if (r135 != null) goto L280;
        return Collections.emptyMap();
    L280:
        return r135;
    L271:
        if (r117 == null) goto L273;
        LinkedHashMap r136 = new LinkedHashMap(r117);
    L274:
        r136.put("x-tt-cookie-rel-metric", Collections.singletonList(r134));
        return r136;
    L273:
        r136 = new LinkedHashMap();
        goto L274
    L257:
        r131 = 0;
        goto L258
    L253:
        r130 = 0;
        goto L255
    L250:
        r129 = 0;
        goto L251
    L247:
        r128 = 0;
        goto L248
    L244:
        r127 = 0;
        goto L245
    L240:
        r126 = 2;
        goto L242
    L289:
    L213:
        th = th;
        r117 = r117;
    L267:
        th.printStackTrace();
        r134 = null;
        goto L269
    L150:
        if (this.f244734a == null) goto L215;
        if (r213 != (-1)) goto L154;
        long r137 = System.nanoTime();     // Catch: Throwable -> L213
        r118 = b.a.f244757a.b(r210);     // Catch: Throwable -> L213
        r213 = (System.nanoTime() - r137) / 1000;     // Catch: Throwable -> L213
    L154:
        long r138 = r213;
        if (r118 == null) goto L160;
        Object r139 = r118.first;     // Catch: Throwable -> L213
        if (r139 == null) goto L160;
        String r140 = (String) r139;     // Catch: Throwable -> L213
    L161:
        if (r115 != null) goto L164;
        r115 = "";
    L164:
        if (r115.isEmpty() == false) goto L169;
        if (r140.isEmpty() == false) goto L169;
        TtCookieRelTestState r141 = TtCookieRelTestState.BOTH_EMPTY;     // Catch: Throwable -> L213
    L189:
        double r142 = 100.0d;
        r121 = false;
    L308:
        r120.put(NotificationCompat.CATEGORY_SYSTEM, r116);     // Catch: Throwable -> L266
        r120.put("tt", r138);     // Catch: Throwable -> L266
        r120.put("rel", r141.ordinal());     // Catch: Throwable -> L266
        r120.put("rel_p", r142);     // Catch: Throwable -> L266
        JSONObject r143 = WebviewCookieRawSyncUtil.f244687b;     // Catch: Throwable -> L266
        monitor-enter(r143);     // Catch: Throwable -> L266
    L210:
        th = move-exception;
        throw th;     // Catch: Throwable -> L266
    L202:
        if (r143.length() <= 0) goto L204;
        String r144 = r143.toString();     // Catch: Throwable -> L210
    L205:
        monitor-exit(r143);     // Catch: Throwable -> L210
    L207:
        if (TextUtils.isEmpty(r144) == true) goto L217;
        r120.put(DocumentType.DOCX_SYNC_BLOCK_NAME, new JSONObject(r144));     // Catch: Throwable -> L281
        goto L217
    L204:
        r144 = null;
    L266:
        th = th;
    L169:
        if (r115.equalsIgnoreCase(r140) == false) goto L171;
        r141 = TtCookieRelTestState.EQUAL;     // Catch: Throwable -> L213
        goto L189
    L171:
        HashSet r145 = new HashSet();     // Catch: Throwable -> L213
        if (TextUtils.isEmpty(r115) == false) goto L302;
    L180:
        if (r118 == null) goto L185;
        Object r146 = r118.second;     // Catch: Throwable -> L213
        if (r146 == null) goto L185;
        Map r147 = (Map) r146;     // Catch: Throwable -> L213
    L186:
        Set r148 = r147.keySet();     // Catch: Throwable -> L213
        if (r145.equals(r148) == false) goto L191;
        r141 = TtCookieRelTestState.EQUAL;     // Catch: Throwable -> L213
        goto L189
    L191:
        if (r145.isEmpty() == false) goto L194;
        TtCookieRelTestState r149 = TtCookieRelTestState.ONLY_SYS_EMPTY;     // Catch: Throwable -> L213
    L197:
        Pair<Boolean, Double> r150 = com.bytedance.frameworks.baselib.network.http.cookie.e.a(r145, r147, r120);     // Catch: Throwable -> L213
        r121 = ((Boolean) r150.first).booleanValue();     // Catch: Throwable -> L213
        double r214 = ((Double) r150.second).doubleValue();     // Catch: Throwable -> L213
        r141 = r149;
        r142 = r214;
        goto L308
    L194:
        if (r148.isEmpty() == false) goto L196;
        r149 = TtCookieRelTestState.ONLY_TT_EMPTY;     // Catch: Throwable -> L213
        goto L197
    L196:
        r149 = TtCookieRelTestState.NOT_EQUAL;     // Catch: Throwable -> L213
    L185:
        r147 = new HashMap();     // Catch: Throwable -> L213
        goto L186
    L302:
        String[] r151 = r115.split(";\\s*");     // Catch: Throwable -> L178
        if (r151.length <= 0) goto L180;
        r145.addAll(Arrays.asList(r151));     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L213
    L160:
        r140 = "";
        goto L161
    L309:
        if (r102 == false) goto L124;
        long r215 = System.nanoTime();     // Catch: Throwable -> L143
        r118 = b.a.f244757a.b(r210);     // Catch: Throwable -> L143
        if (r118 != null) goto L306;
        String r152 = null;
    L121:
        r213 = (System.nanoTime() - r215) / 1000;     // Catch: Throwable -> L118
    L304:
        if (TextUtils.isEmpty(r152) == false) goto L129;
        Pair<String, Map<String, Set<f>>> r216 = r118;
    L139:
        r118 = r216;
        goto L147
    L129:
        if (Logger.debug() == false) goto L133;
        StringBuilder r153 = new StringBuilder();     // Catch: Throwable -> L140
        r216 = r118;
        r153.append("send ttWrap cookie: ");     // Catch: Throwable -> L136
        r153.append(r100);     // Catch: Throwable -> L136
        r153.append(" ");     // Catch: Throwable -> L136
        r153.append(r152);     // Catch: Throwable -> L136
        Logger.v("SSCookieHandler", r153.toString());     // Catch: Throwable -> L136
    L134:
        r117 = d(r101, c(Collections.singletonList(r152), r211), ReqCookieSource.TT_WRAP);     // Catch: Throwable -> L136
    L136:
        th = th;
    L142:
        r118 = r216;
    L145:
        th.printStackTrace();
        goto L147
    L133:
        r216 = r118;
    L140:
        th = th;
        r216 = r118;
    L118:
        th = th;
        r213 = -1;
        goto L145
    L306:
        r152 = (String) r118.first;     // Catch: Throwable -> L118
        goto L121
    L124:
        r152 = b.a.f244757a.a(r210);     // Catch: Throwable -> L143
        r213 = -1;
        r118 = null;
    L143:
        th = th;
        r213 = -1;
        r118 = null;
        goto L145
    L99:
        if (TextUtils.isEmpty(r115) == false) goto L101;
        Map<String, List<String>> r154 = null;
    L106:
        r115 = r108;
        r116 = r212;
        r109 = r107;
        r117 = r154;
        goto L113
    L101:
        if (Logger.debug() == false) goto L103;
        Logger.v("SSCookieHandler", "send cookie: " + r100 + " " + r115);     // Catch: Exception -> L107
    L103:
        r154 = d(r101, c(Collections.singletonList(r115), r211), ReqCookieSource.MAIN);     // Catch: Exception -> L107
        goto L106
    L311:
        r212 = (System.nanoTime() - r114) / 1000;     // Catch: Exception -> L94
    L92:
        e = e;
    L96:
        r107 = false;
        goto L111
    L85:
        if (this.f244740g <= 0) goto L90;
        if ((System.currentTimeMillis() - this.f244740g) > 3000) goto L90;
        boolean r155 = true;
    L91:
        r107 = r155;
        r108 = r115;
    L90:
        r155 = false;
    L94:
        e = e;
        r212 = -1;
    L109:
        e = e;
        r212 = -1;
        r107 = false;
        r115 = null;
    L112:
        r116 = -1;
        r117 = null;
        r109 = false;
        r115 = null;
        goto L113
    L63:
        r112 = false;
    L58:
        th = move-exception;
        th.printStackTrace();
        goto L60
    L282:
    L36:
        th = th;
    L45:
        r101 = false;
    L46:
        r102 = false;
    L47:
        r110 = false;
    L48:
        th.printStackTrace();
        goto L315
    L9:
        if (r211.isEmpty() == true) goto L38;
        r101 = r211.containsKey("x-tt-get-cookie-source");     // Catch: Throwable -> L36
    L34:
        th = th;
        goto L46
    L12:
        if (r211.containsKey("x-tt-cookie-rel-metric") == false) goto L16;
        if (ix5.b.f496374m == false) goto L16;
        r102 = true;
    L313:
        r110 = r211.containsKey("x-tt-webview-request");     // Catch: Throwable -> L32
        List r156 = e(r211, "X-SS-No-Cookie");     // Catch: Throwable -> L41
        if (CollectionUtils.isEmpty(r156) == true) goto L39;
        Iterator r157 = r156.iterator();     // Catch: Throwable -> L41
    L22:
        if (r157.hasNext() == false) goto L39;
        String r158 = (String) r157.next();     // Catch: Throwable -> L41
        if (r158 == null) goto L22;
        if (Boolean.parseBoolean(r158) == false) goto L22;
        if (Logger.debug() == false) goto L31;
        Logger.v("SSCookieHandler", "X-SS-No-Cookie " + r100);     // Catch: Throwable -> L41
    L31:
        return Collections.emptyMap();
    L41:
        th = th;
    L32:
        th = th;
    L16:
        r102 = false;
    L43:
        th = th;
        r100 = null;
        goto L45
    L5:
        return Collections.emptyMap();
    }

    public final String k(String r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L32;
        return null;
    L32:
        Matcher r100 = this.f244735b.matcher(r111);     // Catch: IllegalArgumentException -> L31
        if (r100.find() == false) goto L8;
        String r101 = r100.group().toLowerCase();     // Catch: IllegalArgumentException -> L31
    L10:
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return r111;
    L12:
        boolean r102 = false;
        if (r101.length() < 2) goto L27;
        int r103 = 1;
        int r104 = 0;
    L17:
        if (r103 >= r101.length()) goto L24;
        if (r101.charAt(r103) != '.') goto L23;
        r104 = r104 + 1;     // Catch: IllegalArgumentException -> L31
        if (r104 >= 2) goto L24;
    L23:
        r103 = r103 + 1;     // Catch: IllegalArgumentException -> L31
    L24:
        if (r104 < 2) goto L27;
        r102 = true;
    L27:
        if (r102 == false) goto L38;
        return r100.replaceFirst(r110);
    L38:
        return null;
    L8:
        r101 = null;
    L39:
        return null;
    }

    public final void l(String r100, List<String> r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<String> r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        String r104 = k(r100, r103.next());
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r102.add(r104);
        goto L7
    L13:
        if (r102.isEmpty() == false) goto L16;
        return;
    L16:
        if (Logger.debug() == false) goto L23;
        Logger.d("SSCookieHandler", "Sync cookies list for WebView request, original url: " + r100);
    L23:
        HashMap r105 = new HashMap();     // Catch: Throwable -> L20
        r105.put(new URI(r100), r102);     // Catch: Throwable -> L20
        j(r105, true, false);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r30v10 */
    /* JADX WARN: Type inference failed for: r30v11 */
    /* JADX WARN: Type inference failed for: r30v12 */
    /* JADX WARN: Type inference failed for: r30v13 */
    /* JADX WARN: Type inference failed for: r30v14 */
    /* JADX WARN: Type inference failed for: r30v15 */
    /* JADX WARN: Type inference failed for: r30v16 */
    /* JADX WARN: Type inference failed for: r30v17 */
    /* JADX WARN: Type inference failed for: r30v18 */
    /* JADX WARN: Type inference failed for: r30v4 */
    /* JADX WARN: Type inference failed for: r30v5 */
    /* JADX WARN: Type inference failed for: r30v6 */
    /* JADX WARN: Type inference failed for: r30v7 */
    /* JADX WARN: Type inference failed for: r30v8 */
    /* JADX WARN: Type inference failed for: r30v9 */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler] */
    /* JADX WARN: Type inference failed for: r7v38, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v44 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [boolean] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    public final void put(URI r310, Map<String, List<String>> r311) throws IOException {
        boolean r100 = ix5.b.f496362a;
        String r101 = "store-region=";
        String r110 = "store-country-code=";
        String r111 = "sessionid=";
        String r102 = "://";
        String r103 = "SSCookieHandler";
        String r112 = "receive cookie: ";
        String r210 = "";
        String r211 = HTTP.URL_DEFAULT;
        String r104 = "Set-Cookie";
        if (r100 == false) goto L5;
    L207:
        CharSequence r312 = "store-region=";
        CharSequence r313 = "store-country-code=";
        CharSequence r314 = "sessionid=";
        String r105 = r211;
        String r113 = "://";
        if (r310 == null) goto L435;
        if (r311 != null) goto L211;
        return;
    L211:
        if (r311.isEmpty() == true) goto L437;
        List r106 = e(r311, "Set-Cookie");
        if (Lists.isEmpty(r106) == true) goto L438;
        NetworkParams.h r107 = NetworkParams.getCookieShareInterceptor();
        if (r107 == null) goto L219;
        List<String> r108 = r107.getShareCookieHostList(r310.getHost());
    L221:
        if (ix5.b.f496367f == false) goto L223;
        JSONObject r109 = new JSONObject();
    L224:
        if (r109 == null) goto L232;
        g(r109, "version", "v2");
        g(r109, "url", r310.toString());
        if (r108 == null) goto L229;
        r210 = r108.toString();
    L229:
        g(r109, "shareHostList", r210);
        g(r109, "responseHeaders", r311.toString());
        g(r109, "setCookieList", r106.toString());
    L232:
        if (ix5.a.f496359a == true) goto L234;
    L356:
        NetworkParams.getAppCookieStore();     // Catch: Throwable -> L240
    L242:
        List<String> r114 = r311.get("webview-origin-url");
        if (Lists.isEmpty(r114) == true) goto L251;
        String r115 = (String) ListProtector.get(r114, 0);
        if (TextUtils.isEmpty(r115) == false) goto L366;
    L250:
        String r116 = r115;
        boolean r117 = true;
    L252:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r106.iterator();
        boolean r120 = false;
    L254:
        if (r119.hasNext() == false) goto L289;
        String r121 = (String) r119.next();
        if (Logger.debug() == false) goto L259;
        Logger.v("SSCookieHandler", r112 + r310 + ", set-cookie:" + r121);
    L259:
        if (TextUtils.isEmpty(r121) == true) goto L254;
        String r122 = r121.toLowerCase().trim();
        CharSequence r123 = r314;
        if (r122.contains(r123) == false) goto L264;
        r120 = true;
    L264:
        if (r120 == false) goto L266;
    L274:
        CharSequence r124 = r312;
        CharSequence r125 = r313;
    L276:
        if (ix5.b.a(r121) == false) goto L279;
    L288:
        r314 = r123;
        r313 = r125;
        r312 = r124;
        goto L254
    L279:
        if (TextUtils.isEmpty(r116) == false) goto L288;
        if (Lists.isEmpty(r108) == true) goto L288;
        if (f(r310, r121) == false) goto L288;
        r118.add(r121);
        goto L288
    L266:
        if (ix5.b.f496364c == false) goto L274;
        r125 = r313;
        if (r122.contains(r125) == true) goto L272;
        r124 = r312;
        if (r122.contains(r124) == false) goto L276;
    L273:
        r120 = true;
        goto L276
    L272:
        r124 = r312;
        goto L273
    L289:
        HashMap r126 = new HashMap();
        r126.put(r310, r106);
        if (r118.isEmpty() == false) goto L292;
    L322:
        j(r126, r117, false);
        b(r310.getPath(), r120);     // Catch: Throwable -> L325
    L328:
        if (r109 == null) goto L330;
        boolean r127 = true;
    L331:
        i(r109, "last return", r127);
        return;
    L330:
        r127 = false;
    L325:
        th = move-exception;
        th.printStackTrace();
        goto L328
    L292:
        if (Lists.isEmpty(r108) == true) goto L322;
        Iterator<String> r128 = r108.iterator();
    L295:
        if (r128.hasNext() == false) goto L322;
        String r129 = r128.next();
        if (TextUtils.isEmpty(r129) == true) goto L295;
        if (r310.getHost().endsWith(r129) == true) goto L295;
        ArrayList r130 = new ArrayList();     // Catch: Throwable -> L318
        Iterator r131 = r118.iterator();     // Catch: Throwable -> L318
    L304:
        if (r131.hasNext() == false) goto L308;
        String r132 = this.f244735b.matcher((String) r131.next()).replaceFirst(r129);     // Catch: Throwable -> L318
        if (TextUtils.isEmpty(r132) == true) goto L304;
        r130.add(r132);     // Catch: Throwable -> L318
        goto L304
    L308:
        StringBuilder r133 = new StringBuilder();     // Catch: Throwable -> L318
        r133.append(r310.getScheme());     // Catch: Throwable -> L318
        String r134 = r113;
        r133.append(r134);     // Catch: Throwable -> L316
        r133.append(r129);     // Catch: Throwable -> L316
        String r135 = r105;
        r133.append(r135);     // Catch: Throwable -> L314
        r126.put(URI.create(r133.toString()), r130);     // Catch: Throwable -> L314
    L321:
        r113 = r134;
        r105 = r135;
    L314:
        th = th;
    L320:
        th.printStackTrace();
    L316:
        th = th;
        r135 = r105;
    L318:
        th = th;
        r135 = r105;
        r134 = r113;
        goto L320
    L366:
        l(r115, r106);     // Catch: Throwable -> L248
    L248:
        th = move-exception;
        th.printStackTrace();
        goto L250
    L251:
        r117 = false;
        r116 = null;
    L240:
        th = move-exception;
        th.printStackTrace();
        goto L242
    L234:
        if ("http".equalsIgnoreCase(r310.getScheme()) == false) goto L356;
        if (r108 == null) goto L237;
        r108.clear();
    L237:
        g(r109, "disable_share_insecure_cookie", "1");
        goto L356
    L223:
        r109 = null;
        goto L224
    L219:
        r108 = null;
        goto L221
    L438:
        return;
    L437:
        return;
    L435:
        return;
    L5:
        if (this.f244737d == true) goto L207;
        if (this.f244734a != null) goto L10;
        return;
    L10:
        NetworkParams.h r136 = NetworkParams.getCookieShareInterceptor();
        if (r136 == null) goto L14;
        if (r310 == null) goto L14;
        List<String> r137 = r136.getShareCookieHostList(r310.getHost());
    L15:
        JSONObject r138 = new JSONObject();
        if (r311 != null) goto L18;
    L22:
        boolean r139 = false;
    L23:
        if (r137 != null) goto L370;
        String r140 = "";
    L26:
        r138.put("shareHostList", r140);     // Catch: JSONException -> L333
        if (r139 == false) goto L29;
        r138.put("responseHeaders", r311.toString());     // Catch: JSONException -> L333
    L29:
        if (r310 == null) goto L32;
        r210 = r310.toString();     // Catch: JSONException -> L333
    L32:
        r138.put("url", r210);     // Catch: JSONException -> L333
        if (r310 != null) goto L35;
    L380:
        NetworkParams.getAppCookieStore();     // Catch: Throwable -> L43
    L45:
        if (r311 != null) goto L47;
    L49:
        boolean r141 = false;
    L50:
        if (r310 == null) goto L205;
        if (r311 == null) goto L205;
        if (this.f244734a == null) goto L205;
        HashSet r142 = new HashSet();
        String r143 = r310.toString();
        String[] r144 = {"Set-Cookie"};
        int r145 = r144.length;
        ?? r212 = r139;
        boolean r146 = false;
        int r147 = 0;
        boolean r213 = false;
        ?? r148 = r101;
    L56:
        if (r147 >= r145) goto L154;
        int r214 = r145;
        String r149 = r144[r147];
        List<String> r215 = r311.get(r149);
        if (r215 != null) goto L60;
    L63:
        String[] r216 = r144;
        List<String> r150 = r311.get(r149.toLowerCase());
        if (r150 != null) goto L66;
    L152:
        ?? r315 = r148;
        String r316 = r110;
        String r317 = r111;
        String r151 = r112;
        String r152 = r211;
        String r153 = r102;
        String r154 = r103;
        String r155 = r143;
        r146 = r146;
    L153:
        r147 = r147 + 1;
        r103 = r154;
        r211 = r152;
        r102 = r153;
        r143 = r155;
        r145 = r214;
        r144 = r216;
        r104 = r104;
        r148 = r315;
        r111 = r317;
        r112 = r151;
        r110 = r316;
        goto L56
    L66:
        if (r150.isEmpty() == true) goto L152;
    L70:
        boolean r217 = r146;
        r138.put("cookieMgrList", r150.toString());     // Catch: JSONException -> L334
    L74:
        Iterator<String> r156 = r150.iterator();
        r146 = r217;
        ?? r157 = r148;
    L76:
        if (r156.hasNext() == false) goto L151;
        String r158 = r156.next();
        Iterator<String> r218 = r156;
        if (r158.toLowerCase().trim().contains(r111) == false) goto L80;
        r146 = true;
    L80:
        if (r146 == false) goto L82;
    L88:
        h(r143, r158, r142);
        if (r141 == false) goto L105;
        boolean r219 = r146;
        String r159 = (String) ListProtector.get(r311.get("webview-origin-url"), 0);
        if (this.f244734a != null) goto L93;
    L103:
        ?? r318 = r157;
        String r160 = r103;
    L104:
        String r161 = r160;
        ?? r319 = r318;
    L114:
        String r320 = r110;
        String r321 = r111;
        String r162 = r211;
        String r163 = r102;
        ?? r322 = r319;
    L150:
        r103 = r161;
        r211 = r162;
        r102 = r163;
        r143 = r143;
        r146 = r219;
        r156 = r218;
        r157 = r322;
        r111 = r321;
        r112 = r112;
        r110 = r320;
        goto L76
    L93:
        if (TextUtils.isEmpty(r159) == true) goto L103;
        String r164 = k(r159, r158);
        if (TextUtils.isEmpty(r164) == true) goto L103;
        if (Logger.debug() == false) goto L101;
        r160 = r103;
        Logger.d(r160, " Sync cookies for WebView request, original url: " + r159);
    L102:
        h(r159, r164, r142);
        r318 = r157;
        goto L104
    L101:
        r160 = r103;
        goto L102
    L105:
        r219 = r146;
        r322 = r157;
        r161 = r103;
    L145:
        r320 = r110;
        r321 = r111;
        r162 = r211;
        r163 = r102;
    L147:
        if (Logger.debug() == false) goto L149;
        r112 = r112;
        Logger.v(r161, r112 + r143 + " " + r149 + ": " + r158);
        goto L150
    L149:
        r322 = r322;
        goto L150
    L107:
        if (ix5.b.a(r158) == false) goto L110;
        r319 = r322;
        goto L114
    L110:
        if ((!Lists.isEmpty(r137)) == true) goto L112;
        r319 = r322;
        goto L114
    L112:
        r319 = r322;
        if (f(r310, r158) == false) goto L114;
        Iterator<String> r165 = r137.iterator();     // Catch: Throwable -> L145
    L118:
        if (r165.hasNext() == false) goto L144;
        String r166 = r165.next();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r166) == true) goto L118;
        Iterator<String> r220 = r165;
        if (r310.getHost().endsWith(r166) == true) goto L126;
        String r167 = this.f244735b.matcher(r158).replaceFirst(r166);     // Catch: Throwable -> L338
        if (TextUtils.isEmpty(r167) == true) goto L140;
        String r323 = r110;
        StringBuilder r168 = new StringBuilder();     // Catch: Throwable -> L337
        String r324 = r111;
        r168.append(r310.getScheme());     // Catch: Throwable -> L336
        String r169 = r102;
        r168.append(r169);     // Catch: Throwable -> L138
        r168.append(r166);     // Catch: Throwable -> L138
        String r170 = r211;
        r168.append(r170);     // Catch: Throwable -> L335
        h(r168.toString(), r167, r142);     // Catch: Throwable -> L335
    L143:
        r211 = r170;
        r102 = r169;
        r165 = r220;
        r110 = r323;
        r111 = r324;
    L138:
        r170 = r211;
    L142:
        r170 = r211;
        r169 = r102;
    L141:
        r324 = r111;
        goto L142
    L126:
        r165 = r220;
    L140:
        r323 = r110;
    L139:
        r220 = r165;
        goto L140
    L144:
        r320 = r110;
        r321 = r111;
        r162 = r211;
        r163 = r102;
        goto L147
    L82:
        if (ix5.b.f496364c == false) goto L88;
        if (r158.toLowerCase().trim().contains(r110) == false) goto L86;
    L87:
        r146 = true;
        goto L88
    L86:
        if (r158.toLowerCase().trim().contains(r157) == false) goto L88;
    L151:
        r315 = r157;
        r316 = r110;
        r317 = r111;
        r151 = r112;
        r152 = r211;
        r153 = r102;
        r154 = r103;
        r155 = r143;
        r213 = true;
        goto L153
    L60:
        if (r215.isEmpty() == true) goto L63;
        r216 = r144;
        r150 = r215;
        goto L70
    L154:
        String r221 = r104;
        boolean r222 = r146;
        String r171 = r102;
        NetworkParams.getCookieUpdateListener();
        r142.isEmpty();
        if (r213 == false) goto L382;
        b(r310.getPath(), r222);     // Catch: Throwable -> L339
    L382:
        LinkedHashMap r172 = new LinkedHashMap();     // Catch: Throwable -> L200
        r172.putAll(r311);     // Catch: Throwable -> L200
        b.a.f244757a.c(r310, (List) r172.get(r221));     // Catch: Throwable -> L200
        if ((!Lists.isEmpty(r137)) == false) goto L195;
        if (r141 == true) goto L195;
        Iterator<String> r173 = r137.iterator();     // Catch: Throwable -> L200
    L163:
        if (r173.hasNext() == false) goto L194;
        String r174 = r173.next();     // Catch: Throwable -> L200
    L192:
        r148 = r212 == true ? 1 : 0;
    L193:
        r212 = r148;
        goto L163
    L166:
        if (TextUtils.isEmpty(r174) == true) goto L163;
        if (r310.getHost().endsWith(r174) == true) goto L163;
        List<String> r175 = r311.get(r221);     // Catch: Throwable -> L192
        if (r175 == null) goto L174;
        r148 = r212 == true ? 1 : 0;
        LinkedList r176 = new LinkedList();     // Catch: Throwable -> L340
        Iterator<String> r177 = r175.iterator();     // Catch: Throwable -> L340
    L179:
        if (r177.hasNext() == false) goto L190;
        String r178 = r177.next();     // Catch: Throwable -> L340
        if (ix5.b.a(r178) == true) goto L179;
        if (f(r310, r178) == false) goto L179;
        String r179 = this.f244735b.matcher(r178).replaceFirst(r174);     // Catch: IllegalArgumentException -> L341 Throwable -> L340
        if (TextUtils.isEmpty(r179) == true) goto L179;
        r176.add(r179);     // Catch: IllegalArgumentException -> L341 Throwable -> L340
        goto L179
    L190:
        r172.put(r221, r176);     // Catch: Throwable -> L340
        b.a.f244757a.c(URI.create(r310.getScheme() + r171 + r174), (List) r172.get(r221));     // Catch: Throwable -> L340
        goto L193
    L174:
        r148 = r212 == true ? 1 : 0;
        i(r138, "cookieList is null", r148);     // Catch: Throwable -> L340
        return;
    L194:
        ?? r180 = r212 == true ? 1 : 0;
    L203:
        i(r138, "last return", r180);
        return;
    L195:
        ?? r181 = r212 == true ? 1 : 0;
        i(r138, "isInShareCookieList is false", r181);     // Catch: Throwable -> L198
        return;
    L198:
        th = th;
    L202:
        th.printStackTrace();
        r180 = r181;
    L200:
        th = th;
        r181 = r212;
    L205:
        i(r138, "uri responseHeaders or mCookieMgr is null", r139);
        return;
    L47:
        if (r311.containsKey("webview-origin-url") == false) goto L49;
        r141 = true;
    L43:
        th = move-exception;
        th.printStackTrace();
        goto L45
    L35:
        if ("http".equalsIgnoreCase(r310.getScheme()) == false) goto L380;
        if (ix5.a.f496359a == false) goto L380;
        if (r137 == null) goto L40;
        r137.clear();     // Catch: JSONException -> L333
    L40:
        r138.put("disable_share_insecure_cookie", 1);     // Catch: JSONException -> L333
        goto L380
    L370:
        r140 = r137.toString();     // Catch: JSONException -> L333
        goto L26
    L18:
        if (r311.containsKey("Set-Cookie") == false) goto L20;
    L21:
        r139 = true;
        goto L23
    L20:
        if (r311.containsKey("X-SS-Set-Cookie") == false) goto L22;
    L14:
        r137 = null;
        goto L15
    }

    public static Map<String, List<String>> d(boolean r100, Map<String, List<String>> r101, ReqCookieSource r102) {
        if (r100 == true) goto L4;
        return r101;
    L4:
        if (r101 != null) goto L6;
    L10:
        return r101;
    L6:
        if (r101.isEmpty() == true) goto L10;
        LinkedHashMap r103 = new LinkedHashMap(r101);
        r103.put("x-tt-get-cookie-source", Collections.singletonList(String.valueOf(r102.ordinal())));
        return r103;
    }

    public static void g(JSONObject r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        r100.put(r101, r102);     // Catch: JSONException -> L10
        return;
    L16:
        return;
    }

    public final void h(String r100, String r101, Set<String> r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (this.f244734a == null) goto L17;
        ((HashSet) r102).add(r100);
        this.f244734a.setCookie(r100, r101);
        NetworkParams.getCookieUpdateListener();     // Catch: Throwable -> L12
        return;
    L18:
        return;
    }

    public final void i(JSONObject r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f244736c == null) goto L13;
        if (r102 == false) goto L14;
        r100.put("return", r101);     // Catch: JSONException -> L10
    L8:
        this.f244736c.onEvent("put", r100);
        return;
    L14:
        return;
    }

    public final void j(Map<URI, List<String>> r110, boolean r111, boolean r112) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r110.isEmpty() == true) goto L90;
        WebViewCookieMgrUsage r100 = this.f244739f;
        if (r100 != WebViewCookieMgrUsage.DISABLED) goto L9;
        boolean r101 = true;
    L11:
        if (this.f244737d == false) goto L41;
        if (r111 == false) goto L14;
    L18:
        boolean r113 = false;
    L19:
        r101 = r101 | r113;
        if (this.f244734a != null) goto L23;
        if (r101 == true) goto L23;
        a();
    L23:
        if (r113 == false) goto L41;
        ConcurrentHashMap<URI, List<String>> r114 = this.f244742i;
        monitor-enter(r114);
        Iterator<Map.Entry<URI, List<String>>> r102 = r110.entrySet().iterator();     // Catch: Throwable -> L38
    L28:
        if (r102.hasNext() == false) goto L36;
        Map.Entry<URI, List<String>> r103 = r102.next();     // Catch: Throwable -> L38
        if (Logger.debug() == false) goto L32;
        Logger.v("SSCookieHandler", "cache coldStart cookie for: " + r103.getKey());     // Catch: Throwable -> L38
    L32:
        List<String> r104 = this.f244742i.get(r103.getKey());     // Catch: Throwable -> L38
        if (r104 != null) goto L35;
        r104 = new ArrayList();     // Catch: Throwable -> L38
        this.f244742i.put(r103.getKey(), r104);     // Catch: Throwable -> L38
    L35:
        r104.addAll(r103.getValue());     // Catch: Throwable -> L38
        goto L28
    L36:
        monitor-exit(r114);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L14:
        if (r100 != WebViewCookieMgrUsage.COLD_START_DELAY_INIT) goto L18;
        if (this.f244741h.get() == true) goto L18;
        r113 = true;
    L41:
        HashSet r115 = new HashSet();
        NetworkParams.getCookieUpdateListener();
        Iterator<Map.Entry<URI, List<String>>> r116 = r110.entrySet().iterator();
    L43:
        if (r116.hasNext() == false) goto L91;
        Map.Entry<URI, List<String>> r105 = r116.next();
        String r106 = r105.getKey().toString();
        List<String> r107 = r105.getValue();
        if (TextUtils.isEmpty(r106) == true) goto L43;
        if (CollectionUtils.isEmpty(r107) == true) goto L43;
        if (r112 == true) goto L51;
        b.a.f244757a.c(r105.getKey(), r107);
    L51:
        if (r101 == true) goto L43;
        this.f244740g = System.currentTimeMillis();
        r115.add(r106);
        if (this.f244734a != null) goto L55;
    L58:
        boolean r108 = false;
    L59:
        Iterator<String> r109 = r107.iterator();
    L61:
        if (r109.hasNext() == false) goto L43;
        String r117 = r109.next();
        if (this.f244734a == null) goto L61;
        if (r108 == true) goto L61;
        this.f244734a.setCookie(r106, r117);
        goto L61
    L55:
        if (ix5.b.f496363b == false) goto L58;
        Method r118 = this.f244734a.getClass().getDeclaredMethod("setCookieList", new Class[]{String.class, List.class});     // Catch: Throwable -> L67
        r118.setAccessible(true);     // Catch: Throwable -> L67
        r108 = ((Boolean) r118.invoke(this.f244734a, new Object[]{r106, r107})).booleanValue();     // Catch: Throwable -> L67
    L91:
        return;
    L9:
        r101 = false;
        goto L11
    }

    public SSCookieHandler(final Context r100, android.webkit.CookieManager r101, CookieInitType r102, a r103) {
        this.f244735b = PatternProtector.compile("(?<=Domain=)([^;]*)", 2);
        this.f244740g = -1;
        boolean r104 = false;
        this.f244741h = new AtomicBoolean(false);
        this.f244742i = new ConcurrentHashMap();
        this.f244744k = -1;
        this.f244743j = System.currentTimeMillis();
        boolean r105 = i.d(r100);
        this.f244738e = r105;
        if (r102 == CookieInitType.INIT_V1) goto L5;
        boolean r106 = true;
    L6:
        this.f244737d = r106;
        CookieInitType r107 = CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;
        if (r102 != r107) goto L9;
        this.f244734a = null;
    L10:
        this.f244736c = r103;
        if (r102 != r107) goto L16;
        this.f244739f = WebViewCookieMgrUsage.DISABLED;
        if (Logger.debug() == false) goto L52;
        Logger.d("SSCookieHandler", "CookieInitV2 disableCookieMgr");
    L52:
        b r108 = b.a.f244757a;
        TTExecutors.getScheduledThreadPool().schedule(new d(this, r100), ix5.b.f496373l, TimeUnit.SECONDS);
        if (this.f244739f != WebViewCookieMgrUsage.INIT_AT_START) goto L56;
        a();
    L56:
        if (ix5.b.f496367f == false) goto L72;
        JSONObject r109 = new JSONObject();
        r109.put("init", "success");     // Catch: JSONException -> L61
    L59:
        this.f244736c.onEvent("init", r109);
        return;
    L72:
        return;
    L16:
        if (r102 != CookieInitType.INIT_V2_PREFER_DELAY_COOKIE_MGR) goto L51;
        if (r105 == false) goto L46;
        if (this.f244734a != null) goto L46;
        h r110 = b.a.f244757a.f244756a;
        if (r110 != null) goto L24;
    L40:
        boolean r111 = false;
    L41:
        if (r111 == false) goto L46;
        if (WebviewCookieRawSyncUtil.d() == false) goto L46;
        r104 = true;
        goto L46
    L24:
        if (r110.f244720e == false) goto L40;
        ((ReentrantReadWriteLock) r110.f244719d).readLock().lock();
        Iterator r112 = ((LinkedHashMap) r110.f244718c).entrySet().iterator();     // Catch: Throwable -> L37
    L28:
        if (r112.hasNext() == false) goto L34;
        Map.Entry r113 = (Map.Entry) r112.next();     // Catch: Throwable -> L37
        if (r113 == null) goto L28;
        if (CollectionUtils.isEmpty((Collection) r113.getValue()) == true) goto L28;
        ((ReentrantReadWriteLock) r110.f244719d).readLock().unlock();
        boolean r114 = true;
    L35:
        if (r114 == false) goto L40;
        r111 = true;
        goto L41
    L34:
        ((ReentrantReadWriteLock) r110.f244719d).readLock().unlock();
        r114 = false;
    L37:
        th = move-exception;
        ((ReentrantReadWriteLock) r110.f244719d).readLock().unlock();
        throw th;
    L46:
        if (Logger.debug() == false) goto L48;
        Logger.d("SSCookieHandler", "CookieInitV2 isMain:" + this.f244738e + ", cookieMgr:" + this.f244734a + ", delayInitCookieMgr:" + r104);
    L48:
        if (r104 == true) goto L50;
        this.f244739f = WebViewCookieMgrUsage.INIT_AT_START;
        goto L52
    L50:
        this.f244739f = WebViewCookieMgrUsage.COLD_START_DELAY_INIT;
        goto L52
    L51:
        this.f244739f = WebViewCookieMgrUsage.INIT_AT_START;
        goto L52
    L9:
        this.f244734a = r101;
        goto L10
    L5:
        r106 = false;
        goto L6
    }
}

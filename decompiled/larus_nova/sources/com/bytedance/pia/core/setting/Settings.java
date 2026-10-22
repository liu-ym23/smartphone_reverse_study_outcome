package com.bytedance.pia.core.setting;

import android.net.Uri;
import com.amap.api.col.s.ce;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.facebook.keyframes.model.KFImage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001;R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001a\u0010!\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0014R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0014R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010)\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001a\u0010/\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R \u00101\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b1\u0010\u0014\u0012\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006R\u001a\u00107\u001a\u0002068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/bytedance/pia/core/setting/Settings;", "", "", "isPiaEnabled", "Z", "r", "()Z", "isBootEnabled", ce.f26396k, "isCacheEnabled", "l", "isWorkerEnabled", "y", "isVanillaFetchEnabled", "w", "isWarmupEnabled", "x", "", "", "allowedDomains", "Ljava/util/List;", "", "htmlInterceptTimeout", "I", "h", "()I", "", "enabledFeatures", "Ljava/util/Set;", ce.f26391f, "()Ljava/util/Set;", "pageStorageCapacity", RXScreenCaptureService.KEY_INDEX, "streamingInterceptTimeout", ce.f26395j, "blockedPages", "urlRules", "isPiaQueryDisable", "s", "isMustFinishWarmup", "o", "isUrlCompatV2Enabled", BaseSwitches.V, "isNsrV1Enabled", "p", "isPrefetchV1Enabled", "t", "isSnapshotV1Enabled", "u", "blockedV1Page", "getBlockedV1Page$annotations", "()V", "isCreateRuntimeWaitEnable", "m", "", "createRuntimeWaitInternal", "J", "f", "()J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class Settings {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Settings> f266286f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<Settings> f266287g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile boolean f266288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile Settings f266289i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266290a;

    @SerializedName("allow_domains")
    private final List<String> allowedDomains;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266291b;

    @SerializedName("blocked_pages")
    private final List<String> blockedPages;

    @SerializedName("blocked_pages_v1")
    private final List<String> blockedV1Page;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266292c;

    @SerializedName("create_runtime_wait_internal")
    private final long createRuntimeWaitInternal;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GsonUtils.Exclude
    public final Lazy f266294e;

    @SerializedName(KFImage.FEATURES_JSON_FIELD)
    private final Set<String> enabledFeatures;

    @SerializedName("html_intercept_timeout")
    private final int htmlInterceptTimeout;

    @SerializedName(ErrorType.BOOT)
    private final boolean isBootEnabled;

    @SerializedName("cache")
    private final boolean isCacheEnabled;

    @SerializedName("create_runtime_wait")
    private final boolean isCreateRuntimeWaitEnable;

    @SerializedName("experiment_must_finish_warmup")
    private final boolean isMustFinishWarmup;

    @SerializedName("nsr_v1")
    private final boolean isNsrV1Enabled;

    @SerializedName(PullConfiguration.PROCESS_NAME_MAIN)
    private final boolean isPiaEnabled;

    @SerializedName("experiment_disable_pia_query")
    private final boolean isPiaQueryDisable;

    @SerializedName("prefetch_v1")
    private final boolean isPrefetchV1Enabled;

    @SerializedName("snapshot_v1")
    private final boolean isSnapshotV1Enabled;

    @SerializedName("enable_add_cache_key")
    private final boolean isUrlCompatV2Enabled;

    @SerializedName("vanilla_fetch")
    private final boolean isVanillaFetchEnabled;

    @SerializedName("warmup")
    private final boolean isWarmupEnabled;

    @SerializedName(ErrorType.WORKER)
    private final boolean isWorkerEnabled;

    @SerializedName("page_storage_capacity")
    private final int pageStorageCapacity;

    @SerializedName("streaming_intercept_timeout")
    private final int streamingInterceptTimeout;

    @SerializedName("url_rules")
    private final List<String> urlRules;

    public static final class a {
        public static Settings a() {
            Lazy<Settings> r100 = Settings.f266286f;
            if (Settings.f266288h == false) goto L18;
            Settings r101 = Settings.f266289i;
            if (r101 != null) goto L8;
        L10:
            c47.a r102 = c47.c.a.f22407c;
            if (r102 == null) goto L13;
            Settings r103 = (Settings) r102.a("pia_global_config", Settings.class, Settings.f266286f.getValue());
        L14:
            if (r103 != null) goto L16;
            r103 = Settings.f266286f.getValue();
        L16:
            Settings.f266289i = r103;
            return r103;
        L13:
            r103 = null;
            goto L14
        L8:
            if (Intrinsics.areEqual(r101, Settings.f266286f.getValue()) == true) goto L10;
            return r101;
        L18:
            return Settings.f266287g.getValue();
        }

        public static b d() {
            c47.a r100 = c47.c.a.f22407c;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getPIAConfig();
        }

        @JvmStatic
        public static boolean b() {
            b r100 = d();
            if (r100 == null) goto L7;
            Integer r101 = r100.h();
            if (r101 == null) goto L7;
            int r102 = r101.intValue();
        L8:
            Map<String, Pair<Integer, Boolean>> r103 = i.f266399a;
            boolean r104 = false;
            if (r102 > 10000) goto L29;
            if (r102 < 0) goto L29;
            Map<String, Pair<Integer, Boolean>> r105 = i.f266399a;
            Pair r106 = (Pair) ((LinkedHashMap) r105).get("openManifestCacheInt");
            if (r106 != null) goto L15;
        L17:
            g.f266303a.getClass();
            PiaAppInfo r107 = g.f266305c;
            if (r107 != null) goto L20;
            r107 = null;
        L20:
            if (r107 == null) goto L29;
            String r108 = r107.f266139d;
            if (r108 == null) goto L29;
            if ((((r108.concat("openManifestCacheInt").hashCode() % 10000) + 10000) % 10000) >= r102) goto L27;
            r104 = true;
        L27:
            Intrinsics.checkNotNull("openManifestCacheInt");
            r105.put("openManifestCacheInt", new Pair(Integer.valueOf(r102), Boolean.valueOf(r104)));
            goto L29
        L15:
            if (((Number) r106.getFirst()).intValue() != r102) goto L17;
            return ((Boolean) r106.getSecond()).booleanValue();
        L29:
            return r104;
        L7:
            r102 = 5000;
            goto L8
        }

        public a() {
        }

        @JvmStatic
        public static boolean c(String r100, Uri r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "uri");
            b r102 = d();
            if (r102 == null) goto L6;
            List<String> r103 = r102.k();
            if (r103 == null) goto L6;
        L8:
            if (r103 == null) goto L10;
            boolean r104 = r103.contains(r100);
        L11:
            if (r104 == false) goto L13;
        L14:
            return true;
        L13:
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, "_pia_fast_"), "1") == true) goto L14;
            return false;
        L10:
            r104 = false;
        L6:
            r103 = CollectionsKt.listOf(new String[]{"lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/webcast/webview/caijing_h5_coupon/template/pages/list/index.html", "lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/wallet/h5/webcast/caijing_h5_point/template/home/index.html"});
            goto L8
        }
    }

    public Settings() {
        this(null, false, false, false, false, 4194303);
    }

    static {
        new a();
        f266286f = LazyKt.lazy(Settings$Companion$DEFAULT_SETTINGS$2.INSTANCE);
        f266287g = LazyKt.lazy(Settings$Companion$DISABLED_SETTINGS$2.INSTANCE);
        f266288h = true;
    }

    public final String toString() {
        return "PiaSettings(enabled=" + f266288h + "): " + GsonProtectorUtils.toJson(GsonUtils.b(), this);
    }

    @JvmStatic
    public static final Settings e() {
        return a.a();
    }

    public final long f() {
        return this.createRuntimeWaitInternal;
    }

    public final Set<String> g() {
        return this.enabledFeatures;
    }

    public final int h() {
        return this.htmlInterceptTimeout;
    }

    public final int i() {
        return this.pageStorageCapacity;
    }

    public final int j() {
        return this.streamingInterceptTimeout;
    }

    public final boolean k() {
        return this.isBootEnabled;
    }

    public final boolean l() {
        return this.isCacheEnabled;
    }

    public final boolean m() {
        return this.isCreateRuntimeWaitEnable;
    }

    public final boolean o() {
        return this.isMustFinishWarmup;
    }

    public final boolean p() {
        return this.isNsrV1Enabled;
    }

    public final boolean r() {
        return this.isPiaEnabled;
    }

    public final boolean s() {
        return this.isPiaQueryDisable;
    }

    public final boolean t() {
        return this.isPrefetchV1Enabled;
    }

    public final boolean u() {
        return this.isSnapshotV1Enabled;
    }

    public final boolean v() {
        return this.isUrlCompatV2Enabled;
    }

    public final boolean w() {
        return this.isVanillaFetchEnabled;
    }

    public final boolean x() {
        return this.isWarmupEnabled;
    }

    public final boolean y() {
        return this.isWorkerEnabled;
    }

    public static final /* synthetic */ List a(Settings r100) {
        return r100.allowedDomains;
    }

    public static final /* synthetic */ List b(Settings r100) {
        return r100.blockedPages;
    }

    public static final /* synthetic */ List c(Settings r100) {
        return r100.blockedV1Page;
    }

    public static final /* synthetic */ List d(Settings r100) {
        return r100.urlRules;
    }

    public final boolean n(Uri r100) {
        if (f266288h == true) goto L6;
        return true;
    L6:
        if (this.isPiaEnabled == true) goto L9;
        return false;
    L9:
        if (((Collection) this.f266292c.getValue()).isEmpty() == false) goto L12;
        return false;
    L12:
        if (((Collection) this.f266292c.getValue()).contains("*") == false) goto L14;
        return true;
    L14:
        if (r100 != null) goto L17;
        return false;
    L17:
        if (j.f(r100) == true) goto L19;
        return false;
    L19:
        Collection r101 = (Collection) this.f266292c.getValue();
        if ((r101 instanceof Collection) == true) goto L22;
    L24:
        Iterator r102 = r101.iterator();
    L26:
        if (r102.hasNext() == false) goto L30;
        if (StringsKt.endsWith$default("." + r100.getHost(), (String) r102.next(), false, 2, null) == false) goto L26;
        return true;
    L30:
        return false;
    L22:
        if (r101.isEmpty() == false) goto L24;
        goto L24
    }

    public final boolean q(Uri r100) {
        if (f266288h == true) goto L6;
        return false;
    L6:
        if (r100 != null) goto L9;
        return true;
    L9:
        if (this.isPiaEnabled == true) goto L12;
        return true;
    L12:
        if (j.f(r100) == true) goto L14;
        return true;
    L14:
        String r101 = r100.getHost();
        if (r101 != null) goto L17;
        return true;
    L17:
        String r102 = r100.getPath();
        if (r102 != null) goto L20;
        return true;
    L20:
        String r103 = r101.concat(r102);
        Intrinsics.checkNotNullParameter(r103, "link");
        b r104 = a.d();
        if (r104 == null) goto L35;
        List<String> r105 = r104.b();
        if (r105 == null) goto L35;
        List<String> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r107 = r106.iterator();
    L31:
        if (r107.hasNext() == false) goto L35;
        if (StringsKt.contains$default(r103, (String) r107.next(), false, 2, null) == false) goto L31;
        boolean r108 = true;
    L36:
        if (r108 == false) goto L39;
        return true;
    L39:
        if (((List) this.f266293d.getValue()).isEmpty() == false) goto L41;
        return false;
    L41:
        List r109 = (List) this.f266293d.getValue();
        if ((r109 instanceof Collection) == true) goto L44;
    L46:
        Iterator r110 = r109.iterator();
    L48:
        if (r110.hasNext() == false) goto L60;
        if (StringsKt.contains$default(r103, (String) r110.next(), false, 2, null) == false) goto L48;
        return true;
    L60:
        return false;
    L44:
        if (r109.isEmpty() == false) goto L46;
        return false;
    L27:
        if (r106.isEmpty() == false) goto L29;
    L35:
        r108 = false;
        goto L36
    }

    public Settings(List r210, boolean r211, boolean r310, boolean r311, boolean r312, int r313) {
        boolean r100 = true;
        if ((r313 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r313 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r313 & 4) == 0) goto L13;
        boolean r103 = true;
    L15:
        if ((r313 & 8) == 0) goto L17;
        boolean r104 = true;
    L19:
        if ((r313 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r313 & 32) != 0) goto L27;
        r100 = false;
    L27:
        if ((r313 & 64) == 0) goto L29;
        List r106 = CollectionsKt.emptyList();
    L31:
        if ((r313 & 128) == 0) goto L33;
        int r110 = 20;
    L35:
        if ((r313 & 256) == 0) goto L37;
        Set<String> r111 = SetsKt.setOf(new String[]{ErrorType.PREFETCH, "nsr", "snapshot", "cache", SpeechEngineDefines.CAPT_RESPONSE_MODE_STREAMING, "preload"});
    L39:
        if ((r313 & 512) == 0) goto L41;
        int r112 = 500;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        int r113 = 5;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        List<String> r114 = CollectionsKt.emptyList();
    L51:
        if ((r313 & 4096) == 0) goto L53;
        List<String> r115 = CollectionsKt.emptyList();
    L55:
        if ((r313 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r313 & 65536) == 0) goto L61;
        boolean r116 = false;
    L63:
        if ((r313 & 131072) == 0) goto L65;
        boolean r212 = false;
    L67:
        if ((r313 & 262144) == 0) goto L69;
        boolean r213 = false;
    L71:
        if ((r313 & 524288) == 0) goto L73;
        List<String> r108 = CollectionsKt.emptyList();
    L75:
        if ((r313 & 2097152) == 0) goto L77;
        long r214 = 1500;
    L78:
        Intrinsics.checkNotNullParameter(r106, "allowedDomains");
        Intrinsics.checkNotNullParameter(r111, "enabledFeatures");
        Intrinsics.checkNotNullParameter(r114, "blockedPages");
        Intrinsics.checkNotNullParameter(r115, "urlRules");
        Intrinsics.checkNotNullParameter(r108, "blockedV1Page");
        this.isPiaEnabled = r101;
        this.isBootEnabled = r102;
        this.isCacheEnabled = r103;
        this.isWorkerEnabled = r104;
        this.isVanillaFetchEnabled = r105;
        this.isWarmupEnabled = r100;
        this.allowedDomains = r106;
        this.htmlInterceptTimeout = r110;
        this.enabledFeatures = r111;
        this.pageStorageCapacity = r112;
        this.streamingInterceptTimeout = r113;
        this.blockedPages = r114;
        this.urlRules = r115;
        this.isPiaQueryDisable = r107;
        this.isMustFinishWarmup = false;
        this.isUrlCompatV2Enabled = false;
        this.isNsrV1Enabled = r116;
        this.isPrefetchV1Enabled = r212;
        this.isSnapshotV1Enabled = r213;
        this.blockedV1Page = r108;
        this.isCreateRuntimeWaitEnable = false;
        this.createRuntimeWaitInternal = r214;
        this.f266290a = LazyKt.lazy(new Settings$base$2(this));
        this.f266291b = LazyKt.lazy(new Settings$features$2(this));
        this.f266292c = LazyKt.lazy(new Settings$safeAllowedDomain$2(this));
        this.f266293d = LazyKt.lazy(new Settings$safeBlockedPages$2(this));
        this.f266294e = LazyKt.lazy(new Settings$urlMatcher$2(this));
        return;
    L77:
        r214 = 0;
        goto L78
    L73:
        r108 = null;
        goto L75
    L69:
        r213 = r312;
        goto L71
    L65:
        r212 = r311;
        goto L67
    L61:
        r116 = r310;
        goto L63
    L57:
        r107 = r211;
        goto L59
    L53:
        r115 = null;
        goto L55
    L49:
        r114 = null;
        goto L51
    L45:
        r113 = 0;
        goto L47
    L41:
        r112 = 0;
        goto L43
    L37:
        r111 = null;
        goto L39
    L33:
        r110 = 0;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L21:
        r105 = false;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = false;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L7
    }
}

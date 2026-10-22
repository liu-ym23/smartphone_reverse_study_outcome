package ra;

import android.graphics.Point;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.forest.Forest;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.lynx.init.e;
import com.bytedance.ies.bullet.lynx.init.h;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestExternalJSProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestLynxGenericResourceProvider;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import com.lynx.jsbridge.f;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.t;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import d8a.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final a B = null;
    public String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f536774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadStrategyForRendering f536775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxGroup f536776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f536777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f536778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f536779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f536780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f536781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f536782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<LynxViewBuilder, Unit> f536783j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f536784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f536785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f536786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<com.lynx.tasm.behavior.a> f536787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<f> f536788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, k<?, ?>> f536789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final w7a.a.b f536790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f536791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f536792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f536793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f536794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f536795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f536796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f536797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public HashMap<String, String> f536798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Uri f536799z;

    public static final class a {
        public a() {
        }

        public final b c(Uri r310) {
            Intrinsics.checkNotNullParameter(r310, "uri");
            if (r310.isHierarchical() == false) goto L5;
            HashMap<String, String> r100 = new HashMap();
            if (r310.getBooleanQueryParameter("enable_lynx_config", false) == false) goto L14;
            Iterator<String> r101 = UriProtector.getQueryParameterNames(r310).iterator();
        L10:
            if (r101.hasNext() == false) goto L14;
            String r102 = r101.next();
            String r103 = UriProtector.getQueryParameter(r310, r102);
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r103) == false) goto L10;
            r100.put(r102, r103);
        L14:
            String r104 = UriProtector.getQueryParameter(r310, "group");
            if (r104 != null) goto L17;
            r104 = "";
        L17:
            boolean r105 = r310.getBooleanQueryParameter("use_storage_group", false);
            boolean r106 = r310.getBooleanQueryParameter(LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS, false);
            boolean r110 = r310.getBooleanQueryParameter("enable_canvas_optimize", false);
            boolean r111 = r310.getBooleanQueryParameter("enable_dynamic_v8", false);
            boolean r107 = r310.getBooleanQueryParameter("share_group", true);
            if (r106 == true) goto L20;
        L22:
            HybridLogger r108 = HybridLogger.f246343a;
            Float r112 = null;
            HybridLogger.m("LynxViewBuilderParams", "shareGroup=" + r107 + ", useStorageGroup=" + r105, null, null, 12);
            if (r105 == false) goto L26;
            LynxGroup r109 = a(r104, r107, r106, new String[]{"assets://bdlynx_core.js"}, r111, r110, true);
        L25:
            LynxGroup r113 = r109;
            boolean r311 = r310.getBooleanQueryParameter("enable_code_cache", false);
            String r114 = UriProtector.getQueryParameter(r310, "lynx_preset_height");
            String r115 = UriProtector.getQueryParameter(r310, "lynx_preset_width");
            String r116 = UriProtector.getQueryParameter(r310, "lynx_preset_height_spec");
            String r117 = UriProtector.getQueryParameter(r310, "lynx_preset_width_spec");
            if (r115 != null) goto L35;
            if (r114 != null) goto L35;
            int r118 = 0;
            int r119 = 0;
        L41:
            if (r117 == null) goto L44;
            if (r116 == null) goto L44;
            int r210 = CastIntegerProtector.parseInt(r117);
            int r120 = CastIntegerProtector.parseInt(r116);
        L45:
            String r121 = UriProtector.getQueryParameter(r310, "thread_strategy");
            if (r121 == null) goto L48;
            Integer r122 = Integer.valueOf(CastIntegerProtector.parseInt(r121));
        L49:
            ThreadStrategyForRendering r123 = ThreadStrategyForRendering.ALL_ON_UI;
            int r124 = r123.id();
            if (r122 != null) goto L53;
        L55:
            ThreadStrategyForRendering r125 = ThreadStrategyForRendering.MOST_ON_TASM;
            int r126 = r125.id();
            if (r122 != null) goto L59;
        L61:
            r125 = ThreadStrategyForRendering.PART_ON_LAYOUT;
            int r127 = r125.id();
            if (r122 != null) goto L65;
        L67:
            r125 = ThreadStrategyForRendering.MULTI_THREADS;
            int r128 = r125.id();
            if (r122 != null) goto L71;
        L73:
            ThreadStrategyForRendering r129 = r123;
        L74:
            boolean r130 = r310.getBooleanQueryParameter("enable_font_scale", false);
            String r131 = UriProtector.getQueryParameter(r310, "font_scale");
            if (r130 == false) goto L78;
            if (r131 != null) goto L78;
            Float r132 = h.f247355d;
        L82:
            if (r132 == null) goto L84;
            float r211 = r132.floatValue();
        L85:
            boolean r133 = r310.getBooleanQueryParameter("enable_view_zoom", false);
            String r134 = UriProtector.getQueryParameter(r310, "view_zoom");
            if (r133 == false) goto L89;
            if (r134 != null) goto L89;
            r112 = h.f247356e;
        L91:
            if (r112 == null) goto L93;
            float r312 = r112.floatValue();
        L94:
            boolean r212 = r310.getBooleanQueryParameter("create_view_async", false);
            Function1 r213 = null;
            int r214 = 0;
            int r215 = 0;
            List r216 = null;
            boolean r313 = false;
            String r135 = r104;
            b r136 = new b(r310.getBooleanQueryParameter("preset_safe_point", false), r129, r113, r135, r120, r210, r211, r212, r310.getBooleanQueryParameter("enable_sync_flush", false), r213, !r310.getBooleanQueryParameter("disable_auto_expose", false), r214, r215, r216, r310.getBooleanQueryParameter("enable_pending_js_task", false), r313, r310.getBooleanQueryParameter("air_strict_mode", false), r311, null, r310.getBooleanQueryParameter("enable_vsync_aligned_message_loop", false), r312, 2488832);
            r136.f536798y = r100;
            r136.f536799z = r310;
            return r136;
        L93:
            r312 = 1.0f;
        L89:
            if (r134 == null) goto L91;
            r112 = Float.valueOf(CastFloatProtector.parseFloat(r134));
            goto L91
        L84:
            r211 = 1.0f;
        L78:
            if (r131 == null) goto L80;
            r132 = Float.valueOf(CastFloatProtector.parseFloat(r131));
            goto L82
        L80:
            r132 = null;
            goto L82
        L71:
            if (r122.intValue() != r128) goto L73;
        L72:
            r129 = r125;
            goto L74
        L65:
            if (r122.intValue() != r127) goto L67;
        L59:
            if (r122.intValue() != r126) goto L61;
        L53:
            if (r122.intValue() != r124) goto L55;
        L48:
            r122 = null;
        L44:
            r120 = r118;
            r210 = r119;
        L35:
            if (r115 == null) goto L37;
            r119 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r115), 1073741824);
        L38:
            if (r114 == null) goto L40;
            r118 = View.MeasureSpec.makeMeasureSpec(CastIntegerProtector.parseInt(r114), 1073741824);
            goto L41
        L40:
            r118 = View.MeasureSpec.makeMeasureSpec(0, 0);
            goto L41
        L37:
            r119 = View.MeasureSpec.makeMeasureSpec(0, 0);
            goto L38
        L26:
            if (r110 == false) goto L28;
            r109 = b(this, r104, r107, r106, new String[]{"assets://bdlynx_core.js"}, r111, r110);
            goto L25
        L28:
            Intrinsics.checkNotNullParameter(r104, "groupName");
            r109 = e.b(r104, r107, r106, new String[]{"assets://bdlynx_core.js"}, r111, false);
            goto L25
        L20:
            if (Intrinsics.areEqual(r104, "-1") == true) goto L22;
            r104 = r104.concat("_canvas");
            goto L22
        L5:
            return new b(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
        }

        public static LynxGroup a(String r100, boolean r101, boolean r102, String[] r110, boolean r111, boolean r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r100, "groupName");
            if (r113 == false) goto L6;
            Object r103 = e.f247345a;
            return e.c(r100, r110, r102, r111, r112, true);
        L6:
            Map<String, Map<Class<?>, Object>> r114 = x26.a.f562251a;
            g r115 = (g) x26.a.a(g.class);
            if (r115 == null) goto L13;
            w26.e r116 = (w26.e) r115.n0(w26.e.class);
            if (r116 == null) goto L13;
            Boolean r117 = r116.J();
            if (r117 == null) goto L13;
            boolean r118 = r117.booleanValue();
        L14:
            if (r118 == false) goto L18;
            Object r119 = e.f247345a;
            return e.b(r100, r101, r102, r110, r111, r112);
        L18:
            if (Intrinsics.areEqual(r100, "-1") == true) goto L20;
            if (r101 == false) goto L24;
            return e.d(r100, r110, r102, r111, r112);
        L24:
            return LynxGroup.Create(r100, r110, false, r102, r111, r112);
        L20:
            return LynxGroup.Create(r100, r100, r110, false, r102, r111, r112);
        L13:
            r118 = false;
            goto L14
        }

        public static /* synthetic */ LynxGroup b(a r100, String r101, boolean r102, boolean r110, String[] r111, boolean r112, boolean r113) {
            r100.getClass();
            return a(r101, r102, r110, r111, r112, r113, false);
        }
    }

    static {
        B = new a();
    }

    public b() {
        this(false, null, null, null, 0, 0, 0.0f, false, false, null, false, 0, 0, null, false, false, false, false, null, false, 0.0f, 16777215);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f536774a == r101.f536774a) goto L12;
        return false;
    L12:
        if (this.f536775b == r101.f536775b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f536776c, r101.f536776c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f536777d, r101.f536777d) == true) goto L21;
        return false;
    L21:
        if (this.f536778e == r101.f536778e) goto L24;
        return false;
    L24:
        if (this.f536779f == r101.f536779f) goto L27;
        return false;
    L27:
        if (Float.compare(this.f536780g, r101.f536780g) == 0) goto L30;
        return false;
    L30:
        if (this.f536781h == r101.f536781h) goto L33;
        return false;
    L33:
        if (this.f536782i == r101.f536782i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f536783j, r101.f536783j) == true) goto L39;
        return false;
    L39:
        if (this.f536784k == r101.f536784k) goto L42;
        return false;
    L42:
        if (this.f536785l == r101.f536785l) goto L45;
        return false;
    L45:
        if (this.f536786m == r101.f536786m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f536787n, r101.f536787n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f536788o, r101.f536788o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f536789p, r101.f536789p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f536790q, r101.f536790q) == true) goto L60;
        return false;
    L60:
        if (this.f536791r == r101.f536791r) goto L63;
        return false;
    L63:
        if (this.f536792s == r101.f536792s) goto L66;
        return false;
    L66:
        if (this.f536793t == r101.f536793t) goto L69;
        return false;
    L69:
        if (this.f536794u == r101.f536794u) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f536795v, r101.f536795v) == true) goto L75;
        return false;
    L75:
        if (this.f536796w == r101.f536796w) goto L78;
        return false;
    L78:
        if (Float.compare(this.f536797x, r101.f536797x) == 0) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f536774a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f536775b.hashCode()) * 31;
        LynxGroup r103 = this.f536776c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f536777d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((((r106 + r108) * 31) + this.f536778e) * 31) + this.f536779f) * 31) + Float.floatToIntBits(this.f536780g)) * 31;
        if (this.f536781h == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        if (this.f536782i == false) goto L21;
        int r112 = 1231;
    L22:
        int r113 = (r111 + r112) * 31;
        Function1<LynxViewBuilder, Unit> r114 = this.f536783j;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        if (this.f536784k == false) goto L29;
        int r117 = 1231;
    L30:
        int r118 = (((((((((((r116 + r117) * 31) + this.f536785l) * 31) + this.f536786m) * 31) + this.f536787n.hashCode()) * 31) + this.f536788o.hashCode()) * 31) + this.f536789p.hashCode()) * 31;
        w7a.a.b r119 = this.f536790q;
        if (r119 != null) goto L33;
        int r120 = 0;
    L34:
        int r121 = (r118 + r120) * 31;
        if (this.f536791r == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.f536792s == false) goto L41;
        int r124 = 1231;
    L42:
        int r125 = (r123 + r124) * 31;
        if (this.f536793t == false) goto L45;
        int r126 = 1231;
    L46:
        int r127 = (r125 + r126) * 31;
        if (this.f536794u == false) goto L49;
        int r128 = 1231;
    L50:
        int r129 = (r127 + r128) * 31;
        String r130 = this.f536795v;
        if (r130 == null) goto L54;
        r104 = r130.hashCode();
    L54:
        int r131 = (r129 + r104) * 31;
        if (this.f536796w == true) goto L59;
        r100 = 1237;
    L59:
        return ((r131 + r100) * 31) + Float.floatToIntBits(this.f536797x);
    L49:
        r128 = 1237;
        goto L50
    L45:
        r126 = 1237;
        goto L46
    L41:
        r124 = 1237;
        goto L42
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = r119.hashCode();
        goto L34
    L29:
        r117 = 1237;
        goto L30
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = 1237;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LynxViewBuilderParams(enableLayoutSafepoint=" + this.f536774a + ", threadStrategy=" + this.f536775b + ", lynxGroup=" + this.f536776c + ", lynxGroupName=" + this.f536777d + ", presetHeightMeasureSpec=" + this.f536778e + ", presetWidthMeasureSpec=" + this.f536779f + ", fontScale=" + this.f536780g + ", enableCreateViewAsync=" + this.f536781h + ", enableSyncFlush=" + this.f536782i + ", customInit=" + this.f536783j + ", enableAutoExpose=" + this.f536784k + ", screenWidth=" + this.f536785l + ", screenHeight=" + this.f536786m + ", behaviors=" + this.f536787n + ", modules=" + this.f536788o + ", resourceProviders=" + this.f536789p + ", fontLoader=" + this.f536790q + ", enablePendingJsTask=" + this.f536791r + ", enableJSRuntime=" + this.f536792s + ", enableAirStrictMode=" + this.f536793t + ", enableUserCodeCache=" + this.f536794u + ", codeCacheSourceUrl=" + this.f536795v + ", enableVSyncAlignedMessageLoop=" + this.f536796w + ", viewZoom=" + this.f536797x + ')';
    }

    public static final Point a(b r100, b r101) {
        r100.getClass();
        Point r102 = new Point();
        int r103 = r101.f536785l;
        int r104 = r101.f536786m;
        int r105 = com.bytedance.android.anniex.utils.b.f41399a;
        com.bytedance.android.anniex.utils.b.a(r101.f536799z);
        r102.x = r103;
        r102.y = r104;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.m("LynxViewBuilderParams", "contentSize===" + r102, null, null, 12);
        return r102;
    }

    public final t c(String r110, String r111, Forest r112) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "bid");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxEngineBuilder");
        TraceEvent.beginSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        t r100 = new t();     // Catch: Throwable -> L42
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        r100.setEnableVSyncAlignedMessageLoop(this.f536796w);     // Catch: Throwable -> L45
        r100.setEnableLayoutSafepoint(this.f536774a);     // Catch: Throwable -> L45
        r100.setThreadStrategyForRendering(this.f536775b);     // Catch: Throwable -> L45
        r100.setLynxGroup(this.f536776c);     // Catch: Throwable -> L45
        Point r101 = a(this, this);     // Catch: Throwable -> L45
        Point r102 = new Point();     // Catch: Throwable -> L45
        int r103 = this.f536779f;     // Catch: Throwable -> L45
        int r104 = this.f536778e;     // Catch: Throwable -> L45
        int r105 = com.bytedance.android.anniex.utils.b.f41399a;     // Catch: Throwable -> L45
        com.bytedance.android.anniex.utils.b.a(this.f536799z);     // Catch: Throwable -> L45
        r102.x = r103;     // Catch: Throwable -> L45
        r102.y = r104;     // Catch: Throwable -> L45
        r100.setPresetMeasuredSpec(r103, r104);     // Catch: Throwable -> L45
        r100.setFontScale(this.f536780g);     // Catch: Throwable -> L45
        r100.setEnableCreateViewAsync(this.f536781h);     // Catch: Throwable -> L45
        r100.setEnableSyncFlush(this.f536782i);     // Catch: Throwable -> L45
        r100.enableAutoExpose(this.f536784k);     // Catch: Throwable -> L45
        r100.setScreenSize(r101.x, r101.y);     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        r100.addBehaviors(this.f536787n);     // Catch: Throwable -> L39
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator<T> r106 = this.f536788o.iterator();     // Catch: Throwable -> L36
    L10:
        if (r106.hasNext() == false) goto L12;
        f r107 = (f) r106.next();     // Catch: Throwable -> L36
        r100.registerModule(r107.b(), r107.a(), r107.c());     // Catch: Throwable -> L36
        goto L10
    L12:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L36
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator r109 = MapsKt.asSequence(this.f536789p).iterator();     // Catch: Throwable -> L45
    L15:
        if (r109.hasNext() == false) goto L18;
        Map.Entry r113 = (Map.Entry) r109.next();     // Catch: Throwable -> L45
        r100.setResourceProvider((String) r113.getKey(), (k) r113.getValue());     // Catch: Throwable -> L45
        goto L15
    L18:
        if (com.bytedance.ies.bullet.service.base.h.a0() == false) goto L20;
        r100.setLynxViewConfig(this.f536798y);     // Catch: Throwable -> L45
    L20:
        r100.setFontLoader(this.f536790q);     // Catch: Throwable -> L45
        r100.setEnablePendingJsTask(this.f536791r);     // Catch: Throwable -> L45
        r100.setEnableJSRuntime(this.f536792s);     // Catch: Throwable -> L45
        r100.setEnableAirStrictMode(this.f536793t);     // Catch: Throwable -> L45
        r100.setEnableUserCodeCache(this.f536794u);     // Catch: Throwable -> L45
        r100.setCodeCacheSourceUrl(this.f536795v);     // Catch: Throwable -> L45
        r100.setDynamicComponentFetcher(new ForestDynamicComponentProvider(TrafficMetrics.FRPM_TTNET, r110, r111));     // Catch: Throwable -> L45
        Uri r114 = r100.getUri();     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.Z() == false) goto L23;
        r114 = this.f536799z;     // Catch: Throwable -> L45
    L23:
        boolean r115 = false;
        if (r114 != null) goto L26;
    L28:
        if (r115 == false) goto L30;
        r100.setGenericResourceFetcher(new ForestLynxGenericResourceProvider(TrafficMetrics.FRPM_TTNET, r110, r111, r112));     // Catch: Throwable -> L45
        r100.setMediaResourceFetcher(new com.bytedance.ies.bullet.lynx.resource.forest.a(TrafficMetrics.FRPM_TTNET, r110, r111, r112));     // Catch: Throwable -> L45
        r100.setTemplateResourceFetcher(new ForestTemplateResourceProvider(TrafficMetrics.FRPM_TTNET, r110, null, r111, r112, 4));     // Catch: Throwable -> L45
        r100.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);     // Catch: Throwable -> L45
    L30:
        r100.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider(TrafficMetrics.FRPM_TTNET, r110, r111));     // Catch: Throwable -> L45
        Function1<LynxViewBuilder, Unit> r116 = this.f536783j;     // Catch: Throwable -> L45
        if (r116 == null) goto L33;
        r116.invoke(r100);     // Catch: Throwable -> L45
    L33:
        r100.setThreadStrategyForRendering(ThreadStrategyForRendering.MOST_ON_TASM);     // Catch: Throwable -> L45
        r100.setEnablePendingJsTask(true);     // Catch: Throwable -> L45
        TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
        return r100;
    L26:
        if (r114.getBooleanQueryParameter("enable_lynx_generic_fetcher", false) != true) goto L28;
        r115 = true;
        goto L28
    L36:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L39:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilderParams:toLynxEngineBuilder");
        throw th;
    }

    public final LynxViewBuilder d(String r110, String r111, Forest r112) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "bid");
        TraceEvent.beginSection("LynxViewBuilderParams:toLynxViewBuilder");
        TraceEvent.beginSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        LynxViewBuilder r100 = new LynxViewBuilder();     // Catch: Throwable -> L42
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        r100.setEnableVSyncAlignedMessageLoop(this.f536796w);     // Catch: Throwable -> L45
        r100.setEnableLayoutSafepoint(this.f536774a);     // Catch: Throwable -> L45
        r100.setThreadStrategyForRendering(this.f536775b);     // Catch: Throwable -> L45
        r100.setLynxGroup(this.f536776c);     // Catch: Throwable -> L45
        Point r101 = a(this, this);     // Catch: Throwable -> L45
        Point r102 = new Point();     // Catch: Throwable -> L45
        int r103 = this.f536779f;     // Catch: Throwable -> L45
        int r104 = this.f536778e;     // Catch: Throwable -> L45
        int r105 = com.bytedance.android.anniex.utils.b.f41399a;     // Catch: Throwable -> L45
        com.bytedance.android.anniex.utils.b.a(this.f536799z);     // Catch: Throwable -> L45
        r102.x = r103;     // Catch: Throwable -> L45
        r102.y = r104;     // Catch: Throwable -> L45
        r100.setPresetMeasuredSpec(r103, r104);     // Catch: Throwable -> L45
        r100.setFontScale(this.f536780g);     // Catch: Throwable -> L45
        r100.setEnableCreateViewAsync(this.f536781h);     // Catch: Throwable -> L45
        r100.setEnableSyncFlush(this.f536782i);     // Catch: Throwable -> L45
        r100.enableAutoExpose(this.f536784k);     // Catch: Throwable -> L45
        r100.setScreenSize(r101.x, r101.y);     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.a0() == false) goto L8;
        r100.setLynxViewConfig(this.f536798y);     // Catch: Throwable -> L45
    L9:
        TraceEvent.beginSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        r100.addBehaviors(this.f536787n);     // Catch: Throwable -> L39
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        TraceEvent.beginSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator<T> r106 = this.f536788o.iterator();     // Catch: Throwable -> L36
    L14:
        if (r106.hasNext() == false) goto L16;
        f r107 = (f) r106.next();     // Catch: Throwable -> L36
        r100.registerModule(r107.b(), r107.a(), r107.c());     // Catch: Throwable -> L36
        goto L14
    L16:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L36
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        Iterator r109 = MapsKt.asSequence(this.f536789p).iterator();     // Catch: Throwable -> L45
    L19:
        if (r109.hasNext() == false) goto L21;
        Map.Entry r113 = (Map.Entry) r109.next();     // Catch: Throwable -> L45
        r100.setResourceProvider((String) r113.getKey(), (k) r113.getValue());     // Catch: Throwable -> L45
        goto L19
    L21:
        r100.setFontLoader(this.f536790q);     // Catch: Throwable -> L45
        r100.setEnablePendingJsTask(this.f536791r);     // Catch: Throwable -> L45
        r100.setEnableJSRuntime(this.f536792s);     // Catch: Throwable -> L45
        r100.setEnableAirStrictMode(this.f536793t);     // Catch: Throwable -> L45
        r100.setEnableUserCodeCache(this.f536794u);     // Catch: Throwable -> L45
        r100.setCodeCacheSourceUrl(this.f536795v);     // Catch: Throwable -> L45
        r100.setDynamicComponentFetcher(new ForestDynamicComponentProvider(TrafficMetrics.FRPM_TTNET, r110, r111));     // Catch: Throwable -> L45
        Uri r114 = r100.getUri();     // Catch: Throwable -> L45
        if (com.bytedance.ies.bullet.service.base.h.Z() == false) goto L24;
        r114 = this.f536799z;     // Catch: Throwable -> L45
    L24:
        boolean r115 = false;
        if (r114 != null) goto L27;
    L29:
        if (r115 == false) goto L31;
        r100.setGenericResourceFetcher(new ForestLynxGenericResourceProvider(TrafficMetrics.FRPM_TTNET, r110, r111, r112));     // Catch: Throwable -> L45
        r100.setMediaResourceFetcher(new com.bytedance.ies.bullet.lynx.resource.forest.a(TrafficMetrics.FRPM_TTNET, r110, r111, r112));     // Catch: Throwable -> L45
        r100.setTemplateResourceFetcher(new ForestTemplateResourceProvider(TrafficMetrics.FRPM_TTNET, r110, null, r111, r112, 4));     // Catch: Throwable -> L45
        r100.setEnableGenericResourceFetcher(LynxBooleanOption.TRUE);     // Catch: Throwable -> L45
    L31:
        r100.setResourceProvider("EXTERNAL_JS_SOURCE", new ForestExternalJSProvider(TrafficMetrics.FRPM_TTNET, r110, r111));     // Catch: Throwable -> L45
        Function1<LynxViewBuilder, Unit> r116 = this.f536783j;     // Catch: Throwable -> L45
        if (r116 == null) goto L34;
        r116.invoke(r100);     // Catch: Throwable -> L45
    L34:
        TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
        return r100;
    L27:
        if (r114.getBooleanQueryParameter("enable_lynx_generic_fetcher", false) != true) goto L29;
        r115 = true;
        goto L29
    L36:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:registerModule");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L39:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:addBehaviors");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L8:
        r100.setLynxViewConfig(r100.getLynxViewConfig());     // Catch: Throwable -> L45
        goto L9
    L42:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilder:<init>");     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        TraceEvent.endSection("LynxViewBuilderParams:toLynxViewBuilder");
        throw th;
    }

    public static b b(b r210, boolean r211, ThreadStrategyForRendering r310, LynxGroup r311, String r312, int r313, int r314, float r315, boolean r316, boolean r317, Function1 r318, boolean r319, List r410, List r411, boolean r412, boolean r413, boolean r414, String r415, boolean r416, float r417, int r418) {
        if ((r418 & 1) == 0) goto L5;
        boolean r100 = r210.f536774a;
    L7:
        if ((r418 & 2) == 0) goto L9;
        ThreadStrategyForRendering r101 = r210.f536775b;
    L11:
        if ((r418 & 4) == 0) goto L13;
        LynxGroup r102 = r210.f536776c;
    L15:
        if ((r418 & 8) == 0) goto L17;
        String r103 = r210.f536777d;
    L19:
        if ((r418 & 16) == 0) goto L21;
        int r104 = r210.f536778e;
    L23:
        if ((r418 & 32) == 0) goto L25;
        int r105 = r210.f536779f;
    L27:
        if ((r418 & 64) == 0) goto L29;
        float r110 = r210.f536780g;
    L31:
        if ((r418 & 128) == 0) goto L33;
        boolean r111 = r210.f536781h;
    L35:
        if ((r418 & 256) == 0) goto L37;
        boolean r112 = r210.f536782i;
    L39:
        if ((r418 & 512) == 0) goto L41;
        Function1 r113 = r210.f536783j;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        boolean r114 = r210.f536784k;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        int r115 = r210.f536785l;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        int r116 = r210.f536786m;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        List r106 = r210.f536787n;
    L59:
        if ((r418 & 16384) == 0) goto L61;
        List r107 = r210.f536788o;
    L62:
        int r320 = r115;
        if ((r418 & 32768) == 0) goto L65;
        Map<String, k<?, ?>> r117 = r210.f536789p;
    L66:
        boolean r321 = r114;
        if ((r418 & 65536) == 0) goto L69;
        w7a.a.b r212 = r210.f536790q;
    L71:
        if ((131072 & r418) == 0) goto L73;
        boolean r213 = r210.f536791r;
    L75:
        if ((262144 & r418) == 0) goto L77;
        boolean r214 = r210.f536792s;
    L79:
        if ((524288 & r418) == 0) goto L81;
        boolean r215 = r210.f536793t;
    L83:
        if ((1048576 & r418) == 0) goto L85;
        boolean r216 = r210.f536794u;
    L87:
        if ((2097152 & r418) == 0) goto L89;
        String r217 = r210.f536795v;
    L91:
        if ((4194304 & r418) == 0) goto L93;
        boolean r218 = r210.f536796w;
    L95:
        if ((r418 & 8388608) == 0) goto L97;
        float r219 = r210.f536797x;
    L98:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r101, "threadStrategy");
        Intrinsics.checkNotNullParameter(r106, "behaviors");
        Intrinsics.checkNotNullParameter(r107, IPerformanceManager.Params.modules);
        Intrinsics.checkNotNullParameter(r117, "resourceProviders");
        return new b(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r321, r320, r116, r106, r107, r117, r212, r213, r214, r215, r216, r217, r218, r219);
    L97:
        r219 = r417;
        goto L98
    L93:
        r218 = r416;
        goto L95
    L89:
        r217 = r415;
        goto L91
    L85:
        r216 = r414;
        goto L87
    L81:
        r215 = r413;
        goto L83
    L77:
        r214 = false;
        goto L79
    L73:
        r213 = r412;
        goto L75
    L69:
        r212 = null;
        goto L71
    L65:
        r117 = null;
        goto L66
    L61:
        r107 = r411;
        goto L62
    L57:
        r106 = r410;
        goto L59
    L53:
        r116 = 0;
        goto L55
    L49:
        r115 = 0;
        goto L51
    L45:
        r114 = r319;
        goto L47
    L41:
        r113 = r318;
        goto L43
    L37:
        r112 = r317;
        goto L39
    L33:
        r111 = r316;
        goto L35
    L29:
        r110 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public /* synthetic */ b(boolean r210, ThreadStrategyForRendering r310, LynxGroup r311, String r312, int r313, int r314, float r315, boolean r316, boolean r317, Function1 r318, boolean r319, int r410, int r411, List r412, boolean r413, boolean r414, boolean r415, boolean r416, String r417, boolean r418, float r419, int r510) {
        if ((r510 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r510 & 2) == 0) goto L9;
        ThreadStrategyForRendering r101 = ThreadStrategyForRendering.ALL_ON_UI;
    L11:
        if ((r510 & 4) == 0) goto L13;
        LynxGroup r102 = null;
    L15:
        if ((r510 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r510 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r510 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r510 & 64) == 0) goto L29;
        float r106 = 1.0f;
    L31:
        if ((r510 & 128) == 0) goto L33;
        boolean r110 = false;
    L35:
        if ((r510 & 256) == 0) goto L37;
        boolean r111 = false;
    L39:
        if ((r510 & 512) == 0) goto L41;
        Function1 r112 = null;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        boolean r113 = true;
    L46:
        int r114 = -1;
        if ((r510 & 2048) == 0) goto L49;
        int r107 = -1;
    L51:
        if ((r510 & 4096) != 0) goto L55;
        r114 = r411;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        List r115 = CollectionsKt.emptyList();
    L59:
        if ((r510 & 16384) == 0) goto L61;
        List r116 = CollectionsKt.emptyList();
    L63:
        if ((32768 & r510) == 0) goto L65;
        Map r211 = MapsKt.emptyMap();
    L67:
        if ((131072 & r510) == 0) goto L69;
        boolean r212 = false;
    L71:
        if ((262144 & r510) == 0) goto L73;
        boolean r213 = true;
    L75:
        if ((524288 & r510) == 0) goto L77;
        boolean r214 = false;
    L79:
        if ((1048576 & r510) == 0) goto L81;
        boolean r215 = false;
    L83:
        if ((2097152 & r510) == 0) goto L85;
        String r216 = null;
    L87:
        if ((4194304 & r510) == 0) goto L89;
        boolean r217 = false;
    L91:
        if ((r510 & 8388608) == 0) goto L93;
        float r108 = 1.0f;
    L94:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r114, r115, r116, r211, null, r212, r213, r214, r215, r216, r217, r108);
        return;
    L93:
        r108 = r419;
        goto L94
    L89:
        r217 = r418;
        goto L91
    L85:
        r216 = r417;
        goto L87
    L81:
        r215 = r416;
        goto L83
    L77:
        r214 = r415;
        goto L79
    L73:
        r213 = r414;
        goto L75
    L69:
        r212 = r413;
        goto L71
    L65:
        r211 = null;
        goto L67
    L61:
        r116 = null;
        goto L63
    L57:
        r115 = r412;
        goto L59
    L49:
        r107 = r410;
        goto L51
    L45:
        r113 = r319;
        goto L46
    L41:
        r112 = r318;
        goto L43
    L37:
        r111 = r317;
        goto L39
    L33:
        r110 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r100, ThreadStrategyForRendering r101, LynxGroup r102, String r110, int r111, int r112, float r113, boolean r114, boolean r115, Function1<? super LynxViewBuilder, Unit> r116, boolean r117, int r118, int r119, List<? extends com.lynx.tasm.behavior.a> r210, List<? extends f> r211, Map<String, ? extends k<?, ?>> r212, w7a.a.b r213, boolean r214, boolean r215, boolean r216, boolean r217, String r218, boolean r219, float r310) {
        Intrinsics.checkNotNullParameter(r101, "threadStrategy");
        Intrinsics.checkNotNullParameter(r210, "behaviors");
        Intrinsics.checkNotNullParameter(r211, IPerformanceManager.Params.modules);
        Intrinsics.checkNotNullParameter(r212, "resourceProviders");
        this.f536774a = r100;
        this.f536775b = r101;
        this.f536776c = r102;
        this.f536777d = r110;
        this.f536778e = r111;
        this.f536779f = r112;
        this.f536780g = r113;
        this.f536781h = r114;
        this.f536782i = r115;
        this.f536783j = r116;
        this.f536784k = r117;
        this.f536785l = r118;
        this.f536786m = r119;
        this.f536787n = r210;
        this.f536788o = r211;
        this.f536789p = r212;
        this.f536790q = r213;
        this.f536791r = r214;
        this.f536792s = r215;
        this.f536793t = r216;
        this.f536794u = r217;
        this.f536795v = r218;
        this.f536796w = r219;
        this.f536797x = r310;
    }
}

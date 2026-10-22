package com.ivy.ivykit.plugin.impl.applet;

import android.app.Application;
import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.o;
import com.bytedance.ies.bullet.core.m;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.r;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.ies.bullet.service.base.ResourceType;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.ies.bullet.service.base.resourceloader.config.LoaderType;
import com.bytedance.mt.protector.impl.UriProtector;
import ix7.g;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q26.h;
import v26.l;

/* JADX INFO: loaded from: classes23.dex */
public final class d extends com.bytedance.ies.bullet.kit.web.impl.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f278369t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f278370u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f278371v;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278372a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.DISK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ResourceType.ASSET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f278372a = r100;
        }
    }

    static {
    }

    public final WebResourceResponse F(String r110) {
        Map<Class<?>, ox7.a> r100 = ox7.b.f527091a;
        ox7.b.c(this.f278371v, "AIWebKitDelegate loadResource: " + r110);
        List<String> r101 = this.f278369t;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L21;
        Iterator<T> r104 = this.f278369t.iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        Object r105 = r104.next();
        if (Intrinsics.areEqual((String) r105, r110) == false) goto L14;
    L19:
        if (r105 == null) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == false) goto L25;
        Map<Class<?>, ox7.a> r107 = ox7.b.f527091a;
        ox7.b.c(this.f278371v, r110 + " is in the white list. skip it");
        return null;
    L25:
        x().f246435c.A();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L37
        Uri r109 = UriProtector.parse(r110);     // Catch: Throwable -> L37
        String r111 = r109.getHost();     // Catch: Throwable -> L37
        if (r111 != null) goto L29;
    L31:
        if (r111 != null) goto L33;
    L35:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Boolean r112 = Boolean.FALSE;
        Pair r113 = new Pair(r112, r112);
    L40:
        boolean r114 = ((Boolean) r113.getFirst()).booleanValue();
        boolean r115 = ((Boolean) r113.getSecond()).booleanValue();
        int r116 = -1;
        if (r114 == true) goto L43;
    L103:
        Pair r117 = r.a.e(this, r110, false, x(), null, 22);
        boolean r118 = ((Boolean) r117.component1()).booleanValue();
        Scene r119 = (Scene) r117.component2();
        if (r118 == true) goto L107;
        Map<Class<?>, ox7.a> r120 = ox7.b.f527091a;
        ox7.b.c(this.f278371v, r110 + " can NOT be intercepted by forest. skip it");
        WebResourceResponse r121 = null;
        String r122 = r110;
    L155:
        WebResourceResponse r123 = r121;
    L156:
        if (r123 != null) goto L158;
        r123 = super.j(r110);
    L158:
        if (r123 == null) goto L171;
        g r124 = (g) B().c(g.class);
        if (r124 == null) goto L162;
        WebResourceResponse r125 = r124.a(r122, r123);
    L163:
        if (r125 != null) goto L166;
        return r123;
    L166:
        return r125;
    L162:
        r125 = r121;
        goto L163
    L171:
        return r123;
    L107:
        if (com.bytedance.ies.bullet.forest.g.a.u(x()) == false) goto L110;
        if (r118 == false) goto L110;
        boolean r126 = true;
    L111:
        x().f246435c.A();
        l r127 = new l();
        int r128 = v26.a.f552670f;
        v26.a r129 = v26.a.C7957a.a(x().f246456x.f246557a);
        if (r129 != null) goto L114;
        r129 = new v26.a(false);
    L114:
        r129.a(CollectionsKt.mutableListOf(new LoaderType[]{LoaderType.GECKO, LoaderType.BUILTIN, LoaderType.CDN}));
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r127.f552699b = r129;
        int r130 = w16.a.f557913b;
        h r131 = x().f246450r;
        if (r131 == null) goto L117;
        Map<Class<?>, Object> r132 = r131.getAllDependency();
    L118:
        r127.f552723z = w16.a.C8059a.a(r132);
        r127.b(this.f278370u);
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r127.f552711n = "web";
        if (r126 == false) goto L125;
        com.bytedance.ies.bullet.forest.f<String, o> r133 = ForestLoader.f246728a;
        r121 = null;
        r122 = r110;
        Response r134 = ForestLoader.h(null, r110, com.bytedance.ies.bullet.forest.g.a.f(x()), r119, x().getSessionId(), r127, null, 65);
        if (r134 == null) goto L123;
        m r135 = x().f246456x;
        String r136 = r134.g(r134.f244319u);
        r135.getClass();
        Intrinsics.checkNotNullParameter(r136, "<set-?>");
        r135.f246558b = r136;
        Map<Class<?>, ox7.a> r137 = ox7.b.f527091a;
        ox7.b.c(this.f278371v, "forest resp: " + r134);
        r123 = r134.m();
    L124:
        x().f246435c.B();
        goto L156
    L123:
        r123 = null;
        goto L124
    L125:
        r121 = null;
        r122 = r110;
        ConcurrentHashMap<String, ResourceLoaderService> r138 = i.f246824a;
        d1 r139 = i.b(this.f278370u, 2).h(r122, r127);
        if (r139 == null) goto L155;
        String r140 = r139.f247859b;
        if (r140 != null) goto L130;
    L131:
        r102 = true;
    L133:
        if ((!r102) == true) goto L136;
        r139 = null;
    L136:
        if (r139 == null) goto L155;
        x().f246435c.B();
        WebResourceResponse r141 = r139.f247882y;
        if (r141 != null) goto L152;
        ResourceType r142 = r139.getType();
        if (r142 == null) goto L143;
        r116 = b.f278372a[r142.ordinal()];
    L143:
        if (r116 == 1) goto L151;
        if (r116 == 2) goto L146;
        r141 = null;
        goto L152
    L146:
        j r143 = j.f246830a;
        Application r144 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r144 == null) goto L149;
        AssetManager r145 = r144.getAssets();
    L150:
        String r146 = r139.f247859b;
        r143.getClass();
        r141 = j.d(r145, r146);
        goto L152
    L149:
        r145 = null;
        goto L150
    L151:
        j r147 = j.f246830a;
        String r148 = r139.f247859b;
        r147.getClass();
        r141 = j.e(r148);
    L152:
        if (r141 == null) goto L154;
        m r149 = x().f246456x;
        String r150 = r139.a();
        r149.getClass();
        Intrinsics.checkNotNullParameter(r150, "<set-?>");
        r149.f246558b = r150;
    L154:
        r123 = r141;
        goto L156
    L130:
        if (r140.length() != 0) goto L133;
    L117:
        r132 = null;
    L110:
        r126 = false;
        goto L111
    L43:
        if (StringsKt.contains$default(r110.toLowerCase(), "/favicon.ico", false, 2, null) == true) goto L45;
        ConcurrentHashMap<String, ResourceLoaderService> r151 = i.f246824a;
        ResourceLoaderService r152 = i.b(this.f278370u, 2);
        l r153 = new l();
        r153.f552702e = 5000;
        v26.a r154 = new v26.a(true);
        r154.f552673c = CollectionsKt.mutableListOf(new Class[]{AIResourceLoader.class});
        if (r115 == false) goto L49;
        r154.f552672b.add(LoaderType.CDN);
    L49:
        Intrinsics.checkNotNullParameter(r154, "<set-?>");
        r153.f552699b = r154;
        int r155 = w16.a.f557913b;
        h r156 = x().f246450r;
        if (r156 == null) goto L52;
        Map<Class<?>, Object> r157 = r156.getAllDependency();
    L53:
        r153.f552723z = w16.a.C8059a.a(r157);
        Intrinsics.checkNotNullParameter("web", "<set-?>");
        r153.f552711n = "web";
        Unit r158 = Unit.INSTANCE;
        d1 r159 = r152.h(r110, r153);
        if (r159 == null) goto L103;
        String r160 = r159.f247859b;
        if (r160 != null) goto L58;
    L61:
        boolean r161 = true;
    L63:
        if ((!r161) == true) goto L66;
        r159 = null;
    L66:
        if (r159 == null) goto L103;
        x().f246435c.B();
        WebResourceResponse r162 = r159.f247882y;
        if (r162 != null) goto L100;
        ResourceType r163 = r159.getType();
        if (r163 != null) goto L72;
        int r164 = -1;
    L73:
        if (r164 == 1) goto L82;
        if (r164 == 2) goto L76;
        r162 = null;
        goto L100
    L76:
        j r165 = j.f246830a;
        Application r166 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r166 == null) goto L79;
        AssetManager r167 = r166.getAssets();
    L80:
        String r168 = r159.f247859b;
        r165.getClass();
        r162 = j.d(r167, r168);
        goto L100
    L79:
        r167 = null;
        goto L80
    L82:
        if (r159.f247865h == null) goto L95;
        g r169 = (g) B().c(g.class);
        String r170 = "";
        if (r169 == null) goto L90;
        j r171 = j.f246830a;
        String r172 = r159.f247859b;
        if (r172 != null) goto L88;
        r172 = "";
    L88:
        r171.getClass();
        r162 = r169.a(r110, E(j.c(r172), r159.f247865h));
        if (r162 != null) goto L100;
    L90:
        j r173 = j.f246830a;
        String r174 = r159.f247859b;
        if (r174 == null) goto L94;
        r170 = r174;
    L94:
        r173.getClass();
        r162 = E(j.c(r170), r159.f247865h);
        goto L100
    L95:
        g r175 = (g) B().c(g.class);
        if (r175 == null) goto L99;
        j r176 = j.f246830a;
        String r177 = r159.f247859b;
        r176.getClass();
        r162 = r175.a(r110, j.e(r177));
        if (r162 != null) goto L100;
    L99:
        j r178 = j.f246830a;
        String r179 = r159.f247859b;
        r178.getClass();
        r162 = j.e(r179);
        goto L100
    L72:
        r164 = b.f278372a[r163.ordinal()];
    L100:
        if (r162 == null) goto L103;
        m r180 = x().f246456x;
        String r181 = r159.a();
        r180.getClass();
        Intrinsics.checkNotNullParameter(r181, "<set-?>");
        r180.f246558b = r181;
        return r162;
    L58:
        if (r160.length() == 0) goto L61;
        r161 = false;
        goto L63
    L52:
        r157 = null;
        goto L53
    L45:
        return new WebResourceResponse("image/png", null, null);
    L33:
        if (r109.getBooleanQueryParameter("dev_mode", false) == false) goto L35;
        Boolean r182 = Boolean.TRUE;     // Catch: Throwable -> L37
        r113 = new Pair(r182, r182);     // Catch: Throwable -> L37
        goto L40
    L29:
        if (Intrinsics.areEqual(r111, "app.aisdk.local") == false) goto L31;
        r113 = new Pair(Boolean.TRUE, Boolean.FALSE);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r183 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L18:
        r105 = null;
    L21:
        r106 = false;
        goto L22
    L5:
        if (r101.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.kit.web.impl.c, com.bytedance.ies.bullet.service.webkit.a
    public final WebResourceResponse i(WebResourceRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return F(r100.getUrl().toString());
    }

    @Override // com.bytedance.ies.bullet.kit.web.impl.c, com.bytedance.ies.bullet.service.webkit.a
    public final WebResourceResponse j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return F(r100);
    }

    public d(com.bytedance.ies.bullet.service.webkit.d r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        super(r100);
        this.f278369t = r101;
        this.f278370u = r100.f540302a;
        this.f278371v = "AIPackageWebView";
    }

    public static WebResourceResponse E(String r100, InputStream r101) {
        if (r101 == null) goto L15;
        HashMap r102 = new HashMap();     // Catch: Exception -> L9
        r102.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L9
        if (Intrinsics.areEqual("font/ttf", r100) == true) goto L14;
        WebResourceResponse r103 = new WebResourceResponse(r100, "", r101);     // Catch: Exception -> L9
        r103.setResponseHeaders(r102);     // Catch: Exception -> L9
        return r103;
    L14:
        return new WebResourceResponse(r100, "", 200, "OK", r102, r101);
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L15:
        return null;
    }
}

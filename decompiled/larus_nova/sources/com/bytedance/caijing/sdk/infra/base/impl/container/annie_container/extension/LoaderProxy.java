package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import com.bytedance.caijing.sdk.infra.base.api.gecko.GeckoService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.settings.IPluginSettingsService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class LoaderProxy {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f202397g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f202398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f202399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f202400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f202401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f202402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<kd4.b, Unit> f202403f;

    public static final class a {
        public static boolean a(Uri r100) {
            IPluginSettingsService r101 = (IPluginSettingsService) ve4.b.a(IPluginSettingsService.class);
            String r102 = null;
            if (r101 == null) goto L5;
            JSONObject r103 = r101.getRedirectJsWorkerConfig();
        L6:
            n.a r104 = n.f202423c;
            if (r103 != null) goto L9;
            r103 = new JSONObject();
        L9:
            r104.getClass();
            n r105 = n.a.a(r103);
            if (r100 == null) goto L12;
            String r106 = UriProtector.getQueryParameter(r100, "is_cj_biz");
        L13:
            boolean r107 = Intrinsics.areEqual(r106, "1");
            if (r100 == null) goto L16;
            String r108 = UriProtector.getQueryParameter(r100, "disable_open_popup");
        L17:
            boolean r109 = Intrinsics.areEqual(r108, "1");
            if (r100 == null) goto L20;
            r102 = UriProtector.getQueryParameter(r100, "js_worker_hook");
        L20:
            boolean r110 = Intrinsics.areEqual(r102, "load_url");
            if (r107 == false) goto L23;
            if (r109 == false) goto L23;
        L24:
            boolean r111 = true;
        L26:
            if (r111 == true) goto L28;
        L30:
            return false;
        L28:
            if (r105.f202424a == false) goto L30;
            return true;
        L23:
            if (r110 == true) goto L24;
            r111 = false;
            goto L26
        L16:
            r108 = null;
            goto L17
        L12:
            r106 = null;
            goto L13
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoaderProxy f202404a;

        public b(LoaderProxy r100) {
            this.f202404a = r100;
        }

        public final void a() {
            IJsbService r100 = (IJsbService) ve4.b.a(IJsbService.class);
            if (r100 == null) goto L5;
            cd4.g r101 = r100.getEventHelper();
        L6:
            if (r101 == null) goto L8;
            r101.a("cj_half_screen_popup_ready", this.f202404a.f202403f);
        L8:
            if (r101 == null) goto L10;
            r101.a("cj_half_screen_popup_closed", this.f202404a.f202403f);
        L10:
            this.f202404a.f202400c.invoke();
            return;
        L5:
            r101 = null;
            goto L6
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
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        if (a.a(this.f202398a) == true) goto L5;
    L109:
        this.f202400c.invoke();
        return;
    L5:
        if (this.f202401d != null) goto L109;
        boolean r100 = false;
        if (this.f202399b == null) goto L85;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        od4.a.C7036a.C7037a r102 = new od4.a.C7036a.C7037a(this.f202399b);
        Intrinsics.checkNotNullParameter("CJWebKitView", "tag");
        r102.f522836b = "CJWebKitView";
        Pair[] r103 = new Pair[2];
        Uri r104 = this.f202398a;
        cd4.j r105 = 0;
        if (r104 == null) goto L12;
        String r106 = r104.toString();
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        r103[0] = TuplesKt.to("schema", r106);
        r103[1] = TuplesKt.to("cj_session_id", (String) this.f202402e.getValue());
        r102.f522837c = MapsKt.mutableMapOf(r103);
        r102.b("openSchema", new j(this));
        r102.b("close", new k(r101));
        r102.b("log", new l());
        Context r107 = this.f202399b;
        IPluginSettingsService r108 = (IPluginSettingsService) ve4.b.a(IPluginSettingsService.class);
        if (r108 == null) goto L18;
        JSONObject r109 = r108.getRedirectJsWorkerConfig();
    L19:
        if (r109 == null) goto L60;
        n.f202423c.getClass();
        n r110 = n.a.a(r109);
        if (r110.f202424a == false) goto L60;
        String r111 = String.valueOf(this.f202398a);
        Intrinsics.checkNotNullParameter(r111, "schema");
        if (r110.f202424a == true) goto L27;
        i r112 = null;
    L43:
        if (r112 == null) goto L60;
        if ((!StringsKt.isBlank(r112.a())) == true) goto L48;
    L54:
        boolean r113 = false;
    L55:
        if (r113 == false) goto L60;
        String r114 = r112.a();
        String r115 = r112.f202417e;
        String r116 = r112.f202418f;
        String r117 = r107.getFilesDir().getPath() + File.separator + "offlineX";
        GeckoService r118 = (GeckoService) ve4.b.a(GeckoService.class);
        if (r118 == null) goto L60;
        InputStream r119 = r118.getFileFromGecko(r107, new PolarisFileWrapper(r117), r114, r115, r116);
    L61:
        if (r119 != null) goto L67;
        Context r120 = this.f202399b;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L65
        r119 = r120.getAssets().open("cj_anniex_redirect_jscode.js");     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r119 = null;
    L67:
        if (r119 == null) goto L85;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L83
        String r124 = b(r119);     // Catch: Throwable -> L83
        od4.a r125 = r102.a();     // Catch: Throwable -> L83
        IContainerHostDepend r126 = (IContainerHostDepend) ve4.b.a(IContainerHostDepend.class);     // Catch: Throwable -> L83
        if (r126 == null) goto L71;
        T r127 = r126.getHostJSWorker(r125);     // Catch: Throwable -> L83
    L72:
        r101.element = r127;     // Catch: Throwable -> L83
        if (r127 == 0) goto L85;
        if (r124.length() <= 0) goto L77;
        boolean r128 = true;
    L78:
        if (r128 == false) goto L80;
        r105 = r127;
    L80:
        if (r105 == 0) goto L85;
        r105.a();     // Catch: Throwable -> L83
        r100 = true;
        goto L85
    L77:
        r128 = false;
        goto L78
    L71:
        r127 = 0;
    L83:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L85
    L48:
        if ((!StringsKt.isBlank(r112.f202417e)) == false) goto L54;
        if ((!StringsKt.isBlank(r112.f202418f)) == false) goto L54;
        if ((!StringsKt.isBlank(r112.f202413a)) == false) goto L54;
        r113 = true;
        goto L55
    L27:
        Iterator<T> r130 = r110.f202425b.iterator();
    L29:
        if (r130.hasNext() == false) goto L41;
        Object r131 = r130.next();
        i r132 = (i) r131;
        r132.getClass();
        Intrinsics.checkNotNullParameter(r111, "schema");
        String r133 = CJSchemaExtensionKt.getQueryParameter(r111, "url");
        if (r133 == null) goto L34;
        CJSchemaExtensionKt.clearQuery(r133);
    L34:
        if (Intrinsics.areEqual(r111, r132.f202413a) == true) goto L36;
    L38:
        boolean r134 = false;
    L39:
        if (r134 == false) goto L29;
    L42:
        r112 = (i) r131;
        goto L43
    L36:
        if ((!StringsKt.isBlank(r111)) == false) goto L38;
        r134 = true;
        goto L39
    L41:
        r131 = null;
    L60:
        r119 = null;
        goto L61
    L18:
        r109 = null;
        goto L19
    L12:
        r106 = null;
    L85:
        if (r100 == true) goto L88;
        this.f202400c.invoke();
        return;
    L88:
        m r135 = new m(new b(this));
        monitor-enter(this);
    L106:
        th = move-exception;
        throw th;
    L91:
        if (this.f202401d != null) goto L93;
        this.f202401d = r135;     // Catch: Throwable -> L106
    L93:
        Unit r136 = Unit.INSTANCE;     // Catch: Throwable -> L106
        monitor-exit(this);
        Handler r137 = new Handler(Looper.getMainLooper());
        Uri r138 = this.f202398a;
        if (r138 == null) goto L102;
        String r139 = UriProtector.getQueryParameter(r138, "cj_delay_load_time");
        if (r139 == null) goto L102;
        Long r140 = StringsKt.toLongOrNull(r139);
        if (r140 == null) goto L102;
        long r141 = r140.longValue();
    L103:
        m r142 = this.f202401d;
        if (r142 == null) goto L122;
        r137.postDelayed(r142, RangesKt.coerceAtLeast(r141, 0));
        return;
    L122:
        return;
    L102:
        r141 = 3000;
        goto L103
    }

    public static String b(InputStream r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        BufferedReader r102 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L7
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L7
        String r104 = r102.readLine();     // Catch: Throwable -> L7
    L3:
        if (r104 == null) goto L5;
        r103.append(r104);     // Catch: Throwable -> L7
        r103.append('\n');     // Catch: Throwable -> L7
        r104 = r102.readLine();     // Catch: Throwable -> L7
        goto L3
    L5:
        r102.close();     // Catch: Throwable -> L7
        r100.close();     // Catch: Throwable -> L7
        return r103.toString();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return "";
    }

    public LoaderProxy(Uri r100, Context r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "realLoadAction");
        this.f202398a = r100;
        this.f202399b = r101;
        this.f202400c = r102;
        this.f202402e = LazyKt.lazy(LoaderProxy$cjSessionId$2.INSTANCE);
        this.f202403f = new LoaderProxy$loadActionSubscriber$1(this);
    }
}

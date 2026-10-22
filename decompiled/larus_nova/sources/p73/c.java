package p73;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.k;
import ti.l;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f527998d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f527999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f528000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f528001c;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
            if (ECAppInfoService.f48114e.i() == false) goto L7;
            dm.a.a("EC.PDP").a(r100);     // Catch: Throwable -> L10
        L8:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
            return;
        L7:
            dm.a.a("EC.PDP").i(r100);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r102 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    static {
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
        a.a("PDPLynxCard load failed on schema: " + this.f528001c.f528002a);
        a("lynx card load fail, errorCode=-1, errorMessage=");
        b r100 = this.f528001c.f528008g;
        if (r100 == null) goto L6;
        r100.onLoadFailed();
        return;
    }

    public final void c() {
        a.a("PDPLynxCard start to load from schema: " + this.f528001c.f528002a);
        String r100 = this.f528001c.f528002a;
        l r101 = null;
        JSONObject r102 = null;
        if (com.bytedance.android.shopping.extensions.k.c(r100) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L28;
    L26:
        this.f528000b = r101;
        return;
    L28:
        String r103 = UriProtector.getQueryParameter(UriProtector.parse(r100), "url");     // Catch: Exception -> L20
        if (r103 != null) goto L11;
    L16:
        String r104 = null;
    L17:
        if (r104 != null) goto L22;
        r104 = UriProtector.parse(r100).buildUpon().build().toString();     // Catch: Exception -> L20
    L22:
        String r105 = r104;
        JSONObject r106 = this.f528001c.f528005d;
        if (r106 == null) goto L25;
        r106.put(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
        r102 = r106;
    L25:
        d r107 = this.f528001c;
        JSONObject r108 = r107.f528006e;
        Context r109 = r107.getContext();
        JSONObject r110 = new JSONObject();
        r110.put("module_param", r102);
        r110.put("mob_data", r108);
        Unit r111 = Unit.INSTANCE;
        r101 = ECLiveHybridUtil.b(r109, r105, com.bytedance.android.shopping.hybrid.a.b(r110), this.f528001c.f528004c, this, null, null, false, null, null, false, 4064);
        w.a.e(w.f166998b, r101, this.f528001c.getContext(), Boolean.valueOf(this.f528001c.f528009h), 8);
        goto L26
    L11:
        if (com.bytedance.android.shopping.extensions.k.c(r103) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        r104 = UriProtector.parse(r103).buildUpon().build().toString();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        r104 = "";
        goto L22
    }

    public final void d() {
        l r100 = this.f528000b;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        a.a("PDPLynxCard release schema: " + this.f528001c.f528002a);
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        this.f528001c = r100;
        this.f527999a = System.currentTimeMillis();
    }

    public final void a(String r110) {
        long r100 = System.currentTimeMillis();
        a.a("PDPLynxCard card load total time: " + (r100 - this.f527999a));
        if (r110 != null) goto L5;
    L10:
        Set<String> r111 = ECProcessMonitor.f45118a;
        ECProcessMonitor.k("preload_pdp_lynx_card", r100 - this.f527999a, null, com.bytedance.android.ec.hybrid.list.util.k.b(this.f528001c), 8);
        return;
    L5:
        if (com.bytedance.android.shopping.extensions.k.c(r110) == false) goto L7;
        String r101 = r110;
    L8:
        if (r101 == null) goto L10;
        Set<String> r102 = ECProcessMonitor.f45118a;
        ECProcessMonitor.l("ec_product_detail", "preload_pdp_lynx_card", r110, null, com.bytedance.android.ec.hybrid.list.util.k.b(this.f528001c), null, AnchorV4DataManager.f166338d, 84);
        goto L10
    L7:
        r101 = null;
        goto L8
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        a.a("PDPLynxCard load success on schema: " + this.f528001c.f528002a);
        a("");
        b r101 = this.f528001c.f528008g;
        if (r101 == null) goto L6;
        r101.a(this.f528000b, this);
        return;
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        a.a("PDPLynxCard onRuntimeReady on " + this.f528001c.f528002a);
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}

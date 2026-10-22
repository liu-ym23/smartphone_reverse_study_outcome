package com.bytedance.locallife.pdp.plugin;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.locallife.biz.videopip.LifeVideoPipSessionManager;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.viewmodel.DitoDataCenter;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/pdp/plugin/GoodsDetailVideoPipPlugin;", "Lcom/bytedance/locallife/dito/plugin/AbsDitoLifeCyclePlugin;", "", "event", "", "onEvent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailVideoPipPlugin extends AbsDitoLifeCyclePlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f261630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f261631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f261632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f261633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f261634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f261635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f261636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f261637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f261638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f261639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Uri f261640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f261641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f261642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final GoodsDetailVideoPipPlugin$fragmentLifecycleCallback$1 f261643q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f261644a = null;

        static {
            f261644a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            vn6.b.a(com.bytedance.locallife.pdp.plugin.b.a.f261675a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailVideoPipPlugin f261645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DitoFragment f261646b;

        public c(GoodsDetailVideoPipPlugin r100, DitoFragment r101) {
            this.f261645a = r100;
            this.f261646b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            JSONObject r101 = (JSONObject) r100;
            GoodsDetailVideoPipPlugin r102 = this.f261645a;
            boolean r103 = r102.f261634h;
            r102.v(this.f261646b);
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailVideoPipPlugin f261647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DitoFragment f261648b;

        public d(GoodsDetailVideoPipPlugin r100, DitoFragment r101) {
            this.f261647a = r100;
            this.f261648b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GoodsDetailVideoPipPlugin r100 = this.f261647a;     // Catch: Throwable -> L4
            boolean r101 = r100.f261634h;     // Catch: Throwable -> L4
            r100.v(this.f261648b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements ViewTreeObserver.OnWindowFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GoodsDetailVideoPipPlugin f261649a;

        public e(GoodsDetailVideoPipPlugin r100) {
            this.f261649a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r100) {
            GoodsDetailVideoPipPlugin r101 = this.f261649a;
            boolean r102 = r101.f261633g;
            String r103 = r101.f261632f;
            if (r102 == false) goto L18;
            if (r100 == false) goto L19;
            boolean r104 = false;
            r101.f261633g = false;
            if (r101.f261634h == true) goto L11;
            DitoFragment r105 = r101.f();
            if (r105 == null) goto L20;
            this.f261649a.v(r105);
            return;
        L20:
            return;
        L11:
            if (Intrinsics.areEqual(r103, "full_page") == false) goto L13;
        L14:
            r104 = true;
        L15:
            if (r104 == false) goto L22;
            com.bytedance.locallife.biz.videopip.b r106 = LifeVideoPipSessionManager.f256999a;
            LifeVideoPipSessionManager.i(this.f261649a.f261637k);
            return;
        L22:
            return;
        L13:
            if (r101.s() == true) goto L15;
        L19:
            return;
        }
    }

    static {
    }

    public final boolean s() {
        com.bytedance.locallife.biz.videopip.b r100 = LifeVideoPipSessionManager.f256999a;
        String r101 = this.f261636j;
        Intrinsics.checkNotNullParameter(r101, "traceSessionId");
        yn6.c r102 = yn6.a.f568561a;
        String r103 = "";
        Object r104 = yn6.a.e(r101, "", "life_poi_75_flag_now");
        if (r104 == null) goto L9;
        String r105 = r104.toString();
        if (r105 == null) goto L9;
        r103 = r105;
    L9:
        if (r103.length() != 0) goto L11;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L16;
        r103 = CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF;
    L16:
        return Intrinsics.areEqual(r103, CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF);
    L11:
        r106 = false;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.locallife.pdp.plugin.GoodsDetailVideoPipPlugin$fragmentLifecycleCallback$1] */
    public GoodsDetailVideoPipPlugin(Bundle r100) {
        this.f261630d = r100;
        this.f261631e = new String[]{"com.bytedance.android.anniex.lite.AnnieXLiteFragment"};
        this.f261632f = CJPayConstant.CJ_PAY_FINGER_PAGE_STYLE_HALF;
        this.f261635i = "";
        this.f261636j = "";
        this.f261637k = "";
        this.f261638l = "";
        this.f261639m = "poi_page";
        this.f261641o = 1;
        this.f261642p = new e(this);
        this.f261643q = new GoodsDetailVideoPipPlugin$fragmentLifecycleCallback$1(this);
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void j(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        vn6.b.b(this);
        Bundle r101 = this.f261630d;     // Catch: Exception -> L52
        String r102 = null;
        if (r101 == null) goto L6;
        String r103 = r101.getString("router_uri");     // Catch: Exception -> L52
    L7:
        Uri r104 = UriProtector.parse(r103);     // Catch: Exception -> L52
        this.f261640n = r104;     // Catch: Exception -> L52
        if (r104 == null) goto L11;
        String r105 = UriProtector.getQueryParameter(r104, "group_id");     // Catch: Exception -> L52
    L12:
        String r106 = "";
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        this.f261635i = r105;     // Catch: Exception -> L52
        Uri r107 = this.f261640n;     // Catch: Exception -> L52
        if (r107 == null) goto L18;
        String r108 = UriProtector.getQueryParameter(r107, "poi_enter_id");     // Catch: Exception -> L52
    L19:
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        this.f261636j = r108;     // Catch: Exception -> L52
        Uri r109 = this.f261640n;     // Catch: Exception -> L52
        if (r109 == null) goto L24;
        String r110 = UriProtector.getQueryParameter(r109, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);     // Catch: Exception -> L52
    L25:
        if (r110 != null) goto L27;
        r110 = "";
    L27:
        this.f261637k = r110;     // Catch: Exception -> L52
        Uri r111 = this.f261640n;     // Catch: Exception -> L52
        if (r111 == null) goto L30;
        String r112 = UriProtector.getQueryParameter(r111, "popup");     // Catch: Exception -> L52
    L31:
        if (r112 == null) goto L34;
        r106 = r112;
    L34:
        this.f261638l = r106;     // Catch: Exception -> L52
        Uri r113 = this.f261640n;     // Catch: Exception -> L52
        if (r113 == null) goto L37;
        r102 = UriProtector.getQueryParameter(r113, "detail_enter_page");     // Catch: Exception -> L52
    L37:
        if (r102 != null) goto L39;
        r102 = "poi_page";
    L39:
        this.f261639m = r102;     // Catch: Exception -> L52
        Uri r114 = this.f261640n;     // Catch: Exception -> L52
        if (r114 == null) goto L50;
        String r115 = UriProtector.getQueryParameter(r114, "request_params");     // Catch: Exception -> L52
        if (r115 != null) goto L44;
    L47:
        boolean r116 = true;
    L48:
        if (r116 == true) goto L50;
        this.f261641o = new JSONObject(r115).optInt("enable_video_pip");     // Catch: Exception -> L52
        goto L50
    L44:
        if (r115.length() == 0) goto L47;
        r116 = false;
    L50:
        goto L53
    L30:
        r112 = null;
        goto L31
    L24:
        r110 = null;
        goto L25
    L18:
        r108 = null;
        goto L19
    L11:
        r105 = null;
        goto L12
    L6:
        r103 = null;
    L53:
        DitoFragment r117 = f();
        if (r117 != null) goto L56;
    L61:
        DitoFragment r118 = f();
        if (r118 == null) goto L71;
        FragmentActivity r119 = r118.requireActivity();
        if (r119 == null) goto L72;
        FragmentManager r120 = r119.getSupportFragmentManager();
        if (r120 == null) goto L73;
        r120.registerFragmentLifecycleCallbacks(this.f261643q, true);
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L56:
        if (this.f261641o != 1) goto L60;
        DitoDataCenter r121 = g().f258041g;
        int r122 = DitoDataCenter.f258004d;
        r121.a0("goods_detail_fmp_complete", 1).observe(r117, new c(this, r117));
        View r123 = r117.getView();
        if (r123 == null) goto L61;
        r123.postDelayed(new d(this, r117), 2000);
        goto L61
    L60:
        v(r117);
        goto L61
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void l(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        this.f261634h = false;
        vn6.b.c(this);
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.e(this.f261637k);
        DitoFragment r102 = f();
        if (r102 == null) goto L10;
        FragmentActivity r103 = r102.requireActivity();
        if (r103 == null) goto L11;
        FragmentManager r104 = r103.getSupportFragmentManager();
        if (r104 == null) goto L12;
        r104.unregisterFragmentLifecycleCallbacks(this.f261643q);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void m(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        DitoFragment r101 = f();
        if (r101 == null) goto L10;
        View r102 = r101.getView();
        if (r102 == null) goto L11;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 == null) goto L12;
        r103.removeOnWindowFocusChangeListener(this.f261642p);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void n(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        this.f261633g = true;
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.f();
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void o(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        boolean r102 = true;
        LifeVideoPipSessionManager.b(true);
        if (LifeVideoPipSessionManager.b(true) == true) goto L5;
        return;
    L5:
        if (this.f261634h == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.f261632f, "full_page") == false) goto L9;
    L12:
        if (r102 == false) goto L17;
        LifeVideoPipSessionManager.i(this.f261637k);
        return;
    L17:
        return;
    L9:
        if (s() == false) goto L12;
        r102 = false;
        goto L12
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, "GoodsDetailImageShow") == false) goto L6;
        this.f261633g = true;
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.g();
        vn6.b.a(com.bytedance.locallife.pdp.plugin.b.C3688b.f261676a);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "GoodsDetailImageDismiss") == true) goto L8;
        return;
    L8:
        if (s() == false) goto L13;
        com.bytedance.locallife.biz.videopip.b r102 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.g();
        vn6.b.a(com.bytedance.locallife.pdp.plugin.b.a.f261675a);
        return;
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void q(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
    }

    @Override // com.bytedance.locallife.dito.plugin.AbsDitoLifeCyclePlugin
    public final void r(t r100) {
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        Intrinsics.checkNotNullParameter(r100, "lifeData");
        DitoFragment r101 = f();
        if (r101 == null) goto L10;
        View r102 = r101.getView();
        if (r102 == null) goto L11;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 == null) goto L12;
        r103.addOnWindowFocusChangeListener(this.f261642p);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void t(boolean r100) {
        if (r100 == false) goto L8;
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.f();
        DitoFragment r102 = f();
        if (r102 == null) goto L10;
        View r103 = r102.getView();
        if (r103 == null) goto L11;
        r103.postDelayed(b.f261644a, 500);
        return;
    L11:
        return;
    L10:
        return;
    L8:
        com.bytedance.locallife.biz.videopip.b r104 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.i(this.f261637k);
    }

    public final void v(DitoFragment r100) {
        if (this.f261634h == false) goto L5;
        return;
    L5:
        if (this.f261633g == true) goto L12;
        this.f261634h = true;
        com.bytedance.locallife.biz.videopip.b r101 = LifeVideoPipSessionManager.f256999a;
        LifeVideoPipSessionManager.g();
        LifeVideoPipSessionManager.d(this.f261635i, "detail_page", this.f261637k, e().f(), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_from", this.f261639m), TuplesKt.to("smallwindow_page", "detail_page")}));
        if (Intrinsics.areEqual(this.f261638l, "1") == false) goto L9;
        boolean r102 = s();
        t(r102);
        DitoDataCenter r103 = g().f258041g;
        int r104 = DitoDataCenter.f258004d;
        r103.a0("dialog_state_event", 1).observe(r100, new com.bytedance.locallife.pdp.plugin.c(this, r102));
        return;
    L9:
        this.f261632f = "full_page";
        LifeVideoPipSessionManager.i(this.f261637k);
        return;
    }
}

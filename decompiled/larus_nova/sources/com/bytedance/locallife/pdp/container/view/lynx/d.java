package com.bytedance.locallife.pdp.container.view.lynx;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.api.config.CubeContext;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.cube.api.model.DelegateStatus;
import com.bytedance.locallife.pdp.opt.GoodsLynxTimingApiManager;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements LynxLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f261312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LynxLoader.b f261313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxLoader.c f261314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f261315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IPoiLynxKitDelegate f261316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f261317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f261318g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.pdp.container.view.lynx.LynxLoader
    public final void cancel() {
        this.f261315d.set(2);
        this.f261313b = null;
        this.f261314c = null;
        this.f261316e = null;
        this.f261317f.removeCallbacksAndMessages(null);
    }

    public d(boolean r100) {
        this.f261312a = r100;
        this.f261315d = new AtomicInteger(0);
        this.f261317f = new Handler(Looper.getMainLooper());
        this.f261318g = new f(this);
    }

    public static final void a(d r100, Throwable r101) {
        if (r101 == null) goto L7;
        LynxLoader.b r102 = r100.f261313b;
        if (r102 == null) goto L10;
        r102.d(r101);
    L10:
        r100.f261313b = null;
        r100.f261314c = null;
        r100.f261316e = null;
        r100.f261317f.removeCallbacksAndMessages(null);
        r100.f261315d.set(0);
        return;
    L7:
        LynxLoader.b r103 = r100.f261313b;
        if (r103 == null) goto L10;
        r103.a(new i(false, false));
        goto L10
    }

    public final void b(String r100, IPoiLynxKitDelegate r101, final LynxLoader.a r102, b.c r110, b.a r111) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r102, "loadParamsGenerator");
        Intrinsics.checkNotNullParameter(r110, "loadResultCallback");
        boolean r103 = true;
        if (this.f261315d.compareAndSet(0, 1) == true) goto L6;
        r110.d(new IllegalStateException("in running state"));
        return;
    L6:
        DelegateStatus r104 = null;
        if (r101 == null) goto L11;
        View r105 = r101.realView();
        if (r105 == null) goto L11;
        ViewParent r106 = r105.getParent();
    L12:
        if (r106 == null) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L29;
        if (r101 == null) goto L21;
        CubeContext r112 = r101.getCubeContext();
        if (r112 == null) goto L21;
        r104 = r112.a();
    L21:
        if (r104 == DelegateStatus.INIT) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L27;
        CubeInternalSchemaModel r114 = kp6.c.e(kp6.c.f505514a, r100);
        Map<String, Object> r108 = r102.a(r100);
        Map<String, Object> r109 = r102.c();
        int r115 = n.f261335a;
        n.a.a(this.f261312a, r101, r114, r108, r109);
        r110.a(new i(false, true));
        return;
    L27:
        r110.d(new IllegalStateException("view in screen,but cube in init state"));
        return;
    L23:
        r113 = false;
        goto L24
    L29:
        if (r101 == null) goto L34;
        CubeContext r116 = r101.getCubeContext();
        if (r116 == null) goto L34;
        r104 = r116.a();
    L34:
        if (r104 != DelegateStatus.INIT) goto L37;
        r103 = false;
    L37:
        CubeInternalSchemaModel r117 = kp6.c.e(kp6.c.f505514a, r100);
        if (r103 == false) goto L40;
        r117 = kp6.c.a(r117, DefaultLynxLoader$load$schemaModel$1$1.INSTANCE);
    L40:
        final Map<String, ? extends Object> r118 = r102.a(r100);
        if (r103 == false) goto L43;
        r118.put("preload", Boolean.FALSE);
        int r119 = GoodsLynxTimingApiManager.f261615a;
        GoodsLynxTimingApiManager.a(r118, GoodsLynxTimingApiManager.FLAG.PRELOAD);
    L43:
        Map<String, Object> r120 = r102.c();
        i r121 = new i(r103, false);
        r110.b(r121, r117.getSchema(), r118);
        if (r103 == false) goto L47;
        int r122 = n.f261335a;
        n.a.a(this.f261312a, r101, r117, r118, r120);
        r110.c(r121);
        r110.a(r121);
        return;
    L47:
        if (r101 == null) goto L49;
        r101.updateGlobalProps(r120, r117);
    L49:
        this.f261313b = r110;
        this.f261314c = r111;
        this.f261316e = r101;
        if (r101 == null) goto L52;
        r101.addCubeListener(this.f261318g);
    L52:
        if (r101 == null) goto L54;
        r101.load(r117, new DefaultLynxLoader$load$1(r118, r102));
    L54:
        r110.c(new i(false, false));
        Handler r123 = this.f261317f;
        e r124 = new e(this);
        if (HostServiceUtilsKt.u().i() == false) goto L57;
    L60:
        long r125 = 1000;
    L61:
        r123.postDelayed(r124, r125);
        return;
    L57:
        if (HostServiceUtilsKt.u().p() == true) goto L60;
        r125 = 400;
        goto L61
    L14:
        r107 = false;
    L11:
        r106 = null;
        goto L12
    }
}

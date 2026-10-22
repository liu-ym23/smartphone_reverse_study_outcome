package com.bytedance.ee.bear.watermark;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.NetService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.watermark.Watermark;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f239835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f239836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f239837c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WatermarkInfo f239838d;

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f239839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f239840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f239841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f239842d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.watermark.l$a$a, reason: collision with other inner class name */
        public static final class C3445a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f239843a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f239844b;

            public C3445a(Function0<Unit> r100, Function0<Unit> r101) {
                this.f239843a = r100;
                this.f239844b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                ju5.j r101 = (ju5.j) r100;
                Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
                tt5.a.h("WatermarkManager", "getValueInBgThread success: " + du5.b.k(r101.f500499a) + ' ' + r101.f500500b);
                if (TextUtils.isEmpty(r101.f500499a) == false) goto L5;
            L8:
                String r102 = l.f239835a;
                if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.watermark.error.no_fallback") == false) goto L11;
                tt5.a.h("WatermarkManager", "watermark request error and no cache, return without fallback");
                return;
            L11:
                l.h(true, this.f239843a, this.f239844b);
                return;
            L5:
                if (TextUtils.isEmpty(r101.f500500b) == true) goto L8;
                boolean r103 = Boolean.parseBoolean(r101.f500500b);
                String r104 = l.f239835a;
                l.h(r103, this.f239843a, this.f239844b);
                l.f239837c.put(r101.f500499a, Boolean.valueOf(r103));
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f239845a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f239846b;

            public b(Function0<Unit> r100, Function0<Unit> r101) {
                this.f239845a = r100;
                this.f239846b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.d("WatermarkManager", "getValueInBgThread onError: " + ((Throwable) r100));
                String r101 = l.f239835a;
                if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.watermark.error.no_fallback") == false) goto L5;
                tt5.a.h("WatermarkManager", "watermark db error, return without fallback");
                return;
            L5:
                l.h(true, this.f239845a, this.f239846b);
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c<T> f239847a = null;

            static {
                f239847a = new c();
            }

            public c() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.h("WatermarkManager", "insertModelInBgThread result " + ((Long) r100));
            }
        }

        public static final class d<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d<T> f239848a = null;

            static {
                f239848a = new d();
            }

            public d() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.d("WatermarkManager", "insertModelInBgThread err: " + ((Throwable) r100));
            }
        }

        @Override // com.bytedance.ee.bear.watermark.h
        public final void onError() {
            tt5.a.d("WatermarkManager", "getWatermarkFromNet error");
            if (this.f239842d == true) goto L6;
            return;
        L6:
            if (com.bytedance.ee.util.db.b.f243109b != null) goto L17;
            Object r100 = com.bytedance.ee.util.db.b.f243108a;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L10:
            if (com.bytedance.ee.util.db.b.f243109b != null) goto L12;
            com.bytedance.ee.util.db.b.f243109b = new com.bytedance.ee.util.db.b(eu5.b.f474075a);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L14
        L17:
            com.bytedance.ee.util.db.b r101 = com.bytedance.ee.util.db.b.f243109b;
            String r102 = this.f239839a;
            r101.getClass();
            Flowable r103 = Flowable.just(r102).observeOn(fo5.d.b()).map(new ju5.h(r101)).observeOn(fo5.d.d());
            Function0<Unit> r104 = this.f239840b;
            Function0<Unit> r105 = this.f239841c;
            r103.subscribe(new C3445a(r104, r105), new b(r104, r105));
        }

        @Override // com.bytedance.ee.bear.watermark.h
        public final void a(WatermarkConfigPuller$WatermarkResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            String r101 = String.valueOf(r100.showWatermark);
            tt5.a.h("WatermarkManager", "getWatermarkConfig showWatermark: " + r101);
            if (com.bytedance.ee.util.db.b.f243109b != null) goto L14;
            Object r102 = com.bytedance.ee.util.db.b.f243108a;
            monitor-enter(r102);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (com.bytedance.ee.util.db.b.f243109b != null) goto L9;
            com.bytedance.ee.util.db.b.f243109b = new com.bytedance.ee.util.db.b(eu5.b.f474075a);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r102);     // Catch: Throwable -> L11
        L14:
            com.bytedance.ee.util.db.b r103 = com.bytedance.ee.util.db.b.f243109b;
            ju5.j r104 = new ju5.j(this.f239839a, r101);
            r103.getClass();
            Flowable.just(r104).observeOn(fo5.d.b()).map(new ju5.i(r103)).subscribe(c.f239847a, d.f239848a);
            l.f239837c.put(this.f239839a, Boolean.valueOf(r100.showWatermark));
            String r105 = l.f239835a;
            l.h(r100.showWatermark, this.f239840b, this.f239841c);
        }

        public a(String r100, Function0<Unit> r101, Function0<Unit> r102, boolean r103) {
            this.f239839a = r100;
            this.f239840b = r101;
            this.f239841c = r102;
            this.f239842d = r103;
        }
    }

    public l() {
    }

    static {
        f239836b = Integer.MIN_VALUE;
        f239837c = new ConcurrentHashMap();
        f239838d = new WatermarkInfo();
    }

    public static boolean i() {
        boolean r100 = f239838d.isGlobalWatermark();
        tt5.a.h("WatermarkManager", "isGlobalWatermark=" + r100);
        return r100;
    }

    public static final void a(FrameLayout r100) {
        tt5.a.h("WatermarkManager", "addGlobalWatermark for frameLayout");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getHeight() != 0) goto L7;
        r100.post(new j(r100));
        return;
    L7:
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r100, true, null);
    }

    public static final void b(FrameLayout r100) {
        tt5.a.h("WatermarkManager", "addWaterMark for frameLayout");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getHeight() != 0) goto L7;
        r100.post(new k(r100));
        return;
    L7:
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r100, null);
    }

    @JvmStatic
    public static final void c(Activity r100) {
        tt5.a.h("WatermarkManager", "addWaterMark for activity");
        if (r100 == null) goto L6;
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r100, null);
        return;
    }

    @JvmStatic
    public static final void d(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isFinishing() == false) goto L6;
        return;
    L6:
        if (r100.isDestroyed() == true) goto L11;
        Watermark.Companion.getClass();
        Watermark.a.a().detachWatermark(r100);
        return;
    }

    @JvmStatic
    public static final void e(FrameLayout r100) {
        if (r100 == null) goto L5;
        Watermark.Companion.getClass();
        Watermark.a.a().detachWatermark(r100);
        return;
    }

    public static String f(String r100, Integer r101) {
        return "watermark" + r100 + r101;
    }

    public static void h(boolean r100, Function0 r101, Function0 r102) {
        if (r100 == true) goto L6;
        tt5.a.h("WatermarkManager", "do not need watermark");
        if (r102 == null) goto L9;
        r102.invoke();
        return;
    L9:
        return;
    L6:
        if (r101 == null) goto L11;
        r101.invoke();
        return;
    }

    public static void g(String r100, int r101, Function0 r102, Function0 r103, boolean r104) {
        tt5.a.h("WatermarkManager", "handleByNetConfig type: " + r101);
        if (r100 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L14;
        if (r101 < 0) goto L14;
        String r106 = f(r100, Integer.valueOf(r101));
        NetService.d r107 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new i());
        String r108 = String.valueOf(r101);
        a r109 = new a(r106, r102, r103, r104);
        NetService.f r110 = new NetService.f("/api/obj_setting/get/");
        r110.b("obj_type", r108);
        r110.b("obj_token", r100);
        r107.a(r110).observeOn(fo5.d.d()).subscribe(new f(r109), new g(r109));
        return;
    L14:
        tt5.a.d("WatermarkManager", "token.isNullOrEmpty() || type < 0");
        h(true, r102, r103);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}

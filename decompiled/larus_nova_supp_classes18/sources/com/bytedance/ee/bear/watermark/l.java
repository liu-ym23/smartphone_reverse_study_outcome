package com.bytedance.ee.bear.watermark;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.watermark.Watermark;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public static volatile String a;
    public static volatile int b;
    public static final ConcurrentHashMap<String, Boolean> c = null;
    public static WatermarkInfo d;

    public static final class a implements h {
        public final /* synthetic */ String a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ boolean d;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.watermark.l$a$a, reason: collision with other inner class name */
        public static final class C0198a<T> implements Consumer {
            public final /* synthetic */ Function0<Unit> a;
            public final /* synthetic */ Function0<Unit> b;

            public C0198a(Function0<Unit> r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r4) {
                ju5.j r5 = (ju5.j) r4;
                Intrinsics.checkNotNullParameter(r5, "model");
                tt5.a.h("WatermarkManager", "getValueInBgThread success: " + du5.b.k(r5.a) + ' ' + r5.b);
                if (TextUtils.isEmpty(r5.a) == false) goto L5;
            L8:
                String r6 = l.a;
                if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.watermark.error.no_fallback") == false) goto L11;
                tt5.a.h("WatermarkManager", "watermark request error and no cache, return without fallback");
                return;
            L11:
                l.h(true, this.a, this.b);
                return;
            L5:
                if (TextUtils.isEmpty(r5.b) == true) goto L8;
                boolean r0 = Boolean.parseBoolean(r5.b);
                String r1 = l.a;
                l.h(r0, this.a, this.b);
                l.c.put(r5.a, Boolean.valueOf(r0));
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ Function0<Unit> a;
            public final /* synthetic */ Function0<Unit> b;

            public b(Function0<Unit> r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r3) {
                tt5.a.d("WatermarkManager", "getValueInBgThread onError: " + ((Throwable) r3));
                String r4 = l.a;
                if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.watermark.error.no_fallback") == false) goto L5;
                tt5.a.h("WatermarkManager", "watermark db error, return without fallback");
                return;
            L5:
                l.h(true, this.a, this.b);
            }
        }

        public static final class c<T> implements Consumer {
            public static final c<T> a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final void accept(Object r3) {
                tt5.a.h("WatermarkManager", "insertModelInBgThread result " + ((Long) r3));
            }
        }

        public static final class d<T> implements Consumer {
            public static final d<T> a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final void accept(Object r3) {
                tt5.a.d("WatermarkManager", "insertModelInBgThread err: " + ((Throwable) r3));
            }
        }

        @Override // com.bytedance.ee.bear.watermark.h
        public final void onError() {
            tt5.a.d("WatermarkManager", "getWatermarkFromNet error");
            if (this.d == true) goto L6;
            return;
        L6:
            if (com.bytedance.ee.util.db.b.b != null) goto L17;
            Object r0 = com.bytedance.ee.util.db.b.a;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L10:
            if (com.bytedance.ee.util.db.b.b != null) goto L12;
            com.bytedance.ee.util.db.b.b = new com.bytedance.ee.util.db.b(eu5.b.a);     // Catch: Throwable -> L14
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L14
        L17:
            com.bytedance.ee.util.db.b r1 = com.bytedance.ee.util.db.b.b;
            String r2 = this.a;
            r1.getClass();
            Flowable r3 = Flowable.just(r2).observeOn(fo5.d.b()).map(new ju5.h(r1)).observeOn(fo5.d.d());
            Function0<Unit> r4 = this.b;
            Function0<Unit> r5 = this.c;
            r3.subscribe(new C0198a(r4, r5), new b(r4, r5));
        }

        @Override // com.bytedance.ee.bear.watermark.h
        public final void a(WatermarkConfigPuller$WatermarkResult r5) {
            Intrinsics.checkNotNullParameter(r5, "result");
            String r0 = String.valueOf(r5.showWatermark);
            tt5.a.h("WatermarkManager", "getWatermarkConfig showWatermark: " + r0);
            if (com.bytedance.ee.util.db.b.b != null) goto L14;
            Object r1 = com.bytedance.ee.util.db.b.a;
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (com.bytedance.ee.util.db.b.b != null) goto L9;
            com.bytedance.ee.util.db.b.b = new com.bytedance.ee.util.db.b(eu5.b.a);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
        L14:
            com.bytedance.ee.util.db.b r2 = com.bytedance.ee.util.db.b.b;
            ju5.j r3 = new ju5.j(this.a, r0);
            r2.getClass();
            Flowable.just(r3).observeOn(fo5.d.b()).map(new ju5.i(r2)).subscribe(c.a, d.a);
            l.c.put(this.a, Boolean.valueOf(r5.showWatermark));
            String r4 = l.a;
            l.h(r5.showWatermark, this.b, this.c);
        }

        public a(String r1, Function0<Unit> r2, Function0<Unit> r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public l() {
    }

    static {
        b = Integer.MIN_VALUE;
        c = new ConcurrentHashMap();
        d = new WatermarkInfo();
    }

    public static boolean i() {
        boolean r0 = d.isGlobalWatermark();
        tt5.a.h("WatermarkManager", "isGlobalWatermark=" + r0);
        return r0;
    }

    public static final void a(FrameLayout r3) {
        tt5.a.h("WatermarkManager", "addGlobalWatermark for frameLayout");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.getHeight() != 0) goto L7;
        r3.post(new j(r3));
        return;
    L7:
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r3, true, null);
    }

    public static final void b(FrameLayout r2) {
        tt5.a.h("WatermarkManager", "addWaterMark for frameLayout");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getHeight() != 0) goto L7;
        r2.post(new k(r2));
        return;
    L7:
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r2, null);
    }

    @JvmStatic
    public static final void c(Activity r2) {
        tt5.a.h("WatermarkManager", "addWaterMark for activity");
        if (r2 == null) goto L6;
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r2, null);
        return;
    }

    @JvmStatic
    public static final void d(Activity r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isFinishing() == false) goto L6;
        return;
    L6:
        if (r1.isDestroyed() == true) goto L11;
        Watermark.Companion.getClass();
        Watermark.a.a().detachWatermark(r1);
        return;
    }

    @JvmStatic
    public static final void e(FrameLayout r1) {
        if (r1 == null) goto L5;
        Watermark.Companion.getClass();
        Watermark.a.a().detachWatermark(r1);
        return;
    }

    public static String f(String r2, Integer r3) {
        return "watermark" + r2 + r3;
    }

    public static void h(boolean r0, Function0 r1, Function0 r2) {
        if (r0 == true) goto L6;
        tt5.a.h("WatermarkManager", "do not need watermark");
        if (r2 == null) goto L9;
        r2.invoke();
        return;
    L9:
        return;
    L6:
        if (r1 == null) goto L11;
        r1.invoke();
        return;
    }

    public static void g(String r4, int r5, Function0 r6, Function0 r7, boolean r8) {
        tt5.a.h("WatermarkManager", "handleByNetConfig type: " + r5);
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L14;
        if (r5 < 0) goto L14;
        String r0 = f(r4, Integer.valueOf(r5));
        NetService.d r1 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new i());
        String r9 = String.valueOf(r5);
        a r3 = new a(r0, r6, r7, r8);
        NetService.f r10 = new NetService.f("/api/obj_setting/get/");
        r10.b("obj_type", r9);
        r10.b(ResourceData.KEY_OBJ_TOKEN, r4);
        r1.a(r10).observeOn(fo5.d.d()).subscribe(new f(r3), new g(r3));
        return;
    L14:
        tt5.a.d("WatermarkManager", "token.isNullOrEmpty() || type < 0");
        h(true, r6, r7);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}

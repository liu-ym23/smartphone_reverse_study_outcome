package com.bytedance.ee.bear.bitable.preload.util;

import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitablePreloadBridgeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215016a = 0;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableOfflineResultModel f215017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f215018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ tb5.m f215019c;

        public a(BitableOfflineResultModel r100, long r101, tb5.m r102) {
            this.f215017a = r100;
            this.f215018b = r101;
            this.f215019c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            String r111 = (String) r110;
            String r100 = this.f215017a.toString();     // Catch: OutOfMemoryError -> L11
            int r101 = r100.length();     // Catch: OutOfMemoryError -> L11
            tt5.a.h("BitablePreloadBridgeUtil", "resultModelString length: " + r101 + "  cost: " + (System.currentTimeMillis() - this.f215018b));     // Catch: OutOfMemoryError -> L9
            tb5.m r102 = this.f215019c;     // Catch: OutOfMemoryError -> L9
            if (r102 == null) goto L7;
            r102.onCallBack(r100);     // Catch: OutOfMemoryError -> L9
        L7:
            tt5.a.h("BitablePreloadBridgeUtil", "resultModelString done");     // Catch: OutOfMemoryError -> L9
            return;
        L9:
            e = e;
        L13:
            BitableOfflineResultModel r103 = new BitableOfflineResultModel(false, "", "");
            tb5.m r104 = this.f215019c;
            if (r104 == null) goto L16;
            r104.onCallBack(r103.toString());
        L16:
            String r105 = this.f215017a.printAndGetFieldsLengthInfo() + "--resultModelStringLength: " + r101;
            tt5.a.h("BitablePreloadBridgeUtil", "onJsCallback out of memory and data: " + r105);
            iu5.d.a("BitablePreloadBridgeUtil", new Throwable(r105, e));
            return;
        L11:
            e = e;
            r101 = 0;
            goto L13
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tb5.m f215020a;

        public b(tb5.m r100) {
            this.f215020a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("BitablePreloadBridgeUtil", "onJsCallback fail", r101, false);
            if (r101 == null) goto L5;
            String r102 = r101.getMessage();
        L6:
            BitableOfflineResultModel r103 = new BitableOfflineResultModel(false, r102, "");
            tb5.m r104 = this.f215020a;
            if (r104 == null) goto L10;
            r104.onCallBack(r103.toString());
            return;
        L10:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @JvmStatic
    public static final void e() {
        tt5.a.h("BitablePreloadBridgeUtil", "registerRN");
        final com.bytedance.ee.bear.rn.j r100 = (com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6);
        Flowable<String> r101 = r100.d(new BitablePreloadBridgeUtil$registerRN$1(r100));
        if (r101 == null) goto L6;
        r101.subscribe();
        return;
    }

    @JvmStatic
    public static final void a(BitableOfflineResultModel r100, tb5.m r101) {
        Intrinsics.checkNotNullParameter(r100, "resultModel");
        long r102 = System.currentTimeMillis();
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new a(r100, r102, r101), new b(r101));
    }

    @JvmStatic
    public static final void b(String r100, String r101, tb5.m r102) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        tt5.a.b("BitablePreloadBridgeUtil", "onJsFailCallback()... errorMsg = ".concat(r100));
        a(new BitableOfflineResultModel(false, r100, r101), r102);
    }

    @JvmStatic
    public static final void c(String r100, boolean r101, tb5.m r102) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        tt5.a.b("BitablePreloadBridgeUtil", "onJsFailCallback()... errorMsg = ".concat(r100));
        a(new BitableOfflineResultModel(false, r101, r100, ""), r102);
    }

    @JvmStatic
    public static final void d(String r100, boolean r101, tb5.m r102) {
        tt5.a.b("BitablePreloadBridgeUtil", "onJsSuccessCallback()... and isNet " + r101);
        a(new BitableOfflineResultModel(true, r101, "", r100), r102);
    }
}

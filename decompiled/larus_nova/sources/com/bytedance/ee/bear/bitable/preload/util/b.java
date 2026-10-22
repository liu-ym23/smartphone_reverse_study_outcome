package com.bytedance.ee.bear.bitable.preload.util;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.bytedance.ee.bear.bitable.dao.BitableDatabase;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.load.cache.CacheType;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import k25.e0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f215022a;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f215023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f215024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f215025c;

        public a(b r100, long r101, long r102) {
            this.f215023a = r100;
            this.f215024b = r101;
            this.f215025c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            this.f215023a.getClass();
            BitableDatabase r101 = b.b();
            if (r101 == null) goto L7;
            as4.a r102 = r101.d();
            if (r102 == null) goto L7;
            as4.b r103 = (as4.b) r102;
            r103.c(Long.valueOf(this.f215024b), 1);
        L7:
            this.f215023a.getClass();
            BitableDatabase r104 = b.b();
            if (r104 == null) goto L12;
            as4.a r105 = r104.d();
            if (r105 == null) goto L12;
            as4.b r106 = (as4.b) r105;
            r106.c(Long.valueOf(this.f215025c), 0);
        L12:
            this.f215023a.getClass();
            BitableDatabase r107 = b.b();
            if (r107 == null) goto L17;
            zr4.b r108 = r107.c();
            if (r108 == null) goto L17;
            zr4.c r109 = (zr4.c) r108;
            r109.b(Long.valueOf(this.f215025c));
        L17:
            this.f215023a.getClass();
            BitableDatabase r110 = b.b();
            if (r110 == null) goto L22;
            zr4.b r111 = r110.c();
            if (r111 == null) goto L22;
            zr4.c r112 = (zr4.c) r111;
            return Integer.valueOf(r112.d(Long.valueOf(this.f215025c)));
        L22:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.preload.util.b$b, reason: collision with other inner class name */
    public static final class C3070b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f215026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f215027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f215028c;

        public C3070b(b r100, long r101, long r102) {
            this.f215026a = r100;
            this.f215027b = r101;
            this.f215028c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            this.f215026a.getClass();
            tt5.a.h("BitablePreloadDBUtil", "clearDataByTimeMills: timeout : " + this.f215027b + ", over30TimeMills: " + this.f215028c);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f215029a;

        public c(b r100) {
            this.f215029a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f215029a.getClass();
            tt5.a.e("BitablePreloadDBUtil", "clearDataByTimeMills ", (Throwable) r100, false);
        }
    }

    public b() {
        this.f215022a = "";
    }

    public static BitableDatabase b() {
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.a().P2().a();
    }

    public static boolean d(CacheType r100, BitableResourceData r101) {
        String r102 = "";
        Intrinsics.checkNotNullParameter(r100, "cacheType");
        Intrinsics.checkNotNullParameter(r101, "resourceData");
        if (r100 != CacheType.DB) goto L5;
        com.bytedance.ee.bear.bitable.preload.g.a r103 = com.bytedance.ee.bear.bitable.preload.g.b(r101.getResKey(), UserChangedCallback.CHANGE_TYPE_UPDATE);
    L30:
    L16:
        th = move-exception;
        String r104 = th.getMessage();
        if (r104 == null) goto L21;
        r102 = r104;
    L21:
        List<String> r105 = com.bytedance.ee.bear.bitable.preload.g.f215001a;
        Intrinsics.checkNotNullParameter(r102, "debugMessage");
        if (r103 != null) goto L31;
    L28:
        tt5.a.k("BitablePreloadDBUtil", "setResourceToDB Failed:" + th);
        return false;
    L31:
        JSONObject r106 = com.bytedance.ee.bear.bitable.preload.g.a(r103);     // Catch: JSONException -> L26
        r106.put("status", "error").put("debug_message", r102);     // Catch: JSONException -> L26
        com.bytedance.ee.bear.bitable.preload.g.c(r103, r106);     // Catch: JSONException -> L26
    L26:
        e = move-exception;
        tt5.a.l("BitablePreloadAnalytic", "Failed to report preload, ", e);
        goto L28
    L7:
        if (TextUtils.isEmpty(r101.getBaseToken()) == true) goto L15;
        if (TextUtils.isEmpty(r101.getResKey()) == true) goto L15;
        if (TextUtils.isEmpty(r101.getResValue()) == true) goto L15;
        com.bytedance.ee.bear.bitable.core.usercomponent.b.b(r100).b(r101);     // Catch: Throwable -> L16
        com.bytedance.ee.bear.bitable.preload.g.d(r103, r101.getResValue().length(), "", "");     // Catch: Throwable -> L16
        return true;
    L15:
        throw new Throwable("main params is empty");     // Catch: Throwable -> L16
    L5:
        r103 = null;
        goto L30
    }

    public final void a(long r100, long r110) {
        Flowable.just("").observeOn(Schedulers.from(e0.r())).map(new a(this, r110, r100)).subscribe(new C3070b(this, r100, r110), new c(this));
    }

    public final BitableResourceData c(CacheType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "cacheType");
        com.bytedance.ee.bear.bitable.load.cache.a r103 = com.bytedance.ee.bear.bitable.core.usercomponent.b.b(r100);     // Catch: Throwable -> L11
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        return r103.a(r101, "", r102, "");
    L11:
        th = move-exception;
        tt5.a.k("BitablePreloadDBUtil", "getResourceToDB Failed:" + th);
        this.f215022a = "mainPageCacheFetchFailed";
        return null;
    }
}

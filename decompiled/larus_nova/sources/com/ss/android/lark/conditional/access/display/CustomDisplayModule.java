package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelByKeyRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class CustomDisplayModule implements g, r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f418043f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f418044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f418045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f418046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final apb.a f418047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f418048e;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f418049a = null;

        static {
            f418049a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            CustomDisplayModelResponse r101 = (CustomDisplayModelResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return r101.config;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomDisplayModule f418050a;

        public c(CustomDisplayModule r100) {
            this.f418050a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CustomDisplayModule.a(this.f418050a, ((CustomDisplayMGetResponse) r100).config_list);
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418051a;

        public d(String r100) {
            this.f418051a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            CustomDisplayMGetResponse r101 = (CustomDisplayMGetResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            List<CustomDisplayConfig> r102 = r101.config_list;
            String r103 = this.f418051a;
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L8;
            T r105 = r104.next();
            if (Intrinsics.areEqual(((CustomDisplayConfig) r105).f253753id, r103) == false) goto L4;
        L9:
            CustomDisplayConfig r106 = r105;
            if (r106 == null) goto L13;
            return Single.just(new CustomDisplayModel(r106, System.currentTimeMillis()));
        L13:
            return Single.error(new Exception("fetch success, but no id match"));
        L8:
            r105 = (T) null;
            goto L9
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public final String c() {
        return StringsKt.replace$default(this.f418047d.g(), '_', '-', false, 4, null);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f418044a;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        return this.f418045b.U(r100);
    }

    public final void b(final long r100) {
        CustomDisplayPageListRequest.Builder r101 = new CustomDisplayPageListRequest.Builder();
        r101.offset = Long.valueOf(r100);
        r101.count = 50L;
        r101.locale = c();
        t4c.a.b(this.f418045b.a(r101).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()), this.f418048e, new CustomDisplayModule$batchUpdate$1(this, r100), CustomDisplayModule$batchUpdate$2.INSTANCE);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "onUserOffline");
        this.f418048e.dispose();
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "onUserOnline");
        if (w4c.c.a().Q() == true) goto L8;
        this.f418048e = new CompositeDisposable();
        if (w4c.c.a().A() == false) goto L9;
        b(0);
        long r101 = w4c.c.a().f();
        Disposable r102 = Observable.interval(r101, r101, TimeUnit.SECONDS).subscribe(new com.ss.android.lark.conditional.access.display.b(this));
        this.f418048e.add(r102);
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single v5(String r100) {
        Intrinsics.checkNotNullParameter("fixed:advanced_login:geo_restricted", "displayKey");
        Intrinsics.checkNotNullParameter(r100, "traceId");
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "getDisplayModelByRust, displayKey is fixed:advanced_login:geo_restricted");
        String r101 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r100, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r100);     // Catch: Throwable -> L7
        CustomDisplayModelByKeyRequest.Builder r102 = new CustomDisplayModelByKeyRequest.Builder();     // Catch: Throwable -> L7
        r102.key = "fixed:advanced_login:geo_restricted";     // Catch: Throwable -> L7
        Single<R> r103 = this.f418045b.c(r102).map(com.ss.android.lark.conditional.access.display.a.f418054a);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r101, "traceId");
        qqb.a.g(r101);
        return r103;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r101, "traceId");
        qqb.a.g(r101);
        throw th;
    L9:
        th = th;
        r101 = "";
        goto L11
    }

    public static final void a(CustomDisplayModule r100, List r101) {
        r100.getClass();
        if ((!r101.isEmpty()) == false) goto L11;
        i r102 = r100.f418046c;
        String r103 = r100.c();
        List r104 = r101;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(new CustomDisplayModel((CustomDisplayConfig) r106.next(), System.currentTimeMillis()));
        goto L6
    L8:
        r102.a(r103, r105);
        return;
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<? extends CustomDisplayConfig> Ld(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        int r102 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "getDisplayModelByRust, id is " + r100);
        String r103 = qqb.a.d();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r101, "traceId");     // Catch: Throwable -> L7
        qqb.a.g(r101);     // Catch: Throwable -> L7
        CustomDisplayModelRequest.Builder r104 = new CustomDisplayModelRequest.Builder();     // Catch: Throwable -> L7
        r104.f253756id = r100;     // Catch: Throwable -> L7
        Single r105 = this.f418045b.d(r104).map(b.f418049a);     // Catch: Throwable -> L7
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r103, "traceId");
        qqb.a.g(r103);
        return r105;
    L7:
        th = th;
    L11:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r103, "traceId");
        qqb.a.g(r103);
        throw th;
    L9:
        th = th;
        r103 = "";
        goto L11
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final void S5(List<String> r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, ids is " + r100 + ",  force is " + r110);
        if (w4c.c.a().Q() == false) goto L5;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, direct return");
    L5:
        if (r110 == true) goto L21;
        ArrayList r111 = new ArrayList();
        Iterator r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        Object r103 = r102.next();
        CustomDisplayModel r104 = this.f418046c.b(c(), (String) r103);
        if (r104 == null) goto L12;
        long r105 = r104.getLastUpdateTime();
    L14:
        if ((r105 + (w4c.c.a().f() * ((long) 1000))) >= System.currentTimeMillis()) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L8;
        r111.add(r103);
        goto L8
    L16:
        r106 = false;
        goto L17
    L12:
        r105 = 0;
        goto L14
    L19:
        r100 = r111;
    L21:
        if (r100.isEmpty() == false) goto L24;
        ScsLogger.d("SecurityPolicy_CustomDisplayModule", "tryUpdateDisplayModelByIds, needUpdateIds.isEmpty().");
        return;
    L24:
        CustomDisplayMGetRequest.Builder r112 = new CustomDisplayMGetRequest.Builder();
        r112.id_list = r100;
        r112.locale = c();
        t4c.a.b(this.f418045b.b(r112).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()), this.f418048e, new CustomDisplayModule$tryUpdateDisplayModelByIds$2(this), CustomDisplayModule$tryUpdateDisplayModelByIds$3.INSTANCE);
    }

    @Override // com.ss.android.lark.conditional.access.display.g
    public final Single<CustomDisplayModel> ye(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "traceId");
        String r100 = qqb.a.d();     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r111, "traceId");     // Catch: Throwable -> L17
        qqb.a.g(r111);     // Catch: Throwable -> L17
        CustomDisplayModel r112 = this.f418046c.b(c(), r110);     // Catch: Throwable -> L17
        if (r112 != null) goto L8;
        FileAuthMonitor.UpdateTrigger[] r113 = FileAuthMonitor.f418450a;     // Catch: Throwable -> L17
        String r114 = u4c.a.f548750a;     // Catch: Throwable -> L17
        u4c.a.a("scs_security_policy_custom_display", MapsKt.mapOf(TuplesKt.to("hitCache", Boolean.FALSE)), null, null, 0, 28);     // Catch: Throwable -> L17
        CustomDisplayMGetRequest.Builder r115 = new CustomDisplayMGetRequest.Builder();     // Catch: Throwable -> L17
        r115.id_list = CollectionsKt.listOf(r110);     // Catch: Throwable -> L17
        r115.locale = c();     // Catch: Throwable -> L17
        Single r116 = this.f418045b.b(r115).doOnSuccess(new c(this)).flatMap(new d(r110));     // Catch: Throwable -> L17
    L15:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        qqb.a.g(r100);
        return r116;
    L8:
        if ((r112.getLastUpdateTime() + (w4c.c.a().f() * ((long) 1000))) >= System.currentTimeMillis()) goto L14;
        CustomDisplayConfig r117 = r112.getConfig();     // Catch: Throwable -> L17
        if (r117 == null) goto L14;
        String r118 = r117.f253753id;     // Catch: Throwable -> L17
        if (r118 == null) goto L14;
        S5(CollectionsKt.listOf(r118), true);     // Catch: Throwable -> L17
    L14:
        FileAuthMonitor.UpdateTrigger[] r119 = FileAuthMonitor.f418450a;     // Catch: Throwable -> L17
        String r120 = u4c.a.f548750a;     // Catch: Throwable -> L17
        u4c.a.a("scs_security_policy_custom_display", MapsKt.mapOf(TuplesKt.to("hitCache", Boolean.TRUE)), null, null, 0, 28);     // Catch: Throwable -> L17
        r116 = Single.just(r112);     // Catch: Throwable -> L17
    L17:
        th = th;
    L23:
        qqb.a.a();
        Intrinsics.checkNotNullParameter(r100, "traceId");
        qqb.a.g(r100);
        throw th;
    L21:
        th = th;
        r100 = "";
        goto L23
    }

    @Inject
    public CustomDisplayModule(m r100, h r101, i r102, apb.a r103) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "networkRepository");
        Intrinsics.checkNotNullParameter(r102, "storage");
        Intrinsics.checkNotNullParameter(r103, "languageService");
        this.f418044a = r100;
        this.f418045b = r101;
        this.f418046c = r102;
        this.f418047d = r103;
        s.a(this);
        this.f418048e = new CompositeDisposable();
    }
}

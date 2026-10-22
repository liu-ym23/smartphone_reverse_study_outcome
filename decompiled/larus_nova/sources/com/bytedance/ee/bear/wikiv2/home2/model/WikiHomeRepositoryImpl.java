package com.bytedance.ee.bear.wikiv2.home2.model;

import android.app.Application;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.wikiv2.home.api.GetSpaceClassificationPuller;
import com.bytedance.ee.bear.wikiv2.home.api.GetSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.GetStarSpacePuller;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.StarSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.UnStarSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.g0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yq5.j0;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiHomeRepositoryImpl implements com.bytedance.ee.bear.wikiv2.home2.model.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f240856e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ce5.a f240857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WikiSpacesResp f240858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WikiSpacesResp f240859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f240860d;

    public static final class a {
        public static ml5.a a() {
            int r100 = woc.a.f560539a;
            Application r101 = LarkContext.getApplication();
            Intrinsics.checkNotNullParameter(r101, "app");
            return new ml5.a(((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid() + "preference_wiki_space_filter", LarkKVStorage.e(r101, "lark"));
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f240861a = null;

        static {
            f240861a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Boolean) r100, "it");
            return zp5.a.d(WikiDatabase.c().f().a(2, "all", "all"));
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f240862a = null;

        static {
            f240862a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Throwable) r100, "it");
            return CollectionsKt.emptyList();
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T, R> f240863a = null;

        static {
            f240863a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (r101.isEmpty() == true) goto L7;
            WikiSpaceFilterInfo.Companion.getClass();
            return Flowable.just(new WikiSpacesResp(WikiSpaceFilterInfo.access$getNoFilterInfo$cp(), r101, false, null, WikiSpacesResp.Origin.Cache));
        L7:
            return Flowable.empty();
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240864a;

        public e(WikiHomeRepositoryImpl r100) {
            this.f240864a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            WikiSpaceFilterInfo r101 = (WikiSpaceFilterInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            this.f240864a.getClass();
            tt5.a.h("WikiHomeRepositoryImpl", "getCacheRecentWikiSpace.");
            WikiSpaceFilter r102 = r101.getFilterValue();
            return Flowable.concat(Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new com.bytedance.ee.bear.wikiv2.home2.model.c(r102)).onErrorReturn(com.bytedance.ee.bear.wikiv2.home2.model.d.f240926a).flatMap(new com.bytedance.ee.bear.wikiv2.home2.model.e(r101)).observeOn(fo5.d.d()), this.f240864a.m(r101));
        }
    }

    public static final class f<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240865a;

        public f(WikiHomeRepositoryImpl r100) {
            this.f240865a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f240865a.f240858b = (WikiSpacesResp) r100;
            return r100;
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240866a;

        public g(WikiHomeRepositoryImpl r100) {
            this.f240866a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f240866a.f240859c = (WikiSpacesResp) r100;
            return r100;
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240867a;

        public h(WikiHomeRepositoryImpl r100) {
            this.f240867a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f240867a.f240858b = (WikiSpacesResp) r100;
            return r100;
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240868a;

        public i(WikiHomeRepositoryImpl r100) {
            this.f240868a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f240868a.f240858b = (WikiSpacesResp) r100;
            return r100;
        }
    }

    public static final class j<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f240869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceFilter f240870b;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f240871a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f240872b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ WikiSpaceFilter f240873c;

            public a(Object r100, String r101, WikiSpaceFilter r102) {
                this.f240871a = r100;
                this.f240872b = r101;
                this.f240873c = r102;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                List<SpaceBean> r100 = ((WikiSpacesResp) this.f240871a).f240918b;
                if (r100 == null) goto L5;
                List<yq5.d> r101 = zp5.a.b(r100);
            L7:
                if (this.f240872b != null) goto L14;
                yq5.b0 r102 = WikiDatabase.c().f();
                String r103 = this.f240873c.getSpaceTypeId();
                String r104 = this.f240873c.getSpaceClassId();
                j0 r105 = (j0) r102;
                r105.f568827a.beginTransaction();
                j0.d(r105, r101, 1, r103, r104);     // Catch: Throwable -> L11
                r105.f568827a.setTransactionSuccessful();     // Catch: Throwable -> L11
                r105.f568827a.endTransaction();
                return;
            L11:
                th = move-exception;
                r105.f568827a.endTransaction();
                throw th;
            L14:
                WikiDatabase.c().f().b(r101, 1, this.f240873c.getSpaceTypeId(), this.f240873c.getSpaceClassId());
                return;
            L5:
                r101 = CollectionsKt.emptyList();
                goto L7
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public j(String r100, WikiSpaceFilter r101) {
            this.f240869a = r100;
            this.f240870b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Flowable.fromCallable(new a(r100, this.f240869a, this.f240870b)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.f551051a);
            return r100;
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceFilterInfo f240874a;

        public k(WikiSpaceFilterInfo r100) {
            this.f240874a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            GetSpacePuller.Result r101 = (GetSpacePuller.Result) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return new WikiSpacesResp(this.f240874a, r101.spaces, r101.has_more, r101.last_label, WikiSpacesResp.Origin.Network);
        }
    }

    public static final class l<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceFilterInfo f240875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240876b;

        public l(WikiSpaceFilterInfo r100, WikiHomeRepositoryImpl r101) {
            this.f240875a = r100;
            this.f240876b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            WikiSpaceFilterInfo r101 = (WikiSpaceFilterInfo) r100;
            Intrinsics.checkNotNullParameter(r101, "networkFilterInfo");
            if (r101.isFilterOptionContainFilterWith(this.f240875a) == false) goto L5;
            WikiSpaceFilter r102 = this.f240875a.getFilterValue();
        L6:
            WikiSpaceFilterInfo r103 = new WikiSpaceFilterInfo(r102, r101.getFilterOption(), false, 4, null);
            return this.f240876b.l(r103, null).map(new com.bytedance.ee.bear.wikiv2.home2.model.j(this.f240876b));
        L5:
            this.f240876b.i(r101.getFilterValue()).onErrorReturn(com.bytedance.ee.bear.wikiv2.home2.model.k.f240935a).subscribe();
            r102 = r101.getFilterValue();
            goto L6
        }
    }

    public static final class m<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f240877a;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f240878a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f240879b;

            public a(Object r100, String r101) {
                this.f240878a = r100;
                this.f240879b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                List<SpaceBean> r100 = ((WikiSpacesResp) this.f240878a).f240918b;
                if (r100 == null) goto L5;
                List<yq5.d> r101 = zp5.a.b(r100);
            L7:
                if (this.f240879b != null) goto L14;
                j0 r102 = (j0) WikiDatabase.c().f();
                r102.f568827a.beginTransaction();
                j0.d(r102, r101, 2, "all", "all");     // Catch: Throwable -> L11
                r102.f568827a.setTransactionSuccessful();     // Catch: Throwable -> L11
                r102.f568827a.endTransaction();
                return;
            L11:
                th = move-exception;
                r102.f568827a.endTransaction();
                throw th;
            L14:
                WikiDatabase.c().f().b(r101, 2, "all", "all");
                return;
            L5:
                r101 = CollectionsKt.emptyList();
                goto L7
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public m(String r100) {
            this.f240877a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Flowable.fromCallable(new a(r100, this.f240877a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.f551051a);
            return r100;
        }
    }

    public static final class n<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n<T, R> f240880a = null;

        static {
            f240880a = new n();
        }

        public n() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            GetStarSpacePuller.Result r101 = (GetStarSpacePuller.Result) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            WikiSpaceFilterInfo.Companion.getClass();
            return new WikiSpacesResp(WikiSpaceFilterInfo.access$getNoFilterInfo$cp(), r101.spaces, r101.has_more, r101.last_label, WikiSpacesResp.Origin.Network);
        }
    }

    public static final class o<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WikiHomeRepositoryImpl f240881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WikiSpaceFilter f240882b;

        public o(WikiHomeRepositoryImpl r100, WikiSpaceFilter r101) {
            this.f240881a = r100;
            this.f240882b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Boolean) r100, "it");
            WikiHomeRepositoryImpl.j(this.f240881a).b("space_type", this.f240882b.getSpaceTypeId());
            WikiHomeRepositoryImpl.j(this.f240881a).b("space_class_id", this.f240882b.getSpaceClassId());
            return Boolean.TRUE;
        }
    }

    public static final class p<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f240883a;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f240884a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f240885b;

            public a(Object r100, String r101) {
                this.f240884a = r100;
                this.f240885b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Boolean r100 = (Boolean) this.f240884a;
                WikiDatabase.c().f().c(this.f240885b, true);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public p(String r100) {
            this.f240883a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Flowable.fromCallable(new a(r100, this.f240883a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.f551051a);
            return r100;
        }
    }

    public static final class q<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f240886a;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f240887a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f240888b;

            public a(Object r100, String r101) {
                this.f240887a = r100;
                this.f240888b = r101;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Boolean r100 = (Boolean) this.f240887a;
                WikiDatabase.c().f().c(this.f240888b, false);
                yq5.b0 r101 = WikiDatabase.c().f();
                String r102 = this.f240888b;
                j0 r103 = (j0) r101;
                r103.f568827a.assertNotSuspendingTransaction();
                SupportSQLiteStatement r104 = r103.f568832f.acquire();
                r104.bindLong(1, 2);
                if (r102 != null) goto L5;
                r104.bindNull(2);
            L6:
                r103.f568827a.beginTransaction();
                r104.executeUpdateDelete();     // Catch: Throwable -> L10
                r103.f568827a.setTransactionSuccessful();     // Catch: Throwable -> L10
                r103.f568827a.endTransaction();
                r103.f568832f.release(r104);
                return;
            L10:
                th = move-exception;
                r103.f568827a.endTransaction();
                r103.f568832f.release(r104);
                throw th;
            L5:
                r104.bindString(2, r102);
                goto L6
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public q(String r100) {
            this.f240886a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final T apply(T r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Flowable.fromCallable(new a(r100, this.f240886a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.f551051a);
            return r100;
        }
    }

    static {
    }

    public static Flowable k() {
        tt5.a.h("WikiHomeRepositoryImpl", "getCacheStarWikiSpace.");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(b.f240861a).onErrorReturn(c.f240862a).flatMap(d.f240863a).observeOn(fo5.d.d());
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> a() {
        WikiSpacesResp r100 = this.f240859c;
        if (r100 == null) goto L6;
        WikiSpaceFilterInfo r101 = r100.f240917a;
        if (r101 == null) goto L6;
    L8:
        return m(r101);
    L6:
        WikiSpaceFilterInfo.Companion.getClass();
        r101 = WikiSpaceFilterInfo.access$getNoFilterInfo$cp();
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> b() {
        WikiSpacesResp r100 = this.f240859c;
        if (r100 != null) goto L6;
        Flowable<WikiSpacesResp> r101 = Flowable.error(new Throwable("getMoreRecentSpace, lastResp is null."));
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        return l(r100.f240917a, r100.f240920d).map(new g(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> c() {
        return n(this.f240857a.f23448c, null).map(new i(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> e() {
        WikiSpacesResp r100 = this.f240858b;
        if (r100 != null) goto L6;
        Flowable<WikiSpacesResp> r101 = Flowable.error(new Throwable("getMoreStarSpace, lastResp is null."));
        Intrinsics.checkNotNull(r101);
        return r101;
    L6:
        return n(this.f240857a.f23448c, r100.f240920d).map(new h(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> g() {
        tt5.a.h("WikiHomeRepositoryImpl", "getCacheFilterInfo.");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new com.bytedance.ee.bear.wikiv2.home2.model.b(this)).flatMap(new e(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> f() {
        return Flowable.concat(k(), n(this.f240857a.f23448c, null).map(new f(this)));
    }

    public WikiHomeRepositoryImpl(ce5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "userComponentAbility");
        this.f240857a = r100;
        this.f240860d = LazyKt.lazy(WikiHomeRepositoryImpl$filterPreference$2.INSTANCE);
    }

    public static final ml5.a j(WikiHomeRepositoryImpl r100) {
        return (ml5.a) r100.f240860d.getValue();
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        return new UnStarSpacePuller(this.f240857a.f23448c).c(new UnStarSpacePuller.Params(r100)).map(new t()).map(new q(r100));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        return new StarSpacePuller(this.f240857a.f23448c).c(new StarSpacePuller.Params(r100)).map(new g0()).map(new p(r100));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> i(WikiSpaceFilter r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new o(this, r100));
    }

    public final Flowable<WikiSpacesResp> m(WikiSpaceFilterInfo r100) {
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkFilterInfo.");
        Flowable r101 = Flowable.fromCallable(com.bytedance.ee.bear.wikiv2.home2.model.i.f240933a);
        boolean r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a.f("ccm.wiki.mobile.space_classification_enable");
        tt5.a.h("WikiFGHelperV2", "isWikiClassificationEnable: " + r102);
        if (r102 == false) goto L5;
        Flowable r103 = new GetSpaceClassificationPuller(this.f240857a.f23448c).d(new GetSpaceClassificationPuller.Params(true)).map(com.bytedance.ee.bear.wikiv2.home2.model.h.f240932a);
        Intrinsics.checkNotNull(r103);
    L7:
        return Flowable.zip(r101, r103, com.bytedance.ee.bear.wikiv2.home2.model.g.f240931a).map(new com.bytedance.ee.bear.wikiv2.home2.model.f(this)).flatMap(new l(r100, this));
    L5:
        r103 = Flowable.just(CollectionsKt.emptyList());
        Intrinsics.checkNotNull(r103);
        goto L7
    }

    public static Flowable n(NetService r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "netService");
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkStarWikiSpace.");
        GetStarSpacePuller.Params r102 = new GetStarSpacePuller.Params();
        r102.size = 100;
        r102.last_label = r101;
        return new GetStarSpacePuller(r100).d(r102).map(n.f240880a).map(new m(r101));
    }

    public final Flowable<WikiSpacesResp> l(WikiSpaceFilterInfo r100, String r101) {
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkRecentWikiSpace.");
        WikiSpaceFilter r102 = r100.getFilterValue();
        GetSpacePuller.Params r103 = new GetSpacePuller.Params();
        String r104 = r102.getSpaceTypeId();
        String r105 = null;
        if (Intrinsics.areEqual(r104, WikiSpaceType.TEAM) == false) goto L6;
        Integer r106 = 0;
    L9:
        r103.type = r106;
        r103.size = 50;
        r103.last_label = r101;
        if (Intrinsics.areEqual(r102.getSpaceClassId(), "all") == true) goto L12;
        r105 = r102.getSpaceClassId();
    L12:
        r103.space_class_id = r105;
        return new GetSpacePuller(this.f240857a.f23448c).d(r103).map(new k(r100)).map(new j(r101, r102));
    L6:
        if (Intrinsics.areEqual(r104, WikiSpaceType.PERSONAL) == false) goto L8;
        r106 = 1;
        goto L9
    L8:
        r106 = null;
        goto L9
    }
}

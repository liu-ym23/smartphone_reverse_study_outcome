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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiHomeRepositoryImpl implements com.bytedance.ee.bear.wikiv2.home2.model.a {
    public static final /* synthetic */ int e = 0;
    public final ce5.a a;
    public WikiSpacesResp b;
    public WikiSpacesResp c;
    public final Lazy d;

    public static final class a {
        public static ml5.a a() {
            int r0 = woc.a.a;
            Application r1 = LarkContext.getApplication();
            Intrinsics.checkNotNullParameter(r1, "app");
            return new ml5.a(((b0) org.koin.java.a.c(b0.class, null, null, 6)).getUid() + "preference_wiki_space_filter", LarkKVStorage.e(r1, "lark"));
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((Boolean) r3, "it");
            return zp5.a.d(WikiDatabase.c().f().a(2, "all", "all"));
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "it");
            return CollectionsKt.emptyList();
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r7) {
            List r2 = (List) r7;
            Intrinsics.checkNotNullParameter(r2, "it");
            if (r2.isEmpty() == true) goto L7;
            WikiSpaceFilterInfo.Companion.getClass();
            return Flowable.just(new WikiSpacesResp(WikiSpaceFilterInfo.access$getNoFilterInfo$cp(), r2, false, null, WikiSpacesResp.Origin.Cache));
        L7:
            return Flowable.empty();
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;

        public e(WikiHomeRepositoryImpl r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            WikiSpaceFilterInfo r5 = (WikiSpaceFilterInfo) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            this.a.getClass();
            tt5.a.h("WikiHomeRepositoryImpl", "getCacheRecentWikiSpace.");
            WikiSpaceFilter r0 = r5.getFilterValue();
            return Flowable.concat(Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new com.bytedance.ee.bear.wikiv2.home2.model.c(r0)).onErrorReturn(com.bytedance.ee.bear.wikiv2.home2.model.d.a).flatMap(new com.bytedance.ee.bear.wikiv2.home2.model.e(r5)).observeOn(fo5.d.d()), this.a.m(r5));
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;

        public f(WikiHomeRepositoryImpl r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T apply(T r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.b = (WikiSpacesResp) r3;
            return r3;
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;

        public g(WikiHomeRepositoryImpl r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T apply(T r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.c = (WikiSpacesResp) r3;
            return r3;
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;

        public h(WikiHomeRepositoryImpl r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T apply(T r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.b = (WikiSpacesResp) r3;
            return r3;
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;

        public i(WikiHomeRepositoryImpl r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T apply(T r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            this.a.b = (WikiSpacesResp) r3;
            return r3;
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ WikiSpaceFilter b;

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ String b;
            public final /* synthetic */ WikiSpaceFilter c;

            public a(Object r1, String r2, WikiSpaceFilter r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                List<SpaceBean> r0 = ((WikiSpacesResp) this.a).b;
                if (r0 == null) goto L5;
                List<yq5.d> r1 = zp5.a.b(r0);
            L7:
                if (this.b != null) goto L14;
                yq5.b0 r2 = WikiDatabase.c().f();
                String r3 = this.c.getSpaceTypeId();
                String r4 = this.c.getSpaceClassId();
                j0 r5 = (j0) r2;
                r5.a.beginTransaction();
                j0.d(r5, r1, 1, r3, r4);     // Catch: Throwable -> L11
                r5.a.setTransactionSuccessful();     // Catch: Throwable -> L11
                r5.a.endTransaction();
                return;
            L11:
                th = move-exception;
                r5.a.endTransaction();
                throw th;
            L14:
                WikiDatabase.c().f().b(r1, 1, this.c.getSpaceTypeId(), this.c.getSpaceClassId());
                return;
            L5:
                r1 = CollectionsKt.emptyList();
                goto L7
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public j(String r1, WikiSpaceFilter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4, this.a, this.b)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ WikiSpaceFilterInfo a;

        public k(WikiSpaceFilterInfo r1) {
            this.a = r1;
        }

        public final Object apply(Object r8) {
            GetSpacePuller.Result r9 = (GetSpacePuller.Result) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            return new WikiSpacesResp(this.a, r9.spaces, r9.has_more, r9.last_label, WikiSpacesResp.Origin.Network);
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ WikiSpaceFilterInfo a;
        public final /* synthetic */ WikiHomeRepositoryImpl b;

        public l(WikiSpaceFilterInfo r1, WikiHomeRepositoryImpl r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r8) {
            WikiSpaceFilterInfo r9 = (WikiSpaceFilterInfo) r8;
            Intrinsics.checkNotNullParameter(r9, "networkFilterInfo");
            if (r9.isFilterOptionContainFilterWith(this.a) == false) goto L5;
            WikiSpaceFilter r0 = this.a.getFilterValue();
        L6:
            WikiSpaceFilterInfo r1 = new WikiSpaceFilterInfo(r0, r9.getFilterOption(), false, 4, null);
            return this.b.l(r1, null).map(new com.bytedance.ee.bear.wikiv2.home2.model.j(this.b));
        L5:
            this.b.i(r9.getFilterValue()).onErrorReturn(com.bytedance.ee.bear.wikiv2.home2.model.k.a).subscribe();
            r0 = r9.getFilterValue();
            goto L6
        }
    }

    public static final class m<T, R> implements Function {
        public final /* synthetic */ String a;

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ String b;

            public a(Object r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                List<SpaceBean> r0 = ((WikiSpacesResp) this.a).b;
                if (r0 == null) goto L5;
                List<yq5.d> r1 = zp5.a.b(r0);
            L7:
                if (this.b != null) goto L14;
                j0 r2 = (j0) WikiDatabase.c().f();
                r2.a.beginTransaction();
                j0.d(r2, r1, 2, "all", "all");     // Catch: Throwable -> L11
                r2.a.setTransactionSuccessful();     // Catch: Throwable -> L11
                r2.a.endTransaction();
                return;
            L11:
                th = move-exception;
                r2.a.endTransaction();
                throw th;
            L14:
                WikiDatabase.c().f().b(r1, 2, "all", "all");
                return;
            L5:
                r1 = CollectionsKt.emptyList();
                goto L7
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public m(String r1) {
            this.a = r1;
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4, this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class n<T, R> implements Function {
        public static final n<T, R> a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final Object apply(Object r8) {
            GetStarSpacePuller.Result r9 = (GetStarSpacePuller.Result) r8;
            Intrinsics.checkNotNullParameter(r9, "it");
            WikiSpaceFilterInfo.Companion.getClass();
            return new WikiSpacesResp(WikiSpaceFilterInfo.access$getNoFilterInfo$cp(), r9.spaces, r9.has_more, r9.last_label, WikiSpacesResp.Origin.Network);
        }
    }

    public static final class o<T, R> implements Function {
        public final /* synthetic */ WikiHomeRepositoryImpl a;
        public final /* synthetic */ WikiSpaceFilter b;

        public o(WikiHomeRepositoryImpl r1, WikiSpaceFilter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((Boolean) r3, "it");
            WikiHomeRepositoryImpl.j(this.a).b("space_type", this.b.getSpaceTypeId());
            WikiHomeRepositoryImpl.j(this.a).b("space_class_id", this.b.getSpaceClassId());
            return Boolean.TRUE;
        }
    }

    public static final class p<T, R> implements Function {
        public final /* synthetic */ String a;

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ String b;

            public a(Object r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Boolean r0 = (Boolean) this.a;
                WikiDatabase.c().f().c(this.b, true);
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public p(String r1) {
            this.a = r1;
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4, this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class q<T, R> implements Function {
        public final /* synthetic */ String a;

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ String b;

            public a(Object r1, String r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Boolean r0 = (Boolean) this.a;
                WikiDatabase.c().f().c(this.b, false);
                yq5.b0 r1 = WikiDatabase.c().f();
                String r2 = this.b;
                j0 r3 = (j0) r1;
                r3.a.assertNotSuspendingTransaction();
                SupportSQLiteStatement r4 = r3.f.acquire();
                r4.bindLong(1, 2);
                if (r2 != null) goto L5;
                r4.bindNull(2);
            L6:
                r3.a.beginTransaction();
                r4.executeUpdateDelete();     // Catch: Throwable -> L10
                r3.a.setTransactionSuccessful();     // Catch: Throwable -> L10
                r3.a.endTransaction();
                r3.f.release(r4);
                return;
            L10:
                th = move-exception;
                r3.a.endTransaction();
                r3.f.release(r4);
                throw th;
            L5:
                r4.bindString(2, r2);
                goto L6
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public q(String r1) {
            this.a = r1;
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4, this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    static {
    }

    public static Flowable k() {
        tt5.a.h("WikiHomeRepositoryImpl", "getCacheStarWikiSpace.");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(b.a).onErrorReturn(c.a).flatMap(d.a).observeOn(fo5.d.d());
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> a() {
        WikiSpacesResp r0 = this.c;
        if (r0 == null) goto L6;
        WikiSpaceFilterInfo r1 = r0.a;
        if (r1 == null) goto L6;
    L8:
        return m(r1);
    L6:
        WikiSpaceFilterInfo.Companion.getClass();
        r1 = WikiSpaceFilterInfo.access$getNoFilterInfo$cp();
        goto L8
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> b() {
        WikiSpacesResp r0 = this.c;
        if (r0 != null) goto L6;
        Flowable<WikiSpacesResp> r1 = Flowable.error(new Throwable("getMoreRecentSpace, lastResp is null."));
        Intrinsics.checkNotNull(r1);
        return r1;
    L6:
        return l(r0.a, r0.d).map(new g(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> c() {
        return n(this.a.c, null).map(new i(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> e() {
        WikiSpacesResp r0 = this.b;
        if (r0 != null) goto L6;
        Flowable<WikiSpacesResp> r1 = Flowable.error(new Throwable("getMoreStarSpace, lastResp is null."));
        Intrinsics.checkNotNull(r1);
        return r1;
    L6:
        return n(this.a.c, r0.d).map(new h(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> g() {
        tt5.a.h("WikiHomeRepositoryImpl", "getCacheFilterInfo.");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new com.bytedance.ee.bear.wikiv2.home2.model.b(this)).flatMap(new e(this));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<WikiSpacesResp> f() {
        return Flowable.concat(k(), n(this.a.c, null).map(new f(this)));
    }

    public WikiHomeRepositoryImpl(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        this.a = r2;
        this.d = LazyKt.lazy(WikiHomeRepositoryImpl$filterPreference$2.INSTANCE);
    }

    public static final ml5.a j(WikiHomeRepositoryImpl r0) {
        return (ml5.a) r0.d.getValue();
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        return new UnStarSpacePuller(this.a.c).c(new UnStarSpacePuller.Params(r3)).map(new t()).map(new q(r3));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> h(String r3) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        return new StarSpacePuller(this.a.c).c(new StarSpacePuller.Params(r3)).map(new g0()).map(new p(r3));
    }

    @Override // com.bytedance.ee.bear.wikiv2.home2.model.a
    public final Flowable<Boolean> i(WikiSpaceFilter r3) {
        Intrinsics.checkNotNullParameter(r3, "filter");
        return Flowable.just(Boolean.TRUE).observeOn(fo5.d.c()).map(new o(this, r3));
    }

    public final Flowable<WikiSpacesResp> m(WikiSpaceFilterInfo r5) {
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkFilterInfo.");
        Flowable r0 = Flowable.fromCallable(com.bytedance.ee.bear.wikiv2.home2.model.i.a);
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.f("ccm.wiki.mobile.space_classification_enable");
        tt5.a.h("WikiFGHelperV2", "isWikiClassificationEnable: " + r1);
        if (r1 == false) goto L5;
        Flowable r2 = new GetSpaceClassificationPuller(this.a.c).d(new GetSpaceClassificationPuller.Params(true)).map(com.bytedance.ee.bear.wikiv2.home2.model.h.a);
        Intrinsics.checkNotNull(r2);
    L7:
        return Flowable.zip(r0, r2, com.bytedance.ee.bear.wikiv2.home2.model.g.a).map(new com.bytedance.ee.bear.wikiv2.home2.model.f(this)).flatMap(new l(r5, this));
    L5:
        r2 = Flowable.just(CollectionsKt.emptyList());
        Intrinsics.checkNotNull(r2);
        goto L7
    }

    public static Flowable n(NetService r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkStarWikiSpace.");
        GetStarSpacePuller.Params r0 = new GetStarSpacePuller.Params();
        r0.size = 100;
        r0.last_label = r3;
        return new GetStarSpacePuller(r2).d(r0).map(n.a).map(new m(r3));
    }

    public final Flowable<WikiSpacesResp> l(WikiSpaceFilterInfo r6, String r7) {
        tt5.a.h("WikiHomeRepositoryImpl", "getNetworkRecentWikiSpace.");
        WikiSpaceFilter r0 = r6.getFilterValue();
        GetSpacePuller.Params r1 = new GetSpacePuller.Params();
        String r2 = r0.getSpaceTypeId();
        String r4 = null;
        if (Intrinsics.areEqual(r2, WikiSpaceType.TEAM) == false) goto L6;
        Integer r3 = 0;
    L9:
        r1.type = r3;
        r1.size = 50;
        r1.last_label = r7;
        if (Intrinsics.areEqual(r0.getSpaceClassId(), "all") == true) goto L12;
        r4 = r0.getSpaceClassId();
    L12:
        r1.space_class_id = r4;
        return new GetSpacePuller(this.a.c).d(r1).map(new k(r6)).map(new j(r7, r0));
    L6:
        if (Intrinsics.areEqual(r2, WikiSpaceType.PERSONAL) == false) goto L8;
        r3 = 1;
        goto L9
    L8:
        r3 = null;
        goto L9
    }
}

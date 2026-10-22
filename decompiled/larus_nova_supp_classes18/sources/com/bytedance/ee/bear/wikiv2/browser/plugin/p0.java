package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.WikiBrowseReportPuller;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            tt5.a.h("WikiRepository", "browseReport success");
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            tt5.a.d("WikiRepository", "browseReport err. " + ((Throwable) r3));
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;
            public final /* synthetic */ ce5.a b;

            public a(Object r1, ce5.a r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                up5.b r0 = (up5.b) this.a;
                int r1 = p0.a;
                p0.a(this.b, (WikiInfo) r0.a());
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public c(ce5.a r1) {
            this.a = r1;
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4, this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r3) {
            NetService.ServerErrorException r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.k("WikiRepository", "Wiki info rsp err:" + r4.getMessage());
            WikiInfo r0 = new WikiInfo();
            if ((r4 instanceof NetService.ServerErrorException) == false) goto L5;
            r0.setCode(r4.getCode());
        L6:
            return r0;
        L5:
            r0.setCode(-8011);
            goto L6
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r2) {
            WikiInfo r3 = (WikiInfo) r2;
            Intrinsics.checkNotNullParameter(r3, "wikiInfo");
            r3.setWikiToken(this.a);
            r3.log_id = this.b;
            return new up5.b(r3);
        }
    }

    public static final class f<T extends com.bytedance.ee.bear.contract.Result> implements NetService.c {
        public static final f<T> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final com.bytedance.ee.bear.contract.Result parse(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            tt5.a.b("WikiRepository", "networkWikiInfoFlow WikiInfo: " + r4);
            WikiInfo r0 = (WikiInfo) JSON.parseObject(r4, WikiInfo.class);
            JSONObject r5 = new JSONObject(r4).optJSONObject(WikiFolderPushPlugin.DATA);
            if (r5 == null) goto L5;
            boolean r6 = r5.optBoolean("is_wiki");
        L6:
            r0.setInSpace(!r6);
            return r0;
        L5:
            r6 = true;
            goto L6
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ String b;

        public g(ce5.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            up5.b r5 = (up5.b) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            if (r5.b() == true) goto L6;
            return Flowable.just(r5);
        L6:
            return Flowable.just("").map(new i(this.a, this.b));
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ String b;

        public h(ce5.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            up5.b r5 = (up5.b) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            if (r5.b() == true) goto L6;
            return Flowable.just(r5);
        L6:
            return Flowable.just("").observeOn(fo5.d.c()).map(new j(this.a, this.b));
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ String b;

        public i(ce5.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            WikiInfo r4 = p0.g(this.a, this.b);
            tt5.a.b("WikiRepository", "readMemoryCachedWikiInfoFlow success:" + r4);
            return new up5.b(r4);
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ String b;

        public j(ce5.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            WikiInfo r4 = p0.e(this.a, this.b, true);
            tt5.a.b("WikiRepository", "readDiskCachedWikiInfoFlow success:" + r4);
            return new up5.b(r4);
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ boolean b;

        public k(ce5.a r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            up5.b r7 = (up5.b) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            if (this.a.d.isCurrentEnable("ccm.mobile.doc_upgrade_to_docx_v2") == false) goto L35;
            boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
            boolean r2 = true;
            if (r7.b() == true) goto L17;
            if (r0 == false) goto L17;
            WikiInfo r1 = (WikiInfo) r7.a();
            if (r1 != null) goto L11;
        L13:
            boolean r3 = false;
        L14:
            if (r3 == false) goto L17;
            int r8 = up5.b.b;
            return up5.b.a.a();
        L11:
            if (r1.getObjType() != sbb.e.g.b) goto L13;
            r3 = true;
        L17:
            if (this.b == true) goto L19;
            return r7;
        L19:
            if (r7.b() == true) goto L32;
            if (r0 == false) goto L33;
            WikiInfo r4 = (WikiInfo) r7.a();
            if (r4 != null) goto L24;
        L26:
            r2 = false;
        L27:
            if (r2 == false) goto L34;
            int r9 = up5.b.b;
            return up5.b.a.a();
        L34:
            return r7;
        L24:
            if (r4.getObjType() != sbb.e.o.b) goto L26;
        L33:
            return r7;
        L32:
            return r7;
        L35:
            return r7;
        }
    }

    public static final class l<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ String b;

        public l(ce5.a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            up5.b r4 = (up5.b) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            if (r4.b() == false) goto L7;
            tt5.a.h("WikiRepository", "No wiki info cache or read err,will load from network");
            int r5 = p0.a;
            return p0.c(this.a, this.b, false).map(m.a);
        L7:
            return Flowable.just(r4);
        }
    }

    public static final class m<T, R> implements Function {
        public static final m<T, R> a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final Object apply(Object r5) {
            up5.b r6 = (up5.b) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            bn4.a r0 = (bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6);
            if (r0.b() == true) goto L15;
        L14:
            return r6;
        L15:
            kotlin.Result.Companion r1 = kotlin.Result.Companion;     // Catch: Throwable -> L9
            WikiInfo r2 = (WikiInfo) r6.a();     // Catch: Throwable -> L9
            if (r2.getObjType() != 8) goto L7;
            r0.q(r2.getObjToken());     // Catch: Throwable -> L9
        L7:
            Object r3 = kotlin.Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            Throwable r4 = kotlin.Result.exceptionOrNull-impl(r3);
            if (r4 == null) goto L14;
            tt5.a.e("WikiRepository", "Failed to preload bitable app info", r4, false);
        L9:
            th = move-exception;
            kotlin.Result.Companion r7 = kotlin.Result.Companion;
            r3 = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    static {
    }

    public p0() {
    }

    public static String h(AccountService.Account r2) {
        return r2.tenantId + '_' + r2.uid + "_WIKI_INFO";
    }

    public static final void a(ce5.a r10, WikiInfo r11) {
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r11.isValid() == true) goto L5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        k25.e0.m().j(r11.getWikiToken());
        tt5.a.b("WikiRepository", "writeCachedWikiInfo, invalid wikiInfo, delete res:" + r11);
        return;
    L5:
        Intrinsics.checkNotNull(r0);
        String r1 = h(r0);
        t45.c r3 = s45.p.a();
        sbb.e r6 = sbb.e.n;
        String r4 = r3.ua(r6.getType(), r11.getWikiToken(), "");
        k25.m0 r7 = new k25.m0();
        r7.b = r1;
        r7.c = JSON.toJSONString(r11);
        r7.k = r11.getWikiToken();
        r7.n = r4;
        r7.e = Long.valueOf(System.currentTimeMillis());
        r7.v = 1;
        r7.i = r6.getType();
        tt5.a.b("WikiRepository", "writeCachedWikiInfoFlow res:" + r7);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (((Long) k25.e0.m().w(r7).first).longValue() <= 0) goto L8;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).j(r11.getWikiToken());
        return;
    L8:
        tt5.a.d("WikiRepository", "Write resource data err !");
    }

    @JvmStatic
    public static final void b(String r1, ce5.a r2) {
        if (r2 == null) goto L9;
        NetService r3 = r2.c;
        if (r3 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L11;
        new WikiBrowseReportPuller(r3).c(new WikiBrowseReportPuller.Params(r1)).map(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.f0()).subscribe(a.a, b.a);
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final WikiInfo g(ce5.a r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.WIKI_TOKEN);
        return e(r1, r2, false);
    }

    @JvmStatic
    public static final Flowable<WikiInfo> i(ce5.a r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        Flowable r4 = f(r2, r3, null, false).flatMap(new l(r2, r3)).map(new s0());
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return r4.map(up5.c.a);
    }

    public static Flowable c(ce5.a r3, String r4, boolean r5) {
        NetService.f r0 = new NetService.f("/space/api/wiki/v2/obj/info/");
        r0.b("wiki_token", r4);
        r0.b("with_deleted", "true");
        if (r5 == false) goto L5;
        r0.b("need_upgrade_info", "true");
    L5:
        ((NetService.e) r0).c = 2;
        String r6 = u05.b.a();
        r0.c(MapsKt.mapOf(TuplesKt.to("x-tt-logid", r6)));
        return r3.c.Vc(f.a).a(r0).onErrorReturn(d.a).map(new e(r4, r6)).map(new c(r3));
    }

    public static WikiInfo e(ce5.a r3, String r4, boolean r5) {
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r0 != null) goto L5;
        return null;
    L5:
        String r1 = h(r0);
        if (r5 == false) goto L8;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        k25.m0 r6 = k25.e0.m().A(r1, r4, 0);
    L9:
        if (r6 == null) goto L11;
        String r7 = r6.c;
    L13:
        if (TextUtils.isEmpty(r7) == false) goto L15;
        return null;
    L15:
        if (r6 != null) goto L17;
    L20:
        WikiInfo r8 = (WikiInfo) JSON.parseObject(r7, WikiInfo.class);
        r8.from_cache = true;
        return r8;
    L17:
        if (r6.b() == false) goto L20;
        tt5.a.h("WikiRepository", "resourceData has paged, so return null.");
        return null;
    L11:
        r7 = null;
        goto L13
    L8:
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r6 = k25.e0.m().n(r1, r4);
        goto L9
    }

    @JvmStatic
    public static final Flowable<up5.b<WikiInfo>> d(String r3, WikiInfo r4, ce5.a r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "userComponentAbility");
        boolean r0 = com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a();
        boolean r1 = bx4.b.b(r3);
        if (r1 == false) goto L9;
        if (r4 == null) goto L9;
        String r2 = dq5.j.a(r5);
        if (r2 != null) goto L8;
        r2 = r3;
    L8:
        r4.setSpaceId(r2);
    L9:
        if (r0 == false) goto L13;
        if (r1 == true) goto L13;
        Flowable<up5.b<WikiInfo>> r7 = Flowable.concat(f(r5, r3, r4, r6), c(r5, r3, r6));
        Intrinsics.checkNotNull(r7);
    L15:
        return r7.observeOn(fo5.d.d());
    L13:
        r7 = f(r5, r3, r4, false);
        goto L15
    }

    @JvmStatic
    public static final Flowable<up5.b<WikiInfo>> f(ce5.a r2, String r3, WikiInfo r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        if (r4 != null) goto L5;
    L8:
        int r6 = up5.b.b;
        Flowable r7 = Flowable.just(up5.b.a.a());
    L10:
        return r7.flatMap(new g(r2, r3)).flatMap(new h(r2, r3)).map(new k(r2, r5));
    L5:
        if (r4.isValid() == false) goto L8;
        r7 = Flowable.just("").map(new r0(r4)).map(new q0(r2, r4));
        goto L10
    }
}

package mq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRootPermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import dq5.j;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public a(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            tt5.a.h("PersonalTreeDataManager", "requestPersonalTree cacheDataFlow start");
            int r3 = j.a;
            return j.b(this.a);
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "spaceId");
            WikiRelation r6 = s.d(WikiDatabase.c().d().i(r5), "");
            boolean r0 = r6.isValid();
            tt5.a.h("PersonalTreeDataManager", "requestPersonal, load relation from db. valid: " + r0);
            if (r0 == false) goto L5;
            ResultCode r1 = ResultCode.DECO;
        L7:
            return kq5.d.a(new mq5.b(r1), r6);
        L5:
            r1 = ResultCode.DEC1;
            goto L7
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e("PersonalTreeDataManager", "requestPersonal, load relation from db err. ", r5, false);
            return Flowable.just(kq5.d.a(new mq5.b(ResultCode.DEC1), new WikiRelation()));
        }
    }

    /* JADX INFO: renamed from: mq5.d$d, reason: collision with other inner class name */
    public static final class C0271d<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public C0271d(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            tt5.a.h("PersonalTreeDataManager", "requestWikiTree start");
            int r3 = j.a;
            return j.b(this.a);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public e(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "libraryId");
            int r0 = d.a;
            NetService r1 = this.a.c;
            GetRelationPuller.Params r2 = new GetRelationPuller.Params(r5, "");
            if (TextUtils.isEmpty(r2.wiki_token) == false) goto L6;
            r2.wiki_token = null;
        L6:
            return Flowable.zip(new GetRelationPuller(r1).c(r2).flatMap(new i0()), l0.b(r1).a(new GetRootPermPuller.Params(r5)), mq5.e.a).observeOn(fo5.d.c()).map(f.a).doOnError(new g(r5)).onErrorResumeNext(h.a);
        }
    }

    static {
    }

    public static Flowable a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.c()).flatMap(new a(r2)).map(b.a).onErrorResumeNext(c.a);
    }

    public static Flowable b(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.c()).flatMap(new C0271d(r2)).flatMap(new e(r2));
    }
}

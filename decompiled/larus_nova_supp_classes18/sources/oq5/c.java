package oq5;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiHomeRepositoryImpl;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpacesResp;
import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final VirtualNode a = null;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public a(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            tt5.a.h("SpaceTreeDataManager", "requestSpaceWikiTree cacheDataFlow start");
            new WikiHomeRepositoryImpl(this.a);
            return WikiHomeRepositoryImpl.k();
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
            WikiSpacesResp r5 = (WikiSpacesResp) r4;
            Intrinsics.checkNotNullParameter(r5, "response");
            WikiRelation r6 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.c(r5, c.a);
            boolean r0 = r6.isValid();
            tt5.a.h("SpaceTreeDataManager", "requestSpaceWikiTree, load relation from db. valid= " + r0);
            if (r0 == false) goto L5;
            ResultCode r1 = ResultCode.DECO;
        L7:
            return kq5.d.a(new oq5.a(r1), r6);
        L5:
            r1 = ResultCode.DEC1;
            goto L7
        }
    }

    /* JADX INFO: renamed from: oq5.c$c, reason: collision with other inner class name */
    public static final class C0286c<T, R> implements Function {
        public static final C0286c<T, R> a = null;

        static {
            a = new C0286c();
        }

        public C0286c() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("SpaceTreeDataManager", "requestSpaceWikiTree, load relation from db err: " + r4);
            return Flowable.just(kq5.d.a(new oq5.a(ResultCode.DEC2), new WikiRelation()));
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public d(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            tt5.a.h("SpaceTreeDataManager", "requestWikiTree start");
            new WikiHomeRepositoryImpl(this.a);
            return WikiHomeRepositoryImpl.n(this.a.c, null);
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r5) {
            WikiSpacesResp r6 = (WikiSpacesResp) r5;
            Intrinsics.checkNotNullParameter(r6, "response");
            WikiRelation r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.c(r6, c.a);
            boolean r1 = r0.isValid();
            tt5.a.h("SpaceTreeDataManager", "requestSpaceWikiTree, save relation to db. valid= " + r1);
            List<SpaceBean> r7 = r6.b;
            if (r7 != null) goto L5;
        L8:
            boolean r8 = true;
        L9:
            if (r8 == true) goto L12;
            if (r1 == false) goto L12;
            ResultCode r9 = ResultCode.DECO;
        L14:
            return kq5.d.a(new oq5.b(r9), r0);
        L12:
            r9 = ResultCode.DEC1;
            goto L14
        L5:
            if (r7.isEmpty() == true) goto L8;
            r8 = false;
            goto L9
        }
    }

    public static final class f<T, R> implements Function {
        public static final f<T, R> a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("SpaceTreeDataManager", "requestSpaceWikiTree, err: " + r4);
            return Flowable.just(kq5.d.a(new oq5.b(ResultCode.DEC2), new WikiRelation()));
        }
    }

    static {
        a = VirtualNode.TITLE_ROOT_SPACE;
    }

    public static Flowable a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.c()).flatMap(new a(r2)).map(b.a).onErrorResumeNext(C0286c.a);
    }

    public static Flowable b(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").flatMap(new d(r2)).observeOn(fo5.d.c()).map(e.a).onErrorResumeNext(f.a);
    }
}

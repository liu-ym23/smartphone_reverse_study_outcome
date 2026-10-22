package lq5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.create.s0;
import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.TopCloudDocumentListPuller$Params;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.r;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SidebarListInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final VirtualNode a = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: lq5.e$a$a, reason: collision with other inner class name */
        public static final class CallableC0263a<V> implements Callable {
            public final /* synthetic */ Object a;

            public CallableC0263a(Object r1) {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                WikiRelation r0 = (WikiRelation) ((Pair) this.a).getSecond();
                if (r0.isValid() == false) goto L22;
                WikiRelation.Tree r1 = r0.tree;
                if (r1 == null) goto L15;
                HashMap<String, TreeNode> r2 = r1.nodes;
                if (r2 == null) goto L21;
                Iterator<Map.Entry<String, TreeNode>> r3 = r2.entrySet().iterator();
            L11:
                if (r3.hasNext() == false) goto L23;
                Map.Entry<String, TreeNode> r4 = r3.next();
                if (r4.getValue().isSpaceDocument == false) goto L11;
                tt5.a.h("DocumentTreeDataManager", "insertMetaInfoIfNotExist, token=" + du5.b.i(r4.getKey()) + ",metaInfoNeedInsert=" + s0.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.b(r4.getValue())));
                goto L11
            L23:
                return;
            L21:
                return;
            L15:
                return;
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new CallableC0263a(r4)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public b(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            tt5.a.h("DocumentTreeDataManager", "requestWikiTree start");
            TopCloudDocumentListPuller$Params r5 = new TopCloudDocumentListPuller$Params(true);
            NetService.d r0 = this.a.c.Vc(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.a());
            tt5.a.h("TopCloudDocumentListPuller", "pullInfo");
            NetService.f r1 = new NetService.f("/space/api/explorer/v3/pin/list/");
            ((NetService.e) r1).c = 2;
            r1.b("filter_folder", String.valueOf(r5.filterFolder));
            return r0.a(r1).map(new r());
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r6) {
            SidebarListInfo r7 = (SidebarListInfo) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            VirtualNode r0 = e.a;
            WikiRelation r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.d(r7, r0, null, null);
            boolean r2 = r1.isValid();
            tt5.a.h("DocumentTreeDataManager", "requestCloudDocument, load relation from network. valid= " + r2);
            if (hu5.a.f(r7.getNodeList()) == false) goto L6;
            if (r2 == false) goto L6;
            boolean r8 = true;
        L7:
            if (r8 == true) goto L9;
            WikiDatabase.c().d().f(r0);
        L10:
            if (r8 == false) goto L12;
            ResultCode r9 = ResultCode.DECO;
        L14:
            return kq5.d.a(new lq5.b(r9), r1);
        L12:
            r9 = ResultCode.DEC1;
            goto L14
        L9:
            WikiDatabase.c().d().b(r0, s.b(r1));
        L6:
            r8 = false;
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            if (tp5.b.c(tp5.b.a((Throwable) r2)) == false) goto L6;
            tt5.a.k("DocumentTreeDataManager", "requestCloudDocument, this relation was deleted. ");
            WikiDatabase.c().d().e(e.a.getSpaceId());
            return;
        }
    }

    /* JADX INFO: renamed from: lq5.e$e, reason: collision with other inner class name */
    public static final class C0264e<T, R> implements Function {
        public static final C0264e<T, R> a = null;

        static {
            a = new C0264e();
        }

        public C0264e() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("DocumentTreeDataManager", "requestCloudDocument, err: " + r4);
            return Flowable.just(kq5.d.a(new lq5.b(ResultCode.DEC2), new WikiRelation()));
        }
    }

    static {
        a = VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT;
    }

    public static Flowable a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.c()).flatMap(new b(r2)).observeOn(fo5.d.c()).map(c.a).map(new a()).doOnError(d.a).onErrorResumeNext(C0264e.a);
    }
}

package nq5;

import com.bytedance.ee.bear.NodeType;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.create.s0;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.wikiv2.sidebar.home.ResultCode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.ShareListPuller$Params;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.r;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SidebarListInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.SpaceEntity;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.google.gson.Gson;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final VirtualNode a = null;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: nq5.e$a$a, reason: collision with other inner class name */
        public static final class CallableC0279a<V> implements Callable {
            public final /* synthetic */ Object a;

            public CallableC0279a(Object r1) {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                SidebarListInfo r0 = (SidebarListInfo) this.a;
                SidebarListInfo.NodeEntities r1 = r0.getEntities();
                if (r1 == null) goto L5;
                HashMap<String, SpaceEntity> r2 = r1.getSpace();
            L7:
                if (hu5.a.g(r2) == false) goto L28;
                SidebarListInfo.NodeEntities r3 = r0.getEntities();
                if (r3 == null) goto L34;
                HashMap<String, SpaceEntity> r4 = r3.getSpace();
                if (r4 == null) goto L35;
                Iterator<Map.Entry<String, SpaceEntity>> r5 = r4.entrySet().iterator();
            L14:
                if (r5.hasNext() == false) goto L36;
                SpaceEntity r6 = r5.next().getValue();
                Intrinsics.checkNotNullParameter(r6, "<this>");
                Document r7 = new Document();
                r7.b = r6.getType();
                r7.a = r6.getName();
                r7.c = r6.getObjToken();
                r7.d = r6.getObjToken();
                r7.e = r6.getOwnerId();
                r7.g = r6.getEditUid();
                r7.i = String.valueOf(r6.getEditTime());
                r7.j = String.valueOf(r6.getCreateTime());
                r7.z = r6.isStared();
                r7.p = r6.getUrl();
                if (r6.getType() != sbb.e.l.b) goto L18;
                String r8 = com.bytedance.ee.util.io.a.c(r6.getName());
            L19:
                r7.F = r8;
                r7.q = r6.getThumbnail();
                r7.L = r6.isPined();
                r7.A = false;
                r7.L1 = r6.getOwnerType();
                r7.M1 = NodeType.ENTITY.getValue();
                r7.O = new Gson().toJson(r6);     // Catch: Exception -> L22
            L24:
                r7.b2 = r6.getSecretKeyDelete();
                r7.T1 = "";
                r7.V1 = 0;
                r7.h2 = 0;
                r7.p2 = r6.getObjToken();
                r7.v2 = r6.getDeleteFlag();
                SpaceEntity.SpaceEntityThumbnailExtra r9 = r6.getThumbnailExtra();
                if (r9 == null) goto L27;
                r7.V0 = r9.getUrl();
                r7.b1 = r9.getSecret();
                r7.g1 = r9.getNonce();
                r7.h1 = r9.getType();
            L27:
                tt5.a.h("ShareTreeDataManager", "insertMetaInfoIfNotExist, token=" + du5.b.i(r7.d) + ",metaInfoNeedInsert=" + s0.a(r7));
            L22:
                e = move-exception;
                tt5.a.d("TopResultExt", "toDocument parse extra fail: " + e);
                goto L24
            L18:
                r8 = "";
                goto L19
            L36:
                return;
            L35:
                return;
            L34:
                return;
            L28:
                return;
            L5:
                r2 = null;
                goto L7
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
            Flowable.fromCallable(new CallableC0279a(r4)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ ce5.a a;

        public b(ce5.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Intrinsics.checkNotNullParameter((String) r5, "it");
            tt5.a.h("ShareTreeDataManager", "requestWikiTree start");
            ShareListPuller$Params r6 = new ShareListPuller$Params(10);
            NetService.d r0 = this.a.c.Vc(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.a());
            tt5.a.h("ShareListPuller", "pullInfo");
            ArrayList r1 = new ArrayList();
            r1.add(String.valueOf(sbb.e.g.b));
            r1.add(String.valueOf(sbb.e.o.b));
            r1.add(String.valueOf(sbb.e.h.b));
            r1.add(String.valueOf(sbb.e.m.b));
            r1.add(String.valueOf(sbb.e.i.b));
            r1.add(String.valueOf(sbb.e.k.b));
            r1.add(String.valueOf(sbb.e.l.b));
            NetService.f r2 = new NetService.f("/space/api/explorer/v3/share/list/");
            ((NetService.e) r2).c = 2;
            r2.b("length", String.valueOf(r6.requestLength));
            r2.a("obj_type", r1);
            r2.b("forbidden_obj_type", String.valueOf(sbb.e.f.b));
            r2.b("need_total", "1");
            r2.b("rank", String.valueOf(FolderSort.SHARED_TIME.getRank()));
            r2.b("asc", String.valueOf(false));
            return r0.a(r2).map(new r());
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
            WikiRelation r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.c.d(r7, r0, VirtualNode.TITLE_TOTAL_SHARE, 7);
            boolean r2 = r1.isValid();
            tt5.a.h("ShareTreeDataManager", "requestShare, load relation from network. valid= " + r2);
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
            return kq5.d.a(new nq5.b(r9), r1);
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
            tt5.a.k("ShareTreeDataManager", "requestShare, this relation was deleted. ");
            WikiDatabase.c().d().e(e.a.getSpaceId());
            return;
        }
    }

    /* JADX INFO: renamed from: nq5.e$e, reason: collision with other inner class name */
    public static final class C0280e<T, R> implements Function {
        public static final C0280e<T, R> a = null;

        static {
            a = new C0280e();
        }

        public C0280e() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.d("ShareTreeDataManager", "requestShare, err: " + r4);
            return Flowable.just(kq5.d.a(new nq5.b(ResultCode.DEC2), new WikiRelation()));
        }
    }

    static {
        a = VirtualNode.TITLE_ROOT_SHARE;
    }

    public static Flowable a(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return Flowable.just("").observeOn(fo5.d.c()).flatMap(new b(r2)).observeOn(fo5.d.c()).map(new a()).map(c.a).doOnError(d.a).onErrorResumeNext(C0280e.a);
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetChildPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRootPermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t1 {

    public static final class a<V> implements Callable {
        public final /* synthetic */ WikiTreeModel a;
        public final /* synthetic */ String b;

        public a(WikiTreeModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            tt5.a.h("Wiki_WikiTreeRepository", "addNode, save children to db. ");
            t1.l(this.a, this.b);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ WikiTreeModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ List c;
        public final /* synthetic */ String d;

        public b(WikiTreeModel r1, String r2, List r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            tt5.a.h("Wiki_WikiTreeRepository", "delNode, del children to db. ");
            yq5.f r0 = WikiDatabase.c().d();
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
            String r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a.b(this.a.workspace, this.b, this.a.userComponentAbility);
            List<String> r3 = this.c;
            WikiTreeModel r4 = this.a;
            r0.d(r2, r3, t1.g(r4, CollectionsKt.listOf(new String[]{this.d, r4.workspace.a})));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Integer r2 = (Integer) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Wiki_WikiTreeRepository", "delNode, delCachedStatus err. ", (Throwable) r4, false);
        }
    }

    public static final class e<V> implements Callable {
        public final /* synthetic */ WikiTreeModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public e(WikiTreeModel r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            tt5.a.h("Wiki_WikiTreeRepository", "delSingleNode, del node to db. ");
            yq5.f r0 = WikiDatabase.c().d();
            int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
            String r2 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a.b(this.a.workspace, this.b, this.a.userComponentAbility);
            String r3 = this.c;
            WikiTreeModel r4 = this.a;
            List<yq5.b> r5 = t1.g(r4, CollectionsKt.listOf(new String[]{this.d, r4.workspace.a}));
            WikiTreeModel r6 = this.a;
            List<String> r7 = r6.workspace.i(this.d);
            Intrinsics.checkNotNull(r7);
            List<yq5.b> r8 = t1.g(r6, r7);
            yq5.q r9 = (yq5.q) r0;
            r9.a.beginTransaction();
            ArrayList r10 = new ArrayList(1);     // Catch: Throwable -> L9
            if (r3 == null) goto L6;
            r10.add(r3);     // Catch: Throwable -> L9
        L6:
            r9.c(r2, r10);     // Catch: Throwable -> L9
            r9.t(r8);     // Catch: Throwable -> L9
            r9.l(r5);     // Catch: Throwable -> L9
            r9.a.setTransactionSuccessful();     // Catch: Throwable -> L9
            r9.a.endTransaction();
            return;
        L9:
            th = move-exception;
            r9.a.endTransaction();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class f<V> implements Callable {
        public final /* synthetic */ WikiTreeModel a;

        public f(WikiTreeModel r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            WikiTreeModel r0 = this.a;
            t1.a(r0, CollectionsKt.listOf(r0.workspace.a));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class g<T, R> implements Function {
        public static final g<T, R> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object apply(Object r2) {
            TreeNode r3 = (TreeNode) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return new up5.b(r3);
        }
    }

    public static final class h<V> implements Callable {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ WikiTreeModel d;

        public h(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.f r1, String r2, boolean r3, WikiTreeModel r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            tt5.a.h("Wiki_WikiTreeRepository", "movNode, update children to db. ");
            List r0 = CollectionsKt.mutableListOf(new String[]{this.a.a, this.b});
            if (this.c == false) goto L5;
            r0.add(this.a.b);
        L5:
            t1.a(this.d, r0);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final class i<T, R> implements Function {

        public static final class a<V> implements Callable {
            public final /* synthetic */ Object a;

            public a(Object r1) {
                this.a = r1;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                WikiRelation r0 = (WikiRelation) this.a;
                tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, save relation to db. ");
                yq5.f r1 = WikiDatabase.c().d();
                Intrinsics.checkNotNull(r0);
                r1.a(yq5.s.b(r0));
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }
        }

        public i() {
        }

        public final T apply(T r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            Flowable.fromCallable(new a(r4)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return r4;
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ WikiTreeModel a;
        public final /* synthetic */ ce5.a b;

        public j(WikiTreeModel r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            WikiRelation r7 = (WikiRelation) r6;
            Intrinsics.checkNotNullParameter(r7, "relation");
            boolean r0 = r7.isValid();
            if (r0 == false) goto L5;
            WikiTreeModel r1 = this.a;
            r1.workspace = new e3(r7, new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e(), this.b);
        L5:
            tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, init workspace completed. ");
            return Boolean.valueOf(r0);
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public k(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            WikiRelation r5 = yq5.s.d(WikiDatabase.c().d().i(this.a), this.b);
            boolean r0 = r5.isValid();
            if (r0 == false) goto L5;
            r5.init();
        L5:
            tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, load relation from db. valid: " + r0);
            return r5;
        }
    }

    public static final class l<T, R> implements Function {
        public static final l<T, R> a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final Object apply(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e("Wiki_WikiTreeRepository", "requestWikiTree, load relation from db err. ", r5, false);
            return Flowable.just(new WikiRelation());
        }
    }

    public static final class m<T1, T2, R> implements BiFunction {
        public static final m<T1, T2, R> a = null;

        static {
            a = new m();
        }

        public m() {
        }

        public final Object apply(Object r2, Object r3) {
            WikiRelation r4 = (WikiRelation) r2;
            SpacePerm r5 = (SpacePerm) r3;
            Intrinsics.checkNotNullParameter(r4, "relation");
            Intrinsics.checkNotNullParameter(r5, "rootPermInfo");
            r4.space_perm = r5;
            r4.init();
            tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree, load relation from network. res: " + r4);
            return r4;
        }
    }

    public static final class n<T, R> implements Function {
        public final /* synthetic */ WikiTreeModel a;
        public final /* synthetic */ String b;

        public n(WikiTreeModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            WikiRelation r5 = (WikiRelation) r4;
            Intrinsics.checkNotNullParameter(r5, "relation");
            SpaceUserPerm r0 = r5.user_space_perm;
            if (r0 != null) goto L5;
        L9:
            boolean r1 = false;
        L10:
            WikiTreeModel r2 = this.a;
            if (r2.favoriteEnable == false) goto L15;
            if (r1 == false) goto L15;
            return new GetFavoriteRelationPuller(r2.netService).c(new GetFavoriteRelationPuller.Params(this.b)).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.u()).map(new h2(r5));
        L15:
            return Flowable.just(r5);
        L5:
            if (r0.view_wiki_info == false) goto L9;
            if (r0.view_wiki_collaborator == false) goto L9;
            r1 = true;
            goto L10
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ String a;

        public o(String r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (tp5.b.c(tp5.b.a((Throwable) r3)) == false) goto L6;
            tt5.a.k("Wiki_WikiTreeRepository", "requestWikiTree, this relation was deleted. ");
            Flowable.fromCallable(new i2(this.a)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
            return;
        }
    }

    public static final class p<V> implements Callable {
        public final /* synthetic */ WikiTreeModel a;

        public p(WikiTreeModel r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            WikiTreeModel r0 = this.a;
            t1.a(r0, CollectionsKt.listOf(r0.workspace.a));
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public static final void a(WikiTreeModel r0, List r1) {
        List<yq5.b> r2 = g(r0, r1);
        WikiDatabase.c().d().l(r2);
        tt5.a.h("Wiki_WikiTreeRepository", "syncCacheNodeToDb ok. ");
    }

    public static final void f(WikiTreeModel r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
        tt5.a.h("Wiki_WikiTreeRepository", "favoriteNode start. ");
        e3 r0 = r3.workspace;
        if (r0.x(r4) == false) goto L5;
        r0.g.get(r4).is_star = true;
        ListProtector.add(r0.j(r0.a), 0, r4);
    L5:
        Flowable.fromCallable(new f(r3)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
    }

    public static final List<yq5.b> g(WikiTreeModel r4, List<String> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        String r1 = r6.next();
        TreeNode r2 = r4.workspace.m(r1);
        if (r2 == null) goto L8;
        yq5.b r3 = yq5.s.c(r2, r4.workspace.i(r1));
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L11:
        return r0;
    }

    public static final Flowable<up5.b<TreeNode>> h(WikiTreeModel r2, TreeNode r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "node");
        if (r3.isShortcut() == true) goto L5;
    L7:
        int r4 = up5.b.b;
        Flowable<up5.b<TreeNode>> r5 = Flowable.just(up5.b.a.a());
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        if (r2.workspace.x(r3.getOriginToken()) == true) goto L7;
        Flowable<up5.b<TreeNode>> r6 = new GetNodePuller(r2.netService).d(new GetNodePuller.Params(r3.getOriginSpaceId(), r3.getOriginToken())).map(g.a);
        Intrinsics.checkNotNull(r6);
        return r6;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void j(WikiTreeModel r12, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.f r13) {
        TreeNode r0 = r13.f;
        WikiRelation r1 = r13.g;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        tt5.a.h("Wiki_WikiTreeRepository", String.format("moveTo, srcToken: %s, destToken: %s, newSortId: %s, forceExpand: %s, expandToToken: %s", Arrays.copyOf(new Object[]{yu5.c.j(r13.a), yu5.c.j(r13.b), String.valueOf(r13.c), String.valueOf(r13.d), yu5.c.j(r13.e)}, 5)));
        e3 r3 = r12.workspace;
        String r4 = r13.a;
        double r6 = r13.c;
        if (r3.x(r4) == false) goto L6;
        ((TreeNode) ((ConcurrentHashMap) r3.g).get(r4)).sort_id = r6;
    L6:
        if (r12.workspace.x(r13.b) == false) goto L19;
        if (r12.workspace.v(r13.b) == false) goto L19;
        if (r12.workspace.x(r13.a) == false) goto L12;
        tt5.a.h("Wiki_WikiTreeRepository", "moveTo case6");
        r12.workspace.z(r13.a, r13.b, r13.c, r13.h);
    L51:
        if (r13.d == false) goto L59;
        r12.workspace.F(r13.e, true);
        return;
    L59:
        return;
    L12:
        tt5.a.h("Wiki_WikiTreeRepository", "moveTo case3");
        if (r0 != null) goto L15;
        GetNodePuller r5 = new GetNodePuller(r12.netService);
        int r7 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
        r0 = (TreeNode) r5.d(new GetNodePuller.Params(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a.a(r12.workspace, r13, r12.userComponentAbility), r13.a)).blockingSingle();
    L15:
        e3 r8 = r12.workspace;
        String r9 = r13.b;
        r8.getClass();
        if (r0 == null) goto L51;
        int r10 = r8.J(r9, r0.sort_id);
        ArrayList r11 = new ArrayList(1);
        r11.add(r0);
        r8.r(r9, r10, r11);
    L19:
        if (r13.d == true) goto L21;
        tt5.a.h("Wiki_WikiTreeRepository", "moveTo case5");
        r12.workspace.A(r13.a);
        goto L51
    L21:
        tt5.a.h("Wiki_WikiTreeRepository", "moveTo case4");
        if (r1 != null) goto L27;
        NetService r14 = r12.netService;
        int r15 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
        GetRelationPuller.Params r16 = new GetRelationPuller.Params(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a.a(r12.workspace, r13, r12.userComponentAbility), r13.b);
        if (TextUtils.isEmpty(r16.wiki_token) == false) goto L26;
        r16.wiki_token = null;
    L26:
        r1 = (WikiRelation) new GetRelationPuller(r14).c(r16).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()).blockingSingle();
    L27:
        e3 r17 = r12.workspace;
        Intrinsics.checkNotNull(r1);
        SpaceInfo r18 = r1.space;
        WikiRelation.Tree r19 = r1.tree;
        String r20 = r19.root_token;
        HashMap<String, List<String>> r21 = r19.child_map;
        HashMap<String, TreeNode> r22 = r19.nodes;
        String r23 = r13.a;
        r17.getClass();
        if (TextUtils.isEmpty(r18.space_id) == false) goto L30;
    L48:
        tt5.a.k("Wiki_Workspaces", "diffAppendRelation, invalid params. ");
    L49:
        r12.workspace.z(r13.a, r13.b, r13.c, r13.h);
        goto L51
    L30:
        if (TextUtils.equals(r18.space_id, r17.j.space_id) == false) goto L48;
        if (TextUtils.equals(r20, r17.b) == false) goto L48;
        TreeNode r24 = r22.get(r23);
        if (r24 == null) goto L42;
        List<String> r25 = r21.get(r24.parent_wiki_token);
        if (hu5.a.d(r25) == true) goto L40;
        r25.remove(r23);
    L40:
        if (hu5.a.d(r25) == false) goto L42;
        r21.remove(r24.parent_wiki_token);
    L42:
        r21.remove(r23);
        ((ConcurrentHashMap) r17.f).putAll(r21);
        Iterator<Map.Entry<String, TreeNode>> r26 = r22.entrySet().iterator();
    L44:
        if (r26.hasNext() == false) goto L49;
        Map.Entry<String, TreeNode> r27 = r26.next();
        if (((ConcurrentHashMap) r17.g).containsKey(r27.getKey()) == true) goto L44;
        ((ConcurrentHashMap) r17.g).put(r27.getKey(), r27.getValue());
        goto L44
    }

    public static final void l(WikiTreeModel r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "parentToken");
        TreeNode r0 = r2.workspace.m(r3);
        if (r0 == null) goto L5;
        yq5.b r1 = yq5.s.c(r0, r2.workspace.i(r3));
    L6:
        List<String> r4 = r2.workspace.i(r3);
        Intrinsics.checkNotNull(r4);
        List<yq5.b> r5 = g(r2, r4);
        if (r1 == null) goto L14;
        yq5.q r6 = (yq5.q) WikiDatabase.c().d();
        r6.a.beginTransaction();
        yq5.q.q(r6, r1, r5);     // Catch: Throwable -> L11
        r6.a.setTransactionSuccessful();     // Catch: Throwable -> L11
        r6.a.endTransaction();
    L11:
        th = move-exception;
        r6.a.endTransaction();
        throw th;
    L14:
        tt5.a.h("Wiki_WikiTreeRepository", "syncCacheChildrenToDb ok. ");
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void m(WikiTreeModel r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.WIKI_TOKEN);
        tt5.a.h("Wiki_WikiTreeRepository", "unfavoriteNode start. ");
        r2.workspace.K(r3);
        Flowable.fromCallable(new p(r2)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
    }

    public static final String d(WikiTreeModel r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
        tt5.a.h("Wiki_WikiTreeRepository", "delNode start. ");
        TreeNode r0 = r2.workspace.m(r4);
        if (r0 == null) goto L9;
        String r1 = r0.parent_wiki_token;
        if (r1 == null) goto L11;
        List<String> r5 = r2.workspace.A(r4);
        Flowable.fromCallable(new b(r2, r3, r5, r1)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        k25.e0.m().k(r5);
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r5).subscribe(c.a, d.a);
        return r1;
    L11:
        return "";
    L9:
        return "";
    }

    public static final String e(WikiTreeModel r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.WIKI_TOKEN);
        tt5.a.h("Wiki_WikiTreeRepository", "delSingleNode start. ");
        TreeNode r0 = r4.workspace.m(r6);
        if (r0 != null) goto L5;
        return "";
    L5:
        String r2 = r0.parent_wiki_token;
        if (r2 != null) goto L9;
        return "";
    L9:
        if (r0.getNodeType() != WikNodeType.LEAF.getValue()) goto L11;
    L13:
        List<TreeNode> r1 = null;
    L14:
        r4.workspace.B(r6, r1);
        Flowable.fromCallable(new e(r4, r5, r6, r2)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        return r2;
    L11:
        if (r0.isShortcut() == true) goto L13;
        r1 = (List) com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.a(r4.netService).a(new GetChildPuller.Params(r0.space_id, r2)).blockingSingle();
        goto L14
    }

    public static final void i(WikiTreeModel r2, String r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.f r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "srcParent");
        Intrinsics.checkNotNullParameter(r4, "bean");
        tt5.a.h("Wiki_WikiTreeRepository", "movNode start. ");
        boolean r0 = r2.workspace.q(r4.b);
        j(r2, r4);
        Flowable.fromCallable(new h(r4, r3, r0, r2)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
    }

    public static final void c(WikiTreeModel r3, List r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "wikiTokens");
        Intrinsics.checkNotNullParameter(r5, "delParentToken");
        tt5.a.h("Wiki_WikiTreeRepository", "delBatchNodes start. ");
        if (hu5.a.d(r4) == false) goto L6;
        tt5.a.k("Wiki_WikiTreeRepository", "delBatchNodes, wikiTokens is empty, return");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r7 = ((ArrayList) r4).iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        String r1 = (String) r7.next();
        r0.addAll(r3.workspace.A(r1));
        goto L8
    L10:
        Flowable.fromCallable(new u1(r3, r6, r0, r5)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        k25.e0.m().k(r0);
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r0).subscribe(v1.a, w1.a);
    }

    public static final Flowable<Boolean> k(WikiTreeModel r3, String r4, String r5, ce5.a r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "userComponentAbility");
        tt5.a.h("Wiki_WikiTreeRepository", "requestWikiTree start. ");
        GetRelationPuller.Params r0 = new GetRelationPuller.Params(r4, r5);
        r3.getViewConfig().getClass();
        Flowable r7 = Flowable.just("").observeOn(fo5.d.c()).map(new k(r4, r5)).onErrorResumeNext(l.a);
        NetService r1 = r3.netService;
        if (TextUtils.isEmpty(r0.wiki_token) == false) goto L6;
        r0.wiki_token = null;
    L6:
        return Flowable.concat(r7, Flowable.zip(new GetRelationPuller(r1).c(r0).flatMap(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.i0()), com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.b(r3.netService).a(new GetRootPermPuller.Params(r4)), m.a).flatMap(new n(r3, r4)).doOnError(new o(r4)).map(new i())).observeOn(fo5.d.d()).map(new j(r3, r6));
    }

    public static final String b(WikiTreeModel r2, String r3, TreeNode r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "parentToken");
        Intrinsics.checkNotNullParameter(r4, "newInsertNode");
        tt5.a.h("Wiki_WikiTreeRepository", "addNode start. ");
        insert(r2, r3, r4, r5, r6);
        Flowable.fromCallable(new a(r2, r3)).subscribeOn(fo5.d.f()).subscribe(Functions.emptyConsumer(), up5.e.a);
        return r4.wiki_token;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static final void insert(WikiTreeModel r5, String r6, TreeNode r7, boolean r8, String r9) {
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        tt5.a.h("Wiki_WikiTreeRepository", String.format("insert, srcToken: %s, toInsertNode: %s, forceExpand: %s", Arrays.copyOf(new Object[]{yu5.c.j(r6), yu5.c.j(r7.wiki_token), String.valueOf(r8)}, 3)));
        if (r5.workspace.v(r6) == false) goto L5;
        e3 r1 = r5.workspace;
        r1.getClass();
        int r2 = r1.J(r6, r7.sort_id);
        ArrayList r3 = new ArrayList(1);
        r3.add(r7);
        r1.r(r6, r2, r3);
    L7:
        if (r8 == false) goto L10;
        r5.workspace.C(r9);
        return;
    L10:
        return;
    L5:
        if (r8 == false) goto L7;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.d0 r4 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.a(r5.netService);
        int r10 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a;
        r5.workspace.s(r6, (List) r4.a(new GetChildPuller.Params(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.i.a.a(r5.workspace, r7, r5.userComponentAbility), r6)).blockingSingle());
        goto L7
    }
}

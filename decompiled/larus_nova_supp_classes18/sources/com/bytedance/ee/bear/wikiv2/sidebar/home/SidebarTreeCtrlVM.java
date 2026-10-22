package com.bytedance.ee.bear.wikiv2.sidebar.home;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceUserPerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kq5.n;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J8\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J4\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\"\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010#\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010$\u001a\u00020 H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/sidebar/home/SidebarTreeCtrlVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "rootRelation", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikiRelation;", "wikiSupportSharedEnable", "", "lastWorkspace", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/Workspace;", "lastUiCache", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/WikiTreeUICache;", "onRefreshFromDatabase", "Lio/reactivex/Flowable;", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/wikiv2/sidebar/home/IWikiRelationDecoration;", "userComponentAbility", "Lcom/bytedance/ee/bear/list/usercomponent/UserComponentAbility;", "onRefreshFromNetwork", "onRefreshFromDatabaseAndNetwork", "onRefreshFromNet", "onRefreshFromNetWithType", "reloadType", "", "", "addRelationAndCreateWorkspace", "relationPair", "uiCache", "buildWorkspace", "decoration", "relation", "onBeforeRefresh", "", "workspace", "initUiCache", "updateRootRelation", "onCleared", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SidebarTreeCtrlVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "SidebarTreeCtrlVM";
    private volatile com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e lastUiCache;
    private volatile e3 lastWorkspace;
    private WikiRelation rootRelation;
    private boolean wikiSupportSharedEnable;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;

        public b(SidebarTreeCtrlVM r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            SidebarTreeCtrlVM r3 = this.a;
            SidebarTreeCtrlVM.access$onBeforeRefresh(r3, SidebarTreeCtrlVM.access$getLastWorkspace$p(r3));
            return Unit.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;
        public final /* synthetic */ ce5.a b;

        public c(SidebarTreeCtrlVM r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((Unit) r3, "it");
            return Flowable.concat(SidebarTreeCtrlVM.access$onRefreshFromDatabase(this.a, this.b), SidebarTreeCtrlVM.access$onRefreshFromNetwork(this.a, this.b));
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;
        public final /* synthetic */ ce5.a b;

        public d(SidebarTreeCtrlVM r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "relationPair");
            SidebarTreeCtrlVM r0 = this.a;
            return SidebarTreeCtrlVM.access$addRelationAndCreateWorkspace(r0, r5, SidebarTreeCtrlVM.access$getLastUiCache$p(r0), this.b);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;

        public e(SidebarTreeCtrlVM r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            SidebarTreeCtrlVM r3 = this.a;
            SidebarTreeCtrlVM.access$onBeforeRefresh(r3, SidebarTreeCtrlVM.access$getLastWorkspace$p(r3));
            return Unit.INSTANCE;
        }
    }

    public static final class f<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;
        public final /* synthetic */ ce5.a b;

        public f(SidebarTreeCtrlVM r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Unit) r2, "it");
            return SidebarTreeCtrlVM.access$onRefreshFromNetwork(this.a, this.b);
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;
        public final /* synthetic */ ce5.a b;

        public g(SidebarTreeCtrlVM r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "relationPair");
            SidebarTreeCtrlVM r0 = this.a;
            return SidebarTreeCtrlVM.access$addRelationAndCreateWorkspace(r0, r5, SidebarTreeCtrlVM.access$getLastUiCache$p(r0), this.b);
        }
    }

    public static final class h<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;

        public h(SidebarTreeCtrlVM r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((String) r2, "it");
            SidebarTreeCtrlVM r3 = this.a;
            SidebarTreeCtrlVM.access$onBeforeRefresh(r3, SidebarTreeCtrlVM.access$getLastWorkspace$p(r3));
            return Unit.INSTANCE;
        }
    }

    public static final class i<T, R> implements Function {
        public final /* synthetic */ ce5.a a;
        public final /* synthetic */ List<String> b;

        public i(ce5.a r1, List<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((Unit) r6, "it");
            n r7 = new n(this.a);
            List<String> r0 = this.b;
            Intrinsics.checkNotNullParameter(r0, "reloadType");
            HashMap<String, Flowable<Pair<kq5.c, WikiRelation>>> r1 = r7.c;
            ArrayList r2 = new ArrayList();
            Iterator<T> r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            Flowable<Pair<kq5.c, WikiRelation>> r4 = r1.get((String) r3.next());
            if (r4 == null) goto L4;
            r2.add(r4);
            goto L4
        L9:
            if (hu5.a.d(r2) == false) goto L11;
            VirtualNode r5 = lq5.e.a;
            r2.add(lq5.e.a(r7.a));
        L11:
            tt5.a.h("SidebarTreeDataManager", "provideNetworkFlowWithType, reloadType= " + r0);
            Flowable r8 = (Flowable) ListProtector.get(r2, 0);
            int r9 = 1;
            if (r2.size() <= 1) goto L16;
            int r10 = r2.size();
        L14:
            if (r9 >= r10) goto L16;
            r8 = r8.concatWith((Publisher) ListProtector.get(r2, r9));
            r9 = r9 + 1;
        L16:
            return r8;
        }
    }

    public static final class j<T, R> implements Function {
        public final /* synthetic */ SidebarTreeCtrlVM a;
        public final /* synthetic */ ce5.a b;

        public j(SidebarTreeCtrlVM r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Pair r5 = (Pair) r4;
            Intrinsics.checkNotNullParameter(r5, "relationPair");
            SidebarTreeCtrlVM r0 = this.a;
            return SidebarTreeCtrlVM.access$addRelationAndCreateWorkspace(r0, r5, SidebarTreeCtrlVM.access$getLastUiCache$p(r0), this.b);
        }
    }

    static {
        Companion = new a();
    }

    public SidebarTreeCtrlVM() {
        VirtualNode r0 = VirtualNode.TITLE_ROOT_PERSONAL;
        int r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.a;
        Intrinsics.checkNotNullParameter(r0, "virtualNode");
        WikiRelation r2 = new WikiRelation();
        WikiRelation.Tree r3 = new WikiRelation.Tree();
        r2.tree = r3;
        r3.root_token = r0.getRootToken();
        r3.nodes = new HashMap();
        r3.shared = new ArrayList();
        ArrayList r4 = new ArrayList();
        r4.add(r0.getRootToken());
        r3.root_list = r4;
        HashMap<String, List<String>> r5 = new HashMap();
        r3.child_map = r5;
        r5.put(r0.getRootToken(), new ArrayList());
        r3.nodes.put(r0.getRootToken(), com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.b(r0));
        r2.space = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.top.b.a(r0.getSpaceId());
        SpacePerm r6 = new SpacePerm();
        r6.canEditFirstLevel = true;
        r2.space_perm = r6;
        SpaceUserPerm r7 = new SpaceUserPerm();
        r7.view_wiki_info = true;
        r7.view_wiki_collaborator = true;
        r7.star_wiki = true;
        r7.view_wiki_general_info = true;
        r2.user_space_perm = r7;
        this.rootRelation = r2;
        int r8 = qc5.a.a;
        this.wikiSupportSharedEnable = qc5.a.m(new ce5.a());
        this.lastUiCache = new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e();
    }

    public void onCleared() {
        super.onCleared();
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r0 = this.lastUiCache;
        r0.a.clear();
        r0.b.clear();
        this.lastWorkspace = null;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e access$getLastUiCache$p(SidebarTreeCtrlVM r0) {
        return r0.lastUiCache;
    }

    public static final /* synthetic */ e3 access$getLastWorkspace$p(SidebarTreeCtrlVM r0) {
        return r0.lastWorkspace;
    }

    private final void initUiCache(e3 r3) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r0 = this.lastUiCache;
        if (hu5.a.e(r0.a) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        if (r3 != null) goto L14;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r2 = this.lastUiCache;
        VirtualNode r4 = VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT;
        r2.a(r4, r4);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r5 = this.lastUiCache;
        VirtualNode r6 = VirtualNode.TITLE_ROOT_SPACE;
        r5.a(r6, r6);
        if (this.wikiSupportSharedEnable == false) goto L13;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r7 = this.lastUiCache;
        VirtualNode r8 = VirtualNode.TITLE_ROOT_SHARE;
        r7.a(r8, r8);
    L13:
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r9 = this.lastUiCache;
        VirtualNode r10 = VirtualNode.TITLE_ROOT_PERSONAL;
        r9.a(r10, r10);
    L14:
        if (r3 == null) goto L17;
        this.lastUiCache.a.putAll(r3.e());
        this.lastUiCache.b.putAll(r3.d());
        return;
    L17:
        return;
    L5:
        if (hu5.a.e(r0.b) == false) goto L7;
        r1 = true;
        goto L8
    }

    private final void onBeforeRefresh(e3 r1) {
        initUiCache(r1);
        updateRootRelation(r1);
    }

    private final Flowable<Pair<kq5.c, WikiRelation>> onRefreshFromDatabase(ce5.a r6) {
        tt5.a.h(TAG, "onRefreshFromDatabase start");
        n r0 = new n(r6);
        if (r0.b == false) goto L5;
        VirtualNode r7 = lq5.e.a;
        Flowable r8 = Flowable.just("").observeOn(fo5.d.c()).map(lq5.c.a).onErrorResumeNext(lq5.d.a);
        VirtualNode r2 = oq5.c.a;
        Flowable r3 = oq5.c.a(r0.a);
        VirtualNode r4 = nq5.e.a;
        Intrinsics.checkNotNullParameter(r0.a, "userComponentAbility");
        Flowable r1 = Flowable.just("").observeOn(fo5.d.c()).map(nq5.c.a).onErrorResumeNext(nq5.d.a);
        int r5 = mq5.d.a;
        Flowable<Pair<kq5.c, WikiRelation>> r9 = Flowable.concat(r8, r3, r1, mq5.d.a(r0.a));
        Intrinsics.checkNotNull(r9);
        return r9;
    L5:
        VirtualNode r10 = lq5.e.a;
        Flowable r11 = Flowable.just("").observeOn(fo5.d.c()).map(lq5.c.a).onErrorResumeNext(lq5.d.a);
        VirtualNode r12 = oq5.c.a;
        Flowable r13 = oq5.c.a(r0.a);
        int r14 = mq5.d.a;
        Flowable<Pair<kq5.c, WikiRelation>> r15 = Flowable.concat(r11, r13, mq5.d.a(r0.a));
        Intrinsics.checkNotNull(r15);
        return r15;
    }

    private final Flowable<Pair<kq5.c, WikiRelation>> onRefreshFromNetwork(ce5.a r5) {
        tt5.a.h(TAG, "onRefreshFromNetwork start");
        n r0 = new n(r5);
        if (r0.b == false) goto L5;
        VirtualNode r6 = lq5.e.a;
        Flowable r7 = lq5.e.a(r0.a);
        VirtualNode r1 = oq5.c.a;
        Flowable r2 = oq5.c.b(r0.a);
        VirtualNode r3 = nq5.e.a;
        Flowable r4 = nq5.e.a(r0.a);
        int r8 = mq5.d.a;
        Flowable<Pair<kq5.c, WikiRelation>> r9 = Flowable.concat(r7, r2, r4, mq5.d.b(r0.a));
        Intrinsics.checkNotNull(r9);
        return r9;
    L5:
        VirtualNode r10 = lq5.e.a;
        Flowable r11 = lq5.e.a(r0.a);
        VirtualNode r12 = oq5.c.a;
        Flowable r13 = oq5.c.b(r0.a);
        int r14 = mq5.d.a;
        Flowable<Pair<kq5.c, WikiRelation>> r15 = Flowable.concat(r11, r13, mq5.d.b(r0.a));
        Intrinsics.checkNotNull(r15);
        return r15;
    }

    private final void updateRootRelation(e3 r5) {
        if (r5 == null) goto L13;
        Map<String, List<String>> r0 = r5.c();
        Map<String, TreeNode> r6 = r5.b();
        WikiRelation.Tree r1 = this.rootRelation.tree;
        Iterator r7 = ((ConcurrentHashMap) r6).entrySet().iterator();
    L5:
        if (r7.hasNext() == false) goto L7;
        TreeNode r2 = (TreeNode) ((Map.Entry) r7.next()).getValue();
        Intrinsics.checkNotNull(r1);
        kq5.e.b(r2, r1, true);
        goto L5
    L7:
        Iterator r8 = ((ConcurrentHashMap) r0).entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L20;
        Map.Entry r3 = (Map.Entry) r8.next();
        String r4 = (String) r3.getKey();
        List<String> r9 = (List) r3.getValue();
        if (r9 == null) goto L9;
        r1.child_map.put(r4, r9);
        goto L9
    L20:
        return;
    }

    public final Flowable<Pair<kq5.c, e3>> onRefreshFromDatabaseAndNetwork(ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        return Flowable.just("").map(new b(this)).observeOn(fo5.d.c()).flatMap(new c(this, r3)).observeOn(fo5.d.c()).map(new d(this, r3));
    }

    public final Flowable<Pair<kq5.c, e3>> onRefreshFromNet(ce5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        return Flowable.just("").map(new e(this)).flatMap(new f(this, r3)).observeOn(fo5.d.c()).map(new g(this, r3));
    }

    public static final /* synthetic */ void access$onBeforeRefresh(SidebarTreeCtrlVM r0, e3 r1) {
        r0.onBeforeRefresh(r1);
    }

    public static final /* synthetic */ Flowable access$onRefreshFromDatabase(SidebarTreeCtrlVM r0, ce5.a r1) {
        return r0.onRefreshFromDatabase(r1);
    }

    public static final /* synthetic */ Flowable access$onRefreshFromNetwork(SidebarTreeCtrlVM r0, ce5.a r1) {
        return r0.onRefreshFromNetwork(r1);
    }

    public final Flowable<Pair<kq5.c, e3>> onRefreshFromNetWithType(ce5.a r3, List<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "userComponentAbility");
        Intrinsics.checkNotNullParameter(r4, "reloadType");
        return Flowable.just("").map(new h(this)).flatMap(new i(r3, r4)).observeOn(fo5.d.c()).map(new j(this, r3));
    }

    private final Pair<kq5.c, e3> addRelationAndCreateWorkspace(Pair<? extends kq5.c, ? extends WikiRelation> r5, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r6, ce5.a r7) {
        kq5.c r0 = (kq5.c) r5.getFirst();
        WikiRelation r8 = (WikiRelation) r5.getSecond();
        tt5.a.h(TAG, "addRelationAndCreateWorkspace, relation is valid= " + r8.isValid());
        return buildWorkspace(r0, r0.c(r8, this.rootRelation, r6), r6, r7);
    }

    public static final /* synthetic */ Pair access$addRelationAndCreateWorkspace(SidebarTreeCtrlVM r0, Pair r1, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r2, ce5.a r3) {
        return r0.addRelationAndCreateWorkspace(r1, r2, r3);
    }

    private final Pair<kq5.c, e3> buildWorkspace(kq5.c r5, WikiRelation r6, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.e r7, ce5.a r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        WikiRelation.Tree r1 = r6.tree;
        r1.favorite_root_token = "wikiroot%favorite";
        if (TextUtils.isEmpty(r1.pinedRootToken) == false) goto L6;
        r6.tree.pinedRootToken = "wikiroot%top_cloud_document_token";
    L6:
        if (TextUtils.isEmpty(r6.tree.spaceRootToken) == false) goto L9;
        r6.tree.spaceRootToken = "wikiroot%top_wiki_token";
    L9:
        if (TextUtils.isEmpty(r6.tree.shared_root_token) == false) goto L11;
        r6.tree.shared_root_token = "wikiroot%title_root_share_token";
    L11:
        r6.addRoot(TreeNode.createVirtualRoot(r6.space.space_id, "wikiroot%favorite", -1), null);
        e3 r2 = new e3(r6, r7, r8);
        this.lastWorkspace = r2;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r2, "workspace");
        return new Pair(r5, r2);
    }
}

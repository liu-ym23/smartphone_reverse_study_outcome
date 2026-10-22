package com.bytedance.ee.bear.wikiv2.more;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t4;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.o;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiDetailInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.bytedance.ee.bear.contract.route.parcelable.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f240993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f240994b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Pair<TreeNode, WikNodePerm> f240995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f240996b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f240995a, r101.f240995a) == true) goto L12;
            return false;
        L12:
            if (this.f240996b == r101.f240996b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f240995a.hashCode() * 31;
            long r101 = this.f240996b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "CachedMoveInfo(moveInfo=" + this.f240995a + ", createTime=" + this.f240996b + ')';
        }

        public final boolean a() {
            if ((System.currentTimeMillis() - this.f240996b) > 30000) goto L5;
            return true;
        L5:
            return false;
        }

        public a(Pair r100) {
            long r101 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r100, "moveInfo");
            this.f240995a = r100;
            this.f240996b = r101;
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.more.c$c, reason: collision with other inner class name */
    public static final class C3453c<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3453c<T1, T2, R> f240997a = null;

        static {
            f240997a = new C3453c();
        }

        public C3453c() {
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            TreeNode r102 = (TreeNode) r100;
            WikNodePerm r103 = (WikNodePerm) r101;
            Intrinsics.checkNotNullParameter(r102, "treeNode");
            Intrinsics.checkNotNullParameter(r103, "wikiPerm");
            return TuplesKt.to(r102, r103);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f240998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f240999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f241000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f241001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f241002e;

        public d(c r100, Fragment r101, Context r102, Function0<Unit> r103, Function0<Unit> r104) {
            this.f240998a = r100;
            this.f240999b = r101;
            this.f241000c = r102;
            this.f241001d = r103;
            this.f241002e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            c r102 = this.f240998a;
            Fragment r103 = this.f240999b;
            Context r104 = this.f241000c;
            Intrinsics.checkNotNull(r101);
            Function0<Unit> r105 = this.f241001d;
            Function0<Unit> r106 = this.f241002e;
            r102.getClass();
            c.d(r103, r104, r101, r105, r106);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f241003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f241004b;

        public e(Context r100, Function0<Unit> r101) {
            this.f241003a = r100;
            this.f241004b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("WikiListMoveServiceImpl", "openMoveSelectorFromList, fetch node or perm fail. ", (Throwable) r100, false);
            Context r101 = this.f241003a;
            Toast.showFailureText(r101, r101.getString(R.string.LarkCCM_CM_MoveDoc_Error_Toast));
            this.f241004b.invoke();
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f241005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f241006b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super Boolean, Unit> r100, boolean r101) {
            this.f241005a = r100;
            this.f241006b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f241005a.invoke(Boolean.valueOf(this.f241006b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f241007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f241008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f241009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f241010d;

        /* JADX WARN: Multi-variable type inference failed */
        public g(c r100, String r101, Function1<? super Boolean, Unit> r102, String r103) {
            this.f241007a = r100;
            this.f241008b = r101;
            this.f241009c = r102;
            this.f241010d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            ConcurrentHashMap<String, a> r102 = this.f241007a.f240993a;
            String r103 = this.f241008b;
            Intrinsics.checkNotNull(r101);
            r102.put(r103, new a(r101));
            this.f241009c.invoke(Boolean.valueOf(((WikNodePerm) r101.getSecond()).show_move));
            tt5.a.h("WikiListMoveServiceImpl", "prefetchMoveInfoFromList success. spaceId=" + this.f241010d);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f241011a;

        public h(String r100) {
            this.f241011a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("WikiListMoveServiceImpl", "prefetchMoveInfoFromList fail. spaceId=" + this.f241011a, (Throwable) r100, false);
        }
    }

    static {
        new b();
    }

    public c() {
        this.f240993a = new ConcurrentHashMap();
        this.f240994b = new Handler(Looper.getMainLooper());
    }

    public static Flowable c(String r100, String r101) {
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        return Flowable.zip(new GetNodePuller(r102).d(new GetNodePuller.Params(r100, r101)), new GetNodePermPuller(r102).d(new GetNodePermPuller.Params(r100, r101)), C3453c.f240997a);
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.e
    public final Disposable b(String r100, String r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "onResult");
        boolean r103 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L38;
        if (r101 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L38;
        CollectionsKt.removeAll(this.f240993a.entrySet(), WikiListMoveServiceImpl$clearExpiredMoveInfo$1.INSTANCE);
        String r106 = r100 + '#' + r101;
        a r107 = this.f240993a.get(r106);
        if (r107 != null) goto L21;
    L23:
        boolean r108 = false;
    L24:
        if (r108 == false) goto L37;
        a r109 = this.f240993a.get(r106);
        if (r109 == null) goto L34;
        Pair<TreeNode, WikNodePerm> r110 = r109.f240995a;
        if (r110 == null) goto L34;
        WikNodePerm r111 = r110.getSecond();
        if (r111 == null) goto L34;
        if (r111.show_move != true) goto L34;
        r103 = true;
    L34:
        this.f240994b.post(new f(r102, r103));
        return Disposables.disposed();
    L37:
        return c(r100, r101).subscribe(new g(this, r106, r102, r100), new h(r100));
    L21:
        if (r107.a() != true) goto L23;
        r108 = true;
        goto L24
    L12:
        if (r101.length() == 0) goto L15;
        r105 = false;
    L38:
        tt5.a.h("WikiListMoveServiceImpl", "prefetchMoveInfoFromList, wiki params empty. spaceId=" + r100 + ", wikiToken=" + r101);
        return Disposables.disposed();
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static void d(Fragment r110, Context r111, Pair r112, Function0 r210, Function0 r211) {
        TreeNode r100 = (TreeNode) r112.component1();
        WikNodePerm r101 = (WikNodePerm) r112.component2();
        if (r101.show_move == true) goto L6;
        Toast.showFailureText(r111, r111.getString(R.string.Doc_List_MakeMoveForbidden, new Object[]{t0.n(r111, sbb.e.f541303n.f541317b)}));
        r211.invoke();
        return;
    L6:
        r210.invoke();
        Bundle r113 = new Bundle();
        r113.putInt("srcIsLock", r101.is_locked ? 1 : 0);
        r113.putString("src_space_id", r100.space_id);
        r113.putString("src_parent_token", r100.parent_wiki_token);
        r113.putString("src_token", r100.wiki_token);
        r113.putInt("src_obj_type", r100.obj_type);
        r113.putInt("EXTRA_PAGE_MODE", 2);
        r113.putString("trigger_location", "wiki_tree");
        r113.putBoolean("src_is_shortcut", r100.isShortcut());
        String r102 = null;
        if ((r111 instanceof Activity) == false) goto L9;
        Activity r103 = (Activity) r111;
    L10:
        if (r103 == null) goto L12;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r103);
    L12:
        qc5.a.j();
        if (r100.isShortcut() == true) goto L18;
        String r104 = r100.space_id;
        String r105 = r100.parent_wiki_token;
        String r106 = r100.wiki_token;
        boolean r107 = r100.has_child;
        String r108 = r100.title;
        WikiDetailInfo r109 = r100.detail_info;
        if (r109 == null) goto L17;
        r102 = r109.owner_id;
    L17:
        o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r110, r111, r104, r105, r106, r107, r108, r101, 1029, r113, false, t4.a(r102), r100.obj_token, r100.obj_type));
    L19:
        r211.invoke();
        return;
    L18:
        SelectorConfig r114 = new SelectorConfig();
        r114.c(SelectorType.WIKI_MOVE_TO);
        r114.a(SelectorScope.WIKI_ONLY);
        r114.f229375g = 1029;
        r114.f229372d = true;
        r114.b(r111.getString(R.string.LarkCCM_Wiki_MoveTo_Header_Mob));
        r113.putParcelable(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG, r114);
        o.f(r110, r113);
        gq5.d.j("move_to", r100.space_id);
        goto L19
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.e
    public final Disposable a(Fragment r100, Context r101, String r102, String r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "onOperationStarted");
        Intrinsics.checkNotNullParameter(r112, "onFinish");
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L28;
        if (r110 != null) goto L12;
    L15:
        if (r103 == true) goto L28;
        CollectionsKt.removeAll(this.f240993a.entrySet(), WikiListMoveServiceImpl$clearExpiredMoveInfo$1.INSTANCE);
        a r105 = this.f240993a.remove(r102 + '#' + r110);
        if (r105 != null) goto L20;
    L22:
        r105 = null;
    L23:
        if (r105 == null) goto L27;
        d(r100, r101, r105.f240995a, r111, r112);
        return Disposables.empty();
    L27:
        return c(r102, r110).subscribe(new d(this, r100, r101, r111, r112), new e(r101, r112));
    L20:
        if (r105.a() == false) goto L22;
    L12:
        if (r110.length() == 0) goto L15;
        r103 = false;
    L28:
        tt5.a.h("WikiListMoveServiceImpl", "openMoveSelectorFromList, wiki params empty. spaceId=" + r102 + ", wikiToken=" + r110);
        Toast.showFailureText(r101, r101.getString(R.string.LarkCCM_CM_MoveDoc_Error_Toast));
        r112.invoke();
        return Disposables.empty();
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}

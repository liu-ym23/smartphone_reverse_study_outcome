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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.contract.route.parcelable.e {
    public final ConcurrentHashMap<String, a> a;
    public final Handler b;

    public static final class a {
        public final Pair<TreeNode, WikNodePerm> a;
        public final long b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "CachedMoveInfo(moveInfo=" + this.a + ", createTime=" + this.b + ')';
        }

        public final boolean a() {
            if ((System.currentTimeMillis() - this.b) > 30000) goto L5;
            return true;
        L5:
            return false;
        }

        public a(Pair r4) {
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r4, "moveInfo");
            this.a = r4;
            this.b = r0;
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.more.c$c, reason: collision with other inner class name */
    public static final class C0206c<T1, T2, R> implements BiFunction {
        public static final C0206c<T1, T2, R> a = null;

        static {
            a = new C0206c();
        }

        public C0206c() {
        }

        public final Object apply(Object r2, Object r3) {
            TreeNode r4 = (TreeNode) r2;
            WikNodePerm r5 = (WikNodePerm) r3;
            Intrinsics.checkNotNullParameter(r4, "treeNode");
            Intrinsics.checkNotNullParameter(r5, "wikiPerm");
            return TuplesKt.to(r4, r5);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ c a;
        public final /* synthetic */ Fragment b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ Function0<Unit> d;
        public final /* synthetic */ Function0<Unit> e;

        public d(c r1, Fragment r2, Context r3, Function0<Unit> r4, Function0<Unit> r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            c r0 = this.a;
            Fragment r1 = this.b;
            Context r2 = this.c;
            Intrinsics.checkNotNull(r7);
            Function0<Unit> r3 = this.d;
            Function0<Unit> r4 = this.e;
            r0.getClass();
            c.d(r1, r2, r7, r3, r4);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Function0<Unit> b;

        public e(Context r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            tt5.a.e("WikiListMoveServiceImpl", "openMoveSelectorFromList, fetch node or perm fail. ", (Throwable) r4, false);
            Context r5 = this.a;
            Toast.showFailureText(r5, r5.getString(2131888787));
            this.b.invoke();
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ Function1<Boolean, Unit> a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Function1<? super Boolean, Unit> r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke(Boolean.valueOf(this.b));     // Catch: Throwable -> L4
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
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<Boolean, Unit> c;
        public final /* synthetic */ String d;

        /* JADX WARN: Multi-variable type inference failed */
        public g(c r1, String r2, Function1<? super Boolean, Unit> r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Pair r5 = (Pair) r4;
            ConcurrentHashMap<String, a> r0 = this.a.a;
            String r1 = this.b;
            Intrinsics.checkNotNull(r5);
            r0.put(r1, new a(r5));
            this.c.invoke(Boolean.valueOf(((WikNodePerm) r5.getSecond()).show_move));
            tt5.a.h("WikiListMoveServiceImpl", "prefetchMoveInfoFromList success. spaceId=" + this.d);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ String a;

        public h(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("WikiListMoveServiceImpl", "prefetchMoveInfoFromList fail. spaceId=" + this.a, (Throwable) r4, false);
        }
    }

    static {
        new b();
    }

    public c() {
        this.a = new ConcurrentHashMap();
        this.b = new Handler(Looper.getMainLooper());
    }

    public static Flowable c(String r3, String r4) {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        return Flowable.zip(new GetNodePuller(r0).d(new GetNodePuller.Params(r3, r4)), new GetNodePermPuller(r0).d(new GetNodePermPuller.Params(r3, r4)), C0206c.a);
    }

    public final Disposable b(String r5, String r6, Function1<? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "onResult");
        boolean r0 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L38;
        if (r6 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L38;
        CollectionsKt.removeAll(this.a.entrySet(), WikiListMoveServiceImpl$clearExpiredMoveInfo$1.INSTANCE);
        String r4 = r5 + '#' + r6;
        a r8 = this.a.get(r4);
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 == false) goto L37;
        a r10 = this.a.get(r4);
        if (r10 == null) goto L34;
        Pair<TreeNode, WikNodePerm> r11 = r10.a;
        if (r11 == null) goto L34;
        WikNodePerm r12 = (WikNodePerm) r11.getSecond();
        if (r12 == null) goto L34;
        if (r12.show_move != true) goto L34;
        r0 = true;
    L34:
        this.b.post(new f(r7, r0));
        return Disposables.disposed();
    L37:
        return c(r5, r6).subscribe(new g(this, r4, r7, r5), new h(r5));
    L21:
        if (r8.a() != true) goto L23;
        r9 = true;
        goto L24
    L12:
        if (r6.length() == 0) goto L15;
        r3 = false;
    L38:
        tt5.a.h("WikiListMoveServiceImpl", "prefetchMoveInfoFromList, wiki params empty. spaceId=" + r5 + ", wikiToken=" + r6);
        return Disposables.disposed();
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void d(Fragment r17, Context r18, Pair r19, Function0 r20, Function0 r21) {
        TreeNode r0 = (TreeNode) r19.component1();
        WikNodePerm r8 = (WikNodePerm) r19.component2();
        if (r8.show_move == true) goto L6;
        Toast.showFailureText(r18, r18.getString(2131887930, new Object[]{t0.n(r18, sbb.e.n.b)}));
        r21.invoke();
        return;
    L6:
        r20.invoke();
        Bundle r10 = new Bundle();
        r10.putInt("srcIsLock", r8.is_locked ? 1 : 0);
        r10.putString("src_space_id", r0.space_id);
        r10.putString("src_parent_token", r0.parent_wiki_token);
        r10.putString("src_token", r0.wiki_token);
        r10.putInt("src_obj_type", r0.obj_type);
        r10.putInt("EXTRA_PAGE_MODE", 2);
        r10.putString("trigger_location", "wiki_tree");
        r10.putBoolean("src_is_shortcut", r0.isShortcut());
        String r4 = null;
        if ((r18 instanceof Activity) == false) goto L9;
        Activity r1 = (Activity) r18;
    L10:
        if (r1 == null) goto L12;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).setActivity(r1);
    L12:
        qc5.a.j();
        if (r0.isShortcut() == true) goto L18;
        String r3 = r0.space_id;
        String r5 = r0.parent_wiki_token;
        String r6 = r0.wiki_token;
        boolean r7 = r0.has_child;
        String r9 = r0.title;
        WikiDetailInfo r2 = r0.detail_info;
        if (r2 == null) goto L17;
        r4 = r2.owner_id;
    L17:
        o.d(new com.bytedance.ee.bear.wikiv2.wikitreev2.main.b(r17, r18, r3, r5, r6, r7, r9, r8, 1029, r10, false, t4.a(r4), r0.obj_token, r0.obj_type));
    L19:
        r21.invoke();
        return;
    L18:
        SelectorConfig r11 = new SelectorConfig();
        r11.c(SelectorType.WIKI_MOVE_TO);
        r11.a(SelectorScope.WIKI_ONLY);
        r11.g = 1029;
        r11.d = true;
        r11.b(r18.getString(2131889814));
        r10.putParcelable("extra_config", r11);
        o.f(r17, r10);
        gq5.d.j("move_to", r0.space_id);
        goto L19
    L9:
        r1 = null;
        goto L10
    }

    public final Disposable a(Fragment r7, Context r8, String r9, String r10, Function0<Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "onOperationStarted");
        Intrinsics.checkNotNullParameter(r12, "onFinish");
        boolean r0 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L28;
        if (r10 != null) goto L12;
    L15:
        if (r0 == true) goto L28;
        CollectionsKt.removeAll(this.a.entrySet(), WikiListMoveServiceImpl$clearExpiredMoveInfo$1.INSTANCE);
        a r1 = this.a.remove(r9 + '#' + r10);
        if (r1 != null) goto L20;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L27;
        d(r7, r8, r1.a, r11, r12);
        return Disposables.empty();
    L27:
        return c(r9, r10).subscribe(new d(this, r7, r8, r11, r12), new e(r8, r12));
    L20:
        if (r1.a() == false) goto L22;
    L12:
        if (r10.length() == 0) goto L15;
        r0 = false;
    L28:
        tt5.a.h("WikiListMoveServiceImpl", "openMoveSelectorFromList, wiki params empty. spaceId=" + r9 + ", wikiToken=" + r10);
        Toast.showFailureText(r8, r8.getString(2131888787));
        r12.invoke();
        return Disposables.empty();
    L5:
        if (r9.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}

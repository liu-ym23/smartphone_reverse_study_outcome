package com.bytedance.ee.bear.bitable.uikit.tree;

import android.graphics.Canvas;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.TreeItemTouchHelper;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemTreeAdapter;
import com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback;
import com.bytedance.ee.bear.document.pageedit.PageEditPlugin;
import com.bytedance.ee.util.ui.j;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0084\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0004\u0083\u0001\u0084\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u0013H\u0016J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\u0003H\u0016J\u001a\u0010<\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010=\u001a\u00020\u0017J\u0018\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020 2\b\b\u0002\u0010=\u001a\u00020\u0017J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020 H\u0016J\u000e\u00108\u001a\u00020\u00172\u0006\u0010A\u001a\u00020 J(\u0010B\u001a\u0002072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010C\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010E\u001a\u00020\u0017H\u0016J\u000e\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\u0017J\u0010\u0010H\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010I\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\b\u0010J\u001a\u00020 H\u0016J\u000e\u0010K\u001a\u0002072\u0006\u0010A\u001a\u00020 J\u001a\u0010L\u001a\u0002072\u0006\u0010A\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010M\u001a\u0002072\u0006\u00109\u001a\u00020\u0013J&\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020\u0017J \u0010S\u001a\u0002072\u0006\u0010O\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010R\u001a\u00020\u0017H\u0002J\u000e\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020\u0013J\u001f\u0010V\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010W\u001a\u00020\u0013H&¢\u0006\u0002\u0010XJ\u0012\u0010Y\u001a\u0004\u0018\u00010\u00102\u0006\u0010A\u001a\u00020 H\u0002J\u0015\u0010Z\u001a\u0004\u0018\u00018\u00002\u0006\u0010A\u001a\u00020 ¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\b\u0010]\u001a\u00020 H\u0016J\u0006\u0010^\u001a\u00020\u0017J \u0010_\u001a\u0002072\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020 2\u0006\u0010b\u001a\u00020 H\u0002J\u0012\u0010c\u001a\u0002072\b\u0010U\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010d\u001a\u000207H\u0002J\u0010\u0010e\u001a\u0002072\u0006\u00109\u001a\u00020\u0013H\u0002J\b\u0010f\u001a\u00020gH\u0004J\u0019\u0010h\u001a\u0004\u0018\u00010 2\b\u0010i\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0017H\u0002J\u001c\u0010l\u001a\u0002072\b\b\u0002\u0010m\u001a\u00020\u00172\b\b\u0002\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u000207H\u0002J\u001a\u0010p\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020 H\u0016J\u001a\u0010q\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020 H\u0016J\u001a\u0010r\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u0002072\u0006\u0010v\u001a\u00020\u0013H\u0016J\u0010\u0010w\u001a\u0002072\u0006\u0010A\u001a\u00020 H\u0016J0\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020z2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010s\u001a\u00020t2\u0006\u0010{\u001a\u00020 2\u0006\u0010|\u001a\u00020}H\u0016J%\u0010~\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u007f2\u0007\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010O\u001a\u00020 H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0002J\u001a\u0010\u0082\u0001\u001a\u00020 2\u0007\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010O\u001a\u00020 H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSet;", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$OnDragChangedCallbackListener;", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator$OnMoveAnimationEndListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "model", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "data", "", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;", "collapsedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "searchCollapsedSet", "delayUpdate", "", "initCollapsedMap", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "notifyMoveToPos", "", "animator", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator;", "isAniming", "selectedItemCollapsed", "touchCallback", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "getTouchCallback", "()Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "touchCallback$delegate", "Lkotlin/Lazy;", "touchHelper", "Landroidx/recyclerview/widget/TreeItemTouchHelper;", "getTouchHelper", "()Landroidx/recyclerview/widget/TreeItemTouchHelper;", "touchHelper$delegate", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "scorllCallback", "Lkotlin/Function0;", "", "isItemCollapsed", "id", "onMoveAnimationEnd", "viewHolder", "smoothScrollToId", "onlyScrollWhenOutScreen", "smoothScrollToPos", "index", "isItemCanCollapsed", "position", "setData", "handler", "scrollId", "needGenerateTreeParent", "enableDragSort", "enable", "getLevel", "getMaxSubLevel", "getMaxLevel", "toggleTree", "onToggleTreeNodeNotify", "ensureTreeExpend", "move", "fromPosition", "toPosition", "targetLevel", "positionMoved", "notifyAndDoAnim", "searchKey", "key", "isContainKeyword", "keyword", "(Ljava/lang/Object;Ljava/lang/String;)Z", "safeGetItem", "safeGetItemData", "(I)Ljava/lang/Object;", "getParentPos", "getItemCount", "isDataEmpty", "animatorUpdate", PageEditPlugin.REMOVE, "firstIndex", "changeCount", "initCollapsedSet", "updateCollapsedSet", "toggleCollapsedSet", "getRenderTree", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "getIndex", "targetId", "(Ljava/lang/String;)Ljava/lang/Integer;", "shouldDelayUpdate", "updateNowOrDelay", "postRunnable", "forceDelay", "tryRunDelayUpdate", "onDragSelected", "onDragStart", "onDragFinish", "dragIntent", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragIntent;", "onNodeMoved", "selectedId", "onDropOverWait", "onDrawDropUI", "c", "Landroid/graphics/Canvas;", "drawOffsetX", "dropOverLineType", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "getLevelRange", "Lkotlin/Pair;", "dropPosition", "getMaxDepth", "getMinDepth", "BaseViewHolder", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TreeAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements ct4.d, DragTreeCallback.b, TreeItemAnimator.b {
    public static final /* synthetic */ int p = 0;
    public final RecyclerView a;
    public TreeListData<T> b;
    public List<RenderItem> c;
    public HashSet<String> d;
    public final HashSet<String> e;
    public boolean f;
    public boolean g;
    public gv4.a h;
    public int i;
    public boolean j;
    public boolean k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Function0<Unit> o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ TreeAdapter<T, VH> a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public b(TreeAdapter<T, VH> r1, int r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TreeAdapter<T, VH> r0 = this.a;     // Catch: Throwable -> L4
            int r1 = this.b;     // Catch: Throwable -> L4
            int r2 = this.c;     // Catch: Throwable -> L4
            boolean r3 = this.d;     // Catch: Throwable -> L4
            int r4 = TreeAdapter.p;     // Catch: Throwable -> L4
            r0.D2(r1, r2, r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ TreeAdapter<T, VH> b;

        public c(int r1, TreeAdapter<T, VH> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            tt5.a.h("TreeAdapter", "notifyAndDoAnim auto toggleTree:" + this.a);
            this.b.K2(this.a);
            ((Handler) this.b.n.getValue()).postDelayed(new d(this.b.o), 200);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ Function0 a;

        public d(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public abstract boolean A2(T r1, String r2);

    public boolean B2(int r1) {
        return false;
    }

    public void E2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedId");
    }

    public void F2(int r1, RecyclerView.ViewHolder r2) {
    }

    public void c2(Canvas r1, RecyclerView.ViewHolder r2, hv4.a r3, int r4, DragTreeCallback.DropOverLineType r5) {
        Intrinsics.checkNotNullParameter(r1, "c");
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "dragIntent");
        Intrinsics.checkNotNullParameter(r5, "dropOverLineType");
    }

    public void s2(RecyclerView.ViewHolder r1, int r2) {
    }

    public final int getItemCount() {
        return this.c.size();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int getMaxLevel() {
        Integer r0 = this.b.getMaxLevel();
        if (r0 != null) goto L5;
        return 3;
    L5:
        return r0.intValue();
    }

    public final RenderTree z2() {
        return this.b.getRenderTree();
    }

    public TreeAdapter(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a = r2;
        this.b = new TreeListData();
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new HashSet();
        this.i = -1;
        TreeItemAnimator r0 = new TreeItemAnimator();
        r2.setItemAnimator(r0);
        Intrinsics.checkNotNullParameter(this, "listener");
        r0.a = this;
        this.l = LazyKt.lazy(new TreeAdapter$touchCallback$2(this));
        this.m = LazyKt.lazy(new TreeAdapter$touchHelper$2(this));
        this.n = LazyKt.lazy(LazyThreadSafetyMode.NONE, TreeAdapter$mainHandler$2.INSTANCE);
        this.o = new TreeAdapter$scorllCallback$1(this);
    }

    public final boolean C2(int r3) {
        RenderItem r0 = G2(r3);
        if (r0 == null) goto L8;
        String r1 = r0.getId();
        if (r1 == null) goto L8;
        return q(r1);
    L8:
        tt5.a.k("TreeAdapter", "isItemCollapsed id is null, return false. position:" + r3);
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int E1(int r3) {
        RenderItem r4 = G2(r3);
        if (r4 == null) goto L18;
        String r5 = r4.getId();
        if (r5 == null) goto L19;
        RenderTree r6 = z2().findTree(r5);
        if (r6 == null) goto L20;
        RenderTree r7 = r6.getParent();
        if (r7 == null) goto L21;
        RenderItem r8 = r7.getCurrent();
        if (r8 == null) goto L22;
        String r9 = r8.getId();
        if (r9 == null) goto L23;
        Integer r10 = getIndex(r9);
        if (r10 != null) goto L17;
        return -100;
    L17:
        return r10.intValue();
    L23:
        return -100;
    L22:
        return -100;
    L21:
        return -100;
    L20:
        return -100;
    L19:
        return -100;
    L18:
        return -100;
    }

    public final RenderItem G2(int r3) {
        return (RenderItem) m.j(this.c, r3, null);
    }

    public final T H2(int r3) {
        String r1 = null;
        RenderItem r4 = (RenderItem) m.j(this.c, r3, null);
        if (r4 == null) goto L6;
        r1 = r4.getId();
    L6:
        return this.b.getDataMap().get(r1);
    }

    public final void I2(final String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        this.e.clear();
        if (TextUtils.isEmpty(r9) == true) goto L5;
        RenderTree.search$default(z2(), new TreeAdapter$searchKey$1(this, r9), false, 2, null);
        z2().toggleSearchState(true);
    L6:
        this.c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        notifyDataSetChanged();
        return;
    L5:
        z2().toggleSearchState(false);
        goto L6
    }

    public final void K2(int r11) {
        int r0 = z2().getRenderItemList().size();
        RenderItem r1 = G2(r11);
        if (r1 == null) goto L30;
        String r2 = r1.getId();
        if (r2 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(z2().getInSearch(), Boolean.TRUE) == false) goto L10;
        HashSet<String> r3 = this.e;
    L12:
        if (r3.contains(r2) == false) goto L14;
        r3.remove(r2);
    L15:
        this.c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        int r4 = z2().getRenderItemList().size();
        boolean r5 = q(r2);
        Integer r6 = getIndex(r2);
        if (r6 == null) goto L28;
        int r7 = r6.intValue();
        int r8 = Math.abs(r4 - r0);
        if (r5 == false) goto L20;
        notifyItemRangeRemoved(r7 + 1, r8);
    L21:
        RecyclerView.LayoutManager r9 = this.a.getLayoutManager();
        RecyclerView.ViewHolder r10 = null;
        if (r9 == null) goto L24;
        View r12 = r9.findViewByPosition(r11);
    L25:
        if (r12 == null) goto L27;
        r10 = this.a.findContainingViewHolder(r12);
    L27:
        F2(r11, r10);
        return;
    L24:
        r12 = null;
        goto L25
    L20:
        notifyItemRangeInserted(r7 + 1, r8);
        goto L21
    L28:
        L2(this, false);
        return;
    L14:
        r3.add(r2);
        goto L15
    L10:
        j.d(new com.bytedance.ee.bear.bitable.uikit.tree.a(this), 100);
        r3 = this.d;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int P1(int r2) {
        RenderItem r3 = G2(r2);
        if (r3 == null) goto L11;
        String r4 = r3.getId();
        if (r4 == null) goto L11;
        RenderTree r5 = z2().findTree(r4);
        if (r5 == null) goto L11;
        return r5.getDepth();
    L11:
        return getMaxLevel();
    }

    public final Integer getIndex(String r3) {
        List<RenderItem> r0 = this.c;
        RenderItem r1 = new RenderItem();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r1.setId(r3);
        int r4 = r0.indexOf(r1);
        if (r4 >= 0) goto L8;
        return null;
    L8:
        return Integer.valueOf(r4);
    }

    public final boolean q(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        if (Intrinsics.areEqual(z2().getInSearch(), Boolean.TRUE) == false) goto L6;
        return this.e.contains(r3);
    L6:
        return this.d.contains(r3);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void t(int r2) {
        if (C2(r2) == false) goto L6;
        K2(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeItemAnimator.b
    public final void w(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        this.j = false;
        if (this.f == false) goto L6;
        this.f = false;
        L2(this, true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int x(int r1) {
        RenderItem r2 = G2(r1);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getLevel();
    }

    public final void y2(boolean r3) {
        if (r3 == false) goto L6;
        ((TreeItemTouchHelper) this.m.getValue()).attachToRecyclerView(this.a);
        DragTreeCallback r4 = (DragTreeCallback) this.l.getValue();
        CatalogItemTreeAdapter r0 = (CatalogItemTreeAdapter) this;
        if (r4.b != null) goto L10;
        r4.b = r0;
        return;
    L10:
        return;
    L6:
        ((TreeItemTouchHelper) this.m.getValue()).attachToRecyclerView(null);
        DragTreeCallback r5 = (DragTreeCallback) this.l.getValue();
        if (r5.b != null) goto L12;
        r5.b = null;
        return;
    }

    public static void L2(TreeAdapter r2, boolean r3) {
        if (r2.a.isComputingLayout() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        r2.notifyDataSetChanged();
        return;
    L11:
        r2.f = true;
        if (r3 == false) goto L16;
        j.d(new com.bytedance.ee.bear.bitable.uikit.tree.b(r2), 500);
        return;
    L16:
        return;
    L5:
        if (r2.j == true) goto L8;
        r0 = false;
        goto L9
    }

    public void H0(RecyclerView.ViewHolder r1, int r2) {
        boolean r3 = C2(r2);
        this.k = r3;
        if (r3 == true) goto L6;
        K2(r2);
        return;
    }

    public final void J2(int r4, boolean r5) {
        LinearLayoutManager r0 = this.a.getLayoutManager();
        boolean r1 = true;
        if (r5 == true) goto L5;
    L11:
        if (r1 == false) goto L14;
        tt5.a.h("TreeAdapter", "smoothScrollToPos pos:" + r4 + " onlyScrollWhenOutScreen:" + r5);
        this.a.smoothScrollToPosition(r4);
        return;
    L14:
        return;
    L5:
        if ((r0 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r2 = r0;
        int r3 = r2.findFirstVisibleItemPosition();
        int r6 = r2.findLastVisibleItemPosition();
        if (r4 < r3) goto L11;
        if (r4 > r6) goto L11;
        r1 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final Pair<Integer, Integer> c0(int r5, int r6) {
        int r0 = 1;
        if (r5 < 0) goto L5;
        int r2 = r5 + 1;
        if (r2 != r6) goto L9;
        r2 = r5 + 2;
    L9:
        RenderItem r7 = G2(r2);
        if (r7 == null) goto L12;
        int r8 = Math.max(r7.getLevel(), 1);
    L13:
        Integer r9 = Integer.valueOf(r8);
        RenderItem r3 = G2(r5);
        if (r3 == null) goto L23;
        int r4 = r3.getLevel();
        if (B2(r5) == true) goto L18;
    L20:
        r0 = 0;
    L21:
        r0 = r0 + r4;
        goto L23
    L18:
        if (q(r3.getId()) == true) goto L20;
    L23:
        return new Pair(r9, Integer.valueOf(r0));
    L12:
        r8 = 1;
        goto L13
    L5:
        return new Pair(1, 1);
    }

    public void e1(RecyclerView.ViewHolder r12, hv4.a r13) {
        Intrinsics.checkNotNullParameter(r13, "dragIntent");
        r13.getClass();
        int r6 = r13.a;
        int r1 = r13.b;
        int r7 = r13.d;
        int r2 = r13.g;
        boolean r0 = r13.i;
        tt5.a.h("TreeAdapter", "onDragFinish fromPosition:" + r6 + "   toPosition:" + r7 + "   moveToLevel:" + r2);
        int r4 = 1;
        if (r0 == false) goto L14;
        if (r7 < r6) goto L6;
        if (r7 == r6) goto L10;
    L9:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        if (r1 == r2) goto L14;
    L13:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L48;
        if (r7 < r6) goto L18;
        if (r7 == r6) goto L22;
    L21:
        boolean r9 = true;
    L23:
        if (r6 != r7) goto L25;
        int r8 = r7 - 1;
    L26:
        RenderItem r10 = G2(r6);
        if (r10 == null) goto L49;
        String r11 = r10.getId();
        if (r11 != null) goto L32;
        return;
    L32:
        if (r8 != (-1)) goto L34;
        RenderTree.Companion.getClass();
        String r14 = RenderTree.access$getROOT$cp();
    L39:
        if (r8 == (-1)) goto L42;
        r4 = r2 - x(r8);
    L42:
        z2().moveTree(r11, r14, r4);
        this.c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        if (r7 >= r6) goto L46;
        r7 = r7 + 1;
    L46:
        this.i = r7;
        tt5.a.h("TreeAdapter", "move notifyItemChanged fromPosition:" + r6 + " notifyMoveToPos:" + r7);
        D2(r6, r7, r9);
        E2(r11);
        return;
    L34:
        RenderItem r16 = G2(r8);
        if (r16 == null) goto L50;
        r14 = r16.getId();
        if (r14 != null) goto L39;
        return;
    L50:
        return;
    L49:
        return;
    L25:
        r8 = r7;
    L22:
        r9 = false;
        goto L23
    L18:
        if ((r6 - r7) <= 1) goto L22;
    L48:
        return;
    L10:
        r3 = false;
        goto L11
    L6:
        if ((r6 - r7) <= 1) goto L10;
    L14:
        r5 = false;
        goto L15
    }

    public final void D2(int r4, int r5, boolean r6) {
        if (this.a.isComputingLayout() == false) goto L6;
        tt5.a.h("TreeAdapter", "notifyAndDoAnim do next loop.");
        ThreadUtils.runOnUIThread(new b(this, r4, r5, r6));
        return;
    L6:
        tt5.a.h("TreeAdapter", "notifyAndDoAnim selectedItemCollapsed:" + this.k);
        notifyItemChanged(r5);
        if (r6 == false) goto L10;
        this.j = true;
        notifyItemMoved(r4, r5);
    L10:
        if (this.k == true) goto L12;
        ThreadUtils.runOnUIThread(new c(r5, this), 100);
        return;
    L12:
        ((Handler) this.n.getValue()).postDelayed(new d(this.o), 200);
    }
}

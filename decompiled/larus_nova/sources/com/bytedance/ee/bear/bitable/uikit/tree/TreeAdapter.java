package com.bytedance.ee.bear.bitable.uikit.tree;

import android.graphics.Canvas;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.TreeItemTouchHelper;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemTreeAdapter;
import com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback;
import com.bytedance.ee.util.ui.j;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0084\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0004\u0083\u0001\u0084\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u0013H\u0016J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\u0003H\u0016J\u001a\u0010<\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010=\u001a\u00020\u0017J\u0018\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020 2\b\b\u0002\u0010=\u001a\u00020\u0017J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020 H\u0016J\u000e\u00108\u001a\u00020\u00172\u0006\u0010A\u001a\u00020 J(\u0010B\u001a\u0002072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010C\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010E\u001a\u00020\u0017H\u0016J\u000e\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\u0017J\u0010\u0010H\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\u0010\u0010I\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\b\u0010J\u001a\u00020 H\u0016J\u000e\u0010K\u001a\u0002072\u0006\u0010A\u001a\u00020 J\u001a\u0010L\u001a\u0002072\u0006\u0010A\u001a\u00020 2\b\u0010;\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010M\u001a\u0002072\u0006\u00109\u001a\u00020\u0013J&\u0010N\u001a\u0002072\u0006\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020\u0017J \u0010S\u001a\u0002072\u0006\u0010O\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010R\u001a\u00020\u0017H\u0002J\u000e\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020\u0013J\u001f\u0010V\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010W\u001a\u00020\u0013H&¢\u0006\u0002\u0010XJ\u0012\u0010Y\u001a\u0004\u0018\u00010\u00102\u0006\u0010A\u001a\u00020 H\u0002J\u0015\u0010Z\u001a\u0004\u0018\u00018\u00002\u0006\u0010A\u001a\u00020 ¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0016J\b\u0010]\u001a\u00020 H\u0016J\u0006\u0010^\u001a\u00020\u0017J \u0010_\u001a\u0002072\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020 2\u0006\u0010b\u001a\u00020 H\u0002J\u0012\u0010c\u001a\u0002072\b\u0010U\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010d\u001a\u000207H\u0002J\u0010\u0010e\u001a\u0002072\u0006\u00109\u001a\u00020\u0013H\u0002J\b\u0010f\u001a\u00020gH\u0004J\u0019\u0010h\u001a\u0004\u0018\u00010 2\b\u0010i\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020\u0017H\u0002J\u001c\u0010l\u001a\u0002072\b\b\u0002\u0010m\u001a\u00020\u00172\b\b\u0002\u0010n\u001a\u00020\u0017H\u0002J\b\u0010o\u001a\u000207H\u0002J\u001a\u0010p\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020 H\u0016J\u001a\u0010q\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020 H\u0016J\u001a\u0010r\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u0010s\u001a\u00020tH\u0016J\u0010\u0010u\u001a\u0002072\u0006\u0010v\u001a\u00020\u0013H\u0016J\u0010\u0010w\u001a\u0002072\u0006\u0010A\u001a\u00020 H\u0016J0\u0010x\u001a\u0002072\u0006\u0010y\u001a\u00020z2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010s\u001a\u00020t2\u0006\u0010{\u001a\u00020 2\u0006\u0010|\u001a\u00020}H\u0016J%\u0010~\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u007f2\u0007\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010O\u001a\u00020 H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020 2\u0006\u0010A\u001a\u00020 H\u0002J\u001a\u0010\u0082\u0001\u001a\u00020 2\u0007\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010O\u001a\u00020 H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b2\u00103R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020706X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/ICollapsedSet;", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$OnDragChangedCallbackListener;", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator$OnMoveAnimationEndListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "data", "", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderItem;", "collapsedSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "searchCollapsedSet", "delayUpdate", "", "initCollapsedMap", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getActionHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setActionHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "notifyMoveToPos", "", "animator", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeItemAnimator;", "isAniming", "selectedItemCollapsed", "touchCallback", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "getTouchCallback", "()Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback;", "touchCallback$delegate", "Lkotlin/Lazy;", "touchHelper", "Landroidx/recyclerview/widget/TreeItemTouchHelper;", "getTouchHelper", "()Landroidx/recyclerview/widget/TreeItemTouchHelper;", "touchHelper$delegate", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "scorllCallback", "Lkotlin/Function0;", "", "isItemCollapsed", "id", "onMoveAnimationEnd", "viewHolder", "smoothScrollToId", "onlyScrollWhenOutScreen", "smoothScrollToPos", "index", "isItemCanCollapsed", "position", "setData", "handler", "scrollId", "needGenerateTreeParent", "enableDragSort", "enable", "getLevel", "getMaxSubLevel", "getMaxLevel", "toggleTree", "onToggleTreeNodeNotify", "ensureTreeExpend", "move", "fromPosition", "toPosition", "targetLevel", "positionMoved", "notifyAndDoAnim", "searchKey", "key", "isContainKeyword", "keyword", "(Ljava/lang/Object;Ljava/lang/String;)Z", "safeGetItem", "safeGetItemData", "(I)Ljava/lang/Object;", "getParentPos", "getItemCount", "isDataEmpty", "animatorUpdate", "remove", "firstIndex", "changeCount", "initCollapsedSet", "updateCollapsedSet", "toggleCollapsedSet", "getRenderTree", "Lcom/bytedance/ee/bear/bitable/uikit/tree/RenderTree;", "getIndex", "targetId", "(Ljava/lang/String;)Ljava/lang/Integer;", "shouldDelayUpdate", "updateNowOrDelay", "postRunnable", "forceDelay", "tryRunDelayUpdate", "onDragSelected", "onDragStart", "onDragFinish", "dragIntent", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragIntent;", "onNodeMoved", "selectedId", "onDropOverWait", "onDrawDropUI", "c", "Landroid/graphics/Canvas;", "drawOffsetX", "dropOverLineType", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "getLevelRange", "Lkotlin/Pair;", "dropPosition", "getMaxDepth", "getMinDepth", "BaseViewHolder", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class TreeAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements ct4.d, DragTreeCallback.b, TreeItemAnimator.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f216230p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f216231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TreeListData<T> f216232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<RenderItem> f216233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashSet<String> f216234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<String> f216235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f216236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f216237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gv4.a f216238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f216239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f216240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f216241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f216242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f216243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f216244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f216245o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TreeAdapter<T, VH> f216246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f216247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f216248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f216249d;

        public b(TreeAdapter<T, VH> r100, int r101, int r102, boolean r103) {
            this.f216246a = r100;
            this.f216247b = r101;
            this.f216248c = r102;
            this.f216249d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TreeAdapter<T, VH> r100 = this.f216246a;     // Catch: Throwable -> L4
            int r101 = this.f216247b;     // Catch: Throwable -> L4
            int r102 = this.f216248c;     // Catch: Throwable -> L4
            boolean r103 = this.f216249d;     // Catch: Throwable -> L4
            int r104 = TreeAdapter.f216230p;     // Catch: Throwable -> L4
            r100.D2(r101, r102, r103);     // Catch: Throwable -> L4
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f216250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TreeAdapter<T, VH> f216251b;

        public c(int r100, TreeAdapter<T, VH> r101) {
            this.f216250a = r100;
            this.f216251b = r101;
        }

        public final void a() {
            tt5.a.h("TreeAdapter", "notifyAndDoAnim auto toggleTree:" + this.f216250a);
            this.f216251b.K2(this.f216250a);
            ((Handler) this.f216251b.f216244n.getValue()).postDelayed(new d(this.f216251b.f216245o), 200);
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f216252a;

        public d(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f216252a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f216252a.invoke();     // Catch: Throwable -> L4
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

    public abstract boolean A2(T r100, String r101);

    public boolean B2(int r100) {
        return false;
    }

    public void E2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedId");
    }

    public void F2(int r100, RecyclerView.ViewHolder r101) {
    }

    public void c2(Canvas r100, RecyclerView.ViewHolder r101, hv4.a r102, int r103, DragTreeCallback.DropOverLineType r104) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, "dragIntent");
        Intrinsics.checkNotNullParameter(r104, "dropOverLineType");
    }

    public void s2(RecyclerView.ViewHolder r100, int r101) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f216233c.size();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int getMaxLevel() {
        Integer r100 = this.f216232b.getMaxLevel();
        if (r100 != null) goto L5;
        return 3;
    L5:
        return r100.intValue();
    }

    public final RenderTree z2() {
        return this.f216232b.getRenderTree();
    }

    public TreeAdapter(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f216231a = r100;
        this.f216232b = new TreeListData();
        this.f216233c = new ArrayList();
        this.f216234d = new HashSet();
        this.f216235e = new HashSet();
        this.f216239i = -1;
        TreeItemAnimator r101 = new TreeItemAnimator();
        r100.setItemAnimator(r101);
        Intrinsics.checkNotNullParameter(this, "listener");
        r101.f216253a = this;
        this.f216242l = LazyKt.lazy(new TreeAdapter$touchCallback$2(this));
        this.f216243m = LazyKt.lazy(new TreeAdapter$touchHelper$2(this));
        this.f216244n = LazyKt.lazy(LazyThreadSafetyMode.NONE, TreeAdapter$mainHandler$2.INSTANCE);
        this.f216245o = new TreeAdapter$scorllCallback$1(this);
    }

    public final boolean C2(int r100) {
        RenderItem r101 = G2(r100);
        if (r101 == null) goto L8;
        String r102 = r101.getId();
        if (r102 == null) goto L8;
        return q(r102);
    L8:
        tt5.a.k("TreeAdapter", "isItemCollapsed id is null, return false. position:" + r100);
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int E1(int r100) {
        RenderItem r101 = G2(r100);
        if (r101 == null) goto L18;
        String r102 = r101.getId();
        if (r102 == null) goto L19;
        RenderTree r103 = z2().findTree(r102);
        if (r103 == null) goto L20;
        RenderTree r104 = r103.getParent();
        if (r104 == null) goto L21;
        RenderItem r105 = r104.getCurrent();
        if (r105 == null) goto L22;
        String r106 = r105.getId();
        if (r106 == null) goto L23;
        Integer r107 = getIndex(r106);
        if (r107 != null) goto L17;
        return -100;
    L17:
        return r107.intValue();
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

    public final RenderItem G2(int r100) {
        return (RenderItem) m.j(this.f216233c, r100, null);
    }

    public final T H2(int r100) {
        String r101 = null;
        RenderItem r102 = (RenderItem) m.j(this.f216233c, r100, null);
        if (r102 == null) goto L6;
        r101 = r102.getId();
    L6:
        return this.f216232b.getDataMap().get(r101);
    }

    public final void I2(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f216235e.clear();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        RenderTree.search$default(z2(), new TreeAdapter$searchKey$1(this, r100), false, 2, null);
        z2().toggleSearchState(true);
    L6:
        this.f216233c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        notifyDataSetChanged();
        return;
    L5:
        z2().toggleSearchState(false);
        goto L6
    }

    public final void K2(int r110) {
        int r100 = z2().getRenderItemList().size();
        RenderItem r101 = G2(r110);
        if (r101 == null) goto L30;
        String r102 = r101.getId();
        if (r102 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(z2().getInSearch(), Boolean.TRUE) == false) goto L10;
        HashSet<String> r103 = this.f216235e;
    L12:
        if (r103.contains(r102) == false) goto L14;
        r103.remove(r102);
    L15:
        this.f216233c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        int r104 = z2().getRenderItemList().size();
        boolean r105 = q(r102);
        Integer r106 = getIndex(r102);
        if (r106 == null) goto L28;
        int r107 = r106.intValue();
        int r108 = Math.abs(r104 - r100);
        if (r105 == false) goto L20;
        notifyItemRangeRemoved(r107 + 1, r108);
    L21:
        RecyclerView.LayoutManager r109 = this.f216231a.getLayoutManager();
        RecyclerView.ViewHolder r111 = null;
        if (r109 == null) goto L24;
        View r112 = r109.findViewByPosition(r110);
    L25:
        if (r112 == null) goto L27;
        r111 = this.f216231a.findContainingViewHolder(r112);
    L27:
        F2(r110, r111);
        return;
    L24:
        r112 = null;
        goto L25
    L20:
        notifyItemRangeInserted(r107 + 1, r108);
        goto L21
    L28:
        L2(this, false);
        return;
    L14:
        r103.add(r102);
        goto L15
    L10:
        j.d(new com.bytedance.ee.bear.bitable.uikit.tree.a(this), 100);
        r103 = this.f216234d;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int P1(int r100) {
        RenderItem r101 = G2(r100);
        if (r101 == null) goto L11;
        String r102 = r101.getId();
        if (r102 == null) goto L11;
        RenderTree r103 = z2().findTree(r102);
        if (r103 == null) goto L11;
        return r103.getDepth();
    L11:
        return getMaxLevel();
    }

    public final Integer getIndex(String r100) {
        List<RenderItem> r101 = this.f216233c;
        RenderItem r102 = new RenderItem();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setId(r100);
        int r103 = r101.indexOf(r102);
        if (r103 >= 0) goto L8;
        return null;
    L8:
        return Integer.valueOf(r103);
    }

    @Override // ct4.d
    public final boolean q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (Intrinsics.areEqual(z2().getInSearch(), Boolean.TRUE) == false) goto L6;
        return this.f216235e.contains(r100);
    L6:
        return this.f216234d.contains(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void t(int r100) {
        if (C2(r100) == false) goto L6;
        K2(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeItemAnimator.b
    public final void w(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        this.f216240j = false;
        if (this.f216236f == false) goto L6;
        this.f216236f = false;
        L2(this, true);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final int x(int r100) {
        RenderItem r101 = G2(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getLevel();
    }

    public final void y2(boolean r100) {
        if (r100 == false) goto L6;
        ((TreeItemTouchHelper) this.f216243m.getValue()).attachToRecyclerView(this.f216231a);
        DragTreeCallback r101 = (DragTreeCallback) this.f216242l.getValue();
        CatalogItemTreeAdapter r102 = (CatalogItemTreeAdapter) this;
        if (r101.f216119b != null) goto L10;
        r101.f216119b = r102;
        return;
    L10:
        return;
    L6:
        ((TreeItemTouchHelper) this.f216243m.getValue()).attachToRecyclerView(null);
        DragTreeCallback r103 = (DragTreeCallback) this.f216242l.getValue();
        if (r103.f216119b != null) goto L12;
        r103.f216119b = null;
        return;
    }

    public static void L2(TreeAdapter r100, boolean r101) {
        if (r100.f216231a.isComputingLayout() == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        r100.notifyDataSetChanged();
        return;
    L11:
        r100.f216236f = true;
        if (r101 == false) goto L16;
        j.d(new com.bytedance.ee.bear.bitable.uikit.tree.b(r100), 500);
        return;
    L16:
        return;
    L5:
        if (r100.f216240j == true) goto L8;
        r102 = false;
        goto L9
    }

    public void H0(RecyclerView.ViewHolder r100, int r101) {
        boolean r102 = C2(r101);
        this.f216241k = r102;
        if (r102 == true) goto L6;
        K2(r101);
        return;
    }

    public final void J2(int r100, boolean r101) {
        RecyclerView.LayoutManager r102 = this.f216231a.getLayoutManager();
        boolean r103 = true;
        if (r101 == true) goto L5;
    L11:
        if (r103 == false) goto L14;
        tt5.a.h("TreeAdapter", "smoothScrollToPos pos:" + r100 + " onlyScrollWhenOutScreen:" + r101);
        this.f216231a.smoothScrollToPosition(r100);
        return;
    L14:
        return;
    L5:
        if ((r102 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r104 = (LinearLayoutManager) r102;
        int r105 = r104.findFirstVisibleItemPosition();
        int r106 = r104.findLastVisibleItemPosition();
        if (r100 < r105) goto L11;
        if (r100 > r106) goto L11;
        r103 = false;
        goto L11
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final Pair<Integer, Integer> c0(int r100, int r101) {
        int r102 = 1;
        if (r100 < 0) goto L5;
        int r103 = r100 + 1;
        if (r103 != r101) goto L9;
        r103 = r100 + 2;
    L9:
        RenderItem r104 = G2(r103);
        if (r104 == null) goto L12;
        int r105 = Math.max(r104.getLevel(), 1);
    L13:
        Integer r106 = Integer.valueOf(r105);
        RenderItem r107 = G2(r100);
        if (r107 == null) goto L23;
        int r108 = r107.getLevel();
        if (B2(r100) == true) goto L18;
    L20:
        r102 = 0;
    L21:
        r102 = r102 + r108;
        goto L23
    L18:
        if (q(r107.getId()) == true) goto L20;
    L23:
        return new Pair(r106, Integer.valueOf(r102));
    L12:
        r105 = 1;
        goto L13
    L5:
        return new Pair(1, 1);
    }

    public void e1(RecyclerView.ViewHolder r110, hv4.a r111) {
        Intrinsics.checkNotNullParameter(r111, "dragIntent");
        r111.getClass();
        int r100 = r111.f487297a;
        int r101 = r111.f487298b;
        int r102 = r111.f487300d;
        int r103 = r111.f487303g;
        boolean r104 = r111.f487305i;
        tt5.a.h("TreeAdapter", "onDragFinish fromPosition:" + r100 + "   toPosition:" + r102 + "   moveToLevel:" + r103);
        int r105 = 1;
        if (r104 == false) goto L14;
        if (r102 < r100) goto L6;
        if (r102 == r100) goto L10;
    L9:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L13;
        if (r101 == r103) goto L14;
    L13:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L48;
        if (r102 < r100) goto L18;
        if (r102 == r100) goto L22;
    L21:
        boolean r108 = true;
    L23:
        if (r100 != r102) goto L25;
        int r109 = r102 - 1;
    L26:
        RenderItem r112 = G2(r100);
        if (r112 == null) goto L49;
        String r113 = r112.getId();
        if (r113 != null) goto L32;
        return;
    L32:
        if (r109 != (-1)) goto L34;
        RenderTree.Companion.getClass();
        String r114 = RenderTree.access$getROOT$cp();
    L39:
        if (r109 == (-1)) goto L42;
        r105 = r103 - x(r109);
    L42:
        z2().moveTree(r113, r114, r105);
        this.f216233c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        if (r102 >= r100) goto L46;
        r102 = r102 + 1;
    L46:
        this.f216239i = r102;
        tt5.a.h("TreeAdapter", "move notifyItemChanged fromPosition:" + r100 + " notifyMoveToPos:" + r102);
        D2(r100, r102, r108);
        E2(r113);
        return;
    L34:
        RenderItem r115 = G2(r109);
        if (r115 == null) goto L50;
        r114 = r115.getId();
        if (r114 != null) goto L39;
        return;
    L50:
        return;
    L49:
        return;
    L25:
        r109 = r102;
    L22:
        r108 = false;
        goto L23
    L18:
        if ((r100 - r102) <= 1) goto L22;
    L48:
        return;
    L10:
        r106 = false;
        goto L11
    L6:
        if ((r100 - r102) <= 1) goto L10;
    L14:
        r107 = false;
        goto L15
    }

    public final void D2(int r100, int r101, boolean r102) {
        if (this.f216231a.isComputingLayout() == false) goto L6;
        tt5.a.h("TreeAdapter", "notifyAndDoAnim do next loop.");
        ThreadUtils.runOnUIThread(new b(this, r100, r101, r102));
        return;
    L6:
        tt5.a.h("TreeAdapter", "notifyAndDoAnim selectedItemCollapsed:" + this.f216241k);
        notifyItemChanged(r101);
        if (r102 == false) goto L10;
        this.f216240j = true;
        notifyItemMoved(r100, r101);
    L10:
        if (this.f216241k == true) goto L12;
        ThreadUtils.runOnUIThread(new c(r101, this), 100);
        return;
    L12:
        ((Handler) this.f216244n.getValue()).postDelayed(new d(this.f216245o), 200);
    }
}

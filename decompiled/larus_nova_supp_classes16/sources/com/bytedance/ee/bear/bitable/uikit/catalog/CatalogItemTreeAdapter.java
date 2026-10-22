package com.bytedance.ee.bear.bitable.uikit.catalog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.SyncIconImageView;
import com.bytedance.ee.bear.bitable.uikit.drag.DragAreaState;
import com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback;
import com.bytedance.ee.bear.bitable.uikit.tree.RenderItem;
import com.bytedance.ee.bear.bitable.uikit.tree.RenderTree;
import com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter;
import com.bytedance.ee.bear.bitable.uikit.tree.TreeListData;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001BB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J(\u0010\u0019\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u0004\u0018\u00010\u0002J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\u001fH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0018\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"H\u0016J\u0018\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\"H\u0016J\u001a\u0010/\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u00101\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020\"H\u0016J\u001a\u00102\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020\"H\u0016J\u001a\u00103\u001a\u00020\u00172\b\u00100\u001a\u0004\u0018\u00010\u000f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u001fH\u0016J0\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020:2\u0006\u00100\u001a\u00020\u000f2\u0006\u00104\u001a\u0002052\u0006\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTreeAdapter;", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter;", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemModel;", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeAdapter$BaseViewHolder;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "whiteThene", "", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Z)V", "getWhiteThene", "()Z", "lastAreaViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "currentSelectedItem", "injectHandler", "com/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTreeAdapter$injectHandler$1", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/CatalogItemTreeAdapter$injectHandler$1;", "keywordMatcher", "Lcom/bytedance/ee/bear/bitable/uikit/catalog/search/IKeywordMatcher;", "setKeywordMatcher", "", "matcher", "setData", "model", "Lcom/bytedance/ee/bear/bitable/uikit/tree/TreeListData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "scrollId", "", "findSelectCatalogItem", "findSelectCatalogPos", "", "isItemCanCollapsed", "position", "isContainKeyword", "data", "keyword", "needGenerateTreeParent", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onToggleTreeNodeNotify", "viewHolder", "onDragSelected", "onDragStart", "onDragFinish", "dragIntent", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragIntent;", "onNodeMoved", "selectedId", "onDrawDropUI", "c", "Landroid/graphics/Canvas;", "drawOffsetX", "dropOverLineType", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragTreeCallback$DropOverLineType;", "setParentViewHolderDragAreaState", "moveToParentPosition", "dragAreaState", "Lcom/bytedance/ee/bear/bitable/uikit/drag/DragAreaState;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CatalogItemTreeAdapter extends TreeAdapter<CatalogItemModel, TreeAdapter.BaseViewHolder> {
    public static final int x = 0;
    public static final int y = 0;
    public static final int z = 0;
    public final Context q;
    public final RecyclerView r;
    public final boolean s;
    public RecyclerView.ViewHolder t;
    public CatalogItemModel u;
    public final com.bytedance.ee.bear.bitable.uikit.catalog.a v;
    public com.bytedance.ee.bear.bitable.uikit.catalog.search.a w;

    public static final class a {
    }

    static {
        x = n.d(9);
        y = n.d(2);
        z = n.d(4);
    }

    public final int M2() {
        int r0 = getItemCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        CatalogItemModel r3 = H2(r2);
        if (r3 == null) goto L9;
        boolean r4 = true;
        if (r3.isSelected() != true) goto L9;
    L10:
        if (r4 == true) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return r2;
    L9:
        r4 = false;
        goto L10
    L13:
        return -1;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter
    public final boolean B2(int r1) {
        CatalogItemModel r2 = H2(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        return r2.getEnableCollapsed();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter
    public final void E2(String r11) {
        Intrinsics.checkNotNullParameter(r11, "selectedId");
        Intrinsics.checkNotNullParameter(r11, "selectedId");
        String r1 = "";
        TreeSortAction r0 = new TreeSortAction(r11, "", "", null);
        RenderTree r12 = z2().findTree(r11);
        if (r12 == null) goto L33;
        RenderTree r3 = r12.getParent();
        if (r3 == null) goto L11;
        RenderItem r4 = r3.getCurrent();
        if (r4 == null) goto L11;
        String r5 = r4.getId();
        if (r5 == null) goto L11;
        RenderTree.Companion.getClass();
        String r6 = StringsKt.replace$default(r5, RenderTree.access$getROOT$cp(), "", false, 4, null);
    L12:
        r0.setTargetParentId(r6);
        if (TextUtils.isEmpty(r0.getTargetParentId()) == false) goto L15;
        r0.setTargetParentId(null);
    L15:
        Pair<RenderTree, RenderTree> r13 = r12.getBothersInSameLevel();
        RenderTree r2 = (RenderTree) r13.getFirst();
        if (r2 == null) goto L21;
        RenderItem r7 = r2.getCurrent();
        if (r7 == null) goto L21;
        String r8 = r7.getId();
        if (r8 == null) goto L21;
    L22:
        r0.setBeforeId(r8);
        RenderTree r14 = (RenderTree) r13.getSecond();
        if (r14 == null) goto L30;
        RenderItem r16 = r14.getCurrent();
        if (r16 == null) goto L30;
        String r17 = r16.getId();
        if (r17 == null) goto L30;
        r1 = r17;
    L30:
        r0.setAfterId(r1);
        gv4.a r18 = this.h;
        if (r18 == null) goto L33;
        r18.a(r0);
    L21:
        r8 = "";
    L11:
        r6 = null;
    L33:
        tt5.a.h("TreeAdapter", "onNodeMoved treeSortAction:" + r0);
    }

    public CatalogItemTreeAdapter(Context r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super(r3);
        this.q = r2;
        this.r = r3;
        this.s = false;
        this.v = new com.bytedance.ee.bear.bitable.uikit.catalog.a(this);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter
    public final boolean A2(CatalogItemModel r2, String r3) {
        CatalogItemModel r4 = r2;
        Intrinsics.checkNotNullParameter(r3, "keyword");
        com.bytedance.ee.bear.bitable.uikit.catalog.search.a r0 = this.w;
        if (r0 == null) goto L8;
        if (r4 == null) goto L6;
        String r5 = r4.getLeftText();
    L10:
        return r0.a(r5, r3);
    L6:
        r5 = null;
        goto L10
    L8:
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter
    public final void F2(int r3, RecyclerView.ViewHolder r4) {
        CatalogItemModel r0 = H2(r3);
        if (r0 == null) goto L34;
        r0.setCollapsed(C2(r3));
        ViewPropertyAnimator r5 = null;
        if (r4 == null) goto L7;
        View r6 = r4.itemView;
    L8:
        boolean r1 = r6 instanceof CatalogItemView;
        if (r1 == false) goto L35;
        if (r1 == false) goto L12;
        CatalogItemView r7 = (CatalogItemView) r6;
    L13:
        if (r7 == null) goto L36;
        Intrinsics.checkNotNullParameter(r0, "item");
        if (r0.getEnableCollapsed() == false) goto L40;
        SyncIconImageView r8 = r7.getLeftIconFromXml();
        if (r8 == null) goto L20;
        r5 = r8.animate();
    L20:
        if (r5 == null) goto L22;
        r5.cancel();
    L22:
        if (r5 == null) goto L37;
        boolean r9 = r0.getEnableCollapsed();
        boolean r2 = r0.isCollapsed();
        if (r9 == false) goto L27;
        if (r2 == false) goto L27;
        float r10 = -90.0f;
    L28:
        ViewPropertyAnimator r11 = r5.rotation(r10);
        if (r11 == null) goto L38;
        ViewPropertyAnimator r12 = r11.setDuration(240);
        if (r12 == null) goto L39;
        r12.start();
        return;
    L39:
        return;
    L38:
        return;
    L27:
        r10 = 0.0f;
        goto L28
    L37:
        return;
    L40:
        return;
    L36:
        return;
    L12:
        r7 = null;
        goto L13
    L35:
        return;
    L7:
        r6 = null;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter, com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void H0(RecyclerView.ViewHolder r2, int r3) {
        super.H0(r2, r3);
        CatalogItemView r4 = null;
        if (r2 == null) goto L5;
        View r5 = r2.itemView;
    L7:
        if ((r5 instanceof CatalogItemView) == false) goto L9;
        r4 = (CatalogItemView) r5;
    L9:
        if (r4 == null) goto L12;
        r4.setDragState(true);
        return;
    L12:
        return;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter, com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void e1(RecyclerView.ViewHolder r2, hv4.a r3) {
        Intrinsics.checkNotNullParameter(r3, "dragIntent");
        super.e1(r2, r3);
        CatalogItemView r4 = null;
        if (r2 == null) goto L5;
        View r5 = r2.itemView;
    L7:
        if ((r5 instanceof CatalogItemView) == false) goto L9;
        CatalogItemView r6 = (CatalogItemView) r5;
    L10:
        if (r6 == null) goto L12;
        r6.setDragState(false);
        r6.setDragAreaState(DragAreaState.NONE);
    L12:
        RecyclerView.ViewHolder r7 = this.t;
        if (r7 == null) goto L15;
        View r8 = r7.itemView;
    L17:
        if ((r8 instanceof CatalogItemView) == false) goto L19;
        r4 = (CatalogItemView) r8;
    L19:
        if (r4 == null) goto L22;
        r4.setDragAreaState(DragAreaState.NONE);
        return;
    L22:
        return;
    L15:
        r8 = null;
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        TreeAdapter.BaseViewHolder r5 = (TreeAdapter.BaseViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        CatalogItemModel r0 = H2(r4);
        if (r0 == null) goto L15;
        r0.setLevel(x(r4));
        String r6 = r0.getId();
        if (r6 == null) goto L8;
        boolean r7 = Boolean.valueOf(q(r6)).booleanValue();
    L9:
        r0.setCollapsed(r7);
        View r8 = ((RecyclerView.ViewHolder) r5).itemView;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.uikit.catalog.CatalogItemView");
        CatalogItemView r9 = (CatalogItemView) r8;
        com.bytedance.ee.bear.bitable.uikit.catalog.a r10 = this.v;
        r10.a = this.h;
        r9.a(r0, r10, this.r.getMeasuredWidth());
        if (this.s == false) goto L12;
        r9.getCatalogWrapperFromXml().setBackgroundResource(2131232268);
        return;
    L12:
        r9.getCatalogWrapperFromXml().setBackgroundResource(2131232267);
        return;
    L8:
        r7 = false;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new TreeAdapter.BaseViewHolder(LayoutInflater.from(this.q).inflate(2131558898, r4, false));
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter, com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void s2(RecyclerView.ViewHolder r3, int r4) {
        if (r3 == null) goto L6;
        View r0 = r3.itemView;
        if (r0 == null) goto L6;
        r0.setPressed(false);
    L6:
        if (r3 == null) goto L23;
        CatalogItemModel r5 = H2(r4);
        if (r5 == null) goto L24;
        r5.setCollapsed(true);
        View r6 = r3.itemView;
        if ((r6 instanceof CatalogItemView) == false) goto L12;
        CatalogItemView r7 = (CatalogItemView) r6;
    L13:
        if (r7 == null) goto L25;
        Intrinsics.checkNotNullParameter(r5, "item");
        SyncIconImageView r8 = r7.getLeftIconFromXml();
        if (r8 == null) goto L26;
        boolean r1 = r5.getEnableCollapsed();
        boolean r9 = r5.isCollapsed();
        if (r1 == false) goto L20;
        if (r9 == false) goto L20;
        float r10 = -90.0f;
    L21:
        r8.setRotation(r10);
        return;
    L20:
        r10 = 0.0f;
        goto L21
    L26:
        return;
    L25:
        return;
    L12:
        r7 = null;
        goto L13
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O2(TreeListData<CatalogItemModel> r10, gv4.a r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "handler");
        Intrinsics.checkNotNullParameter(r10, "model");
        Intrinsics.checkNotNullParameter(r11, "handler");
        String r0 = r10.getCacheKey();
        CatalogItemModel r1 = null;
        if (r0 != null) goto L5;
    L9:
        this.b = r10;
        this.h = r11;
        if (r12 != null) goto L12;
    L17:
        this.c = RenderTree.genRenderItemList$default(z2(), this, 0, false, 6, null);
        RenderTree.checkTreeParent$default(z2(), false, 1, null);
        TreeAdapter.L2(this, true);
        tt5.a.h("TreeAdapter", "setData isAniming:" + this.j);
        CatalogItemModel r13 = H2(M2());
        if (r13 == null) goto L20;
        r1 = r13;
    L20:
        this.u = r1;
        return;
    L12:
        if (TextUtils.isEmpty(r12) == true) goto L17;
        Intrinsics.checkNotNullParameter(r12, "id");
        Iterator<T> r14 = z2().getParentIdList(r12).iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        this.d.remove((String) r14.next());
        goto L15
    L5:
        if (this.g == true) goto L9;
        this.g = true;
        Set r2 = ay4.b.d("bitable", 4).getStringSet(r0, null);
        if (r2 == null) goto L9;
        this.d = new HashSet(r2);
        goto L9
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.tree.TreeAdapter, com.bytedance.ee.bear.bitable.uikit.drag.DragTreeCallback.b
    public final void c2(Canvas r5, RecyclerView.ViewHolder r6, hv4.a r7, int r8, DragTreeCallback.DropOverLineType r9) {
        Intrinsics.checkNotNullParameter(r5, "c");
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        Intrinsics.checkNotNullParameter(r7, "dragIntent");
        Intrinsics.checkNotNullParameter(r9, "dropOverLineType");
        super.c2(r5, r6, r7, r8, r9);
        new Paint().setColor(-16776961);
        View r10 = r6.itemView;
        if (r9 != DragTreeCallback.DropOverLineType.TOP) goto L5;
        int r11 = ((r10.getTop() - x) + y) + z;
    L7:
        if (r7.i == false) goto L9;
        DragAreaState r0 = DragAreaState.PARENT_SELECTED;
    L10:
        DragAreaState r1 = DragAreaState.ERROR;
        if (r0 != r1) goto L13;
        Drawable r2 = this.q.getResources().getDrawable(2131232283);
        Intrinsics.checkNotNull(r2);
    L14:
        r2.setBounds((int) (r10.getLeft() + r8), r11, r10.getRight(), r2.getMinimumHeight() + r11);
        r2.draw(r5);
        int r12 = r7.e;
        CatalogItemView r13 = null;
        if (r12 >= 0) goto L17;
        RecyclerView.ViewHolder r14 = null;
    L19:
        if (Intrinsics.areEqual(r14, this.t) == true) goto L44;
        RecyclerView.ViewHolder r16 = this.t;
        if (r16 == null) goto L24;
        View r17 = r16.itemView;
    L26:
        if ((r17 instanceof CatalogItemView) == false) goto L28;
        CatalogItemView r18 = (CatalogItemView) r17;
    L29:
        if (r18 == null) goto L31;
        r18.setDragAreaState(DragAreaState.NONE);
    L31:
        if (r14 == null) goto L33;
        View r19 = r14.itemView;
    L35:
        if ((r19 instanceof CatalogItemView) == false) goto L37;
        r13 = (CatalogItemView) r19;
    L37:
        if (r13 == null) goto L39;
        r13.setDragAreaState(r0);
    L39:
        this.t = r14;
        if (r0 != r1) goto L43;
        UDToast.show(this.q, 2131886663);
        return;
    L43:
        return;
    L33:
        r19 = null;
        goto L35
    L28:
        r18 = null;
        goto L29
    L24:
        r17 = null;
        goto L26
    L44:
        return;
    L17:
        r14 = this.r.findViewHolderForAdapterPosition(r12);
        goto L19
    L13:
        r2 = this.q.getResources().getDrawable(2131232282);
        Intrinsics.checkNotNull(r2);
        goto L14
    L9:
        r0 = DragAreaState.ERROR;
        goto L10
    L5:
        r11 = r10.getBottom() - y;
        goto L7
    }
}

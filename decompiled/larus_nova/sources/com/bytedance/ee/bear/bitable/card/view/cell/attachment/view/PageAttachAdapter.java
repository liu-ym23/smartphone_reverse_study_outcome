package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u0018H\u0016J\b\u0010)\u001a\u00020\u0018H\u0014J\u0018\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0016J\u0012\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/PageAttachAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/view/AttachmentAdapter;", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexMeasure;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "<init>", "()V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "fullWidth", "", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "useNewLayout", "getUseNewLayout", "setUseNewLayout", "fixedWidth", "itemWidthMargin", "itemHeight", "", "itemSide", "itemMarginEnd", "itemVerticalMargin", "itemVerticalMarginTop", "onCreateTimes", "onBindTimes", "getItemViewType", "position", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getLayoutId", "getMeasureHeight", "widthSpec", "heightSpec", "getItemWidth", "t", "getItemMargin", "isMeasureWidthExactly", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageAttachAdapter extends AttachmentAdapter implements com.bytedance.ee.bear.bitable.common.widgets.flex.b<AttachmentEntity> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f207443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f207444i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f207445j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f207446k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f207447l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f207448m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f207449n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f207450o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f207451p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f207452q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f207453r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f207454s;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return R.id.attachment_cell_item_type;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter
    public final int getLayoutId() {
        return R.layout.bitable_page_attachment_rv_item;
    }

    public PageAttachAdapter() {
        this.f207444i = true;
        this.f207446k = com.bytedance.ee.util.ui.n.d(44);
        this.f207447l = com.bytedance.ee.util.ui.n.d(4);
        this.f207448m = com.bytedance.ee.util.ui.n.d(43);
        this.f207449n = com.bytedance.ee.util.ui.n.d(40);
        this.f207450o = com.bytedance.ee.util.ui.n.d(4);
        this.f207451p = com.bytedance.ee.util.ui.n.d(3);
        this.f207452q = com.bytedance.ee.util.ui.n.d(0);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean M1() {
        return this.f207445j;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f207444i;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return this.f207447l;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float g2(AttachmentEntity r100) {
        return this.f207446k;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final int k0(int r100, int r101) {
        if (this.f207443h != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return r101;
    L9:
        if (this.f207444i == false) goto L11;
    L14:
        float r103 = com.bytedance.ee.bear.bitable.common.widgets.flex.a.a(this, this.f207381a, View.MeasureSpec.getSize(r100), this.f207443h);
    L16:
        return View.MeasureSpec.makeMeasureSpec((int) (r103 * this.f207448m), 1073741824);
    L11:
        if (this.f207445j == true) goto L14;
        r103 = 1.0f;
        goto L16
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f207454s++;
        tt5.a.b("PageAttachAdapter", "onBindVH " + r101 + ' ' + this.f207454s + ' ' + (1 - (this.f207453r / this.f207454s)));
        super.onBindViewHolder(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f207453r++;
        tt5.a.b("PageAttachAdapter", "onCreateVH " + r100.hashCode() + ' ' + this.f207453r);
        p r102 = this.f207382b;
        RecyclerView.LayoutParams r103 = null;
        if (r102 == null) goto L9;
        y1 r104 = r102.getMembraneManager();
        if (r104 == null) goto L9;
        AsyncPrefetchAndRecyclePool r105 = r104.f209194a;
        if (r105 == null) goto L9;
        View r106 = r105.b(R.layout.bitable_page_attachment_rv_item);
    L10:
        if (r106 != null) goto L13;
        tt5.a.h("PageAttachAdapter", "onCreateVH async prefetch null");
    L23:
        if (r106 != null) goto L26;
        r106 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_page_attachment_rv_item, r100, false);
    L26:
        return new AttachmentAdapter.ViewHolder(this, r106);
    L13:
        if ((r100 instanceof RecyclerView) == false) goto L15;
        RecyclerView r107 = (RecyclerView) r100;
    L16:
        if (r107 == null) goto L22;
        RecyclerView.LayoutManager r108 = r107.getLayoutManager();
        if (r108 == null) goto L22;
        RecyclerView.LayoutParams r109 = r108.generateDefaultLayoutParams();
        if (r109 == null) goto L22;
        int r110 = this.f207449n;
        ((ViewGroup.MarginLayoutParams) r109).width = r110;
        ((ViewGroup.MarginLayoutParams) r109).height = r110;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = this.f207452q;
        ((ViewGroup.MarginLayoutParams) r109).bottomMargin = this.f207451p;
        r109.setMarginEnd(this.f207450o);
        r103 = r109;
    L22:
        r106.setLayoutParams(r103);
        goto L23
    L15:
        r107 = null;
    L9:
        r106 = null;
        goto L10
    }
}

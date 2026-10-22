package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.card.view.membrane.AsyncPrefetchAndRecyclePool;
import com.bytedance.ee.bear.bitable.card.viewmodel.y1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001e\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/PageFlexChatterCellAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter;", "<init>", "()V", "onCreateTimes", "", "onBindTimes", "itemHeightPx", "itemHorizontalMarginPx", "getItemViewLayoutId", "onCreateViewHolder", "Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/FlexChatterCellAdapter$ChatterViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemTextSize", "itemHeightDp", "getItemHeightDp", "()I", "fixWidthDp", "getFixWidthDp", "getItemMargin", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageFlexChatterCellAdapter<T extends IChatterEntity> extends FlexChatterCellAdapter<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f207535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f207536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f207537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f207538n;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final void A2() {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final int B2() {
        return R.layout.bitable_page_cell_chatter_rv_item;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final int y2() {
        return 29;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final int z2() {
        return 25;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return this.f207538n;
    }

    public PageFlexChatterCellAdapter() {
        this.f207537m = com.bytedance.ee.util.ui.n.d(25);
        this.f207538n = com.bytedance.ee.util.ui.n.c(5.0f);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final FlexChatterCellAdapter.ChatterViewHolder E2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f207535k++;
        tt5.a.b("PageFlexChatterAdapter", "onCreateVH " + r100.hashCode() + ' ' + this.f207535k);
        e<T> r101 = this.f207511a;
        RecyclerView.LayoutParams r102 = null;
        if (r101 == null) goto L9;
        y1 r103 = r101.getMembraneManager();
        if (r103 == null) goto L9;
        AsyncPrefetchAndRecyclePool r104 = r103.f209194a;
        if (r104 == null) goto L9;
        View r105 = r104.b(R.layout.bitable_page_cell_chatter_rv_item);
    L10:
        if (r105 != null) goto L13;
        tt5.a.h("PageFlexChatterAdapter", "onCreateVH async prefetch null");
    L23:
        if (r105 != null) goto L25;
        r105 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_page_cell_chatter_rv_item, r100, false);
    L25:
        Intrinsics.checkNotNull(r105);
        return new FlexChatterCellAdapter.ChatterViewHolder(r105);
    L13:
        if ((r100 instanceof RecyclerView) == false) goto L15;
        RecyclerView r106 = (RecyclerView) r100;
    L16:
        if (r106 == null) goto L22;
        RecyclerView.LayoutManager r107 = r106.getLayoutManager();
        if (r107 == null) goto L22;
        RecyclerView.LayoutParams r108 = r107.generateDefaultLayoutParams();
        if (r108 == null) goto L22;
        ((ViewGroup.MarginLayoutParams) r108).height = this.f207537m;
        r108.setMarginStart(this.f207538n / 2);
        r108.setMarginEnd(r108.getMarginStart());
        r102 = r108;
    L22:
        r105.setLayoutParams(r102);
        goto L23
    L15:
        r106 = null;
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter
    public final void D2(FlexChatterCellAdapter.ChatterViewHolder<T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f207536l++;
        tt5.a.b("PageFlexChatterAdapter", "onBindVH " + r101 + ' ' + this.f207536l + ' ' + (1 - (this.f207535k / this.f207536l)));
        super.D2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        D2((FlexChatterCellAdapter.ChatterViewHolder) r100, r101);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.chatter.FlexChatterCellAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return E2(r100);
    }
}

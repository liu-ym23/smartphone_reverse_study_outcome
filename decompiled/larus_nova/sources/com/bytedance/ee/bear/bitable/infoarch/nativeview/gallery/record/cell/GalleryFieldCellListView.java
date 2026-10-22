package com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.record.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.BaseFieldCellListView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonFieldCellView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryCellData;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0016J\f\u0010\u000f\u001a\u00060\u0010R\u00020\u0001H\u0016J\"\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cell/GalleryFieldCellListView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/BaseFieldCellListView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "showFieldName", "", "loadingFieldCount", "initLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "initAdapter", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/BaseFieldCellListView$BaseFieldCellAdapter;", "setData", "", "cellDatas", "", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setShowFieldName", "setLoadingFieldCount", "GalleryFieldCellAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GalleryFieldCellListView extends BaseFieldCellListView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f213448e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f213449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f213450d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cell/GalleryFieldCellListView$GalleryFieldCellAdapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/BaseFieldCellListView$BaseFieldCellAdapter;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/BaseFieldCellListView;", "<init>", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/gallery/record/cell/GalleryFieldCellListView;)V", "onBindViewHolder", "", "holder", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/BaseFieldCellListView$BaseViewHolder;", "position", "", "getItemCount", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GalleryFieldCellAdapter extends BaseFieldCellListView.BaseFieldCellAdapter {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GalleryFieldCellListView f213451b;

        @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.BaseFieldCellListView.BaseFieldCellAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            GalleryFieldCellListView r100 = this.f213451b;
            int r101 = GalleryFieldCellListView.f213448e;
            if (r100.getShowLoading() == false) goto L6;
            return this.f213451b.f213450d;
        L6:
            return super.getItemCount();
        }

        public GalleryFieldCellAdapter(GalleryFieldCellListView r100) {
            this.f213451b = r100;
            super(r100);
        }

        @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.BaseFieldCellListView.BaseFieldCellAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            y2((BaseFieldCellListView.BaseViewHolder) r100, r101);
        }

        @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.BaseFieldCellListView.BaseFieldCellAdapter
        public final void y2(BaseFieldCellListView.BaseViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            View r102 = r100.itemView;
            if ((r102 instanceof CommonFieldCellView) == false) goto L5;
            CommonFieldCellView r103 = (CommonFieldCellView) r102;
        L6:
            if (r103 == null) goto L23;
            GalleryFieldCellListView r104 = this.f213451b;
            boolean r105 = false;
            if (r104.f213449c == true) goto L10;
        L12:
            boolean r106 = false;
        L13:
            if (r106 == false) goto L15;
            float r107 = 3.0f;
        L16:
            r103.a(true, r107);
            r103.setCellEmptyValueVisible(r104.f213449c);
            if (r101 != (getItemCount() - 1)) goto L19;
            r105 = true;
        L19:
            if (r105 == false) goto L21;
            float r108 = 0.65f;
        L22:
            r103.setCellLoadingPercent(r108);
            goto L23
        L21:
            r108 = 1.0f;
            goto L22
        L15:
            r107 = 0.0f;
            goto L16
        L10:
            if (r104.getShowLoading() == true) goto L12;
            r106 = true;
        L23:
            super.y2(r100, r101);
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public GalleryFieldCellListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GalleryFieldCellListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setLoadingFieldCount(int r100) {
        this.f213450d = Math.max(r100, 0);
    }

    public final void setShowFieldName(boolean r100) {
        this.f213449c = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.BaseFieldCellListView
    public final void r(List<? extends BaseCellData> r100, a r101) {
        if (r100 != null) goto L4;
        r100 = null;
    L14:
        super.r(r100, r101);
        return;
    L4:
        if (this.f213449c == true) goto L14;
        ArrayList r102 = new ArrayList(r100.size());
        ArrayList r103 = new ArrayList();
        Iterator r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        BaseCellData r105 = (BaseCellData) r104.next();
        if (r105.isEmptyValue() == false) goto L10;
        r103.add(new GalleryCellData());
        goto L7
    L10:
        r102.add(r105);
        goto L7
    L12:
        r102.addAll(r103);
        r100 = r102;
        goto L14
    }

    public GalleryFieldCellListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setAdapter(new GalleryFieldCellAdapter(this));
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public /* synthetic */ GalleryFieldCellListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

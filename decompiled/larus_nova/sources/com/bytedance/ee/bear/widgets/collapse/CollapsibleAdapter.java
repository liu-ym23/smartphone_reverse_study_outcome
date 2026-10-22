package com.bytedance.ee.bear.widgets.collapse;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0011B\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter$CollapsibleViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "position", "", "CollapsibleViewHolder", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CollapsibleAdapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, CollapsibleViewHolder> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleAdapter$CollapsibleViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "Lcom/bytedance/ee/bear/widgets/collapse/CollapsibleItemAnimator$ICollapsibleItem;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "groupIndex", "", "getGroupIndex", "()I", "setGroupIndex", "(I)V", "groupChildCount", "getGroupChildCount", "setGroupChildCount", "getIndexInGroup", "getCountInGroup", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CollapsibleViewHolder extends BaseViewHolder implements CollapsibleItemAnimator.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f240156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f240157b;

        @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleItemAnimator.b
        public final int A2() {
            return this.f240156a;
        }

        @Override // com.bytedance.ee.bear.widgets.collapse.CollapsibleItemAnimator.b
        public final int V() {
            return this.f240157b;
        }

        public CollapsibleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f240156a = -1;
        }
    }

    public CollapsibleAdapter(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(r100);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        r100.setItemAnimator(new CollapsibleItemAnimator());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((CollapsibleViewHolder) r100, r101);
    }

    public void y2(CollapsibleViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onBindViewHolder(r100, r101);
        int r102 = getParentPositionInAll(r101);
        int r103 = getItemCount() - 1;
        int r104 = r101 + 1;
        int r105 = getItemCount();
    L3:
        if (r104 >= r105) goto L9;
        if (isExpandable(getItem(r104)) == true) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        r103 = r104 - 1;
    L9:
        if (r102 != (-1)) goto L11;
        int r106 = 0;
    L12:
        r100.f240156a = r106;
        r100.f240157b = r103 - r102;
        return;
    L11:
        r106 = r101 - r102;
        goto L12
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(BaseViewHolder r100, int r101) {
        y2((CollapsibleViewHolder) r100, r101);
    }
}

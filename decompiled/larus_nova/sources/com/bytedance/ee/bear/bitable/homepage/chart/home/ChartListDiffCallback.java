package com.bytedance.ee.bear.bitable.homepage.chart.home;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.HomeChartEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rs4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/ChartListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/bytedance/ee/bear/bitable/homepage/chart/entity/HomeChartEntity;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<HomeChartEntity> f212490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<HomeChartEntity> f212491b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f212491b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f212490a.size();
    }

    public ChartListDiffCallback(List<HomeChartEntity> r100, List<HomeChartEntity> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f212490a = r100;
        this.f212491b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return y28.a.c((HomeChartEntity) CollectionsKt.getOrNull(this.f212490a, r100), (HomeChartEntity) CollectionsKt.getOrNull(this.f212491b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        HomeChartEntity r102 = (HomeChartEntity) CollectionsKt.getOrNull(this.f212490a, r100);
        HomeChartEntity r103 = (HomeChartEntity) CollectionsKt.getOrNull(this.f212491b, r101);
        if (r102 != r103) goto L5;
        return true;
    L5:
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        if (HomeChartEntity.class != HomeChartEntity.class) goto L11;
        return r102.isItemSame(r103);
    L11:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        HomeChartEntity r102 = (HomeChartEntity) CollectionsKt.getOrNull(this.f212490a, r100);
        HomeChartEntity r103 = (HomeChartEntity) CollectionsKt.getOrNull(this.f212491b, r101);
        d r104 = null;
        if (r102 == null) goto L5;
        Boolean r105 = Boolean.valueOf(r102.isEditMode());
    L6:
        if (r103 == null) goto L8;
        Boolean r106 = Boolean.valueOf(r103.isEditMode());
    L10:
        if (Intrinsics.areEqual(r105, r106) == false) goto L12;
        if (r102 == null) goto L15;
        d r107 = r102.getChartData();
    L16:
        if (r103 == null) goto L19;
        r104 = r103.getChartData();
    L19:
        if (Intrinsics.areEqual(r107, r104) == true) goto L23;
        return 2;
    L23:
        return super.getChangePayload(r100, r101);
    L15:
        r107 = null;
        goto L16
    L12:
        return 1;
    L8:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}

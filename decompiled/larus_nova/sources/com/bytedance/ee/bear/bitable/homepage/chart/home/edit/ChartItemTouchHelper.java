package com.bytedance.ee.bear.bitable.homepage.chart.home.edit;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartItemTouchHelper;", "Landroidx/recyclerview/widget/ItemTouchHelper;", "callback", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartTouchCallback;", "<init>", "(Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartTouchCallback;)V", "value", "", "canDragToSort", "getCanDragToSort", "()Z", "setCanDragToSort", "(Z)V", "setMoveListener", "", "moveListener", "Lcom/bytedance/ee/bear/bitable/homepage/chart/home/edit/ChartItemTouchMoveListener;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartItemTouchHelper extends ItemTouchHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChartTouchCallback f212535a;

    public ChartItemTouchHelper() {
        this(0);
    }

    public ChartItemTouchHelper(int r100) {
        ChartTouchCallback r101 = new ChartTouchCallback();
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r101);
        this.f212535a = r101;
    }
}

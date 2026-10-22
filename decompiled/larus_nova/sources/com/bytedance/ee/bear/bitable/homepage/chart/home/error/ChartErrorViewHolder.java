package com.bytedance.ee.bear.bitable.homepage.chart.home.error;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.g;
import com.bytedance.ee.bear.bitable.homepage.BitableHomePageAdapter;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ss4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/error/ChartErrorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onRefreshListener", "Ljava/lang/Runnable;", "<init>", "(Landroid/view/View;Ljava/lang/Runnable;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartErrorViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f212538a;

    public ChartErrorViewHolder(View r100, BitableHomePageAdapter.a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "onRefreshListener");
        super(r100);
        this.f212538a = r101;
        this.itemView.findViewById(R.id.hp_chart_refresh_button).setOnClickListener(new a(this));
        g.a((ImageView) this.itemView.findViewById(R.id.hp_chart_error_icon), "ccm_bitable_home_list_error", true);
    }
}

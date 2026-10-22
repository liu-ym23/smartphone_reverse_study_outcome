package com.bytedance.ee.bear.bitable.homepage.chart.home.empty;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.g;
import com.bytedance.ee.bear.bitable.homepage.chart.home.edit.AddChartEntryView;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/chart/home/empty/ChartEmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "containerEnv", "", "hpBaseFrom", "<init>", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChartEmptyViewHolder extends RecyclerView.ViewHolder {
    public ChartEmptyViewHolder(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        AddChartEntryView r103 = (AddChartEntryView) this.itemView.findViewById(R.id.hp_chart_add_button);
        r103.setContainerEnv(r101);
        r103.setHpFrom(r102);
        r103.setRadius(UIHelper.dp2px(8.0f));
        r103.setTextSize(14.0f);
        r103.setButtonText(this.itemView.getContext().getResources().getString(R.string.Bitable_HomeDashboard_AddChart_Button));
        r103.c(UIHelper.dp2px(16.0f), UIHelper.dp2px(16.0f));
        g.a((ImageView) this.itemView.findViewById(R.id.hp_chart_empty_icon), "ccm_bitable_home_dashboard_empty", true);
    }
}

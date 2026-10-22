package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.todo.v1.TaskCompleteStatusFieldFilterValue;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompleteStatusFieldFilterValue.TaskCompleteStatus f442072b;

    public o(FilterSectionView r100, TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r101) {
        this.f442071a = r100;
        this.f442072b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        FilterSectionView r100 = this.f442071a;
        if (r100.f441845g == false) goto L5;
        return;
    L5:
        r100.f441845g = true;
        FilterSectionView.a(r100);
        TextView r101 = (TextView) this.f442071a.f441839a.findViewById(R.id.complete_status_text);
        com.ss.android.lark.todo.impl.utils.i r102 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r101.setTextColor(r102.a(R.color.primary_fill_default));
        ((TextView) this.f442071a.f441839a.findViewById(R.id.complete_status_text)).setCompoundDrawables(null, null, this.f442071a.f441843e, null);
        FilterSectionView r103 = this.f442071a;
        TaskCompleteStatusFieldFilterValue.TaskCompleteStatus r104 = this.f442072b;
        View r105 = View.inflate(r103.f441839a.getContext(), R.layout.task_center_filters_pop_window, null);
        LinearLayout r106 = (LinearLayout) r105.findViewById(R.id.task_options_container);
        View r107 = View.inflate(r103.f441839a.getContext(), R.layout.task_center_filter_item, null);
        ((TextView) r107.findViewById(R.id.filter_text)).setText(r102.g(R.string.Todo_New_Ongoing_FilterOption));
        ((RelativeLayout) r107.findViewById(R.id.sort_container)).setVisibility(4);
        ((ImageView) r107.findViewById(R.id.select_icon)).setVisibility(4);
        if (r104 != TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.UNCOMPLETED) goto L8;
        ((TextView) r107.findViewById(R.id.filter_text)).setTextColor(r102.a(R.color.primary_fill_default));
        ((ImageView) r107.findViewById(R.id.select_icon)).setVisibility(0);
    L8:
        r107.setOnClickListener(new h(r103));
        r106.addView(r107);
        LinearLayout r108 = (LinearLayout) r105.findViewById(R.id.task_options_container);
        View r109 = View.inflate(r103.f441839a.getContext(), R.layout.task_center_filter_item, null);
        ((TextView) r109.findViewById(R.id.filter_text)).setText(r102.g(R.string.Todo_New_Completed_FilterOption));
        ((RelativeLayout) r109.findViewById(R.id.sort_container)).setVisibility(4);
        ((ImageView) r109.findViewById(R.id.select_icon)).setVisibility(4);
        if (r104 != TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.COMPLETED) goto L11;
        ((TextView) r109.findViewById(R.id.filter_text)).setTextColor(r102.a(R.color.primary_fill_default));
        ((ImageView) r109.findViewById(R.id.select_icon)).setVisibility(0);
    L11:
        r109.setOnClickListener(new i(r103));
        r108.addView(r109);
        LinearLayout r111 = (LinearLayout) r105.findViewById(R.id.task_options_container);
        View r112 = View.inflate(r103.f441839a.getContext(), R.layout.task_center_filter_item, null);
        ((TextView) r112.findViewById(R.id.filter_text)).setText(r102.g(R.string.Todo_New_AllTasks_FilterOption));
        ((RelativeLayout) r112.findViewById(R.id.sort_container)).setVisibility(4);
        ((ImageView) r112.findViewById(R.id.select_icon)).setVisibility(4);
        if (r104 != TaskCompleteStatusFieldFilterValue.TaskCompleteStatus.ALL) goto L14;
        ((TextView) r112.findViewById(R.id.filter_text)).setTextColor(r102.a(R.color.primary_fill_default));
        ((ImageView) r112.findViewById(R.id.select_icon)).setVisibility(0);
    L14:
        r112.findViewById(R.id.divide_line).setVisibility(8);
        r112.setOnClickListener(new j(r103));
        r111.addView(r112);
        Intrinsics.checkNotNull(r105);
        FilterSectionView r113 = this.f442071a;
        Intrinsics.checkNotNull(r110);
        FilterSectionView.c(r113, r110, r105);
    }
}

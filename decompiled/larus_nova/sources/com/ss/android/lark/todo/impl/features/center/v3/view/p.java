package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.center.v3.FilterUtil;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterSectionView f442076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<TaskFieldType> f442077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TaskFieldType f442078c;

    /* JADX WARN: Multi-variable type inference failed */
    public p(FilterSectionView r100, List<? extends TaskFieldType> r101, TaskFieldType r102) {
        this.f442076a = r100;
        this.f442077b = r101;
        this.f442078c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        FilterSectionView r100 = this.f442076a;
        if (r100.f441846h == false) goto L5;
        return;
    L5:
        r100.f441846h = true;
        FilterSectionView.a(r100);
        ((TextView) this.f442076a.f441839a.findViewById(R.id.group_section_text)).setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.primary_fill_default));
        ViewGroup r101 = null;
        ((TextView) this.f442076a.f441839a.findViewById(R.id.group_section_text)).setCompoundDrawables(null, null, this.f442076a.f441843e, null);
        FilterSectionView r102 = this.f442076a;
        List<TaskFieldType> r103 = this.f442077b;
        TaskFieldType r104 = this.f442078c;
        View r105 = View.inflate(r102.f441839a.getContext(), R.layout.task_center_filters_pop_window, null);
        Iterator<T> r106 = r103.iterator();
        int r107 = 0;
    L7:
        if (r106.hasNext() == false) goto L18;
        int r111 = r107 + 1;
        TaskFieldType r112 = (TaskFieldType) r106.next();
        String r113 = FilterUtil.b(r112);
        if (TextUtils.isEmpty(r113) == true) goto L17;
        View r114 = View.inflate(r102.f441839a.getContext(), R.layout.task_center_filter_item, r101);
        ((RelativeLayout) r114.findViewById(R.id.sort_container)).setVisibility(4);
        ((TextView) r114.findViewById(R.id.filter_text)).setText(r113);
        ((ImageView) r114.findViewById(R.id.select_icon)).setVisibility(4);
        if (r104 != r112) goto L14;
        ((TextView) r114.findViewById(R.id.filter_text)).setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.primary_fill_default));
        ((ImageView) r114.findViewById(R.id.select_icon)).setVisibility(0);
    L14:
        if (r107 != (r103.size() - 1)) goto L16;
        r114.findViewById(R.id.divide_line).setVisibility(8);
    L16:
        r114.setOnClickListener(new k(r102, r112));
        ((LinearLayout) r105.findViewById(R.id.task_options_container)).addView(r114);
    L17:
        r107 = r111;
        r101 = null;
        goto L7
    L18:
        Intrinsics.checkNotNull(r105);
        FilterSectionView r108 = this.f442076a;
        Intrinsics.checkNotNull(r110);
        FilterSectionView.c(r108, r110, r105);
    }
}

package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class y0 implements KeyboardScrollView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskListFilterSectionView f442138a;

    public y0(TaskListFilterSectionView r100) {
        this.f442138a = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView.a
    public final void a(KeyboardScrollView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r101 = this.f442138a.f441972a.findViewById(R.id.filter_shader);
        boolean r102 = false;
        if (r100.getChildAt(0).getMeasuredWidth() <= (r100.getScrollX() + r100.getWidth())) goto L5;
        r102 = true;
    L5:
        com.larksuite.framework.section.utils.a.d(r101, r102);
    }
}

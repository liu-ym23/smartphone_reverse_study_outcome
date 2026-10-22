package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class y0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MergeSection f443470a;

    public y0(MergeSection r100) {
        this.f443470a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((ConstraintLayout) this.f443470a.f443252b.findViewById(R.id.todo_merge_container)).setVisibility(8);
        this.f443470a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.g4.f443703a);
    }
}

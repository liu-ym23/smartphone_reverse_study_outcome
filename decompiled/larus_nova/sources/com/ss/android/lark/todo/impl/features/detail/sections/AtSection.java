package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.at.TodoAtController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class AtSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f443132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f443133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TodoAtController f443134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TodoAtController f443135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EditText f443136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EditText f443137h;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getInitAtController(), new AtSection$initViewObserver$1$1(this));
        k(r100.getSummaryInsertAtTag(), new AtSection$initViewObserver$1$2(this));
        k(r100.getDescriptionInsertAtTag(), new AtSection$initViewObserver$1$3(this));
    }

    public AtSection(View r100, View r101, FrameLayout r102, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r103) {
        Intrinsics.checkNotNullParameter(r100, "summaryContainer");
        Intrinsics.checkNotNullParameter(r101, "descriptionContainer");
        Intrinsics.checkNotNullParameter(r102, "atContainerView");
        Intrinsics.checkNotNullParameter(r103, "viewAbility");
        super(r103);
        this.f443131b = r100;
        this.f443132c = r101;
        this.f443133d = r102;
        this.f443136g = (EditText) r100.findViewById(R.id.todo_richText_summary);
        this.f443137h = (EditText) r101.findViewById(R.id.todo_description);
    }
}

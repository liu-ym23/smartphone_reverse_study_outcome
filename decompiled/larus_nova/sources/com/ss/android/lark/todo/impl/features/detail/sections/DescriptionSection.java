package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.todo.impl.framework.config.TodoConfig;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoErrorHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class DescriptionSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f443167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f443168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f443169e;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getDescriptionInit(), new DescriptionSection$initViewObserver$1$1(this));
        k(r100.getDescriptionInfo(), new DescriptionSection$initViewObserver$1$2(this));
        k(r100.getDescriptionShowRichText(), new DescriptionSection$initViewObserver$1$3(this));
        k(r100.getDescriptionClearFocus(), new DescriptionSection$initViewObserver$1$4(this));
    }

    public DescriptionSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443166b = r100;
        EditText r102 = (EditText) r100.findViewById(R.id.todo_description);
        this.f443167c = r102;
        ((KeyboardFunctionEditText) r100.findViewById(R.id.todo_description)).setVisibility(0);
        r102.setFilters(new c8c.d[]{new c8c.d(((TodoConfig) TodoErrorHelper.f444247c.getValue()).c(), b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i1.f443712a})});
        this.f443168d = LazyKt.lazy(new DescriptionSection$editDescriptionClickListener$2(this));
        this.f443169e = LazyKt.lazy(new DescriptionSection$focusChangeListener$2(this));
    }
}

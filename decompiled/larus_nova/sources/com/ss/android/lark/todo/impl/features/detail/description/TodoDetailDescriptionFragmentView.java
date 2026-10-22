package com.ss.android.lark.todo.impl.features.detail.description;

import android.text.method.KeyListener;
import android.view.View;
import android.widget.EditText;
import c8c.d;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.section.e;
import com.larksuite.framework.section.h;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.todo.impl.features.common.richtext2.n;
import com.ss.android.lark.todo.impl.features.detail.at.TodoAtController;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.p;
import com.ss.android.lark.todo.impl.framework.config.TodoConfig;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoErrorHelper;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDetailDescriptionFragmentView extends h<p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<p> f443095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TodoAtController f443096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public KeyListener f443097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f443098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final EditText f443099g;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        CommonTitleBar r100 = (CommonTitleBar) this.f443094b.findViewById(R.id.title_bar);
        if (r100 == null) goto L6;
        r100.setLeftTextColor(UDColorUtils.getColor(r100.getContext(), R.color.text_title));
        r100.setLeftText(CommonTitleBarConstants.TEXT_CANCEL);
        r100.setLeftImageDrawable(null);
        r100.setTitle(R.string.Todo_Task_TaskNotes);
        r100.setLeftClickListener(new a(this));
    L6:
        if (this.f443099g.getKeyListener() == null) goto L8;
        this.f443097e = this.f443099g.getKeyListener();
    L8:
        int r101 = n.f442477a;
        n.b(this.f443099g, true, true, true, 16);
        this.f443099g.addTextChangedListener(new b(this));
        p r102 = e();
        k(r102.getDescriptionFragShowRichText(), new TodoDetailDescriptionFragmentView$initViewObserver$1$1(this));
        k(r102.getDescriptionFragmentInsertAtTag(), new TodoDetailDescriptionFragmentView$initViewObserver$1$2(this));
        k(r102.getInitAtController(), new TodoDetailDescriptionFragmentView$initViewObserver$1$3(this));
        k(r102.getDescriptionInfo(), new TodoDetailDescriptionFragmentView$initViewObserver$1$4(this));
    }

    public TodoDetailDescriptionFragmentView(View r100, e<p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "ability");
        super(r101);
        this.f443094b = r100;
        this.f443095c = r101;
        this.f443098f = LazyKt.lazy(new TodoDetailDescriptionFragmentView$saveAction$2(this));
        EditText r102 = (EditText) r100.findViewById(R.id.edit_description);
        this.f443099g = r102;
        ((KeyboardFunctionEditText) r100.findViewById(R.id.edit_description)).setVisibility(0);
        r102.setFilters(new d[]{new d(((TodoConfig) TodoErrorHelper.f444247c.getValue()).c(), b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{com.ss.android.lark.todo.impl.features.detail.viewmodel.a.i1.f443712a})});
    }
}

package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.todo.impl.features.detail.at.TodoAtController;
import com.ss.android.lark.todo.impl.framework.config.TodoConfig;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoErrorHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SummaryInlineSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TodoAtController f443259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EditText f443260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f443261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f443262f;

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getSummaryInlineShowRichText(), new SummaryInlineSection$initViewObserver$1$1(this));
        k(r100.getSummaryInlineInfo(), new SummaryInlineSection$initViewObserver$1$2(this));
        k(r100.getKeyboardSummaryClearFocus(), new SummaryInlineSection$initViewObserver$1$3(this));
        k(r100.getKeyboardSummaryRequestFocus(), new SummaryInlineSection$initViewObserver$1$4(this));
        k(r100.getSummaryKeyboardInsertAtTag(), new SummaryInlineSection$initViewObserver$1$5(this));
        k(r100.getState(), new SummaryInlineSection$initViewObserver$1$6(this));
    }

    public SummaryInlineSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r110) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r110, "ability");
        super(r110);
        this.f443258b = r100;
        EditText r101 = (EditText) r100.findViewById(R.id.input_content);
        this.f443260d = r101;
        ((KeyboardFunctionEditText) r100.findViewById(R.id.input_content)).setVisibility(0);
        r101.setFilters(new c8c.d[]{new c8c.d(((TodoConfig) TodoErrorHelper.f444247c.getValue()).e(), b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{com.ss.android.lark.todo.impl.features.detail.viewmodel.a.g3.f443702a})});
        com.ss.android.lark.todo.impl.features.common.richtext2.n.b(r101, false, false, false, 30);
        r101.setImeOptions(5);
        r101.setNextFocusForwardId(R.id.input_content);
        r101.setRawInputType(1);
        r101.setOnEditorActionListener(new a1(this));
        r101.setOnFocusChangeListener(new b1(this));
        r101.addTextChangedListener(new c1(this));
        this.f443261e = LazyKt.lazy(new SummaryInlineSection$debounceDispatcher$2(this));
    }
}

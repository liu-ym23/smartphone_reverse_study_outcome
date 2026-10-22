package com.ss.android.lark.todo.impl.features.detail.sections;

import android.text.method.KeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.todo.impl.features.detail.widget.KeyboardScrollView;
import com.ss.android.lark.todo.impl.framework.config.TodoConfig;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoErrorHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SummarySection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f443264o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f443266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f443267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public KeyListener f443268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final KeyboardScrollView f443269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UDButton f443270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UDButton f443271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final UDButton f443272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final EditText f443273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f443274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f443275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f443276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f443277n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SummarySection f443278a;

        public b(SummarySection r100) {
            this.f443278a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f443278a.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.t2.f443773a);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        if (this.f443273j.getKeyListener() == null) goto L5;
        this.f443268e = this.f443273j.getKeyListener();
    L5:
        this.f443273j.addTextChangedListener(new g1(this));
        this.f443273j.setOnFocusChangeListener((View.OnFocusChangeListener) this.f443277n.getValue());
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getSummaryInit(), new SummarySection$initViewObserver$1$1(this));
        k(r100.getSummaryShowRichText(), new SummarySection$initViewObserver$1$2(this));
        k(r100.getCheckboxState(), new SummarySection$initViewObserver$1$3(this));
        k(r100.getGanttContainerShow(), new SummarySection$initViewObserver$1$4(this));
        k(r100.getSummaryInfo(), new SummarySection$initViewObserver$1$5(this));
        k(r100.getSummaryRequestFocus(), new SummarySection$initViewObserver$1$6(this));
        k(r100.getSummaryClearFocus(), new SummarySection$initViewObserver$1$7(this));
        k(r100.getSummaryHideKeyboard(), new SummarySection$initViewObserver$1$8(this));
        k(r100.getDependentDialogShow(), new SummarySection$initViewObserver$1$9(this));
        k(r100.getDependentFinishDialogShow(), new SummarySection$initViewObserver$1$10(this));
    }

    public final void n(boolean r100) {
        if (r100 == false) goto L6;
        EditText r101 = this.f443273j;
        r101.setKeyListener(this.f443268e);
        r101.setLongClickable(true);
        r101.setFocusableInTouchMode(true);
        r101.setOnClickListener(null);
        return;
    L6:
        if (this.f443273j.getKeyListener() == null) goto L8;
        this.f443268e = this.f443273j.getKeyListener();
    L8:
        this.f443273j.setKeyListener(null);
        this.f443273j.setTextIsSelectable(true);
        EditText r102 = this.f443273j;
        if (com.ss.android.lark.todo.impl.features.common.richtext2.f.f442466a != null) goto L11;
        com.ss.android.lark.todo.impl.features.common.richtext2.f.f442466a = new com.ss.android.lark.todo.impl.features.common.richtext2.f();
    L11:
        r102.setMovementMethod(com.ss.android.lark.todo.impl.features.common.richtext2.f.f442466a);
        this.f443273j.setLongClickable(true);
        if (this.f443273j.length() <= 0) goto L14;
        this.f443273j.setFocusableInTouchMode(true);
        this.f443273j.setOnClickListener(null);
        return;
    L14:
        this.f443273j.setFocusableInTouchMode(false);
        this.f443273j.setOnClickListener(new b(this));
    }

    public SummarySection(View r100, View r101, FragmentManager r102, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r103) {
        Intrinsics.checkNotNullParameter(r100, "detailView");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "fragmentManager");
        Intrinsics.checkNotNullParameter(r103, "viewAbility");
        super(r103);
        this.f443265b = r100;
        this.f443266c = r101;
        this.f443267d = r102;
        this.f443269f = (KeyboardScrollView) r101.findViewById(R.id.scroll_view_gantt_container);
        this.f443270g = (UDButton) r101.findViewById(R.id.btn_todo_milestone);
        this.f443271h = (UDButton) r101.findViewById(R.id.btn_task_pre_dependent);
        this.f443272i = (UDButton) r101.findViewById(R.id.btn_task_next_dependent);
        EditText r104 = (EditText) r101.findViewById(R.id.todo_richText_summary);
        this.f443273j = r104;
        this.f443274k = r101.findViewById(R.id.todo_check_box_container);
        this.f443275l = (ImageView) r101.findViewById(R.id.todo_check_box);
        ((KeyboardFunctionEditText) r101.findViewById(R.id.todo_richText_summary)).setVisibility(0);
        r104.setFilters(new c8c.d[]{new c8c.d(((TodoConfig) TodoErrorHelper.f444247c.getValue()).e(), b(), new com.ss.android.lark.todo.impl.features.detail.viewmodel.a[]{com.ss.android.lark.todo.impl.features.detail.viewmodel.a.g3.f443702a})});
        com.ss.android.lark.todo.impl.features.common.richtext2.n.b(r104, false, false, false, 30);
        this.f443277n = LazyKt.lazy(new SummarySection$summaryFocusChangeListener$2(this));
    }
}

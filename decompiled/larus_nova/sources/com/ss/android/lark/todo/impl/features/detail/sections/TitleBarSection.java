package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Configuration;
import android.view.View;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.IActionTitlebar$Action;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;

/* JADX INFO: loaded from: classes38.dex */
public final class TitleBarSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f443292o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f443294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f443295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f443296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f443297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f443298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f443299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f443300i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f443301j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f443302k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f443303l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f443304m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f443305n;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f443306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IActionTitlebar$Action f443307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TitleBarSection f443308c;

        public final void b() {
            IActionTitlebar$Action r100 = this.f443307b;
            if (r100 == null) goto L6;
            this.f443308c.n().removeAction(r100);
            this.f443307b = null;
            return;
        }

        public final void c(com.ss.android.lark.ui.c r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            b();
            if (this.f443306a <= this.f443308c.n().getActionCount()) goto L5;
            this.f443308c.n().addAction(r100);
        L6:
            this.f443307b = r100;
            return;
        L5:
            this.f443308c.n().addAction(r100, this.f443306a);
            goto L6
        }

        public a(TitleBarSection r100, int r101) {
            this.f443308c = r100;
            this.f443306a = r101;
        }

        public final void a(boolean r100, com.ss.android.lark.ui.c r101) {
            Intrinsics.checkNotNullParameter(r101, "action");
            if (r100 == false) goto L5;
            c(r101);
            return;
        L5:
            b();
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    public final CommonTitleBar n() {
        return (CommonTitleBar) this.f443294c.getValue();
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getShareIconShow(), new TitleBarSection$initViewObserver$1$1(this));
        k(r100.getFollowIconState(), new TitleBarSection$initViewObserver$1$2(this));
        k(r100.getMoreIconShow(), new TitleBarSection$initViewObserver$1$3(this));
        k(r100.getTaskNumber(), new TitleBarSection$initViewObserver$1$4(this));
        k(r100.getLeftIconState(), new TitleBarSection$initViewObserver$1$5(this));
        k(r100.getMoreIconState(), new TitleBarSection$initViewObserver$1$6(this));
        k(r100.getInitCreateView(), new TitleBarSection$initViewObserver$1$7(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.c4.f443679a) == false) goto L23;
        a9c.b r101 = a9c.b.f2313a;
        TodoData r102 = e().getTodoDataLiveData().getValue();
        String r103 = "";
        if (r102 == null) goto L8;
        String r104 = r102.getGuid();
        if (r104 == null) goto L8;
    L9:
        Intrinsics.checkNotNullParameter(r104, DBDefinition.TASK_ID);
        s5c.a r105 = z5c.r.f570355y2;
        s5c.a r106 = p3.f570282c;
        r105.getClass();
        a9c.b.a("todo_task_detail_click", s5c.d.b.b(r105, r106).toJson(), r104);
        qf7.a r107 = qf7.a.f532746a;     // Catch: SensitiveAPIException -> L18
        Object r108 = getContext().getSystemService(DataType.CLIPBOARD);     // Catch: SensitiveAPIException -> L18
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: SensitiveAPIException -> L18
        ClipboardManager r109 = (ClipboardManager) r108;     // Catch: SensitiveAPIException -> L18
        com.ss.android.lark.todo.impl.features.detail.viewmodel.b0 r110 = e().getTaskNumber().getValue();     // Catch: SensitiveAPIException -> L18
        if (r110 == null) goto L16;
        String r111 = r110.f443816b;     // Catch: SensitiveAPIException -> L18
        if (r111 == null) goto L16;
        r103 = r111;
    L16:
        r107.a(r109, ClipData.newPlainText("Copied Text", r103), new Token("LARK-PSDA-task_detail_id_copy"));     // Catch: SensitiveAPIException -> L18
        LKUIToast.show(getContext(), UIHelper.getString(R.string.Lark_Legacy_CopySuccess));     // Catch: SensitiveAPIException -> L18
        return;
    L18:
        e = move-exception;
        Log.w("TitleBarSection", "copyItem", e);
        return;
    L8:
        r104 = "";
        goto L9
    }

    @Override // com.larksuite.framework.section.h
    public final void l(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        TodoData r101 = e().getInitCreateView().getValue();
        if (r101 == null) goto L6;
        o(r101);
        return;
    }

    public final void o(TodoData r100) {
        if (r100.isCreateTodo() == true) goto L5;
        return;
    L5:
        if (r100.isShouldFastCreate() == false) goto L9;
        int r101 = com.ss.android.lark.todo.impl.utils.d.f444279a;
        if (com.ss.android.lark.todo.impl.utils.d.a(getContext()) == true) goto L9;
        ((a) this.f443295d.getValue()).c((com.ss.android.lark.ui.c) this.f443300i.getValue());
        return;
    L9:
        ((a) this.f443295d.getValue()).b();
    }

    public TitleBarSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443293b = r100;
        this.f443294c = LazyKt.lazy(new TitleBarSection$titleBar$2(this));
        this.f443295d = LazyKt.lazy(new TitleBarSection$createAction$2(this));
        this.f443296e = LazyKt.lazy(new TitleBarSection$followAction$2(this));
        this.f443297f = LazyKt.lazy(new TitleBarSection$shareAction$2(this));
        this.f443298g = LazyKt.lazy(new TitleBarSection$copyAction$2(this));
        this.f443299h = LazyKt.lazy(new TitleBarSection$moreAction$2(this));
        this.f443300i = LazyKt.lazy(new TitleBarSection$shrinkAction$2(this));
        this.f443301j = LazyKt.lazy(new TitleBarSection$moreIcon$2(this));
        this.f443302k = LazyKt.lazy(new TitleBarSection$shareIcon$2(this));
        this.f443303l = LazyKt.lazy(new TitleBarSection$taskNumberIcon$2(this));
        this.f443304m = LazyKt.lazy(new TitleBarSection$followIcon$2(this));
        this.f443305n = LazyKt.lazy(new TitleBarSection$hasFollowIcon$2(this));
    }
}

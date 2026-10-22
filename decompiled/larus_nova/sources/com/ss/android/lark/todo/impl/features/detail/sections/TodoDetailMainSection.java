package com.ss.android.lark.todo.impl.features.detail.sections;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import com.ss.android.lark.ui.CommonTitleBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDetailMainSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f443314l = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f443317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f443318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f443319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f443320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f443321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f443322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f443323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f443324k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoDetailMainSection f443325a;

        public b(TodoDetailMainSection r100) {
            this.f443325a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            zab.a.a(this.f443325a.c());
            TodoDetailMainSection r101 = this.f443325a;
            boolean r102 = r101.f443317d;
            TodoData r103 = r101.e().getTodoDataLiveData().getValue();
            if (r103 == null) goto L6;
            String r104 = r103.getGuid();
            if (r104 == null) goto L6;
        L7:
            int r105 = a9c.c.f2314a;
            Intrinsics.checkNotNullParameter(r104, "guid");
            if (r102 == false) goto L10;
            a9c.c.a("todo_create_cancel");
        L11:
            TodoDetailMainSection r106 = this.f443325a;
            if (r106.f443318e == false) goto L14;
            return;
        L14:
            if (r106.f443317d == true) goto L16;
            return;
        L16:
            if (r106.f443323j == false) goto L21;
            a9c.c.h(false);
            return;
        L21:
            return;
        L10:
            a9c.c.b("todo_task_close", new JSONObject().put("task_id", r104));
        L6:
            r104 = "";
            goto L7
        }
    }

    static {
    }

    @Override // com.larksuite.framework.section.h
    public final void a() {
        if (this.f443318e == false) goto L5;
    L6:
        Intent r100 = new Intent();
        if (this.f443322i == false) goto L21;
        TodoData r101 = e().getTodoDataLiveData().getValue();
        if (r101 == null) goto L12;
        String r102 = r101.getGuid();
        if (r102 == null) goto L12;
    L13:
        r100.putExtra("message_alert_todo_guid", r102);
        TodoData r103 = e().getTodoDataLiveData().getValue();
        if (r103 == null) goto L18;
        boolean r104 = true;
        if (r103.getCreateSuccess() != true) goto L18;
    L19:
        if (r104 == false) goto L21;
        r100.putExtra("todo_create_detail_container_guid", r103.getContainerGuid());
        r100.putExtra("todo_create_detail_section_guid", r103.getSectionGuid());
        r100.putExtra("todo_create_detail_rank", r103.getRank());
    L18:
        r104 = false;
    L12:
        r102 = "";
    L21:
        FragmentActivity r105 = c().getActivity();
        if (r105 == null) goto L24;
        r105.setResult(-1, r100);
    L24:
        Log.i("TodoDetailMainSection", "setResult for chat");
        return;
    L5:
        if (this.f443319f == true) goto L6;
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
        ((CommonTitleBar) this.f443315b.findViewById(R.id.title_bar)).setLeftClickListener(new b(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getInitCreateView(), new TodoDetailMainSection$initViewObserver$1$1(this));
        k(r100.getActivityFinished(), new TodoDetailMainSection$initViewObserver$1$2(this));
        k(r100.getLoading(), new TodoDetailMainSection$initViewObserver$1$3(this));
        k(r100.getLoadingResult(), new TodoDetailMainSection$initViewObserver$1$4(this));
        k(r100.getShareEntity(), new TodoDetailMainSection$initViewObserver$1$5(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.q0.f443756a) == false) goto L6;
        b().e(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.q1.f443757a, true);
        return;
    }

    public TodoDetailMainSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443315b = r100;
        this.f443316c = r101;
        this.f443317d = true;
        this.f443324k = LazyKt.lazy(new TodoDetailMainSection$loadingUI$2(this));
    }

    @Override // com.larksuite.framework.section.h
    public final void h(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.q1.f443757a) == false) goto L12;
        this.f443318e = r101;
        if (r101 == false) goto L10;
        ((FrameLayout) this.f443315b.findViewById(R.id.edit_activity_root)).setVisibility(4);
        int r102 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f443315b.measure(r102, r102);
        if (((FrameLayout) this.f443315b.findViewById(R.id.content_detail_activity)).getLayoutTransition() != null) goto L9;
        ((FrameLayout) this.f443315b.findViewById(R.id.content_detail_activity)).setLayoutTransition(m8c.a.a(this.f443315b.getMeasuredHeight(), 300));
    L9:
        ((FrameLayout) this.f443315b.findViewById(R.id.todo_feature_fragment_container)).setOnClickListener(new w1(this));
        return;
    L10:
        a9c.b.b(a9c.b.f2313a, "todo_create_view", new JSONObject(), 4);
        ((FrameLayout) this.f443315b.findViewById(R.id.edit_activity_root)).setVisibility(0);
        ((FrameLayout) this.f443315b.findViewById(R.id.todo_feature_fragment_container)).setClickable(false);
        return;
    }
}

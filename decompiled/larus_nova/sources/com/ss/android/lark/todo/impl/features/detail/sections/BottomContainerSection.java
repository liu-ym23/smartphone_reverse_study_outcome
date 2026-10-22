package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BottomContainerSection extends com.larksuite.framework.section.h<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f443151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f443152c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomContainerSection f443153a;

        public a(BottomContainerSection r100) {
            this.f443153a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ((UDCheckBox) this.f443153a.f443151b.findViewById(R.id.checkbox_send_to_chat)).setChecked(!((UDCheckBox) this.f443153a.f443151b.findViewById(R.id.checkbox_send_to_chat)).isChecked());
        }
    }

    public static final class b implements UDCheckBox.c {
        public b() {
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            y8c.a.a().putBoolean("key_todo_send_to_chat_checkbox", r101);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f443154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BottomContainerSection f443155b;

        public c(BottomContainerSection r100) {
            this.f443155b = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f443154a;
            long r102 = System.currentTimeMillis();
            this.f443154a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            this.f443155b.b().a(com.ss.android.lark.todo.impl.features.detail.viewmodel.a.t0.f443771a);
        }
    }

    @Override // com.larksuite.framework.section.h
    public final void i() {
    }

    public final void n() {
        boolean r100 = false;
        if (this.f443152c <= 0) goto L5;
        boolean r101 = true;
    L6:
        List<TodoAttachmentData> r102 = e().getAttachments().getValue();
        if (r102 == null) goto L25;
        List<TodoAttachmentData> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L25;
        String r105 = ((TodoAttachmentData) r104.next()).getFileToken();
        if (r105 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == false) goto L15;
        boolean r107 = false;
    L26:
        if (r101 == false) goto L29;
        if (r107 == false) goto L29;
        r100 = true;
    L29:
        UDButton r108 = (UDButton) this.f443151b.findViewById(R.id.button_create);
        if (r108 == null) goto L32;
        r108.setEnabled(r100);
    L32:
        UDButton r109 = (UDButton) this.f443151b.findViewById(R.id.button_create);
        if (r109 == null) goto L45;
        com.ss.android.lark.todo.impl.utils.i r110 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r100 == false) goto L37;
        int r111 = R.color.primary_fill_default;
    L38:
        r109.setStrokeColor(r110.a(r111));
        return;
    L37:
        r111 = R.color.text_disable;
        goto L38
    L45:
        return;
    L19:
        if (r105.length() == 0) goto L22;
        r106 = false;
        goto L23
    L11:
        if (r103.isEmpty() == false) goto L13;
    L25:
        r107 = true;
        goto L26
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larksuite.framework.section.h
    public final void j() {
        com.ss.android.lark.todo.impl.features.detail.viewmodel.p r100 = e();
        k(r100.getShowCreateAndAssigneeDialog(), new BottomContainerSection$initViewObserver$1$1(this));
        k(r100.getAllUsersCompletedDialog(), new BottomContainerSection$initViewObserver$1$2(this));
        k(r100.getAllUsersUnCompletedDialog(), new BottomContainerSection$initViewObserver$1$3(this));
        k(r100.getFastCreateInitData(), new BottomContainerSection$initViewObserver$1$4(this));
        k(r100.getAttachments(), new BottomContainerSection$initViewObserver$1$5(this));
    }

    public BottomContainerSection(View r100, com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "viewAbility");
        super(r101);
        this.f443151b = r100;
        boolean r102 = false;
        ((UDButton) r100.findViewById(R.id.button_create)).setEnabled(false);
        ((UDButton) r100.findViewById(R.id.button_create)).setStrokeColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_disable));
        r100.findViewById(R.id.button_create).setOnClickListener(new c(this));
        ((LinearLayout) r100.findViewById(R.id.layout_checkbox_send_to_chat)).setOnClickListener(new a(this));
        ((UDCheckBox) r100.findViewById(R.id.checkbox_send_to_chat)).setChecked(y8c.a.a().getBoolean("key_todo_send_to_chat_checkbox", true));
        ((UDCheckBox) r100.findViewById(R.id.checkbox_send_to_chat)).setOnCheckedChangeListener(new b());
        TextView r103 = (TextView) r100.findViewById(R.id.text_checkbox_send_to_chat);
        String r104 = e().getThreadIdForCreate().getValue();
        if (r104 != null) goto L5;
    L6:
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        int r105 = R.string.Todo_Task_SendTaskToChatShortcut;
    L10:
        r103.setText(r105);
        return;
    L9:
        r105 = R.string.Todo_SendTaskToTopic_Checkbox;
        goto L10
    L5:
        if (r104.length() != 0) goto L7;
        goto L6
    }

    @Override // com.larksuite.framework.section.h
    public final void g(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100, com.ss.android.lark.todo.impl.features.detail.viewmodel.a.j3.f443720a) == false) goto L13;
        TodoData r102 = e().getTodoDataLiveData().getValue();
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.isCreateTodo() != true) goto L9;
    L10:
        if (r103 == false) goto L14;
        this.f443152c = r101;
        n();
        return;
    L14:
        return;
    L9:
        r103 = false;
        goto L10
    }
}

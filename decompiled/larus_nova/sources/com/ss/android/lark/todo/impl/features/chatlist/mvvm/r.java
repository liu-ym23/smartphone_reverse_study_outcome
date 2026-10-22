package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f442400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskListPermissionFragment f442401b;

    public static final class a implements UDListDialogController.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListPermissionFragment f442402a;

        public a(TaskListPermissionFragment r100) {
            this.f442402a = r100;
        }

        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r100) {
            TaskListPermissionFragment r101 = this.f442402a;
            int r102 = TaskListPermissionFragment.f442310k;
            TaskListPermissionViewModel r103 = (TaskListPermissionViewModel) r101.f442317j.getValue();
            if (r100 != 1) goto L5;
            TodoItemMemberRole r104 = TodoItemMemberRole.WRITER;
        L6:
            r103.setRole(r104);
            return;
        L5:
            r104 = TodoItemMemberRole.READER;
            goto L6
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        UDActionPanelBuilder r101 = new UDActionPanelBuilder(this.f442400a);
        com.ss.android.lark.todo.impl.utils.i r102 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        UDDialog r103 = ((UDActionPanelBuilder) r101.items(CollectionsKt.listOf(new String[]{r102.g(R.string.Todo_List_NoPermissionRequestViewLatter_Text), r102.g(R.string.Todo_List_NoPermissionRequestEditLatter_Text)})).itemClickListener(new a(this.f442401b)).addActionButton(R.id.ud_dialog_btn_cancel, r102.g(R.string.Lark_Legacy_Cancel), null)).build();
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.primary_fill_default));
    }

    public r(Context r100, TaskListPermissionFragment r101) {
        this.f442400a = r100;
        this.f442401b = r101;
    }
}

package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.view.View;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.chatlist.item.TodoDisplayItem;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TodoDisplayItem f442223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f442224b;

    public f(TodoDisplayItem r100, View r101) {
        this.f442223a = r100;
        this.f442224b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a9c.b r101 = a9c.b.f2313a;
        TodoDisplayItem r102 = this.f442223a;
        String r103 = r102.f442238a;
        v7c.a r104 = r102.f442254q;
        if (r104 == null) goto L6;
        String r105 = r104.f553584c;
        if (r105 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r103, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r105, "chatId");
        a9c.b.a("todo_im_chat_todo_list_click", new JSONObject().put("click", "jump_to_chat").put(PickerReporterConstants.KEY.TARGET, "im_chat_main_view").put("chat_id", r105), r103);
        v7c.a r106 = this.f442223a.f442254q;
        if (r106 == null) goto L14;
        View r107 = this.f442224b;
        if (r106.f553585d == true) goto L12;
        TodoDependencyHolder.a().chatModuleDependency().n(r107.getContext(), r106.f553584c);
        return;
    L12:
        TodoDependencyHolder.a().chatModuleDependency().d(r107.getContext(), r106.f553584c);
        return;
    L14:
        return;
    L6:
        r105 = "";
        goto L7
    }
}

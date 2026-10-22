package com.ss.android.lark.todo.impl.features.detail.dependent.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.larksuite.framework.ui.BaseDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import i8c.f;
import i8c.g;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentDialog;", "Lcom/larksuite/framework/ui/BaseDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "themeResId", "", "dependentType", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel$Companion$TaskDependentType;", "dependentTodos", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lark/pb/todo/v1/Todo;", "todoCanEdit", "", "actionListener", "Lcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentDialog$ActionListener;", "<init>", "(Landroid/content/Context;ILcom/ss/android/lark/todo/impl/features/detail/dependent/TaskDependentSearchViewModel$Companion$TaskDependentType;Ljava/util/concurrent/CopyOnWriteArrayList;ZLcom/ss/android/lark/todo/impl/features/detail/dependent/dialog/TaskDependentDialog$ActionListener;)V", "getDependentTodos", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "initView", "", "initListView", "initTitleBar", "onBackPressed", "ActionListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskDependentDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Todo> f443075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f443076b;

    public interface a {
        void a(String r100);

        void b();

        void c(String r100);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    public TaskDependentDialog(Context r100, int r101, TaskDependentSearchViewModel.Companion.TaskDependentType r102, CopyOnWriteArrayList<Todo> r103, boolean r104, a r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "dependentType");
        Intrinsics.checkNotNullParameter(r103, "dependentTodos");
        Intrinsics.checkNotNullParameter(r105, "actionListener");
        super(r100, r101);
        this.f443075a = r103;
        this.f443076b = r105;
        setContentView(R.layout.task_dependent_dialog_layout);
        setCanceledOnTouchOutside(true);
        TextView r106 = (TextView) findViewById(R.id.tv_title_text);
        if (r102 != TaskDependentSearchViewModel.Companion.TaskDependentType.PREV) goto L5;
        int r107 = R.string.Todo_Tasks_BlockedBy_Title;
    L6:
        r106.setText(UIHelper.getString(r107));
        findViewById(R.id.img_title_close).setOnClickListener(new f(this));
        com.larksuite.framework.section.utils.a.d(findViewById(R.id.tv_title_add), r104);
        findViewById(R.id.tv_title_add).setOnClickListener(new g(this));
        LinearLayoutManager r108 = new LinearLayoutManager(getContext());
        r108.setOrientation(1);
        RecyclerView r109 = (RecyclerView) findViewById(R.id.dependenet_task_lists);
        if (r109 == null) goto L9;
        r109.setLayoutManager(r108);
    L9:
        TaskDependentAdapter r110 = new TaskDependentAdapter(r104);
        r110.f443071b = new com.ss.android.lark.todo.impl.features.detail.dependent.dialog.a(this, r110);
        ((RecyclerView) findViewById(R.id.dependenet_task_lists)).setAdapter(r110);
        Intrinsics.checkNotNullParameter(r103, "datas");
        r110.f443073d.submitList(new ArrayList(r103));
        return;
    L5:
        r107 = R.string.Todo_Tasks_Blocking_Title;
        goto L6
    }
}

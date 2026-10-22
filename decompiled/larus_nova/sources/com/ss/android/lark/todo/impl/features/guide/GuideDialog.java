package com.ss.android.lark.todo.impl.features.guide;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.ui.BaseDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n8c.b;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/guide/GuideDialog;", "Lcom/larksuite/framework/ui/BaseDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "uiHandler", "Landroid/os/Handler;", "initDialogView", "", "initGuideText", "initListener", "showGuideDialog", "dismissDialog", "delayMillis", "", "setDialogHeight", "yDp", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GuideDialog extends BaseDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f443921a;

    public static final class a {
    }

    static {
    }

    public GuideDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.TodoGuideToast);
        this.f443921a = new Handler(Looper.getMainLooper());
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setWindowAnimations(R.style.OperationToastWindow);
    L5:
        setContentView(R.layout.todo_guide_toast);
        setCanceledOnTouchOutside(true);
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.y = UIUtils.dp2px(getContext(), 162);
        r103.gravity = 80;
        r102.setAttributes(r103);
    L8:
        TodoDependencyHolder.a().mainModuleDependency().d();
        ((TextView) findViewById(R.id.tvTodoGuide)).setText(i.f444291a.g(R.string.Todo_Chat_ViewTaskGuideMore));
        ((LinearLayout) findViewById(R.id.llEnterTodo)).setOnClickListener(new b(this));
    }
}

package com.ss.android.lark.todo.impl.adapterhelper.viewholder;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.impl.adapterhelper.TaskBaseQuickAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/adapterhelper/viewholder/TaskListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mAdapter", "Lcom/ss/android/lark/todo/impl/adapterhelper/TaskBaseQuickAdapter;", "<init>", "(Lcom/ss/android/lark/todo/impl/adapterhelper/TaskBaseQuickAdapter;)V", "onInserted", "", "position", "", "count", "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", WsConstants.KEY_PAYLOAD, "", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListUpdateCallback implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskBaseQuickAdapter f441371a;

    public static final class a {
    }

    static {
    }

    public TaskListUpdateCallback(TaskBaseQuickAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "mAdapter");
        this.f441371a = r100;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int r100, int r101) {
        Log.i("TaskListUpdateCallback", "insert, position=" + r100 + ", count=" + r101);
        if (r101 < (this.f441371a.getItemCount() - 1)) goto L5;
        this.f441371a.notifyDataSetChanged();
        return;
    L5:
        this.f441371a.notifyItemRangeInserted(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(int r100, int r101) {
        Log.i("TaskListUpdateCallback", "move, fromPosition=" + r100 + ", toPosition=" + r101);
        this.f441371a.notifyItemMoved(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int r100, int r101) {
        Log.i("TaskListUpdateCallback", "remove, position=" + r100 + ", count=" + r101);
        if (r101 != this.f441371a.f441366d.size()) goto L5;
        this.f441371a.notifyDataSetChanged();
        return;
    L5:
        this.f441371a.notifyItemRangeRemoved(r100, r101);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onChanged(int r100, int r101, Object r102) {
        Log.i("TaskListUpdateCallback", "change, position=" + r100 + ", count=" + r101 + ", payload=" + r102);
        this.f441371a.notifyItemRangeChanged(r100, r101, r102);
    }
}

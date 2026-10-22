package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.lark.pb.todo.v1.Progress;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAssigneeData;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public interface m {
    LiveData<List<TodoAssigneeData>> getAddSubTaskOwnerInfo();

    LiveData<Boolean> getAddSubTaskRequestFocus();

    LiveData<b> getAddSubTaskSelectAtChatter();

    LiveData<RichText> getAddSubTaskSummary();

    LiveData<a0> getAddSubTaskTimeInfo();

    LiveData<Integer> getAncestorStatus();

    LiveData<SubTaskLoadingStatus> getSubTaskLoadingStatus();

    LiveData<Progress> getSubTaskProgress();

    LiveData<List<SimpleSubTodoData>> getSubTasks();

    ConcurrentHashMap<String, String> getSubTasksRank();

    LiveData<Boolean> isInAddSubTask();

    LiveData<Boolean> isSubTaskEditEnable();
}

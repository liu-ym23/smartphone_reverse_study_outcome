package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.u;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface d {
    LiveData<u> getSearchTaskLists();

    LiveData<Boolean> getTaskListCanEdit();

    LiveData<List<com.ss.android.lark.todo.impl.features.detail.viewmodel.g>> getTaskListItems();

    LiveData<Boolean> getTaskListShowEnable();
}

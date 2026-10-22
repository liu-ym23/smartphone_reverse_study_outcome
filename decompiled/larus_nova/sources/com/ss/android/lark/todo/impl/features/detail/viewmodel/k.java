package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes38.dex */
public interface k {
    LiveData<Boolean> getAllUsersCompletedDialog();

    LiveData<Boolean> getAllUsersUnCompletedDialog();

    LiveData<Integer> getAssigneeCompleteState();

    LiveData<Boolean> getShowCreateAndAssigneeDialog();
}

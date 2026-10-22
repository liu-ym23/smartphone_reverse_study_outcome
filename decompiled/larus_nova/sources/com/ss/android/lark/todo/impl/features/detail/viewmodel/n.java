package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.lark.pb.todo.v1.TaskMode;

/* JADX INFO: loaded from: classes38.dex */
public interface n {
    LiveData<Boolean> getShowTaskModeChooserDialog();

    LiveData<TaskMode> getTaskMode();
}

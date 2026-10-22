package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoCustomFieldData;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface l {
    LiveData<List<TodoCustomFieldData>> getCustomFields();

    LiveData<TodoCustomFieldData> getShowCustomFieldsDatePickerEvent();

    LiveData<TodoCustomFieldData> getShowCustomFieldsNumberEditTextEvent();

    LiveData<TodoCustomFieldData> getShowCustomFieldsOptionPickerEvent();

    LiveData<TodoCustomFieldData> getShowCustomFieldsTextEditTextEvent();
}

package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public interface j {
    LiveData<List<TodoAttachmentData>> getAttachments();

    LiveData<Boolean> getCommentAttachmentsUploading();

    LiveData<Boolean> getShowFileChooserDialog();

    LiveData<Boolean> isAttachmentEditable();
}

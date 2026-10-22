package com.ss.android.lark.todo.impl.features.detail.comment;

import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class m<T> implements Comparator {
    public m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((TodoAttachmentData) r100).getUploadMilliTime()), Long.valueOf(((TodoAttachmentData) r101).getUploadMilliTime()));
    }
}

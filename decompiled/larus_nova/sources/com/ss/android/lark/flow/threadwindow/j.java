package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes36.dex */
public interface j {
    void insertSendingRootPlaceholder(Message r100);

    void markRootSendFailed(Message r100);

    void markRootSendSuccess(Message r100, String r101);
}

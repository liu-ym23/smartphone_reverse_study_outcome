package com.ss.android.lark.chat.chatwindow.chat.data.reply;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.MessageInfo;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    CharSequence a(MessageInfo r100);

    void b(MessageInfo r100, boolean r101, IGetDataCallback<i7b.c> r102);

    void c(MessageInfo r100, IGetDataCallback<i7b.c> r101);

    void d(MessageInfo r100, IGetDataCallback<i7b.c> r101);
}

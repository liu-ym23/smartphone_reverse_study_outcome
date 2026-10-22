package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes35.dex */
public interface b {
    Object a(String r100, ProfileSource r101, Continuation<? super Result<? extends Chat>> r102);

    Object b(String r100, Continuation<? super Result<? extends Chat>> r101);

    Object c(String r100, Continuation<? super Result<? extends Chatter>> r101);
}

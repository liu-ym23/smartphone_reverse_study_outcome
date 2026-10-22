package com.larus.bmhome.chat.camera.command;

import com.larus.im.bean.bot.BotModel;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
public interface l {
    BotModel a();

    Object b(Continuation<? super BotModel> r100);

    boolean c1();

    CoroutineScope getScope();
}

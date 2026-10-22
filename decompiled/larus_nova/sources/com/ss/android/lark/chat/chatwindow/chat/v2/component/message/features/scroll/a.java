package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.scroll;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a {
    void a();

    s0 b();

    void e(int r100, boolean r101);

    a1 h();

    w0 i();

    void r(ScrollScene r100, int r101, boolean r102, int r103);

    void t3(ScrollScene r100, int r101, boolean r102, boolean r103, IMessageListComponent.k r104, Function1<? super MessageInfo, Boolean> r105);
}

package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.data;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.biz.im.api.message.audit.e;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Collection;
import java.util.List;
import y6b.c;

/* JADX INFO: loaded from: classes35.dex */
public interface a extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.a, e {
    MutableLiveData Da();

    List<f5b.b> Fa(Collection<String> r100);

    int Fe();

    void H5(String r100);

    void Jf(MessageListRendererFeature$initPullToRefresh$1$onLoadMoreBegin$1 r100);

    MutableLiveData Kn();

    ChatChatter N0();

    void N3();

    void addSticker(String r100);

    ChatChatter an();

    void b7();

    boolean canLoadMore();

    boolean canLoadPre();

    void cancelUploadMediaMsg(String r100, String r101);

    void executeMessage(Runnable r100);

    IMessageListViewModel f();

    void g(List<? extends c<?>> r100);

    void g6(int r100);

    Chat getCurrentChat();

    MessageInfo getMessageInfoById(String r100);

    s2b.e getUIModel();

    void retrySendMessage(String r100);

    void rm(String r100, String r101);

    void xl(MessageListRendererFeature$initPullToRefresh$1$onRefreshBegin$1 r100);

    List<String> y0(int r100);

    void z6(boolean r100);
}

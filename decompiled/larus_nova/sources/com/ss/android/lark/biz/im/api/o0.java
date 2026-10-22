package com.ss.android.lark.biz.im.api;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1;
import com.ss.android.lark.flow.replyinthread.pages.plugin.ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface o0 {
    void Dd(String r100, UIGetDataCallback r101);

    void J7(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$1.AnonymousClass2 r102);

    void N6(String r100, SyncDataStrategy r101, IGetDataCallback r102);

    l5b.a Qb(String r100, MessageFetchScene r101, int r102, int r103, int r104, ChannelDataFetcherStrategy r105, int r106, boolean r107);

    ThreadTopic Vd(String r100);

    void ja(String r100, boolean r101, ReplyInThreadTitleBarPlugin$showMoreOperationMenu$2.AnonymousClass1 r102);

    void q5(List r100, int r101, int r102);
}

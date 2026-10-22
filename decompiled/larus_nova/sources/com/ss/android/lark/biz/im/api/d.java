package com.ss.android.lark.biz.im.api;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.compose.chatsetting.bridge.SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface d {
    gya.a<Content> a(com.ss.android.lark.chat.export.entity.message.MessageType r100);

    BasicDialogContentConfig b();

    CardContent c(com.ss.android.lark.chat.entity.message.content.CardContent r100);

    List<gya.a<Content>> d();

    void e();

    void f(Activity r100, String r101, Map r102, SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1 r103);
}

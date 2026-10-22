package com.ss.android.lark.keyboard.dependency;

import android.view.View;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.chat.entity.chat.Chat;
import d5b.c;
import m6b.o;

/* JADX INFO: loaded from: classes36.dex */
public interface a {
    eya.a getLocationPanelItemConfig(Chat r100, c r101, View r102, ComponentType r103);

    void registerPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102, o r103);

    void unregisterPushChatRelation(Object r100, String r101, SubscribeChatEventRequest.SubscriptionKey r102);
}

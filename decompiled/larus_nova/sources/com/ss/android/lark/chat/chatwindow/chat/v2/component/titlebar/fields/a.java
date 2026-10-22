package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsRequest;
import com.bytedance.lark.pb.contact.v2.GetUserChatWindowFieldsResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public interface a {
    void a(GetUserChatWindowFieldsRequest.Builder r100, IGetDataCallback<c> r101, Function1<? super GetUserChatWindowFieldsResponse, c> r102);
}

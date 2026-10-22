package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$ChatRequest {

    @JSONField(name = "chatid")
    public String mChatId;

    @JSONField(name = "isBot")
    public boolean mIsBot;

    @JSONField(name = "type")
    public String mType;

    public Messenger$ChatRequest() {
    }
}

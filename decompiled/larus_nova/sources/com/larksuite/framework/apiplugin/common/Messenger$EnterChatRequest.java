package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$EnterChatRequest extends LKBaseRequestModel {

    @JSONField(name = "chatterId")
    public String mChatterId;

    @JSONField(name = "needBadge")
    public boolean mNeedBadge;

    @JSONField(name = "openChatId")
    public String mOpenChatId;

    @JSONField(name = "openid")
    public String mOpenId;

    public Messenger$EnterChatRequest() {
    }
}

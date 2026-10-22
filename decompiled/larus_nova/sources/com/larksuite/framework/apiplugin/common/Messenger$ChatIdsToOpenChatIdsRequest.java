package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$ChatIdsToOpenChatIdsRequest extends LKBaseRequestModel {

    @JSONField(name = "chats")
    public List<Messenger$ChatRequest> mChats;

    public Messenger$ChatIdsToOpenChatIdsRequest() {
        this.mChats = new ArrayList();
    }
}

package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$ChatBadgeRequest extends LKBaseRequestModel {

    @JSONField(name = "chatIds")
    @LKRequiredParam
    public List<String> mChatIds;

    public Messenger$ChatBadgeRequest() {
        this.mChatIds = new ArrayList();
    }
}

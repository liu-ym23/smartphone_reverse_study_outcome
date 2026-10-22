package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$OpenChatIds2ChatIdsResponse extends LKBaseResponseModel {

    @JSONField(name = "chatIds")
    public List<String> mChatIds;

    @JSONField(name = "failedOpenChatIds")
    public List<String> mFailedOpenChatIds;

    public Messenger$OpenChatIds2ChatIdsResponse() {
        this.mChatIds = new ArrayList();
        this.mFailedOpenChatIds = new ArrayList();
    }
}

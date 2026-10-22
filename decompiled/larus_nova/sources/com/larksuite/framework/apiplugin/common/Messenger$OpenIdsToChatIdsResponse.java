package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$OpenIdsToChatIdsResponse extends LKBaseResponseModel {

    @JSONField(name = "chatIds")
    public ArrayList<String> mChatIds;

    public Messenger$OpenIdsToChatIdsResponse() {
        this.mChatIds = new ArrayList();
    }
}

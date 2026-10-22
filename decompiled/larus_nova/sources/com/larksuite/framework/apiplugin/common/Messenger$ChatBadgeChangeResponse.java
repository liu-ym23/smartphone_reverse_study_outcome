package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.service.manager.alliance.IAllianceService;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$ChatBadgeChangeResponse extends LKBaseResponseModel {

    @JSONField(name = IAllianceService.CONTENT_TYPE_BADGE)
    public int mBadge;

    @JSONField(name = "chatId")
    public String mChatId;

    @JSONField(name = "isRemind")
    public boolean mIsRemind;

    public Messenger$ChatBadgeChangeResponse() {
    }
}

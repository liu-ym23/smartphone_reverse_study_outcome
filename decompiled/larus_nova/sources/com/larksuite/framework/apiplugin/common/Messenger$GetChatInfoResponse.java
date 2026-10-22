package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$GetChatInfoResponse extends LKBaseResponseModel {

    @JSONField(name = "atCount")
    public int mAtCount;

    @JSONField(name = "avatarUrls")
    public List<String> mAvatarUrls;

    @JSONField(name = IAllianceService.CONTENT_TYPE_BADGE)
    public int mBadge;

    @JSONField(name = "i18nNames")
    public JSONObject mI18nNames;

    @JSONField(name = "name")
    public String mName;

    public Messenger$GetChatInfoResponse() {
        this.mAvatarUrls = new ArrayList();
    }
}

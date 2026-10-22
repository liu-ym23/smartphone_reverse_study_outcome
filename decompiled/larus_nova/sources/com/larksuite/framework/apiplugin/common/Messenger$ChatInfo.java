package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$ChatInfo {

    @JSONField(name = "avatarUrls")
    public List<String> mAvatarUrls;

    @JSONField(name = "chatType")
    public int mChatType;

    @JSONField(name = "i18nNames")
    public JSONObject mI18nNames;

    @JSONField(name = "id")
    public String mId;

    @JSONField(name = "name")
    public String mName;

    @JSONField(name = "userType")
    public int mUserType;

    public Messenger$ChatInfo() {
        this.mAvatarUrls = new ArrayList();
    }
}

package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$OpenIdsToUserIdsRequest extends LKBaseRequestModel {

    @JSONField(name = "openIds")
    @LKRequiredParam
    public ArrayList<String> mOpenIds;

    public Messenger$OpenIdsToUserIdsRequest() {
        this.mOpenIds = new ArrayList();
    }
}

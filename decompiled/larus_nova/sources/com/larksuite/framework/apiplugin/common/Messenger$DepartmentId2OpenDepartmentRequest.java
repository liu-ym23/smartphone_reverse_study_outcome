package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class Messenger$DepartmentId2OpenDepartmentRequest extends LKBaseRequestModel {

    @JSONField(name = "departmentIds")
    public List<String> mDepartmentIds;

    public Messenger$DepartmentId2OpenDepartmentRequest() {
        this.mDepartmentIds = new ArrayList();
    }
}

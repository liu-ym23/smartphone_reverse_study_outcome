package com.bytedance.ee.bear.middleground.permission.batchauthorize.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UpdateCardRequest implements Serializable {

    @JSONField(name = "origin_object_token")
    private String objectToken;

    @JSONField(name = "origin_object_type")
    private long objectType;

    public UpdateCardRequest() {
    }

    public String getObjectToken() {
        return this.objectToken;
    }

    public long getObjectType() {
        return this.objectType;
    }

    public void setObjectToken(String r1) {
        this.objectToken = r1;
    }

    public void setObjectType(long r1) {
        this.objectType = r1;
    }
}

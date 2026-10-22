package com.bytedance.ee.bear.retention;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RetentionSettingVisible extends Result {
    private boolean canSetRetentionLabel;
    private String entityType;
    private String token;

    public RetentionSettingVisible() {
    }

    public String getEntityType() {
        return this.entityType;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isCanSetRetentionLabel() {
        return this.canSetRetentionLabel;
    }

    public void setCanSetRetentionLabel(boolean r1) {
        this.canSetRetentionLabel = r1;
    }

    public void setEntityType(String r1) {
        this.entityType = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }
}

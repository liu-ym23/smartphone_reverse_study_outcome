package com.bytedance.ee.bear.retention;

import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setCanSetRetentionLabel(boolean r100) {
        this.canSetRetentionLabel = r100;
    }

    public void setEntityType(String r100) {
        this.entityType = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}

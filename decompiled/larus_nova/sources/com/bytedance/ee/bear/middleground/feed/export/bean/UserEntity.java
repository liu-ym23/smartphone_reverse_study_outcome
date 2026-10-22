package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public class UserEntity implements NonProguard {

    @JSONField(name = "avatar_url")
    private String avatarUrl;

    @JSONField(name = "cn_name")
    private String cnName;

    @JSONField(name = IGoogleService.ResponseKey.DISPLAY_NAME)
    private DisplayName displayName;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "en_name")
    private String enName;

    @JSONField(name = "i18n_name")
    private HashMap<String, String> i18nName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @JSONField(name = "id")
    private String f232607id;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "suid")
    private String suid;

    @JSONField(name = "tenant_id")
    private String tenantId;

    @JSONField(name = "tenant_name")
    private String tenantName;

    public UserEntity() {
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getCnName() {
        return this.cnName;
    }

    public DisplayName getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEnName() {
        return this.enName;
    }

    public HashMap<String, String> getI18nName() {
        return this.i18nName;
    }

    public String getId() {
        return this.f232607id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getName() {
        return this.name;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setCnName(String r100) {
        this.cnName = r100;
    }

    public void setDisplayName(DisplayName r100) {
        this.displayName = r100;
    }

    public void setEmail(String r100) {
        this.email = r100;
    }

    public void setEnName(String r100) {
        this.enName = r100;
    }

    public void setI18nName(HashMap<String, String> r100) {
        this.i18nName = r100;
    }

    public void setId(String r100) {
        this.f232607id = r100;
    }

    public void setMobile(String r100) {
        this.mobile = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setSuid(String r100) {
        this.suid = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTenantName(String r100) {
        this.tenantName = r100;
    }
}

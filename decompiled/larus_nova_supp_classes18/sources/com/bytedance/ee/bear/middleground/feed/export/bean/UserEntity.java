package com.bytedance.ee.bear.middleground.feed.export.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class UserEntity implements NonProguard {

    @JSONField(name = "avatar_url")
    private String avatarUrl;

    @JSONField(name = "cn_name")
    private String cnName;

    @JSONField(name = "display_name")
    private DisplayName displayName;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "en_name")
    private String enName;

    @JSONField(name = "i18n_name")
    private HashMap<String, String> i18nName;

    @JSONField(name = ResourceData.KEY_ID)
    private String id;

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
        return this.id;
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

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setCnName(String r1) {
        this.cnName = r1;
    }

    public void setDisplayName(DisplayName r1) {
        this.displayName = r1;
    }

    public void setEmail(String r1) {
        this.email = r1;
    }

    public void setEnName(String r1) {
        this.enName = r1;
    }

    public void setI18nName(HashMap<String, String> r1) {
        this.i18nName = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setMobile(String r1) {
        this.mobile = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setSuid(String r1) {
        this.suid = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTenantName(String r1) {
        this.tenantName = r1;
    }
}

package com.bytedance.ee.bear.middleground.permission.collaborator;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NotNotifyUserEntity implements NonProguard {
    private String avatar_url;
    private boolean can_apply_perm;
    private String cn_name;
    private String email;
    private String en_name;
    private String id;
    private String mobile;
    private String name;
    private int ownerType;
    private int permission;
    private String suid;
    private String tenant_id;
    private String tenant_name;

    public NotNotifyUserEntity() {
    }

    public static NotNotifyUserEntity mock() {
        NotNotifyUserEntity r0 = new NotNotifyUserEntity();
        r0.id = "6616581916592177166";
        r0.name = "黄姚警";
        r0.cn_name = "黄姚警";
        r0.en_name = "黄姚警";
        r0.suid = "6616581916592177166";
        return r0;
    }

    public String getAvatar_url() {
        return this.avatar_url;
    }

    public String getCn_name() {
        return this.cn_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEn_name() {
        return this.en_name;
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

    public int getOwnerType() {
        return this.ownerType;
    }

    public int getPermission() {
        return this.permission;
    }

    public String getSuid() {
        return this.suid;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public String getTenant_name() {
        return this.tenant_name;
    }

    public boolean isCan_apply_perm() {
        return this.can_apply_perm;
    }

    public void setAvatar_url(String r1) {
        this.avatar_url = r1;
    }

    public void setCan_apply_perm(boolean r1) {
        this.can_apply_perm = r1;
    }

    public void setCn_name(String r1) {
        this.cn_name = r1;
    }

    public void setEmail(String r1) {
        this.email = r1;
    }

    public void setEn_name(String r1) {
        this.en_name = r1;
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

    public void setOwnerType(int r1) {
        this.ownerType = r1;
    }

    public void setPermission(int r1) {
        this.permission = r1;
    }

    public void setSuid(String r1) {
        this.suid = r1;
    }

    public void setTenant_id(String r1) {
        this.tenant_id = r1;
    }

    public void setTenant_name(String r1) {
        this.tenant_name = r1;
    }
}

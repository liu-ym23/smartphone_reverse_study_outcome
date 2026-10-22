package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class GroupChatConfig implements Serializable {
    private Condition$GroupChatTypeCondition groupChatTypeCondition;
    private Condition$PublicTypeCondition publicTypeCondition;
    private Condition$ShieldTypeCondition shieldTypeCondition;
    private Condition$TenantCondition tenantCondition;

    public GroupChatConfig() {
        this.tenantCondition = Condition$TenantCondition.ALL_TENANT;
        this.groupChatTypeCondition = Condition$GroupChatTypeCondition.ALL_CHAT;
        this.publicTypeCondition = Condition$PublicTypeCondition.ALL_STATUS;
        this.shieldTypeCondition = Condition$ShieldTypeCondition.ALL;
    }

    public Condition$GroupChatTypeCondition getGroupChatTypeCondition() {
        return this.groupChatTypeCondition;
    }

    public Condition$PublicTypeCondition getPublicTypeCondition() {
        return this.publicTypeCondition;
    }

    public Condition$ShieldTypeCondition getShieldTypeCondition() {
        return this.shieldTypeCondition;
    }

    public Condition$TenantCondition getTenantCondition() {
        return this.tenantCondition;
    }

    public void setGroupChatTypeCondition(Condition$GroupChatTypeCondition r100) {
        this.groupChatTypeCondition = r100;
    }

    public void setTenantCondition(Condition$TenantCondition r100) {
        this.tenantCondition = r100;
    }

    public static void access$000(GroupChatConfig r100, Condition$PublicTypeCondition r101) {
        r100.publicTypeCondition = r101;
    }

    public static void access$100(GroupChatConfig r100, Condition$ShieldTypeCondition r101) {
        r100.shieldTypeCondition = r101;
    }
}

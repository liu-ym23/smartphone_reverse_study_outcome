package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class UserConfig implements Serializable {
    private Condition$ShieldTypeCondition shieldTypeCondition;
    private Condition$TenantCondition tenantCondition;
    private Condition$UserTypeCondition userTypeCondition;

    public UserConfig() {
        this.tenantCondition = Condition$TenantCondition.ALL_TENANT;
        this.userTypeCondition = Condition$UserTypeCondition.ALL_USER;
        this.shieldTypeCondition = Condition$ShieldTypeCondition.ALL;
    }

    public Condition$ShieldTypeCondition getShieldTypeCondition() {
        return this.shieldTypeCondition;
    }

    public Condition$TenantCondition getTenantCondition() {
        return this.tenantCondition;
    }

    public Condition$UserTypeCondition getUserTypeCondition() {
        return this.userTypeCondition;
    }

    public void setTenantCondition(Condition$TenantCondition r100) {
        this.tenantCondition = r100;
    }

    public void setUserTypeCondition(Condition$UserTypeCondition r100) {
        this.userTypeCondition = r100;
    }

    public static void access$000(UserConfig r100, Condition$ShieldTypeCondition r101) {
        r100.shieldTypeCondition = r101;
    }
}

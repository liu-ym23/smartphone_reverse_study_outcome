package com.ss.android.lark.forwardv2.dto.template.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public class ThreadConfig implements Serializable {
    private Condition$PublicTypeCondition publicTypeCondition;
    private Condition$TenantCondition tenantCondition;
    private Condition$ThreadTypeCondition threadTypeCondition;

    public ThreadConfig() {
        this.tenantCondition = Condition$TenantCondition.ALL_TENANT;
        this.threadTypeCondition = Condition$ThreadTypeCondition.ALL_THREAD;
        this.publicTypeCondition = Condition$PublicTypeCondition.ALL_STATUS;
    }

    public Condition$PublicTypeCondition getPublicTypeCondition() {
        return this.publicTypeCondition;
    }

    public Condition$TenantCondition getTenantCondition() {
        return this.tenantCondition;
    }

    public Condition$ThreadTypeCondition getThreadTypeCondition() {
        return this.threadTypeCondition;
    }

    public void setThreadTypeCondition(Condition$ThreadTypeCondition r100) {
        this.threadTypeCondition = r100;
    }

    public static void access$000(ThreadConfig r100, Condition$PublicTypeCondition r101) {
        r100.publicTypeCondition = r101;
    }

    public static void access$100(ThreadConfig r100, Condition$TenantCondition r101) {
        r100.tenantCondition = r101;
    }
}

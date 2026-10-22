package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0017\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "accessStrategy", "", "roleId", "", "enableSysRole", "", "<init>", "(ILjava/lang/String;Z)V", "getAccessStrategy", "()I", "getRoleId", "()Ljava/lang/String;", "getEnableSysRole", "()Z", "bindRole", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "getBindRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "setBindRole", "(Lcom/bytedance/ee/bear/bitable/pro/Role;)V", "getBindRoleId", "isValid", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultConfig implements NonProguard {
    public static final int ACCESS_STRATEGY_BIND_ROLE = 1;
    public static final int ACCESS_STRATEGY_DENY = 0;
    public static final a Companion = null;
    public static final String TAG = "DefaultConfig";
    private final int accessStrategy;
    private Role bindRole;
    private final boolean enableSysRole;
    private final String roleId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DefaultConfig() {
        this(0, null, false, 7, null);
    }

    public final String getBindRoleId() {
        if (this.accessStrategy == 1) goto L5;
        tt5.a.h(TAG, "accessStrategy is " + this.accessStrategy);
        return null;
    L5:
        return this.roleId;
    }

    public final boolean isValid() {
        int r0 = this.accessStrategy;
        if (r0 != 0) goto L6;
        return true;
    L6:
        if (r0 == 1) goto L8;
        tt5.a.h(TAG, "invalid " + this.accessStrategy);
        return false;
    L8:
        if (this.bindRole == null) goto L10;
        return true;
    L10:
        tt5.a.h(TAG, "invalid roleId  " + this.roleId);
        return false;
    }

    public final int getAccessStrategy() {
        return this.accessStrategy;
    }

    public final Role getBindRole() {
        return this.bindRole;
    }

    public final boolean getEnableSysRole() {
        return this.enableSysRole;
    }

    public final String getRoleId() {
        return this.roleId;
    }

    public final void setBindRole(Role r1) {
        this.bindRole = r1;
    }

    public DefaultConfig(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "roleId");
        this.accessStrategy = r2;
        this.roleId = r3;
        this.enableSysRole = r4;
    }

    public /* synthetic */ DefaultConfig(int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}

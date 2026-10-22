package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/RoleResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "defaultEditRole", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "defaultReadRole", "otherRole", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "defaultConfig", "Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "<init>", "(Lcom/bytedance/ee/bear/bitable/pro/Role;Lcom/bytedance/ee/bear/bitable/pro/Role;Ljava/util/ArrayList;Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;)V", "getDefaultEditRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "getDefaultReadRole", "getOtherRole", "()Ljava/util/ArrayList;", "getDefaultConfig", "()Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoleResult extends Result<Serializable> {
    private final DefaultConfig defaultConfig;
    private final Role defaultEditRole;
    private final Role defaultReadRole;
    private final ArrayList<Role> otherRole;

    public RoleResult() {
        this(null, null, null, null, 15, null);
    }

    public final DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public final Role getDefaultEditRole() {
        return this.defaultEditRole;
    }

    public final Role getDefaultReadRole() {
        return this.defaultReadRole;
    }

    public final ArrayList<Role> getOtherRole() {
        return this.otherRole;
    }

    public RoleResult(Role r2, Role r3, ArrayList<Role> r4, DefaultConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "otherRole");
        this.defaultEditRole = r2;
        this.defaultReadRole = r3;
        this.otherRole = r4;
        this.defaultConfig = r5;
    }

    public /* synthetic */ RoleResult(Role r2, Role r3, ArrayList r4, DefaultConfig r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = new ArrayList();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}

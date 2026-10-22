package com.bytedance.ee.bear.middleground.permission.permission.doc;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J5\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/permission/doc/BatchDocUserPermission;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "perms", "", "", "", "permissionV2", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "getPerms", "()Ljava/util/Map;", "getPermissionV2", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatchDocUserPermission extends Result<Serializable> {
    private final Map<String, Integer> permissionV2;
    private final Map<String, Integer> perms;

    public BatchDocUserPermission() {
        Map r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchDocUserPermission copy$default(BatchDocUserPermission r0, Map r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.perms;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.permissionV2;
    L9:
        return r0.copy(r1, r2);
    }

    public final Map<String, Integer> component1() {
        return this.perms;
    }

    public final Map<String, Integer> component2() {
        return this.permissionV2;
    }

    public final BatchDocUserPermission copy(Map<String, Integer> r2, Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "perms");
        Intrinsics.checkNotNullParameter(r3, "permissionV2");
        return new BatchDocUserPermission(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BatchDocUserPermission) == true) goto L8;
        return false;
    L8:
        BatchDocUserPermission r6 = (BatchDocUserPermission) r5;
        if (Intrinsics.areEqual(this.perms, r6.perms) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permissionV2, r6.permissionV2) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.perms.hashCode() * 31) + this.permissionV2.hashCode();
    }

    public String toString() {
        return "BatchDocUserPermission(perms=" + this.perms + ", permissionV2=" + this.permissionV2 + ')';
    }

    public final Map<String, Integer> getPermissionV2() {
        return this.permissionV2;
    }

    public final Map<String, Integer> getPerms() {
        return this.perms;
    }

    public BatchDocUserPermission(Map<String, Integer> r2, Map<String, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "perms");
        Intrinsics.checkNotNullParameter(r3, "permissionV2");
        this.perms = r2;
        this.permissionV2 = r3;
    }

    public /* synthetic */ BatchDocUserPermission(Map r1, Map r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new HashMap();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new HashMap();
    L8:
        this(r1, r2);
    }
}

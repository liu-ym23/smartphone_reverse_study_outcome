package com.bytedance.ee.bear.middleground.permission.escape.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "Ljava/io/Serializable;", "instances", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "Lkotlin/collections/ArrayList;", "myInstance", "<init>", "(Ljava/util/ArrayList;Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;)V", "getInstances", "()Ljava/util/ArrayList;", "getMyInstance", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalList implements Serializable {
    private final ArrayList<Instance> instances;
    private final Instance myInstance;

    /* JADX WARN: Multi-variable type inference failed */
    public ApprovalList() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApprovalList copy$default(ApprovalList r0, ArrayList r1, Instance r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.instances;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.myInstance;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<Instance> component1() {
        return this.instances;
    }

    public final Instance component2() {
        return this.myInstance;
    }

    public final ApprovalList copy(ArrayList<Instance> r2, Instance r3) {
        Intrinsics.checkNotNullParameter(r2, "instances");
        return new ApprovalList(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ApprovalList) == true) goto L8;
        return false;
    L8:
        ApprovalList r6 = (ApprovalList) r5;
        if (Intrinsics.areEqual(this.instances, r6.instances) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.myInstance, r6.myInstance) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.instances.hashCode() * 31;
        Instance r1 = this.myInstance;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ApprovalList(instances=");
        r0.append(this.instances.size());
        r0.append(", myInstance=");
        if (this.myInstance != null) goto L5;
        String r1 = "null";
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = "not null";
        goto L6
    }

    public final ArrayList<Instance> getInstances() {
        return this.instances;
    }

    public final Instance getMyInstance() {
        return this.myInstance;
    }

    public ApprovalList(ArrayList<Instance> r2, Instance r3) {
        Intrinsics.checkNotNullParameter(r2, "instances");
        this.instances = r2;
        this.myInstance = r3;
    }

    public /* synthetic */ ApprovalList(ArrayList r1, Instance r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}

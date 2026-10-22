package com.bytedance.ee.bear.middleground.permission.escape.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/model/ApprovalList;", "Ljava/io/Serializable;", "instances", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "Lkotlin/collections/ArrayList;", "myInstance", "<init>", "(Ljava/util/ArrayList;Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;)V", "getInstances", "()Ljava/util/ArrayList;", "getMyInstance", "()Lcom/bytedance/ee/bear/middleground/permission/escape/model/Instance;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApprovalList implements Serializable {
    private final ArrayList<Instance> instances;
    private final Instance myInstance;

    /* JADX WARN: Multi-variable type inference failed */
    public ApprovalList() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApprovalList copy$default(ApprovalList r100, ArrayList r101, Instance r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.instances;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.myInstance;
    L9:
        return r100.copy(r101, r102);
    }

    public final ArrayList<Instance> component1() {
        return this.instances;
    }

    public final Instance component2() {
        return this.myInstance;
    }

    public final ApprovalList copy(ArrayList<Instance> r100, Instance r101) {
        Intrinsics.checkNotNullParameter(r100, "instances");
        return new ApprovalList(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApprovalList) == true) goto L8;
        return false;
    L8:
        ApprovalList r101 = (ApprovalList) r100;
        if (Intrinsics.areEqual(this.instances, r101.instances) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.myInstance, r101.myInstance) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.instances.hashCode() * 31;
        Instance r101 = this.myInstance;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("ApprovalList(instances=");
        r100.append(this.instances.size());
        r100.append(", myInstance=");
        if (this.myInstance != null) goto L5;
        String r101 = "null";
    L6:
        r100.append(r101);
        return r100.toString();
    L5:
        r101 = "not null";
        goto L6
    }

    public final ArrayList<Instance> getInstances() {
        return this.instances;
    }

    public final Instance getMyInstance() {
        return this.myInstance;
    }

    public ApprovalList(ArrayList<Instance> r100, Instance r101) {
        Intrinsics.checkNotNullParameter(r100, "instances");
        this.instances = r100;
        this.myInstance = r101;
    }

    public /* synthetic */ ApprovalList(ArrayList r100, Instance r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

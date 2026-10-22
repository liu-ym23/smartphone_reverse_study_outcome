package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B_\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\nJ\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J\u0019\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006HÆ\u0003Ja\u0010 \u001a\u00020\u00002\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006HÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/Department;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "visibleDepartments", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "Lkotlin/collections/ArrayList;", "visibleTopUserInDep", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "hasMore", "", "existsMembers", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/existmember/Member;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;ZLjava/util/ArrayList;)V", "getVisibleDepartments", "()Ljava/util/ArrayList;", "setVisibleDepartments", "(Ljava/util/ArrayList;)V", "getVisibleTopUserInDep", "setVisibleTopUserInDep", "getHasMore", "()Z", "setHasMore", "(Z)V", "getExistsMembers", "setExistsMembers", "isEmpty", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Department extends Result<Serializable> {
    private ArrayList<Member> existsMembers;
    private boolean hasMore;
    private ArrayList<VisibleDepartment> visibleDepartments;
    private ArrayList<VisibleTopUserInDep> visibleTopUserInDep;

    public Department() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Department copy$default(Department r0, ArrayList r1, ArrayList r2, boolean r3, ArrayList r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.visibleDepartments;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.visibleTopUserInDep;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.existsMembers;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final ArrayList<VisibleDepartment> component1() {
        return this.visibleDepartments;
    }

    public final ArrayList<VisibleTopUserInDep> component2() {
        return this.visibleTopUserInDep;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final ArrayList<Member> component4() {
        return this.existsMembers;
    }

    public final Department copy(ArrayList<VisibleDepartment> r2, ArrayList<VisibleTopUserInDep> r3, boolean r4, ArrayList<Member> r5) {
        Intrinsics.checkNotNullParameter(r2, "visibleDepartments");
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        Intrinsics.checkNotNullParameter(r5, "existsMembers");
        return new Department(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Department) == true) goto L8;
        return false;
    L8:
        Department r6 = (Department) r5;
        if (Intrinsics.areEqual(this.visibleDepartments, r6.visibleDepartments) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.visibleTopUserInDep, r6.visibleTopUserInDep) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.existsMembers, r6.existsMembers) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.visibleDepartments.hashCode() * 31) + this.visibleTopUserInDep.hashCode()) * 31;
        if (this.hasMore == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.existsMembers.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "Department(visibleDepartments=" + this.visibleDepartments + ", visibleTopUserInDep=" + this.visibleTopUserInDep + ", hasMore=" + this.hasMore + ", existsMembers=" + this.existsMembers + ')';
    }

    public final boolean isEmpty() {
        if (this.visibleDepartments.isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.visibleTopUserInDep.isEmpty() == false) goto L7;
        return true;
    }

    public final ArrayList<Member> getExistsMembers() {
        return this.existsMembers;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ArrayList<VisibleDepartment> getVisibleDepartments() {
        return this.visibleDepartments;
    }

    public final ArrayList<VisibleTopUserInDep> getVisibleTopUserInDep() {
        return this.visibleTopUserInDep;
    }

    public final void setExistsMembers(ArrayList<Member> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.existsMembers = r2;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public final void setVisibleDepartments(ArrayList<VisibleDepartment> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.visibleDepartments = r2;
    }

    public final void setVisibleTopUserInDep(ArrayList<VisibleTopUserInDep> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.visibleTopUserInDep = r2;
    }

    public Department(ArrayList<VisibleDepartment> r2, ArrayList<VisibleTopUserInDep> r3, boolean r4, ArrayList<Member> r5) {
        Intrinsics.checkNotNullParameter(r2, "visibleDepartments");
        Intrinsics.checkNotNullParameter(r3, "visibleTopUserInDep");
        Intrinsics.checkNotNullParameter(r5, "existsMembers");
        this.visibleDepartments = r2;
        this.visibleTopUserInDep = r3;
        this.hasMore = r4;
        this.existsMembers = r5;
    }

    public /* synthetic */ Department(ArrayList r1, ArrayList r2, boolean r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = new ArrayList();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = new ArrayList();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = false;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = new ArrayList();
    L14:
        this(r1, r2, r3, r4);
    }
}

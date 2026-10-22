package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
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
    public static /* synthetic */ Department copy$default(Department r100, ArrayList r101, ArrayList r102, boolean r103, ArrayList r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.visibleDepartments;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.visibleTopUserInDep;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.existsMembers;
    L15:
        return r100.copy(r101, r102, r103, r104);
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

    public final Department copy(ArrayList<VisibleDepartment> r100, ArrayList<VisibleTopUserInDep> r101, boolean r102, ArrayList<Member> r103) {
        Intrinsics.checkNotNullParameter(r100, "visibleDepartments");
        Intrinsics.checkNotNullParameter(r101, "visibleTopUserInDep");
        Intrinsics.checkNotNullParameter(r103, "existsMembers");
        return new Department(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Department) == true) goto L8;
        return false;
    L8:
        Department r101 = (Department) r100;
        if (Intrinsics.areEqual(this.visibleDepartments, r101.visibleDepartments) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.visibleTopUserInDep, r101.visibleTopUserInDep) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.existsMembers, r101.existsMembers) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.visibleDepartments.hashCode() * 31) + this.visibleTopUserInDep.hashCode()) * 31;
        if (this.hasMore == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.existsMembers.hashCode();
    L5:
        r101 = 1237;
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

    public final void setExistsMembers(ArrayList<Member> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.existsMembers = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setVisibleDepartments(ArrayList<VisibleDepartment> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.visibleDepartments = r100;
    }

    public final void setVisibleTopUserInDep(ArrayList<VisibleTopUserInDep> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.visibleTopUserInDep = r100;
    }

    public Department(ArrayList<VisibleDepartment> r100, ArrayList<VisibleTopUserInDep> r101, boolean r102, ArrayList<Member> r103) {
        Intrinsics.checkNotNullParameter(r100, "visibleDepartments");
        Intrinsics.checkNotNullParameter(r101, "visibleTopUserInDep");
        Intrinsics.checkNotNullParameter(r103, "existsMembers");
        this.visibleDepartments = r100;
        this.visibleTopUserInDep = r101;
        this.hasMore = r102;
        this.existsMembers = r103;
    }

    public /* synthetic */ Department(ArrayList r100, ArrayList r101, boolean r102, ArrayList r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new ArrayList();
    L14:
        this(r100, r101, r102, r103);
    }
}

package com.ss.android.lark.profile.v2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002:\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "departmentPathList", "", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$DepartmentPath;", "getDepartmentPathList", "()Ljava/util/List;", "setDepartmentPathList", "(Ljava/util/List;)V", "groupedManagedDepartments", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$GroupedManagedDepartments;", "getGroupedManagedDepartments", "()Lcom/ss/android/lark/profile/v2/entity/DepartmentField$GroupedManagedDepartments;", "setGroupedManagedDepartments", "(Lcom/ss/android/lark/profile/v2/entity/DepartmentField$GroupedManagedDepartments;)V", "DepartmentNode", "DepartmentPath", "ManagedDepartmentSourceType", "ManagedDepartmentVisibilityType", "ManagedDepartmentInfo", "ManagedDepartmentItem", "ManagedDepartmentGroup", "GroupedManagedDepartments", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentField extends BaseField {
    private List<DepartmentPath> departmentPathList;
    private GroupedManagedDepartments groupedManagedDepartments;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$DepartmentNode;", "Ljava/io/Serializable;", "<init>", "()V", "departmentId", "", "getDepartmentId", "()Ljava/lang/String;", "setDepartmentId", "(Ljava/lang/String;)V", "departmentName", "getDepartmentName", "setDepartmentName", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DepartmentNode implements Serializable {
        private String departmentId;
        private String departmentName;

        public DepartmentNode() {
        }

        public final String getDepartmentId() {
            return this.departmentId;
        }

        public final String getDepartmentName() {
            return this.departmentName;
        }

        public final void setDepartmentId(String r100) {
            this.departmentId = r100;
        }

        public final void setDepartmentName(String r100) {
            this.departmentName = r100;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$DepartmentPath;", "Ljava/io/Serializable;", "<init>", "()V", "departmentNodeList", "", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$DepartmentNode;", "getDepartmentNodeList", "()Ljava/util/List;", "setDepartmentNodeList", "(Ljava/util/List;)V", "accessible", "", "getAccessible", "()Z", "setAccessible", "(Z)V", "link", "", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "errorTip", "getErrorTip", "setErrorTip", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DepartmentPath implements Serializable {
        private boolean accessible;
        private List<DepartmentNode> departmentNodeList;
        private String errorTip;
        private String link;

        public DepartmentPath() {
            this.link = "";
            this.errorTip = "";
        }

        public final boolean getAccessible() {
            return this.accessible;
        }

        public final List<DepartmentNode> getDepartmentNodeList() {
            return this.departmentNodeList;
        }

        public final String getErrorTip() {
            return this.errorTip;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setAccessible(boolean r100) {
            this.accessible = r100;
        }

        public final void setDepartmentNodeList(List<DepartmentNode> r100) {
            this.departmentNodeList = r100;
        }

        public final void setErrorTip(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.errorTip = r100;
        }

        public final void setLink(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.link = r100;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$GroupedManagedDepartments;", "Ljava/io/Serializable;", "groups", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentGroup;", "<init>", "(Ljava/util/ArrayList;)V", "getGroups", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupedManagedDepartments implements Serializable {
        private final ArrayList<ManagedDepartmentGroup> groups;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GroupedManagedDepartments copy$default(GroupedManagedDepartments r100, ArrayList r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.groups;
        L6:
            return r100.copy(r101);
        }

        public final ArrayList<ManagedDepartmentGroup> component1() {
            return this.groups;
        }

        public final GroupedManagedDepartments copy(ArrayList<ManagedDepartmentGroup> r100) {
            Intrinsics.checkNotNullParameter(r100, "groups");
            return new GroupedManagedDepartments(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof GroupedManagedDepartments) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.groups, ((GroupedManagedDepartments) r100).groups) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.groups.hashCode();
        }

        public String toString() {
            return "GroupedManagedDepartments(groups=" + this.groups + ')';
        }

        public final ArrayList<ManagedDepartmentGroup> getGroups() {
            return this.groups;
        }

        public GroupedManagedDepartments(ArrayList<ManagedDepartmentGroup> r100) {
            Intrinsics.checkNotNullParameter(r100, "groups");
            this.groups = r100;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentGroup;", "Ljava/io/Serializable;", "sourceType", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentSourceType;", "visibilityType", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentVisibilityType;", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentItem;", "<init>", "(Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentSourceType;Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentVisibilityType;Ljava/util/ArrayList;)V", "getSourceType", "()Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentSourceType;", "getVisibilityType", "()Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentVisibilityType;", "getItems", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ManagedDepartmentGroup implements Serializable {
        private final ArrayList<ManagedDepartmentItem> items;
        private final ManagedDepartmentSourceType sourceType;
        private final ManagedDepartmentVisibilityType visibilityType;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ManagedDepartmentGroup copy$default(ManagedDepartmentGroup r100, ManagedDepartmentSourceType r101, ManagedDepartmentVisibilityType r102, ArrayList r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.sourceType;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.visibilityType;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.items;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final ManagedDepartmentSourceType component1() {
            return this.sourceType;
        }

        public final ManagedDepartmentVisibilityType component2() {
            return this.visibilityType;
        }

        public final ArrayList<ManagedDepartmentItem> component3() {
            return this.items;
        }

        public final ManagedDepartmentGroup copy(ManagedDepartmentSourceType r100, ManagedDepartmentVisibilityType r101, ArrayList<ManagedDepartmentItem> r102) {
            Intrinsics.checkNotNullParameter(r100, "sourceType");
            Intrinsics.checkNotNullParameter(r101, "visibilityType");
            Intrinsics.checkNotNullParameter(r102, "items");
            return new ManagedDepartmentGroup(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ManagedDepartmentGroup) == true) goto L8;
            return false;
        L8:
            ManagedDepartmentGroup r101 = (ManagedDepartmentGroup) r100;
            if (this.sourceType == r101.sourceType) goto L12;
            return false;
        L12:
            if (this.visibilityType == r101.visibilityType) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.items, r101.items) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.sourceType.hashCode() * 31) + this.visibilityType.hashCode()) * 31) + this.items.hashCode();
        }

        public String toString() {
            return "ManagedDepartmentGroup(sourceType=" + this.sourceType + ", visibilityType=" + this.visibilityType + ", items=" + this.items + ')';
        }

        public final ArrayList<ManagedDepartmentItem> getItems() {
            return this.items;
        }

        public final ManagedDepartmentSourceType getSourceType() {
            return this.sourceType;
        }

        public final ManagedDepartmentVisibilityType getVisibilityType() {
            return this.visibilityType;
        }

        public ManagedDepartmentGroup(ManagedDepartmentSourceType r100, ManagedDepartmentVisibilityType r101, ArrayList<ManagedDepartmentItem> r102) {
            Intrinsics.checkNotNullParameter(r100, "sourceType");
            Intrinsics.checkNotNullParameter(r101, "visibilityType");
            Intrinsics.checkNotNullParameter(r102, "items");
            this.sourceType = r100;
            this.visibilityType = r101;
            this.items = r102;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentInfo;", "Ljava/io/Serializable;", "id", "", "name", "larkId", "code", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getLarkId", "getCode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ManagedDepartmentInfo implements Serializable {
        private final String code;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f438854id;
        private final String larkId;
        private final String name;

        public static /* synthetic */ ManagedDepartmentInfo copy$default(ManagedDepartmentInfo r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.f438854id;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.name;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.larkId;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.code;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.f438854id;
        }

        public final String component2() {
            return this.name;
        }

        public final String component3() {
            return this.larkId;
        }

        public final String component4() {
            return this.code;
        }

        public final ManagedDepartmentInfo copy(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "larkId");
            Intrinsics.checkNotNullParameter(r103, "code");
            return new ManagedDepartmentInfo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ManagedDepartmentInfo) == true) goto L8;
            return false;
        L8:
            ManagedDepartmentInfo r101 = (ManagedDepartmentInfo) r100;
            if (Intrinsics.areEqual(this.f438854id, r101.f438854id) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.larkId, r101.larkId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.code, r101.code) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f438854id.hashCode() * 31) + this.name.hashCode()) * 31) + this.larkId.hashCode()) * 31) + this.code.hashCode();
        }

        public String toString() {
            return "ManagedDepartmentInfo(id=" + this.f438854id + ", name=" + this.name + ", larkId=" + this.larkId + ", code=" + this.code + ')';
        }

        public final String getCode() {
            return this.code;
        }

        public final String getId() {
            return this.f438854id;
        }

        public final String getLarkId() {
            return this.larkId;
        }

        public final String getName() {
            return this.name;
        }

        public ManagedDepartmentInfo(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "larkId");
            Intrinsics.checkNotNullParameter(r103, "code");
            this.f438854id = r100;
            this.name = r101;
            this.larkId = r102;
            this.code = r103;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentItem;", "Ljava/io/Serializable;", "department", "Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentInfo;", "accessible", "", "link", "", "managerId", "<init>", "(Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentInfo;ZLjava/lang/String;Ljava/lang/String;)V", "getDepartment", "()Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentInfo;", "getAccessible", "()Z", "getLink", "()Ljava/lang/String;", "getManagerId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ManagedDepartmentItem implements Serializable {
        private final boolean accessible;
        private final ManagedDepartmentInfo department;
        private final String link;
        private final String managerId;

        public static /* synthetic */ ManagedDepartmentItem copy$default(ManagedDepartmentItem r100, ManagedDepartmentInfo r101, boolean r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.department;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.accessible;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.link;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.managerId;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final ManagedDepartmentInfo component1() {
            return this.department;
        }

        public final boolean component2() {
            return this.accessible;
        }

        public final String component3() {
            return this.link;
        }

        public final String component4() {
            return this.managerId;
        }

        public final ManagedDepartmentItem copy(ManagedDepartmentInfo r100, boolean r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "department");
            Intrinsics.checkNotNullParameter(r102, "link");
            Intrinsics.checkNotNullParameter(r103, "managerId");
            return new ManagedDepartmentItem(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof ManagedDepartmentItem) == true) goto L8;
            return false;
        L8:
            ManagedDepartmentItem r101 = (ManagedDepartmentItem) r100;
            if (Intrinsics.areEqual(this.department, r101.department) == true) goto L12;
            return false;
        L12:
            if (this.accessible == r101.accessible) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.link, r101.link) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.managerId, r101.managerId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = this.department.hashCode() * 31;
            if (this.accessible == false) goto L5;
            int r101 = 1231;
        L7:
            return ((((r100 + r101) * 31) + this.link.hashCode()) * 31) + this.managerId.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public String toString() {
            return "ManagedDepartmentItem(department=" + this.department + ", accessible=" + this.accessible + ", link=" + this.link + ", managerId=" + this.managerId + ')';
        }

        public final boolean getAccessible() {
            return this.accessible;
        }

        public final ManagedDepartmentInfo getDepartment() {
            return this.department;
        }

        public final String getLink() {
            return this.link;
        }

        public final String getManagerId() {
            return this.managerId;
        }

        public ManagedDepartmentItem(ManagedDepartmentInfo r100, boolean r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "department");
            Intrinsics.checkNotNullParameter(r102, "link");
            Intrinsics.checkNotNullParameter(r103, "managerId");
            this.department = r100;
            this.accessible = r101;
            this.link = r102;
            this.managerId = r103;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SELF_MANAGED", "SUBORDINATE_MANAGED", "OTHER_MANAGED", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ManagedDepartmentSourceType extends Enum<ManagedDepartmentSourceType> {
        public static final ManagedDepartmentSourceType OTHER_MANAGED = null;
        public static final ManagedDepartmentSourceType SELF_MANAGED = null;
        public static final ManagedDepartmentSourceType SUBORDINATE_MANAGED = null;
        public static final ManagedDepartmentSourceType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ManagedDepartmentSourceType[] f438855a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f438856b = null;

        public static EnumEntries<ManagedDepartmentSourceType> getEntries() {
            return f438856b;
        }

        static {
            ManagedDepartmentSourceType r100 = new ManagedDepartmentSourceType("UNKNOWN", 0);
            UNKNOWN = r100;
            ManagedDepartmentSourceType r101 = new ManagedDepartmentSourceType("SELF_MANAGED", 1);
            SELF_MANAGED = r101;
            ManagedDepartmentSourceType r102 = new ManagedDepartmentSourceType("SUBORDINATE_MANAGED", 2);
            SUBORDINATE_MANAGED = r102;
            ManagedDepartmentSourceType r103 = new ManagedDepartmentSourceType("OTHER_MANAGED", 3);
            OTHER_MANAGED = r103;
            ManagedDepartmentSourceType[] r104 = {r100, r101, r102, r103};
            f438855a = r104;
            f438856b = EnumEntriesKt.enumEntries(r104);
        }

        public static ManagedDepartmentSourceType[] values() {
            return (ManagedDepartmentSourceType[]) f438855a.clone();
        }

        public static ManagedDepartmentSourceType valueOf(String r100) {
            return (ManagedDepartmentSourceType) a.a(ManagedDepartmentSourceType.class, r100);
        }

        public ManagedDepartmentSourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/DepartmentField$ManagedDepartmentVisibilityType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "EXTERNAL_VISIBLE", "EXTERNAL_HIDDEN", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ManagedDepartmentVisibilityType extends Enum<ManagedDepartmentVisibilityType> {
        public static final ManagedDepartmentVisibilityType EXTERNAL_HIDDEN = null;
        public static final ManagedDepartmentVisibilityType EXTERNAL_VISIBLE = null;
        public static final ManagedDepartmentVisibilityType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ManagedDepartmentVisibilityType[] f438857a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f438858b = null;

        public static EnumEntries<ManagedDepartmentVisibilityType> getEntries() {
            return f438858b;
        }

        static {
            ManagedDepartmentVisibilityType r100 = new ManagedDepartmentVisibilityType("UNKNOWN", 0);
            UNKNOWN = r100;
            ManagedDepartmentVisibilityType r101 = new ManagedDepartmentVisibilityType("EXTERNAL_VISIBLE", 1);
            EXTERNAL_VISIBLE = r101;
            ManagedDepartmentVisibilityType r102 = new ManagedDepartmentVisibilityType("EXTERNAL_HIDDEN", 2);
            EXTERNAL_HIDDEN = r102;
            ManagedDepartmentVisibilityType[] r103 = {r100, r101, r102};
            f438857a = r103;
            f438858b = EnumEntriesKt.enumEntries(r103);
        }

        public static ManagedDepartmentVisibilityType[] values() {
            return (ManagedDepartmentVisibilityType[]) f438857a.clone();
        }

        public static ManagedDepartmentVisibilityType valueOf(String r100) {
            return (ManagedDepartmentVisibilityType) a.a(ManagedDepartmentVisibilityType.class, r100);
        }

        public ManagedDepartmentVisibilityType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public DepartmentField() {
    }

    public final List<DepartmentPath> getDepartmentPathList() {
        return this.departmentPathList;
    }

    public final GroupedManagedDepartments getGroupedManagedDepartments() {
        return this.groupedManagedDepartments;
    }

    public final void setDepartmentPathList(List<DepartmentPath> r100) {
        this.departmentPathList = r100;
    }

    public final void setGroupedManagedDepartments(GroupedManagedDepartments r100) {
        this.groupedManagedDepartments = r100;
    }
}

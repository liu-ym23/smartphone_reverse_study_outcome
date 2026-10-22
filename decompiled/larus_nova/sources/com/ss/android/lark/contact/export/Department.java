package com.ss.android.lark.contact.export;

import android.text.TextUtils;
import com.larksuite.framework.utils.f0;
import java.io.Serializable;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class Department implements Serializable, Comparable<Department>, b<Department> {
    private String chatId;
    private String duty;
    private boolean hasLeaderPermission;
    private boolean hasSubDepartments;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f419448id;
    private boolean isSelected;
    private String leaderId;
    private String mRefParentId;
    private int memberCount;
    public int memberCountByDisplayRule;
    private String name;
    private String namePinyin;
    private String parentId;
    private String section;
    private boolean showMemberCount;
    private int status;

    public int hashCode() {
        String r100 = this.f419448id;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public Department() {
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getDuty() {
        return this.duty;
    }

    public String getId() {
        return this.f419448id;
    }

    public String getLeaderId() {
        return this.leaderId;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getRefParentId() {
        return this.mRefParentId;
    }

    public String getSection() {
        return this.section;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean hasSubDepartments() {
        return this.hasSubDepartments;
    }

    public boolean isHasLeaderPermission() {
        return this.hasLeaderPermission;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowMemberCount() {
        return this.showMemberCount;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Department r100) {
        if (getNamePinyin() != null) goto L5;
    L17:
        return 1;
    L5:
        if (r100.getNamePinyin() == null) goto L17;
        boolean r101 = f0.b(getName());
        boolean r102 = f0.b(r100.getName());
        if (r101 == false) goto L12;
        if (r102 == true) goto L12;
        return -1;
    L12:
        if (r101 == true) goto L16;
        if (r102 == false) goto L16;
        return 1;
    L16:
        return getNamePinyin().compareTo(r100.getNamePinyin());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Department) == true) goto L7;
        return false;
    L7:
        return TextUtils.equals(this.f419448id, ((Department) r100).f419448id);
    }

    public boolean isContentSame(Department r100) {
        String r101 = this.name;
        if (r101 != null) goto L8;
        if (r100.name != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r101, r100.name) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isItemSame(Department r100) {
        String r101 = this.f419448id;
        if (r101 != null) goto L8;
        if (r100.f419448id != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(r101, r100.f419448id) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setDuty(String r100) {
        this.duty = r100;
    }

    public void setHasLeaderPermission(boolean r100) {
        this.hasLeaderPermission = r100;
    }

    public void setHasSubDepartments(boolean r100) {
        this.hasSubDepartments = r100;
    }

    public void setId(String r100) {
        this.f419448id = r100;
    }

    public void setLeaderId(String r100) {
        this.leaderId = r100;
    }

    public void setMemberCount(int r100) {
        this.memberCount = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNamePinyin(String r100) {
        this.namePinyin = r100;
    }

    public void setParentId(String r100) {
        this.parentId = r100;
    }

    public void setRefParentId(String r100) {
        this.mRefParentId = r100;
    }

    public void setSection(String r100) {
        this.section = r100;
    }

    public void setSelected(boolean r100) {
        this.isSelected = r100;
    }

    public void setShowMemberCount(boolean r100) {
        this.showMemberCount = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Department r100) {
        return compareTo2(r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Department) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Department) r100);
    }
}

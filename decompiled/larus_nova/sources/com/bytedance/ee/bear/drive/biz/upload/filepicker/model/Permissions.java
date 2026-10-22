package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public class Permissions implements Serializable, Comparable<Permissions> {
    private static final long serialVersionUID = -3995246732859872806L;
    private GroupPermission mGroup;
    private OthersPermission mOthers;
    private UserPermission mUser;

    public static Permissions createDefaultFilePermissions() {
        return new Permissions(new UserPermission(true, true, false, false), new GroupPermission(true, true, false, false), new OthersPermission(false, false, false, false));
    }

    public static Permissions createDefaultFolderPermissions() {
        return new Permissions(new UserPermission(true, true, true, false), new GroupPermission(true, false, true, false), new OthersPermission(false, false, false, false));
    }

    public int hashCode() {
        GroupPermission r100 = this.mGroup;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        OthersPermission r104 = this.mOthers;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        UserPermission r107 = this.mUser;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toOctalString() {
        if (this.mUser.isSetUID() == false) goto L5;
        int r100 = 4;
    L7:
        if (this.mGroup.isSetGID() == false) goto L10;
        r100 = r100 | 2;
    L10:
        if (this.mOthers.isStickybit() == false) goto L13;
        r100 = r100 | 1;
    L13:
        if (this.mUser.isRead() == false) goto L15;
        int r101 = 4;
    L17:
        if (this.mUser.isWrite() == false) goto L20;
        r101 = r101 | 2;
    L20:
        if (this.mUser.isExecute() == false) goto L23;
        r101 = r101 | 1;
    L23:
        if (this.mGroup.isRead() == false) goto L25;
        int r102 = 4;
    L27:
        if (this.mGroup.isWrite() == false) goto L30;
        r102 = r102 | 2;
    L30:
        if (this.mGroup.isExecute() == false) goto L33;
        r102 = r102 | 1;
    L33:
        if (this.mOthers.isRead() == false) goto L35;
        int r103 = 4;
    L37:
        if (this.mOthers.isWrite() == false) goto L40;
        r103 = r103 | 2;
    L40:
        if (this.mOthers.isExecute() == false) goto L43;
        r103 = r103 | 1;
    L43:
        return String.format(Locale.US, "%d%d%d%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)});
    L35:
        r103 = 0;
        goto L37
    L25:
        r102 = 0;
        goto L27
    L15:
        r101 = 0;
        goto L17
    L5:
        r100 = 0;
        goto L7
    }

    public String toRawString() {
        return this.mUser.toRawString() + this.mGroup.toRawString() + this.mOthers.toRawString();
    }

    public String toString() {
        return "Permissions [user=" + this.mUser + ", group=" + this.mGroup + ", others=" + this.mOthers + "]";
    }

    public GroupPermission getGroup() {
        return this.mGroup;
    }

    public OthersPermission getOthers() {
        return this.mOthers;
    }

    public UserPermission getUser() {
        return this.mUser;
    }

    public static Permissions fromOctalString(String r110) throws ParseException {
        int r100 = r110.length();
        boolean r101 = false;
        if (r100 == 3) goto L9;
        if (r100 == 4) goto L9;
        throw new ParseException("Invalid permissions string length: !=3 or != 4", 0);
    L9:
        if (r100 != 4) goto L11;
        char r102 = r110.charAt(0);
        int r103 = 1;
    L12:
        char r104 = r110.charAt(r103);
        int r105 = r103 + 1;
        char r106 = r110.charAt(r105);
        char r111 = r110.charAt(r105 + 1);
        if ((r104 & 4) != 4) goto L15;
        boolean r107 = true;
    L17:
        if ((r104 & 2) != 2) goto L19;
        boolean r108 = true;
    L21:
        if ((r104 & 1) != 1) goto L23;
        boolean r109 = true;
    L25:
        if ((r102 & 1) != 1) goto L27;
        boolean r112 = true;
    L28:
        UserPermission r113 = new UserPermission(r107, r108, r109, r112);
        if ((r106 & 4) != 4) goto L31;
        boolean r114 = true;
    L33:
        if ((r106 & 2) != 2) goto L35;
        boolean r115 = true;
    L37:
        if ((r106 & 1) != 1) goto L39;
        boolean r116 = true;
    L41:
        if ((r102 & 2) != 2) goto L43;
        boolean r117 = true;
    L44:
        GroupPermission r118 = new GroupPermission(r114, r115, r116, r117);
        if ((r111 & 4) != 4) goto L47;
        boolean r119 = true;
    L49:
        if ((r111 & 2) != 2) goto L51;
        boolean r120 = true;
    L53:
        if ((r111 & 1) != 1) goto L55;
        boolean r121 = true;
    L57:
        if ((r102 & 4) != 4) goto L60;
        r101 = true;
    L60:
        return new Permissions(r113, r118, new OthersPermission(r119, r120, r121, r101));
    L55:
        r121 = false;
        goto L57
    L51:
        r120 = false;
        goto L53
    L47:
        r119 = false;
        goto L49
    L43:
        r117 = false;
        goto L44
    L39:
        r116 = false;
        goto L41
    L35:
        r115 = false;
        goto L37
    L31:
        r114 = false;
        goto L33
    L27:
        r112 = false;
        goto L28
    L23:
        r109 = false;
        goto L25
    L19:
        r108 = false;
        goto L21
    L15:
        r107 = false;
        goto L17
    L11:
        r102 = 0;
        r103 = 0;
        goto L12
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Permissions r100) {
        return toRawString().compareTo(r100.toRawString());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        Permissions r101 = (Permissions) r100;
        GroupPermission r102 = this.mGroup;
        if (r102 != null) goto L17;
        if (r101.mGroup == null) goto L19;
        return false;
    L19:
        OthersPermission r103 = this.mOthers;
        if (r103 != null) goto L25;
        if (r101.mOthers == null) goto L27;
        return false;
    L27:
        UserPermission r104 = this.mUser;
        if (r104 != null) goto L33;
        if (r101.mUser == null) goto L35;
        return false;
    L35:
        return true;
    L33:
        if (r104.equals(r101.mUser) == true) goto L35;
        return false;
    L25:
        if (r103.equals(r101.mOthers) == true) goto L27;
        return false;
    L17:
        if (r102.equals(r101.mGroup) == true) goto L19;
        return false;
    }

    public void setGroup(GroupPermission r100) {
        this.mGroup = r100;
    }

    public void setOthers(OthersPermission r100) {
        this.mOthers = r100;
    }

    public void setUser(UserPermission r100) {
        this.mUser = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Permissions r100) {
        return compareTo2(r100);
    }

    public Permissions(UserPermission r100, GroupPermission r101, OthersPermission r102) {
        this.mUser = r100;
        this.mGroup = r101;
        this.mOthers = r102;
    }
}

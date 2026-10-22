package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        GroupPermission r0 = this.mGroup;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        OthersPermission r4 = this.mOthers;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        UserPermission r7 = this.mUser;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toOctalString() {
        if (this.mUser.isSetUID() == false) goto L5;
        int r0 = 4;
    L7:
        if (this.mGroup.isSetGID() == false) goto L10;
        r0 = r0 | 2;
    L10:
        if (this.mOthers.isStickybit() == false) goto L13;
        r0 = r0 | 1;
    L13:
        if (this.mUser.isRead() == false) goto L15;
        int r3 = 4;
    L17:
        if (this.mUser.isWrite() == false) goto L20;
        r3 = r3 | 2;
    L20:
        if (this.mUser.isExecute() == false) goto L23;
        r3 = r3 | 1;
    L23:
        if (this.mGroup.isRead() == false) goto L25;
        int r4 = 4;
    L27:
        if (this.mGroup.isWrite() == false) goto L30;
        r4 = r4 | 2;
    L30:
        if (this.mGroup.isExecute() == false) goto L33;
        r4 = r4 | 1;
    L33:
        if (this.mOthers.isRead() == false) goto L35;
        int r5 = 4;
    L37:
        if (this.mOthers.isWrite() == false) goto L40;
        r5 = r5 | 2;
    L40:
        if (this.mOthers.isExecute() == false) goto L43;
        r5 = r5 | 1;
    L43:
        return String.format(Locale.US, "%d%d%d%d", new Object[]{Integer.valueOf(r0), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(r5)});
    L35:
        r5 = 0;
        goto L37
    L25:
        r4 = 0;
        goto L27
    L15:
        r3 = 0;
        goto L17
    L5:
        r0 = 0;
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

    public static Permissions fromOctalString(String r11) throws ParseException {
        int r0 = r11.length();
        boolean r3 = false;
        if (r0 == 3) goto L9;
        if (r0 == 4) goto L9;
        throw new ParseException("Invalid permissions string length: !=3 or != 4", 0);
    L9:
        if (r0 != 4) goto L11;
        char r1 = r11.charAt(0);
        int r4 = 1;
    L12:
        char r5 = r11.charAt(r4);
        int r6 = r4 + 1;
        char r7 = r11.charAt(r6);
        char r12 = r11.charAt(r6 + 1);
        if ((r5 & 4) != 4) goto L15;
        boolean r8 = true;
    L17:
        if ((r5 & 2) != 2) goto L19;
        boolean r9 = true;
    L21:
        if ((r5 & 1) != 1) goto L23;
        boolean r10 = true;
    L25:
        if ((r1 & 1) != 1) goto L27;
        boolean r13 = true;
    L28:
        UserPermission r14 = new UserPermission(r8, r9, r10, r13);
        if ((r7 & 4) != 4) goto L31;
        boolean r16 = true;
    L33:
        if ((r7 & 2) != 2) goto L35;
        boolean r17 = true;
    L37:
        if ((r7 & 1) != 1) goto L39;
        boolean r18 = true;
    L41:
        if ((r1 & 2) != 2) goto L43;
        boolean r19 = true;
    L44:
        GroupPermission r20 = new GroupPermission(r16, r17, r18, r19);
        if ((r12 & 4) != 4) goto L47;
        boolean r21 = true;
    L49:
        if ((r12 & 2) != 2) goto L51;
        boolean r22 = true;
    L53:
        if ((r12 & 1) != 1) goto L55;
        boolean r110 = true;
    L57:
        if ((r1 & 4) != 4) goto L60;
        r3 = true;
    L60:
        return new Permissions(r14, r20, new OthersPermission(r21, r22, r110, r3));
    L55:
        r110 = false;
        goto L57
    L51:
        r22 = false;
        goto L53
    L47:
        r21 = false;
        goto L49
    L43:
        r19 = false;
        goto L44
    L39:
        r18 = false;
        goto L41
    L35:
        r17 = false;
        goto L37
    L31:
        r16 = false;
        goto L33
    L27:
        r13 = false;
        goto L28
    L23:
        r10 = false;
        goto L25
    L19:
        r9 = false;
        goto L21
    L15:
        r8 = false;
        goto L17
    L11:
        r1 = 0;
        r4 = 0;
        goto L12
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Permissions r2) {
        return toRawString().compareTo(r2.toRawString());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        Permissions r6 = (Permissions) r5;
        GroupPermission r2 = this.mGroup;
        if (r2 != null) goto L17;
        if (r6.mGroup == null) goto L19;
        return false;
    L19:
        OthersPermission r3 = this.mOthers;
        if (r3 != null) goto L25;
        if (r6.mOthers == null) goto L27;
        return false;
    L27:
        UserPermission r4 = this.mUser;
        if (r4 != null) goto L33;
        if (r6.mUser == null) goto L35;
        return false;
    L35:
        return true;
    L33:
        if (r4.equals(r6.mUser) == true) goto L35;
        return false;
    L25:
        if (r3.equals(r6.mOthers) == true) goto L27;
        return false;
    L17:
        if (r2.equals(r6.mGroup) == true) goto L19;
        return false;
    }

    public void setGroup(GroupPermission r1) {
        this.mGroup = r1;
    }

    public void setOthers(OthersPermission r1) {
        this.mOthers = r1;
    }

    public void setUser(UserPermission r1) {
        this.mUser = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Permissions r1) {
        return compareTo2(r1);
    }

    public Permissions(UserPermission r1, GroupPermission r2, OthersPermission r3) {
        this.mUser = r1;
        this.mGroup = r2;
        this.mOthers = r3;
    }
}

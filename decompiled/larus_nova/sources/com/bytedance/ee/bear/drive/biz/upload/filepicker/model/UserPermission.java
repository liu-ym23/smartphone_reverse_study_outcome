package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: classes16.dex */
public class UserPermission extends Permission {
    public static final char SETUID = 'S';
    public static final char SETUID_E = 's';
    private static final long serialVersionUID = -900037436267443837L;
    private boolean mSetuid;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public String getRawString() {
        StringBuilder r100 = new StringBuilder();
        char r101 = '-';
        if (isRead() == false) goto L5;
        char r102 = Permission.READ;
    L6:
        r100.append(r102);
        if (isWrite() == false) goto L9;
        char r103 = Permission.WRITE;
    L10:
        r100.append(r103);
        if (isSetUID() == false) goto L18;
        if (isExecute() == false) goto L15;
        char r104 = 's';
    L16:
        r100.append(r104);
    L22:
        return r100.toString();
    L15:
        r104 = 'S';
        goto L16
    L18:
        if (isExecute() == false) goto L20;
        r101 = Permission.EXECUTE;
    L20:
        r100.append(r101);
        goto L22
    L9:
        r103 = '-';
        goto L10
    L5:
        r102 = '-';
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public String toString() {
        return "UserPermission [setuid=" + this.mSetuid + ", permission=" + super.toString() + "]";
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        if (this.mSetuid == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public boolean isSetUID() {
        return this.mSetuid;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (super.equals(r100) == true) goto L9;
        return false;
    L9:
        if (getClass() == r100.getClass()) goto L12;
        return false;
    L12:
        if (this.mSetuid == ((UserPermission) r100).mSetuid) goto L14;
        return false;
    L14:
        return true;
    }

    public void setSetUID(boolean r100) {
        this.mSetuid = r100;
        invalidateRawString();
    }

    public UserPermission(boolean r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
        this.mSetuid = false;
    }

    public UserPermission(boolean r100, boolean r101, boolean r102, boolean r103) {
        super(r100, r101, r102);
        this.mSetuid = r103;
    }
}

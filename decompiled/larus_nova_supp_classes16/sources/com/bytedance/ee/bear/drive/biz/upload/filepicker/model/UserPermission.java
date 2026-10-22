package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class UserPermission extends Permission {
    public static final char SETUID = 'S';
    public static final char SETUID_E = 's';
    private static final long serialVersionUID = -900037436267443837L;
    private boolean mSetuid;

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public String getRawString() {
        StringBuilder r0 = new StringBuilder();
        char r2 = '-';
        if (isRead() == false) goto L5;
        char r1 = Permission.READ;
    L6:
        r0.append(r1);
        if (isWrite() == false) goto L9;
        char r3 = Permission.WRITE;
    L10:
        r0.append(r3);
        if (isSetUID() == false) goto L18;
        if (isExecute() == false) goto L15;
        char r4 = 's';
    L16:
        r0.append(r4);
    L22:
        return r0.toString();
    L15:
        r4 = 'S';
        goto L16
    L18:
        if (isExecute() == false) goto L20;
        r2 = Permission.EXECUTE;
    L20:
        r0.append(r2);
        goto L22
    L9:
        r3 = '-';
        goto L10
    L5:
        r1 = '-';
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public String toString() {
        return "UserPermission [setuid=" + this.mSetuid + ", permission=" + super.toString() + "]";
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        if (this.mSetuid == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public boolean isSetUID() {
        return this.mSetuid;
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (super.equals(r5) == true) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L12;
        return false;
    L12:
        if (this.mSetuid == ((UserPermission) r5).mSetuid) goto L14;
        return false;
    L14:
        return true;
    }

    public void setSetUID(boolean r1) {
        this.mSetuid = r1;
        invalidateRawString();
    }

    public UserPermission(boolean r1, boolean r2, boolean r3) {
        super(r1, r2, r3);
        this.mSetuid = false;
    }

    public UserPermission(boolean r1, boolean r2, boolean r3, boolean r4) {
        super(r1, r2, r3);
        this.mSetuid = r4;
    }
}

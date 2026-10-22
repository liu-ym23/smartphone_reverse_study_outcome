package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OthersPermission extends Permission {
    public static final char STICKY = 'T';
    public static final char STICKY_E = 't';
    private static final long serialVersionUID = -8993601349099495256L;
    private boolean mStickybit;

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
        if (isStickybit() == false) goto L18;
        if (isExecute() == false) goto L15;
        char r4 = STICKY_E;
    L16:
        r0.append(r4);
    L22:
        return r0.toString();
    L15:
        r4 = STICKY;
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
        return "OthersPermission [stickybit=" + this.mStickybit + ", permission=" + super.toString() + "]";
    }

    @Override // com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        if (this.mStickybit == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public boolean isStickybit() {
        return this.mStickybit;
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
        if (this.mStickybit == ((OthersPermission) r5).mStickybit) goto L14;
        return false;
    L14:
        return true;
    }

    public void setStickybit(boolean r1) {
        this.mStickybit = r1;
        invalidateRawString();
    }

    public OthersPermission(boolean r1, boolean r2, boolean r3) {
        super(r1, r2, r3);
        this.mStickybit = false;
    }

    public OthersPermission(boolean r1, boolean r2, boolean r3, boolean r4) {
        super(r1, r2, r3);
        this.mStickybit = r4;
    }
}

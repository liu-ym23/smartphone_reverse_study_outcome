package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class Permission implements Serializable {
    public static final char EXECUTE = 'x';
    public static final char READ = 'r';
    public static final char UNASIGNED = '-';
    public static final char WRITE = 'w';
    private static final long serialVersionUID = 5775987092282897912L;
    private boolean mExecute;
    private String mRawString;
    private boolean mRead;
    private boolean mWrite;

    public abstract String getRawString();

    public void invalidateRawString() {
        this.mRawString = null;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.mExecute == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = (r0 + 31) * 31;
        if (this.mRead == false) goto L9;
        int r4 = 1231;
    L10:
        int r3 = (r2 + r4) * 31;
        if (this.mWrite == true) goto L15;
        r1 = 1237;
    L15:
        return r3 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toRawString() {
        if (this.mRawString != null) goto L6;
        this.mRawString = getRawString();
    L6:
        return this.mRawString;
    }

    public String toString() {
        return "Permission [read=" + this.mRead + ", write=" + this.mWrite + ", execute=" + this.mExecute + "]";
    }

    public boolean isExecute() {
        return this.mExecute;
    }

    public boolean isRead() {
        return this.mRead;
    }

    public boolean isWrite() {
        return this.mWrite;
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
        Permission r6 = (Permission) r5;
        if (this.mExecute == r6.mExecute) goto L15;
        return false;
    L15:
        if (this.mRead == r6.mRead) goto L18;
        return false;
    L18:
        if (this.mWrite == r6.mWrite) goto L20;
        return false;
    L20:
        return true;
    }

    public void setExecute(boolean r1) {
        this.mExecute = r1;
        invalidateRawString();
    }

    public void setRead(boolean r1) {
        this.mRead = r1;
        invalidateRawString();
    }

    public void setWrite(boolean r1) {
        this.mWrite = r1;
        invalidateRawString();
    }

    public Permission(boolean r1, boolean r2, boolean r3) {
        this.mRead = r1;
        this.mWrite = r2;
        this.mExecute = r3;
    }
}

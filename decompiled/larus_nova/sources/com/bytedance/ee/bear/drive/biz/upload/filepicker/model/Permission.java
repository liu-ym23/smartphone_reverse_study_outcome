package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
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
        int r100 = 1231;
        if (this.mExecute == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r101 + 31) * 31;
        if (this.mRead == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.mWrite == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
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
        Permission r101 = (Permission) r100;
        if (this.mExecute == r101.mExecute) goto L15;
        return false;
    L15:
        if (this.mRead == r101.mRead) goto L18;
        return false;
    L18:
        if (this.mWrite == r101.mWrite) goto L20;
        return false;
    L20:
        return true;
    }

    public void setExecute(boolean r100) {
        this.mExecute = r100;
        invalidateRawString();
    }

    public void setRead(boolean r100) {
        this.mRead = r100;
        invalidateRawString();
    }

    public void setWrite(boolean r100) {
        this.mWrite = r100;
        invalidateRawString();
    }

    public Permission(boolean r100, boolean r101, boolean r102) {
        this.mRead = r100;
        this.mWrite = r101;
        this.mExecute = r102;
    }
}

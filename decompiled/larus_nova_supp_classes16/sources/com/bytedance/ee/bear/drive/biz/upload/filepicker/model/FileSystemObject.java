package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.net.Uri;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class FileSystemObject implements Serializable, Comparable<FileSystemObject> {
    private static final long serialVersionUID = -571144166609728391L;
    private Group mGroup;
    private boolean mIsRemote;
    private boolean mIsSecure;
    private Date mLastAccessedTime;
    private Date mLastChangedTime;
    private Date mLastModifiedTime;
    private String mName;
    private String mParent;
    private Permissions mPermissions;
    private long mSize;

    public abstract char getUnixIdentifier();

    public Uri getFileUri() {
        return new Uri.Builder().scheme("file").path(getFullPath()).build();
    }

    public String getFullPath() {
        Map<String, String> r0 = w65.a.a;
        boolean r1 = false;
        boolean r2 = true;
        if (getName() != null) goto L6;
    L7:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        return "/";
    L12:
        if (getParent() != null) goto L15;
    L18:
        if (r2 == false) goto L26;
        if (this.mParent != null) goto L24;
        return "/" + this.mName;
    L24:
        return this.mParent + this.mName;
    L26:
        return this.mParent + File.separator + this.mName;
    L15:
        if (getParent().compareTo("/") != 0) goto L17;
        r1 = true;
    L17:
        r2 = r1;
        goto L18
    L6:
        if (getName().compareTo("/") == 0) goto L7;
        r3 = false;
        goto L9
    }

    public int hashCode() {
        String r0 = this.mName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r2 + 31) * 31;
        String r4 = this.mParent;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isHidden() {
        return this.mName.startsWith(".");
    }

    public String toRawPermissionString() {
        return Character.toString(getUnixIdentifier()) + getPermissions().toRawString();
    }

    public String toString() {
        return "FileSystemObject [ mName=" + this.mName + ", mParent=" + this.mParent + ", mGroup=" + this.mGroup + ", mPermissions=" + this.mPermissions + ", mSize=" + this.mSize + ", mLastAccessedTime=" + this.mLastAccessedTime + ", mLastModifiedTime=" + this.mLastModifiedTime + ", mLastChangedTime=" + this.mLastChangedTime + ", mIsSecure=" + this.mIsSecure + ", mIsRemote=" + this.mIsRemote + "]";
    }

    public FileSystemObject() {
    }

    public Group getGroup() {
        return this.mGroup;
    }

    public Date getLastAccessedTime() {
        return this.mLastAccessedTime;
    }

    public Date getLastChangedTime() {
        return this.mLastChangedTime;
    }

    public Date getLastModifiedTime() {
        return this.mLastModifiedTime;
    }

    public String getName() {
        return this.mName;
    }

    public String getParent() {
        return this.mParent;
    }

    public Permissions getPermissions() {
        return this.mPermissions;
    }

    public long getSize() {
        return this.mSize;
    }

    public boolean isRemote() {
        return this.mIsRemote;
    }

    public boolean isSecure() {
        return this.mIsSecure;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FileSystemObject r2) {
        return getName().compareTo(r2.getName());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
        return false;
    L8:
        FileSystemObject r6 = (FileSystemObject) r5;
        String r2 = this.mName;
        if (r2 != null) goto L14;
        if (r6.mName == null) goto L16;
        return false;
    L16:
        String r3 = this.mParent;
        if (r3 != null) goto L22;
        if (r6.mParent == null) goto L24;
        return false;
    L24:
        return true;
    L22:
        if (r3.equals(r6.mParent) == true) goto L24;
        return false;
    L14:
        if (r2.equals(r6.mName) == true) goto L16;
        return false;
    }

    public void setGroup(Group r1) {
        this.mGroup = r1;
    }

    public void setLastAccessedTime(Date r1) {
        this.mLastAccessedTime = r1;
    }

    public void setLastChangedTime(Date r1) {
        this.mLastChangedTime = r1;
    }

    public void setLastModifiedTime(Date r1) {
        this.mLastModifiedTime = r1;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public void setParent(String r1) {
        this.mParent = r1;
    }

    public void setPermissions(Permissions r1) {
        this.mPermissions = r1;
    }

    public void setRemote(boolean r1) {
        this.mIsRemote = r1;
    }

    public void setSecure(boolean r1) {
        this.mIsSecure = r1;
    }

    public void setSize(long r1) {
        this.mSize = r1;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FileSystemObject r1) {
        return compareTo2(r1);
    }

    public FileSystemObject(String r1, String r2, Permissions r3, long r4, a r6) {
        this.mName = r1;
        this.mParent = r2;
        this.mPermissions = r3;
        this.mSize = r4;
        r6.getClass();
        this.mLastAccessedTime = null;
        this.mLastModifiedTime = null;
        this.mLastChangedTime = null;
        this.mIsSecure = false;
        this.mIsRemote = false;
    }
}

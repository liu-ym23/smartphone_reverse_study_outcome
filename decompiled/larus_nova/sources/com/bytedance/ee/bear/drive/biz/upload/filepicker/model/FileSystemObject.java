package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
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
        Map<String, String> r100 = w65.a.f558425a;
        boolean r101 = false;
        boolean r102 = true;
        if (getName() != null) goto L6;
    L7:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return HTTP.URL_DEFAULT;
    L12:
        if (getParent() != null) goto L15;
    L18:
        if (r102 == false) goto L26;
        if (this.mParent != null) goto L24;
        return HTTP.URL_DEFAULT + this.mName;
    L24:
        return this.mParent + this.mName;
    L26:
        return this.mParent + File.separator + this.mName;
    L15:
        if (getParent().compareTo(HTTP.URL_DEFAULT) != 0) goto L17;
        r101 = true;
    L17:
        r102 = r101;
        goto L18
    L6:
        if (getName().compareTo(HTTP.URL_DEFAULT) == 0) goto L7;
        r103 = false;
        goto L9
    }

    public int hashCode() {
        String r100 = this.mName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        String r104 = this.mParent;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
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
    public int compareTo2(FileSystemObject r100) {
        return getName().compareTo(r100.getName());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
        return false;
    L8:
        FileSystemObject r101 = (FileSystemObject) r100;
        String r102 = this.mName;
        if (r102 != null) goto L14;
        if (r101.mName == null) goto L16;
        return false;
    L16:
        String r103 = this.mParent;
        if (r103 != null) goto L22;
        if (r101.mParent == null) goto L24;
        return false;
    L24:
        return true;
    L22:
        if (r103.equals(r101.mParent) == true) goto L24;
        return false;
    L14:
        if (r102.equals(r101.mName) == true) goto L16;
        return false;
    }

    public void setGroup(Group r100) {
        this.mGroup = r100;
    }

    public void setLastAccessedTime(Date r100) {
        this.mLastAccessedTime = r100;
    }

    public void setLastChangedTime(Date r100) {
        this.mLastChangedTime = r100;
    }

    public void setLastModifiedTime(Date r100) {
        this.mLastModifiedTime = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setParent(String r100) {
        this.mParent = r100;
    }

    public void setPermissions(Permissions r100) {
        this.mPermissions = r100;
    }

    public void setRemote(boolean r100) {
        this.mIsRemote = r100;
    }

    public void setSecure(boolean r100) {
        this.mIsSecure = r100;
    }

    public void setSize(long r100) {
        this.mSize = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FileSystemObject r100) {
        return compareTo2(r100);
    }

    public FileSystemObject(String r100, String r101, Permissions r102, long r103, a r104) {
        this.mName = r100;
        this.mParent = r101;
        this.mPermissions = r102;
        this.mSize = r103;
        r104.getClass();
        this.mLastAccessedTime = null;
        this.mLastModifiedTime = null;
        this.mLastChangedTime = null;
        this.mIsSecure = false;
        this.mIsRemote = false;
    }
}

package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class AID implements Serializable, Comparable<AID> {
    private static final long serialVersionUID = 5603819450513225452L;
    private final int mId;
    private final String mName;

    public int hashCode() {
        int r100 = (this.mId + 31) * 31;
        String r101 = this.mName;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AID [id=" + this.mId + ", name=" + this.mName + "]";
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AID r100) {
        int r101 = this.mId;
        int r102 = r100.mId;
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 <= r102) goto L8;
        return 1;
    L8:
        if (r101 == (-1)) goto L10;
        return 0;
    L10:
        return this.mName.compareTo(r100.mName);
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
        AID r101 = (AID) r100;
        if (this.mId == r101.mId) goto L14;
        return false;
    L14:
        String r102 = this.mName;
        if (r102 != null) goto L20;
        if (r101.mName == null) goto L22;
        return false;
    L22:
        return true;
    L20:
        if (r102.equals(r101.mName) == true) goto L22;
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AID r100) {
        return compareTo2(r100);
    }

    public AID(int r100, String r101) {
        this.mId = r100;
        this.mName = r101;
    }
}

package com.bytedance.ee.bear.drive.biz.upload.filepicker.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AID implements Serializable, Comparable<AID> {
    private static final long serialVersionUID = 5603819450513225452L;
    private final int mId;
    private final String mName;

    public int hashCode() {
        int r0 = (this.mId + 31) * 31;
        String r1 = this.mName;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
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
    public int compareTo2(AID r4) {
        int r0 = this.mId;
        int r1 = r4.mId;
        if (r0 >= r1) goto L5;
        return -1;
    L5:
        if (r0 <= r1) goto L8;
        return 1;
    L8:
        if (r0 == (-1)) goto L10;
        return 0;
    L10:
        return this.mName.compareTo(r4.mName);
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
        AID r6 = (AID) r5;
        if (this.mId == r6.mId) goto L14;
        return false;
    L14:
        String r2 = this.mName;
        if (r2 != null) goto L20;
        if (r6.mName == null) goto L22;
        return false;
    L22:
        return true;
    L20:
        if (r2.equals(r6.mName) == true) goto L22;
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AID r1) {
        return compareTo2(r1);
    }

    public AID(int r1, String r2) {
        this.mId = r1;
        this.mName = r2;
    }
}

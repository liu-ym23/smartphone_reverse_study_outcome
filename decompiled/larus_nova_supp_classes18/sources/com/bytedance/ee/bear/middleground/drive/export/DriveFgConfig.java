package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DriveFgConfig implements NonProguard {
    public boolean mCoverInDoc;
    public int mCoverWidth;

    public String toString() {
        return "DriveFgConfig{mCoverInDoc=" + this.mCoverInDoc + ", mCoverWidth=" + this.mCoverWidth + '}';
    }

    public DriveFgConfig(boolean r1, int r2) {
        this.mCoverInDoc = r1;
        this.mCoverWidth = r2;
    }
}

package com.bytedance.ee.bear.middleground.drive.export;

import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class DriveFgConfig implements NonProguard {
    public boolean mCoverInDoc;
    public int mCoverWidth;

    public String toString() {
        return "DriveFgConfig{mCoverInDoc=" + this.mCoverInDoc + ", mCoverWidth=" + this.mCoverWidth + '}';
    }

    public DriveFgConfig(boolean r100, int r101) {
        this.mCoverInDoc = r100;
        this.mCoverWidth = r101;
    }
}

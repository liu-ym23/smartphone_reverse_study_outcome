package com.ss.ttvideoengine.preloader;

import com.ss.ttvideoengine.Resolution;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public class TTAVPreloaderItem {
    public String[] mBackUpUrls;
    public long mCurFileSize;
    public int mCurUrlIndex;
    public String mFileHash;
    public String mFileKey;
    public String mFilePath;
    public long mFileSize;
    public int mHeight;
    public int mResolution;
    public long mSupportResMask;
    public String mUrl;
    public long mUrlTime;
    public String mVideoID;
    public int mWidth;

    public Resolution[] supportResolutions() {
        ArrayList r100 = new ArrayList();
        if ((this.mSupportResMask & 2) != 2) goto L6;
        r100.add(Resolution.Standard);
    L6:
        if ((this.mSupportResMask & 4) != 4) goto L9;
        r100.add(Resolution.High);
    L9:
        if ((this.mSupportResMask & 8) != 8) goto L12;
        r100.add(Resolution.SuperHigh);
    L12:
        if ((this.mSupportResMask & 16) != 16) goto L15;
        r100.add(Resolution.ExtremelyHigh);
    L15:
        if ((this.mSupportResMask & 32) != 32) goto L18;
        r100.add(Resolution.FourK);
    L18:
        return (Resolution[]) r100.toArray(new Resolution[r100.size()]);
    }

    public TTAVPreloaderItem(String r100, int r101, long r102, String r103, String r104, String r110) {
        this.mSupportResMask = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mCurUrlIndex = 0;
        this.mCurFileSize = 0;
        this.mFileSize = 0;
        this.mUrl = r104;
        this.mUrlTime = r102;
        this.mFileKey = r103;
        this.mFilePath = r110;
        this.mVideoID = r100;
        this.mResolution = r101;
        this.mBackUpUrls = null;
    }

    public TTAVPreloaderItem(String r100, int r101, long r102, String r103, String r104, String r105, long r110) {
        this.mWidth = 0;
        this.mHeight = 0;
        this.mCurUrlIndex = 0;
        this.mCurFileSize = 0;
        this.mFileSize = 0;
        this.mUrl = r104;
        this.mUrlTime = r102;
        this.mFileKey = r103;
        this.mFilePath = r105;
        this.mVideoID = r100;
        this.mResolution = r101;
        this.mSupportResMask = r110;
        this.mBackUpUrls = null;
    }

    public TTAVPreloaderItem(String r100, int r101, long r102, String r103, String r104, String r105, long r110, int r111, int r112) {
        this.mCurUrlIndex = 0;
        this.mCurFileSize = 0;
        this.mFileSize = 0;
        this.mUrl = r104;
        this.mUrlTime = r102;
        this.mFileKey = r103;
        this.mFilePath = r105;
        this.mVideoID = r100;
        this.mResolution = r101;
        this.mSupportResMask = r110;
        this.mWidth = r111;
        this.mHeight = r112;
        this.mBackUpUrls = null;
    }

    public TTAVPreloaderItem(String r100, int r101, long r102, String r103, String r104, String r105, long r110, int r111, int r112, String r113) {
        this.mCurUrlIndex = 0;
        this.mCurFileSize = 0;
        this.mFileSize = 0;
        this.mUrl = r104;
        this.mUrlTime = r102;
        this.mFileKey = r103;
        this.mFilePath = r105;
        this.mVideoID = r100;
        this.mResolution = r101;
        this.mSupportResMask = r110;
        this.mWidth = r111;
        this.mHeight = r112;
        this.mFileHash = r113;
        this.mBackUpUrls = null;
    }

    public TTAVPreloaderItem(String r100, int r101, long r102, String r103, String r104, String r110, long r111, int r112, int r113, String r114, long r115, long r116) {
        this.mCurUrlIndex = 0;
        this.mUrl = r104;
        this.mUrlTime = r102;
        this.mFileKey = r103;
        this.mFilePath = r110;
        this.mVideoID = r100;
        this.mResolution = r101;
        this.mSupportResMask = r111;
        this.mWidth = r112;
        this.mHeight = r113;
        this.mFileHash = r114;
        this.mBackUpUrls = null;
        this.mCurFileSize = r115;
        this.mFileSize = r116;
    }
}

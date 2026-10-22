package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public class VEMusicSRTEffectParam {
    private boolean mAddMask;
    private String mEffectResourcePath;
    private int mFontFaceIndex;
    private String mFontTTFPath;
    public a mGetMusicProgressInvoker;
    private int mMaskColor;
    private boolean mParamUpdated;
    private c[] mSrtData;

    public interface a {
        float a();
    }

    public interface b extends a {
        VEMusicBitmapParam b();
    }

    public static class c {
    }

    private boolean getParamUpdated() {
        if (this.mParamUpdated == false) goto L6;
        this.mParamUpdated = false;
        return true;
    L6:
        return false;
    }

    public float getMusicProgress() {
        a r100 = this.mGetMusicProgressInvoker;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.a();
    }

    public int[][] getSrtData() {
        int[][] r100 = new int[this.mSrtData.length][];
        int r101 = 0;
    L3:
        c[] r102 = this.mSrtData;
        if (r101 >= r102.length) goto L6;
        c r103 = r102[r101];
        r100[r101] = convertDataToUnicode32(null);
        r101 = r101 + 1;
        goto L3
    L6:
        return r100;
    }

    private VEMusicSRTEffectParam() {
        this.mParamUpdated = false;
        this.mAddMask = false;
        this.mMaskColor = 1291845632;
    }

    public boolean getAddMask() {
        return this.mAddMask;
    }

    public String getEffectResPath() {
        return this.mEffectResourcePath;
    }

    public int getFontFaceIndex() {
        return this.mFontFaceIndex;
    }

    public String getFontTTFPath() {
        return this.mFontTTFPath;
    }

    public int getMaskColor() {
        return this.mMaskColor;
    }

    private int[] convertDataToUnicode32(c r100) {
        throw null;
    }

    public void setAddMask(boolean r100) {
        this.mAddMask = r100;
        this.mParamUpdated = true;
    }

    public void setMaskColor(int r100) {
        this.mMaskColor = r100;
        this.mParamUpdated = true;
    }

    public VEMusicSRTEffectParam(c[] r100, String r101, String r102, int r103, a r104) {
        this.mAddMask = false;
        this.mMaskColor = 1291845632;
        this.mSrtData = r100;
        this.mFontTTFPath = r102;
        this.mEffectResourcePath = r101;
        this.mFontFaceIndex = r103;
        this.mGetMusicProgressInvoker = r104;
        this.mParamUpdated = true;
    }

    public void updateEffectResPath(c[] r100, String r101, String r102, int r103, a r104) {
        this.mSrtData = r100;
        this.mFontTTFPath = r102;
        this.mEffectResourcePath = r101;
        this.mFontFaceIndex = r103;
        this.mGetMusicProgressInvoker = r104;
        this.mParamUpdated = true;
    }

    public VEMusicBitmapParam generateBitmap(String r100, int r101, int r102, int r103, float r104, int r105, int r106, int r107) {
        a r108 = this.mGetMusicProgressInvoker;
        if (r108 != null) goto L5;
        return null;
    L5:
        if ((r108 instanceof b) == true) goto L7;
        return null;
    L7:
        return ((b) r108).b();
    }

    public VEMusicBitmapParam generateBitmapUnicode(int[] r110, int r111, int r112, int r113, float r114, int r115, int r116, int r117) {
        if (r110 != null) goto L5;
        return null;
    L5:
        if (r110.length > 0) goto L8;
        return null;
    L8:
        return generateBitmap(new String(r110, 0, r110.length), r111, r112, r113, r114, r115, r116, r117);
    }
}

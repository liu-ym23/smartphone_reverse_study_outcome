package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes23.dex */
public class ImmutableQualityInfo implements QualityInfo {
    public static final QualityInfo FULL_QUALITY = null;
    boolean mIsOfFullQuality;
    boolean mIsOfGoodEnoughQuality;
    int mQuality;

    public int hashCode() {
        int r100 = this.mQuality;
        int r101 = 0;
        if (this.mIsOfGoodEnoughQuality == false) goto L5;
        int r102 = 4194304;
    L6:
        int r103 = r100 ^ r102;
        if (this.mIsOfFullQuality == false) goto L10;
        r101 = 8388608;
    L10:
        return r103 ^ r101;
    L5:
        r102 = 0;
        goto L6
    }

    static {
        FULL_QUALITY = of(Integer.MAX_VALUE, true, true);
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public int getQuality() {
        return this.mQuality;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfFullQuality() {
        return this.mIsOfFullQuality;
    }

    @Override // com.facebook.imagepipeline.image.QualityInfo
    public boolean isOfGoodEnoughQuality() {
        return this.mIsOfGoodEnoughQuality;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImmutableQualityInfo) == true) goto L8;
        return false;
    L8:
        ImmutableQualityInfo r101 = (ImmutableQualityInfo) r100;
        if (this.mQuality == r101.mQuality) goto L11;
    L15:
        return false;
    L11:
        if (this.mIsOfGoodEnoughQuality != r101.mIsOfGoodEnoughQuality) goto L15;
        if (this.mIsOfFullQuality != r101.mIsOfFullQuality) goto L15;
        return true;
    }

    private ImmutableQualityInfo(int r100, boolean r101, boolean r102) {
        this.mQuality = r100;
        this.mIsOfGoodEnoughQuality = r101;
        this.mIsOfFullQuality = r102;
    }

    public static QualityInfo of(int r100, boolean r101, boolean r102) {
        return new ImmutableQualityInfo(r100, r101, r102);
    }
}

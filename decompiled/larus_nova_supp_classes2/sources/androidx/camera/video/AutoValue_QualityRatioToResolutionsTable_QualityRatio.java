package androidx.camera.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_QualityRatioToResolutionsTable_QualityRatio extends QualityRatioToResolutionsTable.QualityRatio {
    private final int aspectRatio;
    private final Quality quality;

    public int hashCode() {
        return ((this.quality.hashCode() ^ 1000003) * 1000003) ^ this.aspectRatio;
    }

    public String toString() {
        return "QualityRatio{quality=" + this.quality + ", aspectRatio=" + this.aspectRatio + "}";
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    public int getAspectRatio() {
        return this.aspectRatio;
    }

    @Override // androidx.camera.video.QualityRatioToResolutionsTable.QualityRatio
    public Quality getQuality() {
        return this.quality;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof QualityRatioToResolutionsTable.QualityRatio) == false) goto L14;
        QualityRatioToResolutionsTable.QualityRatio r6 = (QualityRatioToResolutionsTable.QualityRatio) r5;
        if (this.quality.equals(r6.getQuality()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.aspectRatio != r6.getAspectRatio()) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_QualityRatioToResolutionsTable_QualityRatio(Quality r1, int r2) {
        if (r1 == null) goto L7;
        this.quality = r1;
        this.aspectRatio = r2;
        return;
    L7:
        throw new NullPointerException("Null quality");
    }
}

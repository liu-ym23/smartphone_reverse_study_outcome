package h35;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f483715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f483716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f483717c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f483715a == r101.f483715a) goto L12;
        return false;
    L12:
        if (this.f483716b == r101.f483716b) goto L15;
        return false;
    L15:
        if (this.f483717c == r101.f483717c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f483715a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f483716b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f483717c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TemplatePreviewData(previewEnable=" + this.f483715a + ", isGroupTemplatePreview=" + this.f483716b + ", isCommonTemplatePreview=" + this.f483717c + ')';
    }

    public b(boolean r100, boolean r101, boolean r102) {
        this.f483715a = r100;
        this.f483716b = r101;
        this.f483717c = r102;
    }
}

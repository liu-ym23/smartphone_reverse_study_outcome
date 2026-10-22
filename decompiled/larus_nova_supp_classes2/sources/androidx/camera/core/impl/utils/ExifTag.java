package androidx.camera.core.impl.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public boolean isFormatCompatible(int r5) {
        int r0 = this.primaryFormat;
        if (r0 == 7) goto L30;
        if (r5 == 7) goto L32;
        if (r0 == r5) goto L31;
        int r2 = this.secondaryFormat;
        if (r2 != r5) goto L11;
        return true;
    L11:
        if (r0 == 4) goto L14;
        if (r2 == 4) goto L14;
    L17:
        if (r0 == 9) goto L20;
        if (r2 == 9) goto L20;
    L23:
        if (r0 == 12) goto L26;
        if (r2 == 12) goto L26;
    L28:
        return false;
    L26:
        if (r5 != 11) goto L28;
        return true;
    L20:
        if (r5 != 8) goto L23;
        return true;
    L14:
        if (r5 != 3) goto L17;
        return true;
    L31:
        return true;
    L32:
        return true;
    L30:
        return true;
    }

    public ExifTag(String r1, int r2, int r3) {
        this.name = r1;
        this.number = r2;
        this.primaryFormat = r3;
        this.secondaryFormat = -1;
    }

    public ExifTag(String r1, int r2, int r3, int r4) {
        this.name = r1;
        this.number = r2;
        this.primaryFormat = r3;
        this.secondaryFormat = r4;
    }
}

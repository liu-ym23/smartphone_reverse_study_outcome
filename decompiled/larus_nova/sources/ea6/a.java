package ea6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471625c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f471623a, r101.f471623a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471624b, r101.f471624b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471625c, r101.f471625c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f471623a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f471624b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f471625c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "YataParamProcessData(operateRenderNodeKey=" + this.f471623a + ", operatorType=" + this.f471624b + ", triggerType=" + this.f471625c + ')';
    }

    public a(String r100, String r101, String r102) {
        this.f471623a = r100;
        this.f471624b = r101;
        this.f471625c = r102;
    }
}

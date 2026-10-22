package jh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f499100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f499101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f499102c;

    public b() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f499100a, r101.f499100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499101b, r101.f499101b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499102c, r101.f499102c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f499100a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f499101b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f499102c;
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
        return "MarkdownCodeRenderWidgetConfig(backgroundRes=" + this.f499100a + ", separatorColor=" + this.f499101b + ", expandAllBackgroundResult=" + this.f499102c + ')';
    }

    public b(Integer r100, Integer r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this.f499100a = null;
        this.f499101b = r100;
        this.f499102c = r101;
    }
}

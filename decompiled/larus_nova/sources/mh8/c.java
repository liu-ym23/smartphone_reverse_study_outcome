package mh8;

import jc8.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f513972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f513973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f513974c;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f513972a == r101.f513972a) goto L12;
        return false;
    L12:
        if (this.f513973b == r101.f513973b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513974c, r101.f513974c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f513972a * 31) + this.f513973b) * 31;
        Integer r101 = this.f513974c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownEmbeddedBlockLayoutConfig(contentPaddingStart=" + this.f513972a + ", contentPaddingEnd=" + this.f513973b + ", contentMaxWidth=" + this.f513974c + ')';
    }

    public /* synthetic */ c(int r100) {
        this(0, 0, null);
    }

    public c(int r100, int r101, Integer r102) {
        this.f513972a = r100;
        this.f513973b = r101;
        this.f513974c = r102;
    }
}

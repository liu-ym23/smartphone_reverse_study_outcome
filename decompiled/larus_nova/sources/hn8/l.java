package hn8;

import com.larus.bmhome.chat.search.factory.ExpandCardViewMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f486154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpandCardViewMode f486155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f486157d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f486154a, r101.f486154a) == true) goto L12;
        return false;
    L12:
        if (this.f486155b == r101.f486155b) goto L15;
        return false;
    L15:
        if (this.f486156c == r101.f486156c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f486157d, r101.f486157d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f486154a.hashCode() * 31) + this.f486155b.hashCode()) * 31;
        if (this.f486156c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f486157d;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "VideoCardViewData(videoCardData=" + this.f486154a + ", videoCardMode=" + this.f486155b + ", isOversea=" + this.f486156c + ", messageId=" + this.f486157d + ')';
    }

    public l(j r100, ExpandCardViewMode r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "videoCardData");
        Intrinsics.checkNotNullParameter(r101, "videoCardMode");
        this.f486154a = r100;
        this.f486155b = r101;
        this.f486156c = r102;
        this.f486157d = r103;
    }
}

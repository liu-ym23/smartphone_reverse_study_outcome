package de3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f468055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f468056c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f468054a, r101.f468054a) == true) goto L8;
        return false;
    L8:
        if (this.f468055b == r101.f468055b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468056c, r101.f468056c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468054a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f468055b) * 31;
        List<b> r104 = this.f468056c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedbackBoardData(title=" + this.f468054a + ", panelHeight=" + this.f468055b + ", feedbackListData=" + this.f468056c + ")";
    }

    public a(String r100, int r101, List<b> r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r102, "feedbackListData");
        this.f468054a = r100;
        this.f468055b = r101;
        this.f468056c = r102;
    }
}

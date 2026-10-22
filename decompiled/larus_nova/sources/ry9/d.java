package ry9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f539924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f539925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f539926c;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f539924a, r101.f539924a) == true) goto L12;
        return false;
    L12:
        if (this.f539925b == r101.f539925b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539926c, r101.f539926c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f539924a.hashCode() * 31) + this.f539925b) * 31;
        Double r101 = this.f539926c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CreationReferenceAttachmentSnapshot(attachments=" + this.f539924a + ", additionalVideoCount=" + this.f539925b + ", additionalVideoDuration=" + this.f539926c + ')';
    }

    public /* synthetic */ d(int r100) {
        this(CollectionsKt.emptyList(), 0, null);
    }

    public d(List<c> r100, int r101, Double r102) {
        Intrinsics.checkNotNullParameter(r100, "attachments");
        this.f539924a = r100;
        this.f539925b = r101;
        this.f539926c = r102;
    }

    public static d a(d r100, int r101, Double r102) {
        List<c> r103 = r100.f539924a;
        Intrinsics.checkNotNullParameter(r103, "attachments");
        return new d(r103, r101, r102);
    }
}

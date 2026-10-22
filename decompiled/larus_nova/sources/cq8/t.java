package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.larus.bmhome.actionbar.model.w> f464957c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f464956b, r101.f464956b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464957c, r101.f464957c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f464956b.hashCode() * 31) + this.f464957c.hashCode();
    }

    public final String toString() {
        return "ImageStyleListRefreshAction(widgetId=" + this.f464956b + ", imageList=" + this.f464957c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464956b;
    }

    public t(String r100, List<com.larus.bmhome.actionbar.model.w> r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "imageList");
        super("ImageStyleListRefreshAction");
        this.f464956b = r100;
        this.f464957c = r101;
    }
}

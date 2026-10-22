package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.larus.bmhome.actionbar.model.w> f464856c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f464855b, r101.f464855b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464856c, r101.f464856c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f464855b.hashCode() * 31) + this.f464856c.hashCode();
    }

    public final String toString() {
        return "DropFeatureListSyncAction(widgetId=" + this.f464855b + ", optionList=" + this.f464856c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464855b;
    }

    public j(String r100, List<com.larus.bmhome.actionbar.model.w> r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "optionList");
        super("DropFeatureListSyncAction");
        this.f464855b = r100;
        this.f464856c = r101;
    }
}

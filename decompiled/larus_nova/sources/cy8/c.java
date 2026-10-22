package cy8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f465812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f465813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465814c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f465812a, r101.f465812a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465813b, r101.f465813b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465814c, r101.f465814c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f465812a.hashCode() * 31;
        Long r101 = this.f465813b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f465814c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasBlockSnapshot(blocks=" + this.f465812a + ", sequenceId=" + this.f465813b + ", logId=" + this.f465814c + ')';
    }

    public c() {
        this(CollectionsKt.emptyList(), null, null);
    }

    public c(List<b> r100, Long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "blocks");
        this.f465812a = r100;
        this.f465813b = r101;
        this.f465814c = r102;
    }
}

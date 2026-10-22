package sg4;

import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<Integer, pg4.d> f541832a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f541832a, ((d) r100).f541832a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        TreeMap<Integer, pg4.d> r100 = this.f541832a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LyricsInfo(lyricsLineInfoTreeMap=" + this.f541832a + ")";
    }

    public d(TreeMap<Integer, pg4.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "lyricsLineInfoTreeMap");
        this.f541832a = r100;
    }
}

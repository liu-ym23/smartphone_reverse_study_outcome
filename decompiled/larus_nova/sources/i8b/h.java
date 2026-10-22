package i8b;

import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f488731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileAuthMonitor.a f488732b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f488731a, r101.f488731a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488732b, r101.f488732b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f488731a.hashCode() * 31) + this.f488732b.hashCode();
    }

    public final String toString() {
        return "DataResultChangeData(pointKeys=" + this.f488731a + ", updateInfo=" + this.f488732b + ')';
    }

    public h(List<String> r100, FileAuthMonitor.a r101) {
        Intrinsics.checkNotNullParameter(r100, "pointKeys");
        Intrinsics.checkNotNullParameter(r101, "updateInfo");
        this.f488731a = r100;
        this.f488732b = r101;
    }
}

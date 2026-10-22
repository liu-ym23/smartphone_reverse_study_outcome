package sob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.AsrAdoptionRate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f542804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsrAdoptionRate f542805b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f542804a, r101.f542804a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542805b, r101.f542805b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f542804a.hashCode() * 31) + this.f542805b.hashCode();
    }

    public final String toString() {
        return "AsrNerStatistic(userInfoList=" + this.f542804a + ", adoptionRate=" + this.f542805b + ')';
    }

    public a(List<b> r100, AsrAdoptionRate r101) {
        Intrinsics.checkNotNullParameter(r100, "userInfoList");
        Intrinsics.checkNotNullParameter(r101, "adoptionRate");
        this.f542804a = r100;
        this.f542805b = r101;
    }
}

package va8;

import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FloatChatWindowState f553966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f553967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f553968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f553969d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f553966a == r101.f553966a) goto L12;
        return false;
    L12:
        if (this.f553967b == r101.f553967b) goto L15;
        return false;
    L15:
        if (this.f553968c == r101.f553968c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f553969d, r101.f553969d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f553966a.hashCode() * 31) + this.f553967b) * 31) + this.f553968c) * 31) + this.f553969d.hashCode();
    }

    public final String toString() {
        return "FloatChatWindowSnapshot(state=" + this.f553966a + ", heightPx=" + this.f553967b + ", showPercent=" + this.f553968c + ", from=" + this.f553969d + ')';
    }

    public h(FloatChatWindowState r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r103, "from");
        this.f553966a = r100;
        this.f553967b = r101;
        this.f553968c = r102;
        this.f553969d = r103;
    }
}

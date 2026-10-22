package dw8;

import com.larus.bmhome.ability.FloatChatWindowState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatChatWindowState f470354b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f470353a == r101.f470353a) goto L12;
        return false;
    L12:
        if (this.f470354b == r101.f470354b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f470353a * 31) + this.f470354b.hashCode();
    }

    public final String toString() {
        return "AIChatPanelInfo(heightPx=" + this.f470353a + ", state=" + this.f470354b + ')';
    }

    public n(int r100, FloatChatWindowState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f470353a = r100;
        this.f470354b = r101;
    }
}

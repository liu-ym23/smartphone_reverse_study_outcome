package r2;

import com.bytedance.ai.applet.components.input.AppletChatPanelState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppletChatPanelState f535708b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f535707a == r101.f535707a) goto L12;
        return false;
    L12:
        if (this.f535708b == r101.f535708b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f535707a * 31) + this.f535708b.hashCode();
    }

    public final String toString() {
        return "AppletChatPanelInfo(height=" + this.f535707a + ", state=" + this.f535708b + ')';
    }

    public f(int r100, AppletChatPanelState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f535707a = r100;
        this.f535708b = r101;
    }
}

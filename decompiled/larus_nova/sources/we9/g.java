package we9;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g implements xe9.a, xe9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559425b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f559424a, r101.f559424a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559425b, r101.f559425b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f559424a.hashCode() * 31) + this.f559425b.hashCode();
    }

    public final String toString() {
        return "SpeechOnly(eventName=" + this.f559424a + ", payload=" + this.f559425b + ')';
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        this.f559424a = r100;
        this.f559425b = r101;
    }
}

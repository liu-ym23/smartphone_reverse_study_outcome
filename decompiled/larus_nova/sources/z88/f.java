package z88;

import com.larus.avlink.business.api.DoraAvlinkSessionMode;
import com.larus.avlink.business.api.DoraAvlinkSessionState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f570961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraAvlinkSessionState f570962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DoraAvlinkSessionMode f570963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y88.c f570964d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f570961a, r101.f570961a) == true) goto L12;
        return false;
    L12:
        if (this.f570962b == r101.f570962b) goto L15;
        return false;
    L15:
        if (this.f570963c == r101.f570963c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f570964d, r101.f570964d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f570961a.hashCode() * 31) + this.f570962b.hashCode()) * 31) + this.f570963c.hashCode()) * 31) + this.f570964d.hashCode();
    }

    public final String toString() {
        return "DoraAvlinkSessionSnapshot(sessionId=" + this.f570961a + ", state=" + this.f570962b + ", mode=" + this.f570963c + ", sessionContext=" + this.f570964d + ')';
    }

    public f(String r100, DoraAvlinkSessionState r101, DoraAvlinkSessionMode r102, y88.c r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "mode");
        Intrinsics.checkNotNullParameter(r103, "sessionContext");
        this.f570961a = r100;
        this.f570962b = r101;
        this.f570963c = r102;
        this.f570964d = r103;
    }

    public static f a(f r100, DoraAvlinkSessionState r101, DoraAvlinkSessionMode r102, int r103) {
        y88.c r104 = null;
        if ((r103 & 1) == 0) goto L5;
        String r105 = r100.f570961a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f570962b;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r102 = r100.f570963c;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r104 = r100.f570964d;
    L15:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "mode");
        Intrinsics.checkNotNullParameter(r104, "sessionContext");
        return new f(r105, r101, r102, r104);
    L5:
        r105 = null;
        goto L7
    }

    public /* synthetic */ f(String r100, DoraAvlinkSessionMode r101, y88.c r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        DoraAvlinkSessionState r104 = DoraAvlinkSessionState.UNKNOWN;
    L7:
        if ((r103 & 4) == 0) goto L10;
        r101 = DoraAvlinkSessionMode.NORMAL;
    L10:
        if ((r103 & 8) == 0) goto L12;
        r102 = new y88.c(r100, 254);
    L12:
        this(r100, r104, r101, r102);
        return;
    L5:
        r104 = null;
        goto L7
    }
}

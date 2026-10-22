package pc8;

import com.larus.bmhome.chat.bubble.floating.ReachSpacerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f528606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f528607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f528608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f528609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReachSpacerState f528610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f528611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f528612j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f528603a, r101.f528603a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528604b, r101.f528604b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528605c, r101.f528605c) == true) goto L18;
        return false;
    L18:
        if (this.f528606d == r101.f528606d) goto L21;
        return false;
    L21:
        if (this.f528607e == r101.f528607e) goto L24;
        return false;
    L24:
        if (this.f528608f == r101.f528608f) goto L27;
        return false;
    L27:
        if (this.f528609g == r101.f528609g) goto L30;
        return false;
    L30:
        if (this.f528610h == r101.f528610h) goto L33;
        return false;
    L33:
        if (this.f528611i == r101.f528611i) goto L36;
        return false;
    L36:
        if (this.f528612j == r101.f528612j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f528603a.hashCode() * 31) + this.f528604b.hashCode()) * 31) + this.f528605c.hashCode()) * 31;
        if (this.f528606d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((((((((r100 + r101) * 31) + this.f528607e) * 31) + this.f528608f) * 31) + this.f528609g) * 31) + this.f528610h.hashCode()) * 31;
        long r103 = this.f528611i;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f528612j;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ReachSpacerSnapshot(reachUniqueId=" + this.f528603a + ", conversationId=" + this.f528604b + ", queryMessageId=" + this.f528605c + ", requiresSpacer=" + this.f528606d + ", spacerHeightPx=" + this.f528607e + ", showTiming=" + this.f528608f + ", dismissTiming=" + this.f528609g + ", state=" + this.f528610h + ", transitionStartedAtMs=" + this.f528611i + ", transitionDurationMs=" + this.f528612j + ')';
    }

    public m(String r100, String r101, String r102, boolean r103, int r104, int r105, int r106, ReachSpacerState r107, long r110) {
        Intrinsics.checkNotNullParameter(r100, "reachUniqueId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "queryMessageId");
        Intrinsics.checkNotNullParameter(r107, "state");
        this.f528603a = r100;
        this.f528604b = r101;
        this.f528605c = r102;
        this.f528606d = r103;
        this.f528607e = r104;
        this.f528608f = r105;
        this.f528609g = r106;
        this.f528610h = r107;
        this.f528611i = r110;
        this.f528612j = 500;
    }
}

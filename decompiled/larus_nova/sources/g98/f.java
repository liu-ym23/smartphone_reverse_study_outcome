package g98;

import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraEnvObserveState f480532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnvObserveChangeReason f480534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f480535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f480536e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f480532a == r101.f480532a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480533b, r101.f480533b) == true) goto L15;
        return false;
    L15:
        if (this.f480534c == r101.f480534c) goto L18;
        return false;
    L18:
        if (this.f480535d == r101.f480535d) goto L21;
        return false;
    L21:
        if (this.f480536e == r101.f480536e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f480532a.hashCode() * 31) + this.f480533b.hashCode()) * 31;
        EnvObserveChangeReason r101 = this.f480534c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f480535d) * 31) + this.f480536e;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraEnvObserveStateEvent(state=" + this.f480532a + ", source=" + this.f480533b + ", reason=" + this.f480534c + ", type=" + this.f480535d + ", code=" + this.f480536e + ')';
    }

    public final int getType() {
        return this.f480535d;
    }

    public /* synthetic */ f(DoraEnvObserveState r100, String r101) {
        this(r100, r101, null, 0, 0);
    }

    public f(DoraEnvObserveState r100, String r101, EnvObserveChangeReason r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f480532a = r100;
        this.f480533b = r101;
        this.f480534c = r102;
        this.f480535d = r103;
        this.f480536e = r104;
    }
}

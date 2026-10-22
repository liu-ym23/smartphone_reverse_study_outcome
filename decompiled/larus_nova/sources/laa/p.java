package laa;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f508228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f508229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f508230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f508231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f508232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f508233f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f508228a, r101.f508228a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f508229b, r101.f508229b) == true) goto L15;
        return false;
    L15:
        if (this.f508230c == r101.f508230c) goto L18;
        return false;
    L18:
        if (Float.compare(this.f508231d, r101.f508231d) == 0) goto L21;
        return false;
    L21:
        if (this.f508232e == r101.f508232e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f508233f, r101.f508233f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f508228a.hashCode() * 31) + this.f508229b.hashCode()) * 31) + this.f508230c) * 31) + Float.floatToIntBits(this.f508231d)) * 31;
        long r101 = this.f508232e;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f508233f.hashCode();
    }

    public final String toString() {
        return "ObricMessageVisibilityEvent(message=" + this.f508228a + ", messageKey=" + this.f508229b + ", position=" + this.f508230c + ", visibleRatio=" + this.f508231d + ", visibleDurationMs=" + this.f508232e + ", reason=" + this.f508233f + ')';
    }

    public p(Message r100, String r101, int r102, float r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "messageKey");
        Intrinsics.checkNotNullParameter(r105, "reason");
        this.f508228a = r100;
        this.f508229b = r101;
        this.f508230c = r102;
        this.f508231d = r103;
        this.f508232e = r104;
        this.f508233f = r105;
    }
}

package yaa;

import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricAiKeyGestureAction f567043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObricAiKeyGestureState f567044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f567045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f567046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f567047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f567048f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f567043a == r101.f567043a) goto L12;
        return false;
    L12:
        if (this.f567044b == r101.f567044b) goto L15;
        return false;
    L15:
        if (this.f567045c == r101.f567045c) goto L18;
        return false;
    L18:
        if (this.f567046d == r101.f567046d) goto L21;
        return false;
    L21:
        if (this.f567047e == r101.f567047e) goto L24;
        return false;
    L24:
        if (this.f567048f == r101.f567048f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f567043a.hashCode() * 31) + this.f567044b.hashCode()) * 31;
        long r101 = this.f567045c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f567046d;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f567047e) * 31) + this.f567048f;
    }

    public final String toString() {
        return "ObricAiKeyGestureEvent(action=" + this.f567043a + ", stateBefore=" + this.f567044b + ", eventTimeMillis=" + this.f567045c + ", downTimeMillis=" + this.f567046d + ", durationMillis=" + this.f567047e + ", firstTapDurationMillis=" + this.f567048f + ')';
    }

    public a(ObricAiKeyGestureAction r100, ObricAiKeyGestureState r101, long r102, long r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "stateBefore");
        this.f567043a = r100;
        this.f567044b = r101;
        this.f567045c = r102;
        this.f567046d = r103;
        this.f567047e = r104;
        this.f567048f = r105;
    }
}

package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class y implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kf5.b f472517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f472518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f472519c;

    public final String toString() {
        return "KeyboardHeightChangeEvent(height=" + this.f472518b + ", canDismiss=" + this.f472519c + ')';
    }

    public y(kf5.b r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "inputComment");
        this.f472517a = r100;
        this.f472518b = r101;
        this.f472519c = r102;
    }
}

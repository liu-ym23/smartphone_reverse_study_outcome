package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class u implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kf5.b f472506b;

    public final String toString() {
        return "InputTextChangedEvent(text=" + this.f472505a.length() + ')';
    }

    public u(String r100, kf5.b r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "inputComment");
        this.f472505a = r100;
        this.f472506b = r101;
    }
}

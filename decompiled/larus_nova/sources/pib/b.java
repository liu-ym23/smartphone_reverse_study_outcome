package pib;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f529413d;

    public final String toString() {
        return "ForwardFlagShareOption{ messageId=" + this.f529416a + ", originMergeForwardId=" + this.f529413d + " , messageFileKeys_size = " + this.f529412c + '}';
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "messageFileKey");
        Intrinsics.checkNotNullParameter(r102, "originMergeForwardId");
        this.f529412c = r101;
        this.f529413d = r102;
        this.f529417b = 9;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f529416a = r100;
    }
}

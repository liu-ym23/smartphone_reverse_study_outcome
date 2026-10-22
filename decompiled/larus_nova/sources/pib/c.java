package pib;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f529415d;

    public final String toString() {
        return "ForwardMessageShareOption{ messageId=" + this.f529416a + ", originMergeForwardId=" + this.f529415d + " , messageFileKeys_size = " + this.f529414c + '}';
    }

    public c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "messageFileKey");
        Intrinsics.checkNotNullParameter(r102, "originMergeForwardId");
        this.f529414c = r101;
        this.f529415d = r102;
        this.f529417b = 7;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f529416a = r100;
    }
}

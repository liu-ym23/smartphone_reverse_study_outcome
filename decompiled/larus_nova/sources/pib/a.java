package pib;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f529410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f529411d;

    public final String toString() {
        return "ForwardFavShareOption{ messageId=" + this.f529416a + ", favId=" + this.f529411d + " ,messageFileKeys_size = " + this.f529410c + '}';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "messageFileKey");
        Intrinsics.checkNotNullParameter(r102, "favId");
        this.f529410c = r101;
        this.f529411d = r102;
        this.f529417b = 8;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f529416a = r100;
    }
}

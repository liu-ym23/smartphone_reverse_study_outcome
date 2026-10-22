package dw8;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f470348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f470349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Boolean> f470350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Boolean> f470351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f470352e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f470348a, r101.f470348a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f470349b, r101.f470349b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f470350c, r101.f470350c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f470351d, r101.f470351d) == true) goto L21;
        return false;
    L21:
        if (this.f470352e == r101.f470352e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f470348a.hashCode() * 31) + this.f470349b.hashCode()) * 31) + this.f470350c.hashCode()) * 31) + this.f470351d.hashCode()) * 31;
        if (this.f470352e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "AIChatHostConfig(canInterceptBack=" + this.f470348a + ", onBackIntercepted=" + this.f470349b + ", onLinkIntercepted=" + this.f470350c + ", onArtifactIntercepted=" + this.f470351d + ", imageSkipDownscaleEnabled=" + this.f470352e + ')';
    }

    public m() {
        this(new zb8.c(), new j(), new k(), new l(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function0<Boolean> r100, Function0<Unit> r101, Function1<? super String, Boolean> r102, Function1<? super String, Boolean> r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "canInterceptBack");
        Intrinsics.checkNotNullParameter(r101, "onBackIntercepted");
        Intrinsics.checkNotNullParameter(r102, "onLinkIntercepted");
        Intrinsics.checkNotNullParameter(r103, "onArtifactIntercepted");
        this.f470348a = r100;
        this.f470349b = r101;
        this.f470350c = r102;
        this.f470351d = r103;
        this.f470352e = r104;
    }
}

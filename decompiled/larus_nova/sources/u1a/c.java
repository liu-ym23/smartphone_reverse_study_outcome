package u1a;

import com.larus.ui.arch.component.external.api.receiver.Container;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Container> f548350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ContainerFilter f548351b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f548350a, r101.f548350a) == true) goto L12;
        return false;
    L12:
        if (this.f548351b == r101.f548351b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f548350a.hashCode() * 31) + this.f548351b.hashCode();
    }

    public final String toString() {
        return "ContainerMeta(provider=" + this.f548350a + ", filter=" + this.f548351b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends Container> r100, ContainerFilter r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        Intrinsics.checkNotNullParameter(r101, "filter");
        this.f548350a = r100;
        this.f548351b = r101;
    }
}

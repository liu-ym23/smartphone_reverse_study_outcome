package znc;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class i extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputStream f573047c;

    @Override // znc.a
    public final InputStream b() {
        return this.f573047c;
    }

    public i(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f573047c = r100;
    }
}

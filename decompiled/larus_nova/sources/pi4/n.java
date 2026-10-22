package pi4;

import java.util.Map;
import ki4.b0;
import ki4.d0;
import ki4.e0;
import ki4.p;
import ki4.q;
import ki4.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n implements q<r, b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e0, Function0<p<r, b0>>> f529354a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(Map<e0, ? extends Function0<? extends p<r, b0>>> r100) {
        Intrinsics.checkNotNullParameter(r100, "fetcherBuilderMap");
        this.f529354a = r100;
    }

    @Override // ki4.q
    public final p<r, b0> a(e0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r101, "materialRange");
        Function0<p<r, b0>> r102 = this.f529354a.get(r100);
        if (r102 == null) goto L5;
        p<r, b0> r103 = r102.invoke();
    L6:
        if (r103 == null) goto L9;
        return r103;
    L9:
        throw new IllegalArgumentException(("AlbumSDK: FetcherProvider error, current source type is " + r100).toString());
    L5:
        r103 = null;
        goto L6
    }
}

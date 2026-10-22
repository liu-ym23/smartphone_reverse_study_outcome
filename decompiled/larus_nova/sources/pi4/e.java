package pi4;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import ki4.b0;
import ki4.d0;
import ki4.e0;
import ki4.h0;
import ki4.p;
import ki4.q;
import ki4.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements q<r, b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ki4.h> f529329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ki4.g<r>> f529330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<h0> f529331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<h0> f529332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q<r, b0> f529333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f529334f;

    public final mi4.c b(Function0 r100) {
        h0 r101 = (h0) r100.invoke();
        ki4.h r102 = this.f529329a.invoke();
        ki4.g r103 = (ki4.g) this.f529334f.getValue();
        Intrinsics.checkNotNullParameter(r102, "cursorProvider");
        Intrinsics.checkNotNullParameter(r103, "cursorParserProvider");
        Intrinsics.checkNotNullParameter(r101, "queryParam");
        return new mi4.c(r102, r103, r101);
    }

    @Override // ki4.q
    public final p<r, b0> a(e0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r101, "materialRange");
        if (r100 != BuiltInMaterialType.VIDEO) goto L6;
        p<r, b0> r102 = b(this.f529332d);
    L12:
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new IllegalArgumentException(("AlbumSDK: FetcherProvider error, current source type is " + r100).toString());
    L6:
        if (r100 != BuiltInMaterialType.IMAGE) goto L8;
        r102 = b(this.f529331c);
        goto L12
    L8:
        q<r, b0> r103 = this.f529333e;
        if (r103 == null) goto L11;
        r102 = r103.a(r100, r101);
        goto L12
    L11:
        r102 = null;
        goto L12
    }

    public e(oi4.g r100, oi4.f r101, Function0 r102, Function0 r103, n r104) {
        Intrinsics.checkNotNullParameter(r100, "cursorProvider");
        Intrinsics.checkNotNullParameter(r101, "cursorParserProvider");
        Intrinsics.checkNotNullParameter(r102, "imageQueryParamProvider");
        Intrinsics.checkNotNullParameter(r103, "videoQueryParamProvider");
        this.f529329a = r100;
        this.f529330b = r101;
        this.f529331c = r102;
        this.f529332d = r103;
        this.f529333e = r104;
        this.f529334f = LazyKt.lazy(new d(this));
    }
}

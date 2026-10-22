package to;

import kotlin.jvm.internal.Intrinsics;
import to.a;

/* JADX INFO: loaded from: classes44.dex */
public final class c<VO extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends VO> f546884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f546885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VO f546886c;

    public c(Class<? extends VO> r100, String r101, VO r102) {
        Intrinsics.checkNotNullParameter(r100, "voClazz");
        Intrinsics.checkNotNullParameter(r101, "renderTargetType");
        Intrinsics.checkNotNullParameter(r102, "vo");
        this.f546884a = r100;
        this.f546885b = r101;
        this.f546886c = r102;
    }
}

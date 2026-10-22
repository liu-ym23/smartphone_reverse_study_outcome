package ji4;

import fi4.d;
import ki4.a0;
import ki4.r;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti4.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements d<r> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f499195d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<r> f499196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fi4.c<r> f499197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<a0, ti4.r<r>> f499198c;

    public static final class a {
    }

    static {
    }

    @Override // fi4.d
    public final m<r> b() {
        return this.f499196a;
    }

    @Override // fi4.d
    public final fi4.c<r> c() {
        return this.f499197b;
    }

    @Override // fi4.d
    public final ti4.r<r> a(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        return this.f499198c.invoke(r100);
    }

    public c(m r100, b r101) {
        ji4.a r102 = new ji4.a();
        Intrinsics.checkNotNullParameter(r101, "mediaSelectListViewModelProvider");
        this.f499196a = r100;
        this.f499197b = r102;
        this.f499198c = r101;
    }
}

package unc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends unc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f550892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xnc.a f550893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public wnc.a f550894e;

    public static final class a implements tnc.a {
        @Override // tnc.a
        public final void onNext() {
        }

        public a(snc.b r100, wnc.a r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
        }
    }

    public d(String r100, xnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultScheme");
        Intrinsics.checkNotNullParameter(r101, "routerMapping");
        this.f550892c = r100;
        this.f550893d = r101;
    }
}

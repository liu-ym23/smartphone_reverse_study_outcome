package unc;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, f> f550890b;

    public static final class a implements tnc.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ tnc.a f550891a;

        @Override // tnc.a
        public final void onNext() {
            this.f550891a.onNext();
        }

        public a(tnc.a r100) {
            this.f550891a = r100;
        }
    }

    public c() {
        this.f550890b = new HashMap();
    }

    @Override // unc.b
    public final boolean a(snc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (this.f550890b.get(r100.f542690e) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // unc.f
    public final void c(snc.b r100, tnc.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        f r102 = this.f550890b.get(r100.f542690e);
        if (r102 == null) goto L5;
        r102.b(r100, new a(r101));
        return;
    L5:
        r101.onNext();
    }
}

package ny3;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements p24.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f521199a;

    public e(d r100) {
        this.f521199a = r100;
    }

    @Override // r34.e
    public final void onFail(Exception r100) {
        ux3.b r101 = (ux3.b) this.f521199a.f547816b;
        if (r101 == null) goto L6;
        new RuntimeException();
        r101.f();
        return;
    }

    @Override // r34.e
    public final void onSuccess(o14.f r100) {
        o14.f r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f521199a.a(r101, true);
        d r102 = this.f521199a;
        List<o14.a> r103 = r101.g();
        boolean r104 = this.f521199a.f521197d;
        ux3.b r105 = (ux3.b) r102.f547816b;
        if (r105 == null) goto L6;
        r105.C6(TypeIntrinsics.asMutableList(r103), r104);
        return;
    }
}

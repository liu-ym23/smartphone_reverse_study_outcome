package k92;

import ak6.g;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import qb2.e;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f502140a;

    public b(TextView r100) {
        this.f502140a = r100;
    }

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f502140a.setText(r100.f4074a);
    }
}

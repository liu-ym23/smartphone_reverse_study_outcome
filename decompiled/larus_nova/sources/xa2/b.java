package xa2;

import ak6.e;
import ak6.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import h52.c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f563058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f563059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f563060c;

    @Override // ak6.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ak6.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        k.a r101 = this.f563058a;
        if (r101 == null) goto L6;
        r101.a(this.f563059b, new j(r100.f4074a, ((d) this.f563060c.element).f133506b));
        return;
    }

    public b(k.a r100, c r101, Ref.ObjectRef r102) {
        this.f563058a = r100;
        this.f563059b = r101;
        this.f563060c = r102;
    }
}

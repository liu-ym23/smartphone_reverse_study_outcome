package da2;

import ak6.e;
import ak6.g;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k.a f467674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f467675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f467676c;

    @Override // ak6.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ak6.e
    public final void b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        k.a r101 = this.f467674a;
        if (r101 == null) goto L6;
        r101.a(this.f467675b, new j(r100.f4074a, ((com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.d) this.f467676c.element).f133506b));
        return;
    }

    public d(k.a r100, f r101, Ref.ObjectRef r102) {
        this.f467674a = r100;
        this.f467675b = r101;
        this.f467676c = r102;
    }
}

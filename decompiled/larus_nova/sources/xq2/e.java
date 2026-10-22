package xq2;

import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements o, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ir2.a f564798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f564799b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // xq2.b
    public final cy0.c c0() {
        cy0.a r100 = this.f564798a.Ak();
        if (r100 == null) goto L10;
        a r101 = (a) m.f163449e.d(r100, a.class);
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.c0();
    L10:
        return this.f564799b.f564794a;
    }

    public e(ir2.a r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "livePlayScopeFinder");
        Intrinsics.checkNotNullParameter(r101, "linkDataScopeProviderServiceAnchor");
        this.f564798a = r100;
        this.f564799b = r101;
    }
}

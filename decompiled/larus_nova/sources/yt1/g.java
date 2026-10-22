package yt1;

import android.view.View;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "use IDSLComponent")
public final class g implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f569029a;

    @Override // yt1.k
    public final void a(com.bytedance.android.livesdk.dsl.recyclerview.i r100) {
    }

    @Override // yt1.k
    public final void b(au1.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lifeType");
    }

    @Override // yt1.k
    public final void c(String r100, Map<String, ? extends Object> r101, int r102) {
    }

    @Override // yt1.k
    public final void release() {
    }

    @Override // yt1.k
    public final View getView() {
        return this.f569029a;
    }

    public g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "mView");
        this.f569029a = r100;
    }
}

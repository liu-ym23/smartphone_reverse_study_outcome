package lf6;

import com.bytedance.live.artist.render.RenderRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends c {
    public b() {
    }

    @Override // lf6.c
    public final void b(RenderRequest r100, float r101) {
        com.bytedance.live.artist.core.b r102 = this.f509063a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_engineContext");
    L5:
        r102.f254823a.b();
    }
}

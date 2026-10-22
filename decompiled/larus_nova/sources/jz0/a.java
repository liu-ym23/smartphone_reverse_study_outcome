package jz0;

import com.bytedance.android.scope.o;
import com.bytedance.keva.Keva;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements iz0.b, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // iz0.b
    public final b p0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "repoName");
        return new b(Keva.getRepo(r100, r101));
    }
}

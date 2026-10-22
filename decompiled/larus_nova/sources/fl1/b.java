package fl1;

import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import mq1.z;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements z, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zq1.a f477688a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b(zq1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "interactionFragment");
        this.f477688a = r100;
    }

    @Override // mq1.z
    public final void a(vk1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f477688a.Iv(r100);
    }
}

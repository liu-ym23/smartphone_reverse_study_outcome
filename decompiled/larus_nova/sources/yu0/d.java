package yu0;

import com.bytedance.android.live.revenue.common.reactive.f;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f569218a;

    public d(m r100) {
        this.f569218a = r100;
    }

    @Override // com.bytedance.android.live.revenue.common.reactive.f
    public final void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f569218a.setValue(r100);
    }
}

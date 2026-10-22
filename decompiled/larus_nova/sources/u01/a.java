package u01;

import com.bytedance.android.livesdkapi.feed.IFeedViewState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements IFeedViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qc0.d f548124a;

    @Override // com.bytedance.android.livesdkapi.feed.IFeedViewState
    public final Object getReal() {
        return this.f548124a;
    }

    public a(qc0.d r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f548124a = r100;
    }
}

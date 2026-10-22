package u01;

import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k implements qc0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InteractFeedActionCaller f548136a;

    @Override // qc0.e
    public final void onCouplePkEnd() {
        this.f548136a.onCouplePkEnd();
    }

    @Override // qc0.e
    public final void onPkToNormal() {
        this.f548136a.onPkToNormal();
    }

    public k(InteractFeedActionCaller r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f548136a = r100;
    }
}

package ph6;

import com.bytedance.android.live.liveinteract.plantform.permission.checker.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qh0.a f529290a;

    public k(s r100) {
        this.f529290a = r100;
    }

    public final void a(tg6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        qh0.a r101 = this.f529290a;
        if (r101 == null) goto L6;
        r101.a(new j(r100));
        return;
    }
}

package ty6;

import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes21.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547989a;

    public abstract void a(boolean r100);

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f547989a = r100;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100.f547984a, this.f547989a) == false) goto L6;
        a(r100.f547985b);
        return;
    }
}

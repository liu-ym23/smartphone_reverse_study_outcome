package fu7;

import com.bytedance.common.utility.concurrent.ThreadPlus;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements f09.a.b {
    public e() {
    }

    @Override // f09.a.b
    public final void onAllActivityDestroyed() {
    }

    @Override // f09.a.b
    public final void onAppBackground() {
        h r100 = h.f478911a;
        ThreadPlus.submitRunnable(new d("background_state", "background", new b("background")));
    }

    @Override // f09.a.b
    public final void onAppForeground() {
        h r100 = h.f478911a;
        ThreadPlus.submitRunnable(new d("background_state", "foreground", new b("foreground")));
    }
}

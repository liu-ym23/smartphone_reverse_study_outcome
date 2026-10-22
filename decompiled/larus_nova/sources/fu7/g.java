package fu7;

import com.larus.network.util.ScreenStateManager;

/* JADX INFO: loaded from: classes23.dex */
public final class g implements ScreenStateManager.b {
    public g() {
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOff() {
        h r100 = h.f478911a;
        h.c("off");
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOn() {
        h r100 = h.f478911a;
        h.c("on");
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onUserPresent() {
        h r100 = h.f478911a;
        h.c("on");
    }
}

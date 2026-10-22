package hm9;

import com.larus.network.util.ScreenStateManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements ScreenStateManager.b {
    public i() {
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOff() {
        s r100 = j.f485966h;
        ScreenStateManager.ScreenState r101 = ScreenStateManager.ScreenState.SCREEN_OFF;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f485971a = r101;
        j.f485959a.b();
        j.e("onScreenOff");
        r100.f485983m = true;
        r100.f485984n = 50;
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onScreenOn() {
        s r100 = j.f485966h;
        ScreenStateManager.ScreenState r101 = ScreenStateManager.ScreenState.SCREEN_ON;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f485971a = r101;
        j.f485959a.b();
        j.e("onScreenOn");
        if (r100.f485995y == 2) goto L5;
        r100.d(false);
    L5:
        r100.f485983m = true;
        r100.f485984n = 50;
    }

    @Override // com.larus.network.util.ScreenStateManager.b
    public final void onUserPresent() {
        s r100 = j.f485966h;
        ScreenStateManager.ScreenState r101 = ScreenStateManager.ScreenState.SCREEN_ON;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f485971a = r101;
        j.f485959a.b();
        j.e("onUserPresent");
    }
}

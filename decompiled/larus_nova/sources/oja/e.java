package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements qja.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerController f523602a;

    @Override // qja.c.a
    public final void onCompletion() {
        tja.a r100 = this.f523602a.f396569d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r100.onCompletion();
        PlayerController r101 = this.f523602a;
        r101.f396572g = PlayerState.PAUSED;
        r101.b();
    }

    public e(PlayerController r100) {
        this.f523602a = r100;
    }
}

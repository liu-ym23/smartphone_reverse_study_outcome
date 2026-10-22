package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements qja.c.InterfaceC7343c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerController f523601a;

    @Override // qja.c.InterfaceC7343c
    public final void onFirstFrame() {
        tja.a r100 = this.f523601a.f396569d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r100.onFirstFrame();
    }

    public d(PlayerController r100) {
        this.f523601a = r100;
    }
}

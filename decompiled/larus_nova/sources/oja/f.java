package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements qja.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerController f523603a;

    @Override // qja.c.b
    public final void onError() {
        Intrinsics.checkNotNullParameter("", SocialConstants.PARAM_APP_DESC);
        PlayerController r100 = this.f523603a;
        int r101 = PlayerController.f396565n;
        r100.getClass();
        this.f523603a.b();
    }

    public f(PlayerController r100) {
        this.f523603a = r100;
    }
}

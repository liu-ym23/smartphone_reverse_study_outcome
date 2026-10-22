package com.bytedance.bdp.live.livecontainer.sonicgame;

import com.bytedance.android.live.broadcastgame.opengame.auth.OpenSonicAuthService;
import com.bytedance.android.live.broadcastgame.opengame.openapi.v;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.hostmethod.BdpInteractHostMethodService;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BdpInteractHostMethodService f201520a = null;

    static {
        f201520a = (BdpInteractHostMethodService) BdpManager.getInst().getService(BdpInteractHostMethodService.class);
    }

    public static void a(String r100, final v.a r101) {
        BdpInteractHostMethodService r102 = f201520a;
        if (r102 == null) goto L6;
        new SonicMethodManager$getAuthSetting$1(r101);
        r102.getSetting();
        return;
    }

    public static void b(String r100, final OpenSonicAuthService.a r101) {
        BdpInteractHostMethodService r102 = f201520a;
        if (r102 == null) goto L6;
        new SonicMethodManager$openAuthSetting$1(r101);
        r102.r2();
        return;
    }
}

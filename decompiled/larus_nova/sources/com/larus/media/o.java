package com.larus.media;

import com.bytedance.keva.Keva;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.f2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f359130a = null;

    static {
        f359130a = Keva.getRepo("sami_asr_env", 0);
    }

    public static boolean a() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        com.larus.home.impl.sdk.s r101 = r100.s0();
        if (r101 == null) goto L9;
        if (r101.H() != true) goto L9;
        boolean r102 = true;
    L11:
        if (f359130a.getBoolean("key_media_resource_management", r102) == true) goto L17;
        int r103 = f2.f365106a.getMediaRequestManagerConfig();
        FLogger.f375446a.i("OnMediaStateChangeListener", "mediaRequestManagerConfig:" + r103);
        if (r103 != 1) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L17;
        return false;
    L15:
        r104 = false;
    L17:
        return true;
    L9:
        r102 = false;
        goto L11
    }
}

package com.larus.home.impl.sdk;

import com.larus.audio.IAudioService;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.ivykit.forest.IObricForestService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f346177a = null;

    static {
        f346177a = new g();
    }

    public g() {
    }

    public final void a() {
        Intrinsics.checkNotNullParameter("DefaultActionSpeakTouchListener", "enterFrom");
    }

    public final Integer b() {
        IAudioService r100 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.A());
    }

    public final String c(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "channel");
        IFlowForestService r103 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);
        if (r103 == null) goto L5;
        String r104 = r103.b(r100, r101, r102);
    L6:
        if (r104 != null) goto L9;
        return "";
    L9:
        return r104;
    L5:
        r104 = null;
        goto L6
    }

    public final String d(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter("com_flow_obric", "channel");
        IObricForestService r103 = (IObricForestService) ServiceManager.get().getService(IObricForestService.class);
        if (r103 == null) goto L5;
        String r104 = r103.a(r100, r101, r102);
    L6:
        if (r104 != null) goto L9;
        return "";
    L9:
        return r104;
    L5:
        r104 = null;
        goto L6
    }
}

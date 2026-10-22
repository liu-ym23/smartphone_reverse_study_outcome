package com.larus.dora.impl.ota.g2;

import com.larus.dora.impl.assistant.AssistantWifiService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements s4 {
    private static final a Companion = null;
    public static final String TAG = "G2OtaTransport";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public c() {
    }

    @Override // com.larus.dora.impl.ota.g2.s4
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        AssistantWifiService r101 = (AssistantWifiService) ServiceManager.get().getService(AssistantWifiService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        com.larus.dora.impl.assistant.b r102 = r101.c(r100);
        StringBuilder r103 = new StringBuilder("release wifi owner=");
        r103.append(r100);
        r103.append(" success=");
        String r104 = null;
        if (r102 == null) goto L8;
        Boolean r105 = Boolean.valueOf(r102.f332036a);
    L9:
        r103.append(r105);
        r103.append(" error=");
        if (r102 == null) goto L12;
        r104 = r102.f332037b;
    L12:
        r103.append(r104);
        g49.d.d(TAG, r103.toString());
        return;
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.larus.dora.impl.ota.g2.s4
    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        AssistantWifiService r101 = (AssistantWifiService) ServiceManager.get().getService(AssistantWifiService.class);
        if (r101 != null) goto L6;
        g49.d.e(TAG, "enable wifi failed: assistant wifi service unavailable");
        return false;
    L6:
        com.larus.dora.impl.assistant.b r102 = r101.a(r100);
        g49.d.d(TAG, "enable wifi owner=" + r100 + " success=" + r102.f332036a + " error=" + r102.f332037b);
        return r102.f332036a;
    }
}

package com.larus.home.impl.sdk;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 implements com.larus.platform.api.k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a1 f346135a = null;

    static {
        f346135a = new a1();
    }

    public a1() {
    }

    @Override // com.larus.platform.api.k1
    public final boolean a(final com.larus.audio.w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "paramBuilder");
        long r101 = SAMICore.RegisterServerParamRequestCallback(new z0(r100));
        if (r101 != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        FLogger.f375446a.e("SamiServerParamServiceImpl", "RegisterServerParamRequestCallback failed, ret=" + r101);
    L8:
        return r102;
    L5:
        r102 = false;
        goto L6
    }
}

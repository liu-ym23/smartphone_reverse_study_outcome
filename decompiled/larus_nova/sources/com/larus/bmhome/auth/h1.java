package com.larus.bmhome.auth;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final class h1 {
    public static final i1 a() {
        AuthModelDelegate r100 = AuthModelDelegate.f297134b;
        c1<h0> r101 = r100.a().getValue();
        String r102 = null;
        if (r101 == null) goto L5;
        h0 r103 = r101.f295753d;
    L7:
        if (r103 == null) goto L12;
        String r104 = r103.h();
        TouristModeABParam r105 = r103.i();
        String r106 = r103.b();
        wc9.e r107 = r100.y().getValue();
        if (r107 == null) goto L11;
        r102 = r107.f559198a;
    L11:
        i1 r108 = new i1(r104, r105, r106, r102);
        FLogger.f375446a.d("TouristModeConfig", "getTouristModeConfig from current launch info  " + r108);
        return r108;
    L12:
        i1 r109 = LaunchCacheDelegate.f295726b.e();
        FLogger.f375446a.d("TouristModeConfig", "getTouristModeConfig from cache  " + r109);
        return r109;
    L5:
        r103 = null;
        goto L7
    }
}

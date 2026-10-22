package com.ss.android.common.applog;

import com.bytedance.bdinstall.Level;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class b0 implements com.bytedance.bdinstall.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0.b f408077a;

    public b0(c0.b r100) {
        this.f408077a = r100;
    }

    @Override // com.bytedance.bdinstall.d0
    public final HashMap<String, String> a(Level r100) {
        HashMap<String, String> r101 = new HashMap(c0.f408080b);
        if (r100 != Level.L0) goto L5;
        d0.c(c0.f408081c, r101);
    L5:
        c0.b r102 = this.f408077a;
        if (r102 == null) goto L10;
        HashMap<String, String> r103 = r102.getExtrparams(r100);
        if (r103 == null) goto L10;
        r101.putAll(r103);
    L10:
        return r101;
    }
}

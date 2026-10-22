package com.bytedance.ies.bullet.web.pia;

import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements j47.a {
    public h() {
    }

    @Override // j47.a
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Lazy<ArgusGlobalDelegate> r101 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r102 = ArgusGlobalDelegate.a.a();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(new InjectLoginStateParams(r100, InjectLoginStateParams.SceneType.PIA)).d();
    }
}

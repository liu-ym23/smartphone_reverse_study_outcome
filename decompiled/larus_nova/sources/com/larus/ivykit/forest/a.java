package com.larus.ivykit.forest;

import com.bytedance.geckox.GeckoGlobalConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends GeckoResourceLoader {
    public a(GeckoGlobalConfig.ENVType r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        pg9.e r101 = pg9.e.f529215a;
        String r102 = r101.a(r100);
        r101.getClass();
        super(r102, "offlineX");
    }
}

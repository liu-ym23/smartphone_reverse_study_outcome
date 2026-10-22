package com.larus.home.impl.sdk;

import android.net.Uri;
import com.bytedance.locallife.ILocalLifeService;
import com.larus.platform.api.w2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e0 implements w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f346163a = null;

    static {
        f346163a = new e0();
    }

    public e0() {
    }

    @Override // com.larus.platform.api.w2
    public final void a() {
        ILocalLifeService r100 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.platform.api.w2
    public final boolean b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        ILocalLifeService r101 = (ILocalLifeService) ServiceManager.get().getService(ILocalLifeService.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.b(r100);
    }
}

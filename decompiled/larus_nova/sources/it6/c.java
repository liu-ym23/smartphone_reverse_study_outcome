package it6;

import com.larus.live.api.ILiveService;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends com.bytedance.locallife.adapter.live.impl.host.live.e {
    @Override // com.bytedance.locallife.adapter.live.impl.host.live.e, it6.i
    public final boolean e() {
        boolean r100 = Intrinsics.areEqual(z2.f365865a.getLocalLifeConfig().d(), Boolean.TRUE);
        ILiveService r101 = (ILiveService) ServiceManager.get().getService(ILiveService.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == false) goto L11;
        if (r102 == false) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (r101.a() != true) goto L7;
        r102 = true;
        goto L8
    }

    public c() {
    }
}

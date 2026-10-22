package com.bytedance.bdp.live.livecontainer.sonicgame;

import com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadEntity;
import com.bytedance.bdp.serviceapi.defaults.log.BdpLogService;
import com.bytedance.bdp.serviceapi.defaults.platform.BdpPlatformService;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements a {
    public d() {
    }

    @Override // com.bytedance.bdp.live.livecontainer.sonicgame.a
    public final j a(String r100) {
        return new j(r100);
    }

    @Override // com.bytedance.bdp.live.livecontainer.sonicgame.a
    public final void b(String r100) {
        BdpLogService r101 = oa4.a.f522541a;
        oa4.a.f522541a.i("SonicGameService", "preload sonic game: " + r100);
        new BdpAppPreloadEntity(r100, 0);
        BdpPlatformService r102 = oa4.b.f522542a;
        new LinkedHashMap().put("plugin_name", "com.ss.android.ugc.aweme.miniapp");
        BdpPlatformService r103 = oa4.b.f522542a;
        if (r103 == null) goto L6;
        r103.y2();
        return;
    }
}

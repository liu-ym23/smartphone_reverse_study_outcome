package com.bytedance.android.livesdk.ktvimpl.base.util;

import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.multilink.service.host.IMultiLinkHostService;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static t61 a() {
        Lazy r0 = MultiLinkSettingHelper.a;
        if (((t61) r0.getValue()).getTotalSwitch() == true) goto L10;
        IMultiLinkHostService r1 = jc1.k.f(IMultiLinkHostService.class);
        if (r1 == null) goto L8;
        int r2 = ft2.a.a;
        return (t61) r1.getClientABValueByJsonString(new ClientABTestKey("live_multi_scene_panel_first_frame_opt_uid_config", String.class, "", 1), t61.class);
    L8:
        return null;
    L10:
        return (t61) r0.getValue();
    }

    static {
    }
}

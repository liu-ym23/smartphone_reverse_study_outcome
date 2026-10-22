package com.bytedance.locallife.poi.poidetail.container.ability.common;

import com.bytedance.locallife.poi.settings.IPoiSetting;
import com.ss.android.ugc.aweme.poi.perf.PoiRenderTaskConfig;
import com.ss.android.ugc.aweme.poi.settings.PoiSetting;
import kotlin.Pair;

/* JADX INFO: loaded from: classes21.dex */
public final class f {
    public f() {
    }

    public final Pair<String, PoiRenderTaskConfig> a() {
        PoiSetting r100 = IPoiSetting.a();
        if (r100 == null) goto L5;
        PoiRenderTaskConfig r101 = r100.r();
    L7:
        return new Pair("poi_detail_0vv_event", r101);
    L5:
        r101 = null;
        goto L7
    }
}

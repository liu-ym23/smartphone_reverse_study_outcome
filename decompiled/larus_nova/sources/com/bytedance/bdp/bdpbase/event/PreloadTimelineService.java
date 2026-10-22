package com.bytedance.bdp.bdpbase.event;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/bdp/bdpbase/event/PreloadTimelineService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "bdp-base_release"}, k = 1, mv = {1, 4, 0})
public interface PreloadTimelineService extends IBdpService {
    Pair<Integer, Boolean> G();
}

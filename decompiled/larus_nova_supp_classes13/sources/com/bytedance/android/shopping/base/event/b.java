package com.bytedance.android.shopping.base.event;

import com.bytedance.android.btm.api.model.PageFinder;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b {
    void appendEventParamToEntranceInfo(String r1, String r2);

    void appendEventParams(Map<String, ? extends Object> r1);

    void appendEventParams(Pair<String, ? extends Object>... r1);

    void clearEventParams();

    void doEventAction(String r1, PageFinder r2, Map<String, ? extends Object> r3);

    void doEventAction(String r1, PageFinder r2, Pair<String, ? extends Object>... r3);

    void doEventAction(String r1, Map<String, ? extends Object> r2);

    void doEventAction(String r1, Pair<String, ? extends Object>... r2);

    Map<String, Object> getEventParams();

    void initEventContext(Map<String, ? extends Object> r1);

    void initEventContext(Pair<String, ? extends Object>... r1);
}

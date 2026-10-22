package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.btm.api.model.PageFinder;
import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface h {
    void appendEventParams(Pair<String, ? extends Object>... r1);

    Map<String, Object> getEventParams();

    void o(String r1);

    void p(LinkedTreeMap r1);

    void q(String r1, PageFinder r2, Map<String, ? extends Object> r3);
}

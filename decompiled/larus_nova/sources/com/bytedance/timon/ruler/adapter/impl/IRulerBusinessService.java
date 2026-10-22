package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.base.models.f;
import com.bytedance.timonbase.ITMBusinessService;
import java.util.Map;
import kotlin.Metadata;
import v97.b;
import v97.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/IRulerBusinessService;", "Lcom/bytedance/timonbase/ITMBusinessService;", "ruler-adapter-api_release"}, k = 1, mv = {1, 4, 0})
public interface IRulerBusinessService extends ITMBusinessService {
    void a(d<?> r100);

    f b(Map<String, ?> r100);

    void c(b r100);

    String d();
}

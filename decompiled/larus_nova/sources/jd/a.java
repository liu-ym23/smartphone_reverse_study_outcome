package jd;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, am3.c> f498190a = null;

    static {
        HashMap r100 = new HashMap();
        f498190a = r100;
        r100.put(TraceTimeMetricV2.class, new com.bytedance.android.ec.adapter.api.messagev2.model.a());
        r100.put(TraceTimeMetric.class, new de.c());
        r100.put(UpdatedCartInfo.class, new com.bytedance.android.ec.adapter.api.message.model.a());
        r100.put(UpdatedCartInfo.RoomCartStateVertical.class, new com.bytedance.android.ec.adapter.api.message.model.c());
        r100.put(UpdatedCartInfo.RoomCartStateHorizontal.class, new com.bytedance.android.ec.adapter.api.message.model.b());
        r100.put(ve.a.class, new ve.b());
        r100.put(com.bytedance.android.ec.adapter.impl.messagev2.a.class, new com.bytedance.android.ec.adapter.impl.messagev2.b());
    }
}

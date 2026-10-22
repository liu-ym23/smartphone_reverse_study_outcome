package com.bytedance.bdlocation.continuous;

import com.bytedance.bdlocation.bridge.PlatformLoggerDelegate;
import com.bytedance.bdlocation.bridge.PlatformTrackerDelegate;
import com.bytedance.bdlocation.bridge.TrackerBoolValue;
import com.bytedance.bdlocation.bridge.TrackerDoubleMetricValue;
import com.bytedance.bdlocation.bridge.TrackerDoubleValue;
import com.bytedance.bdlocation.bridge.TrackerIntMetricValue;
import com.bytedance.bdlocation.bridge.TrackerIntValue;
import com.bytedance.bdlocation.bridge.TrackerMetricValue;
import com.bytedance.bdlocation.bridge.TrackerStringValue;
import com.bytedance.bdlocation.bridge.TrackerValue;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J \u0010\u000e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionPlatformDelegates;", "", "()V", "TAG", "", "createLoggerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformLoggerDelegate;", "createTrackerDelegate", "Lcom/bytedance/bdlocation/bridge/PlatformTrackerDelegate;", "toTrackerMetricJson", "Lorg/json/JSONObject;", "values", "", "Lcom/bytedance/bdlocation/bridge/TrackerMetricValue;", "toTrackerValueJson", "Lcom/bytedance/bdlocation/bridge/TrackerValue;", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionPlatformDelegates {
    public static final ByteFusionPlatformDelegates INSTANCE = null;
    private static final String TAG = "ByteFusionContinuous";

    private ByteFusionPlatformDelegates() {
    }

    static {
        INSTANCE = new ByteFusionPlatformDelegates();
    }

    public final PlatformLoggerDelegate createLoggerDelegate() {
        return new AnonymousClass1();
    }

    public final PlatformTrackerDelegate createTrackerDelegate() {
        return new C03471();
    }

    private final JSONObject toTrackerMetricJson(Map<String, ? extends TrackerMetricValue> r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return null;
    L11:
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, ? extends TrackerMetricValue>> r8 = r7.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L21;
        Map.Entry<String, ? extends TrackerMetricValue> r2 = r8.next();
        String r3 = r2.getKey();
        TrackerMetricValue r4 = r2.getValue();
        if ((r4 instanceof TrackerIntMetricValue) == true) goto L16;
        if ((r4 instanceof TrackerDoubleMetricValue) == true) goto L19;
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, r4.toString());
        goto L13
    L19:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, Double.valueOf(((TrackerDoubleMetricValue) r4).value));
        goto L13
    L16:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, Long.valueOf(((TrackerIntMetricValue) r4).value));
        goto L13
    L21:
        return r1;
    L4:
        if (r7.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }

    private final JSONObject toTrackerValueJson(Map<String, ? extends TrackerValue> r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return null;
    L11:
        JSONObject r1 = new JSONObject();
        Iterator<Map.Entry<String, ? extends TrackerValue>> r8 = r7.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L27;
        Map.Entry<String, ? extends TrackerValue> r2 = r8.next();
        String r3 = r2.getKey();
        TrackerValue r4 = r2.getValue();
        if ((r4 instanceof TrackerStringValue) == true) goto L16;
        if ((r4 instanceof TrackerIntValue) == true) goto L19;
        if ((r4 instanceof TrackerDoubleValue) == true) goto L22;
        if ((r4 instanceof TrackerBoolValue) == true) goto L25;
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, r4.toString());
        goto L13
    L25:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, Boolean.valueOf(((TrackerBoolValue) r4).value));
        goto L13
    L22:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, Double.valueOf(((TrackerDoubleValue) r4).value));
        goto L13
    L19:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, Long.valueOf(((TrackerIntValue) r4).value));
        goto L13
    L16:
        ByteFusionJsonUtils.INSTANCE.putSafe(r1, r3, ((TrackerStringValue) r4).value);
        goto L13
    L27:
        return r1;
    L4:
        if (r7.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }

    public static final /* synthetic */ JSONObject access$toTrackerMetricJson(ByteFusionPlatformDelegates r0, Map r1) {
        return r0.toTrackerMetricJson(r1);
    }

    public static final /* synthetic */ JSONObject access$toTrackerValueJson(ByteFusionPlatformDelegates r0, Map r1) {
        return r0.toTrackerValueJson(r1);
    }
}

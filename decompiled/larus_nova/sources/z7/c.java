package z7;

import com.bytedance.android.monitorV2.listener.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements f {
    public c() {
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventCreated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventSampled(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventTerminated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventUploaded(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventUpdated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
        if (Intrinsics.areEqual(r100.f163023a, "performance") == false) goto L5;
    L6:
        ConcurrentHashMap<String, com.bytedance.android.monitorV2.event.c> r101 = e.f570636a;
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r102 = r100.f163026d.get("containerBase");
        String r103 = null;
        if ((r102 instanceof JSONObject) == false) goto L9;
        JSONObject r104 = (JSONObject) r102;
    L10:
        if (r104 == null) goto L14;
        JSONArray r105 = r104.optJSONArray("container_ids");
        if (r105 == null) goto L14;
        r103 = r105.optString(0);
    L14:
        if (r103 != null) goto L16;
        return;
    L16:
        if ((!StringsKt.isBlank(r103)) == false) goto L21;
        e.f570636a.put(r103, r100);
        return;
    L21:
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        if (Intrinsics.areEqual(r100.f163023a, PerfLog.TAG_PERF) == true) goto L6;
    }
}

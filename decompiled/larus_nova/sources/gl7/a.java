package gl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.ConfigStatus;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import ok7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogGetTaskFullRoadConfig", owner = "maochangtong")
public final class a extends ok7.a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogGetTaskFullRoadConfig";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public a() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (j.f271711b != ConfigStatus.ReadyAndOpen.getStatus()) goto L5;
        boolean r103 = true;
    L6:
        r102.put(MapMonitorConst.IS_ENABLE, Boolean.valueOf(r103));
        ArrayList<String> r104 = j.f271712c;
        if (r104 != null) goto L10;
        r104 = new ArrayList();
    L10:
        r102.put("global_task_id_list", r104);
        onSuccess(r101, r102, "success");
        return;
    L5:
        r103 = false;
        goto L6
    }
}

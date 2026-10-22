package gl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.f;
import com.bytedance.ug.sdk.luckydog.api.task.taskmanager.j;
import java.util.LinkedHashMap;
import java.util.Map;
import ok7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogGetTaskFullRoadParams", owner = "maochangtong")
public final class b extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481598a;

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public b() {
        this.f481598a = "luckydogGetTaskFullRoadParams";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f481598a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        boolean r102 = s.b(r100, "is_begin_event", false);
        String r103 = s.f(r100, "global_task_id", "");
        Map<String, Object> r104 = new LinkedHashMap();
        f r105 = j.e(r102, r103);     // Catch: Throwable -> L8
        if (r105 == null) goto L6;
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L8
        r106.putAll(r105.a());     // Catch: Throwable -> L8
        r104.put("full_road_params", r106);     // Catch: Throwable -> L8
        j.c(r103, false);     // Catch: Throwable -> L8
        d.d("TaskFullPathManager", "前端成功获取全链路参数: " + r105);     // Catch: Throwable -> L8
    L6:
        onSuccess(r101, r104, "success");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        d.b("LuckyTaskFullRoadXBridge", th.getLocalizedMessage());
        onSuccess(r101, r104, "occur error");
    }
}

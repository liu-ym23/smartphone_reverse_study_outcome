package vv0;

import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.config.iz0;
import com.bytedance.common.utility.Logger;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements sv0.a {
    public c() {
    }

    @Override // sv0.a
    public final void a(String r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = r101.optString("mode", "");
        if (Intrinsics.areEqual(r102, "push") == false) goto L7;
        return;
    L7:
        int r103 = 1;
        if ((!Intrinsics.areEqual("live_client_monitor_log", r100)) == false) goto L27;
        ((IHostMonitor) k.n(IHostMonitor.class)).monitorCommonLog(r100, r101);
        return;
    L27:
    L24:
        e = move-exception;
        Logger.e("uploadLog", e.getMessage());
        return;
    L12:
        if (Intrinsics.areEqual("live_client_monitor_log", r100) == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual("rtc", r102) == false) goto L30;
        boolean r104 = n3.h();     // Catch: Exception -> L24
        if (iz0.f120490a.getValue().booleanValue() == true) goto L19;
        if (r104 == true) goto L22;
        r103 = 0;
    L22:
        r101.put("live_message_fetch_type", r103);     // Catch: Exception -> L24
        ((IHostMonitor) k.n(IHostMonitor.class)).monitorCommonLog(r100, r101);     // Catch: Exception -> L24
        return;
    L19:
        if (r104 == true) goto L21;
        r103 = 2;
        goto L22
    L21:
        r103 = 3;
        goto L22
    }
}

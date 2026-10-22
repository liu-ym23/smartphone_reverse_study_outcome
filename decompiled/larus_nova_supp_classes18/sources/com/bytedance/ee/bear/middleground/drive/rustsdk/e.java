package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.MonitorCallback;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements com.ss.android.lark.sdk.g.b {
    public e() {
    }

    public final void a(byte[] r4) {
        MonitorCallback r5 = (MonitorCallback) MonitorCallback.ADAPTER.decode(r4);     // Catch: Exception -> L5
    L7:
        if (r5 != null) goto L10;
        tt5.a.d("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic dispatch: data is null");
        return;
    L10:
        tt5.a.h("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic dispatch: event: " + r5.event);
        HashMap r0 = new HashMap(r5.params);
        String r6 = r5.event;
        if (r0.size() <= 0) goto L16;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v(r6, r0);
        return;
    L16:
        return;
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic parse: ", e, false);
        r5 = null;
        goto L7
    }
}

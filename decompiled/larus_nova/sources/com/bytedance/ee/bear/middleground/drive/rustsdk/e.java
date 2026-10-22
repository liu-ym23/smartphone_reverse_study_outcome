package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.MonitorCallback;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements com.ss.android.lark.sdk.g.b {
    public e() {
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        MonitorCallback r101 = MonitorCallback.ADAPTER.decode(r100);     // Catch: Exception -> L5
    L7:
        if (r101 != null) goto L10;
        tt5.a.d("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic dispatch: data is null");
        return;
    L10:
        tt5.a.h("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic dispatch: event: " + r101.event);
        HashMap r102 = new HashMap(r101.params);
        String r103 = r101.event;
        if (r102.size() <= 0) goto L16;
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v(r103, r102);
        return;
    L16:
        return;
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustAnalytic", "DriveRustAnalytic parse: ", e, false);
        r101 = null;
        goto L7
    }
}

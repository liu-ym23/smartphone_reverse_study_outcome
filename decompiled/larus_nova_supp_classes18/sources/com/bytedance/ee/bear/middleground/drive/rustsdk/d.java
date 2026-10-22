package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.NetworkLevel;
import com.bytedance.lark.pb.basic.v1.DynamicNetStatusResponse;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements com.ss.android.lark.sdk.g.b, com.bytedance.ee.bear.lark.dependency.w.a {
    public NetworkLevel a;

    public d() {
        this.a = NetworkLevel.EXCELLENT;
    }

    public final void a(byte[] r3) {
        this.a = NetworkLevel.forNumber(((DynamicNetStatusResponse) DynamicNetStatusResponse.ADAPTER.decode(r3)).net_status.getValue());     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        tt5.a.d("Middleground_Drive_DriveNetStateListener", "onPushNetLevel parser failed:" + e.getMessage());
    }
}

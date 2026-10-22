package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.ee.bear.middleground.drive.export.NetworkLevel;
import com.bytedance.lark.pb.basic.v1.DynamicNetStatusResponse;
import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements com.ss.android.lark.sdk.g.b, com.bytedance.ee.bear.lark.dependency.w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NetworkLevel f232566a;

    public d() {
        this.f232566a = NetworkLevel.EXCELLENT;
    }

    @Override // com.ss.android.lark.sdk.g.b
    public final void a(byte[] r100) {
        this.f232566a = NetworkLevel.forNumber(DynamicNetStatusResponse.ADAPTER.decode(r100).net_status.getValue());     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        tt5.a.d("Middleground_Drive_DriveNetStateListener", "onPushNetLevel parser failed:" + e.getMessage());
    }
}

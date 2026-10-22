package com.bytedance.ee.bear.drive.biz.external;

import com.bytedance.ee.bear.contract.NetService;
import d55.b0;
import d55.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements b {
    public final com.bytedance.ee.bear.drive.biz.permission.f a;

    public h() {
        this.a = new com.bytedance.ee.bear.drive.biz.permission.f((NetService) org.koin.java.a.a(NetService.class));
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.b
    public final void a(a r4, final f.a r5) {
        tt5.a.h("DRIVE_PREVIEW_FLOW", "ThirdPartyExportPermissionChecker check");
        this.a.a(r4.a, r4.c, r4.d).subscribe(new b0(r5), new c0(r5));
    }
}

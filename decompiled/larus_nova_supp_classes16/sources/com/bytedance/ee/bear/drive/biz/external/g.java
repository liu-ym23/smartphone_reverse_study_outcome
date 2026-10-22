package com.bytedance.ee.bear.drive.biz.external;

import d55.a0;
import d55.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements b {
    public g() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.b
    public final void a(a r3, final f.a r4) {
        tt5.a.h("DRIVE_PREVIEW_FLOW", "SpaceKitExportPermissionChecker check");
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).aa().c(r3.a, sbb.e.l.b).subscribe(new z(r4), new a0(r4));
    }
}

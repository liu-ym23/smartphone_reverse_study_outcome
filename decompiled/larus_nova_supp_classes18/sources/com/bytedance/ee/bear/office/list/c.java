package com.bytedance.ee.bear.office.list;

import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.office.export.space.i {
    public final /* synthetic */ OfficeFolderDetailHostFragment a;

    @Override // com.bytedance.ee.bear.office.export.space.i
    public final com.bytedance.ee.bear.office.export.space.h a() {
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r0 = com.bytedance.ee.bear.office.export.space.m.a;
        OfficeFolderDetailHostFragment r1 = this.a;
        int r2 = OfficeFolderDetailHostFragment.t;
        return com.bytedance.ee.bear.office.export.space.m.a(r1.Z90());
    }

    public c(OfficeFolderDetailHostFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.office.export.space.i
    public final OfficeSpaceActionResult b(OfficeSpaceHeaderAction r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        OfficeFolderDetailHostFragment r0 = this.a;
        int r1 = OfficeFolderDetailHostFragment.t;
        return r0.U90(r3);
    }
}

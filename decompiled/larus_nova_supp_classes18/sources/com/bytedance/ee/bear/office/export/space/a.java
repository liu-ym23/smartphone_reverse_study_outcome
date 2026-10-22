package com.bytedance.ee.bear.office.export.space;

import com.bytedance.ee.bear.office.list.OfficeFolderDetailHostFragment;
import com.bytedance.ee.bear.office.space.OfficeSpaceFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    OfficeSpacePreloadHandle a(OfficeSpacePreloadRequest r1);

    void b(String r1);

    OfficeSpaceFragment c(OfficeSpaceConfig r1, h r2, OfficeSpaceEnterContext r3);

    void d(String r1, String r2, com.larus.drive.sdk.impl.view.preview.b r3);

    OfficeFolderDetailHostFragment e(OfficeFolderPageRequest r1, h r2);

    void f();

    void g(OfficeSpacePreloadCancelReason r1);

    OfficeSpaceFragment h(OfficeSpaceConfig r1, h r2);
}

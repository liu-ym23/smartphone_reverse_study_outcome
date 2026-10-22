package com.bytedance.ee.bear.office.export.space;

import com.bytedance.ee.bear.office.list.OfficeFolderDetailHostFragment;
import com.bytedance.ee.bear.office.space.OfficeSpaceFragment;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    OfficeSpacePreloadHandle a(OfficeSpacePreloadRequest r100);

    void b(String r100);

    OfficeSpaceFragment c(OfficeSpaceConfig r100, h r101, OfficeSpaceEnterContext r102);

    void d(String r100, String r101, com.larus.drive.sdk.impl.view.preview.b r102);

    OfficeFolderDetailHostFragment e(OfficeFolderPageRequest r100, h r101);

    void f();

    void g(OfficeSpacePreloadCancelReason r100);

    OfficeSpaceFragment h(OfficeSpaceConfig r100, h r101);
}

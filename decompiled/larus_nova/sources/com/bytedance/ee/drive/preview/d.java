package com.bytedance.ee.drive.preview;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes16.dex */
public interface d {
    Fragment Ae(DrivePreviewOpenRequest r100, List<? extends i> r101, hk5.a r102, com.bytedance.ee.bear.container.f r103);

    a85.c Jd();

    @Deprecated(message = "use openPreviewFragment(request: DrivePreviewOpenRequest) instead")
    Fragment Z5(String r100, hk5.a r101, com.bytedance.ee.bear.container.f r102);

    void k1(o r100);

    o l6();

    DrivePreviewOpenRequest o9(DrivePreviewOpenRequest r100);

    a85.a u8();

    a85.b y7();
}

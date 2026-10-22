package com.bytedance.ee.drive.preview;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.o;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d {
    Fragment Ae(DrivePreviewOpenRequest r1, List<? extends i> r2, hk5.a r3, com.bytedance.ee.bear.container.f r4);

    a85.c Jd();

    @Deprecated(message = "use openPreviewFragment(request: DrivePreviewOpenRequest) instead")
    Fragment Z5(String r1, hk5.a r2, com.bytedance.ee.bear.container.f r3);

    void k1(o r1);

    o l6();

    DrivePreviewOpenRequest o9(DrivePreviewOpenRequest r1);

    a85.a u8();

    a85.b y7();
}

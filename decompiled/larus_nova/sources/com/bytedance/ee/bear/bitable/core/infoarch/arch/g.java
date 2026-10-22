package com.bytedance.ee.bear.bitable.core.infoarch.arch;

import com.bytedance.ee.bear.bitable.infoarch.toolbar.BitableToolbarContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {
    public static final void a(SceneModel r100, BitableToolbarContainer r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "toolbarContainer");
        if (r100.hideToolbar() == false) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }
}

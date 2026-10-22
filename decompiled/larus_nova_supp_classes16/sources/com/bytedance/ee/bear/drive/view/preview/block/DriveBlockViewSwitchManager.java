package com.bytedance.ee.bear.drive.view.preview.block;

import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import h95.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveBlockViewSwitchManager {
    public final ViewOwner a;
    public final DriveBlockPreviewVM b;

    public static final class a {
    }

    static {
    }

    public DriveBlockViewSwitchManager(ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "viewOwner");
        this.a = r2;
        this.b = (DriveBlockPreviewVM) r2.viewModel(DriveBlockPreviewVM.class);
    }

    public final void a(final b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (this.b.getLiveBlockState().getValue() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        tt5.a.h("DriveBlockViewSwitchManager", "observeBlockState current is not in block");
        return;
    L9:
        ((DriveViewModel) this.a.viewModel(DriveViewModel.class)).livePreviewType().observe(this.a.lifecycleOwner(), new DriveBlockViewSwitchManager$observeBlockState$1(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }
}

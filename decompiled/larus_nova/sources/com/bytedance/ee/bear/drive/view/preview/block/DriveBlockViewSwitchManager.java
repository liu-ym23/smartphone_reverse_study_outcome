package com.bytedance.ee.bear.drive.view.preview.block;

import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import h95.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveBlockViewSwitchManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewOwner f224777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DriveBlockPreviewVM f224778b;

    public static final class a {
    }

    static {
    }

    public DriveBlockViewSwitchManager(ViewOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "viewOwner");
        this.f224777a = r100;
        this.f224778b = (DriveBlockPreviewVM) r100.viewModel(DriveBlockPreviewVM.class);
    }

    public final void a(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f224778b.getLiveBlockState().getValue() == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        tt5.a.h("DriveBlockViewSwitchManager", "observeBlockState current is not in block");
        return;
    L9:
        ((DriveViewModel) this.f224777a.viewModel(DriveViewModel.class)).livePreviewType().observe(this.f224777a.lifecycleOwner(), new DriveBlockViewSwitchManager$observeBlockState$1(r100));
        return;
    L5:
        r101 = false;
        goto L6
    }
}

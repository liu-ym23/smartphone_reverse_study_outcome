package com.ss.android.lark.cameraview;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.camera_export.CameraFG;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f410877b;

    public c1(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        int r101 = r100.getWindowManager().getDefaultDisplay().getRotation();
        int r102 = 0;
        if (r101 != 0) goto L5;
    L14:
        int r103 = 0;
    L16:
        if (CameraFG.getEnableAdaptPadAndFoldable() == true) goto L19;
        r102 = r103;
    L19:
        this.f410876a = r102;
        this.f410877b = r103;
        return;
    L5:
        if (r101 != 1) goto L7;
        r103 = 90;
        goto L16
    L7:
        if (r101 != 2) goto L9;
        r103 = 180;
        goto L16
    L9:
        if (r101 != 3) goto L14;
        r103 = 270;
        goto L16
    }
}

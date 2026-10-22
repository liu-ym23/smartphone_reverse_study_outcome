package com.bytedance.ies.bullet.ui.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class g implements h16.c {
    public g() {
    }

    @Override // h16.c
    public final void onStart(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void onStop(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void a(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void b(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void onCreate(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void onWindowFocusChanged(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void onActivityResult(Activity r100, int r101, int r102, Intent r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // h16.c
    public final void onRequestPermissionsResult(Activity r100, int r101, String[] r102, int[] r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r102, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "grantResults");
        throw new YieldError("An operation is not implemented");
    }
}

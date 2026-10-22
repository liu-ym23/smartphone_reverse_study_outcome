package com.bytedance.bdturing.livedetect;

import android.widget.Toast;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements TuringBaseLiveDetectActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringLiveDetectActivity f201907a;

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void f1() {
        this.f201907a.finish();
    }

    public c(TuringLiveDetectActivity r100) {
        this.f201907a = r100;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void G(int r100) {
        TuringLiveDetectActivity.G1(this.f201907a);
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void U0(int r100) {
        if (r100 != 1) goto L6;
        Toast.makeText(this.f201907a, "为确保功能正常，请授予摄像头权限", 0).show();
    L8:
        this.f201907a.finish();
        return;
    L6:
        if (r100 != 2) goto L8;
        Toast.makeText(this.f201907a, "为确保功能正常，请到设置中开启摄像头权限", 0).show();
        goto L8
    }
}

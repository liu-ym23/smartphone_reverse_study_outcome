package com.bytedance.bdturing.livedetect;

import android.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements TuringBaseLiveDetectActivity.a {
    public final /* synthetic */ TuringLiveDetectActivity a;

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void f1() {
        this.a.finish();
    }

    public c(TuringLiveDetectActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void G(int r1) {
        TuringLiveDetectActivity.G1(this.a);
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.a
    public final void U0(int r3) {
        if (r3 != 1) goto L6;
        Toast.makeText(this.a, "为确保功能正常，请授予摄像头权限", 0).show();
    L8:
        this.a.finish();
        return;
    L6:
        if (r3 != 2) goto L8;
        Toast.makeText(this.a, "为确保功能正常，请到设置中开启摄像头权限", 0).show();
        goto L8
    }
}

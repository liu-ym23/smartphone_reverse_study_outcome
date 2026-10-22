package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.c {
    public final /* synthetic */ VideoCoverLayout a;

    public final void onLoadSuccess() {
        dm.a.a("VideoCoverLayout").i("initVideoCtrlContainerComponent onLoadSuccess");
        VideoCoverLayout r0 = this.a;
        r0.a = true;
        VideoCoverLayout.b(r0);
    }

    public g(VideoCoverLayout r1) {
        this.a = r1;
    }

    public final void a(String r4) {
        dm.a.a("VideoCoverLayout").b("initVideoCtrlContainerComponent onLoadFailed errMsg=" + r4, null);
        VideoCoverLayout r5 = this.a;
        r5.a = false;
        VideoCoverLayout.a(r5);
    }
}

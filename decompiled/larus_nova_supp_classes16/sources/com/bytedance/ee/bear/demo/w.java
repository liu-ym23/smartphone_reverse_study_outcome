package com.bytedance.ee.bear.demo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w extends com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a {
    public final /* synthetic */ CCMImageDemoActivity a;

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void onCompleted() {
        CCMImageDemoActivity r0 = this.a;
        int r1 = CCMImageDemoActivity.e;
        r0.B1("local image load completed\n");
    }

    public w(CCMImageDemoActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "openType");
        int r1 = CCMImageDemoActivity.e;
        this.a.B1("local image first frame ready: " + r4 + '\n');
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void b(String r1, Throwable r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "openType");
        Intrinsics.checkNotNullParameter(r2, "throwable");
        CCMImageDemoActivity r5 = this.a;
        String r6 = "local image load error: " + r2.getLocalizedMessage() + '\n';
        int r7 = CCMImageDemoActivity.e;
        r5.B1(r6);
    }
}

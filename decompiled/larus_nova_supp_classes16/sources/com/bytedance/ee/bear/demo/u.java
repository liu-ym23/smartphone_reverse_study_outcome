package com.bytedance.ee.bear.demo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u extends com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a {
    public final /* synthetic */ CCMFolderDemoActivity a;

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void onCompleted() {
        this.a.C1("local image load completed\n");
    }

    public u(CCMFolderDemoActivity r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "openType");
        this.a.C1("local image first frame ready: " + r4 + '\n');
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void b(String r1, Throwable r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "openType");
        Intrinsics.checkNotNullParameter(r2, "throwable");
        this.a.C1("local image load error: " + r2.getLocalizedMessage() + '\n');
    }
}

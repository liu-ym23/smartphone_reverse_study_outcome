package com.bytedance.ee.bear.demo;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class x extends com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CCMImageDemoActivity f217581a;

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void onCompleted() {
        CCMImageDemoActivity r100 = this.f217581a;
        int r101 = CCMImageDemoActivity.f217501e;
        r100.B1("OfficePhotoView load completed\n");
    }

    public x(CCMImageDemoActivity r100) {
        this.f217581a = r100;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b.a, com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openType");
        int r101 = CCMImageDemoActivity.f217501e;
        this.f217581a.B1("OfficePhotoView first frame: " + r100 + '\n');
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.imageviewer.b
    public final void b(String r100, Throwable r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "openType");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        CCMImageDemoActivity r104 = this.f217581a;
        String r105 = "OfficePhotoView error: " + r101.getLocalizedMessage() + '\n';
        int r106 = CCMImageDemoActivity.f217501e;
        r104.B1(r105);
    }
}

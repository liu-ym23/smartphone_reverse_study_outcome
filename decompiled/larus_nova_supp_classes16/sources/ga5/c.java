package ga5;

import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements a {
    public final VideoView a;
    public final z b;
    public final PreviewViewModel c;
    public final DriveViewFullScreenVM d;
    public final boolean e;

    @Override // ga5.a
    public final boolean onBackPress() {
        com.bytedance.ee.bear.drive.biz.preview.screen.a r0 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) this.d.liveOuterFullScreenSate.getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (this.a.o() == true) goto L7;
        return false;
    L7:
        if (r0.a == false) goto L9;
        this.a.x();
        return false;
    L9:
        this.a.f();
        return false;
    }

    @Override // ga5.a
    public final void onClick() {
        PreviewViewModel r0 = this.c;
        if (r0 == null) goto L14;
        r0.liveInnerToggleFullScreen().postValue(this.b.c);
        int r1 = this.a.getBarsShowState();
        tt5.a.h("DRIVE_VideoPlayer", "horizon video bars show mode " + r1);
        if (this.e == false) goto L7;
        return;
    L7:
        if (r1 != 0) goto L9;
        this.a.f();
        return;
    L9:
        if (r1 != 1) goto L16;
        this.a.x();
        return;
    L16:
        return;
    }

    public c(VideoView r2, ViewOwner r3, z r4) {
        Intrinsics.checkNotNullParameter(r2, "videoView");
        Intrinsics.checkNotNullParameter(r3, "viewOwner");
        Intrinsics.checkNotNullParameter(r4, "previewFileModel");
        this.a = r2;
        this.b = r4;
        this.c = (PreviewViewModel) r3.viewModel(PreviewViewModel.class);
        this.d = (DriveViewFullScreenVM) r3.viewModel(DriveViewFullScreenVM.class);
        this.e = com.bytedance.ee.bear.appsetting.c.a.a.h("spacekit.mobile.drive_fullscreen_animation");
    }
}

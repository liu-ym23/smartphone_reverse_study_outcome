package ga5;

import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements a {
    public final VideoView a;
    public final ViewOwner b;
    public final z c;

    @Override // ga5.a
    public final boolean onBackPress() {
        if (this.a == null) goto L15;
        tt5.a.h("DRIVE_VideoPlayer", "onBackPressed, current play mode " + this.a.getCurrentPlayMode());
        if (this.a.getCurrentPlayMode() != 1) goto L15;
        this.a.e.g();
        if (this.a.o() == false) goto L15;
        h65.a r0 = this.a.L;     // Catch: Exception -> L12
        if (r0 == null) goto L14;
        r0.c.a(r0.b);     // Catch: Exception -> L12
    L14:
        return true;
    L12:
        e = move-exception;
        tt5.a.e("DRIVE_VideoPlayer", "mVideoPlayer.exitFullScreen error", e, false);
    L15:
        return false;
    }

    @Override // ga5.a
    public final void onClick() {
        ((PreviewViewModel) this.b.viewModel(PreviewViewModel.class)).liveInnerToggleFullScreen().postValue(this.c.c);
        int r0 = this.a.getBarsShowState();
        tt5.a.h("DRIVE_VideoPlayer", "horizon video bars show mode " + r0);
        if (r0 != 0) goto L5;
        this.a.f();
        return;
    L5:
        if (r0 != 1) goto L11;
        this.a.x();
        return;
    }

    public b(VideoView r2, ViewOwner r3, z r4) {
        Intrinsics.checkNotNullParameter(r2, "videoView");
        Intrinsics.checkNotNullParameter(r3, "viewOwner");
        Intrinsics.checkNotNullParameter(r4, "previewFileModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}

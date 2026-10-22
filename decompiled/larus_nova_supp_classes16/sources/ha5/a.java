package ha5;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public final ViewOwner a;

    public a(ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "viewOwner");
        this.a = r2;
    }

    @Override // ha5.b
    public final void a(VideoView r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r4.getCurrentPlayMode() != 0) goto L6;
        return;
    L6:
        if (((PreviewViewModel) this.a.viewModel(PreviewViewModel.class)) != null) goto L8;
    L22:
        tt5.a.d("DRIVE_VideoPlayer", "exit full screen failed, mCommunication == null?");
        return;
    L8:
        if (com.bytedance.ee.util.ui.b.b(r4.getContext()) == false) goto L22;
        r4.setCurrentPlayModeOrientation(0);
        r4.q();
        VideoPlayerControllerView r1 = r4.e;
        if (r1 == null) goto L13;
        r1.k(r4.getCurrentPlayMode());
        VideoPlayerControllerView r2 = r4.e;
        r2.w = false;
        r2.d.setVideoControlBarClearScreen(false);
        r2.q();
        r2.B.d();
    L13:
        Context r5 = r4.getContext();
        if (r5 != null) goto L16;
        return;
    L16:
        if ((r5 instanceof Activity) == false) goto L25;
        Activity r6 = (Activity) r5;
        int r3 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(r6) == false) goto L20;
        r6.setRequestedOrientation(1);
        return;
    L20:
        r6.setRequestedOrientation(0);
        return;
    }

    @Override // ha5.b
    public final void b(VideoView r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if (r5.getCurrentPlayMode() != 1) goto L7;
        tt5.a.h("DRIVE_VideoPlayer", "current mode is full screen, exit");
        return;
    L7:
        if (((PreviewViewModel) this.a.viewModel(PreviewViewModel.class)) != null) goto L9;
    L23:
        tt5.a.d("DRIVE_VideoPlayer", "enter full screen failed, mCommunication == null?");
        return;
    L9:
        if (com.bytedance.ee.util.ui.b.b(r5.getContext()) == false) goto L23;
        r5.setCurrentPlayModeOrientation(1);
        VideoPlayerControllerView r0 = r5.e;
        if (r0 == null) goto L14;
        r0.k(r5.getCurrentPlayMode());
    L14:
        r5.q();
        Context r6 = r5.getContext();
        if (r6 != null) goto L17;
        return;
    L17:
        if ((r6 instanceof Activity) == false) goto L26;
        Activity r7 = (Activity) r6;
        int r1 = com.bytedance.ee.bear.drive.biz.preview.orientation.a.a;
        if (com.bytedance.ee.bear.drive.biz.preview.orientation.a.C0152a.a(r7) == false) goto L21;
        r7.setRequestedOrientation(1);
        return;
    L21:
        r7.setRequestedOrientation(0);
        return;
    }
}

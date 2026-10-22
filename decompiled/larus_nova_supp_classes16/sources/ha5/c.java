package ha5;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.view.preview.block.DriveBlockPreviewVM;
import com.bytedance.ee.bear.drive.view.preview.video.VideoPlayerControllerView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements ha5.b {
    public final ViewOwner a;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ VideoView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public b(VideoView r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoView r0 = this.a;     // Catch: Throwable -> L4
            r0.onSizeChanged(this.b, this.c, r0.getWidth(), this.a.getHeight());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: ha5.c$c, reason: collision with other inner class name */
    public static final class RunnableC0237c implements Runnable {
        public final /* synthetic */ VideoView a;
        public final /* synthetic */ ViewGroup b;

        public RunnableC0237c(VideoView r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoView r0 = this.a;     // Catch: Throwable -> L4
            r0.onSizeChanged(r0.getWidth(), this.a.getHeight(), this.b.getWidth(), this.b.getHeight());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(ViewOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "viewOwner");
        this.a = r2;
    }

    @Override // ha5.b
    public final void a(VideoView r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if (r6.getCurrentPlayMode() != 0) goto L5;
        return;
    L5:
        PreviewViewModel r0 = (PreviewViewModel) this.a.viewModel(PreviewViewModel.class);
        if (r0 != null) goto L8;
    L24:
        tt5.a.d("DRIVE_VideoPlayer", "exit full screen failed, mCommunication == null?");
        return;
    L8:
        if (com.bytedance.ee.util.ui.b.b(r6.getContext()) == false) goto L24;
        r0.liveInnerVideoFullScreen().setValue(Boolean.FALSE);
        Context r1 = r6.getContext();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        ViewGroup r2 = (ViewGroup) ((Activity) r1).findViewById(R.id.content);
        if (r2 != null) goto L14;
        tt5.a.d("DRIVE_VideoPlayer", "contentView is null");
        return;
    L14:
        r2.removeView(r6.getViewContainer());
        r6.getViewContainer().setRotation(0.0f);
        FrameLayout r3 = r6.getViewContainer();
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -1);
        r4.gravity = 17;
        Unit r5 = Unit.INSTANCE;
        r6.addView(r3, r4);
        r6.setCurrentPlayModeOrientation(0);
        r6.e.k(r6.getCurrentPlayMode());
        VideoPlayerControllerView r7 = r6.e;
        r7.w = false;
        r7.d.setVideoControlBarClearScreen(false);
        r7.q();
        r7.B.d();
        r6.q();
        DriveBlockPreviewVM r8 = (DriveBlockPreviewVM) this.a.viewModel(DriveBlockPreviewVM.class);
        if (r8 == null) goto L19;
        MutableLiveData<DriveBlockPreviewVM.BlockState> r9 = r8.getLiveBlockState();
        if (r9 == null) goto L19;
        DriveBlockPreviewVM.BlockState r10 = (DriveBlockPreviewVM.BlockState) r9.getValue();
    L20:
        if (r10 == null) goto L22;
        r2.post(new RunnableC0237c(r6, r2));
    L22:
        tt5.a.h("DRIVE_VideoPlayer", "exit full screen");
        return;
    L19:
        r10 = null;
        goto L20
    }

    @Override // ha5.b
    public final void b(VideoView r8) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (r8.getCurrentPlayMode() != 1) goto L6;
        tt5.a.h("DRIVE_VideoPlayer", "current mode is full screen, exit");
        return;
    L6:
        PreviewViewModel r0 = (PreviewViewModel) this.a.viewModel(PreviewViewModel.class);
        if (r0 != null) goto L9;
    L17:
        tt5.a.d("DRIVE_VideoPlayer", "enter full screen failed, mCommunication == null?");
        return;
    L9:
        if (com.bytedance.ee.util.ui.b.b(r8.getContext()) == false) goto L17;
        r0.liveInnerVideoFullScreen().setValue(Boolean.TRUE);
        Context r1 = r8.getContext();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        ViewGroup r2 = (ViewGroup) ((Activity) r1).findViewById(R.id.content);
        if (r2 != null) goto L15;
        tt5.a.d("DRIVE_VideoPlayer", "contentView is null");
        return;
    L15:
        r8.removeView(r8.getViewContainer());
        int r3 = r2.getHeight();
        int r4 = r2.getWidth();
        r8.getViewContainer().setRotation(90.0f);
        r8.setCurrentPlayModeOrientation(1);
        r8.e.k(r8.getCurrentPlayMode());
        r8.q();
        FrameLayout r5 = r8.getViewContainer();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r3, r4);
        r6.gravity = 17;
        Unit r7 = Unit.INSTANCE;
        r2.addView(r5, r6);
        r2.post(new b(r8, r3, r4));
        tt5.a.h("DRIVE_VideoPlayer", "enter full screen");
    }
}

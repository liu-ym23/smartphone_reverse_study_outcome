package dq2;

import android.opengl.GLSurfaceView;
import android.util.Log;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.livesdk.revenue.interact.animation.RevTaskState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements com.bytedance.android.live.liveinteract.videotalk.emoji.model.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eq2.a f469642a;

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.g
    public final FrameLayout a() {
        eq2.a r100 = this.f469642a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.g
    public final GLSurfaceView b() {
        eq2.a r100 = this.f469642a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    public n(eq2.a r100) {
        this.f469642a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.g
    public final void c(com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r210, TaskState r211) {
        ALogger.e("3d兼容", "3d兼容-notifyAnimationPlayComplete stacktrace " + Log.getStackTraceString(new Throwable()));
        eq2.a r100 = this.f469642a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r210 == null) goto L7;
        Intrinsics.checkNotNullParameter(r210, "$this$toRevType");
        eq2.c r101 = new eq2.c(r210.f79373a, r210.f79374b, r210.f79375c, r210.f79376d, r210.f79377e, r210.f79378f, r210.f79379g, r210.f79380h, r210.f79381i, r210.f79382j, r210.f79383k, r210.f79384l, r210.f79385m);
    L8:
        if (r211 == null) goto L21;
        Intrinsics.checkNotNullParameter(r211, "$this$toRevType");
        int r102 = eq2.b.f473458a[r211.ordinal()];
        if (r102 != 1) goto L12;
        RevTaskState r103 = RevTaskState.START;
    L20:
        RevTaskState r104 = r103;
    L22:
        r100.c(r101, r104);
        return;
    L12:
        if (r102 != 2) goto L14;
        r103 = RevTaskState.COMPLETE;
        goto L20
    L14:
        if (r102 != 3) goto L17;
        r103 = RevTaskState.CANCEL;
        goto L20
    L17:
        throw new NoWhenBranchMatchedException();
    L21:
        r104 = null;
        goto L22
    L7:
        r101 = null;
        goto L8
    }
}

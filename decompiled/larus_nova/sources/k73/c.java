package k73;

import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.AudioState;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.PlayState;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base.VideoComponentScene;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantLynx;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {
    public static final AudioState a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getMuteStatus");
        d r101 = r100.f501996g;
        if (r101 == null) goto L8;
        if (r101.isMuted() != true) goto L8;
        return AudioState.MUTE;
    L8:
        return AudioState.UNMUTE;
    }

    public static final PlayState b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPlayState");
        d r101 = r100.f501996g;
        if (r101 == null) goto L8;
        if (r101.isPlaying() != true) goto L8;
        return PlayState.PLAY;
    L8:
        return PlayState.PAUSE;
    }

    public static final HeaderPendantLynx c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getVideoInteractor");
        if (Intrinsics.areEqual(r100.f501994e, VideoComponentScene.HEAD_VIDEO.getScene()) == false) goto L7;
        n r101 = r100.f501993d;
        if (r101 != null) goto L12;
    L10:
        return null;
    L12:
        return r101.b();
    L7:
        n r102 = r100.f501993d;
        if (r102 == null) goto L10;
        return r102.a();
    }
}

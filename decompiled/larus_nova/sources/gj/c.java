package gj;

import android.view.View;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static final ECVideoPlayerView a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getECPlayerView");
        View r101 = r100.getView();
        if ((r101 instanceof ECVideoPlayerView) == true) goto L6;
        r101 = null;
    L6:
        return (ECVideoPlayerView) r101;
    }
}

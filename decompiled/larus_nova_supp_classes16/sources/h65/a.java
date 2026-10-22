package h65;

import android.app.Activity;
import com.bytedance.ee.bear.drive.view.preview.video.TTVideoView;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import ha5.b;
import kotlin.jvm.internal.Intrinsics;
import ku5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final Activity a;
    public final VideoView b;
    public final b c;

    public final Activity getActivity() {
        return this.a;
    }

    public a(Activity r2, ViewOwner r3, TTVideoView r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewOwner");
        Intrinsics.checkNotNullParameter(r4, "videoView");
        this.a = r2;
        this.b = r4;
        if (c.k(r2) == true) goto L5;
        b r5 = new ha5.a(r3);
    L6:
        this.c = r5;
        return;
    L5:
        r5 = new ha5.c(r3);
        goto L6
    }
}

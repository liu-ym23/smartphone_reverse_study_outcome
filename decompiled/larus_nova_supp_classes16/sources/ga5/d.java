package ga5;

import android.content.Context;
import com.bytedance.ee.bear.drive.view.preview.video.VideoView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final Context a;
    public final VideoView b;
    public final ViewOwner c;
    public final a d;

    public final Context getContext() {
        return this.a;
    }

    public d(Context r2, VideoView r3, ViewOwner r4, z r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "videoView");
        Intrinsics.checkNotNullParameter(r4, "viewOwner");
        Intrinsics.checkNotNullParameter(r5, "previewFileModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (ku5.c.k(r2) == true) goto L5;
        this.d = new c(r3, r4, r5);
        return;
    L5:
        this.d = new b(r3, r4, r5);
    }
}

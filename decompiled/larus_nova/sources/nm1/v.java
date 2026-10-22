package nm1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v {
    public static final int a(VSCameraInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$realCameraStyle");
        u r101 = (u) pm1.h.f529822d.c(u.class);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.c(r100);
    }

    public static final int b(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$realEpisodeStyle");
        u r101 = (u) pm1.h.f529822d.c(u.class);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.a(r100);
    }
}

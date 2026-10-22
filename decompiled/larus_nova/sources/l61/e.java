package l61;

import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final d.a a(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convert");
        if (TopSpeedModeUtils.a() == true) goto L5;
        return r100;
    L5:
        if ((r100 instanceof d.a.u0) == false) goto L8;
        return d.a.v0.f507649e;
    L8:
        if ((r100 instanceof d.a.a0) == true) goto L10;
        return r100;
    L10:
        return d.a.y0.f507655e;
    }
}

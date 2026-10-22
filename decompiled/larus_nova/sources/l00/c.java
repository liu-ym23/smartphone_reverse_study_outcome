package l00;

import android.graphics.Rect;
import com.bytedance.android.live.broadcast.api.utils.api.ICurrentRatioService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Pair;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f506845a = 0;

    static {
        f506845a = UtilityKotlinExtentionsKt.i(132);
    }

    public static Rect a() {
        ICurrentRatioService r100 = (ICurrentRatioService) va1.b.a.f553922a.a(ICurrentRatioService.class);
        if (r100 == null) goto L16;
        Pair<Integer, Integer> r101 = r100.f();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.getFirst().intValue() > 0) goto L9;
    L13:
        ALogger.i("LandscapeBroadcastUtils", "getPreviewBroadcastRenderRect cu");
        return null;
    L9:
        if (r101.getSecond().intValue() <= 0) goto L13;
        int r102 = s1.y();
        int r103 = (r101.getSecond().intValue() * r102) / r101.getFirst().intValue();
        int r104 = f506845a;
        Rect r105 = new Rect(0, r104, r102, r103 + r104);
        ALogger.i("LandscapeBroadcastUtils", "getPreviewBroadcastRenderRect rect is previewRect");
        return r105;
    L16:
        return null;
    }
}

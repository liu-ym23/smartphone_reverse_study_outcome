package sh2;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {
    public static final boolean a(IntroCardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFromEnterRoom");
        if (e.f541952b[r100.ordinal()] == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean b(IntroCardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isFromMessage");
        int r101 = e.f541951a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 != 2) goto L7;
        return true;
    L7:
        if (r101 == 3) goto L12;
        return false;
    L12:
        return true;
    }
}

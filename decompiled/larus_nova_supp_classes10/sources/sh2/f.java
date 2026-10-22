package sh2;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final boolean a(IntroCardScene r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isFromEnterRoom");
        if (e.b[r1.ordinal()] == 1) goto L6;
        return false;
    L6:
        return true;
    }

    public static final boolean b(IntroCardScene r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$isFromMessage");
        int r3 = e.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return true;
    L5:
        if (r3 != 2) goto L7;
        return true;
    L7:
        if (r3 == 3) goto L12;
        return false;
    L12:
        return true;
    }
}

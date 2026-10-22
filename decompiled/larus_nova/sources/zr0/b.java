package zr0;

import android.content.res.Configuration;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.utils.e5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final b03.b a(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toPlatformCfg");
        int r101 = r100.orientation;
        boolean r102 = true;
        if (r101 != (-1)) goto L8;
        if (e5.n() == false) goto L9;
    L10:
        boolean r103 = false;
    L12:
        if (FoldScreenUtils.f() == true) goto L14;
    L16:
        r102 = false;
    L18:
        return new b03.b(r103, r102);
    L14:
        if (FoldScreenUtils.c(r100) != 0) goto L16;
    L9:
        r103 = true;
        goto L12
    L8:
        if (e5.o(r101) == true) goto L10;
        goto L9
    }
}

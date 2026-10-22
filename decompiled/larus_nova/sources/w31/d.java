package w31;

import com.bytedance.android.live.revlink.impl.model.BizType;
import ey.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final boolean a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isClassicDouble");
        if (r100.f474773c != BizType.PK.ordinal()) goto L5;
    L8:
        return true;
    L5:
        if (r100.f474773c == BizType.OpenGame.ordinal()) goto L8;
        return false;
    }
}

package t3;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c0 {
    public static final y a(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r101 = RefType.NORMAL;
        Object r102 = r100.d(y.class);
        if (r102 != null) goto L6;
        r102 = new y(r100);
        r100.b(y.class, r102, r101);
    L6:
        return (y) r102;
    }
}

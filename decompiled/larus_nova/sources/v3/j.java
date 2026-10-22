package v3;

import com.bytedance.ai.bridge.context.RefType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    public static final h a(e3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        RefType r101 = RefType.NORMAL;
        Object r102 = r100.d(h.class);
        if (r102 != null) goto L6;
        r102 = new h(r100);
        r100.b(h.class, r102, r101);
    L6:
        return (h) r102;
    }
}

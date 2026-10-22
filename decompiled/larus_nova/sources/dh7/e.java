package dh7;

import com.bytedance.timon.pipeline.TimonSystem;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final TimonSystem a(TimonSystem r100, TimonSystem.InvokeType r101) {
        int r102 = d.f468623a[r101.ordinal()];
        if (r102 != 1) goto L5;
        TimonSystem r103 = new TimonSystem.b(r100.name() + "_OnlyPre", r100);
    L14:
        return r103;
    L5:
        if (r102 != 2) goto L7;
        r103 = new TimonSystem.a(r100.name() + "_OnlyPost", r100);
        goto L14
    L7:
        if (r102 != 3) goto L10;
        return r100;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}

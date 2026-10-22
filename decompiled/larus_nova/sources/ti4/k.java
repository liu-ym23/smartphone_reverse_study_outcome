package ti4;

import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k {
    public static final <DATA> MaterialSelectedState a(h<DATA> r100, DATA r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        MaterialSelectedState r102 = r100.b(r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        return MaterialSelectedState.NON_SELECTED;
    }
}

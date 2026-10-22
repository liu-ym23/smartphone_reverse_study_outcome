package gs4;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.filter.model.EFilterDuration;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final Object b(EFieldType r100) {
        if (r100 != EFieldType.CHECKBOX) goto L6;
        return Boolean.FALSE;
    L6:
        if (lr4.a.b(r100) == false) goto L9;
        return new Object[]{EFilterDuration.ExactDate, null};
    L9:
        return null;
    }

    public static final boolean a(Object r100, Object r101) {
        if ((r100 instanceof Object[]) == false) goto L8;
        if ((r101 instanceof Object[]) == false) goto L8;
        return ArraysKt.contentDeepEquals((Object[]) r100, (Object[]) r101);
    L8:
        return Intrinsics.areEqual(r100, r101);
    }
}

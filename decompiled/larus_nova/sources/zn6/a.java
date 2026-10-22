package zn6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() == 4) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 0), BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 1), "b", false, 2, null) == true) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 2), "c", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (StringsKt.startsWith$default((String) ListProtector.get(r101, 3), "d", false, 2, null) == false) goto L18;
        return true;
    L18:
        return false;
    }
}

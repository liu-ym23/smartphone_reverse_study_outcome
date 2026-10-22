package foc;

import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ICUUtils.FormatArgsBuilder r101 = new ICUUtils.FormatArgsBuilder();     // Catch: RuntimeException -> L6
        r101.b("APP_DISPLAY_NAME", UIHelper.getAppName());     // Catch: RuntimeException -> L6
        String r102 = ICUUtils.icuFormat(r100, r101.f285892a);     // Catch: RuntimeException -> L6
        Intrinsics.checkNotNull(r102);     // Catch: RuntimeException -> L6
        return r102;
    L9:
        return r100;
    }
}

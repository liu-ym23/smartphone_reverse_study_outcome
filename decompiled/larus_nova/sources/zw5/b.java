package zw5;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        return "kmp_asr_".concat(r100);
    }

    public static final String b(hw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        hw5.a r101 = r100.f487421e;
        if (r101 == null) goto L5;
        String r102 = " causeType=" + r101.getType() + " causeCode=" + r101.f487419c + " causeMessage=" + r101.f487418b;
    L6:
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        return "errorType=" + r100.getType() + " errorCode=" + r100.f487419c + " retryCount=" + r100.f487422f + " errorMessage=" + r100.f487418b + r102;
    L5:
        r102 = null;
        goto L6
    }

    public static final String c(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return "exception=" + Reflection.getOrCreateKotlinClass(r100.getClass()).getSimpleName() + " message=" + r100.getMessage();
    }
}

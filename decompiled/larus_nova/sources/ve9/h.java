package ve9;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {
    public static final String c(g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r102 = r100.f554467a.get(r101);
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    }

    public static final boolean a(g r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r103 = r100.f554467a.get(r101);
        if (r103 == null) goto L17;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L6
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(Boolean.parseBoolean(r103)));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r105) == false) goto L11;
        r105 = null;
    L11:
        Boolean r106 = (Boolean) r105;
        if (r106 != null) goto L14;
        return r102;
    L14:
        return r106.booleanValue();
    L6:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        return r102;
    }

    public static final int b(g r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        String r103 = r100.f554467a.get(r101);
        if (r103 == null) goto L17;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L6
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(CastIntegerProtector.parseInt(r103)));     // Catch: Throwable -> L6
    L9:
        if (Result.m9455isFailureimpl(r105) == false) goto L11;
        r105 = null;
    L11:
        Integer r106 = (Integer) r105;
        if (r106 != null) goto L14;
        return r102;
    L14:
        return r106.intValue();
    L6:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        return r102;
    }
}

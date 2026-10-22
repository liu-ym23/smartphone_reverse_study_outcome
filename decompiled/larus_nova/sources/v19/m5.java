package v19;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m5 {
    public static final void a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.exists() == false) goto L10;
        r100.delete();     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }

    public static final void b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        a(new PolarisFileWrapper(r100));
        return;
    L11:
        return;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static final boolean c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        boolean r102 = true;
        if (r100 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L14:
        r102 = false;
    L15:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r104) == false) goto L22;
        r104 = null;
    L22:
        Boolean r105 = (Boolean) r104;
        if (r105 != null) goto L25;
        return false;
    L25:
        return r105.booleanValue();
    L12:
        if (new PolarisFileWrapper(r100).exists() == false) goto L14;
    L6:
        if (r100.length() == 0) goto L9;
        r103 = false;
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}

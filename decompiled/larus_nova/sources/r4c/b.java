package r4c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f536117a = null;

    static {
        f536117a = new b();
    }

    public b() {
    }

    public static String a(int r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(UIHelper.getString(r100));     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L10;
        Log.w("SecurityFileCryptoTips", "[" + r101 + "] resolve string failed", r104);
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = "";
    L13:
        return (String) r103;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }
}

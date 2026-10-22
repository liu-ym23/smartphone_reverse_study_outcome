package tna;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f546881a = null;

    static {
        f546881a = new a();
    }

    public a() {
    }

    public static String a(Function0 r100) {
        Object r101 = "";
        Intrinsics.checkNotNullParameter(r100, "tokenProvider");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        String r103 = (String) r100.invoke();     // Catch: Throwable -> L8
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L14;
        r105.getMessage();
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L17;
        r101 = r104;
    L17:
        String r106 = (String) r101;
        if (StringsKt.isBlank(r106) == false) goto L21;
        return null;
    L21:
        JSONObject r107 = new JSONObject();
        r107.put("proto-version", "v2");
        r107.put("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r107.put("sdk-version", "2");
        r107.put("X-tt-Token", r106);
        return r107.toString();
    L8:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}

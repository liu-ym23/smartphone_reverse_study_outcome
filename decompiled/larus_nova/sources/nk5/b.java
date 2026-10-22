package nk5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.lynx.tasm.LynxError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    public static final void a(gk5.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("biz.forms.onFrameRecorded", "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(new org.json.JSONObject(r101.toJSONString()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r103) == false) goto L10;
        r100.onEvent((org.json.JSONObject) r103);
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        c(r100, r104);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void b(gk5.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "error");
        Integer r102 = r101.getInteger("errCode");
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        String r104 = r101.getString("errMsg");
        if (r104 != null) goto L9;
        r104 = BitableJSApiErrorCode.UNKNOWN.getErrMsg();
    L9:
        r100.onFailure(r103, r104);
        return;
    L5:
        r103 = BitableJSApiErrorCode.UNKNOWN.getCode();
        goto L6
    }

    public static final void c(gk5.a r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        tt5.a.e("OfficeCCMH5JSB", "H5 JSB handler failed", r101, false);
        BitableJSApiErrorCode r102 = BitableJSApiErrorCode.UNKNOWN;
        int r103 = r102.getCode();
        String r104 = r101.getMessage();
        if (r104 != null) goto L5;
        r104 = r102.getErrMsg();
    L5:
        r100.onFailure(r103, r104);
    }

    public static final void d(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "message");
        tt5.a.k("OfficeCCMH5JSB", "Invalid H5 JSB parameter: ".concat(r101));
        r100.onFailure(BitableJSApiErrorCode.UNKNOWN.getCode(), r101);
    }

    public static final void e(gk5.a r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(new org.json.JSONObject(r101.toJSONString()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9456isSuccessimpl(r103) == false) goto L10;
        r100.onSuccess((org.json.JSONObject) r103);
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        c(r100, r104);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}

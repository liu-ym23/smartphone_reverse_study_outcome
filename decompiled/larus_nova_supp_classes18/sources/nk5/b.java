package nk5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final void a(gk5.a r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter("biz.forms.onFrameRecorded", "name");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(new org.json.JSONObject(r3.toJSONString()));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r4) == false) goto L10;
        r2.onEvent((org.json.JSONObject) r4);
    L10:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L16;
        c(r2, r5);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void b(gk5.a r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "error");
        Integer r0 = r3.getInteger("errCode");
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        String r4 = r3.getString("errMsg");
        if (r4 != null) goto L9;
        r4 = BitableJSApiErrorCode.UNKNOWN.getErrMsg();
    L9:
        r2.onFailure(r1, r4);
        return;
    L5:
        r1 = BitableJSApiErrorCode.UNKNOWN.getCode();
        goto L6
    }

    public static final void c(gk5.a r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.e("OfficeCCMH5JSB", "H5 JSB handler failed", r4, false);
        BitableJSApiErrorCode r0 = BitableJSApiErrorCode.UNKNOWN;
        int r1 = r0.getCode();
        String r5 = r4.getMessage();
        if (r5 != null) goto L5;
        r5 = r0.getErrMsg();
    L5:
        r3.onFailure(r1, r5);
    }

    public static final void d(p r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "message");
        tt5.a.k("OfficeCCMH5JSB", "Invalid H5 JSB parameter: ".concat(r3));
        r2.onFailure(BitableJSApiErrorCode.UNKNOWN.getCode(), r3);
    }

    public static final void e(gk5.a r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(new org.json.JSONObject(r2.toJSONString()));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r3) == false) goto L10;
        r1.onSuccess((org.json.JSONObject) r3);
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        c(r1, r4);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}

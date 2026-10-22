package com.ss.android.lark.passport.flow.idp_auth;

import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/flow/idp_auth/FlowIdpLoginResult;", "Ljava/io/Serializable;", "<init>", "()V", "state", "", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "message", "getMessage", "setMessage", "logId", "getLogId", "setLogId", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowIdpLoginResult implements Serializable {
    public static final a Companion = null;
    private int code;

    @JSONField(name = "log_id")
    private String logId;
    private String message;
    private String state;

    public static final class a {
        public a() {
        }

        public static FlowIdpLoginResult a(String r100, String r101) {
            if (r100 != null) goto L4;
        L7:
            boolean r102 = true;
        L8:
            Object r103 = null;
            if (r102 == false) goto L41;
            PassportLog.b("FlowIdpLoginResult", "decode " + r101 + " failed: encoded content is blank");
            return null;
        L41:
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L24
            Object r105 = Result.m9449constructorimpl(Base64.decode(r100, 2));     // Catch: Throwable -> L16
        L19:
            if (Result.m9452exceptionOrNullimpl(r105) == null) goto L22;
            r105 = Base64.decode(r100, 10);     // Catch: Throwable -> L24
        L22:
            Object r106 = Result.m9449constructorimpl((FlowIdpLoginResult) JSON.parseObject(new String((byte[]) r105, StandardCharsets.UTF_8), FlowIdpLoginResult.class));     // Catch: Throwable -> L24
        L27:
            if (Result.m9456isSuccessimpl(r106) == true) goto L29;
        L32:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L36;
            PassportLog.b("FlowIdpLoginResult", "decode " + r101 + " failed: " + r107.getClass().getSimpleName());
        L36:
            if (Result.m9455isFailureimpl(r106) == true) goto L40;
            r103 = r106;
        L40:
            return (FlowIdpLoginResult) r103;
        L29:
            if (((FlowIdpLoginResult) r106) == null) goto L31;
            PassportLog.d("FlowIdpLoginResult", "decode " + r101 + " success");
            goto L32
        L31:
            PassportLog.b("FlowIdpLoginResult", "decode " + r101 + " failed: result is null");
        L16:
            th = move-exception;
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L27
        L4:
            if (StringsKt.isBlank(r100) == true) goto L7;
            r102 = false;
            goto L8
        }
    }

    public FlowIdpLoginResult() {
    }

    static {
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getState() {
        return this.state;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setState(String r100) {
        this.state = r100;
    }
}

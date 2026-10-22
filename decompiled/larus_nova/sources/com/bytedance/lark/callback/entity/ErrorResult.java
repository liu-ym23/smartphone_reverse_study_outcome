package com.bytedance.lark.callback.entity;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0003;<=B\u0011\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0017\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0019\b\u0017\u0012\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\u0004\u0010\fB\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\rB#\b\u0017\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\u0004\u0010\u000eB?\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b¢\u0006\u0004\b\u0004\u0010\u0011J\b\u00104\u001a\u00020\u0003H\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020\u0007J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0000R\u001e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0005R&\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00038\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\"\u0010$\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u001e\u0010&\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R,\u0010(\u001a\u00060\nj\u0002`\u000b2\n\u0010\u0012\u001a\u00060\nj\u0002`\u000b@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\fR\"\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\"\u0010.\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\"\u00101\u001a\u0004\u0018\u0001002\b\u0010\u0012\u001a\u0004\u0018\u000100@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00109\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u001e¨\u0006>"}, d2 = {"Lcom/bytedance/lark/callback/entity/ErrorResult;", "", "errorCode", "", "<init>", "(I)V", "debugMsg", "", "(Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "(ILjava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/Exception;)V", "rustDisplayMsg", "serverDisplayMsg", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V", "value", "status", "getStatus", "()I", "code", "getCode", "setCode$kmp_utils_release", "bizCode", "getBizCode$annotations", "()V", "getBizCode", "getDebugMsg", "()Ljava/lang/String;", "displayMsg", "getDisplayMsg", "setDisplayMsg$kmp_utils_release", "displayTitle", "getDisplayTitle", "serverRequestId", "getServerRequestId", "regulateCode", "getRegulateCode", "mException", "getMException", "()Ljava/lang/Exception;", "setMException$kmp_utils_release", "logId", "getLogId", "extra", "getExtra", "", "extraRaw", "getExtraRaw", "()[B", "getErrorCode", "fallbackString", "copyFrom", "", "other", "message", "getMessage", "Companion", "Builder", "IErrorCodeCompat", "kmp-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ErrorResult extends Throwable {
    public static final b Companion = null;
    public static final ErrorResult TIMEOUT_ERROR = null;
    private int bizCode;
    private int code;
    private String debugMsg;
    private String displayMsg;
    private String displayTitle;
    private String extra;
    private byte[] extraRaw;
    private String logId;
    private Exception mException;
    private int regulateCode;
    private String serverRequestId;
    private int status;

    public static final class a {
        public a() {
            new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public interface c {
    }

    public static final /* synthetic */ void access$setSCodeCompat$cp(c r100) {
    }

    @Deprecated(message = "passport deprecated", replaceWith = @ReplaceWith(expression = "code", imports = {}))
    public static /* synthetic */ void getBizCode$annotations() {
    }

    static {
        Companion = new b();
        TIMEOUT_ERROR = new ErrorResult(900, "Time out");
    }

    @JvmStatic
    public static final a newBuilder() {
        Companion.getClass();
        return new a();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "ErrorResult: code=" + this.code + ", dbg=" + this.debugMsg + ", display=" + this.displayMsg + ", reqId=" + this.serverRequestId + ", rc=" + this.regulateCode + ", e=" + this.mException;
    }

    public final int getBizCode() {
        return this.bizCode;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDebugMsg() {
        return this.debugMsg;
    }

    public final String getDisplayMsg() {
        return this.displayMsg;
    }

    public final String getDisplayTitle() {
        return this.displayTitle;
    }

    @Deprecated(message = "use getCode() instead")
    public final int getErrorCode() {
        return this.code;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final byte[] getExtraRaw() {
        return this.extraRaw;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final Exception getMException() {
        return this.mException;
    }

    public final int getRegulateCode() {
        return this.regulateCode;
    }

    public final String getServerRequestId() {
        return this.serverRequestId;
    }

    public final int getStatus() {
        return this.status;
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(int r100) {
        super("errorCode = " + r100);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.code = r100;
        this.mException = new Exception("errorCode = " + r100);
    }

    @JvmStatic
    public static final void setCodeCompat(c r100) {
        Companion.getClass();
        access$setSCodeCompat$cp(r100);
    }

    public final void copyFrom(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        this.debugMsg = r100.debugMsg;
        this.code = r100.code;
        this.bizCode = r100.bizCode;
        this.status = r100.status;
        this.displayMsg = r100.displayMsg;
        this.displayTitle = r100.displayTitle;
        this.serverRequestId = r100.serverRequestId;
        this.regulateCode = r100.regulateCode;
        this.mException = r100.mException;
        this.logId = r100.logId;
        this.extra = r100.extra;
        this.extraRaw = r100.extraRaw;
    }

    public final String getDisplayMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fallbackString");
        String r101 = this.displayMsg;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        return r100;
    L12:
        return this.displayMsg;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void setCode$kmp_utils_release(int r100) {
        this.code = r100;
    }

    public final void setDisplayMsg$kmp_utils_release(String r100) {
        this.displayMsg = r100;
    }

    public final void setMException$kmp_utils_release(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mException = r100;
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(Exception r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getMessage();
    L5:
        super(r101);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        if (r100 == null) goto L9;
        this.debugMsg = r100.getMessage();
        this.mException = r100;
        return;
    L9:
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(String r100) {
        super(r100);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.debugMsg = r100;
        this.mException = new Exception(r100);
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(int r100, String r101) {
        super(r101);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.code = r100;
        this.debugMsg = r101;
        this.mException = new Exception(r101);
    }

    public static final /* synthetic */ void access$setBizCode$p(ErrorResult r100, int r101) {
        r100.bizCode = r101;
    }

    public static final /* synthetic */ void access$setDebugMsg$p(ErrorResult r100, String r101) {
        r100.debugMsg = r101;
    }

    public static final /* synthetic */ void access$setDisplayTitle$p(ErrorResult r100, String r101) {
        r100.displayTitle = r101;
    }

    public static final /* synthetic */ void access$setExtra$p(ErrorResult r100, String r101) {
        r100.extra = r101;
    }

    public static final /* synthetic */ void access$setExtraRaw$p(ErrorResult r100, byte[] r101) {
        r100.extraRaw = r101;
    }

    public static final /* synthetic */ void access$setLogId$p(ErrorResult r100, String r101) {
        r100.logId = r101;
    }

    public static final /* synthetic */ void access$setRegulateCode$p(ErrorResult r100, int r101) {
        r100.regulateCode = r101;
    }

    public static final /* synthetic */ void access$setServerRequestId$p(ErrorResult r100, String r101) {
        r100.serverRequestId = r101;
    }

    public static final /* synthetic */ void access$setStatus$p(ErrorResult r100, int r101) {
        r100.status = r101;
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(String r100, Exception r101) {
        super(r100);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.debugMsg = r100;
        if (r101 == null) goto L6;
        this.mException = r101;
        return;
    }

    @Deprecated(message = "use Builder instead")
    public ErrorResult(int r100, String r101, String r102, String r103, Exception r104) {
        super(r101);
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.code = r100;
        this.debugMsg = r101;
        this.displayMsg = r103;
        if (r104 == null) goto L6;
        this.mException = r104;
        return;
    }
}

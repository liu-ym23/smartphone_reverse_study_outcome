package com.larksuite.framework.callback.Entity;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import java.util.Locale;

/* JADX INFO: loaded from: classes24.dex */
public class ErrorResult extends Throwable {
    public static final ErrorResult TIMEOUT_ERROR = null;
    private static b sCodeCompat;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f285538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f285539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f285540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f285541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f285542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f285543f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f285544g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Exception f285545h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f285546i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public byte[] f285547j;

        public final ErrorResult a() {
            ErrorResult r100 = new ErrorResult(0);
            ErrorResult.access$002(r100, this.f285539b);
            ErrorResult.access$102(r100, -9999);
            ErrorResult.access$202(r100, this.f285538a);
            ErrorResult.access$302(r100, this.f285545h);
            ErrorResult.access$402(r100, this.f285542e);
            ErrorResult.access$502(r100, this.f285540c);
            ErrorResult.access$602(r100, this.f285541d);
            ErrorResult.access$702(r100, this.f285543f);
            ErrorResult.access$802(r100, 0);
            ErrorResult.access$902(r100, this.f285544g);
            ErrorResult.access$1002(r100, this.f285546i);
            ErrorResult.access$1102(r100, this.f285547j);
            return r100;
        }

        public a() {
            this.f285539b = -1;
            this.f285540c = "";
            this.f285541d = "";
            this.f285542e = "";
            this.f285543f = "";
            this.f285545h = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        }
    }

    public interface b {
    }

    static {
        TIMEOUT_ERROR = new ErrorResult(900, "Time out");
        sCodeCompat = null;
    }

    public int getErrorCode() {
        b r100 = sCodeCompat;
        if (r100 == null) goto L9;
        int r101 = this.code;
        ((com.ss.android.lark.sdk.b) r100).getClass();
        Integer r102 = com.ss.android.lark.sdk.b.f439870b.get(Integer.valueOf(r101));
        if (r102 != null) goto L7;
        return r101;
    L7:
        return r102.intValue();
    L9:
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return String.format(Locale.US, "ErrorResult: code=%d, dbg=%s, display=%s, reqId=%s, rc=%d, e=%s", new Object[]{Integer.valueOf(this.code), this.debugMsg, this.displayMsg, this.serverRequestId, Integer.valueOf(this.regulateCode), this.mException});
    }

    public String getErrorMsg() {
        return getDisplayMsg();
    }

    public int getBizCode() {
        return this.bizCode;
    }

    public int getCode() {
        return this.code;
    }

    public String getDebugMsg() {
        return this.debugMsg;
    }

    public String getDisplayMsg() {
        return this.displayMsg;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public Exception getException() {
        return this.mException;
    }

    public String getExtra() {
        return this.extra;
    }

    public byte[] getExtraRaw() {
        return this.extraRaw;
    }

    public String getLogId() {
        return this.logId;
    }

    public int getRegulateCode() {
        return this.regulateCode;
    }

    public String getServerRequestId() {
        return this.serverRequestId;
    }

    public int getStatus() {
        return this.status;
    }

    public ErrorResult(int r100) {
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.code = r100;
        this.mException = new Exception("errorCode  = " + r100);
    }

    public static void setCodeCompat(b r100) {
        sCodeCompat = r100;
    }

    public void copyFrom(ErrorResult r100) {
        this.debugMsg = r100.debugMsg;
        this.code = r100.code;
        this.bizCode = r100.bizCode;
        this.status = r100.status;
        this.displayMsg = r100.displayMsg;
        this.displayTitle = r100.displayTitle;
        this.serverRequestId = r100.serverRequestId;
        this.regulateCode = r100.regulateCode;
        this.mException = r100.mException;
    }

    public String getDisplayMsg(String r100) {
        if (TextUtils.isEmpty(this.displayMsg) == false) goto L6;
        return r100;
    L6:
        return getDisplayMsg();
    }

    public void setErrorCode(int r100) {
        this.code = r100;
    }

    public ErrorResult(Exception r100) {
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        if (r100 == null) goto L6;
        this.debugMsg = r100.getLocalizedMessage();
        this.mException = r100;
        return;
    }

    public ErrorResult(String r100) {
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.debugMsg = r100;
        this.mException = new Exception(r100);
    }

    public ErrorResult(int r100, String r101) {
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.code = r100;
        this.debugMsg = r101;
        this.mException = new Exception(r101);
    }

    public static /* synthetic */ int access$002(ErrorResult r100, int r101) {
        r100.code = r101;
        return r101;
    }

    public static /* synthetic */ String access$1002(ErrorResult r100, String r101) {
        r100.extra = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(ErrorResult r100, int r101) {
        r100.bizCode = r101;
        return r101;
    }

    public static /* synthetic */ byte[] access$1102(ErrorResult r100, byte[] r101) {
        r100.extraRaw = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(ErrorResult r100, int r101) {
        r100.status = r101;
        return r101;
    }

    public static /* synthetic */ Exception access$302(ErrorResult r100, Exception r101) {
        r100.mException = r101;
        return r101;
    }

    public static /* synthetic */ String access$402(ErrorResult r100, String r101) {
        r100.displayTitle = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(ErrorResult r100, String r101) {
        r100.debugMsg = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(ErrorResult r100, String r101) {
        r100.displayMsg = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(ErrorResult r100, String r101) {
        r100.serverRequestId = r101;
        return r101;
    }

    public static /* synthetic */ int access$802(ErrorResult r100, int r101) {
        r100.regulateCode = r101;
        return r101;
    }

    public static /* synthetic */ String access$902(ErrorResult r100, String r101) {
        r100.logId = r101;
        return r101;
    }

    public ErrorResult(String r100, Exception r101) {
        this.bizCode = -9999;
        this.mException = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        this.debugMsg = r100;
        if (r101 == null) goto L6;
        this.mException = r101;
        return;
    }

    public ErrorResult(int r100, String r101, String r102, String r103, Exception r104) {
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

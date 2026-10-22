package com.bytedance.lynx.service.security;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityErrorCode;", "", "", "code", "I", "getCode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LynxSecurityErrorCodeOk", "LynxSecurityErrorCodeUnSigned", "LynxSecurityErrorCodeErrorSign", "LynxSecurityErrorCodeReadBlockFailed", "LynxSecurityErrorCodePKNotFound", "LynxSecurityErrorCodeDebugCertExpired", "LynxSecurityErrorCodeDebugCertVerifyFailed", "LynxSecurityErrorCodeDebugCertInvalid", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0})
public final enum LynxSecurityErrorCode extends Enum<LynxSecurityErrorCode> {
    public static final a Companion = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeDebugCertExpired = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeDebugCertInvalid = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeDebugCertVerifyFailed = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeErrorSign = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeOk = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodePKNotFound = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeReadBlockFailed = null;
    public static final LynxSecurityErrorCode LynxSecurityErrorCodeUnSigned = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxSecurityErrorCode[] f264929a = null;
    private final int code;

    public static final class a {
        public a() {
        }

        public static LynxSecurityErrorCode a(int r100) {
            LynxSecurityErrorCode[] r101 = LynxSecurityErrorCode.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            LynxSecurityErrorCode r104 = r101[r103];
            if (r104.getCode() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L15;
            return r104;
        L15:
            throw new IllegalArgumentException("unknown error code: " + r100);
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static LynxSecurityErrorCode valueOf(String r100) {
        return (LynxSecurityErrorCode) r27.a.a(LynxSecurityErrorCode.class, r100);
    }

    public static LynxSecurityErrorCode[] values() {
        return (LynxSecurityErrorCode[]) f264929a.clone();
    }

    static {
        LynxSecurityErrorCode r100 = new LynxSecurityErrorCode("LynxSecurityErrorCodeOk", 0, 0);
        LynxSecurityErrorCodeOk = r100;
        LynxSecurityErrorCode r101 = new LynxSecurityErrorCode("LynxSecurityErrorCodeUnSigned", 1, 1);
        LynxSecurityErrorCodeUnSigned = r101;
        LynxSecurityErrorCode r102 = new LynxSecurityErrorCode("LynxSecurityErrorCodeErrorSign", 2, 2);
        LynxSecurityErrorCodeErrorSign = r102;
        LynxSecurityErrorCode r103 = new LynxSecurityErrorCode("LynxSecurityErrorCodeReadBlockFailed", 3, 3);
        LynxSecurityErrorCodeReadBlockFailed = r103;
        LynxSecurityErrorCode r104 = new LynxSecurityErrorCode("LynxSecurityErrorCodePKNotFound", 4, 4);
        LynxSecurityErrorCodePKNotFound = r104;
        LynxSecurityErrorCode r105 = new LynxSecurityErrorCode("LynxSecurityErrorCodeDebugCertExpired", 5, 5);
        LynxSecurityErrorCodeDebugCertExpired = r105;
        LynxSecurityErrorCode r110 = new LynxSecurityErrorCode("LynxSecurityErrorCodeDebugCertVerifyFailed", 6, 6);
        LynxSecurityErrorCodeDebugCertVerifyFailed = r110;
        LynxSecurityErrorCode r111 = new LynxSecurityErrorCode("LynxSecurityErrorCodeDebugCertInvalid", 7, 7);
        LynxSecurityErrorCodeDebugCertInvalid = r111;
        f264929a = new LynxSecurityErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111};
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public LynxSecurityErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}

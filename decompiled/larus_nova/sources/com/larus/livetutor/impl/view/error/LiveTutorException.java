package com.larus.livetutor.impl.view.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \r2\u00060\u0001j\u0002`\u0002:\u0001\rB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/livetutor/impl/view/error/LiveTutorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errCode", "", "errMsg", "", "<init>", "(ILjava/lang/String;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorException extends RuntimeException {
    public static final a Companion = null;
    public static final int WEBVIEW_LOAD_TIMEOUT_ERROR_NO = -10001;
    private final int errCode;
    private final String errMsg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public LiveTutorException(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        super(r101);
        this.errCode = r100;
        this.errMsg = r101;
    }
}

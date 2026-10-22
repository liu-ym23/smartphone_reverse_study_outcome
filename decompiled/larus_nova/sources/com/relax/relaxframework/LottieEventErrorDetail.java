package com.relax.relaxframework;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/LottieEventErrorDetail;", "", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LottieEventErrorDetail {
    private int code;
    private String msg;

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msg = r100;
    }

    public LottieEventErrorDetail(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.code = r100;
        this.msg = r101;
    }
}

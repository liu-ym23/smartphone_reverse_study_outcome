package com.bytedance.locallife.dito.exception;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/dito/exception/DitoNetworkException;", "Lcom/bytedance/locallife/dito/exception/DitoException;", "", "code", "I", "getCode", "()I", "", "msg", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class DitoNetworkException extends DitoException {
    public static final a Companion = null;
    public static final int DEFAULT_NETWORK_ERROR_CODE = -10000000;
    private final int code;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DitoNetworkException() {
        this(0, null, null, 7, null);
    }

    public int getCode() {
        return this.code;
    }

    public DitoNetworkException(int r100, String r101, Throwable r102) {
        super(r101, r102);
        this.code = r100;
    }

    public /* synthetic */ DitoNetworkException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = DEFAULT_NETWORK_ERROR_CODE;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

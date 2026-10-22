package com.bytedance.locallife.dito.exception;

import com.bytedance.locallife.dito.log.error.API_REQUEST_CLIENT_ERROR;
import com.bytedance.locallife.dito.log.error.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/dito/exception/NetworkClientErrorThrowable;", "Lcom/bytedance/locallife/dito/exception/DitoNetworkException;", "", "code", "I", "getCode", "()I", "Lcom/bytedance/locallife/dito/log/error/a;", "type", "Lcom/bytedance/locallife/dito/log/error/a;", "getType", "()Lcom/bytedance/locallife/dito/log/error/a;", "", "msg", "<init>", "(ILjava/lang/String;Lcom/bytedance/locallife/dito/log/error/a;)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkClientErrorThrowable extends DitoNetworkException {
    private final int code;
    private final a type;

    @Override // com.bytedance.locallife.dito.exception.DitoNetworkException
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.locallife.dito.exception.DitoException
    public a getType() {
        return this.type;
    }

    public NetworkClientErrorThrowable(int r100, String r101, a r110) {
        Intrinsics.checkNotNullParameter(r110, "type");
        super(r100, r101, null, 4, null);
        this.code = r100;
        this.type = r110;
    }

    public /* synthetic */ NetworkClientErrorThrowable(int r100, String r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = API_REQUEST_CLIENT_ERROR.f258445a;
    L8:
        this(r100, r101, r102);
    }
}

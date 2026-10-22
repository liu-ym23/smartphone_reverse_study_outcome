package com.bytedance.locallife.dito.exception;

import com.bytedance.locallife.dito.log.error.API_REQUEST_OTHER_ERROR;
import com.bytedance.locallife.dito.log.error.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/dito/exception/NetworkUndefineErrorException;", "Lcom/bytedance/locallife/dito/exception/DitoNetworkException;", "Lcom/bytedance/locallife/dito/log/error/a;", "type", "Lcom/bytedance/locallife/dito/log/error/a;", "getType", "()Lcom/bytedance/locallife/dito/log/error/a;", "", "msg", "<init>", "(Ljava/lang/String;Lcom/bytedance/locallife/dito/log/error/a;)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class NetworkUndefineErrorException extends DitoNetworkException {
    private final a type;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkUndefineErrorException() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.locallife.dito.exception.DitoException
    public a getType() {
        return this.type;
    }

    public NetworkUndefineErrorException(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        super(0, r100, null, 5, null);
        this.type = r101;
    }

    public /* synthetic */ NetworkUndefineErrorException(String r100, a r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = API_REQUEST_OTHER_ERROR.f258449a;
    L8:
        this(r100, r101);
    }
}

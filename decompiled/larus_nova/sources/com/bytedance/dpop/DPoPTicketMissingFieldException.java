package com.bytedance.dpop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/dpop/DPoPTicketMissingFieldException;", "Lcom/bytedance/dpop/DPoPTicketException;", "fieldName", "", "(Ljava/lang/String;)V", "getFieldName", "()Ljava/lang/String;", "dpopsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DPoPTicketMissingFieldException extends DPoPTicketException {
    private final String fieldName;

    public final String getFieldName() {
        return this.fieldName;
    }

    public DPoPTicketMissingFieldException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fieldName");
        super("ticket response missing " + r100, null, 2, null);
        this.fieldName = r100;
    }
}

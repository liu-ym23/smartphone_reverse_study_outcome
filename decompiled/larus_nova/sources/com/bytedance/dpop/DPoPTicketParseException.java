package com.bytedance.dpop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dpop/DPoPTicketParseException;", "Lcom/bytedance/dpop/DPoPTicketException;", "responseBody", "", "(Ljava/lang/String;)V", "dpopsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DPoPTicketParseException extends DPoPTicketException {
    public DPoPTicketParseException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "responseBody");
        super("ticket response parse failed, body: " + r100, null, 2, null);
    }
}

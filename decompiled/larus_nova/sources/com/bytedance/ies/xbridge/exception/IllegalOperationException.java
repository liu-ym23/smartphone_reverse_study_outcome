package com.bytedance.ies.xbridge.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/exception/IllegalOperationException;", "Lcom/bytedance/ies/xbridge/exception/XBridgeException;", "message", "", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class IllegalOperationException extends XBridgeException {
    public IllegalOperationException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }
}

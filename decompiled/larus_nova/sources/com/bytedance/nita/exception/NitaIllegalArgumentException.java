package com.bytedance.nita.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/nita/exception/NitaIllegalArgumentException;", "Ljava/lang/IllegalArgumentException;", "()V", "core_release"}, k = 1, mv = {1, 1, 16})
public final class NitaIllegalArgumentException extends IllegalArgumentException {
    public NitaIllegalArgumentException() {
        super("can' not use the  non activity context, please check ");
    }
}

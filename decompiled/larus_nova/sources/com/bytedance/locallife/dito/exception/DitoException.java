package com.bytedance.locallife.dito.exception;

import com.bytedance.locallife.dito.log.error.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/dito/exception/DitoException;", "", "Lcom/bytedance/locallife/dito/log/error/a;", "getType", "()Lcom/bytedance/locallife/dito/log/error/a;", "type", "", "msg", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public abstract class DitoException extends Throwable {
    /* JADX WARN: Multi-variable type inference failed */
    public DitoException() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public abstract a getType();

    public DitoException(String r100, Throwable r101) {
        super(r100, r101);
    }

    public /* synthetic */ DitoException(String r100, Throwable r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

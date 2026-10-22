package com.bytedance.locallife.biz.mob;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/biz/mob/ETkitException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Throwable;)V", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ETkitException extends RuntimeException {
    /* JADX WARN: Multi-variable type inference failed */
    public ETkitException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ETkitException(Throwable r100) {
        super(r100);
    }

    public /* synthetic */ ETkitException(Throwable r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}

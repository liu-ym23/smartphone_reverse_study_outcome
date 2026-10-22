package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmError;", "Lcom/bytedance/lark/base/open/pkm/UnhandledException;", "()V", "into", "Lopen_pkm/proto/PkmError;", "Lcom/bytedance/lark/base/open/pkm/PkmErrorData;", "Lcom/bytedance/lark/base/open/pkm/PkmErrorDisk;", "Lcom/bytedance/lark/base/open/pkm/PkmErrorNetwork;", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PkmError extends UnhandledException {
    private PkmError() {
        String r0 = null;
        super(r0, 1, r0);
    }

    public /* synthetic */ PkmError(DefaultConstructorMarker r1) {
        this();
    }

    public final open_pkm.proto.PkmError into() {
        if ((this instanceof PkmErrorNetwork) == false) goto L6;
        return new open_pkm.proto.PkmError.Builder().network(((PkmErrorNetwork) this).getInner()).build();
    L6:
        if ((this instanceof PkmErrorDisk) == false) goto L9;
        return new open_pkm.proto.PkmError.Builder().disk(((PkmErrorDisk) this).getInner()).build();
    L9:
        if ((this instanceof PkmErrorData) == false) goto L13;
        return new open_pkm.proto.PkmError.Builder().data(((PkmErrorData) this).getInner()).build();
    L13:
        throw new NoWhenBranchMatchedException();
    }
}

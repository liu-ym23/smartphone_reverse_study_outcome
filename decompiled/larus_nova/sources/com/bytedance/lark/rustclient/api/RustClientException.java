package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.LarkError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lark/rustclient/api/RustClientException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "rustError", "Lcom/bytedance/lark/pb/basic/v1/LarkError;", "<init>", "(Ljava/lang/String;Lcom/bytedance/lark/pb/basic/v1/LarkError;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getRustError", "()Lcom/bytedance/lark/pb/basic/v1/LarkError;", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustClientException extends RuntimeException {
    private final LarkError rustError;

    public final LarkError getRustError() {
        return this.rustError;
    }

    public RustClientException(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "cause");
        super(r100, r101);
        this.rustError = null;
    }

    public RustClientException(String r100, LarkError r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
        this.rustError = r101;
    }

    public /* synthetic */ RustClientException(String r100, LarkError r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}

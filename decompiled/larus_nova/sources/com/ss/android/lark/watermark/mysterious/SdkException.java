package com.ss.android.lark.watermark.mysterious;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/watermark/mysterious/SdkException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "message", "", "<init>", "(Lcom/larksuite/framework/callback/Entity/ErrorResult;Ljava/lang/String;)V", "getErrorResult", "()Lcom/larksuite/framework/callback/Entity/ErrorResult;", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SdkException extends RuntimeException {
    private final ErrorResult errorResult;

    public final ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public SdkException(ErrorResult r100, String r101) {
        super(r101);
        this.errorResult = r100;
    }

    public /* synthetic */ SdkException(ErrorResult r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}

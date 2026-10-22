package com.ss.android.lark.watermark.mysterious;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/watermark/mysterious/NullResponseException;", "Lcom/ss/android/lark/watermark/mysterious/SdkException;", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "message", "", "<init>", "(Lcom/larksuite/framework/callback/Entity/ErrorResult;Ljava/lang/String;)V", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NullResponseException extends SdkException {
    public NullResponseException(ErrorResult r100, String r101) {
        super(r100, r101);
    }

    public /* synthetic */ NullResponseException(ErrorResult r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}

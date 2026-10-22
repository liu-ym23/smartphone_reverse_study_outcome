package com.bytedance.supervisor.wrapper.common;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/supervisor/wrapper/common/SensitiveAPIException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", LKBaseResponseModel.ERROR_NO_KEY, "", "errorMsg", "", "(ILjava/lang/String;)V", "getErrno", "()I", "wrapper_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SensitiveAPIException extends Exception {
    private final int errno;
    private final String errorMsg;

    public final int getErrno() {
        return this.errno;
    }

    public SensitiveAPIException(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        super(r101);
        this.errno = r100;
        this.errorMsg = r101;
    }

    public /* synthetic */ SensitiveAPIException(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101);
    }
}

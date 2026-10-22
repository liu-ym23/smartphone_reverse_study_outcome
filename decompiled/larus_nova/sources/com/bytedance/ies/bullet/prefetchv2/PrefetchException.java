package com.bytedance.ies.bullet.prefetchv2;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", EventConstant.Key.MODULE, "getModule", "()Ljava/lang/String;", "setModule", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PrefetchException extends Exception {
    private String module;

    public final String getModule() {
        return this.module;
    }

    public PrefetchException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }

    public final void setModule(String r100) {
        this.module = r100;
    }
}

package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/UnhandledException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UnhandledException extends Exception {
    public UnhandledException() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public UnhandledException(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2);
    }

    public /* synthetic */ UnhandledException(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}

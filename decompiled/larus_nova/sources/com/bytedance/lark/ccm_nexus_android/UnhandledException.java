package com.bytedance.lark.ccm_nexus_android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/ccm_nexus_android/UnhandledException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "ccm_nexus_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class UnhandledException extends Exception {
    /* JADX WARN: Multi-variable type inference failed */
    public UnhandledException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UnhandledException(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }

    public /* synthetic */ UnhandledException(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}

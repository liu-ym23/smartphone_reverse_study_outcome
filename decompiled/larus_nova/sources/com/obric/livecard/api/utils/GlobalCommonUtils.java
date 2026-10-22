package com.obric.livecard.api.utils;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J#\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/livecard/api/utils/GlobalCommonUtils;", "", "()V", "getThreadStackInfo", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "getStackInfo", "", "Ljava/lang/StackTraceElement;", "([Ljava/lang/StackTraceElement;I)Ljava/lang/String;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalCommonUtils {
    public static final GlobalCommonUtils INSTANCE = null;

    static {
        INSTANCE = new GlobalCommonUtils();
    }

    private GlobalCommonUtils() {
    }

    public final String getThreadStackInfo(int r100) {
        return getStackInfo(ThreadMethodProxy.currentThread().getStackTrace(), r100);
    }

    public final String getStackInfo(StackTraceElement[] r110, int r111) {
        if (r110 == null) goto L8;
        List r112 = ArraysKt.drop(r110, 3);
        if (r112 == null) goto L8;
        List r113 = CollectionsKt.take(r112, r111);
        if (r113 == null) goto L8;
        return CollectionsKt.joinToString$default(r113, "\n", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    L8:
        return null;
    }

    public static /* synthetic */ String getThreadStackInfo$default(GlobalCommonUtils r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = 7;
    L6:
        return r100.getThreadStackInfo(r101);
    }

    public static /* synthetic */ String getStackInfo$default(GlobalCommonUtils r100, StackTraceElement[] r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r102 = 7;
    L6:
        return r100.getStackInfo(r101, r102);
    }
}

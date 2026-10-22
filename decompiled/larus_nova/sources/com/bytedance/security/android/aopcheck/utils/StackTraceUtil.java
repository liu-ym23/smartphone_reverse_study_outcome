package com.bytedance.security.android.aopcheck.utils;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/security/android/aopcheck/utils/StackTraceUtil;", "", "()V", "getRawStack", "", LynxError.LYNX_THROWABLE, "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class StackTraceUtil {
    public static final StackTraceUtil INSTANCE = null;

    private StackTraceUtil() {
    }

    static {
        INSTANCE = new StackTraceUtil();
    }

    public final String getRawStack(Throwable r100) {
        StringBuffer r101 = new StringBuffer();
        StackTraceElement[] r102 = r100.getStackTrace();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L16;
        StackTraceElement r106 = r102[r104];
        if (r105 >= 6) goto L8;
        r105 = r105 + 1;
    L14:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r101.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        r101.append(System.getProperty("line.separator"));
    L13:
        r101.append(r106.toString());
        goto L14
    L10:
        r107 = false;
        goto L11
    L16:
        return r101.toString();
    }
}

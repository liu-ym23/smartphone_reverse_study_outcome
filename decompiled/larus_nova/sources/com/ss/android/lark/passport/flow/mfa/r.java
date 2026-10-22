package com.ss.android.lark.passport.flow.mfa;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f437911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f437912b = null;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((0 * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public final String toString() {
        return "FlowMfaVerifyCompleteStepInfo(scope=null, mfaToken=null, mfaCode=null, useLocalStorage=null)";
    }

    static {
        f437911a = CollectionsKt.listOf(new String[]{"mfa_token", "mfaToken", "token"});
        f437912b = CollectionsKt.listOf(new String[]{"mfa_code", "mfaCode", "code"});
    }
}

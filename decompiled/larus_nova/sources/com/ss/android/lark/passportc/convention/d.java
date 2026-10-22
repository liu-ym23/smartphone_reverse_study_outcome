package com.ss.android.lark.passportc.convention;

import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {
    public static final boolean a(UserSession r100, UserSession r101) {
        if (r100 != null) goto L6;
        if (r101 == null) goto L6;
        return true;
    L6:
        if (r100 == null) goto L10;
        if (r101 != null) goto L10;
        return true;
    L10:
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        if (Intrinsics.areEqual(r100.f438137a, r101.f438137a) == true) goto L15;
        return true;
    L15:
        return false;
    }
}

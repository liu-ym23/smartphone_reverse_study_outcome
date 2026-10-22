package com.bytedance.dux.largefont;

import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.api.IDuxComponentService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class DuxLargeFontHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f205243a = null;

    static {
        f205243a = LazyKt.lazy(DuxLargeFontHelper$service$2.INSTANCE);
    }

    public static boolean a(DuxComponent r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L13;
        Pair<Boolean, Boolean> r102 = ((IDuxComponentService) f205243a.getValue()).verifyLargeFontModeAdapt(r100.getId());
        if (r102 != null) goto L7;
        return true;
    L7:
        boolean r103 = r102.getFirst().booleanValue();
        boolean r104 = r102.getSecond().booleanValue();
        if (r103 == false) goto L11;
        if (r104 == true) goto L11;
        return true;
    L11:
        return false;
    L13:
        return r101.booleanValue();
    }
}

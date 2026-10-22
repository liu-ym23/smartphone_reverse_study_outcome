package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267576a = 0;

    public static final class a {
        public static Double a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "str");
            Intrinsics.checkNotNullParameter(r100, "str");
            x r101 = l.a(r100, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L15
            __RTS_internal_ExplicitType r102 = r101.f267597c;     // Catch: NumberFormatException -> L15
            if (r102 == __RTS_internal_ExplicitType.UNKNOWN) goto L9;
            if (r102 != __RTS_internal_ExplicitType.FLOAT_64) goto L13;
        L9:
            if (r101.f267596b != __RTS_internal_NumberBase.DECIMAL) goto L13;
            return Double.valueOf(CastDoubleProtector.parseDouble(r101.f267595a));
        L13:
            return null;
        }
    }

    static {
    }
}

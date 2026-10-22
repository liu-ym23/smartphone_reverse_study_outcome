package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Double a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            Intrinsics.checkNotNullParameter(r2, "str");
            x r3 = l.a(r2, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L15
            __RTS_internal_ExplicitType r0 = r3.c;     // Catch: NumberFormatException -> L15
            if (r0 == __RTS_internal_ExplicitType.UNKNOWN) goto L9;
            if (r0 != __RTS_internal_ExplicitType.FLOAT_64) goto L13;
        L9:
            if (r3.b != __RTS_internal_NumberBase.DECIMAL) goto L13;
            return Double.valueOf(CastDoubleProtector.parseDouble(r3.a));
        L13:
            return null;
        }
    }

    static {
    }
}

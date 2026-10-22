package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static Long a(String r2) {
            int r0 = e.a;
            Intrinsics.checkNotNullParameter(r2, "str");
            Intrinsics.checkNotNullParameter(r2, "str");
            x r3 = l.a(r2, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L12
            __RTS_internal_ExplicitType r1 = r3.c;     // Catch: NumberFormatException -> L12
            if (r1 != __RTS_internal_ExplicitType.UNKNOWN) goto L6;
        L8:
            return Long.valueOf(CastLongProtector.parseLong(r3.a, CharsKt.checkRadix(10)));
        L6:
            if (r1 == __RTS_internal_ExplicitType.INT_64) goto L8;
        L10:
            return null;
        }
    }

    static {
        new a();
    }
}

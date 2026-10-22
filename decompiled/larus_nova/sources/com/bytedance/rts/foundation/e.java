package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f267578a = 0;

    public static final class a {
        public a() {
        }

        public static Long a(String r100) {
            int r101 = e.f267578a;
            Intrinsics.checkNotNullParameter(r100, "str");
            Intrinsics.checkNotNullParameter(r100, "str");
            x r102 = l.a(r100, __RTS_internal_ParseOption.PARSE);     // Catch: NumberFormatException -> L12
            __RTS_internal_ExplicitType r103 = r102.f267597c;     // Catch: NumberFormatException -> L12
            if (r103 != __RTS_internal_ExplicitType.UNKNOWN) goto L6;
        L8:
            return Long.valueOf(CastLongProtector.parseLong(r102.f267595a, CharsKt.checkRadix(10)));
        L6:
            if (r103 == __RTS_internal_ExplicitType.INT_64) goto L8;
        L10:
            return null;
        }
    }

    static {
        new a();
    }
}

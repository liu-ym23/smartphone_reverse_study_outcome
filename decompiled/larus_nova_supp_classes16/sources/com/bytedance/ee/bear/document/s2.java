package com.bytedance.ee.bear.document;

import com.ss.android.lark.chameleon.ResConfig;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s2 {
    public static s2 c;
    public final ResConfig a;
    public final Function1<String, Map<String, String>> b;

    public static final class a {
        public static s2 a() {
            s2 r0 = s2.c;
            if (r0 == null) goto L5;
            ResConfig r1 = r0.a;
            Function1<String, Map<String, String>> r2 = r0.b;
            Intrinsics.checkNotNullParameter(r1, "resConfig");
            return new s2(r1, r2);
        L5:
            return null;
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s2) == true) goto L8;
        return false;
    L8:
        s2 r6 = (s2) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Function1<String, Map<String, String>> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DocsTemplateConfig(resConfig=" + this.a + ", getBizTemplateVars=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s2(ResConfig r2, Function1<? super String, ? extends Map<String, String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "resConfig");
        this.a = r2;
        this.b = r3;
    }
}

package com.bytedance.ee.bear.document;

import com.ss.android.lark.chameleon.ResConfig;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static s2 f221500c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResConfig f221501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<String, Map<String, String>> f221502b;

    public static final class a {
        public static s2 a() {
            s2 r100 = s2.f221500c;
            if (r100 == null) goto L5;
            ResConfig r101 = r100.f221501a;
            Function1<String, Map<String, String>> r102 = r100.f221502b;
            Intrinsics.checkNotNullParameter(r101, "resConfig");
            return new s2(r101, r102);
        L5:
            return null;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s2) == true) goto L8;
        return false;
    L8:
        s2 r101 = (s2) r100;
        if (Intrinsics.areEqual(this.f221501a, r101.f221501a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f221502b, r101.f221502b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f221501a.hashCode() * 31;
        Function1<String, Map<String, String>> r101 = this.f221502b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DocsTemplateConfig(resConfig=" + this.f221501a + ", getBizTemplateVars=" + this.f221502b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s2(ResConfig r100, Function1<? super String, ? extends Map<String, String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "resConfig");
        this.f221501a = r100;
        this.f221502b = r101;
    }
}

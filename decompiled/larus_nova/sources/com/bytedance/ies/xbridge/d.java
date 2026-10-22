package com.bytedance.ies.xbridge;

import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Method, f> f249464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, f> f249465b;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f249464a, r101.f249464a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f249465b, r101.f249465b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f249464a.hashCode() * 31) + this.f249465b.hashCode();
    }

    public final String toString() {
        return "IDLAnnotationModel(methodModel=" + this.f249464a + ", stringModel=" + this.f249465b + ')';
    }

    public d(Object r100) {
        HashMap<Method, f> r101 = new HashMap();
        HashMap<String, f> r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r101, "methodModel");
        Intrinsics.checkNotNullParameter(r102, "stringModel");
        this.f249464a = r101;
        this.f249465b = r102;
    }
}

package me7;

import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Method, i> f513529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, i> f513530b;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f513529a, r101.f513529a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513530b, r101.f513530b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f513529a.hashCode() * 31) + this.f513530b.hashCode();
    }

    public final String toString() {
        return "IDLAnnotationModel(methodModel=" + this.f513529a + ", stringModel=" + this.f513530b + ')';
    }

    public g(Object r100) {
        HashMap<Method, i> r101 = new HashMap();
        HashMap<String, i> r102 = new HashMap();
        Intrinsics.checkNotNullParameter(r101, "methodModel");
        Intrinsics.checkNotNullParameter(r102, "stringModel");
        this.f513529a = r101;
        this.f513530b = r102;
    }
}

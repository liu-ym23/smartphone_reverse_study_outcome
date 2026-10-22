package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f249485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f249486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KClass<? extends XBaseModel> f249487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KClass<? extends Object> f249488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f249489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f249490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f249491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<?> f249492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f249493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f249494j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f249485a == r101.f249485a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f249486b, r101.f249486b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f249487c, r101.f249487c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f249488d, r101.f249488d) == true) goto L21;
        return false;
    L21:
        if (this.f249489e == r101.f249489e) goto L24;
        return false;
    L24:
        if (this.f249490f == r101.f249490f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f249491g, r101.f249491g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f249492h, r101.f249492h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f249493i, r101.f249493i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f249494j, r101.f249494j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f249485a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((r101 * 31) + this.f249486b.hashCode()) * 31) + this.f249487c.hashCode()) * 31) + this.f249488d.hashCode()) * 31;
        if (this.f249489e == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f249490f == true) goto L15;
        r100 = 1237;
    L15:
        return ((((((((r104 + r100) * 31) + this.f249491g.hashCode()) * 31) + this.f249492h.hashCode()) * 31) + this.f249493i.hashCode()) * 31) + this.f249494j.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "IDLParamField(required=" + this.f249485a + ", keyPath=" + this.f249486b + ", nestedClassType=" + this.f249487c + ", primitiveClassType=" + this.f249488d + ", isEnum=" + this.f249489e + ", isGetter=" + this.f249490f + ", defaultValue=" + this.f249491g + ", returnType=" + this.f249492h + ", stringEnum=" + this.f249493i + ", intEnum=" + this.f249494j + ')';
    }

    public f(boolean r100, String r101, KClass<? extends XBaseModel> r102, KClass<? extends Object> r103, boolean r104, boolean r105, e r106, Class<?> r107, List<String> r110, List<Integer> r111) {
        Intrinsics.checkNotNullParameter(r101, "keyPath");
        Intrinsics.checkNotNullParameter(r102, "nestedClassType");
        Intrinsics.checkNotNullParameter(r103, "primitiveClassType");
        Intrinsics.checkNotNullParameter(r106, "defaultValue");
        Intrinsics.checkNotNullParameter(r107, "returnType");
        Intrinsics.checkNotNullParameter(r110, "stringEnum");
        Intrinsics.checkNotNullParameter(r111, "intEnum");
        this.f249485a = r100;
        this.f249486b = r101;
        this.f249487c = r102;
        this.f249488d = r103;
        this.f249489e = r104;
        this.f249490f = r105;
        this.f249491g = r106;
        this.f249492h = r107;
        this.f249493i = r110;
        this.f249494j = r111;
    }
}

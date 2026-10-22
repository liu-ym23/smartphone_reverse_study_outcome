package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes22.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f513537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f513538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KClass<? extends XBaseModel> f513539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KClass<? extends Object> f513540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f513541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f513542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f513543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class<?> f513544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f513545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f513546j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f513537a == r101.f513537a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513538b, r101.f513538b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513539c, r101.f513539c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f513540d, r101.f513540d) == true) goto L21;
        return false;
    L21:
        if (this.f513541e == r101.f513541e) goto L24;
        return false;
    L24:
        if (this.f513542f == r101.f513542f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f513543g, r101.f513543g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f513544h, r101.f513544h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f513545i, r101.f513545i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f513546j, r101.f513546j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f513537a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((r101 * 31) + this.f513538b.hashCode()) * 31) + this.f513539c.hashCode()) * 31) + this.f513540d.hashCode()) * 31;
        if (this.f513541e == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f513542f == true) goto L15;
        r100 = 1237;
    L15:
        return ((((((((r104 + r100) * 31) + this.f513543g.hashCode()) * 31) + this.f513544h.hashCode()) * 31) + this.f513545i.hashCode()) * 31) + this.f513546j.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "IDLParamField(required=" + this.f513537a + ", keyPath=" + this.f513538b + ", nestedClassType=" + this.f513539c + ", primitiveClassType=" + this.f513540d + ", isEnum=" + this.f513541e + ", isGetter=" + this.f513542f + ", defaultValue=" + this.f513543g + ", returnType=" + this.f513544h + ", stringEnum=" + this.f513545i + ", intEnum=" + this.f513546j + ')';
    }

    public i(boolean r100, String r101, KClass<? extends XBaseModel> r102, KClass<? extends Object> r103, boolean r104, boolean r105, h r106, Class<?> r107, List<String> r110, List<Integer> r111) {
        Intrinsics.checkNotNullParameter(r101, "keyPath");
        Intrinsics.checkNotNullParameter(r102, "nestedClassType");
        Intrinsics.checkNotNullParameter(r103, "primitiveClassType");
        Intrinsics.checkNotNullParameter(r106, "defaultValue");
        Intrinsics.checkNotNullParameter(r107, "returnType");
        Intrinsics.checkNotNullParameter(r110, "stringEnum");
        Intrinsics.checkNotNullParameter(r111, "intEnum");
        this.f513537a = r100;
        this.f513538b = r101;
        this.f513539c = r102;
        this.f513540d = r103;
        this.f513541e = r104;
        this.f513542f = r105;
        this.f513543g = r106;
        this.f513544h = r107;
        this.f513545i = r110;
        this.f513546j = r111;
    }
}

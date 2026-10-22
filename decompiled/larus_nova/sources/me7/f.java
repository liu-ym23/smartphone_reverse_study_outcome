package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f513524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f513525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f513526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f513527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends XBaseModel>, g> f513528e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f513524a, r101.f513524a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513525b, r101.f513525b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513526c, r101.f513526c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f513527d, r101.f513527d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f513528e, r101.f513528e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f513524a.hashCode() * 31) + this.f513525b.hashCode()) * 31) + this.f513526c.hashCode()) * 31) + this.f513527d.hashCode()) * 31) + this.f513528e.hashCode();
    }

    public final String toString() {
        return "IDLAnnotationData(paramClass=" + this.f513524a + ", resultClass=" + this.f513525b + ", xBridgeParamModel=" + this.f513526c + ", xBridgeResultModel=" + this.f513527d + ", models=" + this.f513528e + ')';
    }

    public f(Class<?> r100, Class<?> r101, g r102, g r103, Map<Class<? extends XBaseModel>, g> r104) {
        Intrinsics.checkNotNullParameter(r100, "paramClass");
        Intrinsics.checkNotNullParameter(r101, "resultClass");
        Intrinsics.checkNotNullParameter(r102, "xBridgeParamModel");
        Intrinsics.checkNotNullParameter(r103, "xBridgeResultModel");
        Intrinsics.checkNotNullParameter(r104, "models");
        this.f513524a = r100;
        this.f513525b = r101;
        this.f513526c = r102;
        this.f513527d = r103;
        this.f513528e = r104;
    }
}

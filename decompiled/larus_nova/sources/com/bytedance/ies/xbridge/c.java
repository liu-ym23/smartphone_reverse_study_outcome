package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f249458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f249459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f249460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f249461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<? extends XBaseModel>, d> f249462e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f249458a, r101.f249458a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f249459b, r101.f249459b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f249460c, r101.f249460c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f249461d, r101.f249461d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f249462e, r101.f249462e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f249458a.hashCode() * 31) + this.f249459b.hashCode()) * 31) + this.f249460c.hashCode()) * 31) + this.f249461d.hashCode()) * 31) + this.f249462e.hashCode();
    }

    public final String toString() {
        return "IDLAnnotationData(paramClass=" + this.f249458a + ", resultClass=" + this.f249459b + ", xBridgeParamModel=" + this.f249460c + ", xBridgeResultModel=" + this.f249461d + ", models=" + this.f249462e + ')';
    }

    public c(Class<?> r100, Class<?> r101, d r102, d r103, Map<Class<? extends XBaseModel>, d> r104) {
        Intrinsics.checkNotNullParameter(r100, "paramClass");
        Intrinsics.checkNotNullParameter(r101, "resultClass");
        Intrinsics.checkNotNullParameter(r102, "xBridgeParamModel");
        Intrinsics.checkNotNullParameter(r103, "xBridgeResultModel");
        Intrinsics.checkNotNullParameter(r104, "models");
        this.f249458a = r100;
        this.f249459b = r101;
        this.f249460c = r102;
        this.f249461d = r103;
        this.f249462e = r104;
    }
}

package com.bytedance.locallife.cube.impl;

import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CubeInternalSchemaModel f257233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f257235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f257236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f257237e;

    public final int hashCode() {
        return (((((((this.f257233a.getSchema().hashCode() * 31) + this.f257234b.hashCode()) * 31) + this.f257235c.hashCode()) * 31) + this.f257236d.hashCode()) * 31) + this.f257237e.hashCode();
    }

    public d(CubeInternalSchemaModel r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        this.f257233a = r100;
        this.f257234b = r100.getLynxChannel();
        this.f257235c = r100.getLynxBundle();
        kp6.c r101 = kp6.c.f505514a;
        String r102 = r100.getSchema();
        r101.getClass();
        this.f257236d = kp6.c.i(r102, false);
        this.f257237e = kp6.c.i(r100.getSchema(), true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(d.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.cube.impl.CubeLoadRecord");
        d r102 = (d) r100;
        if (Intrinsics.areEqual(this.f257233a.getSchema(), r102.f257233a.getSchema()) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f257234b, r102.f257234b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f257235c, r102.f257235c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f257236d, r102.f257236d) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f257237e, r102.f257237e) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}

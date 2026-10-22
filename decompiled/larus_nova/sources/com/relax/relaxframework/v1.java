package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PropertyValueType f405316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ModifierValuePattern f405317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f405318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f405319d;

    public boolean a(v1 r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        return false;
    }

    public Object b() {
        return null;
    }

    public final PropertyValueType getType() {
        PropertyValueType r100 = this.f405316a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public v1(PropertyValueType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f405317b = ModifierValuePattern.EMPTY;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405316a = r100;
    }
}

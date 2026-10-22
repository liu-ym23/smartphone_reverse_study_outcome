package com.larus.home.impl.main.side_bar.data;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f344518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f344519b;

    public static final class a {
    }

    static {
    }

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f344518a, r101.f344518a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344519b, r101.f344519b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f344518a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, Boolean> r104 = this.f344519b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProjectExpandCache(globalExpandAll=" + this.f344518a + ", projects=" + this.f344519b + ')';
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "projectId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return false;
    L8:
        Map<String, Boolean> r102 = this.f344519b;
        if (r102 != null) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        Boolean r103 = r102.get(r100);
        if (r103 != null) goto L17;
        r103 = this.f344518a;
        if (r103 != null) goto L17;
        return false;
    L17:
        return r103.booleanValue();
    L5:
        r101 = false;
        goto L6
    }

    public l(Boolean r100, Map<String, Boolean> r101) {
        this.f344518a = r100;
        this.f344519b = r101;
    }
}

package com.bytedance.ies.argus.repository;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class m extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f246133g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f246134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f246135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Set<com.bytedance.ies.argus.bean.n>> f246136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Set<String>> f246137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ies.argus.bean.feStrategy.b f246138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f246139f;

    public static final class a {
    }

    static {
    }

    public m() {
        this(false, SetsKt.emptySet(), MapsKt.emptyMap(), MapsKt.emptyMap(), null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f246134a == r101.f246134a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246135b, r101.f246135b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246136c, r101.f246136c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246137d, r101.f246137d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246138e, r101.f246138e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f246139f, r101.f246139f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f246134a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((r100 * 31) + this.f246135b.hashCode()) * 31) + this.f246136c.hashCode()) * 31) + this.f246137d.hashCode()) * 31;
        com.bytedance.ies.argus.bean.feStrategy.b r102 = this.f246138e;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        JSONObject r106 = this.f246139f;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "RecoveryConfigModel(forceCloseAll=" + this.f246134a + ", containerIdWithAllAspectsDisabled=" + this.f246135b + ", disabledAspectsByContainerId=" + this.f246136c + ", disabledStrategiesByContainerId=" + this.f246137d + ", jsbAuthRecoveryConfig=" + this.f246138e + ", plugin=" + this.f246139f + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(boolean r100, Set<String> r101, Map<String, ? extends Set<? extends com.bytedance.ies.argus.bean.n>> r102, Map<String, ? extends Set<String>> r103, com.bytedance.ies.argus.bean.feStrategy.b r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r101, "containerIdWithAllAspectsDisabled");
        Intrinsics.checkNotNullParameter(r102, "disabledAspectsByContainerId");
        Intrinsics.checkNotNullParameter(r103, "disabledStrategiesByContainerId");
        this.f246134a = r100;
        this.f246135b = r101;
        this.f246136c = r102;
        this.f246137d = r103;
        this.f246138e = r104;
        this.f246139f = r105;
    }
}

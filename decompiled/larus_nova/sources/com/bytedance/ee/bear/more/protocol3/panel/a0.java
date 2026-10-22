package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f234928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f234929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f234930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f234931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f234932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Boolean> f234933f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f234928a, r101.f234928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234929b, r101.f234929b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234930c, r101.f234930c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234931d, r101.f234931d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234932e, r101.f234932e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234933f, r101.f234933f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f234928a.hashCode() * 31) + this.f234929b.hashCode()) * 31) + this.f234930c.hashCode()) * 31) + this.f234931d.hashCode()) * 31) + this.f234932e.hashCode()) * 31) + this.f234933f.hashCode();
    }

    public final String toString() {
        return "MorePanelJsState(disabledItemIds=" + this.f234928a + ", disableReasons=" + this.f234929b + ", switchOnItemIds=" + this.f234930c + ", invisibleItemIds=" + this.f234931d + ", badgeItemIds=" + this.f234932e + ", benefitEnabled=" + this.f234933f + ')';
    }

    public a0() {
        this(SetsKt.emptySet(), MapsKt.emptyMap(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), MapsKt.emptyMap());
    }

    public a0(Set<String> r100, Map<String, String> r101, Set<String> r102, Set<String> r103, Set<String> r104, Map<String, Boolean> r105) {
        Intrinsics.checkNotNullParameter(r100, "disabledItemIds");
        Intrinsics.checkNotNullParameter(r101, "disableReasons");
        Intrinsics.checkNotNullParameter(r102, "switchOnItemIds");
        Intrinsics.checkNotNullParameter(r103, "invisibleItemIds");
        Intrinsics.checkNotNullParameter(r104, "badgeItemIds");
        Intrinsics.checkNotNullParameter(r105, "benefitEnabled");
        this.f234928a = r100;
        this.f234929b = r101;
        this.f234930c = r102;
        this.f234931d = r103;
        this.f234932e = r104;
        this.f234933f = r105;
    }
}

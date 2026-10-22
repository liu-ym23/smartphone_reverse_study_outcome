package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 {
    public final Set<String> a;
    public final Map<String, String> b;
    public final Set<String> c;
    public final Set<String> d;
    public final Set<String> e;
    public final Map<String, Boolean> f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "MorePanelJsState(disabledItemIds=" + this.a + ", disableReasons=" + this.b + ", switchOnItemIds=" + this.c + ", invisibleItemIds=" + this.d + ", badgeItemIds=" + this.e + ", benefitEnabled=" + this.f + ')';
    }

    public a0() {
        this(SetsKt.emptySet(), MapsKt.emptyMap(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), MapsKt.emptyMap());
    }

    public a0(Set<String> r2, Map<String, String> r3, Set<String> r4, Set<String> r5, Set<String> r6, Map<String, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r2, "disabledItemIds");
        Intrinsics.checkNotNullParameter(r3, "disableReasons");
        Intrinsics.checkNotNullParameter(r4, "switchOnItemIds");
        Intrinsics.checkNotNullParameter(r5, "invisibleItemIds");
        Intrinsics.checkNotNullParameter(r6, "badgeItemIds");
        Intrinsics.checkNotNullParameter(r7, "benefitEnabled");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}

package com.larus.dispatcher.askhuman.handler;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f330929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f330930c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f330928a, r101.f330928a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f330929b, r101.f330929b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f330930c, r101.f330930c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f330928a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f330929b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.f330930c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ServerOption(callbackId=" + this.f330928a + ", scene=" + this.f330929b + ", params=" + this.f330930c + ')';
    }

    public u(String r100, Integer r101, Map<String, ? extends Object> r102) {
        this.f330928a = r100;
        this.f330929b = r101;
        this.f330930c = r102;
    }
}

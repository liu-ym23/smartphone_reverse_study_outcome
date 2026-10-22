package com.bytedance.locallife.live.msgcenter;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pv6.c;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f260629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f260630c;

    public /* synthetic */ b() {
        throw null;
    }

    public final String toString() {
        return "MsgSubscriber(eventName=" + this.f260628a + ", extra=" + this.f260629b + ", jsEventDelegate=" + this.f260630c + ')';
    }

    public final int hashCode() {
        int r100 = this.f260628a.hashCode() * 31;
        Map<String, Object> r101 = this.f260629b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.locallife.live.msgcenter.MsgSubscriber");
        b r102 = (b) r100;
        if (Intrinsics.areEqual(this.f260628a, r102.f260628a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f260629b, r102.f260629b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public b(String r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "jsEventDelegate");
        this.f260628a = r100;
        this.f260629b = r101;
        this.f260630c = r102;
    }

    public static void a(b r100, String r101, Map r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "eventName");
        c r103 = r100.f260630c;
        LinkedHashMap r104 = new LinkedHashMap();
        Map<String, Object> r105 = r100.f260629b;
        String r106 = null;
        if (r105 == null) goto L6;
        Object r107 = r105.get("containerID");
        if (r107 == null) goto L6;
    L8:
        if ((r107 instanceof String) == false) goto L10;
        r106 = (String) r107;
    L10:
        if (r106 == null) goto L12;
        r104.put("containerID", r106);
    L12:
        Unit r108 = Unit.INSTANCE;
        r103.a(r101, r102, r104);
        return;
    L6:
        r107 = null;
        goto L8
    }
}

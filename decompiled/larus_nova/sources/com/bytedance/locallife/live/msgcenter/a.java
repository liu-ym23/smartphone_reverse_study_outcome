package com.bytedance.locallife.live.msgcenter;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f260625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f260626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, Object> f260627d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f260624a, r101.f260624a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f260625b, r101.f260625b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f260626c, r101.f260626c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f260624a.hashCode() * 31;
        Map<String, Object> r101 = this.f260625b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, Object> r105 = this.f260626c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "Message(eventName=" + this.f260624a + ", params=" + this.f260625b + ", extra=" + this.f260626c + ')';
    }

    public a(String r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f260624a = r100;
        this.f260625b = r101;
        this.f260626c = r102;
    }

    public /* synthetic */ a(String r100, Map r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}

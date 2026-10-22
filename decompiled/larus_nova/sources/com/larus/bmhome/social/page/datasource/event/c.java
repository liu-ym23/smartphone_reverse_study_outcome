package com.larus.bmhome.social.page.datasource.event;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f314033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f314034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f314035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f314036d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f314033a, r101.f314033a) == true) goto L12;
        return false;
    L12:
        if (this.f314034b == r101.f314034b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314035c, r101.f314035c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f314036d, r101.f314036d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f314033a.hashCode() * 31;
        long r101 = this.f314034b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f314035c.hashCode()) * 31) + this.f314036d.hashCode();
    }

    public final String toString() {
        return "ListUpdateEvent(version=" + this.f314034b + ", size=" + this.f314033a.size() + ", rt=" + this.f314036d + ')';
    }

    public /* synthetic */ c(List r100, long r101, List r110) {
        this(r100, r101, r110, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends T> r100, long r101, List<? extends b> r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "listData");
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r103, "refreshTraceId");
        this.f314033a = r100;
        this.f314034b = r101;
        this.f314035c = r102;
        this.f314036d = r103;
    }

    public static c a(c r100, List r101, long r102, List r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f314033a;
    L5:
        List r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f314034b;
    L8:
        long r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f314035c;
    L11:
        List r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        r111 = r100.f314036d;
    L14:
        String r106 = r111;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "listData");
        Intrinsics.checkNotNullParameter(r105, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r106, "refreshTraceId");
        return new c(r103, r104, r105, r106);
    }
}

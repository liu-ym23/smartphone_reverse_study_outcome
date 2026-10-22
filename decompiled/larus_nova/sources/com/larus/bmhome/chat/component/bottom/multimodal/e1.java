package com.larus.bmhome.chat.component.bottom.multimodal;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f299764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f299765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h1 f299766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f299767d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (Intrinsics.areEqual(this.f299764a, r101.f299764a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299765b, r101.f299765b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299766c, r101.f299766c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f299767d, r101.f299767d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f299764a.hashCode() * 31) + this.f299765b.hashCode()) * 31;
        h1 r101 = this.f299766c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Map<String, String> r105 = this.f299767d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultimodalInputIntent(source=" + this.f299764a + ", processConfig=" + this.f299765b + ", textMessage=" + this.f299766c + ", eventExt=" + this.f299767d + ')';
    }

    public e1(f1 r100, g1 r101, h1 r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "processConfig");
        this.f299764a = r100;
        this.f299765b = r101;
        this.f299766c = r102;
        this.f299767d = r103;
    }

    public /* synthetic */ e1(f1 r100, g1 r101, h1 r102, Map r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}

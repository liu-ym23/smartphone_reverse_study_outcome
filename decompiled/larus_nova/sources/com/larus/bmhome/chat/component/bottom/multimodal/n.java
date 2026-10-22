package com.larus.bmhome.chat.component.bottom.multimodal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f299909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g1 f299910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h1 f299911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f299912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f299913e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f299909a, r101.f299909a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299910b, r101.f299910b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299911c, r101.f299911c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f299912d, r101.f299912d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f299913e, r101.f299913e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f299909a.hashCode() * 31) + this.f299910b.hashCode()) * 31;
        h1 r101 = this.f299911c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f299912d.hashCode()) * 31;
        m r105 = this.f299913e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultimodalData(attachments=" + this.f299909a + ", processConfig=" + this.f299910b + ", textMessage=" + this.f299911c + ", eventExt=" + this.f299912d + ", bizData=" + this.f299913e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(List<? extends a> r100, g1 r101, h1 r102, Map<String, String> r103, m r104) {
        Intrinsics.checkNotNullParameter(r100, "attachments");
        Intrinsics.checkNotNullParameter(r101, "processConfig");
        Intrinsics.checkNotNullParameter(r103, "eventExt");
        this.f299909a = r100;
        this.f299910b = r101;
        this.f299911c = r102;
        this.f299912d = r103;
        this.f299913e = r104;
    }

    public /* synthetic */ n(List r100, g1 r110, h1 r111, Map r112, m r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        h1 r101 = null;
    L7:
        if ((r114 & 8) == 0) goto L9;
        r112 = new LinkedHashMap();
    L9:
        Map r102 = r112;
        if ((r114 & 16) == 0) goto L12;
        m r103 = null;
    L13:
        this(r100, r110, r101, r102, r103);
        return;
    L12:
        r103 = r113;
        goto L13
    L5:
        r101 = r111;
        goto L7
    }
}

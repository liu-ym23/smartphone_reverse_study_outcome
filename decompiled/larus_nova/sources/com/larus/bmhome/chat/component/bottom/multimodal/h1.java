package com.larus.bmhome.chat.component.bottom.multimodal;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f299786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f299787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f299788c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.f299786a, r101.f299786a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f299787b, r101.f299787b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f299788c, r101.f299788c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f299786a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f299787b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f299788c;
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
        return "MultimodalTextMessageData(content=" + this.f299786a + ", ext=" + this.f299787b + ", eventExt=" + this.f299788c + ')';
    }

    public h1(String r100, Map<String, String> r101, Map<String, String> r102) {
        this.f299786a = r100;
        this.f299787b = r101;
        this.f299788c = r102;
    }

    public /* synthetic */ h1(String r100, Map r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = new LinkedHashMap();
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = new LinkedHashMap();
    L8:
        this(r100, r101, r102);
    }
}

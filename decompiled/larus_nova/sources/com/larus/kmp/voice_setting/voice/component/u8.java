package com.larus.kmp.voice_setting.voice.component;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u8 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t8> f352570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f352571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f352572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f352574e;

    public u8() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u8) == true) goto L8;
        return false;
    L8:
        u8 r101 = (u8) r100;
        if (Intrinsics.areEqual(this.f352570a, r101.f352570a) == true) goto L12;
        return false;
    L12:
        if (this.f352571b == r101.f352571b) goto L15;
        return false;
    L15:
        if (this.f352572c == r101.f352572c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352573d, r101.f352573d) == true) goto L21;
        return false;
    L21:
        if (this.f352574e == r101.f352574e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f352570a.hashCode() * 31) + this.f352571b) * 31) + this.f352572c) * 31;
        String r101 = this.f352573d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f352574e == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceTabPagerStateData(pages=" + this.f352570a + ", selectedPageIndex=" + this.f352571b + ", settledPageIndex=" + this.f352572c + ", selectedTabKey=" + this.f352573d + ", selectTabOnPagerVisiblePageChange=" + this.f352574e + ')';
    }

    public /* synthetic */ u8(int r100) {
        this(CollectionsKt.emptyList(), 0, 0, null, false);
    }

    public u8(List<t8> r100, int r101, int r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "pages");
        this.f352570a = r100;
        this.f352571b = r101;
        this.f352572c = r102;
        this.f352573d = r103;
        this.f352574e = r104;
    }
}

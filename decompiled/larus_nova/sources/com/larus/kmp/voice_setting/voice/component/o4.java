package com.larus.kmp.voice_setting.voice.component;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f352438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n4 f352439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<m4> f352440c;

    public o4() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r101 = (o4) r100;
        if (this.f352438a == r101.f352438a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352439b, r101.f352439b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352440c, r101.f352440c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f352438a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f352439b.hashCode()) * 31) + this.f352440c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "VoiceDropdownMenuUiState(isVisible=" + this.f352438a + ", request=" + this.f352439b + ", items=" + this.f352440c + ')';
    }

    public /* synthetic */ o4(int r100) {
        this(false, new n4(0), CollectionsKt.emptyList());
    }

    public static o4 a(o4 r100) {
        n4 r101 = r100.f352439b;
        List<m4> r102 = r100.f352440c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "items");
        return new o4(false, r101, r102);
    }

    public o4(boolean r100, n4 r101, List<m4> r102) {
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "items");
        this.f352438a = r100;
        this.f352439b = r101;
        this.f352440c = r102;
    }
}

package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import java.util.Map;
import java.util.Set;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, c> f435088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f435089c;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f435087a == r101.f435087a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f435088b, r101.f435088b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f435089c, r101.f435089c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f435087a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.f435088b.hashCode()) * 31) + this.f435089c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingSpeakerEntity(isSpeakerMarkingEnabled=" + this.f435087a + ", markedSpeakerMap=" + this.f435088b + ", noMappingClusterIds=" + this.f435089c + ')';
    }

    public /* synthetic */ f(int r100) {
        this(false, MapsKt.emptyMap(), SetsKt.emptySet());
    }

    public f(boolean r100, Map<String, c> r101, Set<String> r102) {
        Intrinsics.checkNotNullParameter(r101, "markedSpeakerMap");
        Intrinsics.checkNotNullParameter(r102, "noMappingClusterIds");
        this.f435087a = r100;
        this.f435088b = r101;
        this.f435089c = r102;
    }

    public static f a(f r100, boolean r101, Map r102, Set r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f435087a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f435088b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f435089c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "markedSpeakerMap");
        Intrinsics.checkNotNullParameter(r103, "noMappingClusterIds");
        return new f(r101, r102, r103);
    }
}

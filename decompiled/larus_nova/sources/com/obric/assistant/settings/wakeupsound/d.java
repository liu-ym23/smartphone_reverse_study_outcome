package com.obric.assistant.settings.wakeupsound;

import com.obric.assistant.WakeupSoundEffectSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h> f392503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f392504c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f392502a, r101.f392502a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392503b, r101.f392503b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f392504c, r101.f392504c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f392502a.hashCode() * 31) + this.f392503b.hashCode()) * 31;
        String r101 = this.f392504c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ObricWakeupSoundEffectUiState(pageName=" + this.f392502a + ", rows=" + this.f392503b + ", playingValue=" + this.f392504c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r100, List<? extends h> r101, @WakeupSoundEffectSettings String r102) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "rows");
        this.f392502a = r100;
        this.f392503b = r101;
        this.f392504c = r102;
    }

    public static d a(d r100, List r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        String r104 = r100.f392502a;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = r100.f392503b;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = r100.f392504c;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "pageName");
        Intrinsics.checkNotNullParameter(r101, "rows");
        return new d(r104, r101, r102);
    L5:
        r104 = null;
        goto L7
    }
}

package com.larus.kmp.voice_setting.voice.base.api;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<i>> f351773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceTabSource f351774b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f351773a, r101.f351773a) == true) goto L12;
        return false;
    L12:
        if (this.f351774b == r101.f351774b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Map<String, List<i>> r100 = this.f351773a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f351774b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResolvedVoiceTabPayload(tabMap=" + this.f351773a + ", source=" + this.f351774b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Map<String, ? extends List<i>> r100, VoiceTabSource r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f351773a = r100;
        this.f351774b = r101;
    }
}

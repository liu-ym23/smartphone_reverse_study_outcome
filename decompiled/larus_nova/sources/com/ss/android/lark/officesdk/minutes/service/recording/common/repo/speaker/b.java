package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, c> f435067a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f435067a, ((b) r100).f435067a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f435067a.hashCode();
    }

    public final String toString() {
        return "MmEndWindowSpeakerSnapshot(markedSpeakerMap=" + this.f435067a + ')';
    }

    public b(LinkedHashMap<String, c> r100) {
        Intrinsics.checkNotNullParameter(r100, "markedSpeakerMap");
        this.f435067a = r100;
    }

    public /* synthetic */ b(int r100) {
        this(new LinkedHashMap());
    }
}

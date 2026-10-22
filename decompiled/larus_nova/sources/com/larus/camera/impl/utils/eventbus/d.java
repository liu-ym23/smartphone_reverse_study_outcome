package com.larus.camera.impl.utils.eventbus;

import com.larus.camera.impl.ui.component.result.general.e2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e2 f322752a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f322752a, ((d) r100).f322752a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f322752a.hashCode();
    }

    public final String toString() {
        return "ChangeSuggestedActionPosition(position=" + this.f322752a + ')';
    }

    public d(e2 r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f322752a = r100;
    }
}

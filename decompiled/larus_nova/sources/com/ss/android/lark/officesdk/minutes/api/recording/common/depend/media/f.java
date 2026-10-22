package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class f {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        ((f) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "MmPickedMedia(id=0, path=null, mimeType=null, duration=0, width=0, height=0, size=0, isVideo=false)";
    }
}

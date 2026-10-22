package com.larus.bmhome.music.save_video;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f313151a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f313151a, ((t) r100).f313151a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f313151a.hashCode();
    }

    public final String toString() {
        return "MuxingSuccess(file=" + this.f313151a + ')';
    }

    public t(File r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        this.f313151a = r100;
    }
}

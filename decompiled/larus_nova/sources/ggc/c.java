package ggc;

import com.ss.android.ttapkdiffpatch.applier.ApplyPatchFailException;
import jgc.f;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static igc.a f481229a;

    public static void a(String r100, String r101) throws ApplyPatchFailException {
        if (f.a(r100) == true) goto L6;
        return;
    L6:
        throw new ApplyPatchFailException(2009, "require not empty: ".concat(r101));
    }
}

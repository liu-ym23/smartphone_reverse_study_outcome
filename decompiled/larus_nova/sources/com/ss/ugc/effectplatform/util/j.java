package com.ss.ugc.effectplatform.util;

import java.io.File;
import java.io.FilenameFilter;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class j implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f458039a = null;

    static {
        f458039a = new j();
    }

    public j() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (r100.isDirectory() == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r101, "kgsl", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }
}

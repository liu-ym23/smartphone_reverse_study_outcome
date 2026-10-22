package com.bytedance.reparo.core;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f267356a;

    public d(ArrayList r100) {
        this.f267356a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (r101.startsWith("patch") == true) goto L5;
        return false;
    L5:
        if (r101.endsWith(".zip") == false) goto L10;
        this.f267356a.add(new PolarisFileWrapper(r100, r101));
        return true;
    L10:
        return false;
    }
}

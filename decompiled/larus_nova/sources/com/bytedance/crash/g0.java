package com.bytedance.crash;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class g0 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f203199a;

    public g0(long r100) {
        this.f203199a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        String[] r102 = r101.split("_");     // Catch: Throwable -> L10
        if (r102.length != 2) goto L9;
        String r103 = r102[1];     // Catch: Throwable -> L10
        if (Math.abs(CastLongProtector.parseLong(r103.substring(0, r103.length())) - this.f203199a) >= 1000) goto L9;
        return true;
    L9:
        return false;
    }
}

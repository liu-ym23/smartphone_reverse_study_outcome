package com.bytedance.crash;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class k0 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f203235a;

    public k0(long r100) {
        this.f203235a = r100;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        String r102 = r101.split("_")[2];     // Catch: Throwable -> L8
        if (Math.abs(CastLongProtector.parseLong(r102.substring(0, r102.length() - 4)) - this.f203235a) >= 1000) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }
}

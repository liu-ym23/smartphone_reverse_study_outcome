package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes24.dex */
public final class k implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f286038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f286039b;

    public k(String r100, String r101) {
        this.f286038a = r100;
        this.f286039b = r101;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (new PolarisFileWrapper(r101).isDirectory() == false) goto L8;
        return false;
    L8:
        String r102 = this.f286038a;
        String r103 = this.f286039b;
        String r104 = FileUtils.m(r101);
        String r105 = FileUtils.n(r101);
        if (TextUtils.equals(r104, r103) == true) goto L12;
        return false;
    L12:
        if (r105.startsWith(r102) == false) goto L21;
        String r106 = r105.substring(r102.length());
        if (TextUtils.isEmpty(r106) == false) goto L19;
        return true;
    L19:
        return PatternProtector.compile("^_\\d+?$").matcher(r106).find();
    L21:
        return false;
    }
}

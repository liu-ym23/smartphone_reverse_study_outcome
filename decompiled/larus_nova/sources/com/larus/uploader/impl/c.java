package com.larus.uploader.impl;

import com.ss.bduploader.BDImageXUploader;
import kotlin.jvm.internal.Intrinsics;
import mr9.m;

/* JADX INFO: loaded from: classes31.dex */
public final class c {
    public static final void a(BDImageXUploader r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L17;
        r100.setFilePrefix(r101.d());
        r100.setUploadDomain(r101.c());
        mr9.b r102 = r101.a();
        String r103 = null;
        if (r102 == null) goto L7;
        String r104 = r102.a();
    L8:
        r100.setTopAccessKey(r104);
        mr9.b r105 = r101.a();
        if (r105 == null) goto L11;
        String r106 = r105.c();
    L12:
        r100.setTopSecretKey(r106);
        mr9.b r107 = r101.a();
        if (r107 == null) goto L15;
        r103 = r107.d();
    L15:
        r100.setTopSessionToken(r103);
        r100.setServiceID(r101.b());
        return;
    L11:
        r106 = null;
        goto L12
    L7:
        r104 = null;
        goto L8
    }
}

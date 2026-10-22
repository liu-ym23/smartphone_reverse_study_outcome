package com.bytedance.tools.kcp.modelx.runtime.protobuf;

import com.bytedance.mira.oat.ShareElfFile;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static final int a(int r100) {
        if ((r100 & com.alipay.sdk.m.n.a.f25611g) != 0) goto L6;
        return 1;
    L6:
        if ((r100 & (-16384)) != 0) goto L9;
        return 2;
    L9:
        if (((-2097152) & r100) != 0) goto L12;
        return 3;
    L12:
        if ((r100 & ShareElfFile.SectionHeader.SHF_MASKPROC) != 0) goto L14;
        return 4;
    L14:
        return 5;
    }
}

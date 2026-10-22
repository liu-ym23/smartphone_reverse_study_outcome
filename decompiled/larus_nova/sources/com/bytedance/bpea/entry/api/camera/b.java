package com.bytedance.bpea.entry.api.camera;

import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.cert.token.TokenCert;
import qc4.c;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static final c a(TokenCert r100, String r101, int r102) {
        return new c(r100, r101, r102, new String[]{"video"}, Integer.valueOf(EntryCategory.BPEA_ENTRY.getType()));
    }
}

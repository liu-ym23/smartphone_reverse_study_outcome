package com.bytedance.bpea.basics;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¨\u0006\u0005"}, d2 = {"findCert", "Lcom/bytedance/bpea/basics/Cert;", "token", "", "auth", "basics_release"}, k = 2, mv = {1, 1, 16})
public final class CertProviderManagerKt {
    public static final Cert findCert(String r100) {
        Cert r101 = CertProviderManager.INSTANCE.findCert(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new DefaultCert(r100, null, 2, null);
    }

    public static final Cert findCert(String r100, String r101) {
        Cert r102 = CertProviderManager.INSTANCE.findCert(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return new DefaultCert(r100, r101);
    }
}

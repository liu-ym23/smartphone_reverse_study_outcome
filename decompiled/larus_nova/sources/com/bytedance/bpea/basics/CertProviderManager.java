package com.bytedance.bpea.basics;

import kotlin.Metadata;
import qc4.e;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/bpea/basics/CertProviderManager;", "Lqc4/e;", "", "token", "Lcom/bytedance/bpea/basics/Cert;", "findCert", "auth", "certProvider", "", "setCertProvider", "Lqc4/e;", "<init>", "()V", "basics_release"}, k = 1, mv = {1, 4, 0})
public final class CertProviderManager implements e {
    public static final CertProviderManager INSTANCE = null;
    private static e certProvider;

    private CertProviderManager() {
    }

    static {
        INSTANCE = new CertProviderManager();
    }

    @Override // qc4.e
    public Cert findCert(String r100) {
        e r101 = certProvider;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findCert(r100);
    }

    public final void setCertProvider(e r100) {
        if (certProvider != null) goto L7;
        certProvider = r100;
        return;
    L7:
        throw new BPEAException(-1, "certProvider is already exist");
    }

    @Override // qc4.e
    public Cert findCert(String r100, String r101) {
        e r102 = certProvider;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.findCert(r100, r101);
    }
}

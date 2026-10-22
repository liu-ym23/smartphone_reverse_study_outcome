package com.bytedance.assem.arch.reused;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/reused/ProxyStage;", "", "Silent", "Active", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum ProxyStage extends Enum<ProxyStage> {
    public static final ProxyStage Active = null;
    public static final ProxyStage Silent = null;
    public static final /* synthetic */ ProxyStage[] a = null;

    static {
        ProxyStage r1 = new ProxyStage("Silent", 0);
        Silent = r1;
        ProxyStage r2 = new ProxyStage("Active", 1);
        Active = r2;
        a = new ProxyStage[]{r1, r2};
    }

    public static ProxyStage valueOf(String r1) {
        return (ProxyStage) r27.a.a(ProxyStage.class, r1);
    }

    public static ProxyStage[] values() {
        return (ProxyStage[]) a.clone();
    }

    public ProxyStage(String r1, int r2) {
        super(r1, r2);
    }
}

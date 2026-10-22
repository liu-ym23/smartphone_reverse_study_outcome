package com.bytedance.assem.arch.reused;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/assem/arch/reused/ProxyStage;", "", "Silent", "Active", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum ProxyStage extends Enum<ProxyStage> {
    public static final ProxyStage Active = null;
    public static final ProxyStage Silent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProxyStage[] f192946a = null;

    static {
        ProxyStage r100 = new ProxyStage("Silent", 0);
        Silent = r100;
        ProxyStage r101 = new ProxyStage("Active", 1);
        Active = r101;
        f192946a = new ProxyStage[]{r100, r101};
    }

    public static ProxyStage valueOf(String r100) {
        return (ProxyStage) r27.a.a(ProxyStage.class, r100);
    }

    public static ProxyStage[] values() {
        return (ProxyStage[]) f192946a.clone();
    }

    public ProxyStage(String r100, int r101) {
        super(r100, r101);
    }
}

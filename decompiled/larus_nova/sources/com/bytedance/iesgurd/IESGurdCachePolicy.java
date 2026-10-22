package com.bytedance.iesgurd;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdCachePolicy;", "", "FIFO", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum IESGurdCachePolicy extends Enum<IESGurdCachePolicy> {
    public static final IESGurdCachePolicy FIFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IESGurdCachePolicy[] f250622a = null;

    static {
        IESGurdCachePolicy r100 = new IESGurdCachePolicy();
        FIFO = r100;
        f250622a = new IESGurdCachePolicy[]{r100};
    }

    public static IESGurdCachePolicy valueOf(String r100) {
        return (IESGurdCachePolicy) r27.a.a(IESGurdCachePolicy.class, r100);
    }

    public static IESGurdCachePolicy[] values() {
        return (IESGurdCachePolicy[]) f250622a.clone();
    }

    public IESGurdCachePolicy() {
        super("FIFO", 0);
    }
}

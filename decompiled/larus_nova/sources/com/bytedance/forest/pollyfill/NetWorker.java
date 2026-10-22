package com.bytedance.forest.pollyfill;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/forest/pollyfill/NetWorker;", "", "TTNet", "Downloader", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum NetWorker extends Enum<NetWorker> {
    public static final NetWorker Downloader = null;
    public static final NetWorker TTNet = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NetWorker[] f244394a = null;

    static {
        NetWorker r100 = new NetWorker("TTNet", 0);
        TTNet = r100;
        NetWorker r101 = new NetWorker("Downloader", 1);
        Downloader = r101;
        f244394a = new NetWorker[]{r100, r101};
    }

    public static NetWorker valueOf(String r100) {
        return (NetWorker) r27.a.a(NetWorker.class, r100);
    }

    public static NetWorker[] values() {
        return (NetWorker[]) f244394a.clone();
    }

    public NetWorker(String r100, int r101) {
        super(r100, r101);
    }
}

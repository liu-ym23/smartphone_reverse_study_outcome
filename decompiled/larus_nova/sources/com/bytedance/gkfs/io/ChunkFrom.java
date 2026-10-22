package com.bytedance.gkfs.io;

import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/gkfs/io/ChunkFrom;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Parallel", "Disk", "Global", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final enum ChunkFrom extends Enum<ChunkFrom> {
    public static final ChunkFrom Disk = null;
    public static final ChunkFrom Global = null;
    public static final ChunkFrom Parallel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChunkFrom[] f245159a = null;
    private final String value;

    static {
        ChunkFrom r100 = new ChunkFrom("Parallel", 0, "parallel_cache");
        Parallel = r100;
        ChunkFrom r101 = new ChunkFrom("Disk", 1, UploadTypeInf.DISK);
        Disk = r101;
        ChunkFrom r102 = new ChunkFrom("Global", 2, "global_cache");
        Global = r102;
        f245159a = new ChunkFrom[]{r100, r101, r102};
    }

    public static ChunkFrom valueOf(String r100) {
        return (ChunkFrom) r27.a.a(ChunkFrom.class, r100);
    }

    public static ChunkFrom[] values() {
        return (ChunkFrom[]) f245159a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ChunkFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.larus.im.internal.network.chunk.handler.config;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/network/chunk/handler/config/ChunkPosition;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "MIDDLE", "ENDED", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChunkPosition extends Enum<ChunkPosition> {
    public static final ChunkPosition ENDED = null;
    public static final ChunkPosition FIRST = null;
    public static final ChunkPosition MIDDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChunkPosition[] f349142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f349143b = null;

    public static EnumEntries<ChunkPosition> getEntries() {
        return f349143b;
    }

    static {
        ChunkPosition r100 = new ChunkPosition("FIRST", 0);
        FIRST = r100;
        ChunkPosition r101 = new ChunkPosition("MIDDLE", 1);
        MIDDLE = r101;
        ChunkPosition r102 = new ChunkPosition("ENDED", 2);
        ENDED = r102;
        ChunkPosition[] r103 = {r100, r101, r102};
        f349142a = r103;
        f349143b = EnumEntriesKt.enumEntries(r103);
    }

    public static ChunkPosition[] values() {
        return (ChunkPosition[]) f349142a.clone();
    }

    public static ChunkPosition valueOf(String r100) {
        return (ChunkPosition) a.a(ChunkPosition.class, r100);
    }

    public ChunkPosition(String r100, int r101) {
        super(r100, r101);
    }
}

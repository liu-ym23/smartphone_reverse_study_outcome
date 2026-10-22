package com.larus.platform.model.album;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/album/AlbumSelectionMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AlbumSelectionMediaType extends Enum<AlbumSelectionMediaType> {
    public static final AlbumSelectionMediaType IMAGE = null;
    public static final AlbumSelectionMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumSelectionMediaType[] f365513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365514b = null;

    public static EnumEntries<AlbumSelectionMediaType> getEntries() {
        return f365514b;
    }

    static {
        AlbumSelectionMediaType r100 = new AlbumSelectionMediaType("IMAGE", 0);
        IMAGE = r100;
        AlbumSelectionMediaType r101 = new AlbumSelectionMediaType("VIDEO", 1);
        VIDEO = r101;
        AlbumSelectionMediaType[] r102 = {r100, r101};
        f365513a = r102;
        f365514b = EnumEntriesKt.enumEntries(r102);
    }

    public static AlbumSelectionMediaType[] values() {
        return (AlbumSelectionMediaType[]) f365513a.clone();
    }

    public static AlbumSelectionMediaType valueOf(String r100) {
        return (AlbumSelectionMediaType) a.a(AlbumSelectionMediaType.class, r100);
    }

    public AlbumSelectionMediaType(String r100, int r101) {
        super(r100, r101);
    }
}

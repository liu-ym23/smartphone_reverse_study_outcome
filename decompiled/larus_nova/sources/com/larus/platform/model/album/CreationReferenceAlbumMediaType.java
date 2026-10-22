package com.larus.platform.model.album;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAlbumMediaType extends Enum<CreationReferenceAlbumMediaType> implements Serializable {
    public static final CreationReferenceAlbumMediaType AUDIO = null;
    public static final CreationReferenceAlbumMediaType IMAGE = null;
    public static final CreationReferenceAlbumMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAlbumMediaType[] f365541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365542b = null;

    public static EnumEntries<CreationReferenceAlbumMediaType> getEntries() {
        return f365542b;
    }

    static {
        CreationReferenceAlbumMediaType r100 = new CreationReferenceAlbumMediaType("IMAGE", 0);
        IMAGE = r100;
        CreationReferenceAlbumMediaType r101 = new CreationReferenceAlbumMediaType("VIDEO", 1);
        VIDEO = r101;
        CreationReferenceAlbumMediaType r102 = new CreationReferenceAlbumMediaType("AUDIO", 2);
        AUDIO = r102;
        CreationReferenceAlbumMediaType[] r103 = {r100, r101, r102};
        f365541a = r103;
        f365542b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreationReferenceAlbumMediaType[] values() {
        return (CreationReferenceAlbumMediaType[]) f365541a.clone();
    }

    public static CreationReferenceAlbumMediaType valueOf(String r100) {
        return (CreationReferenceAlbumMediaType) a.a(CreationReferenceAlbumMediaType.class, r100);
    }

    public CreationReferenceAlbumMediaType(String r100, int r101) {
        super(r100, r101);
    }
}

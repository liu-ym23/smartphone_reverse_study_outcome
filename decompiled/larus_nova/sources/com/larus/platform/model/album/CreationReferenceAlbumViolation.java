package com.larus.platform.model.album;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumViolation;", "", "<init>", "(Ljava/lang/String;I)V", "UNSUPPORTED_TYPE", "METADATA_UNAVAILABLE", "TYPE_COUNT", "MIXED_COUNT", "SINGLE_DURATION", "TOTAL_DURATION", "MIXED_TOTAL_DURATION", "FILE_SIZE", "RESOLUTION", "RATIO", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationReferenceAlbumViolation extends Enum<CreationReferenceAlbumViolation> {
    public static final CreationReferenceAlbumViolation FILE_SIZE = null;
    public static final CreationReferenceAlbumViolation METADATA_UNAVAILABLE = null;
    public static final CreationReferenceAlbumViolation MIXED_COUNT = null;
    public static final CreationReferenceAlbumViolation MIXED_TOTAL_DURATION = null;
    public static final CreationReferenceAlbumViolation RATIO = null;
    public static final CreationReferenceAlbumViolation RESOLUTION = null;
    public static final CreationReferenceAlbumViolation SINGLE_DURATION = null;
    public static final CreationReferenceAlbumViolation TOTAL_DURATION = null;
    public static final CreationReferenceAlbumViolation TYPE_COUNT = null;
    public static final CreationReferenceAlbumViolation UNSUPPORTED_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationReferenceAlbumViolation[] f365543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365544b = null;

    public static EnumEntries<CreationReferenceAlbumViolation> getEntries() {
        return f365544b;
    }

    static {
        CreationReferenceAlbumViolation r100 = new CreationReferenceAlbumViolation("UNSUPPORTED_TYPE", 0);
        UNSUPPORTED_TYPE = r100;
        CreationReferenceAlbumViolation r101 = new CreationReferenceAlbumViolation("METADATA_UNAVAILABLE", 1);
        METADATA_UNAVAILABLE = r101;
        CreationReferenceAlbumViolation r102 = new CreationReferenceAlbumViolation("TYPE_COUNT", 2);
        TYPE_COUNT = r102;
        CreationReferenceAlbumViolation r103 = new CreationReferenceAlbumViolation("MIXED_COUNT", 3);
        MIXED_COUNT = r103;
        CreationReferenceAlbumViolation r104 = new CreationReferenceAlbumViolation("SINGLE_DURATION", 4);
        SINGLE_DURATION = r104;
        CreationReferenceAlbumViolation r105 = new CreationReferenceAlbumViolation("TOTAL_DURATION", 5);
        TOTAL_DURATION = r105;
        CreationReferenceAlbumViolation r110 = new CreationReferenceAlbumViolation("MIXED_TOTAL_DURATION", 6);
        MIXED_TOTAL_DURATION = r110;
        CreationReferenceAlbumViolation r111 = new CreationReferenceAlbumViolation("FILE_SIZE", 7);
        FILE_SIZE = r111;
        CreationReferenceAlbumViolation r112 = new CreationReferenceAlbumViolation("RESOLUTION", 8);
        RESOLUTION = r112;
        CreationReferenceAlbumViolation r113 = new CreationReferenceAlbumViolation("RATIO", 9);
        RATIO = r113;
        CreationReferenceAlbumViolation[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f365543a = r114;
        f365544b = EnumEntriesKt.enumEntries(r114);
    }

    public static CreationReferenceAlbumViolation[] values() {
        return (CreationReferenceAlbumViolation[]) f365543a.clone();
    }

    public static CreationReferenceAlbumViolation valueOf(String r100) {
        return (CreationReferenceAlbumViolation) a.a(CreationReferenceAlbumViolation.class, r100);
    }

    public CreationReferenceAlbumViolation(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.avlink.gallery.power.policy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/avlink/gallery/power/policy/AlbumPowerLevel;", "", "<init>", "(Ljava/lang/String;I)V", "CRITICAL", "HIGH", "MEDIUM", "LOW", "UNKNOWN", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AlbumPowerLevel extends Enum<AlbumPowerLevel> {
    public static final AlbumPowerLevel CRITICAL = null;
    public static final AlbumPowerLevel HIGH = null;
    public static final AlbumPowerLevel LOW = null;
    public static final AlbumPowerLevel MEDIUM = null;
    public static final AlbumPowerLevel UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumPowerLevel[] f292661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f292662b = null;

    public static EnumEntries<AlbumPowerLevel> getEntries() {
        return f292662b;
    }

    static {
        AlbumPowerLevel r100 = new AlbumPowerLevel("CRITICAL", 0);
        CRITICAL = r100;
        AlbumPowerLevel r101 = new AlbumPowerLevel("HIGH", 1);
        HIGH = r101;
        AlbumPowerLevel r102 = new AlbumPowerLevel("MEDIUM", 2);
        MEDIUM = r102;
        AlbumPowerLevel r103 = new AlbumPowerLevel("LOW", 3);
        LOW = r103;
        AlbumPowerLevel r104 = new AlbumPowerLevel("UNKNOWN", 4);
        UNKNOWN = r104;
        AlbumPowerLevel[] r105 = {r100, r101, r102, r103, r104};
        f292661a = r105;
        f292662b = EnumEntriesKt.enumEntries(r105);
    }

    public static AlbumPowerLevel[] values() {
        return (AlbumPowerLevel[]) f292661a.clone();
    }

    public static AlbumPowerLevel valueOf(String r100) {
        return (AlbumPowerLevel) a.a(AlbumPowerLevel.class, r100);
    }

    public AlbumPowerLevel(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.disk.impl;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/disk/impl/DiskFileType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "AUDIO", "DOCUMENT", "ARCHIVE", "DATABASE", "KV", "LOG", "OFFLINE_RESOURCE", FlowDoraWifiScene.OTHER, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiskFileType extends Enum<DiskFileType> {
    public static final DiskFileType ARCHIVE = null;
    public static final DiskFileType AUDIO = null;
    public static final DiskFileType DATABASE = null;
    public static final DiskFileType DOCUMENT = null;
    public static final DiskFileType IMAGE = null;
    public static final DiskFileType KV = null;
    public static final DiskFileType LOG = null;
    public static final DiskFileType OFFLINE_RESOURCE = null;
    public static final DiskFileType OTHER = null;
    public static final DiskFileType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiskFileType[] f330595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f330596b = null;

    public static EnumEntries<DiskFileType> getEntries() {
        return f330596b;
    }

    static {
        DiskFileType r100 = new DiskFileType("IMAGE", 0);
        IMAGE = r100;
        DiskFileType r101 = new DiskFileType("VIDEO", 1);
        VIDEO = r101;
        DiskFileType r102 = new DiskFileType("AUDIO", 2);
        AUDIO = r102;
        DiskFileType r103 = new DiskFileType("DOCUMENT", 3);
        DOCUMENT = r103;
        DiskFileType r104 = new DiskFileType("ARCHIVE", 4);
        ARCHIVE = r104;
        DiskFileType r105 = new DiskFileType("DATABASE", 5);
        DATABASE = r105;
        DiskFileType r110 = new DiskFileType("KV", 6);
        KV = r110;
        DiskFileType r111 = new DiskFileType("LOG", 7);
        LOG = r111;
        DiskFileType r112 = new DiskFileType("OFFLINE_RESOURCE", 8);
        OFFLINE_RESOURCE = r112;
        DiskFileType r113 = new DiskFileType(FlowDoraWifiScene.OTHER, 9);
        OTHER = r113;
        DiskFileType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f330595a = r114;
        f330596b = EnumEntriesKt.enumEntries(r114);
    }

    public static DiskFileType[] values() {
        return (DiskFileType[]) f330595a.clone();
    }

    public static DiskFileType valueOf(String r100) {
        return (DiskFileType) r27.a.a(DiskFileType.class, r100);
    }

    public DiskFileType(String r100, int r101) {
        super(r100, r101);
    }
}

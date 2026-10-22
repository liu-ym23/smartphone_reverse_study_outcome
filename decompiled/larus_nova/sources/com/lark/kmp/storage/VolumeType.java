package com.lark.kmp.storage;

import com.bytedance.keva.KevaImpl;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/lark/kmp/storage/VolumeType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FILES", "CACHE", "PREFERENCE", "EXTERNAL_FILES", "EXTERNAL_CACHE", "lark-storage-kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VolumeType extends Enum<VolumeType> {
    public static final VolumeType CACHE = null;
    public static final VolumeType EXTERNAL_CACHE = null;
    public static final VolumeType EXTERNAL_FILES = null;
    public static final VolumeType FILES = null;
    public static final VolumeType PREFERENCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VolumeType[] f282693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282694b = null;
    private final String value;

    public static EnumEntries<VolumeType> getEntries() {
        return f282694b;
    }

    static {
        VolumeType r100 = new VolumeType("FILES", 0, KevaImpl.PrivateConstants.FILES_DIR_NAME);
        FILES = r100;
        VolumeType r101 = new VolumeType("CACHE", 1, "cache");
        CACHE = r101;
        VolumeType r102 = new VolumeType("PREFERENCE", 2, "preference");
        PREFERENCE = r102;
        VolumeType r103 = new VolumeType("EXTERNAL_FILES", 3, "external_files");
        EXTERNAL_FILES = r103;
        VolumeType r104 = new VolumeType("EXTERNAL_CACHE", 4, "external_cache");
        EXTERNAL_CACHE = r104;
        VolumeType[] r105 = {r100, r101, r102, r103, r104};
        f282693a = r105;
        f282694b = EnumEntriesKt.enumEntries(r105);
    }

    public static VolumeType[] values() {
        return (VolumeType[]) f282693a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static VolumeType valueOf(String r100) {
        return (VolumeType) r27.a.a(VolumeType.class, r100);
    }

    public VolumeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

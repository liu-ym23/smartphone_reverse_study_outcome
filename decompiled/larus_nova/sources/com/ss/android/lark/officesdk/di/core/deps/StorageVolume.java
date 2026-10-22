package com.ss.android.lark.officesdk.di.core.deps;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/StorageVolume;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL_FILES", "INTERNAL_CACHE", "INTERNAL_ROOT", "EXTERNAL_FILES", "EXTERNAL_CACHE", "PUBLIC_ROOT", "PUBLIC_PICTURES", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum StorageVolume extends Enum<StorageVolume> {
    public static final StorageVolume EXTERNAL_CACHE = null;
    public static final StorageVolume EXTERNAL_FILES = null;
    public static final StorageVolume INTERNAL_CACHE = null;
    public static final StorageVolume INTERNAL_FILES = null;
    public static final StorageVolume INTERNAL_ROOT = null;
    public static final StorageVolume PUBLIC_PICTURES = null;
    public static final StorageVolume PUBLIC_ROOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StorageVolume[] f433187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433188b = null;

    public static EnumEntries<StorageVolume> getEntries() {
        return f433188b;
    }

    static {
        StorageVolume r100 = new StorageVolume("INTERNAL_FILES", 0);
        INTERNAL_FILES = r100;
        StorageVolume r101 = new StorageVolume("INTERNAL_CACHE", 1);
        INTERNAL_CACHE = r101;
        StorageVolume r102 = new StorageVolume("INTERNAL_ROOT", 2);
        INTERNAL_ROOT = r102;
        StorageVolume r103 = new StorageVolume("EXTERNAL_FILES", 3);
        EXTERNAL_FILES = r103;
        StorageVolume r104 = new StorageVolume("EXTERNAL_CACHE", 4);
        EXTERNAL_CACHE = r104;
        StorageVolume r105 = new StorageVolume("PUBLIC_ROOT", 5);
        PUBLIC_ROOT = r105;
        StorageVolume r110 = new StorageVolume("PUBLIC_PICTURES", 6);
        PUBLIC_PICTURES = r110;
        StorageVolume[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f433187a = r111;
        f433188b = EnumEntriesKt.enumEntries(r111);
    }

    public static StorageVolume[] values() {
        return (StorageVolume[]) f433187a.clone();
    }

    public static StorageVolume valueOf(String r100) {
        return (StorageVolume) a.a(StorageVolume.class, r100);
    }

    public StorageVolume(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.kmp.voice_setting.voice.feature;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/feature/CacheStatus;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "LOADING", "CACHED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus CACHED = null;
    public static final CacheStatus EMPTY = null;
    public static final CacheStatus LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStatus[] f353277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353278b = null;

    public static EnumEntries<CacheStatus> getEntries() {
        return f353278b;
    }

    static {
        CacheStatus r100 = new CacheStatus("EMPTY", 0);
        EMPTY = r100;
        CacheStatus r101 = new CacheStatus("LOADING", 1);
        LOADING = r101;
        CacheStatus r102 = new CacheStatus("CACHED", 2);
        CACHED = r102;
        CacheStatus[] r103 = {r100, r101, r102};
        f353277a = r103;
        f353278b = EnumEntriesKt.enumEntries(r103);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) f353277a.clone();
    }

    public static CacheStatus valueOf(String r100) {
        return (CacheStatus) r27.a.a(CacheStatus.class, r100);
    }

    public CacheStatus(String r100, int r101) {
        super(r100, r101);
    }
}

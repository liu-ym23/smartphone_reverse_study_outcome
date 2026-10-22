package com.larus.kmp.voice_setting.voice.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/bean/CacheStatus;", "", "log", "", "<init>", "(Ljava/lang/String;II)V", "getLog", "()I", "EMPTY", "LOADING", "CACHED", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus CACHED = null;
    public static final CacheStatus EMPTY = null;
    public static final CacheStatus LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStatus[] f351836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351837b = null;
    private final int log;

    public static EnumEntries<CacheStatus> getEntries() {
        return f351837b;
    }

    static {
        CacheStatus r100 = new CacheStatus("EMPTY", 0, 0);
        EMPTY = r100;
        CacheStatus r101 = new CacheStatus("LOADING", 1, 1);
        LOADING = r101;
        CacheStatus r102 = new CacheStatus("CACHED", 2, 2);
        CACHED = r102;
        CacheStatus[] r103 = {r100, r101, r102};
        f351836a = r103;
        f351837b = EnumEntriesKt.enumEntries(r103);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) f351836a.clone();
    }

    public final int getLog() {
        return this.log;
    }

    public static CacheStatus valueOf(String r100) {
        return (CacheStatus) a.a(CacheStatus.class, r100);
    }

    public CacheStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.log = r102;
    }
}

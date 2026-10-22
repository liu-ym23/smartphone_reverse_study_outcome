package com.larus.voice_setting.voice.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/voice_setting/voice/bean/CacheStatus;", "", "log", "", "<init>", "(Ljava/lang/String;II)V", "getLog", "()I", "setLog", "(I)V", "EMPTY", "LOADING", "CACHED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CacheStatus extends Enum<CacheStatus> {
    public static final CacheStatus CACHED = null;
    public static final CacheStatus EMPTY = null;
    public static final CacheStatus LOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheStatus[] f376491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f376492b = null;
    private int log;

    public static EnumEntries<CacheStatus> getEntries() {
        return f376492b;
    }

    static {
        CacheStatus r100 = new CacheStatus("EMPTY", 0, 0);
        EMPTY = r100;
        CacheStatus r101 = new CacheStatus("LOADING", 1, 1);
        LOADING = r101;
        CacheStatus r102 = new CacheStatus("CACHED", 2, 2);
        CACHED = r102;
        CacheStatus[] r103 = {r100, r101, r102};
        f376491a = r103;
        f376492b = EnumEntriesKt.enumEntries(r103);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) f376491a.clone();
    }

    public final int getLog() {
        return this.log;
    }

    public static CacheStatus valueOf(String r100) {
        return (CacheStatus) a.a(CacheStatus.class, r100);
    }

    public final void setLog(int r100) {
        this.log = r100;
    }

    public CacheStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.log = r102;
    }
}

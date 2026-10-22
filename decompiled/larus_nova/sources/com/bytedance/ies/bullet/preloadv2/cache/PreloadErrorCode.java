package com.bytedance.ies.bullet.preloadv2.cache;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadErrorCode;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "UriInvalid", "RLFail", "MemFail", "LockFail", "CacheFull", "CacheDuplicate", "Crash", "None", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PreloadErrorCode extends Enum<PreloadErrorCode> {
    public static final PreloadErrorCode CacheDuplicate = null;
    public static final PreloadErrorCode CacheFull = null;
    public static final PreloadErrorCode Crash = null;
    public static final PreloadErrorCode LockFail = null;
    public static final PreloadErrorCode MemFail = null;
    public static final PreloadErrorCode None = null;
    public static final PreloadErrorCode RLFail = null;
    public static final PreloadErrorCode UriInvalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadErrorCode[] f247674a = null;
    private final String tag;

    public static PreloadErrorCode valueOf(String r100) {
        return (PreloadErrorCode) r27.a.a(PreloadErrorCode.class, r100);
    }

    public static PreloadErrorCode[] values() {
        return (PreloadErrorCode[]) f247674a.clone();
    }

    static {
        PreloadErrorCode r100 = new PreloadErrorCode("UriInvalid", 0, "uri invalid");
        UriInvalid = r100;
        PreloadErrorCode r101 = new PreloadErrorCode("RLFail", 1, "resource loader load fail");
        RLFail = r101;
        PreloadErrorCode r102 = new PreloadErrorCode("MemFail", 2, "memory cache put fail");
        MemFail = r102;
        PreloadErrorCode r103 = new PreloadErrorCode("LockFail", 3, "lock fail");
        LockFail = r103;
        PreloadErrorCode r104 = new PreloadErrorCode("CacheFull", 4, "cache is full");
        CacheFull = r104;
        PreloadErrorCode r105 = new PreloadErrorCode("CacheDuplicate", 5, "cache item duplicate");
        CacheDuplicate = r105;
        PreloadErrorCode r110 = new PreloadErrorCode("Crash", 6, "crash");
        Crash = r110;
        PreloadErrorCode r111 = new PreloadErrorCode("None", 7, "none");
        None = r111;
        f247674a = new PreloadErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final String getTag() {
        return this.tag;
    }

    public PreloadErrorCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}

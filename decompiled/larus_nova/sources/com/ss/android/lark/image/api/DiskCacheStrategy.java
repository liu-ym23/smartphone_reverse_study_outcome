package com.ss.android.lark.image.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum DiskCacheStrategy extends Enum<DiskCacheStrategy> {
    public static final DiskCacheStrategy ALL = null;
    public static final DiskCacheStrategy NONE = null;
    public static final DiskCacheStrategy RESULT = null;
    public static final DiskCacheStrategy SOURCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiskCacheStrategy[] f426216a = null;
    private final boolean cacheResult;
    private final boolean cacheSource;

    static {
        DiskCacheStrategy r100 = new DiskCacheStrategy(AccountType.ALL, 0, true, true);
        ALL = r100;
        DiskCacheStrategy r101 = new DiskCacheStrategy(UserProfileEvent.POSITION_NONE, 1, false, false);
        NONE = r101;
        DiskCacheStrategy r102 = new DiskCacheStrategy("SOURCE", 2, true, false);
        SOURCE = r102;
        DiskCacheStrategy r103 = new DiskCacheStrategy("RESULT", 3, false, true);
        RESULT = r103;
        f426216a = new DiskCacheStrategy[]{r100, r101, r102, r103};
    }

    public static DiskCacheStrategy[] values() {
        return (DiskCacheStrategy[]) f426216a.clone();
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }

    public static DiskCacheStrategy valueOf(String r100) {
        return (DiskCacheStrategy) a.a(DiskCacheStrategy.class, r100);
    }

    public DiskCacheStrategy(String r100, int r101, boolean r102, boolean r103) {
        super(r100, r101);
        this.cacheSource = r102;
        this.cacheResult = r103;
    }
}

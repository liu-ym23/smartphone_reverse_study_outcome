package com.bytedance.dux.utils;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/dux/utils/ReplaceStrategy;", "", "", "replaceSystemEmoji", "replaceDouyinEmoji", "", "value", "I", "getValue", "()I", "SYSTEM_EMOJI", "DOUYIN_EMOJI", AccountType.ALL, "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum ReplaceStrategy extends Enum<ReplaceStrategy> {
    public static final ReplaceStrategy ALL = null;
    public static final ReplaceStrategy DOUYIN_EMOJI = null;
    public static final ReplaceStrategy SYSTEM_EMOJI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplaceStrategy[] f205856a = null;
    private final int value;

    public static ReplaceStrategy valueOf(String r100) {
        return (ReplaceStrategy) r27.a.a(ReplaceStrategy.class, r100);
    }

    public static ReplaceStrategy[] values() {
        return (ReplaceStrategy[]) f205856a.clone();
    }

    static {
        ReplaceStrategy r100 = new ReplaceStrategy("SYSTEM_EMOJI", 0, 0);
        SYSTEM_EMOJI = r100;
        ReplaceStrategy r101 = new ReplaceStrategy("DOUYIN_EMOJI", 1, 1);
        DOUYIN_EMOJI = r101;
        ReplaceStrategy r102 = new ReplaceStrategy(AccountType.ALL, 2, 2);
        ALL = r102;
        f205856a = new ReplaceStrategy[]{r100, r101, r102};
    }

    public final boolean replaceDouyinEmoji() {
        if (this != DOUYIN_EMOJI) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public final boolean replaceSystemEmoji() {
        if (this != SYSTEM_EMOJI) goto L5;
    L8:
        return true;
    L5:
        if (this == ALL) goto L8;
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public ReplaceStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.component.lyric_v2.util;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/component/lyric_v2/util/LyricType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "LRC", "KRC", "lib-lyric_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LyricType extends Enum<LyricType> {
    public static final LyricType KRC = null;
    public static final LyricType LRC = null;
    public static final LyricType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LyricType[] f203090a = null;
    private final int value;

    static {
        LyricType r100 = new LyricType("UNKNOWN", 0, 1);
        UNKNOWN = r100;
        LyricType r101 = new LyricType("LRC", 1, 2);
        LRC = r101;
        LyricType r102 = new LyricType("KRC", 2, 3);
        KRC = r102;
        f203090a = new LyricType[]{r100, r101, r102};
    }

    public static LyricType valueOf(String r100) {
        return (LyricType) a.a(LyricType.class, r100);
    }

    public static LyricType[] values() {
        return (LyricType[]) f203090a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LyricType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.component.lyric_v2.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/component/lyric_v2/model/LyricAlignType;", "", "LEFT", "CENTER", "RIGHT", "MV", "lib-lyric_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LyricAlignType extends Enum<LyricAlignType> {
    public static final LyricAlignType CENTER = null;
    public static final LyricAlignType LEFT = null;
    public static final LyricAlignType MV = null;
    public static final LyricAlignType RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LyricAlignType[] f203059a = null;

    static {
        LyricAlignType r100 = new LyricAlignType("LEFT", 0);
        LEFT = r100;
        LyricAlignType r101 = new LyricAlignType("CENTER", 1);
        CENTER = r101;
        LyricAlignType r102 = new LyricAlignType("RIGHT", 2);
        RIGHT = r102;
        LyricAlignType r103 = new LyricAlignType("MV", 3);
        MV = r103;
        f203059a = new LyricAlignType[]{r100, r101, r102, r103};
    }

    public static LyricAlignType valueOf(String r100) {
        return (LyricAlignType) a.a(LyricAlignType.class, r100);
    }

    public static LyricAlignType[] values() {
        return (LyricAlignType[]) f203059a.clone();
    }

    public LyricAlignType(String r100, int r101) {
        super(r100, r101);
    }
}

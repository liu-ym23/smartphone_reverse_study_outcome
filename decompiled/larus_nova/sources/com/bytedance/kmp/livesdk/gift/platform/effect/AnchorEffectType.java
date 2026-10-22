package com.bytedance.kmp.livesdk.gift.platform.effect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/effect/AnchorEffectType;", "", "NormalEffect", "Sticker", "EffectGame", "SkillRole", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorEffectType extends Enum<AnchorEffectType> {
    public static final AnchorEffectType EffectGame = null;
    public static final AnchorEffectType NormalEffect = null;
    public static final AnchorEffectType SkillRole = null;
    public static final AnchorEffectType Sticker = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorEffectType[] f252342a = null;

    static {
        AnchorEffectType r100 = new AnchorEffectType("NormalEffect", 0);
        NormalEffect = r100;
        AnchorEffectType r101 = new AnchorEffectType("Sticker", 1);
        Sticker = r101;
        AnchorEffectType r102 = new AnchorEffectType("EffectGame", 2);
        EffectGame = r102;
        AnchorEffectType r103 = new AnchorEffectType("SkillRole", 3);
        SkillRole = r103;
        f252342a = new AnchorEffectType[]{r100, r101, r102, r103};
    }

    public static AnchorEffectType valueOf(String r100) {
        return (AnchorEffectType) r27.a.a(AnchorEffectType.class, r100);
    }

    public static AnchorEffectType[] values() {
        return (AnchorEffectType[]) f252342a.clone();
    }

    public AnchorEffectType(String r100, int r101) {
        super(r100, r101);
    }
}

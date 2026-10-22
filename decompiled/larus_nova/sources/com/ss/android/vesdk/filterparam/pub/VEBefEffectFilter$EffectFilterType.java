package com.ss.android.vesdk.filterparam.pub;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VEBefEffectFilter$EffectFilterType extends Enum<VEBefEffectFilter$EffectFilterType> {
    public static final VEBefEffectFilter$EffectFilterType AUDIO_SPEED = null;
    public static final VEBefEffectFilter$EffectFilterType DEFAULT = null;
    public static final VEBefEffectFilter$EffectFilterType MIMO = null;
    public static final VEBefEffectFilter$EffectFilterType MUSIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VEBefEffectFilter$EffectFilterType[] f455826a = null;

    static {
        VEBefEffectFilter$EffectFilterType r100 = new VEBefEffectFilter$EffectFilterType("DEFAULT", 0);
        DEFAULT = r100;
        VEBefEffectFilter$EffectFilterType r101 = new VEBefEffectFilter$EffectFilterType("MUSIC", 1);
        MUSIC = r101;
        VEBefEffectFilter$EffectFilterType r102 = new VEBefEffectFilter$EffectFilterType("AUDIO_SPEED", 2);
        AUDIO_SPEED = r102;
        VEBefEffectFilter$EffectFilterType r103 = new VEBefEffectFilter$EffectFilterType("MIMO", 3);
        MIMO = r103;
        f455826a = new VEBefEffectFilter$EffectFilterType[]{r100, r101, r102, r103};
    }

    public static VEBefEffectFilter$EffectFilterType[] values() {
        return (VEBefEffectFilter$EffectFilterType[]) f455826a.clone();
    }

    public static VEBefEffectFilter$EffectFilterType valueOf(String r100) {
        return (VEBefEffectFilter$EffectFilterType) a.a(VEBefEffectFilter$EffectFilterType.class, r100);
    }

    public VEBefEffectFilter$EffectFilterType(String r100, int r101) {
        super(r100, r101);
    }
}

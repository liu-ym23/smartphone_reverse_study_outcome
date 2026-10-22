package com.ss.android.lark.widget.linked_emojicon.roundspan;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum extends Enum<RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum> {
    public static final RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum LARGE = null;
    public static final RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum[] f446388a = null;

    static {
        RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum r100 = new RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum r101 = new RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum("LARGE", 1);
        LARGE = r101;
        f446388a = new RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum[]{r100, r101};
    }

    public static RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum[] values() {
        return (RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum[]) f446388a.clone();
    }

    public static RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum valueOf(String r100) {
        return (RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum) a.a(RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum.class, r100);
    }

    public RoundedBackgroundSpanHelper$TextHorizontalPaddingEnum(String r100, int r101) {
        super(r100, r101);
    }
}

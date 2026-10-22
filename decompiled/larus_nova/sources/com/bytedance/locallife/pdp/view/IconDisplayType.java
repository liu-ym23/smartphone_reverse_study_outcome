package com.bytedance.locallife.pdp.view;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/pdp/view/IconDisplayType;", "", EffectConstants.NORMAL, "SHOW_NOTHING_IN_X_SCREEN", "SHOW_SHARE_IN_X_SCREEN", "SHOW_ALL_IN_X_SCREEN", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum IconDisplayType extends Enum<IconDisplayType> {
    public static final IconDisplayType NORMAL = null;
    public static final IconDisplayType SHOW_ALL_IN_X_SCREEN = null;
    public static final IconDisplayType SHOW_NOTHING_IN_X_SCREEN = null;
    public static final IconDisplayType SHOW_SHARE_IN_X_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconDisplayType[] f261833a = null;

    public static IconDisplayType valueOf(String r100) {
        return (IconDisplayType) r27.a.a(IconDisplayType.class, r100);
    }

    public static IconDisplayType[] values() {
        return (IconDisplayType[]) f261833a.clone();
    }

    static {
        IconDisplayType r100 = new IconDisplayType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        IconDisplayType r101 = new IconDisplayType("SHOW_NOTHING_IN_X_SCREEN", 1);
        SHOW_NOTHING_IN_X_SCREEN = r101;
        IconDisplayType r102 = new IconDisplayType("SHOW_SHARE_IN_X_SCREEN", 2);
        SHOW_SHARE_IN_X_SCREEN = r102;
        IconDisplayType r103 = new IconDisplayType("SHOW_ALL_IN_X_SCREEN", 3);
        SHOW_ALL_IN_X_SCREEN = r103;
        f261833a = new IconDisplayType[]{r100, r101, r102, r103};
    }

    public IconDisplayType(String r100, int r101) {
        super(r100, r101);
    }
}

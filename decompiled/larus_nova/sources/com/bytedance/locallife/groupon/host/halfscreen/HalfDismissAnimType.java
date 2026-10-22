package com.bytedance.locallife.groupon.host.halfscreen;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/groupon/host/halfscreen/HalfDismissAnimType;", "", EffectConstants.NORMAL, "TO_ENTRANCE", "TO_ENTRANCE_WITH_MASK", "locallife-groupon-host-api_release"}, k = 1, mv = {1, 4, 3})
public final enum HalfDismissAnimType extends Enum<HalfDismissAnimType> {
    public static final HalfDismissAnimType NORMAL = null;
    public static final HalfDismissAnimType TO_ENTRANCE = null;
    public static final HalfDismissAnimType TO_ENTRANCE_WITH_MASK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HalfDismissAnimType[] f258802a = null;

    public static HalfDismissAnimType valueOf(String r100) {
        return (HalfDismissAnimType) a.a(HalfDismissAnimType.class, r100);
    }

    public static HalfDismissAnimType[] values() {
        return (HalfDismissAnimType[]) f258802a.clone();
    }

    static {
        HalfDismissAnimType r100 = new HalfDismissAnimType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        HalfDismissAnimType r101 = new HalfDismissAnimType("TO_ENTRANCE", 1);
        TO_ENTRANCE = r101;
        HalfDismissAnimType r102 = new HalfDismissAnimType("TO_ENTRANCE_WITH_MASK", 2);
        TO_ENTRANCE_WITH_MASK = r102;
        f258802a = new HalfDismissAnimType[]{r100, r101, r102};
    }

    public HalfDismissAnimType(String r100, int r101) {
        super(r100, r101);
    }
}

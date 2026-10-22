package com.bytedance.ies.bullet.service.base.callbacks;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/callbacks/ViewBlankState;", "", EffectConstants.NORMAL, "BLANK", "UNKNOWN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ViewBlankState extends Enum<ViewBlankState> {
    public static final ViewBlankState BLANK = null;
    public static final ViewBlankState NORMAL = null;
    public static final ViewBlankState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewBlankState[] f247804a = null;

    public static ViewBlankState valueOf(String r100) {
        return (ViewBlankState) a.a(ViewBlankState.class, r100);
    }

    public static ViewBlankState[] values() {
        return (ViewBlankState[]) f247804a.clone();
    }

    static {
        ViewBlankState r100 = new ViewBlankState(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ViewBlankState r101 = new ViewBlankState("BLANK", 1);
        BLANK = r101;
        ViewBlankState r102 = new ViewBlankState("UNKNOWN", 2);
        UNKNOWN = r102;
        f247804a = new ViewBlankState[]{r100, r101, r102};
    }

    public ViewBlankState(String r100, int r101) {
        super(r100, r101);
    }
}

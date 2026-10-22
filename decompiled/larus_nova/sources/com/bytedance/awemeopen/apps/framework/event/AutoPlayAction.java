package com.bytedance.awemeopen.apps.framework.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/event/AutoPlayAction;", "", "STOP_AUTOPLAY", "TRY_STOP_AUTOPLAY", "REOPEN_AUTOPLAY", "SERIES_OPEN_AUTOPLAY", "SERIES_STOP_AUTOPLAY", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum AutoPlayAction extends Enum<AutoPlayAction> {
    public static final AutoPlayAction REOPEN_AUTOPLAY = null;
    public static final AutoPlayAction SERIES_OPEN_AUTOPLAY = null;
    public static final AutoPlayAction SERIES_STOP_AUTOPLAY = null;
    public static final AutoPlayAction STOP_AUTOPLAY = null;
    public static final AutoPlayAction TRY_STOP_AUTOPLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoPlayAction[] f194595a = null;

    public static AutoPlayAction valueOf(String r100) {
        return (AutoPlayAction) a.a(AutoPlayAction.class, r100);
    }

    public static AutoPlayAction[] values() {
        return (AutoPlayAction[]) f194595a.clone();
    }

    static {
        AutoPlayAction r100 = new AutoPlayAction("STOP_AUTOPLAY", 0);
        STOP_AUTOPLAY = r100;
        AutoPlayAction r101 = new AutoPlayAction("TRY_STOP_AUTOPLAY", 1);
        TRY_STOP_AUTOPLAY = r101;
        AutoPlayAction r102 = new AutoPlayAction("REOPEN_AUTOPLAY", 2);
        REOPEN_AUTOPLAY = r102;
        AutoPlayAction r103 = new AutoPlayAction("SERIES_OPEN_AUTOPLAY", 3);
        SERIES_OPEN_AUTOPLAY = r103;
        AutoPlayAction r104 = new AutoPlayAction("SERIES_STOP_AUTOPLAY", 4);
        SERIES_STOP_AUTOPLAY = r104;
        f194595a = new AutoPlayAction[]{r100, r101, r102, r103, r104};
    }

    public AutoPlayAction(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.livesdk.preview.activities;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/activities/PreviewViewShowingStatus;", "", "NOT_SHOW", "SHOWING", "SHOWED", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewViewShowingStatus extends Enum<PreviewViewShowingStatus> {
    public static final PreviewViewShowingStatus NOT_SHOW = null;
    public static final PreviewViewShowingStatus SHOWED = null;
    public static final PreviewViewShowingStatus SHOWING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewViewShowingStatus[] f256399a = null;

    static {
        PreviewViewShowingStatus r100 = new PreviewViewShowingStatus("NOT_SHOW", 0);
        NOT_SHOW = r100;
        PreviewViewShowingStatus r101 = new PreviewViewShowingStatus("SHOWING", 1);
        SHOWING = r101;
        PreviewViewShowingStatus r102 = new PreviewViewShowingStatus("SHOWED", 2);
        SHOWED = r102;
        f256399a = new PreviewViewShowingStatus[]{r100, r101, r102};
    }

    public static PreviewViewShowingStatus valueOf(String r100) {
        return (PreviewViewShowingStatus) a.a(PreviewViewShowingStatus.class, r100);
    }

    public static PreviewViewShowingStatus[] values() {
        return (PreviewViewShowingStatus[]) f256399a.clone();
    }

    public PreviewViewShowingStatus(String r100, int r101) {
        super(r100, r101);
    }
}

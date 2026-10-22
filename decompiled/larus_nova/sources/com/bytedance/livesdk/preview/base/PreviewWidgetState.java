package com.bytedance.livesdk.preview.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/base/PreviewWidgetState;", "", "LOADING", "LOADED", "UNLOAD", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PreviewWidgetState extends Enum<PreviewWidgetState> {
    public static final PreviewWidgetState LOADED = null;
    public static final PreviewWidgetState LOADING = null;
    public static final PreviewWidgetState UNLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewWidgetState[] f256405a = null;

    static {
        PreviewWidgetState r100 = new PreviewWidgetState("LOADING", 0);
        LOADING = r100;
        PreviewWidgetState r101 = new PreviewWidgetState("LOADED", 1);
        LOADED = r101;
        PreviewWidgetState r102 = new PreviewWidgetState("UNLOAD", 2);
        UNLOAD = r102;
        f256405a = new PreviewWidgetState[]{r100, r101, r102};
    }

    public static PreviewWidgetState valueOf(String r100) {
        return (PreviewWidgetState) r27.a.a(PreviewWidgetState.class, r100);
    }

    public static PreviewWidgetState[] values() {
        return (PreviewWidgetState[]) f256405a.clone();
    }

    public PreviewWidgetState(String r100, int r101) {
        super(r100, r101);
    }
}

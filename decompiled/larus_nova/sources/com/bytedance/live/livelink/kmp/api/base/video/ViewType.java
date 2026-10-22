package com.bytedance.live.livelink.kmp.api.base.video;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/video/ViewType;", "", "SURFACE_VIEW", "TEXTURE_VIEW", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ViewType extends Enum<ViewType> {
    public static final ViewType SURFACE_VIEW = null;
    public static final ViewType TEXTURE_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewType[] f255229a = null;

    static {
        ViewType r100 = new ViewType("SURFACE_VIEW", 0);
        SURFACE_VIEW = r100;
        ViewType r101 = new ViewType("TEXTURE_VIEW", 1);
        TEXTURE_VIEW = r101;
        f255229a = new ViewType[]{r100, r101};
    }

    public static ViewType valueOf(String r100) {
        return (ViewType) a.a(ViewType.class, r100);
    }

    public static ViewType[] values() {
        return (ViewType[]) f255229a.clone();
    }

    public ViewType(String r100, int r101) {
        super(r100, r101);
    }
}

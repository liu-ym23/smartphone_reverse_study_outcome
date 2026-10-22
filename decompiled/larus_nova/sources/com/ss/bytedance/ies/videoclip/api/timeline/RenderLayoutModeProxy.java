package com.ss.bytedance.ies.videoclip.api.timeline;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/bytedance/ies/videoclip/api/timeline/RenderLayoutModeProxy;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "aspectFit", "aspectFill", "videoclip-api-0.0.0.2-alpha.93@aar_release"}, k = 1, mv = {1, 4, 0})
public final enum RenderLayoutModeProxy extends Enum<RenderLayoutModeProxy> {
    public static final int ASPECT_FILL = 1;
    public static final int ASPECT_FIT = 0;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderLayoutModeProxy[] f456078a = null;
    public static final RenderLayoutModeProxy aspectFill = null;
    public static final RenderLayoutModeProxy aspectFit = null;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.bytedance.ies.videoclip.api.timeline.RenderLayoutModeProxy$a] */
    static {
        RenderLayoutModeProxy r100 = new RenderLayoutModeProxy("aspectFit", 0);
        aspectFit = r100;
        RenderLayoutModeProxy r101 = new RenderLayoutModeProxy("aspectFill", 1);
        aspectFill = r101;
        f456078a = new RenderLayoutModeProxy[]{r100, r101};
        Companion = new a();
    }

    public static RenderLayoutModeProxy valueOf(String r100) {
        return (RenderLayoutModeProxy) r27.a.a(RenderLayoutModeProxy.class, r100);
    }

    public static RenderLayoutModeProxy[] values() {
        return (RenderLayoutModeProxy[]) f456078a.clone();
    }

    public RenderLayoutModeProxy(String r100, int r101) {
        super(r100, r101);
    }
}

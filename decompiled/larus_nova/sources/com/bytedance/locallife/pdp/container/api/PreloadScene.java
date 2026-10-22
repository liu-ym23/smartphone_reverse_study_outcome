package com.bytedance.locallife.pdp.container.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/pdp/container/api/PreloadScene;", "", "FMP_COMPLETE", "SHOW_ALL_CONTENT", "ENTER_PAGE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PreloadScene extends Enum<PreloadScene> {
    public static final PreloadScene ENTER_PAGE = null;
    public static final PreloadScene FMP_COMPLETE = null;
    public static final PreloadScene SHOW_ALL_CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadScene[] f261131a = null;

    public static PreloadScene valueOf(String r100) {
        return (PreloadScene) a.a(PreloadScene.class, r100);
    }

    public static PreloadScene[] values() {
        return (PreloadScene[]) f261131a.clone();
    }

    static {
        PreloadScene r100 = new PreloadScene("FMP_COMPLETE", 0);
        FMP_COMPLETE = r100;
        PreloadScene r101 = new PreloadScene("SHOW_ALL_CONTENT", 1);
        SHOW_ALL_CONTENT = r101;
        PreloadScene r102 = new PreloadScene("ENTER_PAGE", 2);
        ENTER_PAGE = r102;
        f261131a = new PreloadScene[]{r100, r101, r102};
    }

    public PreloadScene(String r100, int r101) {
        super(r100, r101);
    }
}

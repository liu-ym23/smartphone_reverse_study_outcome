package com.bytedance.live.layout;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/layout/LayoutStrategy;", "", EffectConstants.NORMAL, "MATCH", "dynamiclayout_release"}, k = 1, mv = {1, 4, 3})
public final enum LayoutStrategy extends Enum<LayoutStrategy> {
    public static final LayoutStrategy MATCH = null;
    public static final LayoutStrategy NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayoutStrategy[] f255195a = null;

    public static LayoutStrategy valueOf(String r100) {
        return (LayoutStrategy) r27.a.a(LayoutStrategy.class, r100);
    }

    public static LayoutStrategy[] values() {
        return (LayoutStrategy[]) f255195a.clone();
    }

    static {
        LayoutStrategy r100 = new LayoutStrategy(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        LayoutStrategy r101 = new LayoutStrategy("MATCH", 1);
        MATCH = r101;
        f255195a = new LayoutStrategy[]{r100, r101};
    }

    public LayoutStrategy(String r100, int r101) {
        super(r100, r101);
    }
}

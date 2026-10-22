package com.ss.android.ugc.aweme.search.dynamic.core.render;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/render/RenderType;", "", EffectConstants.NORMAL, "REUSE", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType NORMAL = null;
    public static final RenderType REUSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f452732a = null;

    public static RenderType valueOf(String r100) {
        return (RenderType) a.a(RenderType.class, r100);
    }

    public static RenderType[] values() {
        return (RenderType[]) f452732a.clone();
    }

    static {
        RenderType r100 = new RenderType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RenderType r101 = new RenderType("REUSE", 1);
        REUSE = r101;
        f452732a = new RenderType[]{r100, r101};
    }

    public RenderType(String r100, int r101) {
        super(r100, r101);
    }
}

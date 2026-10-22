package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/forest/model/PreloadType;", "", "LYNX", "WEB", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum PreloadType extends Enum<PreloadType> {
    public static final PreloadType LYNX = null;
    public static final PreloadType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadType[] f244269a = null;

    static {
        PreloadType r100 = new PreloadType("LYNX", 0);
        LYNX = r100;
        PreloadType r101 = new PreloadType("WEB", 1);
        WEB = r101;
        f244269a = new PreloadType[]{r100, r101};
    }

    public static PreloadType valueOf(String r100) {
        return (PreloadType) r27.a.a(PreloadType.class, r100);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) f244269a.clone();
    }

    public PreloadType(String r100, int r101) {
        super(r100, r101);
    }
}

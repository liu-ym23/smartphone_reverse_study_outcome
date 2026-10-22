package com.bytedance.locallife.cube.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/LoadMode;", "", "(Ljava/lang/String;I)V", "LOAD", "PRELOAD", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum LoadMode extends Enum<LoadMode> {
    private static final /* synthetic */ LoadMode[] $VALUES = null;
    public static final LoadMode LOAD = null;
    public static final LoadMode PRELOAD = null;

    private static final /* synthetic */ LoadMode[] $values() {
        return new LoadMode[]{LOAD, PRELOAD};
    }

    public static LoadMode valueOf(String r100) {
        return (LoadMode) a.a(LoadMode.class, r100);
    }

    public static LoadMode[] values() {
        return (LoadMode[]) $VALUES.clone();
    }

    static {
        LOAD = new LoadMode("LOAD", 0);
        PRELOAD = new LoadMode("PRELOAD", 1);
        $VALUES = $values();
    }

    private LoadMode(String r100, int r101) {
        super(r100, r101);
    }
}

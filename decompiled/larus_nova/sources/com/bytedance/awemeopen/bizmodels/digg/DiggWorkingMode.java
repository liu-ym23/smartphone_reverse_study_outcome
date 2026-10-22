package com.bytedance.awemeopen.bizmodels.digg;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/digg/DiggWorkingMode;", "", "SERVER_MODE", "LOCAL_MODE", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum DiggWorkingMode extends Enum<DiggWorkingMode> {
    public static final DiggWorkingMode LOCAL_MODE = null;
    public static final DiggWorkingMode SERVER_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiggWorkingMode[] f198171a = null;

    public static DiggWorkingMode valueOf(String r100) {
        return (DiggWorkingMode) a.a(DiggWorkingMode.class, r100);
    }

    public static DiggWorkingMode[] values() {
        return (DiggWorkingMode[]) f198171a.clone();
    }

    static {
        DiggWorkingMode r100 = new DiggWorkingMode("SERVER_MODE", 0);
        SERVER_MODE = r100;
        DiggWorkingMode r101 = new DiggWorkingMode("LOCAL_MODE", 1);
        LOCAL_MODE = r101;
        f198171a = new DiggWorkingMode[]{r100, r101};
    }

    public DiggWorkingMode(String r100, int r101) {
        super(r100, r101);
    }
}

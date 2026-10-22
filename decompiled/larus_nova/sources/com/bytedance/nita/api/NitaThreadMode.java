package com.bytedance.nita.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/nita/api/NitaThreadMode;", "", "SINGLE", "MUTIPLE", "core_release"}, k = 1, mv = {1, 4, 0})
public final enum NitaThreadMode extends Enum<NitaThreadMode> {
    public static final NitaThreadMode MUTIPLE = null;
    public static final NitaThreadMode SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NitaThreadMode[] f265992a = null;

    static {
        NitaThreadMode r100 = new NitaThreadMode("SINGLE", 0);
        SINGLE = r100;
        NitaThreadMode r101 = new NitaThreadMode("MUTIPLE", 1);
        MUTIPLE = r101;
        f265992a = new NitaThreadMode[]{r100, r101};
    }

    public static NitaThreadMode valueOf(String r100) {
        return (NitaThreadMode) r27.a.a(NitaThreadMode.class, r100);
    }

    public static NitaThreadMode[] values() {
        return (NitaThreadMode[]) f265992a.clone();
    }

    public NitaThreadMode(String r100, int r101) {
        super(r100, r101);
    }
}

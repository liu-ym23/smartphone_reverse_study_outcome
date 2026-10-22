package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusResourceFrom;", "", "GECKO", "CDN", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusResourceFrom extends Enum<ArgusResourceFrom> {
    public static final ArgusResourceFrom CDN = null;
    public static final ArgusResourceFrom GECKO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusResourceFrom[] f245647a = null;

    public static ArgusResourceFrom valueOf(String r100) {
        return (ArgusResourceFrom) r27.a.a(ArgusResourceFrom.class, r100);
    }

    public static ArgusResourceFrom[] values() {
        return (ArgusResourceFrom[]) f245647a.clone();
    }

    static {
        ArgusResourceFrom r100 = new ArgusResourceFrom("GECKO", 0);
        GECKO = r100;
        ArgusResourceFrom r101 = new ArgusResourceFrom("CDN", 1);
        CDN = r101;
        f245647a = new ArgusResourceFrom[]{r100, r101};
    }

    public ArgusResourceFrom(String r100, int r101) {
        super(r100, r101);
    }
}

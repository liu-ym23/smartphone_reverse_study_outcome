package com.bytedance.ies.argus.aspect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/argus/aspect/ArgusLynxUpdateSignFeIdType;", "", "STRING", "INT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusLynxUpdateSignFeIdType extends Enum<ArgusLynxUpdateSignFeIdType> {
    public static final ArgusLynxUpdateSignFeIdType INT = null;
    public static final ArgusLynxUpdateSignFeIdType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusLynxUpdateSignFeIdType[] f245796a = null;

    public static ArgusLynxUpdateSignFeIdType valueOf(String r100) {
        return (ArgusLynxUpdateSignFeIdType) r27.a.a(ArgusLynxUpdateSignFeIdType.class, r100);
    }

    public static ArgusLynxUpdateSignFeIdType[] values() {
        return (ArgusLynxUpdateSignFeIdType[]) f245796a.clone();
    }

    static {
        ArgusLynxUpdateSignFeIdType r100 = new ArgusLynxUpdateSignFeIdType("STRING", 0);
        STRING = r100;
        ArgusLynxUpdateSignFeIdType r101 = new ArgusLynxUpdateSignFeIdType("INT", 1);
        INT = r101;
        f245796a = new ArgusLynxUpdateSignFeIdType[]{r100, r101};
    }

    public ArgusLynxUpdateSignFeIdType(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.nita.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/nita/api/NitaSchdulerType;", "", "AT_ONCE", "IDEL", "core_release"}, k = 1, mv = {1, 4, 0})
public final enum NitaSchdulerType extends Enum<NitaSchdulerType> {
    public static final NitaSchdulerType AT_ONCE = null;
    public static final NitaSchdulerType IDEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NitaSchdulerType[] f265991a = null;

    static {
        NitaSchdulerType r100 = new NitaSchdulerType("AT_ONCE", 0);
        AT_ONCE = r100;
        NitaSchdulerType r101 = new NitaSchdulerType("IDEL", 1);
        IDEL = r101;
        f265991a = new NitaSchdulerType[]{r100, r101};
    }

    public static NitaSchdulerType valueOf(String r100) {
        return (NitaSchdulerType) r27.a.a(NitaSchdulerType.class, r100);
    }

    public static NitaSchdulerType[] values() {
        return (NitaSchdulerType[]) f265991a.clone();
    }

    public NitaSchdulerType(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.awemeopen.servicesapi.platform;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/platform/HostFuncType;", "", "LIVE", "ECOM", "LOCAL_LIFE", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum HostFuncType extends Enum<HostFuncType> {
    public static final HostFuncType ECOM = null;
    public static final HostFuncType LIVE = null;
    public static final HostFuncType LOCAL_LIFE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HostFuncType[] f199004a = null;

    public static HostFuncType valueOf(String r100) {
        return (HostFuncType) a.a(HostFuncType.class, r100);
    }

    public static HostFuncType[] values() {
        return (HostFuncType[]) f199004a.clone();
    }

    static {
        HostFuncType r100 = new HostFuncType("LIVE", 0);
        LIVE = r100;
        HostFuncType r101 = new HostFuncType("ECOM", 1);
        ECOM = r101;
        HostFuncType r102 = new HostFuncType("LOCAL_LIFE", 2);
        LOCAL_LIFE = r102;
        f199004a = new HostFuncType[]{r100, r101, r102};
    }

    public HostFuncType(String r100, int r101) {
        super(r100, r101);
    }
}

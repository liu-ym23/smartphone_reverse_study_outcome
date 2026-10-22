package com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/jsbDependency/ContainerType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "H5", "LYNX", "UNKNOWN", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType H5 = null;
    public static final ContainerType LYNX = null;
    public static final ContainerType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f202218a = null;
    private final String type;

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f202218a.clone();
    }

    static {
        ContainerType r100 = new ContainerType("H5", 0, "h5");
        H5 = r100;
        ContainerType r101 = new ContainerType("LYNX", 1, "lynx");
        LYNX = r101;
        ContainerType r102 = new ContainerType("UNKNOWN", 2, "unknown");
        UNKNOWN = r102;
        f202218a = new ContainerType[]{r100, r101, r102};
    }

    public final String getType() {
        return this.type;
    }

    public ContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

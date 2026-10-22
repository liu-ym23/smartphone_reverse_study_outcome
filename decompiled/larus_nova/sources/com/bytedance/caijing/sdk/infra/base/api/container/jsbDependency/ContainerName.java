package com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/jsbDependency/ContainerName;", "", "", "isNotCJH5", "", "containerName", "Ljava/lang/String;", "getContainerName", "()Ljava/lang/String;", "CJ_H5", "CJ_ANNIE_H5", "WEBCAST", "BULLET", "ANNIE_X", "ANNIE_X_CARD", "UNKNOWN", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum ContainerName extends Enum<ContainerName> {
    public static final ContainerName ANNIE_X = null;
    public static final ContainerName ANNIE_X_CARD = null;
    public static final ContainerName BULLET = null;
    public static final ContainerName CJ_ANNIE_H5 = null;
    public static final ContainerName CJ_H5 = null;
    public static final ContainerName UNKNOWN = null;
    public static final ContainerName WEBCAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerName[] f202217a = null;
    private final String containerName;

    public static ContainerName valueOf(String r100) {
        return (ContainerName) a.a(ContainerName.class, r100);
    }

    public static ContainerName[] values() {
        return (ContainerName[]) f202217a.clone();
    }

    static {
        ContainerName r100 = new ContainerName("CJ_H5", 0, "cj-h5");
        CJ_H5 = r100;
        ContainerName r101 = new ContainerName("CJ_ANNIE_H5", 1, "cj-annie-h5");
        CJ_ANNIE_H5 = r101;
        ContainerName r102 = new ContainerName("WEBCAST", 2, "webcast");
        WEBCAST = r102;
        ContainerName r103 = new ContainerName("BULLET", 3, "bullet");
        BULLET = r103;
        ContainerName r104 = new ContainerName("ANNIE_X", 4, "annie_x");
        ANNIE_X = r104;
        ContainerName r105 = new ContainerName("ANNIE_X_CARD", 5, "annie_x_card");
        ANNIE_X_CARD = r105;
        ContainerName r110 = new ContainerName("UNKNOWN", 6, "unknown");
        UNKNOWN = r110;
        f202217a = new ContainerName[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final boolean isNotCJH5() {
        if (CJ_H5 == this) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getContainerName() {
        return this.containerName;
    }

    public ContainerName(String r100, int r101, String r102) {
        super(r100, r101);
        this.containerName = r102;
    }
}

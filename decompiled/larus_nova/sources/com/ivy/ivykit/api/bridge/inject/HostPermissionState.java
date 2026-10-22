package com.ivy.ivykit.api.bridge.inject;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ivy/ivykit/api/bridge/inject/HostPermissionState;", "", "GRANTED", "DENIED", "REJECTED", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public final enum HostPermissionState extends Enum<HostPermissionState> {
    public static final HostPermissionState DENIED = null;
    public static final HostPermissionState GRANTED = null;
    public static final HostPermissionState REJECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HostPermissionState[] f278316a = null;

    public static HostPermissionState valueOf(String r100) {
        return (HostPermissionState) a.a(HostPermissionState.class, r100);
    }

    public static HostPermissionState[] values() {
        return (HostPermissionState[]) f278316a.clone();
    }

    static {
        HostPermissionState r100 = new HostPermissionState("GRANTED", 0);
        GRANTED = r100;
        HostPermissionState r101 = new HostPermissionState("DENIED", 1);
        DENIED = r101;
        HostPermissionState r102 = new HostPermissionState("REJECTED", 2);
        REJECTED = r102;
        f278316a = new HostPermissionState[]{r100, r101, r102};
    }

    public HostPermissionState(String r100, int r101) {
        super(r100, r101);
    }
}

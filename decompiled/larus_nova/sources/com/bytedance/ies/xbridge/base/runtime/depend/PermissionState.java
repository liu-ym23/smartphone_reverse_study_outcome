package com.bytedance.ies.xbridge.base.runtime.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/PermissionState;", "", "GRANTED", "DENIED", "REJECTED", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PermissionState extends Enum<PermissionState> {
    public static final PermissionState DENIED = null;
    public static final PermissionState GRANTED = null;
    public static final PermissionState REJECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionState[] f249447a = null;

    public static PermissionState valueOf(String r100) {
        return (PermissionState) a.a(PermissionState.class, r100);
    }

    public static PermissionState[] values() {
        return (PermissionState[]) f249447a.clone();
    }

    static {
        PermissionState r100 = new PermissionState("GRANTED", 0);
        GRANTED = r100;
        PermissionState r101 = new PermissionState("DENIED", 1);
        DENIED = r101;
        PermissionState r102 = new PermissionState("REJECTED", 2);
        REJECTED = r102;
        f249447a = new PermissionState[]{r100, r101, r102};
    }

    public PermissionState(String r100, int r101) {
        super(r100, r101);
    }
}

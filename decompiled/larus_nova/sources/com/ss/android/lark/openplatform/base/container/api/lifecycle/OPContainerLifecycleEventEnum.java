package com.ss.android.lark.openplatform.base.container.api.lifecycle;

import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum OPContainerLifecycleEventEnum extends Enum<OPContainerLifecycleEventEnum> {
    public static final OPContainerLifecycleEventEnum ON_CREATE = null;
    public static final OPContainerLifecycleEventEnum ON_DESTROY = null;
    public static final OPContainerLifecycleEventEnum ON_HIDE = null;
    public static final OPContainerLifecycleEventEnum ON_SHOW = null;
    public static final OPContainerLifecycleEventEnum ON_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OPContainerLifecycleEventEnum[] f437585a = null;

    static {
        OPContainerLifecycleEventEnum r100 = new OPContainerLifecycleEventEnum("ON_CREATE", 0);
        ON_CREATE = r100;
        OPContainerLifecycleEventEnum r101 = new OPContainerLifecycleEventEnum("ON_SHOW", 1);
        ON_SHOW = r101;
        OPContainerLifecycleEventEnum r102 = new OPContainerLifecycleEventEnum("ON_HIDE", 2);
        ON_HIDE = r102;
        OPContainerLifecycleEventEnum r103 = new OPContainerLifecycleEventEnum("ON_STOP", 3);
        ON_STOP = r103;
        OPContainerLifecycleEventEnum r104 = new OPContainerLifecycleEventEnum("ON_DESTROY", 4);
        ON_DESTROY = r104;
        f437585a = new OPContainerLifecycleEventEnum[]{r100, r101, r102, r103, r104};
    }

    public static OPContainerLifecycleEventEnum[] values() {
        return (OPContainerLifecycleEventEnum[]) f437585a.clone();
    }

    public static OPContainerLifecycleEventEnum valueOf(String r100) {
        return (OPContainerLifecycleEventEnum) a.a(OPContainerLifecycleEventEnum.class, r100);
    }

    public OPContainerLifecycleEventEnum(String r100, int r101) {
        super(r100, r101);
    }
}

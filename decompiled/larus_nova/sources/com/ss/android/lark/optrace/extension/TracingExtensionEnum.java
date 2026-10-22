package com.ss.android.lark.optrace.extension;

import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TracingExtensionEnum extends Enum<TracingExtensionEnum> {
    public static final TracingExtensionEnum CLIENT_DURATION = null;
    public static final TracingExtensionEnum CLIENT_REQUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TracingExtensionEnum[] f437608a = null;

    static {
        TracingExtensionEnum r100 = new TracingExtensionEnum("CLIENT_DURATION", 0);
        CLIENT_DURATION = r100;
        TracingExtensionEnum r101 = new TracingExtensionEnum("CLIENT_REQUEST", 1);
        CLIENT_REQUEST = r101;
        f437608a = new TracingExtensionEnum[]{r100, r101};
    }

    public static TracingExtensionEnum[] values() {
        return (TracingExtensionEnum[]) f437608a.clone();
    }

    public static TracingExtensionEnum valueOf(String r100) {
        return (TracingExtensionEnum) a.a(TracingExtensionEnum.class, r100);
    }

    public TracingExtensionEnum(String r100, int r101) {
        super(r100, r101);
    }
}

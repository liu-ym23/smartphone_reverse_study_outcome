package io.opentelemetry.api.trace;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum StatusCode extends Enum<StatusCode> {
    public static final StatusCode ERROR = null;
    public static final StatusCode OK = null;
    public static final StatusCode UNSET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusCode[] f492683a = null;

    static {
        StatusCode r100 = new StatusCode("UNSET", 0);
        UNSET = r100;
        StatusCode r101 = new StatusCode("OK", 1);
        OK = r101;
        StatusCode r102 = new StatusCode("ERROR", 2);
        ERROR = r102;
        f492683a = new StatusCode[]{r100, r101, r102};
    }

    public static StatusCode[] values() {
        return (StatusCode[]) f492683a.clone();
    }

    public static StatusCode valueOf(String r100) {
        return (StatusCode) a.a(StatusCode.class, r100);
    }

    public StatusCode(String r100, int r101) {
        super(r100, r101);
    }
}

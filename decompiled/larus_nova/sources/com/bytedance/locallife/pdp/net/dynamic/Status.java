package com.bytedance.locallife.pdp.net.dynamic;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/pdp/net/dynamic/Status;", "", "SUCCESS", "FAILURE", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum Status extends Enum<Status> {
    public static final Status FAILURE = null;
    public static final Status SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Status[] f261600a = null;

    public static Status valueOf(String r100) {
        return (Status) r27.a.a(Status.class, r100);
    }

    public static Status[] values() {
        return (Status[]) f261600a.clone();
    }

    static {
        Status r100 = new Status("SUCCESS", 0);
        SUCCESS = r100;
        Status r101 = new Status("FAILURE", 1);
        FAILURE = r101;
        f261600a = new Status[]{r100, r101};
    }

    public Status(String r100, int r101) {
        super(r100, r101);
    }
}

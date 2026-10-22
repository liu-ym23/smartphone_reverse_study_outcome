package com.bytedance.caijing.sdk.infra.base.api.trip.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/caijing/sdk/infra/base/api/trip/host/OpenAuthResult$Code", "", "Lcom/bytedance/caijing/sdk/infra/base/api/trip/host/OpenAuthResult$Code;", "SUCCESS", "FAIL", "CANCEL", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum OpenAuthResult$Code extends Enum<OpenAuthResult$Code> {
    public static final OpenAuthResult$Code CANCEL = null;
    public static final OpenAuthResult$Code FAIL = null;
    public static final OpenAuthResult$Code SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenAuthResult$Code[] f202250a = null;

    public static OpenAuthResult$Code valueOf(String r100) {
        return (OpenAuthResult$Code) a.a(OpenAuthResult$Code.class, r100);
    }

    public static OpenAuthResult$Code[] values() {
        return (OpenAuthResult$Code[]) f202250a.clone();
    }

    static {
        OpenAuthResult$Code r100 = new OpenAuthResult$Code("SUCCESS", 0);
        SUCCESS = r100;
        OpenAuthResult$Code r101 = new OpenAuthResult$Code("FAIL", 1);
        FAIL = r101;
        OpenAuthResult$Code r102 = new OpenAuthResult$Code("CANCEL", 2);
        CANCEL = r102;
        f202250a = new OpenAuthResult$Code[]{r100, r101, r102};
    }

    public OpenAuthResult$Code(String r100, int r101) {
        super(r100, r101);
    }
}

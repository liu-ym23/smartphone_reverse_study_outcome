package com.bytedance.locallife.groupon.session;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/locallife/groupon/session/SessionParamsType;", "", "COMMON_PARAMS", "TRACK_PARAMS", "SCHEMA_PARAMS", "EXTRA_PARAMS", "locallife-groupon-common_release"}, k = 1, mv = {1, 4, 3})
public final enum SessionParamsType extends Enum<SessionParamsType> {
    public static final SessionParamsType COMMON_PARAMS = null;
    public static final SessionParamsType EXTRA_PARAMS = null;
    public static final SessionParamsType SCHEMA_PARAMS = null;
    public static final SessionParamsType TRACK_PARAMS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionParamsType[] f258808a = null;

    public static SessionParamsType valueOf(String r100) {
        return (SessionParamsType) r27.a.a(SessionParamsType.class, r100);
    }

    public static SessionParamsType[] values() {
        return (SessionParamsType[]) f258808a.clone();
    }

    static {
        SessionParamsType r100 = new SessionParamsType("COMMON_PARAMS", 0);
        COMMON_PARAMS = r100;
        SessionParamsType r101 = new SessionParamsType("TRACK_PARAMS", 1);
        TRACK_PARAMS = r101;
        SessionParamsType r102 = new SessionParamsType("SCHEMA_PARAMS", 2);
        SCHEMA_PARAMS = r102;
        SessionParamsType r103 = new SessionParamsType("EXTRA_PARAMS", 3);
        EXTRA_PARAMS = r103;
        f258808a = new SessionParamsType[]{r100, r101, r102, r103};
    }

    public SessionParamsType(String r100, int r101) {
        super(r100, r101);
    }
}

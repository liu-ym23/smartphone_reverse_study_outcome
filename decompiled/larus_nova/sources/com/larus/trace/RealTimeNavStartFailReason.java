package com.larus.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/trace/RealTimeNavStartFailReason;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CODE_ERROR", "AUTH_ERROR", "PARAMS_ERROR", "GET_ORIGIN_ERROR", "ROUTE_ERROR", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealTimeNavStartFailReason extends Enum<RealTimeNavStartFailReason> {
    public static final RealTimeNavStartFailReason AUTH_ERROR = null;
    public static final RealTimeNavStartFailReason CODE_ERROR = null;
    public static final RealTimeNavStartFailReason GET_ORIGIN_ERROR = null;
    public static final RealTimeNavStartFailReason PARAMS_ERROR = null;
    public static final RealTimeNavStartFailReason ROUTE_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeNavStartFailReason[] f370149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370150b = null;
    private final String value;

    public static EnumEntries<RealTimeNavStartFailReason> getEntries() {
        return f370150b;
    }

    static {
        RealTimeNavStartFailReason r100 = new RealTimeNavStartFailReason("CODE_ERROR", 0, "code_error");
        CODE_ERROR = r100;
        RealTimeNavStartFailReason r101 = new RealTimeNavStartFailReason("AUTH_ERROR", 1, "auth_error");
        AUTH_ERROR = r101;
        RealTimeNavStartFailReason r102 = new RealTimeNavStartFailReason("PARAMS_ERROR", 2, "params_error");
        PARAMS_ERROR = r102;
        RealTimeNavStartFailReason r103 = new RealTimeNavStartFailReason("GET_ORIGIN_ERROR", 3, "get_origin_error");
        GET_ORIGIN_ERROR = r103;
        RealTimeNavStartFailReason r104 = new RealTimeNavStartFailReason("ROUTE_ERROR", 4, "route_error");
        ROUTE_ERROR = r104;
        RealTimeNavStartFailReason[] r105 = {r100, r101, r102, r103, r104};
        f370149a = r105;
        f370150b = EnumEntriesKt.enumEntries(r105);
    }

    public static RealTimeNavStartFailReason[] values() {
        return (RealTimeNavStartFailReason[]) f370149a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static RealTimeNavStartFailReason valueOf(String r100) {
        return (RealTimeNavStartFailReason) a.a(RealTimeNavStartFailReason.class, r100);
    }

    public RealTimeNavStartFailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

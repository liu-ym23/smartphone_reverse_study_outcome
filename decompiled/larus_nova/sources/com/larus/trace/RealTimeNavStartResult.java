package com.larus.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/trace/RealTimeNavStartResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAILURE", "SUCCESS", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RealTimeNavStartResult extends Enum<RealTimeNavStartResult> {
    public static final RealTimeNavStartResult FAILURE = null;
    public static final RealTimeNavStartResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RealTimeNavStartResult[] f370151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370152b = null;
    private final int value;

    public static EnumEntries<RealTimeNavStartResult> getEntries() {
        return f370152b;
    }

    static {
        RealTimeNavStartResult r100 = new RealTimeNavStartResult("FAILURE", 0, 0);
        FAILURE = r100;
        RealTimeNavStartResult r101 = new RealTimeNavStartResult("SUCCESS", 1, 1);
        SUCCESS = r101;
        RealTimeNavStartResult[] r102 = {r100, r101};
        f370151a = r102;
        f370152b = EnumEntriesKt.enumEntries(r102);
    }

    public static RealTimeNavStartResult[] values() {
        return (RealTimeNavStartResult[]) f370151a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RealTimeNavStartResult valueOf(String r100) {
        return (RealTimeNavStartResult) a.a(RealTimeNavStartResult.class, r100);
    }

    public RealTimeNavStartResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

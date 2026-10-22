package com.larus.lbs.trace.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/lbs/trace/api/model/LbsTraceInitializationStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "ALREADY_INITIALIZED", "INITIALIZING", "DISABLED", "FAILED", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LbsTraceInitializationStatus extends Enum<LbsTraceInitializationStatus> {
    public static final LbsTraceInitializationStatus ALREADY_INITIALIZED = null;
    public static final LbsTraceInitializationStatus DISABLED = null;
    public static final LbsTraceInitializationStatus FAILED = null;
    public static final LbsTraceInitializationStatus INITIALIZING = null;
    public static final LbsTraceInitializationStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LbsTraceInitializationStatus[] f355715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355716b = null;
    private final int value;

    public static EnumEntries<LbsTraceInitializationStatus> getEntries() {
        return f355716b;
    }

    static {
        LbsTraceInitializationStatus r100 = new LbsTraceInitializationStatus("SUCCESS", 0, 0);
        SUCCESS = r100;
        LbsTraceInitializationStatus r101 = new LbsTraceInitializationStatus("ALREADY_INITIALIZED", 1, 1);
        ALREADY_INITIALIZED = r101;
        LbsTraceInitializationStatus r102 = new LbsTraceInitializationStatus("INITIALIZING", 2, 2);
        INITIALIZING = r102;
        LbsTraceInitializationStatus r103 = new LbsTraceInitializationStatus("DISABLED", 3, 3);
        DISABLED = r103;
        LbsTraceInitializationStatus r104 = new LbsTraceInitializationStatus("FAILED", 4, 4);
        FAILED = r104;
        LbsTraceInitializationStatus[] r105 = {r100, r101, r102, r103, r104};
        f355715a = r105;
        f355716b = EnumEntriesKt.enumEntries(r105);
    }

    public static LbsTraceInitializationStatus[] values() {
        return (LbsTraceInitializationStatus[]) f355715a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LbsTraceInitializationStatus valueOf(String r100) {
        return (LbsTraceInitializationStatus) a.a(LbsTraceInitializationStatus.class, r100);
    }

    public LbsTraceInitializationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

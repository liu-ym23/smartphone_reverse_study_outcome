package com.larus.lbs.trace.api.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/lbs/trace/api/model/LbsTraceLevel;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "WARNING", "ERROR", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LbsTraceLevel extends Enum<LbsTraceLevel> {
    public static final LbsTraceLevel ERROR = null;
    public static final LbsTraceLevel INFO = null;
    public static final LbsTraceLevel WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LbsTraceLevel[] f355717a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f355718b = null;

    public static EnumEntries<LbsTraceLevel> getEntries() {
        return f355718b;
    }

    static {
        LbsTraceLevel r100 = new LbsTraceLevel("INFO", 0);
        INFO = r100;
        LbsTraceLevel r101 = new LbsTraceLevel("WARNING", 1);
        WARNING = r101;
        LbsTraceLevel r102 = new LbsTraceLevel("ERROR", 2);
        ERROR = r102;
        LbsTraceLevel[] r103 = {r100, r101, r102};
        f355717a = r103;
        f355718b = EnumEntriesKt.enumEntries(r103);
    }

    public static LbsTraceLevel[] values() {
        return (LbsTraceLevel[]) f355717a.clone();
    }

    public static LbsTraceLevel valueOf(String r100) {
        return (LbsTraceLevel) a.a(LbsTraceLevel.class, r100);
    }

    public LbsTraceLevel(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.lark.policy.model.trace;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/policy/model/trace/TraceResultType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NOT_APPLICABLE", "DENY", "PERMIT", "INDETERMINATE", "ERROR", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TraceResultType extends Enum<TraceResultType> {
    public static final TraceResultType DENY = null;
    public static final TraceResultType ERROR = null;
    public static final TraceResultType INDETERMINATE = null;
    public static final TraceResultType NOT_APPLICABLE = null;
    public static final TraceResultType PERMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TraceResultType[] f253868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253869b = null;
    private final String type;

    public static EnumEntries<TraceResultType> getEntries() {
        return f253869b;
    }

    static {
        TraceResultType r100 = new TraceResultType("NOT_APPLICABLE", 0, "not_applicable");
        NOT_APPLICABLE = r100;
        TraceResultType r101 = new TraceResultType("DENY", 1, "deny");
        DENY = r101;
        TraceResultType r102 = new TraceResultType("PERMIT", 2, "permit");
        PERMIT = r102;
        TraceResultType r103 = new TraceResultType("INDETERMINATE", 3, "indeterminate");
        INDETERMINATE = r103;
        TraceResultType r104 = new TraceResultType("ERROR", 4, "error");
        ERROR = r104;
        TraceResultType[] r105 = {r100, r101, r102, r103, r104};
        f253868a = r105;
        f253869b = EnumEntriesKt.enumEntries(r105);
    }

    public static TraceResultType[] values() {
        return (TraceResultType[]) f253868a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static TraceResultType valueOf(String r100) {
        return (TraceResultType) a.a(TraceResultType.class, r100);
    }

    public TraceResultType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

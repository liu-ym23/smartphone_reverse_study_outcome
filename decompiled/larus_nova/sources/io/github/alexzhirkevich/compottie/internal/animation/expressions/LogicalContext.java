package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/github/alexzhirkevich/compottie/internal/animation/expressions/LogicalContext;", "", "<init>", "(Ljava/lang/String;I)V", "And", "Or", "Compare", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LogicalContext extends Enum<LogicalContext> {
    public static final LogicalContext And = null;
    public static final LogicalContext Compare = null;
    public static final LogicalContext Or = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LogicalContext[] f490809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f490810b = null;

    public static EnumEntries<LogicalContext> getEntries() {
        return f490810b;
    }

    static {
        LogicalContext r100 = new LogicalContext("And", 0);
        And = r100;
        LogicalContext r101 = new LogicalContext("Or", 1);
        Or = r101;
        LogicalContext r102 = new LogicalContext("Compare", 2);
        Compare = r102;
        LogicalContext[] r103 = {r100, r101, r102};
        f490809a = r103;
        f490810b = EnumEntriesKt.enumEntries(r103);
    }

    public static LogicalContext[] values() {
        return (LogicalContext[]) f490809a.clone();
    }

    public static LogicalContext valueOf(String r100) {
        return (LogicalContext) r27.a.a(LogicalContext.class, r100);
    }

    public LogicalContext(String r100, int r101) {
        super(r100, r101);
    }
}

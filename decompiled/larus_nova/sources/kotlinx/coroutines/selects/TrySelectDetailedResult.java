package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum TrySelectDetailedResult extends Enum<TrySelectDetailedResult> {
    public static final TrySelectDetailedResult ALREADY_SELECTED = null;
    public static final TrySelectDetailedResult CANCELLED = null;
    public static final TrySelectDetailedResult REREGISTER = null;
    public static final TrySelectDetailedResult SUCCESSFUL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TrySelectDetailedResult[] f505105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505106b = null;

    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return f505106b;
    }

    public static TrySelectDetailedResult valueOf(String r100) {
        return (TrySelectDetailedResult) r27.a.a(TrySelectDetailedResult.class, r100);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) f505105a.clone();
    }

    static {
        TrySelectDetailedResult r100 = new TrySelectDetailedResult("SUCCESSFUL", 0);
        SUCCESSFUL = r100;
        TrySelectDetailedResult r101 = new TrySelectDetailedResult("REREGISTER", 1);
        REREGISTER = r101;
        TrySelectDetailedResult r102 = new TrySelectDetailedResult("CANCELLED", 2);
        CANCELLED = r102;
        TrySelectDetailedResult r103 = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        ALREADY_SELECTED = r103;
        TrySelectDetailedResult[] r104 = {r100, r101, r102, r103};
        f505105a = r104;
        f505106b = EnumEntriesKt.enumEntries(r104);
    }

    public TrySelectDetailedResult(String r100, int r101) {
        super(r100, r101);
    }
}

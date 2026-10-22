package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/format/WhenToOutput;", "", "<init>", "(Ljava/lang/String;I)V", "NEVER", "IF_NONZERO", "ALWAYS", "kotlinx-datetime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum WhenToOutput extends Enum<WhenToOutput> {
    public static final WhenToOutput ALWAYS = null;
    public static final WhenToOutput IF_NONZERO = null;
    public static final WhenToOutput NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WhenToOutput[] f505193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505194b = null;

    public static EnumEntries<WhenToOutput> getEntries() {
        return f505194b;
    }

    static {
        WhenToOutput r100 = new WhenToOutput("NEVER", 0);
        NEVER = r100;
        WhenToOutput r101 = new WhenToOutput("IF_NONZERO", 1);
        IF_NONZERO = r101;
        WhenToOutput r102 = new WhenToOutput("ALWAYS", 2);
        ALWAYS = r102;
        WhenToOutput[] r103 = {r100, r101, r102};
        f505193a = r103;
        f505194b = EnumEntriesKt.enumEntries(r103);
    }

    public static WhenToOutput[] values() {
        return (WhenToOutput[]) f505193a.clone();
    }

    public static WhenToOutput valueOf(String r100) {
        return (WhenToOutput) r27.a.a(WhenToOutput.class, r100);
    }

    public WhenToOutput(String r100, int r101) {
        super(r100, r101);
    }
}

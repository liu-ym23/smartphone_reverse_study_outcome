package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/rx2/Mode;", "", "s", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getS", "()Ljava/lang/String;", "toString", "FIRST", "FIRST_OR_DEFAULT", "LAST", "SINGLE", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 9, 0}, xi = 48)
final enum Mode extends Enum<Mode> {
    public static final Mode FIRST = null;
    public static final Mode FIRST_OR_DEFAULT = null;
    public static final Mode LAST = null;
    public static final Mode SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mode[] f505046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f505047b = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f505048s;

    public static EnumEntries<Mode> getEntries() {
        return f505047b;
    }

    public static Mode valueOf(String r100) {
        return (Mode) r27.a.a(Mode.class, r100);
    }

    public static Mode[] values() {
        return (Mode[]) f505046a.clone();
    }

    static {
        Mode r100 = new Mode("FIRST", 0, "awaitFirst");
        FIRST = r100;
        Mode r101 = new Mode("FIRST_OR_DEFAULT", 1, "awaitFirstOrDefault");
        FIRST_OR_DEFAULT = r101;
        Mode r102 = new Mode("LAST", 2, "awaitLast");
        LAST = r102;
        Mode r103 = new Mode("SINGLE", 3, "awaitSingle");
        SINGLE = r103;
        Mode[] r104 = {r100, r101, r102, r103};
        f505046a = r104;
        f505047b = EnumEntriesKt.enumEntries(r104);
    }

    public final String getS() {
        return this.f505048s;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f505048s;
    }

    public Mode(String r100, int r101, String r102) {
        super(r100, r101);
        this.f505048s = r102;
    }
}

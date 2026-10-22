package kotlin.text;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", BuyNowCloseMethod.MASK, "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum RegexOption extends Enum<RegexOption> implements FlagEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RegexOption[] $VALUES = null;
    public static final RegexOption CANON_EQ = null;
    public static final RegexOption COMMENTS = null;
    public static final RegexOption DOT_MATCHES_ALL = null;
    public static final RegexOption IGNORE_CASE = null;
    public static final RegexOption LITERAL = null;
    public static final RegexOption MULTILINE = null;
    public static final RegexOption UNIX_LINES = null;
    private final int mask;
    private final int value;

    private static final /* synthetic */ RegexOption[] $values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    public static RegexOption valueOf(String r100) {
        return (RegexOption) a.a(RegexOption.class, r100);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) $VALUES.clone();
    }

    static {
        int r100 = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, r100, 0, 2, null);
        int r110 = 0;
        int r111 = 2;
        DefaultConstructorMarker r112 = null;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, r110, r111, r112);
        int r101 = 0;
        int r102 = 2;
        DefaultConstructorMarker r103 = null;
        LITERAL = new RegexOption("LITERAL", r100, 16, r101, r102, r103);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, r110, r111, r112);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, r101, r102, r103);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, r110, r111, r112);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, r101, r102, r103);
        RegexOption[] r104 = $values();
        $VALUES = r104;
        $ENTRIES = EnumEntriesKt.enumEntries(r104);
    }

    @Override // kotlin.text.FlagEnum
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.FlagEnum
    public int getValue() {
        return this.value;
    }

    private RegexOption(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.mask = r103;
    }

    public /* synthetic */ RegexOption(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = r102;
    L5:
        this(r100, r101, r102, r103);
    }
}

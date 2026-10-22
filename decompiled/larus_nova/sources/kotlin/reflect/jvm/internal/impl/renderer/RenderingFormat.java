package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract enum RenderingFormat extends Enum<RenderingFormat> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RenderingFormat[] $VALUES = null;
    public static final RenderingFormat HTML = null;
    public static final RenderingFormat PLAIN = null;

    private static final /* synthetic */ RenderingFormat[] $values() {
        return new RenderingFormat[]{PLAIN, HTML};
    }

    public /* synthetic */ RenderingFormat(String r100, int r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public abstract String escape(String r100);

    static {
        final String r100 = "PLAIN";
        final int r101 = 0;
        PLAIN = new PLAIN(r100, r101);
        final String r102 = "HTML";
        final int r103 = 1;
        HTML = new HTML(r102, r103);
        RenderingFormat[] r104 = $values();
        $VALUES = r104;
        $ENTRIES = EnumEntriesKt.enumEntries(r104);
    }

    public static RenderingFormat[] values() {
        return (RenderingFormat[]) $VALUES.clone();
    }

    public static RenderingFormat valueOf(String r100) {
        return (RenderingFormat) a.a(RenderingFormat.class, r100);
    }

    private RenderingFormat(String r100, int r101) {
        super(r100, r101);
    }
}

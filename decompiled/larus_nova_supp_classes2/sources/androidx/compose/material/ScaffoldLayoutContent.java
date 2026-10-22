package androidx.compose.material;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/material/ScaffoldLayoutContent;", "", "<init>", "(Ljava/lang/String;I)V", "TopBar", "MainContent", "Snackbar", "Fab", "BottomBar", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum ScaffoldLayoutContent extends Enum<ScaffoldLayoutContent> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ScaffoldLayoutContent[] $VALUES = null;
    public static final ScaffoldLayoutContent BottomBar = null;
    public static final ScaffoldLayoutContent Fab = null;
    public static final ScaffoldLayoutContent MainContent = null;
    public static final ScaffoldLayoutContent Snackbar = null;
    public static final ScaffoldLayoutContent TopBar = null;

    private static final /* synthetic */ ScaffoldLayoutContent[] $values() {
        return new ScaffoldLayoutContent[]{TopBar, MainContent, Snackbar, Fab, BottomBar};
    }

    public static EnumEntries<ScaffoldLayoutContent> getEntries() {
        return $ENTRIES;
    }

    static {
        TopBar = new ScaffoldLayoutContent("TopBar", 0);
        MainContent = new ScaffoldLayoutContent("MainContent", 1);
        Snackbar = new ScaffoldLayoutContent("Snackbar", 2);
        Fab = new ScaffoldLayoutContent("Fab", 3);
        BottomBar = new ScaffoldLayoutContent("BottomBar", 4);
        ScaffoldLayoutContent[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ScaffoldLayoutContent[] values() {
        return (ScaffoldLayoutContent[]) $VALUES.clone();
    }

    public static ScaffoldLayoutContent valueOf(String r1) {
        return (ScaffoldLayoutContent) r27.a.a(ScaffoldLayoutContent.class, r1);
    }

    private ScaffoldLayoutContent(String r1, int r2) {
        super(r1, r2);
    }
}

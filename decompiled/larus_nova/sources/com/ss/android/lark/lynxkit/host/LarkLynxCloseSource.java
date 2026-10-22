package com.ss.android.lark.lynxkit.host;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxCloseSource;", "", "<init>", "(Ljava/lang/String;I)V", "BACK", "DISMISS", "CANCEL", "PROGRAMMATIC", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkLynxCloseSource extends Enum<LarkLynxCloseSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LarkLynxCloseSource[] $VALUES = null;
    public static final LarkLynxCloseSource BACK = null;
    public static final LarkLynxCloseSource CANCEL = null;
    public static final LarkLynxCloseSource DISMISS = null;
    public static final LarkLynxCloseSource PROGRAMMATIC = null;

    private static final /* synthetic */ LarkLynxCloseSource[] $values() {
        return new LarkLynxCloseSource[]{BACK, DISMISS, CANCEL, PROGRAMMATIC};
    }

    public static EnumEntries<LarkLynxCloseSource> getEntries() {
        return $ENTRIES;
    }

    static {
        BACK = new LarkLynxCloseSource("BACK", 0);
        DISMISS = new LarkLynxCloseSource("DISMISS", 1);
        CANCEL = new LarkLynxCloseSource("CANCEL", 2);
        PROGRAMMATIC = new LarkLynxCloseSource("PROGRAMMATIC", 3);
        LarkLynxCloseSource[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LarkLynxCloseSource[] values() {
        return (LarkLynxCloseSource[]) $VALUES.clone();
    }

    public static LarkLynxCloseSource valueOf(String r100) {
        return (LarkLynxCloseSource) r27.a.a(LarkLynxCloseSource.class, r100);
    }

    private LarkLynxCloseSource(String r100, int r101) {
        super(r100, r101);
    }
}

package com.ss.android.lark.lynxkit.host;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxHostType;", "", "<init>", "(Ljava/lang/String;I)V", "VIEW", "PAGE", "DIALOG", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkLynxHostType extends Enum<LarkLynxHostType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LarkLynxHostType[] $VALUES = null;
    public static final LarkLynxHostType DIALOG = null;
    public static final LarkLynxHostType PAGE = null;
    public static final LarkLynxHostType VIEW = null;

    private static final /* synthetic */ LarkLynxHostType[] $values() {
        return new LarkLynxHostType[]{VIEW, PAGE, DIALOG};
    }

    public static EnumEntries<LarkLynxHostType> getEntries() {
        return $ENTRIES;
    }

    static {
        VIEW = new LarkLynxHostType("VIEW", 0);
        PAGE = new LarkLynxHostType("PAGE", 1);
        DIALOG = new LarkLynxHostType("DIALOG", 2);
        LarkLynxHostType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LarkLynxHostType[] values() {
        return (LarkLynxHostType[]) $VALUES.clone();
    }

    public static LarkLynxHostType valueOf(String r100) {
        return (LarkLynxHostType) r27.a.a(LarkLynxHostType.class, r100);
    }

    private LarkLynxHostType(String r100, int r101) {
        super(r100, r101);
    }
}

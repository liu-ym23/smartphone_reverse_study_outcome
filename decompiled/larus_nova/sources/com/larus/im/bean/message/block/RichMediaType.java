package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/im/bean/message/block/RichMediaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SEARCH_IMAGE", "SEARCH_VIDEO", "RUYI", "APPLET", "UGC", "CREATION", "GENERIC_IMAGE", "GENERIC_VIDEO", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaType extends Enum<RichMediaType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RichMediaType[] $VALUES = null;
    public static final RichMediaType APPLET = null;
    public static final RichMediaType CREATION = null;
    public static final RichMediaType GENERIC_IMAGE = null;
    public static final RichMediaType GENERIC_VIDEO = null;
    public static final RichMediaType RUYI = null;
    public static final RichMediaType SEARCH_IMAGE = null;
    public static final RichMediaType SEARCH_VIDEO = null;
    public static final RichMediaType UGC = null;
    public static final RichMediaType UNKNOWN = null;
    private final int value;

    private static final /* synthetic */ RichMediaType[] $values() {
        return new RichMediaType[]{UNKNOWN, SEARCH_IMAGE, SEARCH_VIDEO, RUYI, APPLET, UGC, CREATION, GENERIC_IMAGE, GENERIC_VIDEO};
    }

    public static EnumEntries<RichMediaType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new RichMediaType("UNKNOWN", 0, 0);
        SEARCH_IMAGE = new RichMediaType("SEARCH_IMAGE", 1, 1);
        SEARCH_VIDEO = new RichMediaType("SEARCH_VIDEO", 2, 2);
        RUYI = new RichMediaType("RUYI", 3, 3);
        APPLET = new RichMediaType("APPLET", 4, 4);
        UGC = new RichMediaType("UGC", 5, 5);
        CREATION = new RichMediaType("CREATION", 6, 6);
        GENERIC_IMAGE = new RichMediaType("GENERIC_IMAGE", 7, 7);
        GENERIC_VIDEO = new RichMediaType("GENERIC_VIDEO", 8, 8);
        RichMediaType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static RichMediaType[] values() {
        return (RichMediaType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static RichMediaType valueOf(String r100) {
        return (RichMediaType) a.a(RichMediaType.class, r100);
    }

    private RichMediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

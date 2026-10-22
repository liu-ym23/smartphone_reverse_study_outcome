package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/ImageShowType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNSPECIFIED", "JOIN", "OVERLAY", "FREE_OVERLAY", "SIDE_SLIP", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageShowType extends Enum<ImageShowType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ImageShowType[] $VALUES = null;
    public static final ImageShowType FREE_OVERLAY = null;
    public static final ImageShowType JOIN = null;
    public static final ImageShowType OVERLAY = null;
    public static final ImageShowType SIDE_SLIP = null;
    public static final ImageShowType UNSPECIFIED = null;
    public final int value;

    private static final /* synthetic */ ImageShowType[] $values() {
        return new ImageShowType[]{UNSPECIFIED, JOIN, OVERLAY, FREE_OVERLAY, SIDE_SLIP};
    }

    public static EnumEntries<ImageShowType> getEntries() {
        return $ENTRIES;
    }

    static {
        UNSPECIFIED = new ImageShowType("UNSPECIFIED", 0, 0);
        JOIN = new ImageShowType("JOIN", 1, 1);
        OVERLAY = new ImageShowType("OVERLAY", 2, 2);
        FREE_OVERLAY = new ImageShowType("FREE_OVERLAY", 3, 3);
        SIDE_SLIP = new ImageShowType("SIDE_SLIP", 4, 4);
        ImageShowType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ImageShowType[] values() {
        return (ImageShowType[]) $VALUES.clone();
    }

    public static ImageShowType valueOf(String r100) {
        return (ImageShowType) r27.a.a(ImageShowType.class, r100);
    }

    private ImageShowType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

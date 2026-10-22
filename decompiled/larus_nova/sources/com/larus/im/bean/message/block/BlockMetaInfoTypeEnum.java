package com.larus.im.bean.message.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/larus/im/bean/message/block/BlockMetaInfoTypeEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "SUPERSCRIPT", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BlockMetaInfoTypeEnum extends Enum<BlockMetaInfoTypeEnum> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BlockMetaInfoTypeEnum[] $VALUES = null;
    public static final a Companion = null;

    @SerialName("2")
    public static final BlockMetaInfoTypeEnum SUPERSCRIPT = null;

    @SerialName("0")
    public static final BlockMetaInfoTypeEnum UNKNOWN = null;
    public final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ BlockMetaInfoTypeEnum[] $values() {
        return new BlockMetaInfoTypeEnum[]{UNKNOWN, SUPERSCRIPT};
    }

    public static EnumEntries<BlockMetaInfoTypeEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        UNKNOWN = new BlockMetaInfoTypeEnum("UNKNOWN", 0, 0);
        SUPERSCRIPT = new BlockMetaInfoTypeEnum("SUPERSCRIPT", 1, 2);
        BlockMetaInfoTypeEnum[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static BlockMetaInfoTypeEnum[] values() {
        return (BlockMetaInfoTypeEnum[]) $VALUES.clone();
    }

    public static BlockMetaInfoTypeEnum valueOf(String r100) {
        return (BlockMetaInfoTypeEnum) r27.a.a(BlockMetaInfoTypeEnum.class, r100);
    }

    private BlockMetaInfoTypeEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

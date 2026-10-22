package com.larus.livetutor.impl.home.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/livetutor/impl/home/viewmodel/MsgType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Text", "Picture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MsgType extends Enum<MsgType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MsgType[] $VALUES = null;
    public static final MsgType Picture = null;
    public static final MsgType Text = null;
    private final String value;

    private static final /* synthetic */ MsgType[] $values() {
        return new MsgType[]{Text, Picture};
    }

    public static EnumEntries<MsgType> getEntries() {
        return $ENTRIES;
    }

    static {
        Text = new MsgType("Text", 0, "text");
        Picture = new MsgType("Picture", 1, "pic");
        MsgType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static MsgType[] values() {
        return (MsgType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MsgType valueOf(String r100) {
        return (MsgType) r27.a.a(MsgType.class, r100);
    }

    private MsgType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

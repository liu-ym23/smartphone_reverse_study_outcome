package com.larus.bmhome.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/bmhome/ability/MessageMonitorItemType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE", "VIDEO", "LINK", "LYNX", "POTENTIAL_FORMULA", "POTENTIAL_TABLE", "POTENTIAL_BOLD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageMonitorItemType extends Enum<MessageMonitorItemType> {
    public static final MessageMonitorItemType IMAGE = null;
    public static final MessageMonitorItemType LINK = null;
    public static final MessageMonitorItemType LYNX = null;
    public static final MessageMonitorItemType POTENTIAL_BOLD = null;
    public static final MessageMonitorItemType POTENTIAL_FORMULA = null;
    public static final MessageMonitorItemType POTENTIAL_TABLE = null;
    public static final MessageMonitorItemType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageMonitorItemType[] f294928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294929b = null;
    private final String value;

    public static EnumEntries<MessageMonitorItemType> getEntries() {
        return f294929b;
    }

    static {
        MessageMonitorItemType r100 = new MessageMonitorItemType("IMAGE", 0, "image");
        IMAGE = r100;
        MessageMonitorItemType r101 = new MessageMonitorItemType("VIDEO", 1, "video");
        VIDEO = r101;
        MessageMonitorItemType r102 = new MessageMonitorItemType("LINK", 2, "link");
        LINK = r102;
        MessageMonitorItemType r103 = new MessageMonitorItemType("LYNX", 3, "lynx");
        LYNX = r103;
        MessageMonitorItemType r104 = new MessageMonitorItemType("POTENTIAL_FORMULA", 4, "potential_formula");
        POTENTIAL_FORMULA = r104;
        MessageMonitorItemType r105 = new MessageMonitorItemType("POTENTIAL_TABLE", 5, "potential_table");
        POTENTIAL_TABLE = r105;
        MessageMonitorItemType r110 = new MessageMonitorItemType("POTENTIAL_BOLD", 6, "potential_bold");
        POTENTIAL_BOLD = r110;
        MessageMonitorItemType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f294928a = r111;
        f294929b = EnumEntriesKt.enumEntries(r111);
    }

    public static MessageMonitorItemType[] values() {
        return (MessageMonitorItemType[]) f294928a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MessageMonitorItemType valueOf(String r100) {
        return (MessageMonitorItemType) a.a(MessageMonitorItemType.class, r100);
    }

    public MessageMonitorItemType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

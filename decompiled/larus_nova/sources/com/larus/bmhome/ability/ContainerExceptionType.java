package com.larus.bmhome.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/ability/ContainerExceptionType;", "", "value", "", "type", "Lcom/larus/bmhome/ability/MessageMonitorItemType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/larus/bmhome/ability/MessageMonitorItemType;)V", "getValue", "()Ljava/lang/String;", "getType", "()Lcom/larus/bmhome/ability/MessageMonitorItemType;", "FAILED_LYNX", "FAILED_IMAGE", "FAILED_VIDEO", "TIMEOUT_LYNX", "TIMEOUT_IMAGE", "TIMEOUT_VIDEO", "UNRECOGNIZED_LINK", "WRONG_LINK", "EXCEPTION_LINK", "FAILED_FORMULA", "UNRECOGNIZED_POTENTIAL_FORMULA", "UNRECOGNIZED_POTENTIAL_TABLE", "UNRECOGNIZED_POTENTIAL_BOLD", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContainerExceptionType extends Enum<ContainerExceptionType> {
    public static final ContainerExceptionType EXCEPTION_LINK = null;
    public static final ContainerExceptionType FAILED_FORMULA = null;
    public static final ContainerExceptionType FAILED_IMAGE = null;
    public static final ContainerExceptionType FAILED_LYNX = null;
    public static final ContainerExceptionType FAILED_VIDEO = null;
    public static final ContainerExceptionType TIMEOUT_IMAGE = null;
    public static final ContainerExceptionType TIMEOUT_LYNX = null;
    public static final ContainerExceptionType TIMEOUT_VIDEO = null;
    public static final ContainerExceptionType UNRECOGNIZED_LINK = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_BOLD = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_FORMULA = null;
    public static final ContainerExceptionType UNRECOGNIZED_POTENTIAL_TABLE = null;
    public static final ContainerExceptionType WRONG_LINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerExceptionType[] f294922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294923b = null;
    private final MessageMonitorItemType type;
    private final String value;

    public static EnumEntries<ContainerExceptionType> getEntries() {
        return f294923b;
    }

    static {
        MessageMonitorItemType r100 = MessageMonitorItemType.LYNX;
        ContainerExceptionType r101 = new ContainerExceptionType("FAILED_LYNX", 0, "failed_lynx", r100);
        FAILED_LYNX = r101;
        MessageMonitorItemType r102 = MessageMonitorItemType.IMAGE;
        ContainerExceptionType r103 = new ContainerExceptionType("FAILED_IMAGE", 1, "failed_image", r102);
        FAILED_IMAGE = r103;
        MessageMonitorItemType r104 = MessageMonitorItemType.VIDEO;
        ContainerExceptionType r105 = new ContainerExceptionType("FAILED_VIDEO", 2, "failed_video", r104);
        FAILED_VIDEO = r105;
        ContainerExceptionType r106 = new ContainerExceptionType("TIMEOUT_LYNX", 3, "timeout_lynx", r100);
        TIMEOUT_LYNX = r106;
        ContainerExceptionType r107 = new ContainerExceptionType("TIMEOUT_IMAGE", 4, "timeout_image", r102);
        TIMEOUT_IMAGE = r107;
        ContainerExceptionType r108 = new ContainerExceptionType("TIMEOUT_VIDEO", 5, "timeout_video", r104);
        TIMEOUT_VIDEO = r108;
        MessageMonitorItemType r110 = MessageMonitorItemType.LINK;
        ContainerExceptionType r109 = new ContainerExceptionType("UNRECOGNIZED_LINK", 6, "unrecognized_link", r110);
        UNRECOGNIZED_LINK = r109;
        ContainerExceptionType r111 = new ContainerExceptionType("WRONG_LINK", 7, "wrong_link", r110);
        WRONG_LINK = r111;
        ContainerExceptionType r112 = new ContainerExceptionType("EXCEPTION_LINK", 8, "exception_link", r110);
        EXCEPTION_LINK = r112;
        MessageMonitorItemType r113 = MessageMonitorItemType.POTENTIAL_FORMULA;
        ContainerExceptionType r114 = new ContainerExceptionType("FAILED_FORMULA", 9, "failed_formula", r113);
        FAILED_FORMULA = r114;
        ContainerExceptionType r115 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_FORMULA", 10, "unrecognized_potential_formula", r113);
        UNRECOGNIZED_POTENTIAL_FORMULA = r115;
        ContainerExceptionType r116 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_TABLE", 11, "unrecognized_potential_table", MessageMonitorItemType.POTENTIAL_TABLE);
        UNRECOGNIZED_POTENTIAL_TABLE = r116;
        ContainerExceptionType r117 = new ContainerExceptionType("UNRECOGNIZED_POTENTIAL_BOLD", 12, "unrecognized_potential_bold", MessageMonitorItemType.POTENTIAL_BOLD);
        UNRECOGNIZED_POTENTIAL_BOLD = r117;
        ContainerExceptionType[] r118 = {r101, r103, r105, r106, r107, r108, r109, r111, r112, r114, r115, r116, r117};
        f294922a = r118;
        f294923b = EnumEntriesKt.enumEntries(r118);
    }

    public static ContainerExceptionType[] values() {
        return (ContainerExceptionType[]) f294922a.clone();
    }

    public final MessageMonitorItemType getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public static ContainerExceptionType valueOf(String r100) {
        return (ContainerExceptionType) a.a(ContainerExceptionType.class, r100);
    }

    public ContainerExceptionType(String r100, int r101, String r102, MessageMonitorItemType r103) {
        super(r100, r101);
        this.value = r102;
        this.type = r103;
    }
}

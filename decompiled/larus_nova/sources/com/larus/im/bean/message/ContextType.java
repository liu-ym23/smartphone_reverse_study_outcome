package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/im/bean/message/ContextType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ContextType_Default", "ContextType_Doc", "ContextType_Excel", "ContextType_Ppt", "ContextType_Lark_Im", "ContextType_Lark_Minutes", "ContextType_AppBuilder", "ContextType_DeliveryAddress", "ContextType_Lark_Wiki", "ContextType_Gui", "ContextType_Resource", "ContextType_Base", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContextType extends Enum<ContextType> {
    public static final ContextType ContextType_AppBuilder = null;
    public static final ContextType ContextType_Base = null;
    public static final ContextType ContextType_Default = null;
    public static final ContextType ContextType_DeliveryAddress = null;
    public static final ContextType ContextType_Doc = null;
    public static final ContextType ContextType_Excel = null;
    public static final ContextType ContextType_Gui = null;
    public static final ContextType ContextType_Lark_Im = null;
    public static final ContextType ContextType_Lark_Minutes = null;
    public static final ContextType ContextType_Lark_Wiki = null;
    public static final ContextType ContextType_Ppt = null;
    public static final ContextType ContextType_Resource = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContextType[] f346608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346609b = null;
    private final int value;

    public static EnumEntries<ContextType> getEntries() {
        return f346609b;
    }

    static {
        ContextType r100 = new ContextType("ContextType_Default", 0, 0);
        ContextType_Default = r100;
        ContextType r101 = new ContextType("ContextType_Doc", 1, 1);
        ContextType_Doc = r101;
        ContextType r102 = new ContextType("ContextType_Excel", 2, 2);
        ContextType_Excel = r102;
        ContextType r103 = new ContextType("ContextType_Ppt", 3, 3);
        ContextType_Ppt = r103;
        ContextType r104 = new ContextType("ContextType_Lark_Im", 4, 4);
        ContextType_Lark_Im = r104;
        ContextType r105 = new ContextType("ContextType_Lark_Minutes", 5, 5);
        ContextType_Lark_Minutes = r105;
        ContextType r110 = new ContextType("ContextType_AppBuilder", 6, 6);
        ContextType_AppBuilder = r110;
        ContextType r111 = new ContextType("ContextType_DeliveryAddress", 7, 7);
        ContextType_DeliveryAddress = r111;
        ContextType r112 = new ContextType("ContextType_Lark_Wiki", 8, 8);
        ContextType_Lark_Wiki = r112;
        ContextType r113 = new ContextType("ContextType_Gui", 9, 9);
        ContextType_Gui = r113;
        ContextType r114 = new ContextType("ContextType_Resource", 10, 10);
        ContextType_Resource = r114;
        ContextType r115 = new ContextType("ContextType_Base", 11, 11);
        ContextType_Base = r115;
        ContextType[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f346608a = r106;
        f346609b = EnumEntriesKt.enumEntries(r106);
    }

    public static ContextType[] values() {
        return (ContextType[]) f346608a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContextType valueOf(String r100) {
        return (ContextType) r27.a.a(ContextType.class, r100);
    }

    public ContextType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.larus.flowsdk.common.experiment;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/flowsdk/common/experiment/FlowABValueType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "BOOL", "INT", "LONG", "DOUBLE", "STRING", "DICT", "ARRAY", "flow-client-experiment-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowABValueType extends Enum<FlowABValueType> {
    public static final FlowABValueType ARRAY = null;
    public static final FlowABValueType BOOL = null;
    public static final FlowABValueType DICT = null;
    public static final FlowABValueType DOUBLE = null;
    public static final FlowABValueType INT = null;
    public static final FlowABValueType LONG = null;
    public static final FlowABValueType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowABValueType[] f343449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f343450b = null;
    private final String wireValue;

    public static EnumEntries<FlowABValueType> getEntries() {
        return f343450b;
    }

    static {
        FlowABValueType r100 = new FlowABValueType("BOOL", 0, "bool");
        BOOL = r100;
        FlowABValueType r101 = new FlowABValueType("INT", 1, "int");
        INT = r101;
        FlowABValueType r102 = new FlowABValueType("LONG", 2, "long");
        LONG = r102;
        FlowABValueType r103 = new FlowABValueType("DOUBLE", 3, ItemStyle.ITEM_STYLE_DOUBLE);
        DOUBLE = r103;
        FlowABValueType r104 = new FlowABValueType("STRING", 4, "string");
        STRING = r104;
        FlowABValueType r105 = new FlowABValueType("DICT", 5, "dict");
        DICT = r105;
        FlowABValueType r110 = new FlowABValueType("ARRAY", 6, "array");
        ARRAY = r110;
        FlowABValueType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f343449a = r111;
        f343450b = EnumEntriesKt.enumEntries(r111);
    }

    public static FlowABValueType[] values() {
        return (FlowABValueType[]) f343449a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static FlowABValueType valueOf(String r100) {
        return (FlowABValueType) a.a(FlowABValueType.class, r100);
    }

    public FlowABValueType(String r100, int r101, String r102) {
        super(r100, r101);
        this.wireValue = r102;
    }
}

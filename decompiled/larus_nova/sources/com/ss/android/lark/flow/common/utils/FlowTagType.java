package com.ss.android.lark.flow.common.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/flow/common/utils/FlowTagType;", "", "order", "", "<init>", "(Ljava/lang/String;II)V", "getOrder", "()I", "RESIGNED", "FROZEN", "ON_LEAVE", "EXTERNAL", "PUBLIC", "DEPARTMENT", "BLOCK", "AGENT", "flow-common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowTagType extends Enum<FlowTagType> {
    public static final FlowTagType AGENT = null;
    public static final FlowTagType BLOCK = null;
    public static final FlowTagType DEPARTMENT = null;
    public static final FlowTagType EXTERNAL = null;
    public static final FlowTagType FROZEN = null;
    public static final FlowTagType ON_LEAVE = null;
    public static final FlowTagType PUBLIC = null;
    public static final FlowTagType RESIGNED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowTagType[] f423190a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f423191b = null;
    private final int order;

    public static EnumEntries<FlowTagType> getEntries() {
        return f423191b;
    }

    static {
        FlowTagType r100 = new FlowTagType("RESIGNED", 0, -100);
        RESIGNED = r100;
        FlowTagType r101 = new FlowTagType("FROZEN", 1, -1);
        FROZEN = r101;
        FlowTagType r102 = new FlowTagType("ON_LEAVE", 2, 0);
        ON_LEAVE = r102;
        FlowTagType r103 = new FlowTagType("EXTERNAL", 3, 4);
        EXTERNAL = r103;
        FlowTagType r104 = new FlowTagType("PUBLIC", 4, 5);
        PUBLIC = r104;
        FlowTagType r110 = new FlowTagType("DEPARTMENT", 5, 7);
        DEPARTMENT = r110;
        FlowTagType r111 = new FlowTagType("BLOCK", 6, 102);
        BLOCK = r111;
        FlowTagType r112 = new FlowTagType("AGENT", 7, 50);
        AGENT = r112;
        FlowTagType[] r113 = {r100, r101, r102, r103, r104, r110, r111, r112};
        f423190a = r113;
        f423191b = EnumEntriesKt.enumEntries(r113);
    }

    public static FlowTagType[] values() {
        return (FlowTagType[]) f423190a.clone();
    }

    public final int getOrder() {
        return this.order;
    }

    public static FlowTagType valueOf(String r100) {
        return (FlowTagType) r27.a.a(FlowTagType.class, r100);
    }

    public FlowTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.order = r102;
    }
}

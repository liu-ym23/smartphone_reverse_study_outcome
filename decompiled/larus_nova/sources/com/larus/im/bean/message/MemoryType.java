package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/message/MemoryType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DefaultMemory", "EmptyMemory", "ToolMemory", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryType extends Enum<MemoryType> {
    public static final MemoryType DefaultMemory = null;
    public static final MemoryType EmptyMemory = null;
    public static final MemoryType ToolMemory = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryType[] f346669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346670b = null;
    private final int value;

    public static EnumEntries<MemoryType> getEntries() {
        return f346670b;
    }

    static {
        MemoryType r100 = new MemoryType("DefaultMemory", 0, 0);
        DefaultMemory = r100;
        MemoryType r101 = new MemoryType("EmptyMemory", 1, 1);
        EmptyMemory = r101;
        MemoryType r102 = new MemoryType("ToolMemory", 2, 2);
        ToolMemory = r102;
        MemoryType[] r103 = {r100, r101, r102};
        f346669a = r103;
        f346670b = EnumEntriesKt.enumEntries(r103);
    }

    public static MemoryType[] values() {
        return (MemoryType[]) f346669a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MemoryType valueOf(String r100) {
        return (MemoryType) r27.a.a(MemoryType.class, r100);
    }

    public MemoryType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.relax.relaxreact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxreact/VNodeType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Snapshot", "Component", "relax-kmp-runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum VNodeType extends Enum<VNodeType> {
    public static final VNodeType Component = null;
    public static final VNodeType Snapshot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VNodeType[] f405458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f405459b = null;
    private final int value;

    public static EnumEntries<VNodeType> getEntries() {
        return f405459b;
    }

    public static VNodeType valueOf(String r100) {
        return (VNodeType) r27.a.a(VNodeType.class, r100);
    }

    public static VNodeType[] values() {
        return (VNodeType[]) f405458a.clone();
    }

    static {
        VNodeType r100 = new VNodeType("Snapshot", 0, 0);
        Snapshot = r100;
        VNodeType r101 = new VNodeType("Component", 1, 1);
        Component = r101;
        VNodeType[] r102 = {r100, r101};
        f405458a = r102;
        f405459b = EnumEntriesKt.enumEntries(r102);
    }

    public final int getValue() {
        return this.value;
    }

    public VNodeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

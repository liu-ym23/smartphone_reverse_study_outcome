package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/RightIconIdentifierType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SELECTED", "SWITCH", "ARROW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RightIconIdentifierType extends Enum<RightIconIdentifierType> {
    public static final RightIconIdentifierType ARROW = null;
    public static final RightIconIdentifierType SELECTED = null;
    public static final RightIconIdentifierType SWITCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RightIconIdentifierType[] f335137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335138b = null;
    private final String type;

    public static EnumEntries<RightIconIdentifierType> getEntries() {
        return f335138b;
    }

    static {
        RightIconIdentifierType r100 = new RightIconIdentifierType("SELECTED", 0, "selected");
        SELECTED = r100;
        RightIconIdentifierType r101 = new RightIconIdentifierType("SWITCH", 1, "switch");
        SWITCH = r101;
        RightIconIdentifierType r102 = new RightIconIdentifierType("ARROW", 2, "arrow");
        ARROW = r102;
        RightIconIdentifierType[] r103 = {r100, r101, r102};
        f335137a = r103;
        f335138b = EnumEntriesKt.enumEntries(r103);
    }

    public static RightIconIdentifierType[] values() {
        return (RightIconIdentifierType[]) f335137a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static RightIconIdentifierType valueOf(String r100) {
        return (RightIconIdentifierType) r27.a.a(RightIconIdentifierType.class, r100);
    }

    public RightIconIdentifierType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

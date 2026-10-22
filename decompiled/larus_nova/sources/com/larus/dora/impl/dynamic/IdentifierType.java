package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/IdentifierType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "StringType", "StartlingType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IdentifierType extends Enum<IdentifierType> {
    public static final a Companion = null;
    public static final IdentifierType StartlingType = null;
    public static final IdentifierType StringType = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IdentifierType[] f335132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335133b = null;
    private final String type;

    public static EnumEntries<IdentifierType> getEntries() {
        return f335133b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.dynamic.IdentifierType$a] */
    static {
        IdentifierType r100 = new IdentifierType("StringType", 0, "string_type");
        StringType = r100;
        IdentifierType r101 = new IdentifierType("StartlingType", 1, "starling_type");
        StartlingType = r101;
        IdentifierType[] r102 = {r100, r101};
        f335132a = r102;
        f335133b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static IdentifierType[] values() {
        return (IdentifierType[]) f335132a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static IdentifierType valueOf(String r100) {
        return (IdentifierType) r27.a.a(IdentifierType.class, r100);
    }

    public IdentifierType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

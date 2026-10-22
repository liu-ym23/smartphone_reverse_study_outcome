package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslIdentifierType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "STARLING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslIdentifierType extends Enum<DslIdentifierType> {

    @SerializedName("starling_type")
    public static final DslIdentifierType STARLING = null;

    @SerializedName("string_type")
    public static final DslIdentifierType STRING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DslIdentifierType[] f335165a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335166b = null;

    public static EnumEntries<DslIdentifierType> getEntries() {
        return f335166b;
    }

    static {
        DslIdentifierType r100 = new DslIdentifierType("STRING", 0);
        STRING = r100;
        DslIdentifierType r101 = new DslIdentifierType("STARLING", 1);
        STARLING = r101;
        DslIdentifierType[] r102 = {r100, r101};
        f335165a = r102;
        f335166b = EnumEntriesKt.enumEntries(r102);
    }

    public static DslIdentifierType[] values() {
        return (DslIdentifierType[]) f335165a.clone();
    }

    public static DslIdentifierType valueOf(String r100) {
        return (DslIdentifierType) r27.a.a(DslIdentifierType.class, r100);
    }

    public DslIdentifierType(String r100, int r101) {
        super(r100, r101);
    }
}

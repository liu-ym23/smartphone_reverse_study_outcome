package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslEnableCondition;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslEnableCondition extends Enum<DslEnableCondition> {

    @SerializedName("device_connected")
    public static final DslEnableCondition DEVICE_CONNECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DslEnableCondition[] f335163a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335164b = null;

    public static EnumEntries<DslEnableCondition> getEntries() {
        return f335164b;
    }

    static {
        DslEnableCondition r100 = new DslEnableCondition();
        DEVICE_CONNECTED = r100;
        DslEnableCondition[] r101 = {r100};
        f335163a = r101;
        f335164b = EnumEntriesKt.enumEntries(r101);
    }

    public DslEnableCondition() {
        super("DEVICE_CONNECTED", 0);
    }

    public static DslEnableCondition[] values() {
        return (DslEnableCondition[]) f335163a.clone();
    }

    public static DslEnableCondition valueOf(String r100) {
        return (DslEnableCondition) r27.a.a(DslEnableCondition.class, r100);
    }
}

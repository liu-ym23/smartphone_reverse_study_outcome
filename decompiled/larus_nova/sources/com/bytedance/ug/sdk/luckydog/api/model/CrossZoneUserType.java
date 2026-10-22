package com.bytedance.ug.sdk.luckydog.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ug/sdk/luckydog/api/model/CrossZoneUserType;", "", "", "value", "I", "getValue", "()I", "TYPE_ACTIVATION", "TYPE_ACQUAINTANCE", "TYPE_ALL", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
public final enum CrossZoneUserType extends Enum<CrossZoneUserType> {
    public static final CrossZoneUserType TYPE_ACQUAINTANCE = null;
    public static final CrossZoneUserType TYPE_ACTIVATION = null;
    public static final CrossZoneUserType TYPE_ALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CrossZoneUserType[] f271588a = null;
    private final int value;

    static {
        CrossZoneUserType r100 = new CrossZoneUserType("TYPE_ACTIVATION", 0, 1);
        TYPE_ACTIVATION = r100;
        CrossZoneUserType r101 = new CrossZoneUserType("TYPE_ACQUAINTANCE", 1, 2);
        TYPE_ACQUAINTANCE = r101;
        CrossZoneUserType r102 = new CrossZoneUserType("TYPE_ALL", 2, 0);
        TYPE_ALL = r102;
        f271588a = new CrossZoneUserType[]{r100, r101, r102};
    }

    public static CrossZoneUserType valueOf(String r100) {
        return (CrossZoneUserType) a.a(CrossZoneUserType.class, r100);
    }

    public static CrossZoneUserType[] values() {
        return (CrossZoneUserType[]) f271588a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CrossZoneUserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/UiType;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "DISABLED", "DEFAULT", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UiType extends Enum<UiType> {
    public static final UiType DEFAULT = null;
    public static final UiType DISABLED = null;
    public static final UiType HIDDEN = null;
    public static final /* synthetic */ UiType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UiType> getEntries() {
        return b;
    }

    static {
        UiType r0 = new UiType("HIDDEN", 0);
        HIDDEN = r0;
        UiType r1 = new UiType("DISABLED", 1);
        DISABLED = r1;
        UiType r3 = new UiType("DEFAULT", 2);
        DEFAULT = r3;
        UiType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static UiType[] values() {
        return (UiType[]) a.clone();
    }

    public static UiType valueOf(String r1) {
        return (UiType) a.a(UiType.class, r1);
    }

    public UiType(String r1, int r2) {
        super(r1, r2);
    }
}

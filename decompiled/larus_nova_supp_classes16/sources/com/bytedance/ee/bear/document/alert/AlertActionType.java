package com.bytedance.ee.bear.document.alert;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/alert/AlertActionType;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW", "DISMISS", "UPDATE", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AlertActionType extends Enum<AlertActionType> {
    public static final AlertActionType DISMISS = null;
    public static final AlertActionType SHOW = null;
    public static final AlertActionType UPDATE = null;
    public static final /* synthetic */ AlertActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AlertActionType> getEntries() {
        return b;
    }

    static {
        AlertActionType r0 = new AlertActionType("SHOW", 0);
        SHOW = r0;
        AlertActionType r1 = new AlertActionType("DISMISS", 1);
        DISMISS = r1;
        AlertActionType r3 = new AlertActionType("UPDATE", 2);
        UPDATE = r3;
        AlertActionType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AlertActionType[] values() {
        return (AlertActionType[]) a.clone();
    }

    public static AlertActionType valueOf(String r1) {
        return (AlertActionType) r27.a.a(AlertActionType.class, r1);
    }

    public AlertActionType(String r1, int r2) {
        super(r1, r2);
    }
}

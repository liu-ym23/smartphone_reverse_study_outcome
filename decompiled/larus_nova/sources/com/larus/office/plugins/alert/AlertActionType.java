package com.larus.office.plugins.alert;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/plugins/alert/AlertActionType;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW", "DISMISS", "UPDATE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AlertActionType extends Enum<AlertActionType> {
    public static final AlertActionType DISMISS = null;
    public static final AlertActionType SHOW = null;
    public static final AlertActionType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlertActionType[] f362324a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f362325b = null;

    public static EnumEntries<AlertActionType> getEntries() {
        return f362325b;
    }

    static {
        AlertActionType r100 = new AlertActionType("SHOW", 0);
        SHOW = r100;
        AlertActionType r101 = new AlertActionType("DISMISS", 1);
        DISMISS = r101;
        AlertActionType r102 = new AlertActionType("UPDATE", 2);
        UPDATE = r102;
        AlertActionType[] r103 = {r100, r101, r102};
        f362324a = r103;
        f362325b = EnumEntriesKt.enumEntries(r103);
    }

    public static AlertActionType[] values() {
        return (AlertActionType[]) f362324a.clone();
    }

    public static AlertActionType valueOf(String r100) {
        return (AlertActionType) r27.a.a(AlertActionType.class, r100);
    }

    public AlertActionType(String r100, int r101) {
        super(r100, r101);
    }
}

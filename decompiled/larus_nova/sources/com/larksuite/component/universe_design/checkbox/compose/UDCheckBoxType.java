package com.larksuite.component.universe_design.checkbox.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/checkbox/compose/UDCheckBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CheckBox", "Radio", "CheckMark", "universe-ui-checkbox_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDCheckBoxType extends Enum<UDCheckBoxType> {
    public static final UDCheckBoxType CheckBox = null;
    public static final UDCheckBoxType CheckMark = null;
    public static final UDCheckBoxType Radio = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDCheckBoxType[] f284660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284661b = null;

    public static EnumEntries<UDCheckBoxType> getEntries() {
        return f284661b;
    }

    static {
        UDCheckBoxType r100 = new UDCheckBoxType("CheckBox", 0);
        CheckBox = r100;
        UDCheckBoxType r101 = new UDCheckBoxType("Radio", 1);
        Radio = r101;
        UDCheckBoxType r102 = new UDCheckBoxType("CheckMark", 2);
        CheckMark = r102;
        UDCheckBoxType[] r103 = {r100, r101, r102};
        f284660a = r103;
        f284661b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDCheckBoxType[] values() {
        return (UDCheckBoxType[]) f284660a.clone();
    }

    public static UDCheckBoxType valueOf(String r100) {
        return (UDCheckBoxType) r27.a.a(UDCheckBoxType.class, r100);
    }

    public UDCheckBoxType(String r100, int r101) {
        super(r100, r101);
    }
}

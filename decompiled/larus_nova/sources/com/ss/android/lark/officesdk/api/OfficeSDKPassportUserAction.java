package com.ss.android.lark.officesdk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/api/OfficeSDKPassportUserAction;", "", "<init>", "(Ljava/lang/String;I)V", "LOGOUT", "SWITCH", "DOUBAO_CHANGE_BINDING", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSDKPassportUserAction extends Enum<OfficeSDKPassportUserAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ OfficeSDKPassportUserAction[] $VALUES = null;
    public static final OfficeSDKPassportUserAction DOUBAO_CHANGE_BINDING = null;
    public static final OfficeSDKPassportUserAction LOGOUT = null;
    public static final OfficeSDKPassportUserAction SWITCH = null;

    private static final /* synthetic */ OfficeSDKPassportUserAction[] $values() {
        return new OfficeSDKPassportUserAction[]{LOGOUT, SWITCH, DOUBAO_CHANGE_BINDING};
    }

    public static EnumEntries<OfficeSDKPassportUserAction> getEntries() {
        return $ENTRIES;
    }

    static {
        LOGOUT = new OfficeSDKPassportUserAction("LOGOUT", 0);
        SWITCH = new OfficeSDKPassportUserAction("SWITCH", 1);
        DOUBAO_CHANGE_BINDING = new OfficeSDKPassportUserAction("DOUBAO_CHANGE_BINDING", 2);
        OfficeSDKPassportUserAction[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static OfficeSDKPassportUserAction[] values() {
        return (OfficeSDKPassportUserAction[]) $VALUES.clone();
    }

    public static OfficeSDKPassportUserAction valueOf(String r100) {
        return (OfficeSDKPassportUserAction) a.a(OfficeSDKPassportUserAction.class, r100);
    }

    private OfficeSDKPassportUserAction(String r100, int r101) {
        super(r100, r101);
    }
}

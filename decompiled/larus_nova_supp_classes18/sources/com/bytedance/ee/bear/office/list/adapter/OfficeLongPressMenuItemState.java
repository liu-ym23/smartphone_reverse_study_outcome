package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuItemState;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "LOADING_BLOCKED", "DISABLED", "HIDDEN", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressMenuItemState extends Enum<OfficeLongPressMenuItemState> {
    public static final OfficeLongPressMenuItemState DISABLED = null;
    public static final OfficeLongPressMenuItemState HIDDEN = null;
    public static final OfficeLongPressMenuItemState LOADING_BLOCKED = null;
    public static final OfficeLongPressMenuItemState VISIBLE = null;
    public static final /* synthetic */ OfficeLongPressMenuItemState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeLongPressMenuItemState> getEntries() {
        return b;
    }

    static {
        OfficeLongPressMenuItemState r0 = new OfficeLongPressMenuItemState("VISIBLE", 0);
        VISIBLE = r0;
        OfficeLongPressMenuItemState r1 = new OfficeLongPressMenuItemState("LOADING_BLOCKED", 1);
        LOADING_BLOCKED = r1;
        OfficeLongPressMenuItemState r3 = new OfficeLongPressMenuItemState("DISABLED", 2);
        DISABLED = r3;
        OfficeLongPressMenuItemState r5 = new OfficeLongPressMenuItemState("HIDDEN", 3);
        HIDDEN = r5;
        OfficeLongPressMenuItemState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeLongPressMenuItemState[] values() {
        return (OfficeLongPressMenuItemState[]) a.clone();
    }

    public static OfficeLongPressMenuItemState valueOf(String r1) {
        return (OfficeLongPressMenuItemState) r27.a.a(OfficeLongPressMenuItemState.class, r1);
    }

    public OfficeLongPressMenuItemState(String r1, int r2) {
        super(r1, r2);
    }
}

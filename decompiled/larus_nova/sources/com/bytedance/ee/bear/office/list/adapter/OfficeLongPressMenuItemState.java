package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuItemState;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "LOADING_BLOCKED", "DISABLED", "HIDDEN", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressMenuItemState extends Enum<OfficeLongPressMenuItemState> {
    public static final OfficeLongPressMenuItemState DISABLED = null;
    public static final OfficeLongPressMenuItemState HIDDEN = null;
    public static final OfficeLongPressMenuItemState LOADING_BLOCKED = null;
    public static final OfficeLongPressMenuItemState VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeLongPressMenuItemState[] f235691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235692b = null;

    public static EnumEntries<OfficeLongPressMenuItemState> getEntries() {
        return f235692b;
    }

    static {
        OfficeLongPressMenuItemState r100 = new OfficeLongPressMenuItemState("VISIBLE", 0);
        VISIBLE = r100;
        OfficeLongPressMenuItemState r101 = new OfficeLongPressMenuItemState("LOADING_BLOCKED", 1);
        LOADING_BLOCKED = r101;
        OfficeLongPressMenuItemState r102 = new OfficeLongPressMenuItemState("DISABLED", 2);
        DISABLED = r102;
        OfficeLongPressMenuItemState r103 = new OfficeLongPressMenuItemState("HIDDEN", 3);
        HIDDEN = r103;
        OfficeLongPressMenuItemState[] r104 = {r100, r101, r102, r103};
        f235691a = r104;
        f235692b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeLongPressMenuItemState[] values() {
        return (OfficeLongPressMenuItemState[]) f235691a.clone();
    }

    public static OfficeLongPressMenuItemState valueOf(String r100) {
        return (OfficeLongPressMenuItemState) r27.a.a(OfficeLongPressMenuItemState.class, r100);
    }

    public OfficeLongPressMenuItemState(String r100, int r101) {
        super(r100, r101);
    }
}

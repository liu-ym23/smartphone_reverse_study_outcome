package com.larus.bmhome.actionbar.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ActionBarItemLocation;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY_BAR", "DETAIL_PANEL", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarItemLocation extends Enum<ActionBarItemLocation> {
    public static final ActionBarItemLocation DETAIL_PANEL = null;
    public static final ActionBarItemLocation PRIMARY_BAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarItemLocation[] f294932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294933b = null;

    public static EnumEntries<ActionBarItemLocation> getEntries() {
        return f294933b;
    }

    static {
        ActionBarItemLocation r100 = new ActionBarItemLocation("PRIMARY_BAR", 0);
        PRIMARY_BAR = r100;
        ActionBarItemLocation r101 = new ActionBarItemLocation("DETAIL_PANEL", 1);
        DETAIL_PANEL = r101;
        ActionBarItemLocation[] r102 = {r100, r101};
        f294932a = r102;
        f294933b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActionBarItemLocation[] values() {
        return (ActionBarItemLocation[]) f294932a.clone();
    }

    public static ActionBarItemLocation valueOf(String r100) {
        return (ActionBarItemLocation) r27.a.a(ActionBarItemLocation.class, r100);
    }

    public ActionBarItemLocation(String r100, int r101) {
        super(r100, r101);
    }
}

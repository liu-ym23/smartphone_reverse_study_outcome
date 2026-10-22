package com.larus.bmhome.view.actionbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/view/actionbar/ActionBarUpdateType;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_WITH_BOT", "UPDATE_WITH_ORDER", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarUpdateType extends Enum<ActionBarUpdateType> {
    public static final ActionBarUpdateType UPDATE_WITH_BOT = null;
    public static final ActionBarUpdateType UPDATE_WITH_ORDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarUpdateType[] f315613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315614b = null;

    public static EnumEntries<ActionBarUpdateType> getEntries() {
        return f315614b;
    }

    static {
        ActionBarUpdateType r100 = new ActionBarUpdateType("UPDATE_WITH_BOT", 0);
        UPDATE_WITH_BOT = r100;
        ActionBarUpdateType r101 = new ActionBarUpdateType("UPDATE_WITH_ORDER", 1);
        UPDATE_WITH_ORDER = r101;
        ActionBarUpdateType[] r102 = {r100, r101};
        f315613a = r102;
        f315614b = EnumEntriesKt.enumEntries(r102);
    }

    public static ActionBarUpdateType[] values() {
        return (ActionBarUpdateType[]) f315613a.clone();
    }

    public static ActionBarUpdateType valueOf(String r100) {
        return (ActionBarUpdateType) a.a(ActionBarUpdateType.class, r100);
    }

    public ActionBarUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}

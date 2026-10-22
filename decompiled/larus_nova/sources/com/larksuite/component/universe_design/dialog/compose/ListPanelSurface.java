package com.larksuite.component.universe_design.dialog.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/compose/ListPanelSurface;", "", "<init>", "(Ljava/lang/String;I)V", "ActionPanel", "ActionSheet", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ListPanelSurface extends Enum<ListPanelSurface> {
    public static final ListPanelSurface ActionPanel = null;
    public static final ListPanelSurface ActionSheet = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListPanelSurface[] f284891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284892b = null;

    public static EnumEntries<ListPanelSurface> getEntries() {
        return f284892b;
    }

    static {
        ListPanelSurface r100 = new ListPanelSurface("ActionPanel", 0);
        ActionPanel = r100;
        ListPanelSurface r101 = new ListPanelSurface("ActionSheet", 1);
        ActionSheet = r101;
        ListPanelSurface[] r102 = {r100, r101};
        f284891a = r102;
        f284892b = EnumEntriesKt.enumEntries(r102);
    }

    public static ListPanelSurface[] values() {
        return (ListPanelSurface[]) f284891a.clone();
    }

    public static ListPanelSurface valueOf(String r100) {
        return (ListPanelSurface) r27.a.a(ListPanelSurface.class, r100);
    }

    public ListPanelSurface(String r100, int r101) {
        super(r100, r101);
    }
}

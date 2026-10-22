package com.larksuite.common_selection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/common_selection/SelectionInitiationMode;", "", "<init>", "(Ljava/lang/String;I)V", "SELECT_ON_CONTENT", "SELECT_ANYWHERE", "common-selection_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectionInitiationMode extends Enum<SelectionInitiationMode> {
    public static final SelectionInitiationMode SELECT_ANYWHERE = null;
    public static final SelectionInitiationMode SELECT_ON_CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectionInitiationMode[] f282858a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282859b = null;

    public static EnumEntries<SelectionInitiationMode> getEntries() {
        return f282859b;
    }

    static {
        SelectionInitiationMode r100 = new SelectionInitiationMode("SELECT_ON_CONTENT", 0);
        SELECT_ON_CONTENT = r100;
        SelectionInitiationMode r101 = new SelectionInitiationMode("SELECT_ANYWHERE", 1);
        SELECT_ANYWHERE = r101;
        SelectionInitiationMode[] r102 = {r100, r101};
        f282858a = r102;
        f282859b = EnumEntriesKt.enumEntries(r102);
    }

    public static SelectionInitiationMode[] values() {
        return (SelectionInitiationMode[]) f282858a.clone();
    }

    public static SelectionInitiationMode valueOf(String r100) {
        return (SelectionInitiationMode) r27.a.a(SelectionInitiationMode.class, r100);
    }

    public SelectionInitiationMode(String r100, int r101) {
        super(r100, r101);
    }
}

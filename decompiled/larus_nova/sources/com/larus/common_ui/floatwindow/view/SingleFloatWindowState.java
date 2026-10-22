package com.larus.common_ui.floatwindow.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/floatwindow/view/SingleFloatWindowState;", "", "<init>", "(Ljava/lang/String;I)V", "MINIMIZE", "MAXIMIZE", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SingleFloatWindowState extends Enum<SingleFloatWindowState> {
    public static final SingleFloatWindowState MAXIMIZE = null;
    public static final SingleFloatWindowState MINIMIZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleFloatWindowState[] f327479a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327480b = null;

    public static EnumEntries<SingleFloatWindowState> getEntries() {
        return f327480b;
    }

    static {
        SingleFloatWindowState r100 = new SingleFloatWindowState("MINIMIZE", 0);
        MINIMIZE = r100;
        SingleFloatWindowState r101 = new SingleFloatWindowState("MAXIMIZE", 1);
        MAXIMIZE = r101;
        SingleFloatWindowState[] r102 = {r100, r101};
        f327479a = r102;
        f327480b = EnumEntriesKt.enumEntries(r102);
    }

    public static SingleFloatWindowState[] values() {
        return (SingleFloatWindowState[]) f327479a.clone();
    }

    public static SingleFloatWindowState valueOf(String r100) {
        return (SingleFloatWindowState) r27.a.a(SingleFloatWindowState.class, r100);
    }

    public SingleFloatWindowState(String r100, int r101) {
        super(r100, r101);
    }
}

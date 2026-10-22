package com.larus.canvas.feature.component.instruction.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/component/instruction/model/TabUIState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_LOADING", "STATE_SHOW", "STATE_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TabUIState extends Enum<TabUIState> {
    public static final TabUIState STATE_ERROR = null;
    public static final TabUIState STATE_LOADING = null;
    public static final TabUIState STATE_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabUIState[] f323164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323165b = null;

    public static EnumEntries<TabUIState> getEntries() {
        return f323165b;
    }

    static {
        TabUIState r100 = new TabUIState("STATE_LOADING", 0);
        STATE_LOADING = r100;
        TabUIState r101 = new TabUIState("STATE_SHOW", 1);
        STATE_SHOW = r101;
        TabUIState r102 = new TabUIState("STATE_ERROR", 2);
        STATE_ERROR = r102;
        TabUIState[] r103 = {r100, r101, r102};
        f323164a = r103;
        f323165b = EnumEntriesKt.enumEntries(r103);
    }

    public static TabUIState[] values() {
        return (TabUIState[]) f323164a.clone();
    }

    public static TabUIState valueOf(String r100) {
        return (TabUIState) r27.a.a(TabUIState.class, r100);
    }

    public TabUIState(String r100, int r101) {
        super(r100, r101);
    }
}

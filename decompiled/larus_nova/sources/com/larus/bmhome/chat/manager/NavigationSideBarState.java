package com.larus.bmhome.chat.manager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/manager/NavigationSideBarState;", "", "state", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getState", "()Ljava/lang/String;", "YES", "NO", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationSideBarState extends Enum<NavigationSideBarState> {
    public static final NavigationSideBarState NO = null;
    public static final NavigationSideBarState YES = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigationSideBarState[] f306673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306674b = null;
    private final String state;

    public static EnumEntries<NavigationSideBarState> getEntries() {
        return f306674b;
    }

    static {
        NavigationSideBarState r100 = new NavigationSideBarState("YES", 0, "1");
        YES = r100;
        NavigationSideBarState r101 = new NavigationSideBarState("NO", 1, "0");
        NO = r101;
        NavigationSideBarState[] r102 = {r100, r101};
        f306673a = r102;
        f306674b = EnumEntriesKt.enumEntries(r102);
    }

    public static NavigationSideBarState[] values() {
        return (NavigationSideBarState[]) f306673a.clone();
    }

    public final String getState() {
        return this.state;
    }

    public static NavigationSideBarState valueOf(String r100) {
        return (NavigationSideBarState) r27.a.a(NavigationSideBarState.class, r100);
    }

    public NavigationSideBarState(String r100, int r101, String r102) {
        super(r100, r101);
        this.state = r102;
    }
}

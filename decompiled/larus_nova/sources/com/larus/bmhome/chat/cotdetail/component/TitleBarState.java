package com.larus.bmhome.chat.cotdetail.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/cotdetail/component/TitleBarState;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", "STREAMING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TitleBarState extends Enum<TitleBarState> {
    public static final TitleBarState SHARE = null;
    public static final TitleBarState STREAMING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TitleBarState[] f301950a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f301951b = null;

    public static EnumEntries<TitleBarState> getEntries() {
        return f301951b;
    }

    static {
        TitleBarState r100 = new TitleBarState("SHARE", 0);
        SHARE = r100;
        TitleBarState r101 = new TitleBarState("STREAMING", 1);
        STREAMING = r101;
        TitleBarState[] r102 = {r100, r101};
        f301950a = r102;
        f301951b = EnumEntriesKt.enumEntries(r102);
    }

    public static TitleBarState[] values() {
        return (TitleBarState[]) f301950a.clone();
    }

    public static TitleBarState valueOf(String r100) {
        return (TitleBarState) r27.a.a(TitleBarState.class, r100);
    }

    public TitleBarState(String r100, int r101) {
        super(r100, r101);
    }
}

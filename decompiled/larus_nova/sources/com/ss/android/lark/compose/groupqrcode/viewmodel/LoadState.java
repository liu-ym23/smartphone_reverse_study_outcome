package com.ss.android.lark.compose.groupqrcode.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/compose/groupqrcode/viewmodel/LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "SUCCESS", "ERROR", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState ERROR = null;
    public static final LoadState IDLE = null;
    public static final LoadState LOADING = null;
    public static final LoadState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f417736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417737b = null;

    public static EnumEntries<LoadState> getEntries() {
        return f417737b;
    }

    static {
        LoadState r100 = new LoadState("IDLE", 0);
        IDLE = r100;
        LoadState r101 = new LoadState("LOADING", 1);
        LOADING = r101;
        LoadState r102 = new LoadState("SUCCESS", 2);
        SUCCESS = r102;
        LoadState r103 = new LoadState("ERROR", 3);
        ERROR = r103;
        LoadState[] r104 = {r100, r101, r102, r103};
        f417736a = r104;
        f417737b = EnumEntriesKt.enumEntries(r104);
    }

    public static LoadState[] values() {
        return (LoadState[]) f417736a.clone();
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) r27.a.a(LoadState.class, r100);
    }

    public LoadState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.livetutor.impl.home.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/livetutor/impl/home/data/LoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "Loading", "Success", "Error", "Empty", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadingState extends Enum<LoadingState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LoadingState[] $VALUES = null;
    public static final LoadingState Empty = null;
    public static final LoadingState Error = null;
    public static final LoadingState Init = null;
    public static final LoadingState Loading = null;
    public static final LoadingState Success = null;

    private static final /* synthetic */ LoadingState[] $values() {
        return new LoadingState[]{Init, Loading, Success, Error, Empty};
    }

    public static EnumEntries<LoadingState> getEntries() {
        return $ENTRIES;
    }

    static {
        Init = new LoadingState("Init", 0);
        Loading = new LoadingState("Loading", 1);
        Success = new LoadingState("Success", 2);
        Error = new LoadingState("Error", 3);
        Empty = new LoadingState("Empty", 4);
        LoadingState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LoadingState[] values() {
        return (LoadingState[]) $VALUES.clone();
    }

    public static LoadingState valueOf(String r100) {
        return (LoadingState) a.a(LoadingState.class, r100);
    }

    private LoadingState(String r100, int r101) {
        super(r100, r101);
    }
}

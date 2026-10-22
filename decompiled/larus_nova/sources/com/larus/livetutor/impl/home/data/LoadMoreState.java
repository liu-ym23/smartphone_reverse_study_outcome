package com.larus.livetutor.impl.home.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/livetutor/impl/home/data/LoadMoreState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Success", "Error", "NoMore", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadMoreState extends Enum<LoadMoreState> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LoadMoreState[] $VALUES = null;
    public static final LoadMoreState Error = null;
    public static final LoadMoreState Loading = null;
    public static final LoadMoreState NoMore = null;
    public static final LoadMoreState Success = null;

    private static final /* synthetic */ LoadMoreState[] $values() {
        return new LoadMoreState[]{Loading, Success, Error, NoMore};
    }

    public static EnumEntries<LoadMoreState> getEntries() {
        return $ENTRIES;
    }

    static {
        Loading = new LoadMoreState("Loading", 0);
        Success = new LoadMoreState("Success", 1);
        Error = new LoadMoreState("Error", 2);
        NoMore = new LoadMoreState("NoMore", 3);
        LoadMoreState[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static LoadMoreState[] values() {
        return (LoadMoreState[]) $VALUES.clone();
    }

    public static LoadMoreState valueOf(String r100) {
        return (LoadMoreState) a.a(LoadMoreState.class, r100);
    }

    private LoadMoreState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/paging/DiffingChangePayload;", "", "ITEM_TO_PLACEHOLDER", "PLACEHOLDER_TO_ITEM", "PLACEHOLDER_POSITION_CHANGE", "paging-common_release"}, k = 1, mv = {1, 7, 1})
public final enum DiffingChangePayload extends Enum<DiffingChangePayload> {
    public static final DiffingChangePayload ITEM_TO_PLACEHOLDER = null;
    public static final DiffingChangePayload PLACEHOLDER_POSITION_CHANGE = null;
    public static final DiffingChangePayload PLACEHOLDER_TO_ITEM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiffingChangePayload[] f363648a = null;

    public static DiffingChangePayload valueOf(String r100) {
        return (DiffingChangePayload) r27.a.a(DiffingChangePayload.class, r100);
    }

    public static DiffingChangePayload[] values() {
        return (DiffingChangePayload[]) f363648a.clone();
    }

    static {
        DiffingChangePayload r100 = new DiffingChangePayload("ITEM_TO_PLACEHOLDER", 0);
        ITEM_TO_PLACEHOLDER = r100;
        DiffingChangePayload r101 = new DiffingChangePayload("PLACEHOLDER_TO_ITEM", 1);
        PLACEHOLDER_TO_ITEM = r101;
        DiffingChangePayload r102 = new DiffingChangePayload("PLACEHOLDER_POSITION_CHANGE", 2);
        PLACEHOLDER_POSITION_CHANGE = r102;
        f363648a = new DiffingChangePayload[]{r100, r101, r102};
    }

    public DiffingChangePayload(String r100, int r101) {
        super(r100, r101);
    }
}

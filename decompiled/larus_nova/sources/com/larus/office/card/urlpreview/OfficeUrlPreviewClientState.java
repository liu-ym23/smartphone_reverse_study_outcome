package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewClientState;", "", "<init>", "(Ljava/lang/String;I)V", "GENERATING", "LOADING", "PREVIEW_FAILED", "DELETED", "STATIC_CARD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewClientState extends Enum<OfficeUrlPreviewClientState> {
    public static final OfficeUrlPreviewClientState DELETED = null;
    public static final OfficeUrlPreviewClientState GENERATING = null;
    public static final OfficeUrlPreviewClientState LOADING = null;
    public static final OfficeUrlPreviewClientState PREVIEW_FAILED = null;
    public static final OfficeUrlPreviewClientState STATIC_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewClientState[] f361718a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f361719b = null;

    public static EnumEntries<OfficeUrlPreviewClientState> getEntries() {
        return f361719b;
    }

    static {
        OfficeUrlPreviewClientState r100 = new OfficeUrlPreviewClientState("GENERATING", 0);
        GENERATING = r100;
        OfficeUrlPreviewClientState r101 = new OfficeUrlPreviewClientState("LOADING", 1);
        LOADING = r101;
        OfficeUrlPreviewClientState r102 = new OfficeUrlPreviewClientState("PREVIEW_FAILED", 2);
        PREVIEW_FAILED = r102;
        OfficeUrlPreviewClientState r103 = new OfficeUrlPreviewClientState("DELETED", 3);
        DELETED = r103;
        OfficeUrlPreviewClientState r104 = new OfficeUrlPreviewClientState("STATIC_CARD", 4);
        STATIC_CARD = r104;
        OfficeUrlPreviewClientState[] r105 = {r100, r101, r102, r103, r104};
        f361718a = r105;
        f361719b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeUrlPreviewClientState[] values() {
        return (OfficeUrlPreviewClientState[]) f361718a.clone();
    }

    public static OfficeUrlPreviewClientState valueOf(String r100) {
        return (OfficeUrlPreviewClientState) r27.a.a(OfficeUrlPreviewClientState.class, r100);
    }

    public OfficeUrlPreviewClientState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewOpenSource;", "", "<init>", "(Ljava/lang/String;I)V", "COVER", "EXPAND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewOpenSource extends Enum<OfficeUrlPreviewOpenSource> {
    public static final OfficeUrlPreviewOpenSource COVER = null;
    public static final OfficeUrlPreviewOpenSource EXPAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewOpenSource[] f361766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f361767b = null;

    public static EnumEntries<OfficeUrlPreviewOpenSource> getEntries() {
        return f361767b;
    }

    static {
        OfficeUrlPreviewOpenSource r100 = new OfficeUrlPreviewOpenSource("COVER", 0);
        COVER = r100;
        OfficeUrlPreviewOpenSource r101 = new OfficeUrlPreviewOpenSource("EXPAND", 1);
        EXPAND = r101;
        OfficeUrlPreviewOpenSource[] r102 = {r100, r101};
        f361766a = r102;
        f361767b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeUrlPreviewOpenSource[] values() {
        return (OfficeUrlPreviewOpenSource[]) f361766a.clone();
    }

    public static OfficeUrlPreviewOpenSource valueOf(String r100) {
        return (OfficeUrlPreviewOpenSource) r27.a.a(OfficeUrlPreviewOpenSource.class, r100);
    }

    public OfficeUrlPreviewOpenSource(String r100, int r101) {
        super(r100, r101);
    }
}

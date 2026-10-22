package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewSourceKind;", "", "<init>", "(Ljava/lang/String;I)V", "OFFICE", "HTML", "MARKDOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewSourceKind extends Enum<OfficeUrlPreviewSourceKind> {
    public static final OfficeUrlPreviewSourceKind HTML = null;
    public static final OfficeUrlPreviewSourceKind MARKDOWN = null;
    public static final OfficeUrlPreviewSourceKind OFFICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewSourceKind[] f361817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f361818b = null;

    public static EnumEntries<OfficeUrlPreviewSourceKind> getEntries() {
        return f361818b;
    }

    static {
        OfficeUrlPreviewSourceKind r100 = new OfficeUrlPreviewSourceKind("OFFICE", 0);
        OFFICE = r100;
        OfficeUrlPreviewSourceKind r101 = new OfficeUrlPreviewSourceKind("HTML", 1);
        HTML = r101;
        OfficeUrlPreviewSourceKind r102 = new OfficeUrlPreviewSourceKind("MARKDOWN", 2);
        MARKDOWN = r102;
        OfficeUrlPreviewSourceKind[] r103 = {r100, r101, r102};
        f361817a = r103;
        f361818b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeUrlPreviewSourceKind[] values() {
        return (OfficeUrlPreviewSourceKind[]) f361817a.clone();
    }

    public static OfficeUrlPreviewSourceKind valueOf(String r100) {
        return (OfficeUrlPreviewSourceKind) r27.a.a(OfficeUrlPreviewSourceKind.class, r100);
    }

    public OfficeUrlPreviewSourceKind(String r100, int r101) {
        super(r100, r101);
    }
}

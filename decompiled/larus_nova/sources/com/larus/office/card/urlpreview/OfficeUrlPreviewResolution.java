package com.larus.office.card.urlpreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewResolution;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "READY", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUrlPreviewResolution extends Enum<OfficeUrlPreviewResolution> {
    public static final OfficeUrlPreviewResolution FAILED = null;
    public static final OfficeUrlPreviewResolution LOADING = null;
    public static final OfficeUrlPreviewResolution READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUrlPreviewResolution[] f361815a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f361816b = null;

    public static EnumEntries<OfficeUrlPreviewResolution> getEntries() {
        return f361816b;
    }

    static {
        OfficeUrlPreviewResolution r100 = new OfficeUrlPreviewResolution("LOADING", 0);
        LOADING = r100;
        OfficeUrlPreviewResolution r101 = new OfficeUrlPreviewResolution("READY", 1);
        READY = r101;
        OfficeUrlPreviewResolution r102 = new OfficeUrlPreviewResolution("FAILED", 2);
        FAILED = r102;
        OfficeUrlPreviewResolution[] r103 = {r100, r101, r102};
        f361815a = r103;
        f361816b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeUrlPreviewResolution[] values() {
        return (OfficeUrlPreviewResolution[]) f361815a.clone();
    }

    public static OfficeUrlPreviewResolution valueOf(String r100) {
        return (OfficeUrlPreviewResolution) r27.a.a(OfficeUrlPreviewResolution.class, r100);
    }

    public OfficeUrlPreviewResolution(String r100, int r101) {
        super(r100, r101);
    }
}
